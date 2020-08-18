package com.example.demo.demo.repositories;

import com.example.demo.demo.entities.SimpleEntity;
import org.springframework.data.repository.CrudRepository;

public interface SimpleRepository extends CrudRepository<SimpleEntity, Integer> {
}
