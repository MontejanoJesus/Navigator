package com.solvd.navigator.model;

public class Taxi {

    private Long id;
    private Integer taxiNumber;
    private Integer cost;
    private Driver driver;

    public Taxi(){}
    public Taxi(Long id, Integer taxiNumber, Integer cost,Driver driver) {
        this.id = id;
        this.taxiNumber = taxiNumber;
        this.cost = cost;
        this.driver = driver;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTaxiNumber() {
        return taxiNumber;
    }

    public void setTaxiNumber(Integer taxiNumber) {
        this.taxiNumber = taxiNumber;
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
        return "Taxi{" +
                "id=" + id +
                ", taxiNumber='" + taxiNumber + '\'' +
                ", cost=" + cost +
                ", driver=" + driver +
                '}';
    }
}

