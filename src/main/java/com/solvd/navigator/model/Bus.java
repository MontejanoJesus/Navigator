package com.solvd.navigator.model;

public class Bus {

    private Long id;
    private Integer busNumber;
    private Integer cost;
    private Driver driver;

    public Bus(){}
    public Bus(Long id, Integer busNumber, Integer cost,Driver driver) {
        this.id = id;
        this.busNumber = busNumber;
        this.cost = cost;
        this.driver = driver;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(Integer busNumber) {
        this.busNumber = busNumber;
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
        return "Bus{" +
                "id=" + id +
                ", busNumber='" + busNumber +
                ", cost=" + cost +
                ", driver=" + driver +
                '}';
    }
}

