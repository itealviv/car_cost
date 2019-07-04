package com.homework.maksym.DBO;

import java.sql.ResultSet;

public interface QueryDBO<T> {

    public void select(String sel);
    public void from (String from);
    public void where(String whereN, T val);
    public ResultSet getRes();
    public void closeRs(ResultSet r);
    public void setLimit(int limit);
    public void setOffset (int offset);
}
