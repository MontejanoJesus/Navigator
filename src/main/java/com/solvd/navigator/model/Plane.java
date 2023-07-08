package com.solvd.navigator.model;

public class Plane {

    private Long id;
    private Integer planeNumber;
    private Integer cost;
    private Long driverId;

    public Plane(){}
    public Plane(Long id, Integer planeNumber, Integer cost, Long driverId) {
        this.id = id;
        this.planeNumber = planeNumber;
        this.cost = cost;
        this.driverId = driverId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPlaneNumber() {
        return planeNumber;
    }

    public void setPlanNumber(Integer planeNumber) {
        this.planeNumber = planeNumber;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "id=" + id +
                ", planeNumber='" + planeNumber + '\'' +
                ", cost=" + cost +
                ", driverId=" + driverId +
                '}';
    }
}

