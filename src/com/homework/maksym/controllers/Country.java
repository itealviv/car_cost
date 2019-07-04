package com.homework.maksym.controllers;

public class Country {
    private int id;
    private double vat;
    private String name;

    public Country(int id, double vat, String name) {
        this.id = id;
        this.vat = vat;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public Double getVat() {
        return vat;
    }

    public String getName() {
        return name;
    }
}
