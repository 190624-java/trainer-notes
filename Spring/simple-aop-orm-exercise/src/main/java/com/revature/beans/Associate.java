package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Spring_Associate")
public class Associate {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "associate_id")
	private int associateId;
	
	@Column(name = "associate_name")
	private String associateName;
	
	@Column(name = "associate_email")
	private String associateEmail;
	
	@ManyToOne
	@JoinColumn(name = "associate_batch")
	private Batch associateBatch;

	public Associate() {}
	
	public Associate(int associateId, String associateName, String associateEmail, Batch associateBatch) {
		super();
		this.associateId = associateId;
		this.associateName = associateName;
		this.associateEmail = associateEmail;
		this.associateBatch = associateBatch;
	}

	public int getAssociateId() {
		return associateId;
	}

	public void setAssociateId(int associateId) {
		this.associateId = associateId;
	}

	public String getAssociateName() {
		return associateName;
	}

	public void setAssociateName(String associateName) {
		this.associateName = associateName;
	}

	public String getAssociateEmail() {
		return associateEmail;
	}

	public void setAssociateEmail(String associateEmail) {
		this.associateEmail = associateEmail;
	}

	public Batch getAssociateBatch() {
		return associateBatch;
	}

	public void setAssociateBatch(Batch associateBatch) {
		this.associateBatch = associateBatch;
	}
}
