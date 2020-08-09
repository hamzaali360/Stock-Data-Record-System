package com.example.demo.controllers;


import com.example.demo.controllers.messages.PrerecordEnvelope;
import com.example.demo.morningpanic.MorningPanicService;
import com.example.demo.webscraper.YahooScraperService;
import com.example.demo.webscraper.model.Complete_Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Records_Controller {

    @Autowired
    private YahooScraperService yahooScraperService;

    @Autowired
    MorningPanicService morningPanicService;

    @RequestMapping(method=RequestMethod.POST, value="/morning_panic")
    public void addRecord(@RequestBody PrerecordEnvelope envelope){
        System.out.println("Symbol: "+envelope.symbol);
        System.out.println("History length: "+envelope.history_length);

        String date = "2020-07-10";
        String symbol = "CYDY";

        Complete_Record record = yahooScraperService.scrape_symbol(symbol, date, 10);

        if(record != null) {
            //System.out.println(record.toString_formatted());
            morningPanicService.addRecord(record);
        }

    }


}
