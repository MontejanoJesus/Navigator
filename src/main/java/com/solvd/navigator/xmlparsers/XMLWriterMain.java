package com.solvd.navigator.xmlparsers;

import com.solvd.navigator.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class XMLWriterMain {
/*
    private static final Logger logger = LogManager.getLogger("XMLWriterMain");

    public static void main(String[] args) {
        Result result = new Result();

        Driver driver = new Driver();
        driver.setName("Noah");
        driver.setId(1l);

        Transportation transportation= new Transportation();
        transportation.setDriver(driver);
        transportation.setId(1l);
        transportation.setName("Bus");

        Location locationA = new Location();
        locationA.setName("NY");
        locationA.setId(2l);

        Location locationB = new Location();
        locationB.setName("LA");
        locationB.setId(3l);

        Route route = new Route();
        route.setId(1l);
        route.setLocationA(locationA);
        route.setLocationB(locationB);
        //Tae
        //route.setTransportation(transportation);
        route.setDuration(200);
        //Tae
        //route.setCost(111);
        route.setDistance(99);

        List<Route> routeList = new ArrayList<Route>();
        routeList.add(route);

        result.setRouteList(routeList);


        Path path = Paths.get("src/main/resources/ResultStax.xml");
        StaxWriter staxWriter = new StaxWriter();
        staxWriter.writeToXml(path, result);
    }
*/
}
