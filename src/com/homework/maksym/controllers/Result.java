package com.homework.maksym.controllers;

import com.homework.maksym.DBO.*;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Result {
    private Car car;
    private Country country;
    private Engine engine;
    private Year year;
    private double priceWithCustomsAndVat;

    public Result(int car, int country, int engine, int year, Boolean save) throws SQLException {
        this.car = CarDBO.getSingleCar(car);
        this.country = CountryDBO.getSingleCountry(country);
        this.engine = EngineDBO.getSingleengine(engine);
        this.year = YearDBO.getSingleYear(year);
        this.priceWithCustomsAndVat = priceWithCustomsAndVat();
        if(save)
            saveResult();
    }

    private Double priceWithCustomsAndVat(){
        double price = car.getPrice();
        double engineTmp = engine.getEngine();
        double yearVat = year.getVat();
        double countryVat = country.getVat();
        double result = ((engineTmp*1000*yearVat)+price)*countryVat;
        return result;
    }

    private void saveResult(){
        InsertDBO i = new QueryBuider();
        String carName = car.getName();
        Integer carId = car.getId();
        Integer yr = year.getId();
        Integer ctry = country.getId();
        Integer eng = engine.getId();
        Double carPrice = car.getPrice();
        Map<Integer, Object> insertObj = new HashMap<Integer, Object>();
        insertObj.put(0,carId);
        insertObj.put(1,carName);
        insertObj.put(2,ctry);
        insertObj.put(3,priceWithCustomsAndVat);
        insertObj.put(4,eng);
        insertObj.put(5,yr);
        insertObj.put(6,carPrice);
        i.insert("cars", insertObj);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Ви вибрали авто ");
        res.append(car.getName());
        res.append(" за ціною $");
        res.append(car.getPrice());
        res.append(" з ");
        res.append(country.getName());
        res.append(" з двигуном ");
        res.append(engine.getEngine());
        res.append(" ");
        res.append(year.getYear());
        res.append("-го року, його ціна з розмитненням = $");
        DecimalFormat decimalFormat = new DecimalFormat("0.##");
        res.append(decimalFormat.format(priceWithCustomsAndVat));
        return res.toString();
    }
}
