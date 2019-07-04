package com.homework.maksym.main;

import com.homework.maksym.DBO.*;
import com.homework.maksym.controllers.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;

public interface UserChoose {

    static int chooseCar() throws SQLException {

        Map<Integer, Car> cars = CarDBO.getAllCars();
        System.out.println("Choose car:");
        int start = 999;
        int end = 0;
        for(Map.Entry<Integer, Car> item : cars.entrySet()){
            if(item.getKey()<start)
                start = item.getKey();
            if(item.getKey()>end)
                end = item.getKey();
            System.out.printf("%s:  %s $%g \n", item.getKey(), item.getValue().getName(), item.getValue().getPrice());
        }
        System.out.printf("[%s-%s] : \n", start, end);
        int choose = new Scanner(System.in).nextInt();
        return choose;
    }

    static int chooseYear() throws SQLException {
        Map <Integer, Year> cars = YearDBO.getAllYears();
        System.out.println("Choose year:");
        int start = 999;
        int end = 0;
        for(Map.Entry<Integer, Year> item : cars.entrySet()){
            if(item.getKey()<start)
                start = item.getKey();
            if(item.getKey()>end)
                end = item.getKey();
            System.out.printf("%s:  %s \n", item.getKey(), item.getValue().getYear());
        }
        System.out.printf("[%s-%s] : \n", start, end);
        int choose = new Scanner(System.in).nextInt();
        return choose;
    }

    static int chooseCountry() throws SQLException {

        Map<Integer, Country> countries = CountryDBO.getAllCountries();
        System.out.println("Choose country:");
        int start = 999;
        int end = 0;
        for(Map.Entry<Integer, Country> item : countries.entrySet()){
            if(item.getKey()<start)
                start = item.getKey();
            if(item.getKey()>end)
                end = item.getKey();
            System.out.printf("%s:  %s \n", item.getKey(), item.getValue().getName());
        }
        System.out.printf("[%s-%s] : \n", start, end);
        int choose = new Scanner(System.in).nextInt();
        return choose;
    }

    static int chooseEngine() throws SQLException {

        Map<Integer, Engine> engines = EngineDBO.getAllEngines();
        System.out.println("Choose engine:");
        int start = 999;
        int end = 0;
        for(Map.Entry<Integer, Engine> item : engines.entrySet()){
            if(item.getKey()<start)
                start = item.getKey();
            if(item.getKey()>end)
                end = item.getKey();
            System.out.printf("%s:  %s \n", item.getKey(), item.getValue().getEngine());
        }
        System.out.printf("[%s-%s] : \n", start, end);
        int choose = new Scanner(System.in).nextInt();
        return choose;
    }

    public static void getAllResults() throws SQLException{
        Map<Integer, Result> results = ResultsDBO.getAllResults();
        for(Map.Entry<Integer, Result> item : results.entrySet()){
            System.out.println(item.getValue());
        }
    }
}
