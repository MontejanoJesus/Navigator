package com.solvd.navigator.model;

import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;
import java.util.List;

public class Person {
	private Long id;
	private String name;
	@XmlTransient
	private DriverLicense driverLicense;

	public Person() {
		this.driverLicense = new DriverLicense();
	}

	public Person(Long id, String name) {
		this.id = id;
		this.name = name;
		this.driverLicense = new DriverLicense();
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

	public DriverLicense getDriverLicense() {
		return driverLicense;
	}

	public void setDriverLicense(DriverLicense driverLicense) {
		this.driverLicense = driverLicense;
	}

	@Override
	public String toString() {
		if(driverLicense == null){
			return "Person{" +
					"id=" + id +
					", name='" + name + '\'' +
					'}';
		} else {
			return "Person{" +
					"id=" + id +
					", name='" + name + '\'' +
					", driverLicense=" + driverLicense +
					'}';
		}
	}
}
