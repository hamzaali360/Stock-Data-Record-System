package com.example.demo.morningpanic.entities;

import com.example.demo.morningpanic.models.Envelope;
import com.example.demo.webscraper.models.Data;

import javax.persistence.*;

import static com.example.demo.common.models.Common_Values.null_date;

@Entity
@Table(name="data")
public class DataEntity extends Data{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "data_generator")
    @SequenceGenerator(name="data_generator", sequenceName = "d_seq", allocationSize = 1)
    public int dataId;

    @Transient
    public String date;
    @Transient
    public int history_length;


    public DataEntity(){
        super();
        dataId = 0;
        date = null_date;
        history_length = 0;
    }

    public DataEntity(Data data, Envelope envelope){
        super(data);

        // Manually entered by user
        sector = envelope.data.sector;

        dataId = 0;
    }

}
