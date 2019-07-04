package com.homework.maksym.controllers;

public class Engine {
    private int id;
    private Double engine;

    public Engine(int id, Double engine) {
        this.id = id;
        this.engine = engine;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getEngine() {
        return engine;
    }

    public void setEngine(Double engine) {
        this.engine = engine;
    }
}
