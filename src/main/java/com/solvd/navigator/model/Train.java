package com.solvd.navigator.model;

public class Train {

    private Long id;
    private Integer trainNumber;
    private Integer cost;
    private Long driverId;

    public Train(){}
    public Train(Long id, Integer trainNumber, Integer cost, Long driverId) {
        this.id = id;
        this.trainNumber = trainNumber;
        this.cost = cost;
        this.driverId = driverId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(Integer trainNumber) {
        this.trainNumber = trainNumber;
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
        return "Train{" +
                "id=" + id +
                ", trainNumber='" + trainNumber + '\'' +
                ", cost=" + cost +
                ", driverId=" + driverId +
                '}';
    }
}

