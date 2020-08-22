package com.example.demo.morningpanic.models;

import com.example.demo.morningpanic.entities.*;

import java.util.ArrayList;
import java.util.List;


public class Envelope {
    public DataEntity data;
    public PremarketEntity premarket;
    public MainPanicBounceEntity main_panic_bounce;
    public List<FailedMorningSpikeEntity> failed_morning_spikes;
    public List<FailedBounceEntity> failed_bounces;
    public List<PullbackBounceEntity> pullback_bounces;
    public List<KeyLevelEntity> key_levels;
    public List<TechnicalIndicatorBehaviorEntity> technical_indicator_behaviors;
    public List<CatalystEntity> catalysts;


    public Envelope(){
        data = new DataEntity();
        premarket = new PremarketEntity();
        main_panic_bounce = new MainPanicBounceEntity();
        failed_morning_spikes = new ArrayList<>();
        failed_bounces = new ArrayList<>();
        pullback_bounces = new ArrayList<>();
        key_levels = new ArrayList<>();
        technical_indicator_behaviors = new ArrayList<>();
        catalysts = new ArrayList<>();
    }

    @Override
    public String toString() {
        String str = "--- DATA ---"+"\n"+
                    data.toString()+
                "\n" + "--- PREMARKET ---"+"\n"+
                premarket.toString()+
                "\n" + "--- MAIN PANIC BOUNCE ---"+"\n"+
                main_panic_bounce.toString();
        str+= "\n"+"--- FAILED MORNING SPIKES ---"+"\n";
        for(int i=0; i<failed_morning_spikes.size(); i++){ str += failed_morning_spikes.get(i).toString(); }
        str += "\n"+"--- FAILED BOUNCES ---"+"\n";
        for(int i=0; i<failed_bounces.size(); i++){ str += failed_bounces.get(i).toString(); }
        str += "\n"+"--- PULLBACK BOUNCES ---"+"\n";
        for(int i=0; i<pullback_bounces.size(); i++){ str += pullback_bounces.get(i).toString(); }
        str += "\n"+"--- KEY LEVELS ---"+"\n";
        for(int i=0; i<key_levels.size(); i++){ str += key_levels.get(i).toString(); }
        str += "\n"+"--- TECHNICAL INDICATOR BEHAVIORS ---"+"\n";
        for(int i=0; i<technical_indicator_behaviors.size(); i++){ str += technical_indicator_behaviors.get(i).toString(); }
        str += "\n"+"--- CATALYSTS ---"+"\n";
        for(int i=0; i<catalysts.size(); i++){ str += catalysts.get(i).toString(); }

        return str;
    }
}
