package com.solvd.navigator.model;

import java.util.ArrayList;
import java.util.List;

public class Route {
    private Long id;
    private Location locationA;
    private Location locationB;
    private Integer duration;
    private Integer distance;
    private List<User> users;
    private User user;
    private Driver driver;

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
        this.user = user;
        this.driver = driver;
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public String toString() {
        return "Route{" +
                "id=" + id +
                ", locationA=" + locationA.getName() +
                ", locationB=" + locationB.getName() +
                ", duration=" + duration +
                ", distance=" + distance +
                ", users=" + users +
                ", user=" + user+
                ", driver=" + driver +
                '}';
    }
}
