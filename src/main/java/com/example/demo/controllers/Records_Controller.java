package com.example.demo.controllers;


import com.example.demo.controllers.messages.MorningPanicEnvelope;
import com.example.demo.morningpanic.MorningPanicService;
import com.example.demo.webscraper.YahooScraperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.example.demo.util.Validate.validate_MorningPanicEnvelope;

@RestController
public class Records_Controller {

    @Autowired
    private YahooScraperService yahooScraperService;

    @Autowired
    MorningPanicService morningPanicService;

    @RequestMapping(method=RequestMethod.POST, value="/morning_panic")
    public void addRecord(@RequestBody MorningPanicEnvelope envelope){
        if(!validate_MorningPanicEnvelope(envelope)){ System.out.println("Error in Morning Panic Envelope"); return; } // Send error code to postman

//        Complete_Record record = yahooScraperService.scrape_symbol(envelope.symbol, envelope.date, envelope.history_length);

//        if(record != null) {
//            //System.out.println(record.toString_formatted());
//            morningPanicService.addRecord(record, envelope);
//        }

    }


}
