package com.cg.oas.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oas.entities.Branch;
import com.cg.oas.entities.Course;
import com.cg.oas.exception.BranchNotFoundException;
import com.cg.oas.exception.CourseNotFoundException;
import com.cg.oas.repository.ICourseRepository;
import com.cg.oas.service.ICourseService;
@Service
public class ICourseServiceImpl implements ICourseService {
	@Autowired
	private ICourseRepository iCourseRepo;

	@Override
	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
		return iCourseRepo.save(course);
	}

	@Override
	public List<Course> viewAllCourseDetails() throws CourseNotFoundException {
			List<Course> list=iCourseRepo.findAll();
			if(list.isEmpty()) {
				throw new CourseNotFoundException("No Course Found");
			}
			else
			return iCourseRepo.findAll();
	}
	@Override
		public Course getCourseDetailsByCourseId(int courseId) throws CourseNotFoundException{
			Optional<Course> optional = iCourseRepo.findById(courseId);
			if(optional.isPresent()) {
				return optional.get();	
			}
			else
				throw new CourseNotFoundException("No Course Found");
	}

	@Override
		public List<Course> deleteCourseById(int courseById) throws CourseNotFoundException {
			Optional<Course> optional = iCourseRepo.findById(courseById);
			if(optional.isPresent()) {
				iCourseRepo.deleteById(courseById);
			return iCourseRepo.findAll();
			}
			else
				throw new CourseNotFoundException("No Course Found");
		}
	@Override
		public Course updateCourseDetails(Course course) throws CourseNotFoundException{
			// TODO Auto-generated method stub
			Optional<Course> optional = iCourseRepo.findById(course.getCourseId());
			if(optional.isPresent()) {
				iCourseRepo.save(course);
			return course;
			}
			else
				throw new CourseNotFoundException("No Course Found");
		}
	}


