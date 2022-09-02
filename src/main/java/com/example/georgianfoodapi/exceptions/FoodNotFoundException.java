package com.example.georgianfoodapi.exceptions;

public class FoodNotFoundException extends Exception {
    public FoodNotFoundException(Long id) {
        super("Could not found food: " + id);
    }
}
