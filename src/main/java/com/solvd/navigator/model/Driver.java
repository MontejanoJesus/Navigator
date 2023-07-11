package com.solvd.navigator.model;

import java.util.ArrayList;
import java.util.List;

public class Driver {
    private Long id;
    private String name;
    //one and zero relationship with review
    private Review review;
    //one and many relationship  with review
    private List<Review> reviews;
    private DriverLicense driverLicense;
    private Boat boat;
    private Bus bus;
    private Plane plane;
    private Taxi taxi;
    private Train train;

    public Driver() {
    }

    public Driver(Long id, String name) {
        this.id = id;
        this.name = name;
        //one and zero relationship with review
        this.review = review;
        //one and many relationship  with review
        this.reviews = new ArrayList<>();
        this.boat = boat;
        this.bus = bus;
        this.plane = plane;
        this.taxi = taxi;
        this.train = train;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // start one and zero relationship with review
    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }
    // end one and zero relationship with review

    //start and many relationship  with review
    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
    //end and many relationship  with review

    public DriverLicense getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(DriverLicense driverLicense) {
        this.driverLicense = driverLicense;
        }

    public Boat getBoat() {
        return boat;
    }

    public void setBoat(Boat boat) {
        this.boat = boat;
    }
    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }
    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }
    public Taxi getTaxi() {
        return taxi;
    }

    public void setPlane(Taxi taxi) {
        this.taxi = taxi;
    }
    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", name='" + name +
                ", review='" + review +
                ", reviews='" + reviews +
                ", driverLicense='" + driverLicense +
                ", boat='" + boat +
                ", bus='" + bus +
                ", plane='" + plane +
                ", taxi='" + taxi +
                ", train='" + train +
                '}';
    }
}

