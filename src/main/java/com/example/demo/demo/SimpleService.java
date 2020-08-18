package com.example.demo.demo;

import com.example.demo.demo.entities.SimpleEntity;
import com.example.demo.demo.repositories.SimpleRepository;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class SimpleService {
    @Autowired
    private SimpleRepository simpleRepository;

    public void addRecord(SimpleEntity entity){ simpleRepository.save(entity); }

}
