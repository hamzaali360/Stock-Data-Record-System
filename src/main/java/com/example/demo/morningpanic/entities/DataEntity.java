package com.example.demo.morningpanic.entities;


import com.example.demo.morningpanic.models.Envelope;
import com.example.demo.webscraper.models.Data;

import javax.persistence.*;

import static com.example.demo.common.util.Analyis.calc_percent_change;
import static com.example.demo.common.util.Analyis.calc_time_elapsed;

@Entity
@Table(name="data")
public class DataEntity extends Data{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "data_generator")
    @SequenceGenerator(name="data_generator", sequenceName = "d_seq", allocationSize = 1)
    public int dataId;
    public double drop_point;
    public String drop_time;
    public double bottom_tick;
    public String bottom_time;
    public double top_tick;
    public String top_time;
    public double panic_percent; // calculated
    public double bounce_percent; // calculated
    public String panic_time_length; // calculated
    public String bounce_time_length; // calculated
    public double premarket_high;
    public String premarket_high_time;
    public double premarket_low_after_high;
    public String premarket_low_after_high_time;
    public double premarket_pullback_percent; // calculated
    public String premarket_pullback_time_length; // calculated

    @Transient
    public String null_time = "00:00";

    public DataEntity(){
        super();
        dataId = 0;
        drop_point = 0;
        drop_time = null_time;
        bottom_tick = 0;
        bottom_time = null_time;
        top_tick = 0;
        top_time = null_time;
        panic_percent = 0;
        bounce_percent = 0;
        panic_time_length = null_time;
        bounce_time_length = null_time;
        premarket_high = 0;
        premarket_high_time = null_time;
        premarket_low_after_high = 0;
        premarket_low_after_high_time = null_time;
        premarket_pullback_percent = 0;
        premarket_pullback_time_length = null_time;
    }

    public DataEntity(Data data, Envelope envelope){
        super(data);

        // Manually entered by user
        sector = envelope.data.sector;

        dataId = 0;
        drop_point = envelope.data.drop_point;
        drop_time = envelope.data.drop_time;
        bottom_tick = envelope.data.bottom_tick;
        bottom_time = envelope.data.bottom_time;
        top_tick = envelope.data.top_tick;
        top_time = envelope.data.top_time;
        panic_percent = calc_percent_change(drop_point, bottom_tick);
        bounce_percent = calc_percent_change(bottom_tick, top_tick);
        panic_time_length = calc_time_elapsed(drop_time, bottom_time);
        bounce_time_length = calc_time_elapsed(bottom_time, top_time);
        premarket_high = envelope.data.premarket_high;
        premarket_high_time = envelope.data.premarket_high_time;
        premarket_low_after_high = envelope.data.premarket_low_after_high;
        premarket_low_after_high_time = envelope.data.premarket_low_after_high_time;
        premarket_pullback_percent = calc_percent_change(premarket_high, premarket_low_after_high);
        premarket_pullback_time_length = calc_time_elapsed(premarket_high_time, premarket_low_after_high_time);
    }

    @Override
    public String toString() {
        String str = "ID: "+ dataId +"\n"+
                super.toString()+"\n"+
                "--- PATTERN DATA ---"+"\n"+
                "drop_point: "+drop_point+"\n"+
                "drop_time: "+drop_time+"\n" +
                "bottom_tick: "+bottom_tick+"\n"+
                "bottom_time: "+bottom_time+"\n"+
                "top_tick: "+top_tick+"\n"+
                "top_time: "+top_time+"\n"+
                "panic_percent: "+panic_percent+"\n"+
                "bounce_percent: "+bounce_percent+"\n"+
                "panic_time_length: "+panic_time_length+"\n"+
                "bounce_time_length: "+bounce_time_length+"\n"+
                "premarket_high: "+premarket_high+"\n"+
                "premarket_high_time: "+premarket_high_time+"\n"+
                "premarket_low_after_high: "+premarket_low_after_high+"\n"+
                "premarket_low_after_high_time: "+premarket_low_after_high_time+"\n"+
                "premarket_pullback_percent: "+premarket_pullback_percent+"\n"+
                "premarket_pullback_time_length: "+premarket_pullback_time_length+"\n";
        return str;
    }

}
