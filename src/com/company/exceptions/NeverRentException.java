package com.company.exceptions;

public class NeverRentException extends Exception {
    public NeverRentException() {
        super("Never rent");
    }
}
