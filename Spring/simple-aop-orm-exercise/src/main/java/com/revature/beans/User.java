package com.revature.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Spring_User")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "user_role")
	private int userRole;
	
	@Column(name = "user_full_name")
	private String userFullName;
	
	@Column(name = "user_email")
	private String userEmail;

	@OneToMany(mappedBy = "batchTrainer")
	private Set<Batch> batches;
	
	public User() {}
	
	public User(int userRole, String userFullName, String userEmail) {
		this.userRole = userRole;
		this.userFullName = userFullName;
		this.userEmail = userEmail;
	}
	
	public User(int userId, int userRole, String userFullName, String userEmail) {
		super();
		this.userId = userId;
		this.userRole = userRole;
		this.userFullName = userFullName;
		this.userEmail = userEmail;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserRole() {
		return userRole;
	}

	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}

	public String getUserFullName() {
		return userFullName;
	}

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
}
