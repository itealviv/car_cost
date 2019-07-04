package com.homework.maksym.DBO;

import com.homework.maksym.controllers.Result;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ResultsDBO {

    public static Map<Integer, Result> getAllResults() throws SQLException {
        Map<Integer, Result> results = new HashMap<Integer, Result>();

        QueryDBO q = new QueryBuider();
        q.select("*");
        q.from("cars");
        ResultSet rs = q.getRes();

        while (rs.next()) {
            int id = rs.getInt(1);
            results.put(id, resultObj(rs));
        }
        q.closeRs(rs);
        return results;
    }

    protected static Result resultObj (ResultSet rs) throws SQLException{
        if(rs.getRow()==0)
            rs.first();
        int carId = rs.getInt(2);
        int ctry = rs.getInt(4);
        int engn = rs.getInt(6);
        int year = rs.getInt(7);

        Result resObj = new Result(carId, ctry, engn,year, false);
        return resObj;
    }

}
