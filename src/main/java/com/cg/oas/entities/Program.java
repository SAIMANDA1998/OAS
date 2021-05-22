	package com.cg.oas.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Program
{   @Id
	private Integer programId;	
	private String programName;
	
	private String programDescription;
	
	private String programEligibility;
	
	private String programDuration;
	
	private String degreeOffered;
	@ManyToOne
	@JsonIgnore
	private College collegeRegId;
	
	public College getCollegeRegId() {
		return collegeRegId;
	}
	public void setCollegeRegId(College collegeRegId) {
		this.collegeRegId = collegeRegId;
	}
	public Program() {}
	public Integer getProgramId() {
		return programId;
	}
	public void setProgramId(Integer programId) {
		this.programId = programId;
	}
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public String getProgramDescription() {
		return programDescription;
	}
	public void setProgramDescription(String programDescription) {
		this.programDescription = programDescription;
	}
	public String getProgramEligibility() {
		return programEligibility;
	}
	public void setProgramEligibility(String programEligibility) {
		this.programEligibility = programEligibility;
	}
	public String getProgramDuration() {
		return programDuration;
	}
	public void setProgramDuration(String programDuration) {
		this.programDuration = programDuration;
	}
	public String getDegreeOffered() {
		return degreeOffered;
	}
	public void setDegreeOffered(String degreeOffered) {
		this.degreeOffered = degreeOffered;
	}
	
	
}