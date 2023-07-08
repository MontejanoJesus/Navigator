package com.solvd.navigator.model;

public class Taxi {

    private Long id;
    private Integer taxiNumber;
    private Integer cost;
    private Long driverId;

    public Taxi(){}
    public Taxi(Long id, Integer taxiNumber, Integer cost, Long driverId) {
        this.id = id;
        this.taxiNumber = taxiNumber;
        this.cost = cost;
        this.driverId = driverId;
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

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    @Override
    public String toString() {
        return "Taxi{" +
                "id=" + id +
                ", taxiNumber='" + taxiNumber + '\'' +
                ", cost=" + cost +
                ", driverId=" + driverId +
                '}';
    }
}

