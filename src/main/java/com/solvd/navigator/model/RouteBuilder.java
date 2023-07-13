package com.solvd.navigator.model;

import java.util.List;

public class RouteBuilder {

    private Long id;
    private Location locationA;
    private Location locationB;
    private Integer duration;
    private Integer distance;
    private Transportation transportation;

    public RouteBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public RouteBuilder withLocationA(Location locationA) {
        this.locationA = locationA;
        return this;
    }

    public RouteBuilder withLocationB(Location locationB) {
        this.locationB = locationB;
        return this;
    }

    public RouteBuilder withTransportation(Transportation transportation) {
        this.transportation = transportation;
        return this;
    }

    public RouteBuilder withDuration(Integer duration) {
        this.duration = duration;
        return this;
    }

    public RouteBuilder withDistance(Integer distance) {
        this.distance = distance;
        return this;
    }

    public Route createRoute(){return new Route(id,locationA,locationB,duration,distance,transportation);}
}
