package com.company;

import com.company.exceptions.NeverRentException;
import com.company.exceptions.TooManyThingsException;
import com.company.exceptions.WarehouseIsRentedException;

import java.text.ParseException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws NeverRentException, WarehouseIsRentedException, TooManyThingsException, ParseException {


        WarehouseReport warehouseReport = new WarehouseReport("duży magazyn");
        System.out.println("Witaj w magazynie: " + warehouseReport.getWarehouseSetName());

        int menu;
        int selectedPerson = 0;
        int selectedWarehouse = 0;
        int selectedWarehouseByPerson = 0;

        while (true) {
            Scanner scanner = new Scanner(System.in);
            menu = scanner.nextInt();

            switch (menu) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("wybierz osobe: ");
                    warehouseReport.getListPerson().stream().forEach(person -> {
                        System.out.println(person.getPersonId() + " - " + person.toString());
                    });

                    selectedPerson = scanner.nextInt();
                    if (selectedPerson == 0) {
                        System.exit(0);
                    }
                    System.out.println("wybrany wynajmujący" + warehouseReport.getPersonById(selectedPerson));

                    selectedWarehouse = 0;
                    break;
                case 2:
                    if (selectedPerson == 0) {
                        System.out.println("wybierz najpierw wynajmującego");
                    } else {
                        Person person = warehouseReport.getPersonById(selectedPerson);
                        System.out.println("Imie: " + person.getName() + ", Nazwisko: " + person.getLastName());
                        System.out.println("PESEL: " + person.getPersonalIdentityNumber() + ", Data ur: " + person.getDateOfBirth());
                        System.out.println("Adrees: " + person.getAddress());
                        System.out.println("Pomieszczenia:");

                        for (WarehouseSpace warehouseSpace : warehouseReport.getWarehouseSet()) {
                            if (warehouseSpace != null && warehouseSpace.getPerson().getPersonId() == selectedPerson) {
                                System.out.println("id" + warehouseSpace.getWarehouseId() + "objetosc" + warehouseSpace.getArea());
                                selectedWarehouseByPerson++;
                            }
                        }

                    }
            }

        }
    }
}
