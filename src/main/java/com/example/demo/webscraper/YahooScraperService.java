package com.example.demo.webscraper;

import com.example.demo.webscraper.model.Historical_Data;
import com.example.demo.webscraper.model.Complete_Record;
import com.example.demo.webscraper.model.Data;
import com.example.demo.webscraper.util.Validate;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static com.example.demo.webscraper.processing.Yahoo_Data_Processor.*;

// This class uses Jsoup to scrape the HTML from Yahoo Finance pages. Uses the
// Yahoo_Data_Processor to create objects from the scraped data.

@Service
public class YahooScraperService {

    public YahooScraperService(){ }

    // Returns an object that contains statistics and historical data on a symbol starting at
    // a given time_stamp. The historical data size depends on the history_length parameter.
    // Assumes valid parameters.
    public Complete_Record scrape_symbol(String symbol, String date, int history_length){
        // Parameter validation (Moved to envelope validation)
        //if(!validate_parameters(symbol, date, history_length)){ System.out.println("Invalid scrape parameters."); return null; }

        symbol = symbol.toUpperCase();
        System.out.println("Scraping "+symbol+" data");
        System.out.println("Date: " + date);
        System.out.println();

        Complete_Record record = new Complete_Record(symbol);
        
        try { retrieve_statistics(symbol, record.data);
              retrieve_historical_data(symbol, date, history_length, record);
              record.calc_market_cap(); }
        catch (Exception e){ System.out.println("Error scraping "+symbol+" data."); return null; }

        return record;
    }

    // Parameter validation (Moved to envelope validation)
    public static boolean validate_parameters(String symbol, String date, int history_length){
         if(!Validate.validateJavaDate(date)){ System.out.println("Invalid time_stamp (yyyy-MM-dd)"); return false; }
         if(!Validate.validateSymbol(symbol)){ System.out.println("Invalid symbol"); return false; }
         if(history_length < 0 || history_length > 100){ System.out.println("Invalid number of days in history (0 - 100)"); return false; }
        return true;
    }

    // Retrieves list of historical data beginning at the time_stamp provided and reaches back history_length amount of
    // days, where the market has been open on these days.
    private void retrieve_historical_data(String symbol, String date, int history_length, Complete_Record record){
        String time = "17:00:00 CST";
        String time_stamp = date+" "+time;
        ZonedDateTime day  = ZonedDateTime.parse(time_stamp, Historical_Data.dtf);
        DayOfWeek dayOfWeek = day.getDayOfWeek();

        history_length += 1; // Added day to calculate open_percentage on final day in history. Is removed. 
        
        if(dayOfWeek.equals(DayOfWeek.SATURDAY) || dayOfWeek.equals(DayOfWeek.SUNDAY)){
            System.out.println("Select a time_stamp that is not a Saturday or Sunday.");
            return;
        }

        // Get end point (next day)
        ZonedDateTime next_day;
        if(dayOfWeek.equals(DayOfWeek.FRIDAY)){ next_day = day.plusDays(3); }
        else{ next_day = day.plusDays(1); }

        int i = 0;
        ZonedDateTime zdt = day;

        // Get start point (history_length is the amount of days where the market has been open.
        while(i < history_length){
            zdt = zdt.minusDays(1);
            DayOfWeek dayofweek = zdt.getDayOfWeek();
            if(!dayofweek.equals(DayOfWeek.SATURDAY) && !dayofweek.equals(DayOfWeek.SUNDAY)){ i += 1; }
        }

        String start = String.valueOf(zdt.toInstant().toEpochMilli()).substring(0, 10);
        String end = String.valueOf(next_day.toInstant().toEpochMilli()).substring(0, 10);
        List<Historical_Data> records = scrape_historical_pricing(start, end, symbol);
        cut_future_records(records, day);
        calc_open_percentage(records, history_length);
        remove_added_day(records, history_length);

        record.historical_data = records;
    }


    // Historical_Data is in descending order
    private void calc_open_percentage(List<Historical_Data> historical_data, int history_length){
        for(int i=0; i<history_length; i++){
            if(i != history_length -1){
                historical_data.get(i).calc_open_percent(historical_data.get(i+1).close);
            }
        }
    }

