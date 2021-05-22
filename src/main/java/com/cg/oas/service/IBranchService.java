package com.cg.oas.service;

import java.util.List;

import com.cg.oas.entities.Branch;

public interface IBranchService
{
	public Branch addBranch( Branch branch);
	public List<Branch> viewAllBranchDetails();
	//public  ArrayList<Branch> getBranchDetailsByName(String branchName);
	public List<Branch> deleteBranchById(int branchId);
	public Branch getBranchById(int branchId);
	//public int deleteBranchByName(String branchName);
	public Branch  updateBranch(Branch branch);

}
