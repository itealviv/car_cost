package com.homework.maksym.DBO;

import com.homework.maksym.controllers.Year;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class YearDBO {

    public YearDBO(){

    }

    public static Map<Integer, Year> getAllYears() throws SQLException {
        Map<Integer, Year> years = new HashMap<Integer, Year>();

        QueryDBO q = new QueryBuider();
        q.select("*");
        q.from("years");
        ResultSet rs = q.getRes();

        while (rs.next()) {
            int id = rs.getInt(1);
            years.put(id, yearObject(rs));
        }
        q.closeRs(rs);
        return years;
    }

    public static Year getSingleYear (Integer id) throws SQLException{
        QueryDBO q = new QueryBuider();
        q.select("*");
        q.from("years");
        q.where("id", id);
        ResultSet rs = q.getRes();

        Year year = yearObject(rs);
        q.closeRs(rs);
        return year;
    }


    protected static Year yearObject (ResultSet rs) throws SQLException{
        if(rs.getRow()==0)
            rs.first();
        int id = rs.getInt(1);
        String year = rs.getString(2);
        double vat = rs.getDouble(3);

        Year yearObj = new Year(id, year, vat);
        return yearObj;
    }
}
