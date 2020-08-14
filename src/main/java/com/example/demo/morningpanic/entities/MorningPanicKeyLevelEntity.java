package com.example.demo.morningpanic.entities;

import javax.persistence.*;

@Entity
@Table(name="morning_panic_key_level")
public class MorningPanicKeyLevelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "morning_panic_key_level_generator")
    @SequenceGenerator(name="morning_panic_key_level_generator", sequenceName = "mp_kl_seq", allocationSize = 1)
    public int keyLevelId;

    public int dataId;

    double price;
    String type;

    public MorningPanicKeyLevelEntity(double price, String type){
        this.price = price;
        this.type = type;
    }

    public String toString(){
        return "price: "+price+"\n"+
                "type: "+type+"\n";
    }
}
