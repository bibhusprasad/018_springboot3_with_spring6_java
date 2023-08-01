package com.bibhu.springboot.myfirstwebapp01.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

    @RequestMapping("/sayHello")
    @ResponseBody
    public String sayHello(){
        return "Hello! How are you doing today?";
    }

    @RequestMapping("/sayHelloJsp")
    public String sayHelloJsp(){
        return "sayHello";
    }
}
