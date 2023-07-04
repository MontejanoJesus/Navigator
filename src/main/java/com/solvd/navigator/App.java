package com.solvd.navigator;

import com.solvd.navigator.connection.ConnectionPool;
import com.solvd.navigator.dao.IDriverDAO;
import com.solvd.navigator.dao.ILocationDAO;
import com.solvd.navigator.dao.ITransportationDAO;
import com.solvd.navigator.dao.impl.mybatis.DriverDAO;
import com.solvd.navigator.dao.impl.mybatis.LocationDAO;
import com.solvd.navigator.dao.impl.mybatis.TransportationDAO;
import com.solvd.navigator.model.Driver;
import com.solvd.navigator.model.Location;
import com.solvd.navigator.model.Transportation;
import org.apache.logging.log4j.Logger;
import java.util.Random;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class App {
    private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger(App.class);
    private static final Random random = new Random();

    public static void main(String[] args) {
        //  connectionPoolTest();
        myBatisTransportationTest();
    }

    public static void connectionPoolTest(){
        // Create an instance of ConnectionPool with a desired pool size
        ConnectionPool connectionPool = ConnectionPool.getInstance(5);

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

    public static void myBatisDriverTest(){
        // Test DriverDAO
        long id1 = Math.abs(random.nextLong());
        long id2 = Math.abs(random.nextLong());
        IDriverDAO driverDAO = new DriverDAO();
        Driver driver = new Driver();
        Driver driver2 = new Driver();
        driver.setId(id1);
        driver2.setId(id2);
        driver2.setName("Jack");
        driver.setName("John");

        driverDAO.insert(driver);
        logger.info(driverDAO.getById(id1).toString() + "\n");

        driver.setName("Bob");
        driverDAO.update(driver);
        logger.info(driverDAO.getById(id1).toString() + "\n");

        driverDAO.insert(driver2);
        logger.info(driverDAO.getAll().toString() + "\n");

        driverDAO.delete(id1);
        driverDAO.delete(id2);
    }

    private static void myBatisLocationTest() {
        // Test LocationDAO, route list is initialized in service layer
        long id1 = Math.abs(random.nextLong());
        long id2 = Math.abs(random.nextLong());
        ILocationDAO locationDAO = new LocationDAO();
        Location location1 = new Location();
        Location location2 = new Location();
        location1.setId(id1);
        location2.setId(id2);
        location1.setName("New York");
        location2.setName("Los Angeles");

        locationDAO.insert(location1);
        logger.info(locationDAO.getById(id1).toString() + "\n");

        location1.setName("Chicago");
        locationDAO.update(location1);
        logger.info(locationDAO.getById(id1).toString() + "\n");

        locationDAO.insert(location2);
        logger.info(locationDAO.getAll().toString() + "\n");

        locationDAO.delete(id1);
        locationDAO.delete(id2);
    }

    private static void myBatisTransportationTest(){
        // Test TransportationDAO
        long id1 = Math.abs(random.nextLong());
        long id2 = Math.abs(random.nextLong());
        long id3 = Math.abs(random.nextLong());
        ITransportationDAO transportationDAO = new TransportationDAO();
        Transportation transportation1 = new Transportation();
        Transportation transportation2 = new Transportation();
        transportation1.setId(id1);
        transportation2.setId(id2);
        transportation1.setName("Bus");
        transportation2.setName("Train");

        IDriverDAO driverDAO = new DriverDAO();
        Driver driver = new Driver();
        driver.setId(id3);
        driver.setName("John");

        transportation1.setDriver(driver);
        transportation2.setDriver(driver);

        driverDAO.insert(driver);
        transportationDAO.insert(transportation1);
        logger.info(transportationDAO.getById(id1).toString() + "\n");

        transportation1.setName("Plane");
        transportationDAO.update(transportation1);
        logger.info(transportationDAO.getById(id1).toString() + "\n");

        transportationDAO.insert(transportation2);
        logger.info(transportationDAO.getAll().toString() + "\n");

        transportationDAO.delete(id1);
        transportationDAO.delete(id2);
        driverDAO.delete(id3);
    }

    private static void myBatisRouteTest(){

    }
}
