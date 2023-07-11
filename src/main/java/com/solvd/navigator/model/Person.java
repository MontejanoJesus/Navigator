package com.solvd.navigator.model;

import java.util.ArrayList;
import java.util.List;

public class Person {
        private Long id;
        private String name;
        private List<Route> routes;
        private DriverLicense driverLicense;
        private Transportation transportation;

    public Person(){

        }

        public Person(Long id, String name) {
            this.id = id;
            this.name = name;
            this.routes = new ArrayList<>();
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

        public void setRoutes(List<Route> routes) {
            this.routes = routes;
        }

        public DriverLicense getDriverLicense() {
            return driverLicense;
        }

        public void setDriverLicense(DriverLicense driverLicense) {
            this.driverLicense = driverLicense;
        }
        public Transportation getTransportation() {
        return transportation;
    }

        public void setTransportation(Transportation transportation) {
        this.transportation = transportation;
    }

        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name +
                    ", routes=" + routes +
                    ", driverLicense=" + driverLicense +
                    ", transportation=" + transportation +
                    '}';
        }
    }

