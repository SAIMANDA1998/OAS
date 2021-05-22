package com.cg.oas.service;

import java.util.List;
import java.util.Optional;

import com.cg.oas.entities.College;

public interface ICollegeService
{
	public College addCollege(College college);
	public List<College> viewAllCollegeDetails();
	public Optional<College> getCollegeDetailsByProgram(String programName);
	//public List<College> getCollegeDetailsByCourse(String courseName);
	//public List<College> getCollegeDetailsByBranch(String branchName);
	//public  ArrayList<College> getCollegeDetailsByName(String collgeName);
	public List<College> deleteCollegeById(int collegeId);
	//public int deleteCollegeByName(String collgeName);
	public College  updateCollegeDetails(College college);
	public  College getCollegeDetailsById(int collegeRegId);
}
