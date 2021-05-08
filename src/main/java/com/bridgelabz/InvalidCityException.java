package com.bridgelabz;

public class InvalidCityException extends Exception {
    String message;
    public InvalidCityException(String message) {
        this.message = message;
    }
}
