package com.example.demo.morningpanic.entities;

import com.example.demo.common.models.Point;
import com.example.demo.common.models.Spike;

import javax.persistence.*;

import static com.example.demo.common.models.Common_Values.null_time;
import static com.example.demo.common.util.Analyis.calc_percent_change;
import static com.example.demo.common.util.Analyis.calc_time_elapsed;

@Entity
@Table(name="failed_morning_spike")
public class FailedMorningSpikeEntity extends Spike {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "failed_morning_spike_generator")
    @SequenceGenerator(name="failed_morning_spike_generator", sequenceName = "fms_seq", allocationSize = 1)
    public int spikeId;

    public int dataId;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "price", column = @Column(name = "bottom_point_price")),
            @AttributeOverride( name = "time", column = @Column(name = "bottom_point_time"))
    })
    public Point bottom;
    public double drop_percent;
    public String drop_time_length;

    public FailedMorningSpikeEntity(){
        super();
        bottom = new Point();
        drop_percent = 0.0;
        drop_time_length = null_time;

    }

    public String toString(){
        return start.toString()+
                top.toString()+
                bottom.toString()+
                "spike_percent: "+spike_percent+"\n"+
                "spike_time_length: "+spike_time_length+"\n"+
                "drop_percent: "+drop_percent+"\n"+
                "drop_time_length: "+drop_time_length+"\n";
    }

    public void calculateMetrics(){
        spike_percent = calc_percent_change(start.price, top.price);
        drop_percent = calc_percent_change(top.price, bottom.price);
        spike_time_length = calc_time_elapsed(start.time, top.time);
        drop_time_length = calc_time_elapsed(top.time, bottom.time);
    }
}
