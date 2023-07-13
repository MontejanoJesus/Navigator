package com.solvd.navigator.service.imple;

import com.solvd.navigator.dao.*;
import com.solvd.navigator.factory.AbstractFactory;
import com.solvd.navigator.factory.DaoType;
import com.solvd.navigator.factory.FactoryGenerator;
import com.solvd.navigator.factory.FactoryType;
import com.solvd.navigator.model.*;
import com.solvd.navigator.service.IService;

import java.util.List;

public class LocationService implements IService<Location> {

    private AbstractFactory daoFactory = FactoryGenerator.getFactory(FactoryType.JDBC);
    private ITransportationDAO transportationDAO = daoFactory.getDao(DaoType.TRANSPORTATION);
    private IRouteDAO routedao = daoFactory.getDao(DaoType.ROUTE);
    private ILocationDAO locationDAO = daoFactory.getDao(DaoType.LOCATION);
    private ITransportationTypeDAO transportationTypeDAO = daoFactory.getDao(DaoType.TRANSPORTATION_TYPE);

    private IPersonDAO personDAO = daoFactory.getDao(DaoType.PERSON);

    private IDriverLicenseDAO driverLicenseDAO = daoFactory.getDao(DaoType.DRIVER_LICENSE);


    @Override
    public Location getById(long id) {
        Location location = locationDAO.getById(id);
        List<Route> routeList = routedao.getAllRoutesByLocationId(id);


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
        location.setRoutes(routeList);


       return location;


    }

    @Override
    public List<Location> getAll() {

        List<Location> locationsList = locationDAO.getAll();
        List<Route> routeList = null;

        for(Location loca: locationsList) {
            routeList = routedao.getAllRoutesByLocationId(loca.getId());
            for (Route route : routeList) {

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
            loca.setRoutes(routeList);
        }


        return locationsList;


    }

    @Override
    public void insert(Location location) {
        locationDAO.insert(location);
    }

    @Override
    public void update(Location location) {
        locationDAO.update(location);
    }

    @Override
    public void delete(long id) {
        locationDAO.delete(id);
    }
}
