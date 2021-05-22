package com.cg.oas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.oas.entities.Application;
import com.cg.oas.entities.Branch;
import com.cg.oas.service.IBranchService;

@RestController
@RequestMapping("/branch")
public class BranchController {
	@Autowired
	private IBranchService iBranchService;
	@PostMapping("/addBranch")
	public ResponseEntity<Branch> addBranch(@RequestBody Branch branch)
	{
		Branch obj=iBranchService.addBranch(branch);
		return new ResponseEntity<Branch>(obj, HttpStatus.OK);
	}
	 @GetMapping("/viewAllBranchDetails")
		public ResponseEntity<List<Branch>> viewAllBranchDetails() 
	  {
		  List<Branch> list=iBranchService.viewAllBranchDetails();
		  return new ResponseEntity<List<Branch>>(list, HttpStatus.OK);
	  }
	 @PutMapping("/updateBranch")
	 public ResponseEntity<Branch> updateBranch(@RequestBody Branch branch)
		{
		 Branch obj=iBranchService.updateBranch(branch);
			return new ResponseEntity<Branch>(obj, HttpStatus.OK);
		}
	 @DeleteMapping("/deleteBranchById/{branchId}")
	 public ResponseEntity<List<Branch>> deleteBranchById(@PathVariable Integer branchId)
		{
		List<Branch> obj=iBranchService.deleteBranchById(branchId);
			return new ResponseEntity<List<Branch>>(obj, HttpStatus.OK);
		}
	 @GetMapping("/getBranchById/{branchId}")
	 public ResponseEntity<Branch> getBranchById(@PathVariable Integer branchId)
		{
			Branch obj=iBranchService.getBranchById(branchId);
			return new ResponseEntity<Branch>(obj, HttpStatus.OK);
		}
	 


}
