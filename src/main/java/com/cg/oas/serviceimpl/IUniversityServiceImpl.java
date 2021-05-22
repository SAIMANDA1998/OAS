package com.cg.oas.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oas.entities.University;
import com.cg.oas.exception.UniversityNotFoundException;
import com.cg.oas.repository.IUniversityRepository;
import com.cg.oas.service.IUniversityService;
@Service
public class IUniversityServiceImpl implements IUniversityService{
	@Autowired
	private IUniversityRepository iUniversityRepo;
	@Override
	public University addUniversity(University university) {
		return iUniversityRepo.save(university);
	}

	@Override
	public List<University> viewAllUniversityDetails() throws UniversityNotFoundException{
		// TODO Auto-generated method stub
		List<University> list=iUniversityRepo.findAll();
		if(list.isEmpty()) {
			throw new UniversityNotFoundException("No University Found");
		}
		else
		return iUniversityRepo.findAll();
	}

	@Override
	public List<University> deleteUniversityById(int universityId) throws UniversityNotFoundException{
		
		Optional<University> optional = iUniversityRepo.findById(universityId);
		if(optional.isPresent()) {
			iUniversityRepo.deleteById(universityId);
		return iUniversityRepo.findAll();
		}
		else
			throw new UniversityNotFoundException("No University Id");
	}

	@Override
	public University getUniversityById(int applicationId) throws UniversityNotFoundException {
		
		Optional<University> optional = iUniversityRepo.findById(applicationId);
		if(optional.isPresent()) {
			return optional.get();	
		}
		else
			throw new UniversityNotFoundException("No University Found");
}

	@Override
	public University updateUniversity(University university) throws UniversityNotFoundException {

		Optional<University> optional = iUniversityRepo.findById(university.getUniversityId());
		if(optional.isPresent()) {
			iUniversityRepo.save(university);
		return university;
		}
		else
			throw new UniversityNotFoundException("No university Id");
	}


}
