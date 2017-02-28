package com.learn.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

    @Value("${home.name}")
    String testValue;

    @Autowired
    Application.Test test;

    @RequestMapping("/test1")
    public String t1(){
        return test.QQQQ;
    }

    @RequestMapping("/test2")
    public String t2(){
        return testValue;
    }
}
