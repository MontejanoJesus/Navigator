package com.solvd.navigator.model;

public class DriverLicense {
    private Long id;
    private Integer number;

    public DriverLicense(){}
    public DriverLicense(Long id, Integer number) {
        this.id = id;
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String toString() {
        return "DriverLicense{" +
                "id=" + id +
                ",number='" + number +
                '}';
    }
}

