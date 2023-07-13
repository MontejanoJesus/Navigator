package com.solvd.navigator.parsers;

import com.solvd.navigator.model.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ParserRunner {
    public static void main(String[] args) throws IOException {
        Location la = new Location("Los Angeles");
        Location sf = new Location("San Fransico");
        Location ny = new Location("New York");
        Location ma = new Location("Miami");

        Transportation bus = new Transportation(101, 10, new TransportationType("Bus"));
        Transportation plane = new Transportation(747, 50, new TransportationType("Plane"));
        Transportation taxi = new Transportation(59, 10, new TransportationType("Taxi"));


        Route laSf = new RouteBuilder().withLocationA(la).withLocationB(sf).withTransportation(bus)
                .withDuration(10).createRoute();
        Route sfNy = new RouteBuilder().withLocationA(sf).withLocationB(ny).withTransportation(plane)
                .withDuration(50).createRoute();
        Route nyMa = new RouteBuilder().withLocationA(ny).withLocationB(ma).withTransportation(taxi)
                .withDuration(5).createRoute();

        List<Route> routeList = new ArrayList<>();
        routeList.add(laSf);
        routeList.add(sfNy);
        routeList.add(nyMa);

        Result result = new Result();
        result.setRouteList(routeList);

        StaxWriter staxWriter = new StaxWriter();

        Path path = Paths.get("src\\main\\resources\\ResultStax.xml");
        staxWriter.writeToXml(path, result);


    }
}
