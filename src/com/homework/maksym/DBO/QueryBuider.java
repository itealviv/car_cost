package com.homework.maksym.DBO;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class QueryBuider <T> implements QueryDBO<T>, InsertDBO<Integer, T>{
    private static final String db = "jdbc:mariadb://localhost:3336/java";
    private String user;
    private String password;

    private static Connection con;
    private static Statement stmt;
    private ResultSet rs;

    private StringBuilder select = new StringBuilder();
    private StringBuilder where = new StringBuilder();
    private String from;
    private int limit = 0;
    private int offset = 0;

    public QueryBuider(){
        try (InputStream input = QueryBuider.class.getClassLoader().getResourceAsStream("DBO.properties")) {

            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }

            //load a properties file from class path, inside static method
            prop.load(input);

            //get the property value and print it out
            this.user = prop.getProperty("db.user");
            this.password = prop.getProperty("db.password");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public ResultSet getRes(){
        result();
        return rs;
    }

    public void select(String sel, String alias){
        select.append(sel);
        select.append(" as ");
        select.append(alias);
        select.append(",");
    }

    public void select(String sel){
        select.append(sel);
        select.append(",");
    }

    public void from(String from) {
        this.from = from;
    }

    //TODO
    //  add  <, =, > to clause
    //
    public void where(String whereN, T val){
        String value = val.toString();
        if(where.toString().length()>0){
            where.append(" AND ");
            where.append(whereN);
            where.append("=");
            where.append(value);
        } else {
            where.append(whereN);
            where.append("=");
            where.append(value);
        }
    }

    protected String query(){
        StringBuilder q = new StringBuilder();
        String sel = this.select.toString().substring(0,this.select.toString().length()-1);
        q.append("SELECT ");
        q.append(sel);
        q.append(" FROM ");
        q.append(from);
        q.append(" ");
        if(where.toString().length()>0){
            q.append(" WHERE ");
            q.append(where.toString());
        }

        if(limit>0)
            q.append(" LIMIT "+limit);
        if(offset>0)
            q.append(" OFFSET "+offset);
        return q.toString();
    }


    private void result(){

        String query = query();

        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(db, user, password);

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            rs = stmt.executeQuery(query);


        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
        }
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public void closeRs(ResultSet r){
        try { r.close(); } catch(SQLException se) { /*can't do anything */ }
    }

    public void insert(String table, Map<Integer, T> obj){
        Object o = obj.get(1);
        if(o==null)
            throw new NullPointerException("Null is not insertable object");
        StringBuilder query = new StringBuilder("INSERT INTO ");
        query.append(table);
        query.append(" VALUES(NULL,");

        for(Map.Entry<Integer, T> item : obj.entrySet()){
            query.append("\"");
            query.append(item.getValue());
            query.append("\",");
        }
        StringBuilder q = new StringBuilder(query.toString().substring(0, query.toString().length()-1));
        q.append(")");
        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(db, user, password);

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            rs = stmt.executeQuery(q.toString());


        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }


    }



}