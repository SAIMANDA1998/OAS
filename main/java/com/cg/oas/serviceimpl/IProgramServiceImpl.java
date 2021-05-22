package com.cg.oas.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oas.entities.Program;
import com.cg.oas.exception.AddressIdNotFoundException;
import com.cg.oas.exception.ProgramNotFoundException;
import com.cg.oas.repository.IProgramRepository;
import com.cg.oas.service.IProgramService;

@Service
public class IProgramServiceImpl implements IProgramService{
	@Autowired
	private IProgramRepository iProgramRepo;
	@Override
	public Program addProgram(Program program) {
			return iProgramRepo.save(program);
		}
	
	@Override
	public List<Program> viewAllProgramDetails() throws ProgramNotFoundException{
			List<Program> list=iProgramRepo.findAll();
			if(list.isEmpty()) {
				throw new ProgramNotFoundException("No Program Found");
			}
			else
			return iProgramRepo.findAll();
			}

	@Override
	public List<Program> deleteProgramById(int programId) throws ProgramNotFoundException {
			Optional<Program> optional = iProgramRepo.findById(programId);
			if(optional.isPresent()) {
			iProgramRepo.deleteById(programId);
			return iProgramRepo.findAll();
			}
			else
				throw new ProgramNotFoundException("No Program Found");
		}
	
	@Override
	public Program getProgramById(int programId) throws ProgramNotFoundException  {
			Optional<Program> optional = iProgramRepo.findById(programId);
			if(optional.isPresent()) {
				return optional.get();	
			}
			else
				throw new ProgramNotFoundException("No Program Found");
			
	}

	@Override
	public Program updateProgramStatus(Program program) throws ProgramNotFoundException{
			Optional<Program> optional = iProgramRepo.findById(program.getProgramId());
			if(optional.isPresent()) {
			iProgramRepo.save(program);
			return program;
			}
			else
				throw new AddressIdNotFoundException("No Program Found");
	}
	

}
