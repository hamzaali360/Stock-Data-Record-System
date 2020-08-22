package com.example.demo.morningpanic;

import com.example.demo.morningpanic.models.Envelope;
import com.example.demo.morningpanic.entities.DataEntity;
import com.example.demo.morningpanic.entities.HistoricalDataEntity;
import com.example.demo.morningpanic.repositories.*;
import com.example.demo.webscraper.models.CompleteRecord;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private DataRepository dataRepository;
    @Autowired
    private PremarketRepository premarketRepository;
    @Autowired
    private MainPanicBounceRepository mainPanicBounceRepository;
    @Autowired
    private HistoricalDataRepository historicalDataRepository;
    @Autowired
    private KeyLevelRepository keyLevelRepository;
    @Autowired
    private TechnicalIndicatorBehaviorRepository technicalIndicatorBehaviorRepository;
    @Autowired
    private FailedBounceRepository failedBounceRepository;
    @Autowired
    private PullbackBounceRepository pullbackBounceRepository;
    @Autowired
    private FailedMorningSpikeRepository failedMorningSpikeRepository;
    @Autowired
    private CatalystRepository catalystRepository;


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

        // Premarket
        envelope.premarket.dataId = primary_key;
        envelope.premarket.calculateMetrics();
        premarketRepository.save(envelope.premarket);

        // Main Panic Bounce
        envelope.main_panic_bounce.dataId = primary_key;
        envelope.main_panic_bounce.calculateMetrics();
        mainPanicBounceRepository.save(envelope.main_panic_bounce);

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

        // Failed Bounce
        for(int i=0; i<envelope.failed_bounces.size(); i++){
            envelope.failed_bounces.get(i).dataId = primary_key;
            envelope.failed_bounces.get(i).calculateMetrics();
            failedBounceRepository.save(envelope.failed_bounces.get(i));
        }

        // Pullback Bounce
        for(int i=0; i<envelope.pullback_bounces.size(); i++){
            envelope.pullback_bounces.get(i).dataId = primary_key;
            envelope.pullback_bounces.get(i).calculateMetrics();
            pullbackBounceRepository.save(envelope.pullback_bounces.get(i));
        }

        // Failed Morning Spike
        for(int i=0; i<envelope.failed_morning_spikes.size(); i++){
            envelope.failed_morning_spikes.get(i).dataId = primary_key;
            envelope.failed_morning_spikes.get(i).calculateMetrics();
            failedMorningSpikeRepository.save(envelope.failed_morning_spikes.get(i));
        }

        // Catalysts
        for(int i=0; i<envelope.catalysts.size(); i++){
            envelope.catalysts.get(i).dataId = primary_key;
            catalystRepository.save(envelope.catalysts.get(i));
        }

        System.out.println("Saved record");
    }

}

