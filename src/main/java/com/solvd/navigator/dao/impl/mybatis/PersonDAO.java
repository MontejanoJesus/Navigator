package com.solvd.navigator.dao.impl.mybatis;

import com.solvd.navigator.dao.IDAO;
import com.solvd.navigator.dao.IPersonDAO;
import com.solvd.navigator.model.Person;

import java.util.List;

public class PersonDAO extends MyBatisDAO implements IPersonDAO {
    @Override
    public Person getDriverById(long id) {
        return executeWithSession(session -> {
            IPersonDAO personMapper = session.getMapper(IPersonDAO.class);
            return personMapper.getDriverById(id);
        });
    }

    @Override
    public List<Person> getAllDrivers() {
        return executeWithSession(session -> {
            IPersonDAO personMapper = session.getMapper(IPersonDAO.class);
            return personMapper.getAllDrivers();
        });
    }

    @Override
    public void insertDriver(Person person) {
        executeWithSession(session -> {
            IPersonDAO personMapper = session.getMapper(IPersonDAO.class);
            personMapper.insertDriver(person);
            return null;
        });
    }

    @Override
    public void updateDriver(Person person) {
        executeWithSession(session -> {
            IPersonDAO personMapper = session.getMapper(IPersonDAO.class);
            personMapper.updateDriver(person);
            return null;
        });
    }

    @Override
    public Person getById(long id) {
        return executeWithSession(session -> {
            IPersonDAO personMapper = session.getMapper(IPersonDAO.class);
            return personMapper.getById(id);
        });
    }

    @Override
    public List<Person> getAll() {
        return executeWithSession(session -> {
            IPersonDAO personMapper = session.getMapper(IPersonDAO.class);
            return personMapper.getAll();
        });
    }

    @Override
    public void insert(Person person) {
        executeWithSession(session -> {
            IPersonDAO personMapper = session.getMapper(IPersonDAO.class);
            personMapper.insert(person);
            return null;
        });
    }

    @Override
    public void update(Person person) {
        executeWithSession(session -> {
            IPersonDAO personMapper = session.getMapper(IPersonDAO.class);
            personMapper.update(person);
            return null;
        });
    }

    @Override
    public void delete(long id) {
        executeWithSession(session -> {
            IPersonDAO personMapper = session.getMapper(IPersonDAO.class);
            personMapper.delete(id);
            return null;
        });
    }
}
