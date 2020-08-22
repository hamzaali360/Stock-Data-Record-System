package com.example.demo.morningpanic.entities;

import com.example.demo.common.models.Point;

import javax.persistence.*;

import static com.example.demo.common.models.Common_Values.null_time;
import static com.example.demo.common.util.Analyis.calc_percent_change;
import static com.example.demo.common.util.Analyis.calc_time_elapsed;

@Entity
@Table(name="premarket")
public class PremarketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "premarket_generator")
    @SequenceGenerator(name="premarket_generator", sequenceName = "p_seq", allocationSize = 1)
    public int premarketId;

    public int dataId;

    @AttributeOverrides({
            @AttributeOverride( name = "price", column = @Column(name = "premarket_high_price")),
            @AttributeOverride( name = "time", column = @Column(name = "premarket_high_time")),
            @AttributeOverride( name = "significance", column = @Column(name = "premarket_high_significance"))

    })
    public Point high;

    @AttributeOverrides({
            @AttributeOverride( name = "price", column = @Column(name = "premarket_low_after_high_price")),
            @AttributeOverride( name = "time", column = @Column(name = "premarket_low_after_high_time")),
            @AttributeOverride( name = "significance", column = @Column(name = "premarket_low_after_high_significance"))
    })
    public Point low_after_high;

    @Column(columnDefinition = "double default 0", name = "premarket_pullback_percent")
    public double pullback_percent; // calculated
    @Column(columnDefinition = "varchar(5) default '00:00'", name = "premarket_pullback_time_length")
    public String pullback_time_length; // calculated

    public PremarketEntity(){
        high = new Point();
        low_after_high = new Point();
        pullback_percent = 0.0;
        pullback_time_length = null_time;
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
