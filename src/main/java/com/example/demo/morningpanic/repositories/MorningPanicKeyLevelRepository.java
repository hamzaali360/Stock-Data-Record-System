package com.example.demo.morningpanic.repositories;

import com.example.demo.morningpanic.entities.MorningPanicDataEntity;
import com.example.demo.morningpanic.entities.MorningPanicKeyLevelEntity;
import org.springframework.data.repository.CrudRepository;

public interface MorningPanicKeyLevelRepository extends CrudRepository<MorningPanicKeyLevelEntity, Integer> {
}
