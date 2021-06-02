 package com.cg.oas;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.oas.entities.Address;
import com.cg.oas.entities.Branch;
import com.cg.oas.entities.College;
import com.cg.oas.entities.Course;
import com.cg.oas.entities.Program;
import com.cg.oas.entities.ProgramScheduled;
import com.cg.oas.entities.University;
import com.cg.oas.repository.IProgramScheduleRepository;
import com.cg.oas.service.IProgramScheduleService;

@SpringBootTest
public class ProgramScheduledTest {
	@Autowired
	IProgramScheduleService iProgramScheduleService;
	
	@MockBean
	IProgramScheduleRepository iProgramScheduleRepo;
	
	@Test
	public void addProgramSchedule() {
		ProgramScheduled programSchedule = new ProgramScheduled();
		Course course = new Course(1,
				"M.tech",
				"Mechanical Engineering",
				"65",
				null
				);
		
		programSchedule.setScheduleId(300);
		programSchedule.setBranch(new Branch(5,"CSE","Coding"));
		programSchedule.setCourse(course);
		programSchedule.setProgram(new Program(5,"java","Coding","60","4","B.Tech"));
		programSchedule.setCollege(new College(
				15,
				"IARE",
				new Address(1,"Hyderabad", "Ranga Reddy", "Telangna", "India", "500090", "Beside Park"),
				null,
				null,
				new University("JNTU",
						120,
						new Address(1, "Hyderabad", "Ranga Reddy", "Telangna", "India", "500090", "Beside Park"),
						null)));
		programSchedule.setStartDate(LocalDate.now());
		programSchedule.setEndDate(LocalDate.now().plusDays(2));

		when(iProgramScheduleRepo.save(Mockito.any(ProgramScheduled.class))).thenReturn(programSchedule);
		assertEquals(programSchedule, iProgramScheduleService.addProgramSchedule(programSchedule));
	}
	
	@Test
	public void getProgramScheduledById() {
		
		ProgramScheduled programSchedule = new ProgramScheduled();
		Course course = new Course(1,
				"M.tech",
				"Mechanical Engineering",
				"65",
				null
				);
		
		programSchedule.setScheduleId(300);
		programSchedule.setBranch(new Branch(5,"CSE","Coding"));
		programSchedule.setCourse(course);
		programSchedule.setProgram(new Program(5,"java","Coding","60","4","B.Tech"));
		programSchedule.setCollege(new College(
				15,
				"IARE",
				new Address(1,"Hyderabad", "Ranga Reddy", "Telangna", "India", "500090", "Beside Park"),
				null,
				null,
				new University("JNTU",
						120,
						new Address(1, "Hyderabad", "Ranga Reddy", "Telangna", "India", "500090", "Beside Park"),
						null)));
		programSchedule.setStartDate(LocalDate.now());
		programSchedule.setEndDate(LocalDate.now().plusDays(2));
		
		
		
		when(iProgramScheduleService.addProgramSchedule(programSchedule)).thenReturn(programSchedule);
		ProgramScheduled programScheduleNew = iProgramScheduleService.addProgramSchedule(programSchedule);
		assertThat(programScheduleNew).isEqualTo(programSchedule);
	}
	
	@Test
	public void getAllProgramScheduled() {
		
		ProgramScheduled programSchedule = new ProgramScheduled();
		Course course = new Course(1,
				"M.tech",
				"Mechanical Engineering",
				"65",
				null
				);
		
		programSchedule.setScheduleId(300);
		programSchedule.setBranch(new Branch(5,"CSE","Coding"));
		programSchedule.setCourse(course);
		programSchedule.setProgram(new Program(5,"java","Coding","60","4","B.Tech"));
		programSchedule.setCollege(new College(
				15,
				"IARE",
				
				new Address(1,"Hyderabad", "Ranga Reddy", "Telangna", "India", "500090", "Beside Park"),
				null,
				null,
				new University("JNTU",
						120,
						new Address(1, "Hyderabad", "Ranga Reddy", "Telangna", "India", "500090", "Beside Park"),
						null)));
		programSchedule.setStartDate(LocalDate.now());
		programSchedule.setEndDate(LocalDate.now().plusDays(2));
		
		
		
			iProgramScheduleRepo.save(programSchedule);
			when(iProgramScheduleRepo.getProgramScheduledCount()).thenReturn(1);
	     	int count = iProgramScheduleRepo.getProgramScheduledCount();
	        assertEquals(count, 1);
	}
	
	@Test
	public void deleteProgramScheduledById() {
		
		ProgramScheduled programSchedule = new ProgramScheduled();
		Course course = new Course(1,
				"M.tech",
				"Mechanical Engineering",
				"65",
				null
				);
		
		programSchedule.setScheduleId(300);
		programSchedule.setBranch(new Branch(5,"CSE","Coding"));
		programSchedule.setCourse(course);
		programSchedule.setProgram(new Program(5,"java","Coding","60","4","B.Tech"));
		programSchedule.setCollege(new College(
				15,
				"IARE",
				new Address(1,"Hyderabad", "Ranga Reddy", "Telangna", "India", "500090", "Beside Park"),
				null,
				null,
				new University("JNTU",
						120,
						new Address(1, "Hyderabad", "Ranga Reddy", "Telangna", "India", "500090", "Beside Park"),
						null)));
		programSchedule.setStartDate(LocalDate.now());
		programSchedule.setEndDate(LocalDate.now().plusDays(2));
		
		when(iProgramScheduleRepo.findById(programSchedule.getScheduleId())).thenReturn(Optional.of(programSchedule));
		iProgramScheduleService.deleteProgramScheduleById(programSchedule.getScheduleId());
		verify(iProgramScheduleRepo).deleteById(programSchedule.getScheduleId());

	}
	
	@Test
	public void updateProgramScheduleDetails() {
		
		ProgramScheduled programSchedule = new ProgramScheduled();
		Course course = new Course(1,
				"M.tech",
				"Mechanical Engineering",
				"65",
				null
				);
		
		programSchedule.setScheduleId(300);
		programSchedule.setBranch(new Branch(5,"CSE","Coding"));
		programSchedule.setCourse(course);
		programSchedule.setProgram(new Program(5,"java","Coding","60","4","B.Tech"));
		programSchedule.setCollege(new College(
				15,
				"IARE",
				new Address(1,"Hyderabad", "Ranga Reddy", "Telangna", "India", "500090", "Beside Park"),
				null,
				null,
				new University("JNTU",
						120,
						new Address(1, "Hyderabad", "Ranga Reddy", "Telangna", "India", "500090", "Beside Park"),
						null)));
		programSchedule.setStartDate(LocalDate.now());
		programSchedule.setEndDate(LocalDate.now().plusDays(2));

		when(iProgramScheduleRepo.save(programSchedule)).thenReturn(programSchedule);
		assertEquals(programSchedule, iProgramScheduleService.addProgramSchedule(programSchedule));

	}
	
}
