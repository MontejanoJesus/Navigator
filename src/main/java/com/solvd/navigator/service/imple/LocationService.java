package com.solvd.navigator.service.imple;

import com.solvd.navigator.dao.*;
import com.solvd.navigator.factory.AbstractFactory;
import com.solvd.navigator.factory.FactoryGenerator;
import com.solvd.navigator.model.Location;
import com.solvd.navigator.model.Route;
import com.solvd.navigator.model.Transportation;
import com.solvd.navigator.service.ILocationService;

import java.util.List;

public class LocationService implements ILocationService {

    private AbstractFactory daoFactory = FactoryGenerator.getFactory("JDBC");
    private ITransportationDAO transportationDAO = daoFactory.getDao("Transportation");
    private IRouteDAO routedao = daoFactory.getDao("Route");
    private ILocationDAO locationDAO = daoFactory.getDao("Location");
    private IDriverDAO driverDAO = daoFactory.getDao("Driver");

    @Override
    public Location getById(long id) {

        Location location = locationDAO.getById(id);
        List<Route> routeList = routedao.getAllRoutesByLocationId(id);

        for(Route route: routeList){

            route.setLocationA(locationDAO.getById(route.getLocationA().getId()));
            route.setLocationB(locationDAO.getById(route.getLocationB().getId()));
            //Tae comment cause of error
           /*Transportation transportation = transportationDAO.getById(route.getTransportation().getId());
            transportation.setDriver(driverDAO.getById(transportation.getDriver().getId()));
            route.setTransportation(transportation); */

        }
        //Tae comment
        //location.setRoutes(routeList);

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
                //Tae comment cause of error
                /*Transportation transportation = transportationDAO.getById(route.getTransportation().getId());
                transportation.setDriver(driverDAO.getById(transportation.getDriver().getId()));
                route.setTransportation(transportation); */

            }
            //Tae comment
            //loca.setRoutes(routeList);
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
