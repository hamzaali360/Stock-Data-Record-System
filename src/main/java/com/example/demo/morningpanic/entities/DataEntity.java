package com.example.demo.morningpanic.entities;


import com.example.demo.common.models.Bounce;
import com.example.demo.common.models.Point;
import com.example.demo.common.models.Premarket;
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

    public Premarket premarket;

    public Bounce panic_bounce;

    public DataEntity(){
        super();
        dataId = 0;
        premarket = new Premarket();
        panic_bounce = new Bounce();
    }

    public DataEntity(Data data, Envelope envelope){
        super(data);

        // Manually entered by user
        sector = envelope.data.sector;

        dataId = 0;

        premarket = envelope.data.premarket;
        premarket.calculateMetrics();

        panic_bounce = envelope.data.panic_bounce;
        panic_bounce.calculateMetrics();
    }

    @Override
    public String toString() {
        String str = "ID: "+ dataId +"\n"+
                super.toString()+"\n"+
                "--- PATTERN DATA ---"+"\n"+
                "panic_bounce"+"\n"+
                panic_bounce.toString()+"\n"+
                "premarket"+"\n"+
                premarket.toString()+"\n"
                ;

        return str;
    }

}
