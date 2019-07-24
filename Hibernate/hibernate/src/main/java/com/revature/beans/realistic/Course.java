package com.revature.beans.realistic;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Course {

	@Id
	@Column(name = "COURSE_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_gen")
	@SequenceGenerator(name = "course_gen", sequenceName = "COURSE_ID_SEQ")
	private int courseId;
	
	@Column(name = "COURSE_NAME")
	private String courseName; //Java 101
	
	@OneToMany(mappedBy = "course")
	private Set<Classes> classes;
	
	public Course() {}
	
	public Course(int courseId, String courseName, Set<Classes> classes) {
		this.courseId = courseId;
		this.courseName = courseName;
		this.classes = classes;
	}

	public Set<Classes> getClasses() {
		return classes;
	}

	public void setClasses(Set<Classes> classes) {
		this.classes = classes;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
}
