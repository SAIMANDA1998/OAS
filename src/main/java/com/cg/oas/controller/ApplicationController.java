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

import com.cg.oas.entities.Address;
import com.cg.oas.entities.Application;
import com.cg.oas.repository.IApplicationRepository;
import com.cg.oas.service.IApplicationService;

@RestController
@RequestMapping("/application")
public class ApplicationController {
	@Autowired
	private IApplicationService iApplicationService;
	@Autowired
	private IApplicationRepository iApplicationRepo;
	@PostMapping("/addApplication")
	public ResponseEntity<Application> addApplication(@RequestBody Application application)
	{
		Application obj=iApplicationService.addApplication(application);
		return new ResponseEntity<Application>(obj, HttpStatus.OK);
	}
	 @GetMapping("/viewallApplicationDetails")
		public ResponseEntity<List<Application>> viewAllApplicationDetails() 
	  {
		  List<Application> list=iApplicationService.viewAllApplicationDetails();
		  return new ResponseEntity<List<Application>>(list, HttpStatus.OK);
	  }
	 @PutMapping("/updateApplicationDetails")
	 public ResponseEntity<Application> updateApplicationStatus(@RequestBody Application app)
		{
		 Application obj=iApplicationService.updateApplicationStatus(app);
			return new ResponseEntity<Application>(obj, HttpStatus.OK);
		}
	 @DeleteMapping("/deleteApplicationById/{applicationId}")
	 public ResponseEntity<List<Application>> deleteApplicationById(@PathVariable Integer applicationId)
		{
		List<Application> obj=iApplicationService.deleteApplicationById(applicationId);
			return new ResponseEntity<List<Application>>(obj, HttpStatus.OK);
		}
	 @GetMapping("/getApplicationById/{applicationId}")
	 public ResponseEntity<Application> getApplicationById(@PathVariable Integer applicationId)
		{
			Application obj=iApplicationService.getApplicationById(applicationId);
			return new ResponseEntity<Application>(obj, HttpStatus.OK);
		}
	 

}
