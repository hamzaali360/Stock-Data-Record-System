package com.example.demo.demo;


import com.example.demo.demo.entities.SimpleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {
    @Autowired
    SimpleService simpleService;

    @RequestMapping(method= RequestMethod.POST, value="/simple")
    public void addRecord(){
        simpleService.addRecord(new SimpleEntity());
    }
}
