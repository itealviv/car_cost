package com.homework.maksym.DBO;

import java.util.Map;

public interface InsertDBO<Integer, T>  {
    public void insert(String table, Map<Integer, T> obj);
}
