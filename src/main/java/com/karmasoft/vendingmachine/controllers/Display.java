package com.karmasoft.vendingmachine.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Display {
    @GetMapping("/display")
    public String display(){
        return "Empty";
    }
}
