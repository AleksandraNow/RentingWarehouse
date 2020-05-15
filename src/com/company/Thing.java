package com.company;

public class Thing {
    private String name;

    //wielkosc nierozlozonego przedmiotu
    private ThingSize size1;

    //wielkosc rozłozonego przedmiotu
    private ThingSize size2;

    public Thing(String name, ThingSize size) {
        this.name = name;
        this.size1 = size;
    }

    public Thing(String name, ThingSize size, ThingSize size2) {
        this.name = name;
        this.size1 = size;
        this.size2 = size2;
    }

    public int getMaxSize() {
        if (size1 != null && size2 != null) {
            //math.max porówuje dwie wartosci i zwraca większą wartość
            return Math.max(size1.getSize(), size2.getSize());
        } else {
            return size1.getSize();
        }
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return " - Przedmiot - nazwa: " + getName() + ", objetość: " + getMaxSize();
    }
}
