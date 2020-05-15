package com.company;

public class Thing {
    private String name;

    //wielkosc nierozlozonego przedmiotu
    private ThingSize complexSize;

    //wielkosc rozłozonego przedmiotu
    private ThingSize distributedSize;

    public Thing(String name, ThingSize complexSize) {
        this.name = name;
        this.complexSize = complexSize;
    }

    public Thing(String name, ThingSize complexSize, ThingSize distributedSize) {
        this.name = name;
        this.complexSize = complexSize;
        this.distributedSize = distributedSize;
    }

    public int getMaxSize() {
        if (complexSize != null && distributedSize != null) {
            //math.max porówuje dwie wartosci i zwraca większą wartość
            return Math.max(complexSize.getSize(), distributedSize.getSize());
        } else {
            return complexSize.getSize();
        }
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return " - Przedmiot - nazwa: " + getName() + ", objetość: " + getMaxSize();
    }
}
