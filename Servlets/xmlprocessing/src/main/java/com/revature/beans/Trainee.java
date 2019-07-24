package com.revature.beans;

public class Trainee {

	private int id;
	private String name;
	private boolean isCertified;
	
	public Trainee() {}
	
	public Trainee(int id, String name, boolean isCertified) {
		this.id = id;
		this.name = name;
		this.isCertified = isCertified;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isCertified() {
		return isCertified;
	}

	public void setCertified(boolean isCertified) {
		this.isCertified = isCertified;
	}
		
}
