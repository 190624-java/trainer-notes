package com.revature.beans;

import java.util.Date; //Use this over java.sql.Date

public class User {
	enum UserType { EMPLOYEE, MANAGER, CUSTOMER }
	
	private int userId;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	//private String userType; //we could use this or use the below enum
	private UserType userType;
	//We can create something called an ENUM, where we essentially restrict what values can be held by
	//variables of the ENUM data type.
	
	public User() {}
	
	public User(int userId, String firstName, String lastName, Date dateOfBirth, UserType userType) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.userType = userType;
	}
	
	public User(String firstName, String lastName, Date dateOfBirth, UserType userType) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.userType = userType;
	}

	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	
}
