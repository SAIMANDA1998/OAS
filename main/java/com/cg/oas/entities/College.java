package com.cg.oas.entities;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class College
{
	@Id
	private int collegeRegId;
	private String collegeName;
	
	@OneToOne
	private Address collegeAddress;	
	
	@OneToMany(mappedBy="collegeRegId")
	private List<Program> programList;
	@OneToMany(mappedBy="collegeRegId")
	@JsonIgnore
	private List<Course> courseList;
	@OneToMany(mappedBy="collegeRegId")
	private List<Branch> branchList;
	@OneToOne
	private University universityName;
	public College() {}
	public int getCollegeRegId() {
		return collegeRegId;
	}
	public void setCollegeRegId(int collegeRegId) {
		this.collegeRegId = collegeRegId;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public Address getCollegeAddress() {
		return collegeAddress;
	}
	public void setCollegeAddress(Address collegeAddress) {
		this.collegeAddress = collegeAddress;
	}
	public List<Program> getProgramList() {
		return programList;
	}
	public void setProgramList(List<Program> programList) {
		this.programList = programList;
	}
	public List<Course> getCourseList() {
		return courseList;
	}
	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}
	public List<Branch> getBranchList() {
		return branchList;
	}
	public void setBranchList(List<Branch> branchList) {
		this.branchList = branchList;
	}
	public University getUniversityName() {
		return universityName;
	}
	public void setUniversityName(University universityName) {
		this.universityName = universityName;
	}
	
}
