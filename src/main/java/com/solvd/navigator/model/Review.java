package com.solvd.navigator.model;

public class Review {
	private Long id;
	private String content;
	private Location location;

	public Review() {
	}

	public Review(Long id, String content, Location location) {
		this.id = id;
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Review{" +
				"id=" + id +
				", content='" + content + '\'' +
				", location=" + location +
				'}';
	}
}
