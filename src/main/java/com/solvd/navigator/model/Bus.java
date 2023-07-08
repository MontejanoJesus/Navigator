package com.solvd.navigator.model;

public class Bus {

    private Long id;
    private Integer busNumber;
    private Integer cost;
    private Long driverId;

    public Bus(){}
    public Bus(Long id, Integer busNumber, Integer cost, Long driverId) {
        this.id = id;
        this.busNumber = busNumber;
        this.cost = cost;
        this.driverId = driverId;
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

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "id=" + id +
                ", busNumber='" + busNumber + '\'' +
                ", cost=" + cost +
                ", driverId=" + driverId +
                '}';
    }
}

