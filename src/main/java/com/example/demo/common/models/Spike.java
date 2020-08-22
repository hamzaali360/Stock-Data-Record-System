package com.example.demo.common.models;

import javax.persistence.*;

import static com.example.demo.common.models.Common_Values.null_time;

@MappedSuperclass
public class Spike {
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "price", column = @Column(name = "start_point_price")),
            @AttributeOverride( name = "time", column = @Column(name = "start_point_time")),
            @AttributeOverride( name = "significance", column = @Column(name = "start_point_significance"))
    })
    public Point start;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "price", column = @Column(name = "top_point_price")),
            @AttributeOverride( name = "time", column = @Column(name = "top_point_time")),
            @AttributeOverride( name = "significance", column = @Column(name = "top_point_significance"))
    })
    public Point top;

    public String spike_time_length;
    public double spike_percent;

    public Spike(){
        start = new Point();
        top = new Point();
        spike_time_length = null_time;
        spike_percent = 0.0;
    }


}
