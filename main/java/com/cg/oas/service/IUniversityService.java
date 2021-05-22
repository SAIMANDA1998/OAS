package com.cg.oas.service;

import java.util.List;

import com.cg.oas.entities.University;

public interface IUniversityService
{
	public University addUniversity(University university);
	public List<University> viewAllUniversityDetails();
	//public  ArrayList<University> getUniversityDetailsByCity(String city);
	//public  ArrayList<University> getUniversityDetailsBycollegeName(String collegeName);
	public List<University> deleteUniversityById(int universityId);
	public University getUniversityById(int applicationId);
	public University  updateUniversity(University university);
	//can add more funtion if require as per business logic
}
