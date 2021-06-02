package com.cg.oas;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.oas.entities.Address;
import com.cg.oas.entities.Branch;
import com.cg.oas.entities.College;
import com.cg.oas.entities.Program;
import com.cg.oas.entities.University;
import com.cg.oas.repository.IUniversityRepository;
import com.cg.oas.service.IUniversityService;

@SpringBootTest
public class UniversityTest {

	
	@Autowired
	IUniversityService iUniversityService;
	
	@MockBean
	IUniversityRepository iUniversityRepo;
	
	@Test
	public void testAddUniversity() {
		University uni = new University();
		uni.setUniversityId(101);
		uni.setName("JNTUK");
		uni.setAddress(
				new Address(10,"Kakinada", "East Godavari", "Andhra Pradesh", "India", "533001","city")
			);
		
		List<College> collegeList = new ArrayList<College>();
		List<Program> programList = new ArrayList<Program>();
		programList.add(new Program(5,"java","Coding","60","4","B.Tech"));

		List<Branch> branchList = new ArrayList<Branch>();
		branchList.add(new Branch(5,"CSE","Coding"));


		collegeList.add(
				new College(
						15,
						"IARE",
						new Address(1,"Hyderabad", "Ranga Reddy", "Telangna", "India", "500090", "Beside Park"),
						programList,
						branchList,
						new University("JNTU",
								120,
								new Address(1, "Hyderabad", "Ranga Reddy", "Telangna", "India", "500090", "Beside Park"),
								null)
				));
		
		when(iUniversityRepo.save(uni)).thenReturn(uni);
		assertEquals(uni, iUniversityService.addUniversity(uni));
	}

	@Test
	public void testviewAllUniversityDetails() {
//		List<University> uni = new ArrayList<>();
//        Mockito.when(iUniversityRepo.findAll()).thenReturn(uni);
//        Exception ex = assertThrows(UniversityNotFoundException.class, ()-> iUniversityService.viewAllUniversityDetails());
//        assertEquals("No Document Found", ex.getMessage());
        
        int count = iUniversityRepo.unversityCount();
        List<University> universityList = iUniversityRepo.findAll();
        assertEquals(count, universityList.size());
        
	}
	

	@Test
	public void testdeleteUniversityById() {
		University uni = new University();
		uni.setUniversityId(101);
		uni.setName("JNTUK");
		uni.setAddress(
				new Address(10,"Kakinada", "East Godavari", "Andhra Pradesh", "India", "533001","city")
			);
		
		List<College> collegeList = new ArrayList<College>();
		List<Program> programList = new ArrayList<Program>();
		programList.add(new Program(5,"java","Coding","60","4","B.Tech"));

		List<Branch> branchList = new ArrayList<Branch>();
		branchList.add(new Branch(5,"CSE","Coding"));


		collegeList.add(
				new College(
						15,
						"IARE",
						new Address(1,"Hyderabad", "Ranga Reddy", "Telangna", "India", "500090", "Beside Park"),
						programList,
						branchList,
						new University("JNTU",
								120,
								new Address(1, "Hyderabad", "Ranga Reddy", "Telangna", "India", "500090", "Beside Park"),
								null)
				));
		
		int nUniversitySize = iUniversityRepo.findAll().size();
		iUniversityRepo.deleteById(101);
		int pUniversitySize = iUniversityRepo.findAll().size();
		assertThat(nUniversitySize).isEqualTo(pUniversitySize);
	}

	@Test
	public void testgetUniversityById() {
		University uni = new University();
		uni.setUniversityId(101);
		uni.setName("JNTUK");
		uni.setAddress(
				new Address(10,"Kakinada", "East Godavari", "Andhra Pradesh", "India", "533001","city")
			);
		
		List<College> collegeList = new ArrayList<College>();
		List<Program> programList = new ArrayList<Program>();
		programList.add(new Program(5,"java","Coding","60","4","B.Tech"));

		List<Branch> branchList = new ArrayList<Branch>();
		branchList.add(new Branch(5,"CSE","Coding"));


		collegeList.add(
				new College(
						15,
						"IARE",
						new Address(1,"Hyderabad", "Ranga Reddy", "Telangna", "India", "500090", "Beside Park"),
						programList,
						branchList,
						new University("JNTU",
								120,
								new Address(1, "Hyderabad", "Ranga Reddy", "Telangna", "India", "500090", "Beside Park"),
								null)
				));
		 Mockito.when(iUniversityRepo.findById(uni.getUniversityId())).thenReturn(Optional.of(uni));
	        assertThat(iUniversityService.getUniversityById(uni.getUniversityId())).isEqualTo(uni);
	}
	
	@Test
	public void testupdateUniversity() {
		University uni = new University();
		uni.setUniversityId(101);
		uni.setName("JNTUK");
		uni.setAddress(
				new Address(10,"Kakinada", "East Godavari", "Andhra Pradesh", "India", "533001","city")
			);
		
		List<College> collegeList = new ArrayList<College>();
		List<Program> programList = new ArrayList<Program>();
		programList.add(new Program(5,"java","Coding","60","4","B.Tech"));

		List<Branch> branchList = new ArrayList<Branch>();
		branchList.add(new Branch(5,"CSE","Coding"));


		collegeList.add(
				new College(
						15,
						"IARE",
						new Address(1,"Hyderabad", "Ranga Reddy", "Telangna", "India", "500090", "Beside Park"),
						programList,
						branchList,
						new University("JNTU",
								120,
								new Address(1, "Hyderabad", "Ranga Reddy", "Telangna", "India", "500090", "Beside Park"),
								null)
				));
		  Mockito.when(iUniversityRepo.findById(uni.getUniversityId())).thenReturn(Optional.of(uni));
	       
	        uni.setName("JNtukakinada");
	        Mockito.when(iUniversityRepo.save(uni)).thenReturn(uni);
	       
	        assertThat(iUniversityService.updateUniversity(uni)).isEqualTo(uni);
	}

}
