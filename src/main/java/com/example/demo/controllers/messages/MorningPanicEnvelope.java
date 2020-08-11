package com.example.demo.controllers.messages;

import com.example.demo.morningpanic.MorningPanicDataEntity;

public class MorningPanicEnvelope extends MorningPanicDataEntity {
    public String symbol;
    public String date;
    public int history_length;

    public MorningPanicEnvelope(){
        super();
        symbol = "SYMB";
        date = "2020-01-01";
        history_length = 0;
    }

}
