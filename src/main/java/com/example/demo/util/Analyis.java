package com.example.demo.util;

import java.time.Duration;
import java.time.LocalTime;

import static com.example.demo.util.Validate.isTime;

public class Analyis {
    public static String calc_time_elapsed(String start_str, String end_str){
        if(!isTime(start_str) || !isTime(end_str)){
            System.out.println("Invalid paramaters");
            return "00:00";
        }

        int default_seconds = 0;

        LocalTime start = LocalTime.of(extract_hour(start_str), extract_minute(start_str), default_seconds);
        LocalTime end = LocalTime.of(extract_hour(end_str), extract_minute(end_str), default_seconds);

        Duration duration = Duration.between(start, end);

        String hours = String.valueOf(duration.toHoursPart());
        String minutes = String.valueOf(duration.toMinutesPart());
        if(minutes.equals("0")){ minutes += "0"; }

        String time_elapsed = hours+":"+minutes;

        return time_elapsed;
    }

    public static int extract_hour(String time){
        if(!isTime(time)){ return -1; }

        char[] chars = time.toCharArray();
        int i=0;
        for(; i<2 && chars[i] != ':'; i++){ }
        String hour = time.substring(0, i);

        return Integer.parseInt(hour);
    }


    public static int extract_minute(String time){
        if(!isTime(time)){ return -1; }

        char[] chars = time.toCharArray();
        int i=0;
        for(; i<2 && chars[i] != ':'; i++){ }
        String minute = time.substring(i+1, i+3);

        return Integer.parseInt(minute);
    }

}
