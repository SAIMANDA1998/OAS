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

import com.cg.oas.entities.University;
import com.cg.oas.service.IUniversityService;

@RestController
@RequestMapping("/University")
public class UniversityController {
	@Autowired
	private IUniversityService iUniversityService;
	@PostMapping("/addUniversity")
	public ResponseEntity<University> addUniversity(@RequestBody University university)
	{
		University obj=iUniversityService.addUniversity(university);
		return new ResponseEntity<University>(obj, HttpStatus.OK);
	}
	
	@GetMapping("/ViewallUniversitydetails")
	public ResponseEntity<List<University>> viewAllUniversityDetails() 
  {
		  List<University> list=iUniversityService.viewAllUniversityDetails();
		  return new ResponseEntity<List<University>>(list, HttpStatus.OK);
	  }
	
	@DeleteMapping("/deleteUniversityById/{universityId}")
	 public ResponseEntity<List<University>> deleteUniversity(@PathVariable Integer universityId)
		{
		List<University> obj=iUniversityService.deleteUniversityById(universityId);
			return new ResponseEntity<List<University>>(obj, HttpStatus.OK);
		}
	
	@GetMapping("/getUniversityDetailsById/{universityId}")
	 public ResponseEntity<University> getUniversityById(@PathVariable Integer applicationId)
		{
		University obj=iUniversityService.getUniversityById(applicationId);
			return new ResponseEntity<University>(obj, HttpStatus.OK);
		}
	
	@PutMapping("/updateUniversityDetails")
	 public ResponseEntity<University> updateUniversity(@RequestBody University university)
		{
		University obj=iUniversityService.updateUniversity(university);
			return new ResponseEntity<University>(obj, HttpStatus.OK);
		}
	


}
