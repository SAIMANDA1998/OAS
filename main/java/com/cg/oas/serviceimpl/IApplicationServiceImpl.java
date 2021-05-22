package com.cg.oas.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oas.entities.Address;
import com.cg.oas.entities.Application;
import com.cg.oas.exception.AddressIdNotFoundException;
import com.cg.oas.exception.ApplicationNotFoundException;
import com.cg.oas.repository.IApplicationRepository;
import com.cg.oas.service.IApplicationService;

@Service
public class IApplicationServiceImpl implements IApplicationService{
	@Autowired
	private IApplicationRepository iApplicationRepo;

	@Override
	public Application addApplication(Application application) {
		// TODO Auto-generated method stub
		return iApplicationRepo.save(application) ;
	}

	@Override
	public List<Application> viewAllApplicationDetails() throws ApplicationNotFoundException {
		List<Application> list=iApplicationRepo.findAll();
		if(list.isEmpty()) {
			throw new ApplicationNotFoundException("No Application Found");
		}
		else
		return iApplicationRepo.findAll();
		}

	@Override
		public List<Application> deleteApplicationById(int applicationId)throws ApplicationNotFoundException {
			Optional<Application> optional =iApplicationRepo.findById(applicationId);
			if(optional.isPresent()) {
				iApplicationRepo.deleteById(applicationId);
			return iApplicationRepo.findAll();
			}
			else
				throw new ApplicationNotFoundException("No Application Found");
	}

	@Override
	public Application getApplicationById(int applicationId) throws ApplicationNotFoundException {
		// TODO Auto-generated method stub
			Optional<Application> optional = iApplicationRepo.findById(applicationId);
			if(optional.isPresent()) {
				return optional.get();	
			}
			else
				throw new ApplicationNotFoundException("No Application Found");
	}

	@Override
		public Application updateApplicationStatus(Application app) throws ApplicationNotFoundException{
			// TODO Auto-generated method stub
			Optional<Application> optional = iApplicationRepo.findById(app.getApplicationId());
			if(optional.isPresent()) {
				iApplicationRepo.save(app);
			return app;
			}
			else
				throw new ApplicationNotFoundException("No Application Found");
		}
	

}
