package com.increff.employee.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @RequestMapping(path = "/say-hello", method = RequestMethod.GET)
    public String sayHello(){
        return "Hello World!";
    }

    @RequestMapping(path = "/say-hello2", method = RequestMethod.GET)
    public String sayHello2(){
        return "Hello World 2!";
    }


}


