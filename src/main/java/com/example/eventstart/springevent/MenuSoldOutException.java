package com.example.eventstart.springevent;

public class MenuSoldOutException extends RuntimeException{
    public MenuSoldOutException(String message) {
        super(message);
    }
}
