package com.example.demo.webscraper.models;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.example.demo.common.util.Analyis.calc_percent_change;
import static com.example.demo.webscraper.util.Transformer.round;
import static com.example.demo.webscraper.util.Transformer.transform_to_unit;

@MappedSuperclass
public class HistoricalData {
    @Column(columnDefinition = "timestamp default current_timestamp")
    public ZonedDateTime time_stamp;
    @Column(columnDefinition = "double default 0")
    public double open;
    @Column(columnDefinition = "double default 0")
    public double high;
    @Column(columnDefinition = "double default 0")
    public double low;
    @Column(columnDefinition = "double default 0")
    public double close;
    @Column(columnDefinition = "bigint default 0")
    public long volume;
    @Column(columnDefinition = "double default 0")
    public double open_percent_change;
    @Column(columnDefinition = "double default 0")
    public double close_percent_change;

    public static String default_time = "17:00:00 CST";
    public static String date_format = "yyyy-MM-dd";
    public static DateTimeFormatter dtf  = DateTimeFormatter.ofPattern(date_format+" HH:mm:ss zzz");
    public static DateTimeFormatter yahoo_dtf = DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm:ss zzz");


    // Webscraping constructor
    public HistoricalData(List<String> values){
        String record_time_stamp = values.get(0)+" "+default_time;
        time_stamp = ZonedDateTime.parse(record_time_stamp,yahoo_dtf);
        open = Double.parseDouble(values.get(1));
        high = Double.parseDouble(values.get(2));
        low = Double.parseDouble(values.get(3));
        close = Double.parseDouble(values.get(4));
        volume = Long.parseLong(values.get(6).replace(",", ""));
        this.open_percent_change = 0;
        this.close_percent_change = round(((close / open)-1)*100, 2);
    }


    // Copy Constructor
    public HistoricalData(HistoricalData historical_data){
        this.time_stamp = historical_data.time_stamp; // May need to create new object
        this.open = historical_data.open;
        this.high = historical_data.high;
        this.low  = historical_data.low;
        this.close = historical_data.close;
        this.volume = historical_data.volume;
        this.open_percent_change = historical_data.open_percent_change;
        this.close_percent_change = historical_data.close_percent_change;
    }


    public HistoricalData(){
        String record_time_stamp = "2020-01-01 "+ default_time;
        time_stamp = ZonedDateTime.parse(record_time_stamp,dtf);
        open = 0;
        high = 0;
        low = 0;
        close = 0;
        volume = 0;
        open_percent_change = 0;
        close_percent_change = 0;
    }


    public void calc_open_percent(double prev_close){ open_percent_change = calc_percent_change(prev_close, open); }


    public String toString(){
        return  "time_stamp: "+ time_stamp.toLocalDate()+"\n"+
                "open: "+open+"\n"+
                "high: "+high+"\n"+
                "low: "+low+"\n"+
                "close: "+close+"\n"+
                "volume: "+volume+"\n"+
                "open_percent_change: "+ open_percent_change +"\n"+
                "close_percent_change: "+ close_percent_change +"\n";
    }


    public String toString_formatted(){
        return  "time_stamp: "+ time_stamp.toLocalDate()+", "+ time_stamp.getDayOfWeek()+"\n"+
                "open: $"+open+"\n"+
                "high: $"+high+"\n"+
                "low: $"+low+"\n"+
                "close: $"+close+"\n"+
                "volume: "+transform_to_unit(volume)+"\n"+
                "open_percent_change: "+ open_percent_change +"\n"+
                "close_percent_change: "+ close_percent_change +"\n";
    }
}
