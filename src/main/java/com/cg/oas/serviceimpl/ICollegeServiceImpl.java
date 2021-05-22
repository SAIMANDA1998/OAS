package com.cg.oas.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oas.entities.College;
import com.cg.oas.entities.Program;
import com.cg.oas.exception.CollegeNotFoundException;
import com.cg.oas.repository.ICollegeRepository;
import com.cg.oas.repository.IProgramRepository;
import com.cg.oas.service.ICollegeService;

@Service
public class ICollegeServiceImpl implements ICollegeService {
	@Autowired
	private ICollegeRepository iCollegeRepo;
	@Autowired
	private IProgramRepository iProgramRepo;

	@Override
	public College addCollege(College college) {
		// TODO Auto-generated method stub
		return iCollegeRepo.save(college);
	}

	@Override
	public List<College> viewAllCollegeDetails() throws CollegeNotFoundException {
			List<College> list=iCollegeRepo.findAll();
			if(list.isEmpty()) {
				throw new CollegeNotFoundException("No College Found");
			}
			else
			return iCollegeRepo.findAll();
	}

	@Override
	public Optional<College> getCollegeDetailsByProgram(String programName) throws CollegeNotFoundException{
		List<Program> list=iProgramRepo.findByProgram(programName);
		if(list.isEmpty()) {
			throw new CollegeNotFoundException("No College Found");
		}
		else {
		Optional<College> optional=null;
		for(Program p:list)
		{
			if(p.getProgramName().equals(programName))
			optional=iCollegeRepo.findById(p.getProgramId());
		}
					return optional;
		}
		
	}

//	@Override
//	public List<College> getCollegeDetailsByCourse(String courseName) {
//		List<College> list=iCollegeRepo.findAll();
//		if(list.isEmpty()) {
//			throw new CollegeNotFoundException("No College Found");
//		}
//		else
//		return iCollegeRepo.findAll();
//	}
//
//	@Override
//	public List<College> getCollegeDetailsByBranch(String branchName) {
//		List<College> list=iCollegeRepo.findAll();
//		if(list.isEmpty()) {
//			throw new CollegeNotFoundException("No College Found");
//		}
//		else
//		return iCollegeRepo.findAll();
//	}

	@Override
	public List<College> deleteCollegeById(int collegeId) throws CollegeNotFoundException {
			Optional<College> optional = iCollegeRepo.findById(collegeId);
			if(optional.isPresent()) {
				iCollegeRepo.deleteById(collegeId);
			return iCollegeRepo.findAll();
			}
			else
				throw new CollegeNotFoundException("No College Found");
		}
	@Override
	public College updateCollegeDetails(College college) throws CollegeNotFoundException{
			// TODO Auto-generated method stub
			Optional<College> optional = iCollegeRepo.findById(college.getCollegeRegId());
			if(optional.isPresent()) {
				iCollegeRepo.save(college);
			return college;
			}
			else
				throw new CollegeNotFoundException("No College Found");
		}

	@Override
	public College getCollegeDetailsById(int collegeRegId) throws CollegeNotFoundException{
			// TODO Auto-generated method stub
			Optional<College> optional = iCollegeRepo.findById(collegeRegId);
			if(optional.isPresent()) {
				return optional.get();	
			}
			else
				throw new CollegeNotFoundException("No College Found");
			}
}
