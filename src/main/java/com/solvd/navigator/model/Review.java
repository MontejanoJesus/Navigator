package com.solvd.navigator.model;

import java.util.ArrayList;
import java.util.List;

public class Review {
    private Long id;
    private String content;
    private Long driverId;
    private Location location;

    public Review(){}
    public Review(Long id, String name) {
        this.id = id;
        this.content = content;
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

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
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
                ", driverId=" + driverId +
                ", location=" + location +
                '}';
    }
}
