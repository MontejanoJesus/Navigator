package com.solvd.navigator.model;

import java.util.ArrayList;
import java.util.List;

public class Location {
    private Long id;
    private String name;
    private Coordinate coordinate;
    private List<Route> routes;

    public Location(){

        this.routes = new ArrayList<>();
    }
    public Location(String name){

        this.name = name;
        this.coordinate = new Coordinate();
        this.routes = new ArrayList<>();

    }

    public Location(Long id, String name,Review review) {
        this.id = id;
        this.name = name;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public void addRoute(Location endLocation, Integer weight) {

        this.routes.add(new RouteBuilder().withLocationA(this).withLocationB(endLocation).withDuration(weight).createRoute());
    }

    public void addRoute(Location endLocation, Integer weight, Transportation t) {

        this.routes.add(new RouteBuilder().withLocationA(this).withLocationB(endLocation).withDuration(weight).withTransportation(t).createRoute());
    }
    public void addRoute(Route route) {

        this.routes.add(route);
    }

    public void removeEdge(Location endLocation) {

        this.routes.removeIf(route ->route.getLocationB().equals(endLocation) );
    }



    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinate=" + coordinate +
                ", routes=" + routes +
                '}';
    }
}
