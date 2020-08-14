package com.example.demo.morningpanic.repositories;

import com.example.demo.morningpanic.entities.MorningPanicHistoricalDataEntity;
import org.springframework.data.repository.CrudRepository;

public interface MorningPanicHistoricalDataRepository extends CrudRepository<MorningPanicHistoricalDataEntity, Integer> {
}
