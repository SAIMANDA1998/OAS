package com.cg.oas;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

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
import com.cg.oas.entities.Course;
import com.cg.oas.entities.Program;
import com.cg.oas.entities.ProgramScheduled;
import com.cg.oas.entities.University;
import com.cg.oas.repository.ICollegeRepository;
import com.cg.oas.service.ICollegeService;
@SpringBootTest
public class CollegeTest {
	
		@Autowired
		ICollegeService iCollegeService;
		
		@MockBean
		ICollegeRepository iCollegeRepo;
		
		@Test
		public void testaddCollege()
		{
			College col= new College();
			col.setCollegeRegId(6);
			col.setCollegeName("vtu");
			col.setCollegeAddress(new Address(8,"clp","krishna","AP","India","521126","opp police station"));
			col.setUniversityName(new University("vel",34,new Address(1,"Hyderabad", "Ranga Reddy", "Telangna", "India", "500090", "Beside Park"), null));
			
			List<Program> programList = new ArrayList<Program>();
			programList.add(new Program(5,"java","Coding","60","4","B.Tech"));
			
			List<Branch> branchList = new ArrayList<Branch>();
			branchList.add(new Branch(5,"CSE","Coding"));
			List<Course> courseList = new ArrayList<Course>();
			courseList.add(
					new Course(1,
							"M.tech",
							"Mechanical Engineering",
							"65",
							new College(
								15,
								"IARE",
								new Address(1,"Hyderabad", "Ranga Reddy", "Telangna", "India", "500090", "Beside Park"),
								programList,
								branchList,
								new University("JNTU",
										120,
										new Address(1, "Hyderabad", "Ranga Reddy", "Telangna", "India", "500090", "Beside Park"),
										null))
							));
			Mockito.when(iCollegeRepo.save(col)).thenReturn(col);
			assertThat(iCollegeService.addCollege(col)).isEqualTo(col);
			
			
		}
		@Test
	    public void testViewAllCollegeDetails()
	    {
			College col1= new College();
			col1.setCollegeRegId(6);
			col1.setCollegeName("vtu");
			col1.setCollegeAddress(new Address(8,"clp","krishna","AP","India","521126","opp police station"));
			col1.setUniversityName(new University("vel",34,new Address(1,"Hyderabad", "Ranga Reddy", "Telangna", "India", "500090", "Beside Park"), null));
			
			List<Program> programList = new ArrayList<Program>();
			programList.add(new Program(5,"java","Coding","60","4","B.Tech"));
			
			List<Branch> branchList = new ArrayList<Branch>();
			branchList.add(new Branch(5,"CSE","Coding"));
			List<Course> courseList = new ArrayList<Course>();
			courseList.add(
					new Course(1,
							"M.tech",
							"Mechanical Engineering",
							"65",
							new College(
								15,
								"IARE",
								new Address(1,"Hyderabad", "Ranga Reddy", "Telangna", "India", "500090", "Beside Park"),
								programList,
								branchList,
								new University("JNTU",
										120,
										new Address(1, "Hyderabad", "Ranga Reddy", "Telangna", "India", "500090", "Beside Park"),
										null))
							));
			
			College col2= new College();
			col2.setCollegeRegId(6);
			col2.setCollegeName("vtu");
			col2.setCollegeAddress(new Address(8,"clp","krishna","AP","India","521126","opp police station"));
			col2.setUniversityName(new University("vel",34,new Address(1,"Hyderabad", "Ranga Reddy", "Telangna", "India", "500090", "Beside Park"), null));
			
			List<Program> programList2 = new ArrayList<Program>();
			programList2.add(new Program(5,"java","Coding","60","4","B.Tech"));
			
			List<Branch> branchList2 = new ArrayList<Branch>();
			branchList.add(new Branch(5,"CSE","Coding"));
			List<Course> courseList2 = new ArrayList<Course>();
			courseList.add(
					new Course(1,
							"M.tech",
							"Mechanical Engineering",
							"65",
							new College(
								15,
								"IARE",
								new Address(1,"Hyderabad", "Ranga Reddy", "Telangna", "India", "500090", "Beside Park"),
								programList2,
								branchList,
								new University("JNTU",
										120,
										new Address(1, "Hyderabad", "Ranga Reddy", "Telangna", "India", "500090", "Beside Park"),
										null))
							));
			List<College> col = new ArrayList<>();
			col.add(col1); col.add(col2);
		        Mockito.when(iCollegeRepo.findAll()).thenReturn(col);
		        assertThat(iCollegeService.viewAllCollegeDetails()).isEqualTo(col);
		    }
		   
