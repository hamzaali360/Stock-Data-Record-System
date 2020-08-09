package com.example.demo.webscraper.util;

import java.time.ZonedDateTime;

import static com.example.demo.webscraper.model.Historical_Data.default_time;
import static com.example.demo.webscraper.model.Historical_Data.dtf;

public class Validate {
    public static boolean validateJavaDate(String strDate) {
        // Create Date object parse the string into time_stamp
        try {
            ZonedDateTime zdt = ZonedDateTime.parse(strDate+" "+default_time, dtf);
        }
        // Date format is invalid
        catch (Exception e) {
            e.printStackTrace();
            return false; }
        // Return true if time_stamp format is valid
        return true;
    }

    public static boolean validateSymbol(String symbol){
        char[] charArr = symbol.toCharArray();
        if(charArr.length > 5){ return false; }
        for(char c : charArr){ if(!Character.isLetter(c)){ return false; }}

        return true;
    }

}
