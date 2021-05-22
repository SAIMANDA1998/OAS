package com.cg.oas.service;

import java.util.List;

import com.cg.oas.entities.ProgramScheduled;

public interface IProgramScheduleService {
	public ProgramScheduled addProgramSchedule(ProgramScheduled programSchedule);
	public List<ProgramScheduled> viewAllProgramScheduleDetails();
	//public  ArrayList<ProgramScheduled> getProgramScheduleByCollegeName(String collegeName);
	//public  ArrayList<ProgramScheduled> getProgramScheduleByDate(String date);
	public  List<ProgramScheduled> deleteProgramScheduleById(int scheduleId);
//	public int deleteProgramScheduleByDate(String startDate);
	public ProgramScheduled getProgramScheduleById(int scheduleId);
	public ProgramScheduled  updateProgramSchedule(ProgramScheduled programSchedule);
	//as per requirment can be added more function
}
