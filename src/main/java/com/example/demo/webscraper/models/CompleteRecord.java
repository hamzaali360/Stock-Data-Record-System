package com.example.demo.webscraper.models;

import java.util.LinkedList;
import java.util.List;

public class CompleteRecord {
    public Data data;
    public List<HistoricalData> historical_data; // records are in descending order

    public CompleteRecord(String symbol){
        data = new Data(symbol);
        historical_data = new LinkedList<>();
    }
    public void calc_market_cap(){ data.market_cap = (long)(historical_data.get(0).open * data.shares_outstanding); }

    public String toString_formatted() {
        String str = data.toString_formatted();

        str += "\n" + "--- HISTORIC DATA ---" + "\n";

        for (HistoricalData d : historical_data) { str += (d.toString_formatted() + "\n"); }

        str += "--------------------\n";

        return str;
    }
}
