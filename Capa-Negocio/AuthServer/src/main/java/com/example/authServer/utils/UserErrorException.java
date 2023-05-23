package com.example.authServer.utils;

public class UserErrorException extends Exception{
    public UserErrorException(String message) {
        super(message);
    }
}
