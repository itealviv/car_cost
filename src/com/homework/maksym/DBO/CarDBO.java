package com.homework.maksym.DBO;

import com.homework.maksym.controllers.Car;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class CarDBO{


    public CarDBO(){
    }

    public static Map<Integer, Car> getAllCars() throws SQLException {
        Map<Integer, Car> cars = new HashMap<Integer, Car>();

        QueryDBO q = new QueryBuider();
        q.select("*");
        q.from("newCar");
        ResultSet rs = q.getRes();

        while (rs.next()) {
            int id = rs.getInt(1);
            cars.put(id, carObject(rs));
        }
        q.closeRs(rs);
        return cars;
    }

    public static Car getSingleCar (Integer id) throws SQLException{
        QueryDBO q = new QueryBuider();
        q.select("*");
        q.from("newCar");
        q.where("id", id);
        ResultSet rs = q.getRes();

        Car car = carObject(rs);
        q.closeRs(rs);
        return car;
    }

    protected static Car carObject (ResultSet rs) throws SQLException{
            if(rs.getRow()==0)
                rs.first();
            int id = rs.getInt(1);
            String name = rs.getString(2);
            double price = rs.getDouble(3);

            Car car = new Car(id, name, price);
        return car;
    }
}
