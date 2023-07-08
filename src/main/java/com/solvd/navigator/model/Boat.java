package com.solvd.navigator.model;

public class Boat {

    private Long id;
    private Integer boatNumber;
    private Integer cost;
    private Long driverId;

    public Boat(){}
    public Boat(Long id, Integer boatNumber, Integer cost, Long driverId) {
        this.id = id;
        this.boatNumber = boatNumber;
        this.cost = cost;
        this.driverId = driverId;
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

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    @Override
    public String toString() {
        return "Boat{" +
                "id=" + id +
                ", boatNumber='" + boatNumber + '\'' +
                ", cost=" + cost +
                ", driverId=" + driverId +
                '}';
    }
}

