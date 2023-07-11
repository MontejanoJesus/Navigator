package com.solvd.navigator.model;

import java.util.ArrayList;
import java.util.List;

public class Review {
    private Long id;
    private String content;
    private Person driver;

    public Review(){}
    public Review(Long id, String content, Person driver ){
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

    public Person getDriver() {
        return driver;
    }

    public void setDriver(Person driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", driver=" + driver +
                '}';
    }
}
