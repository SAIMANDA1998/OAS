package com.cg.oas.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Login 
{
	@Id
	private int loginId;
	private String password;
	private String role;
	public Login() {}
	
	public Login(int loginId, String password, String role) {
		super();
		this.loginId = loginId;
		this.password = password;
		this.role = role;
	}

	public int getLoginId() {
		return loginId;
	}
	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	

}
