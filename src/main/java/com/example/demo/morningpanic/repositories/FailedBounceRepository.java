package com.example.demo.morningpanic.repositories;

import com.example.demo.morningpanic.entities.FailedBounceEntity;
import org.springframework.data.repository.CrudRepository;

public interface FailedBounceRepository extends CrudRepository<FailedBounceEntity, Integer> {
}
