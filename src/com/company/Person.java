package com.company;

import com.company.exceptions.NeverRentException;

import java.util.Date;

public class Person {


    private int personId;
    private static int lastPersonId = 1;
    private String name;
    private String lastName;
    private String personalIdentityNumber;
    private String address;
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

    public String  getDateOfBirth() {
        return dateOfBirth;
    }



}
