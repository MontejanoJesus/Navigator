package com.solvd.navigator.model;

import java.util.ArrayList;
import java.util.List;

public class Route {
    private Long id;
    private Location locationA;
    private Location locationB;
    private Integer duration;
    private Integer distance;
    private Person person;
    private Long driverId;

    public Route() {
        this.locationA = new Location();
        this.locationB = new Location();
    }

    public Route(Long id, Integer duration, Integer distance) {
        this.id = id;
        this.duration = duration;
        this.distance = distance;
        this.person = person;
        this.driverId = driverId;
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
    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }
    public Long getDriverId() {
        return driverId;
    }
    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public String toString() {
        return "Route{" +
                "id=" + id +
                ", locationA=" + locationA.getName() +
                ", locationB=" + locationB.getName() +
                ", duration=" + duration +
                ", distance=" + distance +
                ", person=" + person +
                ", driverId=" + driverId +
                '}';
    }
}
