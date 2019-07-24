package com.revature.beans.realistic;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Student {

	@Id
	@Column(name = "STUDENT_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_gen")
	@SequenceGenerator(name = "student_gen", sequenceName = "STUDENT_ID_SEQ")
	private int studentId;
	
	@Column(name = "FULL_NAME")
	private String fullName;
	
	@Column(name = "MAJOR")
	private String major;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PC_ID")
	private Computer computer;
	
	//this is a bi-directional mapping, we have to choose an owner
	//the owner is the one that must be saved in order for any changes
	//to the junction to be saved.
	@ManyToMany
	//our junction table
	@JoinTable(name = "ENROLLMENTS", joinColumns = {
			@JoinColumn(name = "STUDENT_ID")
		},
		inverseJoinColumns = {
			@JoinColumn(name = "CLASS_INSTANCE_ID")	
		})
	private Set<Classes> enrolledClasses;
	
	
	public Student() {}

	public Student(int studentId, String fullName, String major, Computer computer, Set<Classes> enrolledClasses) {
		super();
		this.studentId = studentId;
		this.fullName = fullName;
		this.major = major;
		this.computer = computer;
		this.enrolledClasses = enrolledClasses;
	}

	public Set<Classes> getEnrolledClasses() {
		return enrolledClasses;
	}

	public void setEnrolledClasses(Set<Classes> enrolledClasses) {
		this.enrolledClasses = enrolledClasses;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Computer getComputer() {
		return computer;
	}

	public void setComputer(Computer computer) {
		this.computer = computer;
	}
}
