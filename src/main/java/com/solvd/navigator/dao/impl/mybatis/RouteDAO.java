package com.solvd.navigator.dao.impl.mybatis;

import com.solvd.navigator.dao.IRouteDAO;
import com.solvd.navigator.model.Route;

import java.util.List;

public class RouteDAO extends MyBatisDAO implements IRouteDAO {

    @Override
    public Route getById(long id) {
        return executeWithSession(session -> {
            IRouteDAO routeMapper = session.getMapper(IRouteDAO.class);
            return routeMapper.getById(id);
        });
    }

    @Override
    public List<Route> getAll() {
        return executeWithSession(session -> {
            IRouteDAO routeMapper = session.getMapper(IRouteDAO.class);
            return routeMapper.getAll();
        });
    }

    @Override
    public void insert(Route route) {
        executeWithSession(session -> {
            IRouteDAO routeMapper = session.getMapper(IRouteDAO.class);
            routeMapper.insert(route);
            return null;
        });
    }

    @Override
    public void update(Route route) {
        executeWithSession(session -> {
            IRouteDAO routeMapper = session.getMapper(IRouteDAO.class);
            routeMapper.update(route);
            return null;
        });
    }

    @Override
    public void delete(long id) {
        executeWithSession(session -> {
            IRouteDAO routeMapper = session.getMapper(IRouteDAO.class);
            routeMapper.delete(id);
            return null;
        });
    }

    @Override
    public Route getRouteByLocationsId(long locationAId, long locationBId) {
        return executeWithSession(session -> {
            IRouteDAO routeMapper = session.getMapper(IRouteDAO.class);
            return routeMapper.getRouteByLocationsId(locationAId, locationBId);
        });
    }

    @Override
    public List<Route> getAllRoutesByLocationId(long locationId) {
        return executeWithSession(session -> {
            IRouteDAO routeMapper = session.getMapper(IRouteDAO.class);
            return routeMapper.getAllRoutesByLocationId(locationId);
        });
    }
}
