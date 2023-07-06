package com.solvd.navigator.service;

import java.util.List;

public interface IService<T> {

    T getById(long id);

    List<T> getAll();

    void insert(T t);

    void update(T t);

    void delete(long id);



}
