package com.solvd.navigator.model;

import java.util.ArrayList;
import java.util.List;

public class Review {
    private Long id;
    private String content;
    private Driver driver;
    private Location location;

    public Review(){}
    public Review(Long id, String name,Driver driver,Location location) {
        this.id = id;
        this.content = content;
        this.driver = driver;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String name) {
        this.content = content;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", driver=" + driver +
                ", location=" + location +
                '}';
    }
}
