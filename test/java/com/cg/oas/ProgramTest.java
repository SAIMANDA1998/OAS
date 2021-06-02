package com.cg.oas;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.oas.entities.College;
import com.cg.oas.entities.Program;
import com.cg.oas.exception.ProgramNotFoundException;
import com.cg.oas.repository.IProgramRepository;
import com.cg.oas.service.IProgramService;

@SpringBootTest
public class ProgramTest {
	@Autowired 
	IProgramService iProgramService;
	@MockBean
	IProgramRepository iProgramRepo;
	@Test
	public void testAddProgram()
	{
		Program program = new Program();
		College college = new College();
		program.setProgramId(8);
		program.setProgramName("ECE");
		program.setProgramDescription("Electronics");
		program.setProgramEligibility("Inter Passed");
		program.setProgramDuration("4 years");
		program.setDegreeOffered("btech");
	    college.setCollegeRegId(4);
		Mockito.when(iProgramRepo.save(program)).thenReturn(program);
		assertThat(iProgramService.addProgram(program)).isEqualTo(program);
	}

	 @Test
	    public void testUpdateProgramStatus()
	    {  
		   College college = new College();
	       Program program = new Program();
	       program.setProgramId(8);
	       program.setProgramName("ECE");
			program.setProgramDescription("Electronics");
			program.setProgramEligibility("Inter Passed");
			program.setProgramDuration("4 years");
			program.setDegreeOffered("btech");	
			college.setCollegeRegId(4);
	        Mockito.when(iProgramRepo.findById(program.getProgramId())).thenReturn(Optional.of(program));
	       
	        program.setProgramName("EEE");
	        Mockito.when(iProgramRepo.save(program)).thenReturn(program);
	       
	        assertThat(iProgramService.updateProgramStatus(program)).isEqualTo(program);
	       
	    }
	 @Test
	    public void testviewAllProgramDetails()
	    {
	        List<Program> program = new ArrayList<>();
	        Mockito.when(iProgramRepo.findAll()).thenReturn(program);
	        Exception ex = assertThrows(ProgramNotFoundException.class, ()-> iProgramService.viewAllProgramDetails());
	        assertEquals("No Program Found", ex.getMessage());
	       
	    }
	 @Test
	    public void testgetProgramById()
	    {
	       Program program = new Program();
	       College college = new College();
	       program.setProgramId(8);
	       program.setProgramName("ECE");
			program.setProgramDescription("Electronics");
			program.setProgramEligibility("Inter Passed");
			program.setProgramDuration("4 years");
			program.setDegreeOffered("btech");	
			college.setCollegeRegId(4);
	       
	        Mockito.when(iProgramRepo.findById(8)).thenReturn(Optional.of(program));
	        Mockito.when(iProgramRepo.existsById(program.getProgramId())).thenReturn(false);
	       assertFalse(iProgramRepo.existsById(program.getProgramId()));
	    }
	 public void testdeleteProgramById()
	    {
	        Program program = new Program();
	        College college = new College();
	        program.setProgramId(8);
		       program.setProgramName("ECE");
				program.setProgramDescription("Electronics");
				program.setProgramEligibility("Inter Passed");
				program.setProgramDuration("4 years");
				program.setDegreeOffered("btech");	
				college.setCollegeRegId(4);
	        Mockito.when(iProgramRepo.findById(8)).thenReturn(Optional.of(program));
	        Mockito.when(iProgramRepo.existsById(program.getProgramId())).thenReturn(false);
	       assertFalse(iProgramRepo.existsById(program.getProgramId()));
	    }
	 
	
}

