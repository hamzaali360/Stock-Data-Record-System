package com.example.demo.util;

import java.util.regex.Pattern;
import com.example.demo.controllers.messages.MorningPanicEnvelope;
import com.example.demo.controllers.messages.ResponseObject;

import static com.example.demo.webscraper.util.Validate.validateJavaDate;
import static com.example.demo.webscraper.util.Validate.validateSymbol;

public class Validate {

    public static boolean isTime(String str) {
        return Pattern.matches("[0-9][0-9]:[0-9][0-9]", str) || Pattern.matches("[0-9]:[0-9][0-9]", str);
    }

    public static ResponseObject validate_MorningPanicEnvelope(MorningPanicEnvelope envelope){
        System.out.println(envelope.toString());
        boolean valid = true;
        String response = "";

        if(!validateSymbol(envelope.symbol)){ response = "Invalid symbol"; valid = false; }
        if(envelope.history_length < 0 || envelope.history_length > 100){ response = "Invalid history_length (0 - 100)"; valid = false; }
        if(!validateJavaDate(envelope.date)){ response = "Invalid date (yyyy-MM-dd)"; valid = false; }
        if(envelope.drop_point < 0){ response = "Invalid drop_point ( d_p > 0 )"; valid = false; }
        if(!isTime(envelope.drop_time)){ response = "Invalid drop_time (HH:mm)"; valid = false; }
        if(envelope.bottom_tick < 0){ response = "Invalid bottom_tick ( b_t > 0 )"; valid = false; }
        if(!isTime(envelope.bottom_time)){ response = "Invalid bottom_time (HH:mm)"; valid = false; }
        if(envelope.top_tick < 0){ response = "Invalid top_tick ( t_t > 0 )"; valid = false; }
        if(!isTime(envelope.top_time)){ response = "Invalid top_time (HH:mm)"; valid = false; }
        if(envelope.premarket_high < 0){ response = "Invalid premarket_high ( p_h > 0 )"; valid = false; }
        if(!isTime(envelope.premarket_high_time)){ response = "Invalid premarket_high_time (HH:mm)"; valid = false; }
        if(envelope.premarket_low_after_high < 0){ response = "Invalid premarket_low_after_high ( p_l_a_h > 0 )"; valid = false; }
        if(!isTime(envelope.premarket_low_after_high_time)){ response = "Invalid premarket_low_after_high_time (HH:mm)"; valid = false; }

        return new ResponseObject(valid, response);
    }

}
