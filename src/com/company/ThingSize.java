package com.company;

public class ThingSize {

    private int width;
    private int lenght;
    private int height;
    private int size;
//
//    public ThingSize(int width, int lenght, int height) {
//        this.width = width;
//        this.lenght = lenght;
//        this.height = height;
//        this.size = width * lenght * height;
//    }

    public ThingSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
    public float getVolume() {
        return this.size;
    }
}
