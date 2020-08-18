package com.example.demo.common.models;

import javax.persistence.*;

import static com.example.demo.common.util.Analyis.calc_percent_change;
import static com.example.demo.common.util.Analyis.calc_time_elapsed;

@Embeddable
public class Premarket {

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "price", column = @Column(name = "premarket_high_price")),
            @AttributeOverride( name = "time", column = @Column(name = "premarket_high_time"))
    })
    public Point high;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "price", column = @Column(name = "premarket_low_after_high_price")),
            @AttributeOverride( name = "time", column = @Column(name = "premarket_low_after_high_time"))
    })
    public Point low_after_high;

    @Column(columnDefinition = "double default 0", name = "premarket_pullback_percent")
    public double pullback_percent; // calculated
    @Column(columnDefinition = "varchar(5) default '00:00'", name = "premarket_pullback_time_length")
    public String pullback_time_length; // calculated

    public Premarket(){
        high = new Point();
        low_after_high = new Point();
        pullback_percent = 0.0;
        pullback_time_length = "00:00";
    }

    public void calculateMetrics(){
        pullback_percent = calc_percent_change(high.price, low_after_high.price);
        pullback_time_length = calc_time_elapsed(high.time, low_after_high.time);
    }

    public String toString(){
        return  "- high -"+"\n"+
                high.toString()+
                "- low_after_high -"+"\n"+
                low_after_high.toString()+
                "pullback_percent: "+pullback_percent+"\n"+
                "pullback_time_length: "+pullback_time_length+"\n";
    }

}
