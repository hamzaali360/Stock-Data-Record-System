package com.example.demo.morningpanic.entities;


import com.example.demo.webscraper.models.HistoricalData;

import javax.persistence.*;

@Entity
@Table(name="historical_data")
public class HistoricalDataEntity extends HistoricalData {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "historical_data_generator")
    @SequenceGenerator(name="historical_data_generator", sequenceName = "hd_seq", allocationSize = 1)
    public int historicalDateId;

    public int dataId;

    public HistoricalDataEntity(){ super(); }

    public HistoricalDataEntity(HistoricalData historical_data, int dataId){
        super(historical_data);
        this.dataId = dataId;
    }

}