    private void remove_added_day(List<Historical_Data> historical_data, int historical_length){
        historical_data.remove(historical_length-1);
    }
    
    // Returns a list of historical records from a "start" time_stamp to an "end" time_stamp.
    // start   - start time_stamp of historical pricing search
    // end     - end time_stamp of historical pricing search
    // symbol  - stock symbol
    private List<Historical_Data> scrape_historical_pricing(String start, String end, String symbol)  {
        String url = "https://finance.yahoo.com/quote/"+symbol+"/history?period1="+start+"&period2="+end+"&interval=1d&filter=history&frequency=1d";
        //System.out.println(url);
        LinkedList<Historical_Data> records = new LinkedList();

        try {
            Document document = Jsoup.connect(url).get();
            Elements elements = document.select("div[class=Pb(10px) Ovx(a) W(100%)]");
            Elements table = elements.first().getElementsByAttributeValue("class", "W(100%) M(0)");
            Elements trows = table.first().getElementsByAttributeValue("class", "BdT Bdc($seperatorColor) Ta(end) Fz(s) Whs(nw)");


            for (Element row : trows) {
                List<String> values = row.children().eachText();
                if(values.size() == 7){ records.add(new Historical_Data(values));}
                else{ System.out.println("Error creating historical data record"); }
            }
        }
        catch (Exception e){ System.out.println("Error retrieving historical pricing"); }

        return records;
    }

    // Wrapper method to retrieve quote header and statistics data.
    private void retrieve_statistics(String symbol, Data data) throws IOException {
        Document document = null;
        document = Jsoup.connect("https://finance.yahoo.com/quote/" + symbol + "/key-statistics?p=" + symbol).get();

        scrape_quote_header(document, data);
        scrape_statistics_page(document, data);
    }

    // Extracts the desired information from the quote header
    private void scrape_quote_header(Document document, Data data){
        //Scrapes for market_index
        Elements quote_header_bar = document.select("div[class=D(ib) Mt(-5px) Mend(20px) Maw(56%)--tab768 Maw(52%) Ov(h) smartphone_Maw(85%) smartphone_Mend(0px)]");
        Elements company_name_elem = quote_header_bar.get(0).getElementsByAttributeValue("class", "D(ib) ");
        Elements index_elem = quote_header_bar.get(0).getElementsByAttributeValue("class", "C($tertiaryColor) Fz(12px)");

        // Extracting company name
        String name_and_symbol = company_name_elem.first().text();
        String name = "";
        for(int i=0; i<name_and_symbol.length() ; i++){ if(name_and_symbol.charAt(i) == '(' ){ name = name_and_symbol.substring(0, i); break; } }
        interpret("Company Name", name, data);

        // Extracting market_index
        String index_full = index_elem.first().text();
        String index = "";
        for(int i=0; i<index_full.length() ; i++){ if(index_full.charAt(i) == '-' ){ index = index_full.substring(0, i); break; } }
        if(index.contains("NYSE")){ index = "NYSE"; }
        else if(index.contains("Nasdaq")){ index = "NASDAQ"; }
        else if(index.contains("OTC")){ index = "OTC"; }
        interpret("Index", index, data);
    }

    // Extracts the desired information from the statistics page
    private void scrape_statistics_page(Document document, Data data) {
        ArrayList<String> desired_table_names = new ArrayList<>(List.of("Stock Price History", "Share Statistics"));

        // Scrapes each table on statistics page
        Elements statistics_tables = document.select("div[class=Pos(r) Mt(10px)]");
        for (Element tables : statistics_tables) {
            String table_name = tables.getElementsByAttributeValue("class", "Mt(20px)").text();
            if (desired_table_names.contains(table_name)) {
                Elements table = tables.getElementsByAttributeValue("class", "W(100%) Bdcl(c)");
                table.select("tbody").unwrap();

                for (Element t : table) {
                    Elements trow = t.children();
                    //System.out.println(trow);
                    for (Element tr : trow) {
                        Elements tdata = tr.children();
                        if (tdata.size() == 2) {
                            String value = tdata.get(1).text();
                            String name = tdata.get(0).text();
                            parse_and_interpret_statistics(name, value, data);
                        }
                    }
                }
            }
        }
    }
}
