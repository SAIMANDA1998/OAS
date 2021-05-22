package com.cg.oas.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.oas.entities.ProgramScheduled;
import com.cg.oas.entities.University;
@Repository
public interface IUniversityRepository extends JpaRepository<University,Integer>
{
//	public University addUniversity(University university);
//	public ArrayList<University> viewAllUniversityDetails();
//	public  ArrayList<University> getUniversityDetailsByCity(String city);
//	public  ArrayList<University> getUniversityDetailsBycollegeName
//	(String collegeName);
//	public int deleteUniversityById(int universityId);
//	public University getUniversityById(int applicationId);
//	public int  updateUniversity(University university);
//	//can add more funtion if require as per business logic
}
