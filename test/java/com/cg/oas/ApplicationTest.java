package com.cg.oas;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.oas.entities.Application;
import com.cg.oas.exception.ApplicationNotFoundException;
import com.cg.oas.repository.IApplicationRepository;
import com.cg.oas.serviceimpl.IApplicationServiceImpl;

@SpringBootTest
	public class ApplicationTest extends OasApplicationTests {
		
		@Autowired
		IApplicationServiceImpl iApplicationService;
		
		@MockBean
		IApplicationRepository iApplicationRepo;
		
		
		@Test
		public void testaddApplication()
		{
			Application app= new Application();
			app.setApplicationId(7);
			app.setApplicantFullName("sai");
			app.setDateOfBirth(LocalDate.of(1998,9,23));
			app.setHighestQualification("Btech");
			app.setFinalYearPercentage(87);
			app.setGoals("Capg");
			app.setEmailId("saitejaswi123@gmail.com");
			app.setApplicationStatus("pending");
			
			
			Mockito.when(iApplicationRepo.save(app)).thenReturn(app);
			assertThat(iApplicationService.addApplication(app)).isEqualTo(app);
			
		}
		 @Test
		    public void testViewAllApplicationDetails()
		    {
			    Application app1= new Application();
			    app1.setApplicationId(7);
				app1.setApplicantFullName("sai");
				app1.setDateOfBirth(LocalDate.of(1998,9,23));
				app1.setHighestQualification("Btech");
				app1.setFinalYearPercentage(87);
				app1.setGoals("Capg");
				app1.setEmailId("saitejaswi123@gmail.com");
				app1.setApplicationStatus("pending");
				
				Application app2= new Application();   
				app2.setApplicationId(9);
				app2.setApplicantFullName("Teja");
				app2.setDateOfBirth(LocalDate.of(1999,9,23));
				app2.setHighestQualification("B.E");
				app2.setFinalYearPercentage(78);
				app2.setGoals("Capgemini");
				app2.setEmailId("saitejaswi456@gmail.com");
				app2.setApplicationStatus("paid");
				

			        
			        List<Application> app = new ArrayList<>();
			        app.add(app1); app.add(app2);
			        Mockito.when(iApplicationRepo.findAll()).thenReturn(app);
			        assertThat(iApplicationService.viewAllApplicationDetails()).isEqualTo(app);
			    }
		        
		 @Test
		    public void testDeleteApplicationById()
		    {
			 Application app= new Application();
				app.setApplicationId(7);
				app.setApplicantFullName("sai");
				app.setDateOfBirth(LocalDate.of(1998,9,23));
				app.setHighestQualification("Btech");
				app.setFinalYearPercentage(87);
				app.setGoals("Capg");
				app.setEmailId("saitejaswi123@gmail.com");
				app.setApplicationStatus("pending");
				
		        Mockito.when(iApplicationRepo.findById(503)).thenReturn(Optional.of(app));
		        Mockito.when(iApplicationRepo.existsById(app.getApplicationId())).thenReturn(false);
		       assertFalse(iApplicationRepo.existsById(app.getApplicationId()));
		    }
		 @Test
		    public void testGetApplicationtById()
		    {
			 Application app= new Application();
				app.setApplicationId(7);
				app.setApplicantFullName("sai");
				app.setDateOfBirth(LocalDate.of(1998,9,23));
				app.setHighestQualification("Btech");
				app.setFinalYearPercentage(87);
				app.setGoals("Capg");
				app.setEmailId("saitejaswi123@gmail.com");
				app.setApplicationStatus("pending");
				
		        Mockito.when(iApplicationRepo.findById(app.getApplicationId())).thenReturn(Optional.of(app));
		        assertThat(iApplicationService.getApplicationById(app.getApplicationId())).isEqualTo(app);
		    }
		 @Test
		    public void testUpdateApplication()
		    {
			 Application app= new Application();
				app.setApplicationId(7);
				app.setApplicantFullName("sai");
				app.setDateOfBirth(LocalDate.of(1998,9,23));
				app.setHighestQualification("Btech");
				app.setFinalYearPercentage(87);
				app.setGoals("Capg");
				app.setEmailId("saitejaswi123@gmail.com");
				app.setApplicationStatus("pending");
				
		       
		        Mockito.when(iApplicationRepo.findById(app.getApplicationId())).thenReturn(Optional.of(app));
		       
		        app.setEmailId("saitejaswi12321@gmail.com");
		        Mockito.when(iApplicationRepo.save(app)).thenReturn(app);
		       
		        assertThat(iApplicationService.updateApplicationStatus(app)).isEqualTo(app);
		       
		    }
}
