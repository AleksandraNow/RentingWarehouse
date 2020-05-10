package com.company;

public class Car extends Thing {

    private EngineType engine;

    public Car(String name, ThingSize size, EngineType engine ) {
        super(name, size);
        this.engine = engine;
    }
    public EngineType getEngine() {
        return this.engine;
    }
}
