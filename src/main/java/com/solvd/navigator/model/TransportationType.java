package com.solvd.navigator.model;

public class TransportationType {
    private Long id;
    private String type;

    public TransportationType() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String toString() {
        return "TransportationType{" +
                "id=" + id +
                ",type=" + type +
                '}';
    }
}
