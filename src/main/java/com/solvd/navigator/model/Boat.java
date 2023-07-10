package com.solvd.navigator.model;

public class Boat {

    private Long id;
    private Integer boatNumber;
    private Integer cost;
    private Driver driver;

    public Boat(){}
    public Boat(Long id, Integer boatNumber, Integer cost,Driver driver) {
        this.id = id;
        this.boatNumber = boatNumber;
        this.cost = cost;
        this.driver = driver;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBoatNumber() {
        return boatNumber;
    }

    public void setBoatNumber(Integer boatNumber) {
        this.boatNumber = boatNumber;
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
        return "Boat{" +
                "id=" + id +
                ", boatNumber='" + boatNumber + '\'' +
                ", cost=" + cost +
                ", driver=" + driver +
                '}';
    }
}

