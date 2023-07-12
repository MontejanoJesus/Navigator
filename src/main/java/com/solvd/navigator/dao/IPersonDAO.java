package com.solvd.navigator.dao;

import com.solvd.navigator.model.Person;
import java.util.List;

public interface IPersonDAO extends IDAO<Person>{
    Person getDriverById(long id);
    List<Person> getAllDrivers();
    void insertDriver(Person person);
    void updateDriver(Person person);

}
