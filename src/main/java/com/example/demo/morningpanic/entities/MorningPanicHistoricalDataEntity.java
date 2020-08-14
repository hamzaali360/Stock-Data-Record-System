package com.example.demo.morningpanic.entities;


import com.example.demo.webscraper.model.Historical_Data;

import javax.persistence.*;

@Entity
@Table(name="morning_panic_historical_data")
public class MorningPanicHistoricalDataEntity extends Historical_Data {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "morning_panic_historical_data_generator")
    @SequenceGenerator(name="morning_panic_historical_data_generator", sequenceName = "mp_hd_seq", allocationSize = 1)
    public int historicalDateId;

    public int dataId;

    public MorningPanicHistoricalDataEntity(){ super(); }

    public MorningPanicHistoricalDataEntity(Historical_Data historical_data, int dataId){
        super(historical_data);
        this.dataId = dataId;
    }

}
