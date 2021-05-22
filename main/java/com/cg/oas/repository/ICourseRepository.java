package com.cg.oas.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.oas.entities.College;
import com.cg.oas.entities.Course;
@Repository
public interface ICourseRepository extends JpaRepository<Course,Integer>
{
//	public Course addCourse(Course course);
//	public ArrayList<Course> viewAllCourseDetails();
//	public  ArrayList<Course> getCourseDetailsByCourseName(String courceName);
//	public  ArrayList<Course> getCourseDetailsByCollegeName(String collegeName);
//	public  ArrayList<Course> getCourseDetailsByEligibility(String eligibility);
//	public  Course getCourseDetailsByCourseId(int courceId);
//	public int deleteCourseById(int courseById);
//	public int deleteCourseByName(String courseName);
//	public int  updateCourseDetails(Course course);
}
