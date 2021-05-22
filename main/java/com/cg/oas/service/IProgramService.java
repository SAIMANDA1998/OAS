package com.cg.oas.service;

import java.util.List;

import com.cg.oas.entities.Program;

public interface IProgramService {
	public Program addProgram(Program program);
	public List<Program> viewAllProgramDetails();
	//public  ArrayList<Program> getApplicationDetailsByCollegeName(String collegeName);
	//public  ArrayList<Program> getProgramDetailsByName(String programName);
	//public  ArrayList<Program> getProgramDetailsByEligibility(String eligibility);
	public List<Program> deleteProgramById(int programId);
	//public int deleteProgramByName(String programName);
	public Program getProgramById(int programId);
	public Program  updateProgramStatus(Program program);
}
