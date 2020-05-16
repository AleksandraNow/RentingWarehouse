package com.company;

public class Car extends Thing {
    Thing thing;

    private EngineType engine;

    public Car(String name, ThingSize size, EngineType engine ) {
        super(name, size);
        this.engine = engine;
    }
    public EngineType getEngine() {
        return this.engine;
    }

    public String toString() {
        return (" - Samochód - nazwa: " + thing.getName() + ", objetość: " + thing.getMaxSize() +", silnik: " + getEngine());
    }
}
