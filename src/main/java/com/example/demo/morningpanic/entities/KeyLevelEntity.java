package com.example.demo.morningpanic.entities;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;


@Entity
@Table(name="key_level")
public class KeyLevelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "key_level_generator")
    @SequenceGenerator(name="key_level_generator", sequenceName = "kl_seq", allocationSize = 1)
    public int keyLevelId;

    public int dataId;

    public double price;
    public String type;

    @Transient
    // immutable
    public static List<String> types = Arrays.asList("Resistance", "Multi-Day Resistance", "Multi-Week Resistance", "Multi-Month Resistance", "Multi-Year Resistance",
                                                     "Support",    "Multi-Day Support",    "Multi-Week Support",    "Multi-Month Support",    "Multi-Year Support",
                                                     "Breakout",   "Multi-Day Breakout",   "Multi-Week Breakout",   "Multi-Month Breakout",   "Multi-Year Breakout",
                                                     "High",       "Multi-Day High",       "Multi-Week High",       "Multi-Month High",       "Multi-Year High",
                                                     "Low",        "Multi-Day Low",        "Multi-Week Low",        "Multi-Month Low",        "Multi-Year Low");

    public KeyLevelEntity(double price, String time, String type){
        this.price = price;
        this.type = type;
    }

    public static boolean validate_type(String str){ return types.contains(str); }

    public String toString(){
        return "price: "+price+"\n"+
                "type: "+type+"\n";
    }
}
