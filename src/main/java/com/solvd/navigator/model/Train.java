package com.solvd.navigator.model;

public class Train {

    private Long id;
    private Integer trainNumber;
    private Integer cost;
    private Driver driver;


    public Train(){}
    public Train(Long id, Integer trainNumber, Integer cost,Driver driver) {
        this.id = id;
        this.trainNumber = trainNumber;
        this.cost = cost;
        this.driver = driver;
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
    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", trainNumber='" + trainNumber + '\'' +
                ", cost=" + cost +
                ", driver=" + driver +
                '}';
    }
}

