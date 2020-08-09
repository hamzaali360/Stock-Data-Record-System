package com.example.demo.morningpanic;

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

    public void addRecord(Complete_Record record){
        MorningPanicDataEntity data = new MorningPanicDataEntity(record.data);
        dataRepository.save(data);

        // Assigns dataId as last record in table, which was just inserted.
        MorningPanicDataEntity e = dataRepository.findFirstByOrderByDataIdDesc();
        Integer panic_id = -1;
        if(e != null){ panic_id = e.dataId; } // null if db is empty
        List<MorningPanicHistoricalDataEntity> historicalData = new LinkedList<>();
        int length = record.historical_data.size();
        for(int i=0; i<length; i++){
            historicalData.add(new MorningPanicHistoricalDataEntity(record.historical_data.get(i), panic_id));
        }

        System.out.println("Going to save");
        for(int i=0; i<length; i++){
            historicalDataRepository.save(historicalData.get(i));
        }
        System.out.println("Saved records");
    }

}

