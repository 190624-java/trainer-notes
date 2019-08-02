package com.expedia.boot;

public class Hotel {

	private int id;
	private String description;
	private double price;
	private int occupancy;
	private int beds;

	public Hotel() {
	}

	public Hotel(String description, double price, int occupancy, int beds) {
		super();
		this.description = description;
		this.price = price;
		this.occupancy = occupancy;
		this.beds = beds;
	}

	public Hotel(int id, String description, double price, int occupancy, int beds) {
		super();
		this.id = id;
		this.description = description;
		this.price = price;
		this.occupancy = occupancy;
		this.beds = beds;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getOccupancy() {
		return occupancy;
	}

	public void setOccupancy(int occupancy) {
		this.occupancy = occupancy;
	}

	public int getBeds() {
		return beds;
	}

	public void setBeds(int beds) {
		this.beds = beds;
	}

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", description=" + description + ", price=" + price + ", occupancy=" + occupancy
				+ ", beds=" + beds + "]";
	}
}
