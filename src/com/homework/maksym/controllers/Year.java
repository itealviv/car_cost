package com.homework.maksym.controllers;

public class Year {
    protected int id;
    protected String year;
    protected double vat;

    public Year(int id, String year, double vat) {
        this.year = year;
        this.id = id;
        this.vat = vat;
    }

    public String getYear() {
        return year;
    }

    public int getId() {
        return id;
    }

    public double getVat() {
        return vat;
    }
}
