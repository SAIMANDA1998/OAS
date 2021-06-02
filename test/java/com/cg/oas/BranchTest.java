package com.cg.oas;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.oas.entities.Address;
import com.cg.oas.entities.Branch;
import com.cg.oas.entities.College;
import com.cg.oas.entities.Branch;
import com.cg.oas.entities.Program;
import com.cg.oas.entities.University;
import com.cg.oas.repository.IBranchRepository;
import com.cg.oas.service.IBranchService;

@SpringBootTest
public class BranchTest {

	@Autowired
	private IBranchService iBranchService;

	@MockBean
	private IBranchRepository iBranchRepo;

	@Test
	public void getBranchsTest() {

		List<Branch> branchList = new ArrayList<>();
		
		branchList.add(new Branch(5,"CSE","Coding"));
		branchList.add(new Branch(1,"ECE","IOT"));
		
		when(iBranchRepo.findAll()).thenReturn(branchList);
		assertEquals(2, iBranchService.viewAllBranchDetails().size()); 
	}

	@Test
	public void createBranchTest() {
		Branch branch = new Branch(5,"CSE","Coding");
		iBranchService.addBranch(branch);
		when(iBranchRepo.save(branch)).thenReturn(branch);
		assertEquals(branch, iBranchService.addBranch(branch));
	}
	

	@Test
	public void updateBranchTest() {

		Branch branch = new Branch(5,"CSE","Coding");
		iBranchService.addBranch(branch);
		when(iBranchRepo.save(branch)).thenReturn(branch);
		assertEquals(branch, iBranchService.addBranch(branch));
	}

	@Test
	public void deleteBranch() {

		Branch branch = new Branch();
		branch.setBranchId(1);
		branch.setBranchName("ECE");
		branch.setBranchDescription("IOT");
		
		when(iBranchRepo.findById(branch.getBranchId())).thenReturn(Optional.of(branch));
		iBranchService.deleteBranchById(branch.getBranchId());
		verify(iBranchRepo).deleteById(branch.getBranchId());
		
	}

}

	
