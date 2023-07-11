package com.solvd.navigator;

import com.solvd.navigator.connection.ConnectionPool;
import com.solvd.navigator.dao.*;
import com.solvd.navigator.dao.impl.mybatis.DriverDAO;
import com.solvd.navigator.dao.impl.mybatis.LocationDAO;
import com.solvd.navigator.dao.impl.mybatis.TransportationDAO;
import com.solvd.navigator.dao.impl.mybatis.RouteDAO;
import com.solvd.navigator.factory.AbstractFactory;
import com.solvd.navigator.factory.FactoryGenerator;
import com.solvd.navigator.model.Driver;
import com.solvd.navigator.model.Location;
import com.solvd.navigator.model.Route;
import com.solvd.navigator.model.Transportation;
import com.solvd.navigator.service.ILocationService;
import com.solvd.navigator.service.IRouteService;
import com.solvd.navigator.service.ServiceTesting;
import com.solvd.navigator.service.imple.LocationService;
import com.solvd.navigator.service.imple.RouteService;
import com.solvd.navigator.service.imple.TransportationService;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Random;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class App {
    private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger(App.class);
    private static final Random random = new Random();

    public static void main(String[] args) {

//        ServiceTesting.driverCRUD();
//        ServiceTesting.locationCRUD();
//        ServiceTesting.transportationCRUD();
//        ServiceTesting.routeCRUD();

        //connectionPoolTest();
        //myBatisDriverTest();
        //myBatisLocationTest();
        //myBatisTransportationTest();
        //myBatisRouteTest();
    }

    private static void connectionPoolTest(){
        // Create an instance of ConnectionPool with a desired pool size
        ConnectionPool connectionPool = ConnectionPool.getInstance();

        try {
            // Acquire a connection from the pool
            Connection connection = connectionPool.getConnection();

            // Ensure the connection is not null
            if (connection != null) {
                logger.info("Connection acquired successfully!\n");

                // Release the connection back to the pool
                connectionPool.releaseConnection(connection);
                logger.info("Connection released successfully!");
            } else {
                logger.info("Failed to acquire connection from the pool.");
            }
        } catch (InterruptedException | SQLException | IOException e) {
            logger.error("Failed to acquire/release connection from the pool.", e);
        }
    }

    private static void myBatisPersonTest(){
        // Test DriverDAO
        IPersonDAO personDAO = new PersonDAO();
        Driver driver = createDriver("John");
        Driver driver2 = createDriver("Jack");

        try{
            driverDAO.insert(driver);
            logger.info(driverDAO.getById(driver.getId()).toString() + "\n");

            driver.setName("Bob");
            driverDAO.update(driver);
            logger.info(driverDAO.getById(driver.getId()).toString() + "\n");

            driverDAO.insert(driver2);
            logger.info(driverDAO.getAll().toString() + "\n");
        }catch (Exception e){
            logger.error(e);
        }finally {
            driverDAO.delete(driver.getId());
            driverDAO.delete(driver2.getId());
        }
    }

    private static void myBatisLocationTest() {
        // Test LocationDAO, route list is initialized in service layer
        ILocationDAO locationDAO = new LocationDAO();
        Location location1 = createLocation("New York");
        Location location2 = createLocation("Los Angeles");

        try {
            locationDAO.insert(location1);
            logger.info(locationDAO.getById(location1.getId()).toString() + "\n");

            location1.setName("Chicago");
            locationDAO.update(location1);
            logger.info(locationDAO.getById(location1.getId()).toString() + "\n");

            locationDAO.insert(location2);
            logger.info(locationDAO.getAll().toString() + "\n");
        }catch (Exception e){
            logger.error(e);
        }finally {
            locationDAO.delete(location1.getId());
            locationDAO.delete(location2.getId());
        }
    }

    private static void myBatisTransportationTest(){
        // Test TransportationDAO
        IDriverDAO driverDAO = new DriverDAO();
        Driver driver = createDriver("John");

        ITransportationDAO transportationDAO = new TransportationDAO();
        Transportation transportation1 = createTransportation("Bus", driver);
        Transportation transportation2 = createTransportation("Train", driver);

        try {
            driverDAO.insert(driver);
            transportationDAO.insert(transportation1);
            logger.info(transportationDAO.getById(transportation1.getId()).toString() + "\n");

            transportation1.setName("Plane");
            transportationDAO.update(transportation1);
            logger.info(transportationDAO.getById(transportation1.getId()).toString() + "\n");

            transportationDAO.insert(transportation2);
            logger.info(transportationDAO.getAll().toString() + "\n");
        }catch (Exception e){
            logger.error(e);
        }finally {
            transportationDAO.delete(transportation1.getId());
            transportationDAO.delete(transportation2.getId());
            driverDAO.delete(driver.getId());
        }
    }

    private static void myBatisRouteTest(){
        IDriverDAO driverDAO = new DriverDAO();
        Driver driver = createDriver("John");

        ITransportationDAO transportationDAO = new TransportationDAO();
        Transportation transportation = createTransportation("Bus", driver);
        Transportation transportation2 = createTransportation("Train", driver);

        ILocationDAO locationDAO = new LocationDAO();
        Location locationA = createLocation("New York");
        Location locationB = createLocation("Los Angeles");

        IRouteDAO routeDAO = new RouteDAO();
        Route route = createRoute(locationA, locationB, transportation, 10, 100, 1000);
        Route route2 = createRoute(locationB, locationA, transportation, 10, 100, 1500);

        try{
            driverDAO.insert(driver);
            transportationDAO.insert(transportation);
            transportationDAO.insert(transportation2);
            locationDAO.insert(locationA);
            locationDAO.insert(locationB);
            routeDAO.insert(route);
            logger.info(routeDAO.getById(route.getId()) + "\n");

            route.setTransportation(transportation2);
            routeDAO.update(route);
            logger.info(routeDAO.getById(route.getId()) + "\n");

            routeDAO.insert(route2);
            logger.info(routeDAO.getAll() + "\n");
        }catch (Exception e) {
            logger.error(e);
        }finally {
            routeDAO.delete(route.getId());
            routeDAO.delete(route2.getId());
            transportationDAO.delete(transportation.getId());
            transportationDAO.delete(transportation2.getId());
            driverDAO.delete(driver.getId());
            locationDAO.delete(locationA.getId());
            locationDAO.delete(locationB.getId());
        }


    }

    // Helpers for creating model objects
    private static Driver createDriver(String name){
        long id = Math.abs(random.nextLong());
        Driver driver = new Driver();
        driver.setId(id);
        driver.setName(name);
        return driver;
    }

    private static Transportation createTransportation(String name, Driver driver){
        long id = Math.abs(random.nextLong());
        Transportation transportation = new Transportation();
        transportation.setId(id);
        transportation.setName(name);
        transportation.setDriver(driver);
        return transportation;
    }

    private static Location createLocation(String name){
        long id = Math.abs(random.nextLong());
        Location location = new Location();
        location.setId(id);
        location.setName(name);
        return location;
    }

    private static Route createRoute(Location locationA, Location locationB, Transportation transportation, int duration, int distance, int cost){
        long id = Math.abs(random.nextLong());
        Route route = new Route();
        route.setId(id);
        route.setLocationA(locationA);
        route.setLocationB(locationB);
        route.setTransportation(transportation);
        route.setDuration(duration);
        route.setDistance(distance);
        route.setCost(cost);
        return route;
    }
}
