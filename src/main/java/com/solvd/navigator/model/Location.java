package com.solvd.navigator.model;
import java.util.ArrayList;
import java.util.List;

public class Location {
    private Long id;
    private String name;
    private Coordinate coordinate;
    private List<Route> routes;
    private List<Review> reviews;

    public Location(){

    }

    public Location(Long id, String name,Review review) {
        this.id = id;
        this.name = name;
        this.reviews = new ArrayList<>();
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
    public List<Route> getRoutes() {
        return routes;
    }
    public List<Review> getReviews() {
        return reviews;
    }
    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name +
                ", routes=" + routes +
                ", reviews;=" + reviews +
                '}';
    }
}


