package com.company;

public class Motorcycle extends Thing {

    public boolean isHomologation() {
        return homologation;
    }

    private boolean homologation;

    public Motorcycle(String name, ThingSize size, boolean homologation) {
        super(name, size);
        this.homologation = homologation;
    }
}
