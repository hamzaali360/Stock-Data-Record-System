package com.example.demo.webscraper.model;

import com.example.demo.webscraper.util.Transformer;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Data {


    @Column(columnDefinition = "varchar(6) default 'sym'")
    public String symbol;
    @Column(columnDefinition = "varchar(255) default 'name'")
    public String company_name;
    @Column(columnDefinition = "varchar(20) default 'index'")
    public String market_index;
    @Column(columnDefinition = "bigint default 0")
    public long market_cap;
    @Column(columnDefinition = "bigint default 0")
    public long shares_outstanding;
    @Column(columnDefinition = "bigint default 0")
    public long shares_float;

    public Data(){
        symbol = "sym";
        company_name = "name";
        market_index = "market_index";
        market_cap = 0;
        shares_outstanding = 0;
        shares_float = 0;
    }

    public Data(String sym){
        symbol = sym;
        company_name = "name";
        market_index = "market_index";
        market_cap = 0;
        shares_outstanding = 0;
        shares_float = 0;
    }

    // Copy constructor
    public Data(Data data){
        this.symbol = data.symbol;
        this.company_name = data.company_name;
        this.market_index = data.market_index;
        this.market_cap = data.market_cap;
        this.shares_outstanding = data.shares_outstanding;
        this.shares_float = data.shares_float;
    }



    public String toString() {
        String str = "--- STATISTICS ---" + "\n" +
                "symbol: " + symbol + "\n" +
                "company name: " + company_name + "\n"+
                "market_index: " + market_index + "\n" +
                "market_cap: " + market_cap + "\n" +
                "shares_outstanding: " + shares_outstanding + "\n" +
                "float: " + shares_float + "\n";

        return str;
    }

    public String toString_formatted(){
        String str = "--- STATISTICS ---"+"\n"+
                 "symbol: "+symbol+"\n"+
                 "company name: " + company_name + "\n"+
                 "market_index: "+ market_index +"\n"+
                 "market_cap: $"+ Transformer.transform_to_unit(market_cap)+"\n"+
                 "shares_outstanding: "+ Transformer.transform_to_unit(shares_outstanding)+"\n"+
                 "float: "+ Transformer.transform_to_unit(shares_float)+"\n";

        return str;
    }

    // Sets String type members
    public void set(String type, String value){
        type = type.toLowerCase();

        if(type.equals("symbol")){ symbol = value; }
        else if(type.equals("index")){ market_index = value; }
        else if(type.equals("company name")){ company_name = value; }
    }

    // Sets long type members
    public void set(String type, long value){
        type = type.toLowerCase();

        if(type.equals("market cap")){ market_cap = value; }
        else if(type.equals("shares outstanding")){ shares_outstanding = value; }
        else if(type.equals("float")){ shares_float = value;  }
    }

    // Sets double type members
    public void set(String type, double value){ type = type.toLowerCase();}

}