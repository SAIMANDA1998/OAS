package com.cg.oas.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oas.entities.ProgramScheduled;
import com.cg.oas.exception.ProgramScheduleNotFoundException;
import com.cg.oas.repository.IProgramScheduleRepository;
import com.cg.oas.service.IProgramScheduleService;

@Service
public class IProgramScheduleServiceImpl implements IProgramScheduleService{
	@Autowired
	private IProgramScheduleRepository iProgramScheduleRepo;
	@Override
	public ProgramScheduled addProgramSchedule(ProgramScheduled progamSchedule) {	
				return iProgramScheduleRepo.save(progamSchedule);
	}

	@Override
	public List<ProgramScheduled> viewAllProgramScheduleDetails() throws ProgramScheduleNotFoundException{
		List<ProgramScheduled> list=iProgramScheduleRepo.findAll();
		if(list.isEmpty()) {
			throw new ProgramScheduleNotFoundException("No ProgramScheduled Found");
		}
		else
		return iProgramScheduleRepo.findAll();
	}

	@Override
	public List<ProgramScheduled> deleteProgramScheduleById(int scheduleId) throws ProgramScheduleNotFoundException {
	
		Optional<ProgramScheduled> optional = iProgramScheduleRepo.findById(scheduleId);
		if(optional.isPresent()) {
			iProgramScheduleRepo.deleteById(scheduleId);
		return iProgramScheduleRepo.findAll();
		}
		else
			throw new ProgramScheduleNotFoundException("No ProgramScheduuled Found");
	}

	@Override
	public ProgramScheduled getProgramScheduleById(int scheduleId) throws ProgramScheduleNotFoundException{
		Optional<ProgramScheduled> optional = iProgramScheduleRepo.findById(scheduleId);
		if(optional.isPresent()) {
			return optional.get();	
		}
		else
			throw new ProgramScheduleNotFoundException("No ProgramSchedule Found");
	}

	@Override
	public ProgramScheduled updateProgramSchedule(ProgramScheduled programSchedule) throws ProgramScheduleNotFoundException {
		// TODO Auto-generated method stub
		Optional<ProgramScheduled> optional = iProgramScheduleRepo.findById(programSchedule.getScheduleId());
		if(optional.isPresent()) {
			iProgramScheduleRepo.save(programSchedule);
		return programSchedule;
		}
		else
			throw new ProgramScheduleNotFoundException("No ProgramSchedule Found");
	}


}
