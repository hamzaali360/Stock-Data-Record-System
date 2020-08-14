package com.example.demo.morningpanic;

import com.example.demo.controllers.messages.MorningPanicEnvelope;
import com.example.demo.morningpanic.entities.MorningPanicDataEntity;
import com.example.demo.morningpanic.entities.MorningPanicHistoricalDataEntity;
import com.example.demo.morningpanic.repositories.MorningPanicDataRepository;
import com.example.demo.morningpanic.repositories.MorningPanicHistoricalDataRepository;
import com.example.demo.morningpanic.repositories.MorningPanicKeyLevelRepository;
import com.example.demo.morningpanic.repositories.MorningPanicTechnicalIndicatorBehaviorRepository;
import com.example.demo.webscraper.model.Complete_Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class MorningPanicService {

    @Autowired
    private MorningPanicDataRepository dataRepository;
    @Autowired
    private MorningPanicHistoricalDataRepository historicalDataRepository;
    @Autowired
    private MorningPanicKeyLevelRepository keyLevelRepository;
    @Autowired
    private MorningPanicTechnicalIndicatorBehaviorRepository technicalIndicatorBehaviorRepository;
    
    
    public void addRecord(Complete_Record record, MorningPanicEnvelope envelope){
        MorningPanicDataEntity data = new MorningPanicDataEntity(record.data, envelope);
        dataRepository.save(data);

        // Assigns dataId as last record in table, which was just inserted.
        MorningPanicDataEntity e = dataRepository.findFirstByOrderByDataIdDesc();
        Integer primary_key = -1;
        if(e != null){ primary_key = e.dataId; } // null if db is empty
        
        // Historical Data
        List<MorningPanicHistoricalDataEntity> historicalData = new LinkedList<>();
        int length = record.historical_data.size();
        for(int i=0; i<length; i++){
            historicalData.add(new MorningPanicHistoricalDataEntity(record.historical_data.get(i), primary_key));
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

