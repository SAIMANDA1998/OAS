package com.cg.oas.entities;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Course 
{   @Id
	private int courseId;
	private String courseName;
	private String description;
	private String eligibility;
	@ManyToOne
	@JsonIgnore
	private College collegeRegId;
	@OneToMany(mappedBy="branchId")
	@JsonIgnore
	private List<Branch> branches;
	public Course() {}
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEligibility() {
		return eligibility;
	}
	public void setEligibility(String eligibility) {
		this.eligibility = eligibility;
	}
	public College getCollege() {
		return collegeRegId;
	}
	public void setCollege(College collegeRegId) {
		this.collegeRegId = collegeRegId;
	}
	public List<Branch> getBranches() {
		return branches;
	}
	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}
	
}
