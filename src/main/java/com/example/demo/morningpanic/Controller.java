package com.example.demo.morningpanic;


import com.example.demo.morningpanic.models.Envelope;
import com.example.demo.common.models.Response;
import com.example.demo.webscraper.YahooScraperService;
import com.example.demo.webscraper.models.CompleteRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.example.demo.common.util.Validate.validate_MorningPanicEnvelope;

@RestController
public class Controller {

    @Autowired
    private YahooScraperService yahooScraperService;

    @Autowired
    Service morningPanicService;

    @RequestMapping(method=RequestMethod.POST, value="/morning_panic")
    public ResponseEntity<String> addRecord(@RequestBody Envelope envelope){
        System.out.println(envelope.toString());
//        return new ResponseEntity<>("Success", HttpStatus.CREATED);

        Response response = validate_MorningPanicEnvelope(envelope);

        if(!response.valid){
            System.out.println("Error in Morning Panic Envelope");
            return new ResponseEntity<>(response.response, HttpStatus.BAD_REQUEST);
        }

        CompleteRecord record = yahooScraperService.scrape_symbol(envelope.data.symbol, envelope.date, envelope.history_length);

        if(record != null) {
            //System.out.println(record.toString_formatted());
            morningPanicService.addRecord(record, envelope);
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        }else{ return new ResponseEntity<>("Webscraper failure (NULL).", HttpStatus.FAILED_DEPENDENCY); }

    }
}
