package com.cg.oas.service;

import java.util.List;

import com.cg.oas.entities.Course;

public interface ICourseService 
{
	public Course addCourse(Course course);
	public List<Course> viewAllCourseDetails();
	//public  ArrayList<Course> getCourseDetailsByCourseName(String courceName);
	//public  ArrayList<Course> getCourseDetailsByCollegeName(String collegeName);
	//public  ArrayList<Course> getCourseDetailsByEligibility(String eligibility);
	public  Course getCourseDetailsByCourseId(int courseId);
	public List<Course> deleteCourseById(int courseById);
	//public int deleteCourseByName(String courseName);
	public Course  updateCourseDetails(Course course);
}
