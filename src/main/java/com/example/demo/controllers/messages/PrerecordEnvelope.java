package com.example.demo.controllers.messages;

public class PrerecordEnvelope {
    public String symbol;
    public int history_length;

    public PrerecordEnvelope(String symbol, int history_length){
        this.symbol = symbol;
        this.history_length = history_length;
    }

}
