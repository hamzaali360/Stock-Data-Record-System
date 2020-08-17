package com.example.demo.morningpanic.repositories;

import com.example.demo.morningpanic.entities.HistoricalDataEntity;
import org.springframework.data.repository.CrudRepository;

public interface HistoricalDataRepository extends CrudRepository<HistoricalDataEntity, Integer> {
}
