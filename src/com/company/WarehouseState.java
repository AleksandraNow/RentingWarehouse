package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WarehouseState {

    private String warehouseSetName;

    private List<WarehouseSpace> warehouseSet = new ArrayList<WarehouseSpace>();

    private List<Person> listPerson = new ArrayList<Person>();

    public WarehouseState(String warehouseSetName) {
        this.warehouseSetName = warehouseSetName;
    }

    public String getWarehouseSetName() {
        return warehouseSetName;
    }

    public List<WarehouseSpace> getWarehouseSet() {
        return this.warehouseSet;
    }

    public List<Person> getListPerson() {
        return this.listPerson;
    }


    public void addWarehouse(WarehouseSpace warehouseSpace) {
        this.warehouseSet.add(warehouseSpace);
    }

    public void addPerson(Person person) {
        this.listPerson.add(person);
    }

    public Person getPersonById(int id) {
        for (Person person : this.listPerson) {
            if (person.getPersonId() == id)
                return person;
        }
        return null;
    }

    public WarehouseSpace getWarehouseById(int id) {
        for (WarehouseSpace warehouseSpace : this.warehouseSet) {
            if (warehouseSpace.getWarehouseId() == id)
                return warehouseSpace;

        }
        return null;
    }

    public static void createWarehouseSpaces(WarehouseState warehouseState) {
        WarehouseSpace warehouseSpace1 = new WarehouseSpace(120);
        WarehouseSpace warehouseSpace2 = new WarehouseSpace(85);
        WarehouseSpace warehouseSpace3 = new WarehouseSpace(460);
        WarehouseSpace warehouseSpace4 = new WarehouseSpace(20);
        WarehouseSpace warehouseSpace5 = new WarehouseSpace(80, 2, 1);
        WarehouseSpace warehouseSpace6 = new WarehouseSpace(45, 2, 9);
        WarehouseSpace warehouseSpace7 = new WarehouseSpace(2, 55, 1);
        WarehouseSpace warehouseSpace8 = new WarehouseSpace(100, 2, 1);
        WarehouseSpace warehouseSpace9 = new WarehouseSpace(85);
        WarehouseSpace warehouseSpace10 = new WarehouseSpace(81);
        warehouseState.addWarehouse(warehouseSpace1);
        warehouseState.addWarehouse(warehouseSpace2);
        warehouseState.addWarehouse(warehouseSpace3);
        warehouseState.addWarehouse(warehouseSpace4);
        warehouseState.addWarehouse(warehouseSpace5);
        warehouseState.addWarehouse(warehouseSpace6);
        warehouseState.addWarehouse(warehouseSpace7);
        warehouseState.addWarehouse(warehouseSpace8);
        warehouseState.addWarehouse(warehouseSpace9);
        warehouseState.addWarehouse(warehouseSpace10);
    }


    public void createPeople() {
        Person person1 = new Person("ola", "t", "12123456", "adress1", "202-02-03");
        Person person2 = new Person("ala", "asb", "12123456", "adress1", "202-02-03");
        Person person3 = new Person("marek", "c", "12123456", "adress1", "202-02-03");
        Person person4 = new Person("asia", "d", "12123456", "adress1", "202-02-03");
        Person person5 = new Person("kasia", "td", "12123456", "adress1", "202-02-03");
        this.addPerson(person1);
        this.addPerson(person2);
        this.addPerson(person3);
        this.addPerson(person4);
        this.addPerson(person5);
    }

    public void report() {
        String fileName = "MAGAZYN.txt";
        BufferedWriter writer;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            writer = new BufferedWriter(new FileWriter(fileName));
            for (WarehouseSpace warehouseSpace : warehouseSet) {
                stringBuffer.append("------------------------------------------------------------------------------\n");
                stringBuffer.append("Pomieszczenie: id = " + warehouseSpace.getWarehouseId() + " całkowita przestrzeń" +
                        " = " + warehouseSpace.getArea() + "\n");
                stringBuffer.append("dostępne: " + (warehouseSpace.isAvailable() ? "tak\n" : "nie\n"));
                stringBuffer.append("najemca: " + (warehouseSpace.getPerson() != null ?
                        warehouseSpace.getPerson().toString() + "\n" : "brak\n"));
                stringBuffer.append("------------------------------------------------------------------------------\n");
                Set<Integer> indexes = warehouseSpace.getThings().keySet();
                for (Integer integer : indexes) {
                    Thing thing = warehouseSpace.getThings().get(integer);
                    for (Integer i : indexes) {
                        Thing t = warehouseSpace.getThings().get(i);
                        if (t instanceof Bike) {
                            stringBuffer.append(i.toString() + " - Rower - nazwa: " + t.getName() + ", objetość: " + t.getMaxSize() + ", ilość przerzutek: " + ((Bike) t).getDerailleurGears() + "\n");
                        } else if (t instanceof Car) {
                            stringBuffer.append(i.toString() + " - Samochód - nazwa: " + t.getName() + ", objetość: " + t.getMaxSize() + ", silnik: " + ((Car) t).getEngine() + "\n");
                        } else if (t instanceof Motorcycle) {
                            stringBuffer.append(i.toString() + " - Motocykl - nazwa: " + t.getName() + ", objetość: " + t.getMaxSize() + ", homologacja: " + ((Motorcycle) t).isHomologation() + "\n");
                        } else {
                            stringBuffer.append(i.toString() + " - Przedmiot - nazwa: " + t.getName() + ", objetość: " + t.getMaxSize() + "\n");
                        }
                    }
                }
            }
            writer.write(stringBuffer.toString());
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}