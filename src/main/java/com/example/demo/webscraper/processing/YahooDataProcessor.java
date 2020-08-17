package com.example.demo.webscraper.processing;

import com.example.demo.webscraper.models.HistoricalData;
import com.example.demo.webscraper.models.Data;
import com.example.demo.webscraper.util.Transformer;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

// This class processes scraped time_stamp from Yahoo Finance. It then stores the scraped data
// into an object to be used.

public class YahooDataProcessor {
    // Ensures all records have the correct number of historic records. Future days appear when the day
    // following the day provided has already occurred. For example, a record of todays time_stamp will not
    // produce a future historic record. A record from two days ago will produce a future historic record as
    // the day one day ago has already happened.
    public static void cut_future_records(List<HistoricalData> records, ZonedDateTime day){
        for(int i=0; i<records.size(); i++){
            HistoricalData record = records.get(i);
            if( record.time_stamp.isAfter(day) ){ records.remove(i); }
        }
    }

    // Ensures only the data that is desired is being processed.
    public static void parse_and_interpret_statistics(String type, String value, Data yahooData) {
        ArrayList<String> desired_data_types = new ArrayList<>(List.of("Shares Outstanding", "Float"));

        int num_desired = desired_data_types.size();
        boolean found = false;

        for (int i = 0; i < num_desired && !found; i++) {
            String desired_data_name = desired_data_types.get(i);

            // Checking to see if passed in type is something that is wanted.
            if(type.contains(desired_data_name)){
                if (type.contains("Float") && type.contains("Short % of")) { continue; }
                if (type.contains("Shares Outstanding")){
                    if(type.contains("Short % of")) { continue; }
                    else{ type = "Shares Outstanding"; }
                }
                found = true;
                interpret(type, value, yahooData);
            }
        }
    }

    // Used as a way to interpret or classify data that has been scraped from Yahoo
    public static void interpret(String type, String value, Data yahooData) {
        //System.out.println("type: " + type + "\tvalue: " + value);

        // Changing N/A to default value of 0.
        if (value.equals("N/A")) { value = "0"; }

        //double_data(type, value, yahooData); // not finished
        long_data(type, value, yahooData);
        string_data(type, value, yahooData);
    }

    // Interprets and sets double data values. Not in use as Data does need.
    private static void double_data(String type, String value, Data yahooData) {
            ArrayList<String> double_data_names = new ArrayList<>(
                    List.of());

            if(double_data_names.contains(type)){
                try { double val = Double.parseDouble(value);
                       yahooData.set(type, val);
                } catch (Exception e) { e.printStackTrace(); }
            }
    }

    // Interprets and sets long data values.
    private static void long_data(String type, String value, Data yahooData) {
        ArrayList<String> long_data_names = new ArrayList<>(
                List.of("Volume", "Shares Outstanding", "Float"));

        if(long_data_names.contains(type)){

            if(type.equals("Shares Outstanding") || type.equals("Float")){
                long val = Transformer.transform_to_number(value);
                yahooData.set(type, val);
            } else {
                try { long val = Long.parseLong(value);
                    yahooData.set(type, val);
                } catch (Exception e) { e.printStackTrace(); }
            }
        }
    }

    // Interprets and sets String data values.
    private static void string_data(String type, String value, Data yahooData) {
        ArrayList<String> string_data_names = new ArrayList<>(
                List.of("Symbol", "Index", "Company Name"));

        if(string_data_names.contains(type)){ yahooData.set(type, value); }
    }
}
