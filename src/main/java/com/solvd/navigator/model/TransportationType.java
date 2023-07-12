package com.solvd.navigator.model;

public class TransportationType {
	Long id;
	String type;

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

	@Override
	public String toString() {
		return "TransportationType{" +
				"id=" + id +
				", name='" + type + '\'' +
				'}';
	}
}
