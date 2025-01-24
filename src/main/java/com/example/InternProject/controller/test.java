package com.example.InternProject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class test {
    @GetMapping("/test")
    public String test() {
        return "test";
    }

}
