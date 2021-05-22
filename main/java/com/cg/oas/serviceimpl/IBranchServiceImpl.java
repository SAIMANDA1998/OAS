package com.cg.oas.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oas.entities.Address;
import com.cg.oas.entities.Branch;
import com.cg.oas.exception.AddressIdNotFoundException;
import com.cg.oas.exception.BranchNotFoundException;
import com.cg.oas.repository.IBranchRepository;
import com.cg.oas.service.IBranchService;

@Service
public class IBranchServiceImpl implements IBranchService{
	@Autowired
	private IBranchRepository iBranchRepo;

	@Override
	public Branch addBranch(Branch branch) {
		// TODO Auto-generated method stub
		return iBranchRepo.save(branch);
	}

	@Override
		public List<Branch> viewAllBranchDetails() throws BranchNotFoundException {
			List<Branch> list=iBranchRepo.findAll();
			if(list.isEmpty()) {
				throw new BranchNotFoundException("No Branch Found");
			}
			else
			return iBranchRepo.findAll();
	}

	@Override
		public List<Branch> deleteBranchById(int branchId) throws BranchNotFoundException {
			Optional<Branch> optional = iBranchRepo.findById(branchId);
			if(optional.isPresent()) {
				iBranchRepo.deleteById(branchId);
			return iBranchRepo.findAll();
			}
			else
				throw new BranchNotFoundException("No Branch Found");
		}

	@Override
		public Branch getBranchById(int branchId) throws BranchNotFoundException{
			// TODO Auto-generated method stub
			Optional<Branch> optional = iBranchRepo.findById(branchId);
			if(optional.isPresent()) {
				return optional.get();	
			}
			else
				throw new BranchNotFoundException("No Branch Found");
	}

	@Override
		public Branch updateBranch(Branch branch) throws BranchNotFoundException{
			// TODO Auto-generated method stub
			Optional<Branch> optional = iBranchRepo.findById(branch.getBranchId());
			if(optional.isPresent()) {
				iBranchRepo.save(branch);
			return branch;
			}
			else
				throw new BranchNotFoundException("No Branch Found");
		}
	}


