package com.solvd.navigator.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Transportation")
public class Transportation {
	@JsonIgnore
	@XmlTransient
	private Long id;
	@XmlTransient
	private Integer cost;
	private Integer vehicleNumber;
	@JsonIgnore
	@XmlTransient
	private Person driver;

	@XmlElement(name="TransportationType")
	private TransportationType transportationType;

	public Transportation() {
		this.driver = new Person();
		this.transportationType = new TransportationType();
	}
	public Transportation(Integer vehicleNumber, Integer cost, TransportationType type) {
		this.vehicleNumber = vehicleNumber;
		this.cost = cost;
		this.transportationType = type;
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
				", transportationType=" + transportationType +
				'}';
	}
}