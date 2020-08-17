package com.example.demo.morningpanic.repositories;

import com.example.demo.morningpanic.entities.DataEntity;
import org.springframework.data.repository.CrudRepository;

public interface DataRepository extends CrudRepository<DataEntity, Integer> {
    DataEntity findFirstByOrderByDataIdDesc();

}
