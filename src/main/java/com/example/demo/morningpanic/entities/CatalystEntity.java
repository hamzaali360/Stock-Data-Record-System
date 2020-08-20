package com.example.demo.morningpanic.entities;


import javax.persistence.*;

import static com.example.demo.common.models.Common_Values.null_time;

@Entity
@Table(name="catalyst_table")
public class CatalystEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "catalyst_generator")
    @SequenceGenerator(name="catalyst_generator", sequenceName = "c_seq", allocationSize = 1)
    public int catalystId;

    public int dataId;

    public String date;
    public String time;
    public String description;

    public CatalystEntity(){
        catalystId = 0;
        dataId = 0;

        date = "2001-01-01";
        time = null_time;
        description = "";
    }

    public String toString(){
        return "date: "+date+"\n"+
                "time: "+time+"\n"+
                "description: "+description+"\n";
    }

}
