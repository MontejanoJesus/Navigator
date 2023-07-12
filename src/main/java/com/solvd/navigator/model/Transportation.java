package com.solvd.navigator.model;

public class Transportation {
	private Long id;
	private Integer cost;
	private Integer number;
	private Person person;
	private TransportationType transportationType;

	public Transportation() {}

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

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
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
				", number=" + number +
				", person=" + person +
				", transportationType=" + transportationType +
				'}';
	}
}