package com.example.demo.controllers.messages;

import com.example.demo.morningpanic.entities.MorningPanicDataEntity;
import com.example.demo.morningpanic.entities.MorningPanicKeyLevelEntity;
import com.example.demo.morningpanic.entities.MorningPanicTechnicalIndicatorBehaviorEntity;

import java.util.ArrayList;
import java.util.List;

public class MorningPanicEnvelope {
    public String date;
    public int history_length;

    public MorningPanicDataEntity data;
    public List<MorningPanicKeyLevelEntity> key_levels;
    public List<MorningPanicTechnicalIndicatorBehaviorEntity> technical_indicator_behaviors;

    public MorningPanicEnvelope(){
        date = "2020-01-01";
        history_length = 0;
        data = new MorningPanicDataEntity();
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
