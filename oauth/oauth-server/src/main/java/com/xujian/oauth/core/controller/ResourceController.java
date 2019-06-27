package com.xujian.oauth.core.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {

    @GetMapping("/hi")
    public String hi(String name){
        return "hi , " + name;
    }


}
