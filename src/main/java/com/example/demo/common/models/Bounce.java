package com.example.demo.common.models;

import javax.persistence.*;

import static com.example.demo.common.util.Analyis.calc_percent_change;
import static com.example.demo.common.util.Analyis.calc_time_elapsed;


@MappedSuperclass
@Embeddable
public class Bounce {


    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "price", column = @Column(name = "drop_point_price")),
            @AttributeOverride( name = "time", column = @Column(name = "drop_point_time"))
    })
    public Point drop;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "price", column = @Column(name = "bottom_point_price")),
            @AttributeOverride( name = "time", column = @Column(name = "bottom_point_time"))
    })
    public Point bottom;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "price", column = @Column(name = "top_point_price")),
            @AttributeOverride( name = "time", column = @Column(name = "top_point_time"))
    })
    public Point top;
    Double drop_percent; // calculated
    Double bounce_percent; // calculated
    public String panic_time_length; // calculated
    public String bounce_time_length; // calculated

    @Transient
    public String null_time = "00:00";

    public Bounce(){
        drop = new Point();
        bottom = new Point();
        top = new Point();
        drop_percent = 0.0;
        bounce_percent = 0.0;
        panic_time_length = null_time;
        bounce_time_length = null_time;

    }

    public void calculateMetrics(){
        drop_percent = calc_percent_change(drop.price, bottom.price);
        bounce_percent = calc_percent_change(bottom.price, top.price);
        panic_time_length = calc_time_elapsed(drop.time, bottom.time);
        bounce_time_length = calc_time_elapsed(bottom.time, top.time);
    }

    public String toString(){
        return  "- drop -"+"\n"+
                drop.toString()+
                "- bottom -"+"\n"+
                bottom.toString()+
                "- top -"+"\n"+
                top.toString()+
                "drop_percent: "+drop_percent+"\n"+
                "bounce_percent: "+bounce_percent+"\n"+
                "panic_time_length: "+panic_time_length+"\n"+
                "bounce_time_length: "+bounce_time_length+"\n";
    }
}
