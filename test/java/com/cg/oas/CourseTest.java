package com.cg.oas;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
//import java.util.Optional;

import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.oas.entities.Address;
import com.cg.oas.entities.Branch;
import com.cg.oas.entities.College;
import com.cg.oas.entities.Course;
import com.cg.oas.entities.Program;
import com.cg.oas.entities.University;
import com.cg.oas.repository.ICourseRepository;
import com.cg.oas.service.ICourseService;

@SpringBootTest
class CourseTest {

	@Autowired
	private ICourseService courseService;

	@MockBean
	private ICourseRepository courseRepo;

	@Test
	public void getCoursesTest() {

		List<Course> courseList = new ArrayList<Course>();
		List<Program> programList = new ArrayList<Program>();
		programList.add(new Program(5,"java","Coding","60","4","B.Tech"));

		List<Branch> branchList = new ArrayList<Branch>();
		branchList.add(new Branch(5,"CSE","Coding"));
		
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
		courseList.add(
				new Course(2,
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
	
		when(courseRepo.findAll()).thenReturn(courseList);
		assertEquals(2, courseService.viewAllCourseDetails().size());
	}

	@Test
	public void createCourseTest() {
		List<Program> programList = new ArrayList<Program>();
		programList.add(new Program(5,"java","Coding","60","4","B.Tech"));

		List<Branch> branchList = new ArrayList<Branch>();
		branchList.add(new Branch(5,"CSE","Coding"));
		
		
		Course course = new Course(2,
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
						);
		when(courseRepo.save(course)).thenReturn(course);
		assertEquals(course, courseService.addCourse(course));
	}
	

	@Test
	public void updateCourseTest() {
		List<Program> programList = new ArrayList<Program>();
		programList.add(new Program(5,"java","Coding","60","4","B.Tech"));

		List<Branch> branchList = new ArrayList<Branch>();
		branchList.add(new Branch(5,"CSE","Coding"));
		
		Course course = new Course(2,
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
						);
		when(courseRepo.save(course)).thenReturn(course);
		assertEquals(course, courseService.addCourse(course));
	}

	@Test
	public void deleteCourse() {
		
		List<Program> programList = new ArrayList<Program>();
		programList.add(new Program(5,"java","Coding","60","4","B.Tech"));

		List<Branch> branchList = new ArrayList<Branch>();
		branchList.add(new Branch(5,"CSE","Coding"));
		
		
		courseRepo.save(
				new Course(
						2,
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
						)
				);
		int nCourseSize = courseRepo.findAll().size();
		courseRepo.deleteById(2);
		int pCourseSize = courseRepo.findAll().size();
		assertThat(nCourseSize).isEqualTo(pCourseSize);
		
	}

}