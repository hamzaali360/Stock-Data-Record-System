package com.example.demo.util;

import java.util.regex.Pattern;
import com.example.demo.controllers.messages.MorningPanicEnvelope;
import static com.example.demo.webscraper.util.Validate.validateJavaDate;
import static com.example.demo.webscraper.util.Validate.validateSymbol;

public class Validate {

    public static boolean isTime(String str) {
        return Pattern.matches("[0-9][0-9]:[0-9][0-9]", str) || Pattern.matches("[0-9]:[0-9][0-9]", str);
    }

    public static boolean validate_MorningPanicEnvelope(MorningPanicEnvelope envelope){
        //System.out.println(envelope.toString());
        if(!validateJavaDate(envelope.date)){ System.out.println("Invalid time_stamp (yyyy-MM-dd)"); return false; }
        if(!validateSymbol(envelope.symbol)){ System.out.println("Invalid symbol"); return false; }
        if(envelope.history_length < 0 || envelope.history_length > 100){ System.out.println("Invalid number of days in history (0 - 100)"); return false; }
        if(envelope.drop_point < 0){ System.out.println("Invalid drop_point ( d_p > 0 )"); return false; }
        if(!isTime(envelope.drop_time)){ System.out.println("Invalid drop_time (HH:mm)"); return false; }
        if(envelope.bottom_tick < 0){ System.out.println("Invalid bottom_tick ( b_t > 0 )"); return false; }
        if(!isTime(envelope.bottom_time)){ System.out.println("Invalid bottom_time (HH:mm)"); return false; }
        if(envelope.top_tick < 0){ System.out.println("Invalid top_tick ( t_t > 0 )"); return false; }
        if(!isTime(envelope.top_time)){ System.out.println("Invalid top_time (HH:mm)"); return false; }
        if(envelope.premarket_high < 0){ System.out.println("Invalid premarket_high ( p_h > 0 )"); return false; }
        if(!isTime(envelope.premarket_high_time)){ System.out.println("Invalid premarket_high_time (HH:mm)"); return false; }
        if(envelope.premarket_low_after_high < 0){ System.out.println("Invalid premarket_low_after_high ( p_l_a_h > 0 )"); return false; }
        if(!isTime(envelope.premarket_low_after_high_time)){ System.out.println("Invalid premarket_low_after_high_time (HH:mm)"); return false; }

        return true;
    }

}
