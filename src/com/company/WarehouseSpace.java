package com.company;

import com.company.exceptions.TooManyThingsException;
import com.company.exceptions.WarehouseIsRentedException;

import java.text.SimpleDateFormat;
import java.util.*;

public class WarehouseSpace {
    private int warehouseId;
    public int data;
    public int lockerId;
    private int area;
    private Date time;
    private Person person;
    private int spaceUsed = 0;



    private boolean isAvailable = true;
    private static int lastLockerId = 1;
    private static int lastThingId = 1;



    // przedmioty w pomieszczeniu
    private Map<Integer, Thing> things = new HashMap<Integer, Thing>();

    public WarehouseSpace(int area) {
        this.lockerId = WarehouseSpace.lastLockerId++;
        this.area = area;
    }

    public WarehouseSpace(int length, int width, int height) {
        this.lockerId = WarehouseSpace.lastLockerId++;
        this.area = length * width * height;
    }


    public boolean isFree() {
        if (person == null) {
            return true;
        }
        return false;
    }

    public void removePerson() {
        this.person = null;
    }

    //dodanie rzeczy do pomieszczenia
    public void addThing(Thing thing) throws TooManyThingsException {
        if (thing.getMaxSize() < this.getArea()) {
            this.things.put(lastThingId++, thing);
            spaceUsed += thing.getMaxSize();
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

    //wynejm pomieszczenia
    public void addPerson(Person person) throws WarehouseIsRentedException {
        if (this.isAvailable == false) {
            throw new WarehouseIsRentedException("warehouse is already rented");
        } else {
            this.person = person;
            this.isAvailable = false;
        }
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
        Set <Integer> indexes = things.keySet();
        for (Integer number : indexes) {
            Thing thing = things.get(number);
            String idString = number.toString() + "-";
            if (thing instanceof Bike) {
                System.out.println((thingId ? idString : "") + "Rower - nazwa: " + thing.getName() + ", objetosc: " + thing.getMaxSize() + ", ilosc przerzutek: " + ((Bike) thing).getDerailleurGears());
            } else if(thing instanceof Car) {
                System.out.println((thingId ? idString : "") + "Samochód - nazwa: " + thing.getName() + ", objetosc: " + thing.getMaxSize()+ ", silnik: " + ((Car) thing).getEngine());
            } else if(thing instanceof Motorcycle) {
                System.out.println((thingId ? idString : "") + "Motocykl - nazwa: " + thing.getName() + ", objetosc: " + thing.getMaxSize() + ", homologacja: " + ((Motorcycle) thing).isHomologation());
            } else {
                System.out.println((thingId ? idString : "") + "Przedmiot - nazwa: " + thing.getName() + ", objetosc: " + thing.getMaxSize());
            }

        }

    }

    public void warehouseInfo() {
        System.out.println(this.lockerId + this.getArea());
    }

    public static void createWarehouse(WarehouseReport warehouseReport) {
        WarehouseSpace warehouseSpace1 = new WarehouseSpace(120);
        WarehouseSpace warehouseSpace2 = new WarehouseSpace(85);
        WarehouseSpace warehouseSpace3 = new WarehouseSpace(460);
        WarehouseSpace warehouseSpace4 = new WarehouseSpace(30,2,3);
        WarehouseSpace warehouseSpace5 = new WarehouseSpace(80,2,1);
        warehouseReport.addWarehouse(warehouseSpace1);
        warehouseReport.addWarehouse(warehouseSpace2);
        warehouseReport.addWarehouse(warehouseSpace3);
        warehouseReport.addWarehouse(warehouseSpace4);
        warehouseReport.addWarehouse(warehouseSpace5);
    }


}
