package com.company;

public class Bike extends Thing {

    private int derailleurGears;

    public Bike(String name, ThingSize size, int derailleurGears) {
        super(name, size);
        this.derailleurGears = derailleurGears;
    }
    public int getDerailleurGears() {
        return this.derailleurGears;
    }
}
