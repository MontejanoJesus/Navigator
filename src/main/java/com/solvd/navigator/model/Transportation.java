package com.solvd.navigator.model;

public abstract class Transportation {
    private Long id;
    private Integer cost;
    private Integer vehicleNumber;
    private Person driver;

    public Transportation() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(Integer vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public Person getDriver() {
        return driver;
    }

    public void setDriver(Person driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "Transportation{" +
                "id=" + id +
                ", cost=" + cost +
                ", vehicleNumber=" + vehicleNumber +
                ", driver=" + driver +
                '}';
    }
}