package com.example.demo.webscraper.util;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Transformer {
    public static long transform_to_number(String value){
        int multiplier = 1;
        String num = value;
        String unit = value.substring(value.length() - 1); // K M or B
        multiplier = unit_multiplier(unit);

        if (unit.equals("k") || unit.equals("M") || unit.equals("B")) {
            num = value.substring(0, value.length() - 1); // removing unit from string
        }

        char[] charArr = num.toCharArray();
        for(char c : charArr){ if(!Character.isDigit(c) && c != '.' && c != '-'){ return -1; } }

        double temp = Double.parseDouble(num) * multiplier;
        return (long) temp;
    }

    public static String transform_to_unit(long value){
        String unit = "";
        double val = (double) value;

        long k = 1000;
        long M = 1000000;
        long B = 1000000000;

        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.DOWN);

        if(value/B >= 1){
            val = (double) value/B;
            unit = "B";
        } else if(value/M >= 1){
            val = (double) value/M;
            unit = "M";
        } else if(value/k >= 1){
            val = (double) value/k;
            unit = "k";
        }

        return df.format(val)+unit;
    }

    public static int unit_multiplier(String unit) {
        int multiplier = 1;

        if (unit.equals("B")) { multiplier = 1000000000; }
        else if (unit.equals("M")) { multiplier = 1000000; }
        else if (unit.equals("k")) { multiplier = 1000; }

        return multiplier;
    }
}
