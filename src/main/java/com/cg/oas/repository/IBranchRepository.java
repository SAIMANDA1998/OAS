package com.cg.oas.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.oas.entities.Application;
import com.cg.oas.entities.Branch;
@Repository
public interface IBranchRepository extends JpaRepository<Branch,Integer>
{
//	public boolean addBranch( Branch branch);
//	public ArrayList<Branch> viewAllBranchDetails();
//	public  ArrayList<Branch> getBranchDetailsByName(String branchName);
//	public int deleteBranchById(int branchId);
//	public Branch getBranchById(int branchId);
//	public int deleteBranchByName(String branchName);
//	public int  updateBranch(Branch branch);

}
