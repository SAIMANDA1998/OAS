package com.cg.oas.repository;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.oas.entities.Address;
import com.cg.oas.entities.Application;
@Repository
public interface IApplicationRepository extends JpaRepository<Application,Integer>
{
//	public Application addApplication(Application application);
//	public ArrayList<Application> viewAllApplicationDetails();
//	public  ArrayList<Application> getApplicationDetailsByEmail(String email);
//	public  ArrayList<Application> getApplicationDetailsByStatus(String status);
//	public int deleteApplicationById(int applicationId);
//	public int deleteApplicationByEmail(String email);
//	public Application getApplicationById(int applicationId);
//	public int  updateApplicationStatus(Application app);
//	//can add more funtion if require as per business logic
	
}
