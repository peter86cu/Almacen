package com.ayalait.stock.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/print")
    public String print() {
        return "This is from External Tomcat Server";
    }
}
