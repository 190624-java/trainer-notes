package com.revature.beans.realistic;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Classes {

	@Id
	@Column(name = "CLASS_INSTANCE_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "classes_gen")
	@SequenceGenerator(name = "classes_gen", sequenceName = "CLASSES_ID_SEQ")
	private int instanceId;
	
	@Column(name = "START_DATE")
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@Column(name = "END_DATE")
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
	@Column(name = "ROOM_NUMBER")
	private String roomNumber;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "COURSE_ID")
	private Course course;
	
	//This is the 'inverse' side. (NOT the Owner side)
	//mappedBy = "nameOfPropertyOnTheOwnerSide"
	@ManyToMany(mappedBy = "enrolledClasses")
	private Set<Student> enrolledStudents;
	
	public Classes() {}

	public Classes(int instanceId, Date startDate, Date endDate, String roomNumber, Course course, Set<Student> enrolledStudents) {
		super();
		this.instanceId = instanceId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.roomNumber = roomNumber;
		this.course = course;
		this.enrolledStudents = enrolledStudents;
	}

	public Set<Student> getEnrolledStudents() {
		return enrolledStudents;
	}

	public void setEnrolledStudents(Set<Student> enrolledStudents) {
		this.enrolledStudents = enrolledStudents;
	}

	public int getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(int instanceId) {
		this.instanceId = instanceId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
}
