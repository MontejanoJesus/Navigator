package com.solvd.navigator.parsers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.solvd.navigator.model.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParserRunner {
    public static void main(String[] args) throws IOException {
        Location la = new Location("Los Angeles");
        Location sf = new Location("San Fransico");
        Location ny = new Location("New York");
        Location ma = new Location("Miami");

        Route laSf = new RouteBuilder().withLocationA(la).withLocationB(sf).withTransportation(new Transportation())
                .withDuration(10).createRoute();
        Route sfNy = new RouteBuilder().withLocationA(sf).withLocationB(ny).createRoute();
        Route nyMa = new RouteBuilder().withLocationA(ny).withLocationB(ma).createRoute();

        List<Route> routeList = new ArrayList<>();
        routeList.add(laSf);
        routeList.add(sfNy);
        routeList.add(nyMa);

        Result result = new Result();
        result.setRouteList(routeList);


    }
}
