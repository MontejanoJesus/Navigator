package com.solvd.navigator.model;

public class Driver {
        private Long id;
        private String name;

        public Driver() {

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


        public String toString() {
            return "Driver{" +
                    "id=" + id +
                    ", name='" + name +
                    '}';
        }
    }

