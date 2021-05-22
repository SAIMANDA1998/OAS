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

import com.cg.oas.entities.Program;
import com.cg.oas.repository.IProgramRepository;
import com.cg.oas.service.IProgramService;

@RestController
@RequestMapping("/Program")
public class ProgramController {
	@Autowired
	private IProgramService iProgramService;
	@Autowired
	private IProgramRepository iProgramRepo;
	@PostMapping("/addProgram")
	public ResponseEntity<Program> addProgram(@RequestBody Program program)
	{
		Program obj=iProgramService.addProgram(program);
		return new ResponseEntity<Program>(obj, HttpStatus.OK);
	}
	
	@GetMapping("/Viewallprogramdetails")
	public ResponseEntity<List<Program>> viewAllProgramDetails() 
  {
		  List<Program> list=iProgramService.viewAllProgramDetails();
		  return new ResponseEntity<List<Program>>(list, HttpStatus.OK);
	  }
	
	@DeleteMapping("/deleteProgramById/{programId}")
	 public ResponseEntity<List<Program>> deleteProgram(@PathVariable Integer programId)
		{
		List<Program> obj=iProgramService.deleteProgramById(programId);
			return new ResponseEntity<List<Program>>(obj, HttpStatus.OK);
		}
	
	@GetMapping("/getProgramDetailsById/{programId}")
	 public ResponseEntity<Program> getProgramById(@PathVariable Integer programId)
		{
			Program obj=iProgramService.getProgramById(programId);
			return new ResponseEntity<Program>(obj, HttpStatus.OK);
		}
	
	@PutMapping("/updateProgramDetails")
	 public ResponseEntity<Program> updateProgram(@RequestBody Program program)
		{
			Program obj=iProgramService.updateProgramStatus(program);
			return new ResponseEntity<Program>(obj, HttpStatus.OK);
		}


}