		@Test
		public void testDeleteCollegeById()
	    {
			College col= new College();
			col.setCollegeRegId(6);
			col.setCollegeName("vtu");
			col.setCollegeAddress(new Address(8,"clp","krishna","AP","India","521126","opp police station"));
			col.setUniversityName(new University("vel",34,new Address(1,"Hyderabad", "Ranga Reddy", "Telangna", "India", "500090", "Beside Park"), null));
			
			List<Program> programList = new ArrayList<Program>();
			programList.add(new Program(5,"java","Coding","60","4","B.Tech"));
			
			List<Branch> branchList = new ArrayList<Branch>();
			branchList.add(new Branch(5,"CSE","Coding"));
			List<Course> courseList = new ArrayList<Course>();
			courseList.add(
					new Course(1,
							"M.tech",
							"Mechanical Engineering",
							"65",
							new College(
								15,
								"IARE",
								new Address(1,"Hyderabad", "Ranga Reddy", "Telangna", "India", "500090", "Beside Park"),
								programList,
								branchList,
								new University("JNTU",
										120,
										new Address(1, "Hyderabad", "Ranga Reddy", "Telangna", "India", "500090", "Beside Park"),
										null))
							));
			
	        Mockito.when(iCollegeRepo.findById(503)).thenReturn(Optional.of(col));
	        Mockito.when(iCollegeRepo.existsById(col.getCollegeRegId())).thenReturn(false);
	       assertFalse(iCollegeRepo.existsById(col.getCollegeRegId()));
	    }
		 @Test
		    public void testUpdateCollege()
		    {
			 College col= new College();
				col.setCollegeRegId(6);
				col.setCollegeName("vtu");
				col.setCollegeAddress(new Address(8,"clp","krishna","AP","India","521126","opp police station"));
				col.setUniversityName(new University("vel",34,new Address(1,"Hyderabad", "Ranga Reddy", "Telangna", "India", "500090", "Beside Park"), null));
				
				List<Program> programList = new ArrayList<Program>();
				programList.add(new Program(5,"java","Coding","60","4","B.Tech"));
				
				List<Branch> branchList = new ArrayList<Branch>();
				branchList.add(new Branch(5,"CSE","Coding"));
				List<Course> courseList = new ArrayList<Course>();
				courseList.add(
						new Course(1,
								"M.tech",
								"Mechanical Engineering",
								"65",
								new College(
									15,
									"IARE",
									new Address(1,"Hyderabad", "Ranga Reddy", "Telangna", "India", "500090", "Beside Park"),
									programList,
									branchList,
									new University("JNTU",
											120,
											new Address(1, "Hyderabad", "Ranga Reddy", "Telangna", "India", "500090", "Beside Park"),
											null))
								));
				 Mockito.when(iCollegeRepo.findById(col.getCollegeRegId())).thenReturn(Optional.of(col));

		        col.setCollegeName("veltech");
		        Mockito.when(iCollegeRepo.save(col)).thenReturn(col);
		       
		        assertThat(iCollegeService.updateCollegeDetails(col)).isEqualTo(col);
		       
		    }
		 @Test
		    public void testGetCollegeDetailsById()
		    {
			 College col= new College();
				col.setCollegeRegId(6);
				col.setCollegeName("vtu");
				col.setCollegeAddress(new Address(8,"clp","krishna","AP","India","521126","opp police station"));
				col.setUniversityName(new University("vel",34,new Address(1,"Hyderabad", "Ranga Reddy", "Telangna", "India", "500090", "Beside Park"), null));
				
				List<Program> programList = new ArrayList<Program>();
				programList.add(new Program(5,"java","Coding","60","4","B.Tech"));
				
				List<Branch> branchList = new ArrayList<Branch>();
				branchList.add(new Branch(5,"CSE","Coding"));
				List<Course> courseList = new ArrayList<Course>();
				courseList.add(
						new Course(1,
								"M.tech",
								"Mechanical Engineering",
								"65",
								new College(
									15,
									"IARE",
									new Address(1,"Hyderabad", "Ranga Reddy", "Telangna", "India", "500090", "Beside Park"),
									programList,
									branchList,
									new University("JNTU",
											120,
											new Address(1, "Hyderabad", "Ranga Reddy", "Telangna", "India", "500090", "Beside Park"),
											null))
								));
			
		        Mockito.when(iCollegeRepo.findById(col.getCollegeRegId())).thenReturn(Optional.of(col));
		        assertThat(iCollegeService.getCollegeDetailsById(col.getCollegeRegId())).isEqualTo(col);
		    }
//		 @Test
//		 public void testgetgetCollegeDetailsByProgramName() {
//			 College col= new College();
//				ProgramScheduled pros = new ProgramScheduled();
//
//				col.setCollegeRegId(6);
//				col.setCollegeName("vtu");
//				col.setCollegeAddress(new Address(8,"clp","krishna","AP","India","521126","opp police station"));
//				col.setUniversityName(new University("vel",34,new Address(1,"Hyderabad", "Ranga Reddy", "Telangna", "India", "500090", "Beside Park"), null));
//				
//				List<Program> programList = new ArrayList<Program>();
//				programList.add(new Program(5,"java","Coding","60","4","B.Tech"));
//				
//				List<Branch> branchList = new ArrayList<Branch>();
//				branchList.add(new Branch(5,"CSE","Coding"));
//				List<Course> courseList = new ArrayList<Course>();
//				courseList.add(
//						new Course(1,
//								"M.tech",
//								"Mechanical Engineering",
//								"65",
//								new College(
//									15,
//									"IARE",
//									new Address(1,"Hyderabad", "Ranga Reddy", "Telangna", "India", "500090", "Beside Park"),
//									programList,
//									branchList,
//									new University("JNTU",
//											120,
//											new Address(1, "Hyderabad", "Ranga Reddy", "Telangna", "India", "500090", "Beside Park"),
//											null))
//								));
//				Mockito.when(iCollegeRepo.("java")).thenReturn(cust);
//				assertThat(iCollegeService.ViewAllCustomers("Kolkata")).isEqualTo(cust);
////				Mockito.when(iCollegeRepo.findAll(col.ProgramName())).thenReturn(Optional.of(col));
////		        assertThat(iCollegeService.getCollegeDetailsByProgramId(pros.getscheduleId())).isEqualTo(col);	
//		 }
	

	}