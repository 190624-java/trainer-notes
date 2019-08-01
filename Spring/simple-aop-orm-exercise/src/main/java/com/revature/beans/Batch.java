package com.revature.beans;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Spring_Batch")
public class Batch {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "batch_id")
	private int batchId;
	
	@Column(name = "batch_start_date")
	@Temporal(TemporalType.DATE)
	private Date batchStartDate;
	
	@Column(name = "batch_length")
	private int batchLength;
	
	@ManyToOne
	@JoinColumn(name = "batch_trainer")
	private User batchTrainer;
	
	@Column(name = "batch_track")
	private String batchTrack;
	
	@OneToMany(mappedBy = "associateBatch")
	private Set<Associate> associates;

	public Batch() {}
	
	public Batch(int batchId, Date batchStartDate, int batchLength, User batchTrainer, String batchTrack,
			Set<Associate> associates) {
		super();
		this.batchId = batchId;
		this.batchStartDate = batchStartDate;
		this.batchLength = batchLength;
		this.batchTrainer = batchTrainer;
		this.batchTrack = batchTrack;
		this.associates = associates;
	}

	public Set<Associate> getAssociates() {
		return associates;
	}

	public void setAssociates(Set<Associate> associates) {
		this.associates = associates;
	}

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	public Date getBatchStartDate() {
		return batchStartDate;
	}

	public void setBatchStartDate(Date batchStartDate) {
		this.batchStartDate = batchStartDate;
	}

	public int getBatchLength() {
		return batchLength;
	}

	public void setBatchLength(int batchLength) {
		this.batchLength = batchLength;
	}

	public User getBatchTrainer() {
		return batchTrainer;
	}

	public void setBatchTrainer(User batchTrainer) {
		this.batchTrainer = batchTrainer;
	}

	public String getBatchTrack() {
		return batchTrack;
	}

	public void setBatchTrack(String batchTrack) {
		this.batchTrack = batchTrack;
	}
}
