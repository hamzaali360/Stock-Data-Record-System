package com.example.demo.controllers;


import com.example.demo.controllers.messages.MorningPanicEnvelope;
import com.example.demo.controllers.messages.ResponseObject;
import com.example.demo.morningpanic.MorningPanicService;
import com.example.demo.webscraper.YahooScraperService;
import com.example.demo.webscraper.model.Complete_Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> addRecord(@RequestBody MorningPanicEnvelope envelope){
        System.out.println(envelope.toString());

        ResponseObject response = validate_MorningPanicEnvelope(envelope);

        if(!response.valid){
            System.out.println("Error in Morning Panic Envelope");
            return new ResponseEntity<>(response.response, HttpStatus.BAD_REQUEST);
        }

        Complete_Record record = yahooScraperService.scrape_symbol(envelope.data.symbol, envelope.date, envelope.history_length);

        if(record != null) {
            //System.out.println(record.toString_formatted());
            morningPanicService.addRecord(record, envelope);
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        }else{ return new ResponseEntity<>("Webscraper failure (NULL).", HttpStatus.FAILED_DEPENDENCY); }

    }


}
