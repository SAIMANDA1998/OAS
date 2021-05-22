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

import com.cg.oas.entities.ProgramScheduled;
import com.cg.oas.repository.IProgramScheduleRepository;
import com.cg.oas.service.IProgramScheduleService;

@RestController
@RequestMapping("/ProgramSchedule")
public class ProgramScheduleController {
	@Autowired
	private IProgramScheduleService iProgramScheduleService;
	@Autowired
	private IProgramScheduleRepository iProgramScheduleRepo;
	
	@PostMapping("/addProgramSchedule")
	public ResponseEntity<ProgramScheduled> addProgramSchedule(@RequestBody ProgramScheduled programSchedule)
	{
		ProgramScheduled obj=iProgramScheduleService.addProgramSchedule(programSchedule);
		return new ResponseEntity<ProgramScheduled>(obj, HttpStatus.OK);
	}
	@GetMapping("/ViewallprogramScheduledetails")
	public ResponseEntity<List<ProgramScheduled>> viewAllProgramScheduleDetails() 
  {
		  List<ProgramScheduled> list=iProgramScheduleService.viewAllProgramScheduleDetails();
		  return new ResponseEntity<List<ProgramScheduled>>(list, HttpStatus.OK);
	  }
	
	@DeleteMapping("/deleteProgramById/{scheduledId}")
	 public ResponseEntity<List<ProgramScheduled>> deleteProgramSchedule(@PathVariable Integer scheduledId)
		{
		List<ProgramScheduled> obj=iProgramScheduleService.deleteProgramScheduleById(scheduledId);
			return new ResponseEntity<List<ProgramScheduled>>(obj, HttpStatus.OK);
		}
	
	@GetMapping("/getProgramScheduleDetailsById/{scheduledId}")
	 public ResponseEntity<ProgramScheduled> getProgramScheduleById(@PathVariable Integer scheduledId)
		{
		ProgramScheduled obj=iProgramScheduleService.getProgramScheduleById(scheduledId);
			return new ResponseEntity<ProgramScheduled>(obj, HttpStatus.OK);
		}
	
	@PutMapping("/updateProgramScheduleDetails")
	 public ResponseEntity<ProgramScheduled> updateProgramSchedule(@RequestBody ProgramScheduled programSchedule)
		{
		ProgramScheduled obj=iProgramScheduleService.updateProgramSchedule(programSchedule);
			return new ResponseEntity<ProgramScheduled>(obj, HttpStatus.OK);
		}

}
