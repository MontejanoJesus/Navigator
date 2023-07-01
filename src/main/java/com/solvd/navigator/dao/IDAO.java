package com.solvd.navigator.dao;

import java.util.List;

public interface IDAO<T> {
    T getById(long id);
    List<T> getAll();
    void insert(T t);
    void update(long id);
    void delete(long id);
}