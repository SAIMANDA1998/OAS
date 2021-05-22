package com.cg.oas.controller;

import java.util.List;
import java.util.Optional;

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

import com.cg.oas.entities.College;
import com.cg.oas.service.ICollegeService;
import com.cg.oas.service.IProgramService;

@RestController
@RequestMapping("/College")
public class CollegeController {
	@Autowired
	private ICollegeService iCollegeService;
	@Autowired
	private IProgramService iProgramService;
	 @PostMapping("/addCollege")
		public ResponseEntity<College> addCollege(@RequestBody College college)
		{
		  College obj=iCollegeService.addCollege(college);
			return new ResponseEntity<College>(obj, HttpStatus.OK);
		}
		 @GetMapping("/viewAllCollegeDetails")
			public ResponseEntity<List<College>> viewAllCollegeDetails() 
		  {
			  List<College> list=iCollegeService.viewAllCollegeDetails();
			  return new ResponseEntity<List<College>>(list, HttpStatus.OK);
		  }
		 @PutMapping("/updateCollegeDetails")
		 public ResponseEntity<College> updateCollegeDetails(@RequestBody College college)
			{
			 College obj=iCollegeService.updateCollegeDetails(college);
				return new ResponseEntity<College>(obj, HttpStatus.OK);
			}
		 @DeleteMapping("/deleteCollegeById/{collegeRegId}")
		 public ResponseEntity<List<College>> deleteCollegeById(@PathVariable Integer collegeRegId)
			{
			List<College> obj=iCollegeService.deleteCollegeById(collegeRegId);
				return new ResponseEntity<List<College>>(obj, HttpStatus.OK);
			}
		 @GetMapping("/getCollegeDetailsById/{collegeRegId}")
		 public ResponseEntity<College> getCollegeDetailsById(@PathVariable Integer collegeRegId)
			{
				College obj=iCollegeService.getCollegeDetailsById(collegeRegId);
				return new ResponseEntity<College>(obj, HttpStatus.OK);
			}
		 @GetMapping("/getCollegeDetailsByProgram/{programName}")
		 public ResponseEntity<Optional<College>> getCollegeDetailsByProgram(@PathVariable String programName)
			{
				Optional<College> list=iCollegeService.getCollegeDetailsByProgram(programName);
				return new ResponseEntity<Optional<College>>(list, HttpStatus.OK);
			}
	 
	
}
