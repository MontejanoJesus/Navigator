package com.solvd.navigator.dao.impl.mybatis;

import com.solvd.navigator.dao.IDriverDAO;

import java.util.List;

public class DriverDAO{

}
//Tae
/*
public class DriverDAO extends MyBatisDAO implements IDriverDAO {
    @Override
    public Driver getById(long id) {
        return null;
    }

    @Override
    public List<Driver> getAll() {
        return null;
    }

    @Override
    public void insert(Driver driver) {

    }

    @Override
    public void update(Driver driver) {

    }

    @Override
    public void delete(long id) {

    }
   /* @Override
    public Driver getById(long id) {
        return null;
    }

    @Override
    public List<Driver> getAll() {
        return null;
    }

    @Override
    public void insert(Driver driver) {

    }

    @Override
    public void update(Driver driver) {

    }

    @Override
    public void delete(long id) {

    }
   @Override
    public Driver getById(long id) {
        return executeWithSession((session) -> {
            IDriverDAO driverMapper = session.getMapper(IDriverDAO.class);
            return driverMapper.getById(id);
        });
    }

    @Override
    public List<Driver> getAll() {
        return executeWithSession((session) -> {
            IDriverDAO driverMapper = session.getMapper(IDriverDAO.class);
            return driverMapper.getAll();
        });
    }

    @Override
    public void insert(Driver driver) {
        executeWithSession((session) -> {
            IDriverDAO driverMapper = session.getMapper(IDriverDAO.class);
            driverMapper.insert(driver);
            return null;
        });
    }

    @Override
    public void update(Driver driver) {
        executeWithSession((session) -> {
            IDriverDAO driverMapper = session.getMapper(IDriverDAO.class);
            driverMapper.update(driver);
            return null;
        });
    }

    @Override
    public void delete(long id) {
        executeWithSession((session) -> {
            IDriverDAO driverMapper = session.getMapper(IDriverDAO.class);
            driverMapper.delete(id);
            return null;
        });
    }

}*/
