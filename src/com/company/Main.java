package com.company;

import com.company.exceptions.NeverRentException;
import com.company.exceptions.TooManyThingsException;
import com.company.exceptions.WarehouseIsRentedException;

import java.text.ParseException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws NeverRentException, WarehouseIsRentedException, TooManyThingsException, ParseException {


        WarehouseState warehouseState = new WarehouseState("duży magazyn");


        WarehouseState.createWarehouseSpaces(warehouseState);
        warehouseState.createPeople();


        System.out.println("Witaj w magazynie: " + warehouseState.getWarehouseSetName());

        prompt();
        int menu;
        int selectedPerson = 0;
        int selectedWarehouse = 0;
        int selectedWarehouseByPerson = 0;
        int selectedPersonLockerCount = 0;

        while (true) {
            Scanner scanner = new Scanner(System.in);
            menu = scanner.nextInt();

            switch (menu) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("wybierz osobe: ");
                    warehouseState.getListPerson().stream().forEach(person -> {
                        System.out.println(person.getPersonId() + " - " + person.toString());
                    });

                    selectedPerson = scanner.nextInt();
                    if (selectedPerson == 0) {
                        System.exit(0);
                    }
                    System.out.println("wybrany wynajmujący" + warehouseState.getPersonById(selectedPerson));

                    selectedWarehouse = 0;

                    prompt();
                    break;
                case 2:
                    if (selectedPerson == 0) {
                        System.out.println("wybierz najpierw wynajmującego");
                    } else {
                        Person person = warehouseState.getPersonById(selectedPerson);
                        System.out.println("Imie: " + person.getName() + ", Nazwisko: " + person.getLastName());
                        System.out.println("PESEL: " + person.getPersonalIdentityNumber() + ", Data ur: " + person.getDateOfBirth());
                        System.out.println("Adrees: " + person.getAddress());
                        System.out.println("Pomieszczenia:");

                        selectedPersonLockerCount = 0;

                        for (WarehouseSpace warehouseSpace : warehouseState.getWarehouseSet()) {
                            if (warehouseSpace.getPerson() != null && warehouseSpace.getPerson().getPersonId() == selectedPerson) {
                                System.out.println("id: " + warehouseSpace.getWarehouseId() + " objetosc: " + warehouseSpace.getArea());
                                selectedPersonLockerCount++;
                            }
                        }

                    }
                    prompt();
                    break;
                case 3:
                    if (selectedPerson == 0) {
                        System.out.println("W pierwszej kolejności należy wybrać najemcę");
                    } else {
                        System.out.println("wybierz pomieszczenie wynajmowane przez najemce");
                        for (WarehouseSpace warehouseSpace : warehouseState.getWarehouseSet()) {
                            if (warehouseSpace.getPerson() != null && warehouseSpace.getPerson().getPersonId() == selectedPerson) {
                                System.out.println(warehouseSpace.getWarehouseId() + " -całkowita objetość:  " + warehouseSpace.getArea() + " przedmioty: " + warehouseSpace.getThings().toString());
                            }
                        }
                        System.out.println("0 - zakonczenie programu");

                        selectedWarehouse = scanner.nextInt();
                        if (selectedWarehouse == 0)
                            System.exit(0);

                        System.out.println("wyswitlenie zawartosci");
                        warehouseState.getWarehouseById(selectedWarehouse).warehouseContent(false);
                    }
                    prompt();
                    break;
                //dodanie rzeczy
                case 4:
                    if (selectedPerson == 0 || selectedWarehouse == 0) {
                        System.out.println("W pierwszej kolejności należy wybrać najemcę");
                    } else {
                        System.out.println("wybierz przedmiot");
                        System.out.println("1 - samochód");
                        System.out.println("2 - mototcykl");
                        System.out.println("3 - rower");
                        System.out.println("4 - przedmiot");
                        System.out.println("0 - zakonczenie programu");

                        int selectedThing = scanner.nextInt();

                        String thingName;
                        ThingSize thingSize = new ThingSize(0);
                        String width, length, height;
                        int sizeType;
                        Scanner scanner1 = new Scanner(System.in);

                        switch (selectedThing) {
                            case 0:
                                System.exit(0);
                                break;
                            case 1:
                                System.out.println("marka samochod");
                                thingName = scanner1.nextLine();
                                System.out.println("Zajmowana objętość: 0 - m3, 1 - wymiary (szer x dł x wys)");
                                sizeType = scanner.nextInt();
                                if (sizeType == 0) {
                                    System.out.println("objetosc: ");
                                    String sizeString = scanner1.nextLine();
                                    thingSize = new ThingSize(Integer.parseInt(sizeString));
                                } else if (sizeType == 1) {
                                    System.out.println("podaj szerokośc");
                                    width = scanner1.nextLine();
                                    System.out.println("podaj długosc");
                                    length = scanner1.nextLine();
                                    System.out.println("podaj wysokosc");
                                    height = scanner1.nextLine();
                                    thingSize = new ThingSize(Integer.parseInt(width), Integer.parseInt(length),
                                            Integer.parseInt(height));
                                }
                                System.out.println("Typ silnika: 0 - DIESEL, 1 - GAS, 2 - PETROL, 3 - HYBRID");
                                int carEngineType = scanner.nextInt();
                                Car car = new Car(thingName, thingSize, EngineType.values()[carEngineType]);
                                try {
                                    warehouseState.getWarehouseById(selectedWarehouse).addThing(car);
                                } catch (TooManyThingsException tooManyThingsException) {
                                    System.out.println(tooManyThingsException);
                                }
                                break;

                            case 2:
                                System.out.println("marka motocyklu");
                                thingName = scanner.nextLine();
                                System.out.println("Zajmowana objętość: 0 - m3, 1 - wymiary (szer x dł x wys)");
                                sizeType = scanner1.nextInt();
                                if (sizeType == 0) {
                                    int size1 = scanner1.nextInt();
                                    thingSize = new ThingSize(size1);
//                                    String sizeString = scanner1.nextLine();
//                                    thingSize = new ThingSize(Integer.parseInt(sizeString));

                                } else if (sizeType == 1) {
                                    System.out.println("podaj szerokośc");
                                    width = scanner1.nextLine();
                                    System.out.println("podaj długosc");
                                    length = scanner1.nextLine();
                                    System.out.println("podaj wysokosc");
                                    height = scanner1.nextLine();
                                    thingSize = new ThingSize(Integer.parseInt(width),
                                            Integer.parseInt(length),
                                            Integer.parseInt(height));
                                }
                                System.out.println("homologacja: 0 - nie, 1- tak");
                                int homologation = scanner1.nextInt();
                                Motorcycle motorcycle = new Motorcycle(thingName, thingSize, (homologation == 1));
                                try {
                                    warehouseState.getWarehouseById(selectedWarehouse).addThing(motorcycle);
                                } catch (TooManyThingsException tooManyThingsException) {
                                    System.out.println(tooManyThingsException);
                                }
                                break;
                            case 3:
                                System.out.println("nazwa roweru");
                                thingName = scanner1.nextLine();
                                System.out.println("Zajmowana objętość: 0 - m3, 1 - wymiary (szer x dł x wys)");
                                sizeType = scanner.nextInt();
                                if (sizeType == 0) {
                                    System.out.println("objetosc: ");
                                    int size = scanner1.nextInt();
                                    thingSize = new ThingSize(size);
                                } else if (sizeType == 1) {
                                    System.out.println("szerokość:");
                                    width = scanner1.nextLine();
                                    System.out.println("długość:");
                                    length = scanner1.nextLine();
                                    System.out.println("wysokość:");
                                    height = scanner1.nextLine();
                                    thingSize = new ThingSize(Integer.parseInt(width), Integer.parseInt(length),
                                            Integer.parseInt(height));
                                }
                                System.out.println("ilosc przerzutek");
                                int derailleurGears = scanner.nextInt();
                                Bike bike = new Bike(thingName, thingSize, derailleurGears);
                                try {
                                    warehouseState.getWarehouseById(selectedWarehouse).addThing(bike);
                                } catch (TooManyThingsException tooManyThingsException) {
                                    System.out.println(tooManyThingsException);
                                }
                                break;

                            case 4:
                                System.out.println("nazwa przedmiotu");
                                thingName = scanner1.nextLine();
                                System.out.println("Zajmowana objętość: 0 - m3, 1 - wymiary (szer x dł x wys)");
                                sizeType = scanner.nextInt();
                                if (sizeType == 0) {
                                    System.out.println("objetosc: ");
                                    int size = scanner1.nextInt();
                                    thingSize = new ThingSize(size);
                                } else if (sizeType == 1) {
                                    System.out.println("szerokość:");
                                    width = scanner1.nextLine();
                                    System.out.println("długość:");
                                    length = scanner1.nextLine();
                                    System.out.println("wysokość:");
                                    height = scanner1.nextLine();
                                    thingSize = new ThingSize(Integer.parseInt(width), Integer.parseInt(length),
                                            Integer.parseInt(height));
                                }
                                Thing thing = new Thing(thingName, thingSize);
                                try {
                                    warehouseState.getWarehouseById(selectedWarehouse).addThing(thing);
                                } catch (TooManyThingsException tooManyThingsException) {
                                    System.out.println(tooManyThingsException);
                                }
                                break;


                        }
                    }
                    prompt();
                    break;

                case 5://usuniecie przedmiotu
                    if (selectedPerson == 0) {
                        System.out.println("W pierwszej kolejności należy wybrać najemcę");

                        //dopisac co jeseli najemca nie ma zadnego wynajetego pomieszczenie a chce wyjac przedmiot

                    } else {
                        System.out.println("wybierz przedmiot do usuniecia");
                        warehouseState.getWarehouseById(selectedWarehouse).warehouseContent(true);

                        int selectedItem = scanner.nextInt();
                        if (selectedItem == 0)
                            System.exit(0);

                        warehouseState.getWarehouseById(selectedWarehouse).removeThing(selectedItem);
                    }
                    prompt();
                    break;

                case 6://list wolnych pomieszczen
                    System.out.println("wolne pomieszczenia");
                    warehouseState.getWarehouseSet().stream().forEach(warehouseSpace -> {
                        if (warehouseSpace.isAvailable()) {
                            warehouseSpace.warehouseInfo();
                        }
                    });
                    prompt();
                    break;
                case 7://wynajecie pomieszczenia
                    if (selectedPerson == 0) {
                        System.out.println("W pierwszej kolejności należy wybrać najemcę");

                    } else {
                        System.out.println("wybierz pomieszczenie");
                        warehouseState.getWarehouseSet().stream().forEach(warehouseSpace -> {
                            if (warehouseSpace.isAvailable())
                                System.out.println(warehouseSpace.getWarehouseId() + " " + warehouseSpace.getArea());
                        });

                        selectedWarehouse = scanner.nextInt();
                        try {
                            warehouseState.getWarehouseById(selectedWarehouse).rentLocker(warehouseState.getPersonById(selectedPerson));

                        } catch (WarehouseIsRentedException e) {
                            System.out.println(e.getMessage());
                        }

                        System.out.println(warehouseState.getWarehouseById(selectedWarehouse).getArea() + "wynajete " +
                                "przez " + warehouseState.getPersonById(selectedPerson));
                    }

                    prompt();
                    break;

            }


        }
    }

    public static void prompt() {
        System.out.println("\n\nMenu: ");
        System.out.println("0 - zakonczenie programu");
        System.out.println("1 - wybierz najemcę");
        System.out.println("2 - wyświetl dane najemcy i wynajete pomieszczenia");
        System.out.println("3 - wybierz pomieszczenie najemcy i wyświetl jego zawartość");
        System.out.println("4 - umieść przedmiot w pomieszczeniu");
        System.out.println("5 - wyjmij przedmiot z pomieszczenia");
        System.out.println("6 - wyświetl wolne pomieszczenia");
        System.out.println("7 - wynajmij wolne pomieszczenie");
        System.out.println("8 - raport magazynu");
    }
}
