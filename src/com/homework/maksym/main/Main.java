package com.homework.maksym.main;

import com.homework.maksym.controllers.*;

import java.sql.SQLException;
import java.util.Scanner;


public class Main{
    int car;
    int year;
    int engine;
    int country;

    Main() throws SQLException {
        car = UserChoose.chooseCar();
        year = UserChoose.chooseYear();
        country = UserChoose.chooseCountry();
        engine = UserChoose.chooseEngine();
        System.out.println(new Result(car,country,engine,year, true));
    }

    public static void main(String[] args)  throws SQLException {
        new Main();
        System.out.println("Хочете переглянути всі результати?");
        String choose = new Scanner(System.in).next("y|Y|n|N");
        if (choose.equalsIgnoreCase("Y"))
            UserChoose.getAllResults();
    }
}
