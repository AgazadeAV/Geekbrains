package com.example.jsonapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Greeting {
    private final long id;
    private final String message;
}
