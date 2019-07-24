package com.revature.beans.realistic;

import javax.persistence.*;

@Entity
@Table(name = "STUDENT_PC")
public class Computer {

	@Id
	@Column(name = "PC_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comp_gen")
	@SequenceGenerator(name = "comp_gen", sequenceName = "PC_ID_SEQ")
	private int pcId;
	
	@Column
	private String brand;
	
	public Computer() {}
	
	public Computer(int pcId, String brand) {
		this.pcId = pcId;
		this.brand = brand;
	}

	public int getPcId() {
		return pcId;
	}

	public void setPcId(int pcId) {
		this.pcId = pcId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
}
