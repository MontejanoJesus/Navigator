package com.solvd.navigator.model;

public class DriverLicense {
	private Long id;
	private String number;

	public DriverLicense() {
	}

	public DriverLicense(Long id, String number) {
		this.id = id;
		this.number = number;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String toString() {
		return "DriverLicense{" +
				"id=" + id +
				",number='" + number +
				'}';
	}
}
