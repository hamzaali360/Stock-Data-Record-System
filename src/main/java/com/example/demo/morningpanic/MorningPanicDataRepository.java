package com.example.demo.morningpanic;

import org.springframework.data.repository.CrudRepository;

public interface MorningPanicDataRepository extends CrudRepository<MorningPanicDataEntity, Integer> {
    MorningPanicDataEntity findFirstByOrderByDataIdDesc();

}
