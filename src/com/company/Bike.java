package com.company;

public class Bike extends Thing {
    Thing thing;

    private int derailleurGears;

    public Bike(String name, ThingSize size, int derailleurGears) {
        super(name, size);
        this.derailleurGears = derailleurGears;
    }
    public int getDerailleurGears() {
        return this.derailleurGears;
    }

    public String toString() {
        return (" - Rower - nazwa: " + thing.getName() + ", objetość: " + thing.getMaxSize() + ", ilość przerzutek: " + getDerailleurGears());
    }
}
