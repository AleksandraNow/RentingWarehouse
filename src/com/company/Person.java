package com.company;

import com.company.exceptions.NeverRentException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Person {


    private int personId;
    private static int lastPersonId = 1;
    private String name;
    private String lastName;
    private String personalIdentityNumber;
    private String address;
    //private Date dateOfBirth; trzeba pozniej zmienic
    private String dateOfBirth;
    private Date firstRent;

    public Person (String name, String lastName, String personalIdentityNumber, String address, String dateOfBirth) {
        this.personId = Person.lastPersonId++;
        this.name = name;
        this.lastName = lastName;
        this.personalIdentityNumber = personalIdentityNumber;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
    }

    public String toString() {
        return name + " " + lastName;
    }

    public Date getFirstRent() throws NeverRentException{
        if (firstRent == null) {
            throw new NeverRentException();
        } else {
            return firstRent = new Date(System.currentTimeMillis());
        }
    }

    public int getPersonId() {
        return personId;
    }

    public static int getLastPersonId() {
        return lastPersonId;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPersonalIdentityNumber() {
        return personalIdentityNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public static void createPerson(WarehouseReport warehouseReport) {
         Person person1 = new Person("ola", "t", "12123456", "adress1", "202-02-03");
         Person person2 = new Person("ola", "t", "12123456", "adress1", "202-02-03");
         Person person3 = new Person("ola", "t", "12123456", "adress1", "202-02-03");
         Person person4 = new Person("ola", "t", "12123456", "adress1", "202-02-03");
         Person person5 = new Person("ola", "t", "12123456", "adress1", "202-02-03");
         warehouseReport.addPerson(person1);
         warehouseReport.addPerson(person2);
         warehouseReport.addPerson(person3);
         warehouseReport.addPerson(person4);
         warehouseReport.addPerson(person5);

    }

}
