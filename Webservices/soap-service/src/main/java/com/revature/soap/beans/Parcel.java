package com.revature.soap.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Parcel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String tracking;
	private double weight;
	
	public Parcel() {}

	public Parcel(int id, String tracking, double weight) {
		super();
		this.id = id;
		this.tracking = tracking;
		this.weight = weight;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTracking() {
		return tracking;
	}

	public void setTracking(String tracking) {
		this.tracking = tracking;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Parcel [id=" + id + ", tracking=" + tracking + ", weight=" + weight + "]";
	}
	
	
}
