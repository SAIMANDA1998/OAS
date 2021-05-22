package com.cg.oas.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.oas.entities.Application;
import com.cg.oas.entities.College;
@Repository
public interface ICollegeRepository extends JpaRepository<College,Integer>
{
//	public College addCollege(College college);
//	public ArrayList<College> viewAllCollegeDetails();
//	public  ArrayList<College> getCollegeDetailsByProgram(String programName);
//	public  ArrayList<College> getCollegeDetailsByCourse(String courceName);
//	public  ArrayList<College> getCollegeDetailsByBranch(String branchName);
//	public  ArrayList<College> getCollegeDetailsByName(String collgeName);
//	public int deleteCollegeById(int collegeId);
//	public int deleteCollegeByName(String collgeName);
//	public int  updateCollegeDetails(College college);
	//public  College getCollegeDetailsById(int collegeId);
}
