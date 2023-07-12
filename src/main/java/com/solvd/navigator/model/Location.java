package com.solvd.navigator.model;

import java.util.ArrayList;
import java.util.List;

public class Location {
    private Long id;
    private String name;
    private Coordinate coordinate;
    private List<Route> routes;

    public Location(){

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
