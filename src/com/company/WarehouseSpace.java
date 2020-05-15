package com.company;

import com.company.exceptions.TooManyThingsException;
import com.company.exceptions.WarehouseIsRentedException;

import java.util.*;

public class WarehouseSpace {
    private int warehouseId;
    private int area;
    private Date time;
    private Person person;
    private int spaceUsed = 0;

    private boolean isAvailable = true;
    private static int lastThingId = 1;


    // przedmioty w pomieszczeniu
    private Map<Integer, Thing> things = new HashMap<Integer, Thing>();

    public WarehouseSpace(int area) {
        this.warehouseId = GenerateUniqueID.getUniqueID();
        this.area = area;
    }

    public WarehouseSpace(int length, int width, int height) {
        this.warehouseId = GenerateUniqueID.getUniqueID();
        this.area = length * width * height;
    }

    public void removePerson() {
        this.person = null;
    }

    public void addThing(Thing thing) throws TooManyThingsException {
        if (thing.getMaxSize() < this.getArea()) {
            this.things.put(lastThingId++, thing);
        } else {
            throw new TooManyThingsException();
        }
    }

    public void removeThing(int thingId) {
        this.things.remove(thingId);
    }

    //aktualny wynajmujący
    public Person getPerson() {
        return person;
    }

    public int getWarehouseId() {
        return warehouseId;
    }

    public int getArea() {
        return area;
    }

    public void rentWarehousespace(Person person) throws WarehouseIsRentedException {
        if (!this.isAvailable)
            throw new WarehouseIsRentedException("magazyn nie jest dostępny");
        if (this.person != null)
            throw new WarehouseIsRentedException("magazyn jest już wynajęty przez:  " + this.person.toString());
        this.person = person;
        this.isAvailable = false;
    }

    //pobranie wszystkich przedmiotów z listy w pomieszczeniu
    public Map<Integer, Thing> getThings() {
        return things;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    //wyswitlenie zawartosci pomieszczenia
    public void warehouseContent(boolean thingId) {
        Set<Integer> indexes = things.keySet();
        //keyset() zwroci mi zbiór kluczy
        for (Integer number : indexes) {
            Thing thing = things.get(number);
            String idString = number.toString() + "-";
            if (thing instanceof Bike) {
                System.out.println((thingId ? idString : "") + "Rower - nazwa: " + thing.getName() + ", objetosc: " + thing.getMaxSize() + ", ilosc przerzutek: " + ((Bike) thing).getDerailleurGears());
            } else if (thing instanceof Car) {
                System.out.println((thingId ? idString : "") + "Samochód - nazwa: " + thing.getName() + ", objetosc: " + thing.getMaxSize() + ", silnik: " + ((Car) thing).getEngine());
            } else if (thing instanceof Motorcycle) {
                System.out.println((thingId ? idString : "") + "Motocykl - nazwa: " + thing.getName() + ", objetosc: " + thing.getMaxSize() + ", homologacja: " + ((Motorcycle) thing).isHomologation());
            } else {
                System.out.println((thingId ? idString : "") + "Przedmiot - nazwa: " + thing.getName() + ", objetosc: " + thing.getMaxSize());
            }

        }

    }

    public void warehouseInfo() {
        System.out.println("pomieszczenie o objętości: " + this.getArea());
    }



}
