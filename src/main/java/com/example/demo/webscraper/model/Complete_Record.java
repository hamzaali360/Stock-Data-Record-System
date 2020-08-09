package com.example.demo.webscraper.model;

import java.util.LinkedList;
import java.util.List;

public class Complete_Record {
    public Data data;
    public List<Historical_Data> historical_data; // records are in descending order

    public Complete_Record(String symbol){
        data = new Data(symbol);
        historical_data = new LinkedList<>();
    }
    public void calc_market_cap(){ data.market_cap = (long)(historical_data.get(0).open * data.shares_outstanding); }

    public String toString_formatted() {
        String str = data.toString_formatted();

        str += "\n" + "--- HISTORIC DATA ---" + "\n";

        for (Historical_Data d : historical_data) { str += (d.toString_formatted() + "\n"); }

        str += "--------------------\n";

        return str;
    }
}
