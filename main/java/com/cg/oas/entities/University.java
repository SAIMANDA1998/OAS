package com.cg.oas.entities;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class University 
{
	private String name;
	@Id
	private int universityId;
	@OneToOne
	private Address address;
	@OneToMany(mappedBy="collegeRegId")
	private List<College> collgeList;
	public University() {}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUniversityId() {
		return universityId;
	}
	public void setUniversityId(int universityId) {
		this.universityId = universityId;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<College> getCollgeList() {
		return collgeList;
	}
	public void setCollgeList(List<College> collgeList) {
		this.collgeList = collgeList;
	}
	
}
