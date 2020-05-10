package com.company.exceptions;

public class TooManyThingsException extends Exception {
    public TooManyThingsException() {
        super("Too many things");
    }
}
