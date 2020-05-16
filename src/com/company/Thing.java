package com.company;

public class Thing {
    private String name;

    //wielkosc nierozlozonego przedmiotu
    private ThingSize folded;

    //wielkosc rozłozonego przedmiotu
    private ThingSize unfolded;

    public Thing(String name, ThingSize folded) {
        this.name = name;
        this.folded = folded;
    }

    public Thing(String name, ThingSize folded, ThingSize unfolded) {
        this.name = name;
        this.folded = folded;
        this.unfolded = unfolded;
    }

    public int getMaxSize() {
        if (folded != null && unfolded != null) {
            //math.max porówuje dwie wartosci i zwraca większą wartość
            return Math.max(folded.getSize(), unfolded.getSize());
        } else {
            return folded.getSize();
        }
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return " - Przedmiot - nazwa: " + getName() + ", objetość: " + getMaxSize();
    }
}
