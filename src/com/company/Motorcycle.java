package com.company;

public class Motorcycle extends Thing {
    Thing thing;

    public boolean isHomologation() {
        return homologation;
    }

    private boolean homologation;

    public Motorcycle(String name, ThingSize size, boolean homologation) {
        super(name, size);
        this.homologation = homologation;
    }

    public String toString() {
        return (" - Motocykl - nazwa: " + thing.getName() + ", objetość: " + thing.getMaxSize() + " ,homologacja: " + isHomologation());
    }
}
