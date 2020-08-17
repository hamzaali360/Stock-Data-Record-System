package com.example.demo.morningpanic;

import com.example.demo.morningpanic.models.Envelope;
import com.example.demo.morningpanic.entities.DataEntity;
import com.example.demo.morningpanic.entities.HistoricalDataEntity;
import com.example.demo.morningpanic.repositories.DataRepository;
import com.example.demo.morningpanic.repositories.HistoricalDataRepository;
import com.example.demo.morningpanic.repositories.KeyLevelRepository;
import com.example.demo.morningpanic.repositories.TechnicalIndicatorBehaviorRepository;
import com.example.demo.webscraper.models.CompleteRecord;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private DataRepository dataRepository;
    @Autowired
    private HistoricalDataRepository historicalDataRepository;
    @Autowired
    private KeyLevelRepository keyLevelRepository;
    @Autowired
    private TechnicalIndicatorBehaviorRepository technicalIndicatorBehaviorRepository;
    
    
    public void addRecord(CompleteRecord record, Envelope envelope){
        DataEntity data = new DataEntity(record.data, envelope);
        dataRepository.save(data);

        // Assigns dataId as last record in table, which was just inserted.
        DataEntity e = dataRepository.findFirstByOrderByDataIdDesc();
        Integer primary_key = -1;
        if(e != null){ primary_key = e.dataId; } // null if db is empty
        
        // Historical Data
        List<HistoricalDataEntity> historicalData = new LinkedList<>();
        int length = record.historical_data.size();
        for(int i=0; i<length; i++){
            historicalData.add(new HistoricalDataEntity(record.historical_data.get(i), primary_key));
        }
        for(int i=0; i<length; i++){
            historicalDataRepository.save(historicalData.get(i));
        }
        
        // Key Levels
        for(int i=0; i<envelope.key_levels.size(); i++){
            envelope.key_levels.get(i).dataId = primary_key;
            keyLevelRepository.save(envelope.key_levels.get(i));
        }

        // Technical Indicator Behaviors
        for(int i=0; i<envelope.technical_indicator_behaviors.size(); i++){
            envelope.technical_indicator_behaviors.get(i).dataId = primary_key;
            technicalIndicatorBehaviorRepository.save(envelope.technical_indicator_behaviors.get(i));
        }
        
        System.out.println("Saved record");
    }

}

