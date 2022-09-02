package com.example.georgianfoodapi.exceptions;

public class AuthorNotFoundException extends Exception {
    public AuthorNotFoundException(String username) {
        super("could not find author: " + username);
    }
}
