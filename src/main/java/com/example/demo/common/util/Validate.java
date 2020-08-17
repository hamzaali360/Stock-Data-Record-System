package com.example.demo.common.util;

import java.util.regex.Pattern;

import com.example.demo.morningpanic.entities.KeyLevelEntity;
import com.example.demo.morningpanic.entities.TechnicalIndicatorBehaviorEntity;
import com.example.demo.morningpanic.models.Envelope;
import com.example.demo.common.models.ResponseObject;

import static com.example.demo.webscraper.util.Validate.validateJavaDate;
import static com.example.demo.webscraper.util.Validate.validateSymbol;

public class Validate {

    public static boolean isTime(String str) {
        return Pattern.matches("[0-9][0-9]:[0-9][0-9]", str) || Pattern.matches("[0-9]:[0-9][0-9]", str);
    }

    public static ResponseObject validate_MorningPanicEnvelope(Envelope envelope){
        //System.out.println(envelope.data.toString());
        boolean valid = true;
        String response = "";

        if(!validateSymbol(envelope.data.symbol)){ response = "Invalid symbol"; valid = false; }
        if(envelope.history_length < 0 || envelope.history_length > 100){ response = "Invalid history_length (0 - 100)"; valid = false; }
        if(!validateJavaDate(envelope.date)){ response = "Invalid date (yyyy-MM-dd)"; valid = false; }
        // DATA
        if(envelope.data.drop_point < 0){ response = "Invalid drop_point ( d_p > 0 )"; valid = false; }
        if(!isTime(envelope.data.drop_time)){ response = "Invalid drop_time (HH:mm)"; valid = false; }
        if(envelope.data.bottom_tick < 0){ response = "Invalid bottom_tick ( b_t > 0 )"; valid = false; }
        if(!isTime(envelope.data.bottom_time)){ response = "Invalid bottom_time (HH:mm)"; valid = false; }
        if(envelope.data.top_tick < 0){ response = "Invalid top_tick ( t_t > 0 )"; valid = false; }
        if(!isTime(envelope.data.top_time)){ response = "Invalid top_time (HH:mm)"; valid = false; }
        if(envelope.data.premarket_high < 0){ response = "Invalid premarket_high ( p_h > 0 )"; valid = false; }
        if(!isTime(envelope.data.premarket_high_time)){ response = "Invalid premarket_high_time (HH:mm)"; valid = false; }
        if(envelope.data.premarket_low_after_high < 0){ response = "Invalid premarket_low_after_high ( p_l_a_h > 0 )"; valid = false; }
        if(!isTime(envelope.data.premarket_low_after_high_time)){ response = "Invalid premarket_low_after_high_time (HH:mm)"; valid = false; }
        // KEY LEVELS
        for(KeyLevelEntity keyLevel : envelope.key_levels){
            if(!KeyLevelEntity.validate_type(keyLevel.type)){ response = "Invalid key_level type"; valid = false; }
        }
        // TECHNICAL INDICATOR BEHAVIOR
        for(TechnicalIndicatorBehaviorEntity technicalIndicator : envelope.technical_indicator_behaviors){
            if(!TechnicalIndicatorBehaviorEntity.validate_type(technicalIndicator.type)){ response = "Invalid technical_indicator_behavior type"; valid = false; }
            if(!isTime(technicalIndicator.time)){ response = "Invalid technical_indicator_behavior time"; valid = false; }
        }


        return new ResponseObject(valid, response);
    }

}
