package com.example.demo.morningpanic.models;

import com.example.demo.morningpanic.entities.DataEntity;
import com.example.demo.morningpanic.entities.KeyLevelEntity;
import com.example.demo.morningpanic.entities.TechnicalIndicatorBehaviorEntity;

import java.util.ArrayList;
import java.util.List;

public class Envelope {
    public String date;
    public int history_length;

    public DataEntity data;
    public List<KeyLevelEntity> key_levels;
    public List<TechnicalIndicatorBehaviorEntity> technical_indicator_behaviors;

    public Envelope(){
        date = "2020-01-01";
        history_length = 0;
        data = new DataEntity();
        key_levels = new ArrayList<>();
        technical_indicator_behaviors = new ArrayList<>();
    }

    @Override
    public String toString() {
        String str = data.toString();
        str += "\n"+"--- KEY LEVELS ---"+"\n";
        for(int i=0; i<key_levels.size(); i++){ str += key_levels.get(i).toString(); }
        str += "\n"+"--- TECHNICAL INDICATOR BEHAVIORS ---"+"\n";
        for(int i=0; i<technical_indicator_behaviors.size(); i++){ str += technical_indicator_behaviors.get(i).toString(); }

        return str;
    }
}
