package com.company;

import com.company.exceptions.TooManyThingsException;

import java.util.Scanner;

public class Info {

    ThingSize thingSize;
    Scanner scanner1;

    public void getDimension() {
        String width, length, height;
        scanner1 = new Scanner(System.in);
        width = scanner1.nextLine();
        System.out.println("podaj długosc");
        length = scanner1.nextLine();
        System.out.println("podaj wysokosc");
        height = scanner1.nextLine();
        thingSize = new ThingSize(Integer.parseInt(width),
                Integer.parseInt(length),
                Integer.parseInt(height));
    }

    public void getVolume() {
        System.out.println("objetosc: ");
        int size = scanner1.nextInt();
        thingSize = new ThingSize(size);
    }
}
