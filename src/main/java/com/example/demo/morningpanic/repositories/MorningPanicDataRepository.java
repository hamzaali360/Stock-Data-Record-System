package com.example.demo.morningpanic.repositories;

import com.example.demo.morningpanic.entities.MorningPanicDataEntity;
import org.springframework.data.repository.CrudRepository;

public interface MorningPanicDataRepository extends CrudRepository<MorningPanicDataEntity, Integer> {
    MorningPanicDataEntity findFirstByOrderByDataIdDesc();

}
