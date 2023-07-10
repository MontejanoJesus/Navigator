package com.solvd.navigator.model;

public class Plane {

    private Long id;
    private Integer planeNumber;
    private Integer cost;
    private Driver driver;

    public Plane(){}
    public Plane(Long id, Integer planeNumber, Integer cost,Driver driver) {
        this.id = id;
        this.planeNumber = planeNumber;
        this.cost = cost;
        this.driver = driver;
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

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
    @Override
    public String toString() {
        return "Plan{" +
                "id=" + id +
                ", planeNumber='" + planeNumber + '\'' +
                ", cost=" + cost +
                ", driver=" + driver +
                '}';
    }
}

