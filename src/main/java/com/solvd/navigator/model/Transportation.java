package com.solvd.navigator.model;

public class Transportation {
	private Long id;
	private Integer cost;
	private Integer vehicleNumber;
	private Person driver;
	private TransportationType transportationType;

	public Transportation() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public Integer getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(Integer vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public Person getDriver() {
		return driver;
	}

	public void setDriver(Person driver) {
		this.driver = driver;
	}

	public TransportationType getTransportationType() {
		return transportationType;
	}

	public void setTransportationType(TransportationType transportationType) {
		this.transportationType = transportationType;
	}

	@Override
	public String toString() {
		return "Transportation{" +
				"id=" + id +
				", cost=" + cost +
				", vehicleNumber=" + vehicleNumber +
				", driver=" + driver +
				'}';
	}
}