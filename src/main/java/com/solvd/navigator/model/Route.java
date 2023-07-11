package com.solvd.navigator.model;

import java.util.ArrayList;
import java.util.List;

public class Route {
    private Long id;
    private Location locationA;
    private Location locationB;
    private Integer duration;
    private Integer distance;
    private List<Person> users;
    private Transportation transportation;

    public Route() {
        this.locationA = new Location();
        this.locationB = new Location();
        this.users = new ArrayList<>();
    }

    public Route(Long id, Integer duration, Integer distance) {
        this.id = id;
        this.duration = duration;
        this.distance = distance;
        this.users = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Location getLocationA() {
        return locationA;
    }

    public void setLocationA(Location locationA) {
        this.locationA = locationA;
    }

    public Location getLocationB() {
        return locationB;
    }

    public void setLocationB(Location locationB) {
        this.locationB = locationB;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public List<Person> getUsers() {
        return users;
    }

    public void setUsers(List<Person> people) {
        this.users = people;
    }

    public Transportation getTransportation() {
        return transportation;
    }

    public void setTransportation(Transportation transportation) {
        this.transportation = transportation;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", locationA=" + locationA +
                ", locationB=" + locationB +
                ", duration=" + duration +
                ", distance=" + distance +
                ", users=" + users +
                ", transportation=" + transportation +
                '}';
    }
}
