package com.homework.maksym.DBO;

import com.homework.maksym.controllers.Country;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class CountryDBO {
    public CountryDBO(){

    }

    public static Map<Integer, Country> getAllCountries() throws SQLException {
        Map<Integer, Country> countries = new HashMap<Integer, Country>();

        QueryDBO q = new QueryBuider();
        q.select("*");
        q.from("country");
        ResultSet rs = q.getRes();

        while (rs.next()) {
            int id = rs.getInt(1);
            countries.put(id, countryObject(rs));
        }
        q.closeRs(rs);
        return countries;
    }

    public static Country getSingleCountry (Integer id) throws SQLException{
        QueryDBO q = new QueryBuider();
        q.select("*");
        q.from("country");
        q.where("id", id);
        ResultSet rs = q.getRes();

        Country ctry = countryObject(rs);
        q.closeRs(rs);
        return ctry;
    }


    protected static Country countryObject (ResultSet rs) throws SQLException{
        if(rs.getRow()==0)
            rs.first();
        int id = rs.getInt(1);
        String name = rs.getString(2);
        Double vat = rs.getDouble(3);

        Country countryObj = new Country(id, vat, name);
        return countryObj;
    }
}
