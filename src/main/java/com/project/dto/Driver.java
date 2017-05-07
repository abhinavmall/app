package com.project.dto;

public class Driver {
	private Integer id;
	private String name;
	private String email;
	private double latitude;
	private double longitude;
	private String status;
	private String passenger;
	private double distanceFromPassenger;
	
	public double getDistanceFromPassenger() {
		return distanceFromPassenger;
	}
	public void setDistanceFromPassenger(double distanceFromPassenger) {
		this.distanceFromPassenger = distanceFromPassenger;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPassenger() {
		return passenger;
	}
	public void setPassenger(String passenger) {
		this.passenger = passenger;
	}
}
