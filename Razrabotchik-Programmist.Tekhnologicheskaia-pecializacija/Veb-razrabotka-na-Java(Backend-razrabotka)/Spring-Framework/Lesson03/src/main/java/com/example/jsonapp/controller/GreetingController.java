package com.example.jsonapp.controller;

import com.example.jsonapp.model.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping("/greet")
    public Greeting greet(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(1, "Hello, " + name + "!");
    }
}
