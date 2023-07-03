package com.solvd.navigator.model;

public class Route {
    private Long id;
    private Location locationA;
    private Location locationB;
    private Long duration;
    private Transportation transportation;
    private Long cost;
    private Long distance;

    public Route() {

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

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Transportation getTransportationId() {
        return transportation;
    }

    public void setTransportationId(Transportation transportation) {
        this.transportation = transportation;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public Long getDistance() {
        return distance;
    }

    public void setDistance(Long distance) {
        this.distance = distance;
    }

    public String toString() {
        return "Route{" +
                "id=" + id +
                ", locationA=" + locationA +
                ", locationB=" + locationB +
                ", duration=" + duration +
                ", transportationId=" + transportation +
                ", cost=" + cost +
                ", distance=" + distance +
                '}';
    }
}
