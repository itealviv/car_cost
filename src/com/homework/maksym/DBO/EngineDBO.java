package com.homework.maksym.DBO;

import com.homework.maksym.controllers.Engine;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class EngineDBO {
    public EngineDBO(){}

    public static Map<Integer, Engine> getAllEngines() throws SQLException {
        Map<Integer, Engine> engines = new HashMap<Integer, Engine>();

        QueryDBO q = new QueryBuider();
        q.select("*");
        q.from("engines");
        ResultSet rs = q.getRes();

        while (rs.next()) {
            int id = rs.getInt(1);
            engines.put(id, engineObject(rs));
        }
        q.closeRs(rs);
        return engines;
    }

    public static Engine getSingleengine (Integer id) throws SQLException{
        QueryDBO q = new QueryBuider();
        q.select("*");
        q.from("engines");
        q.where("id", id);
        ResultSet rs = q.getRes();

        Engine eng = engineObject(rs);
        q.closeRs(rs);
        return eng;
    }


    protected static Engine engineObject (ResultSet rs) throws SQLException{
        if(rs.getRow()==0)
            rs.first();
        int id = rs.getInt(1);
        Double engine = rs.getDouble(2);

        Engine engineObj = new Engine(id, engine);
        return engineObj;
    }
}
