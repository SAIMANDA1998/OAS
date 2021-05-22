package com.cg.oas;

	import static org.assertj.core.api.Assertions.assertThat;
	import static org.mockito.Mockito.mockitoSession;

	import java.time.LocalDate;

	import org.junit.jupiter.api.Test;
	import org.mockito.Mockito;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.context.SpringBootTest;
	import org.springframework.boot.test.mock.mockito.MockBean;

	import com.cg.oas.entities.Application;
	import com.cg.oas.repository.IApplicationRepository;
	import com.cg.oas.serviceimpl.IApplicationServiceImpl;
	import com.sun.el.stream.Optional;

	@SpringBootTest
	public class ApplicationTest extends OasApplicationTests {
		
		@Autowired
		IApplicationServiceImpl iApplicationService;
		
		@MockBean
		IApplicationRepository iApplicationRepository;
		
		
		@Test
		public void testaddApplication()
		{
			Application app= new Application();
			app.setApplicationId(9);
			app.setApplicantFullName("sai");
			app.setDateOfBirth(LocalDate.of(1998,9,23));
			app.setHighestQualification("Btech");
			app.setFinalYearPercentage(87);
			app.setGoals("Capg");
			app.setEmailId("saitejaswi123@gmail.com");
			app.setApplicationStatus("pending");
			
			Mockito.when(iApplicationRepository.save(app)).thenReturn(app);
			//assertThat(iApplicationRepository.addApplication(app)).isEqualTo(app);
			
		}
		

}
