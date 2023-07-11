package com.solvd.navigator.model;

import java.util.List;

public class Location {
	private Long id;
	private String name;
	private Coordinate coordinate;
	private List<Route> routes;

	public Location() {

	}

	public Location(Long id, String name) {
		this.id = id;
		this.name = name;
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

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	public String toString() {
		return "Location{" +
				"id=" + id +
				", name='" + name +
				", routes=" + routes +
				'}';
	}
}
