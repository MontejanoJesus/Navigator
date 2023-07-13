package com.solvd.navigator.service.imple;

import com.solvd.navigator.dao.*;
import com.solvd.navigator.factory.AbstractFactory;
import com.solvd.navigator.factory.DaoType;
import com.solvd.navigator.factory.FactoryGenerator;
import com.solvd.navigator.factory.FactoryType;
import com.solvd.navigator.model.DriverLicense;
import com.solvd.navigator.model.Person;
import com.solvd.navigator.model.Route;
import com.solvd.navigator.model.Transportation;
import com.solvd.navigator.service.IService;

import java.util.List;

public class RouteService implements IService<Route> {

    private AbstractFactory daoFactory = FactoryGenerator.getFactory(FactoryType.JDBC);
    private ITransportationDAO transportationDAO = daoFactory.getDao(DaoType.TRANSPORTATION);
    private IRouteDAO routedao = daoFactory.getDao(DaoType.ROUTE);
    private ILocationDAO locationDAO = daoFactory.getDao(DaoType.LOCATION);
    private ITransportationTypeDAO transportationTypeDAO = daoFactory.getDao(DaoType.TRANSPORTATION_TYPE);
    private IPersonDAO personDAO = daoFactory.getDao(DaoType.PERSON);

    private IDriverLicenseDAO driverLicenseDAO = daoFactory.getDao(DaoType.DRIVER_LICENSE);

    @Override
    public Route getById(long id) {

        Route route = routedao.getById(id);
        route.setLocationA(locationDAO.getById(route.getLocationA().getId()));
        route.setLocationB(locationDAO.getById(route.getLocationB().getId()));
        Transportation transportation = transportationDAO.getById(route.getTransportation().getId());
        Person person = personDAO.getDriverById(transportation.getDriver().getId());
        DriverLicense dl = driverLicenseDAO.getById(person.getDriverLicense().getId());
        person.setDriverLicense(dl);
        transportation.setTransportationType(transportationTypeDAO.getById(transportation.getTransportationType().getId()));
        transportation.setDriver(person);
        route.setTransportation(transportation);
        return route;
    }

    @Override
    public List<Route> getAll() {
       List<Route> routeList = routedao.getAll();
       for(Route route: routeList){

           route.setLocationA(locationDAO.getById(route.getLocationA().getId()));
           route.setLocationB(locationDAO.getById(route.getLocationB().getId()));
           Transportation transportation = transportationDAO.getById(route.getTransportation().getId());
           Person person = personDAO.getDriverById(transportation.getDriver().getId());
           DriverLicense dl = driverLicenseDAO.getById(person.getDriverLicense().getId());
           person.setDriverLicense(dl);
           transportation.setTransportationType(transportationTypeDAO.getById(transportation.getTransportationType().getId()));
           transportation.setDriver(person);
           route.setTransportation(transportation);

       }
       return routeList;

    }

    @Override
    public void insert(Route route) {
        routedao.insert(route);
    }

    @Override
    public void update(Route route) {
        routedao.update(route);
    }

    @Override
    public void delete(long id) {
        routedao.delete(id);
    }
}
