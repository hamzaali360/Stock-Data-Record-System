package com.example.demo.morningpanic.entities;

import javax.persistence.*;


@Entity
@Table(name="morning_panic_technical_indicator_behavior")
public class MorningPanicTechnicalIndicatorBehaviorEntity {
    double price;
    String type;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "morning_panic_technical_indicator_behavior_generator")
    @SequenceGenerator(name="morning_panic_technical_indicator_behavior_generator", sequenceName = "mp_tib_seq", allocationSize = 1)
    public int indicatorId;

    public int dataId;

    public MorningPanicTechnicalIndicatorBehaviorEntity(double price, String type){
        this.price = price;
        this.type = type;
    }

    public String toString(){
        return "price: "+price+"\n"+
                "type: "+type+"\n";
    }

}
