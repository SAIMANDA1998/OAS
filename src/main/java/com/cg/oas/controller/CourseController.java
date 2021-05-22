package com.cg.oas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.oas.entities.Application;
import com.cg.oas.entities.Course;
import com.cg.oas.repository.ICourseRepository;
import com.cg.oas.service.ICourseService;

@RestController
@RequestMapping("/Course")
public class CourseController {

	@Autowired
	ICourseRepository iCourseRepo;
	@Autowired
	private ICourseService iCourseService;
	 
	  @PostMapping("/addCourse")
		public ResponseEntity<Course> addCourse(@RequestBody Course course)
		{
		  Course obj=iCourseService.addCourse(course);
			return new ResponseEntity<Course>(obj, HttpStatus.OK);
		}
		 @GetMapping("/viewAllCourseDetails")
			public ResponseEntity<List<Course>> viewAllCourseDetails() 
		  {
			  List<Course> list=iCourseService.viewAllCourseDetails();
			  return new ResponseEntity<List<Course>>(list, HttpStatus.OK);
		  }
		 @PutMapping("/updateApplicationDetails")
		 public ResponseEntity<Course> updateCourseDetails(@RequestBody Course course)
			{
			 Course obj=iCourseService.updateCourseDetails(course);
				return new ResponseEntity<Course>(obj, HttpStatus.OK);
			}
		 @DeleteMapping("/deleteCourseById/{courseId}")
		 public ResponseEntity<List<Course>> deleteCourseById(@PathVariable Integer courseById)
			{
			List<Course> obj=iCourseService.deleteCourseById(courseById);
				return new ResponseEntity<List<Course>>(obj, HttpStatus.OK);
			}
		 @GetMapping("/getCourseDetailsByCourseId/{courseId}")
		 public ResponseEntity<Course> getCourseDetailsByCourseId(@PathVariable Integer courseId)
			{
				Course obj=iCourseService.getCourseDetailsByCourseId(courseId);
				return new ResponseEntity<Course>(obj, HttpStatus.OK);
			}
		 
	
}
