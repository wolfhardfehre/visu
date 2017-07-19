package com.nicefontaine.models;

public class CoordinateModel {

    private int[] xy = new int[] {0, 0};

    public synchronized void set(int[] xy) {
        this.xy = xy;
    }

    public synchronized int[] get() {
        return xy;
    }
}
