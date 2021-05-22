package com.cg.oas.service;
import java.util.ArrayList;
import java.util.List;

import com.cg.oas.entities.Application;

public interface IApplicationService 
{
	public Application addApplication(Application application);
	public List<Application> viewAllApplicationDetails();
	//public  ArrayList<Application> getApplicationDetailsByEmail(String email);
	//public  ArrayList<Application> getApplicationDetailsByStatus(String status);
	public List<Application> deleteApplicationById(int applicationId);
	//public int deleteApplicationByEmail(String email);
	public Application getApplicationById(int applicationId);
	public Application  updateApplicationStatus(Application app);
	//can add more funtion if require as per business logic
	
}
