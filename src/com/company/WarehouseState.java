package com.company;

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

    public static void createWarehouse(WarehouseState warehouseState) {
        WarehouseSpace warehouseSpace1 = new WarehouseSpace(120);
        WarehouseSpace warehouseSpace2 = new WarehouseSpace(85);
        WarehouseSpace warehouseSpace3 = new WarehouseSpace(460);
        WarehouseSpace warehouseSpace4 = new WarehouseSpace(30, 2, 3);
        WarehouseSpace warehouseSpace5 = new WarehouseSpace(80, 2, 1);
        warehouseState.addWarehouse(warehouseSpace1);
        warehouseState.addWarehouse(warehouseSpace2);
        warehouseState.addWarehouse(warehouseSpace3);
        warehouseState.addWarehouse(warehouseSpace4);
        warehouseState.addWarehouse(warehouseSpace5);
    }


    public void createPeople() {
        Person person1 = new Person("ola", "t", "12123456", "adress1", "202-02-03");
        Person person2 = new Person("ola", "t", "12123456", "adress1", "202-02-03");
        Person person3 = new Person("ola", "t", "12123456", "adress1", "202-02-03");
        Person person4 = new Person("ola", "t", "12123456", "adress1", "202-02-03");
        Person person5 = new Person("ola", "t", "12123456", "adress1", "202-02-03");
        this.addPerson(person1);
        this.addPerson(person2);
        this.addPerson(person3);
        this.addPerson(person4);
        this.addPerson(person5);
    }
}
