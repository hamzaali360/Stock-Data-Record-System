package com.example.demo.morningpanic;


import com.example.demo.webscraper.model.Data;

import javax.persistence.*;

@Entity
@Table(name="morning_panic_data")
public class MorningPanicDataEntity extends Data{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "morning_panic_data_generator")
    @SequenceGenerator(name="morning_panic_data_generator", sequenceName = "mp_d_seq", allocationSize = 1)
    public int dataId;

    public MorningPanicDataEntity(){ super(); }


    public MorningPanicDataEntity(Data data){
        super(data);
        dataId = 0;
    }

    @Override
    public String toString() {
        String str = "ID: "+ dataId +"\n"+
                super.toString();
        return str;
    }

}
