package com.solvd.navigator.dao.impl.mybatis;

import com.solvd.navigator.dao.ILocationDAO;
import com.solvd.navigator.model.Location;

import java.util.List;

public class LocationDAO extends MyBatisDAO implements ILocationDAO{

    @Override
    public Location getById(long id) {
        return executeWithSession(session -> {
            ILocationDAO locationMapper = session.getMapper(ILocationDAO.class);
            return locationMapper.getById(id);
        });
    }

    @Override
    public List<Location> getAll() {
        return executeWithSession(session -> {
            ILocationDAO locationMapper = session.getMapper(ILocationDAO.class);
            return locationMapper.getAll();
        });
    }

    @Override
    public void insert(Location location) {
        executeWithSession(session -> {
            ILocationDAO locationMapper = session.getMapper(ILocationDAO.class);
            locationMapper.insert(location);
            return null;
        });
    }

    @Override
    public void update(Location location) {
        executeWithSession(session -> {
            ILocationDAO locationMapper = session.getMapper(ILocationDAO.class);
            locationMapper.update(location);
            return null;
        });
    }

    @Override
    public void delete(long id) {
        executeWithSession(session -> {
            ILocationDAO locationMapper = session.getMapper(ILocationDAO.class);
            locationMapper.delete(id);
            return null;
        });
    }
}
