package com.homework.maksym.controllers;

public class Car {
    protected int id;
    protected String name;
    protected String year;
    protected String country;
    protected Double price;
    protected double engine;

    public Car(int id, String name, double price) {
        this.name = name;
        this.price = price;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setEngine(double engine) {
        this.engine = engine;
    }

    public String getYear() {
        return year;
    }

    public String getCountry() {
        return country;
    }

    public double getPrice() {
        return price;
    }

    public double getEngine() {
        return engine;
    }
}
