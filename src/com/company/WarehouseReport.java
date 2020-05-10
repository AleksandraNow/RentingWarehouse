package com.company;

import java.util.ArrayList;
import java.util.List;

public class WarehouseReport {

    private String warehouseSetName;

    private List<WarehouseSpace> warehouseSet = new ArrayList<WarehouseSpace>();

    private List<Person> listPerson = new ArrayList<Person>();

    public WarehouseReport(String warehouseSetName) {
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
            if (warehouseSpace.getWarehouseId() == id) {
                return warehouseSpace;
            }
        }
        return null;
    }

}
