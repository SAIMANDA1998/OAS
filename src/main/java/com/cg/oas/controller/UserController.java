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

import com.cg.oas.entities.Login;
import com.cg.oas.entities.UserTable;
import com.cg.oas.repository.ILoginRepository;
import com.cg.oas.service.IUserService;

@RestController
@RequestMapping("/User")
public class UserController {
@Autowired
IUserService iUserService;
@Autowired
ILoginRepository iLoginRepo;
@PostMapping("/addUserDetails")
public ResponseEntity<UserTable> addUserDetails(@RequestBody UserTable user)
{
	UserTable obj=iUserService.addUserDetails(user);
	return new ResponseEntity<UserTable>(obj, HttpStatus.OK);
}
@PostMapping("/addLoginDetails")
public ResponseEntity<Login> addLoginDetails(@RequestBody Login login)
{
	Login obj=iUserService.addLoginDetails(login);
	return new ResponseEntity<Login>(obj, HttpStatus.OK);
}

@GetMapping("/getAllUserDetails")
public ResponseEntity<List<UserTable>> getAllUserDetails() 
{
	  List<UserTable> list=iUserService.getAllUserDetails();
	  return new ResponseEntity<List<UserTable>>(list, HttpStatus.OK);
  }
@GetMapping("/getAllLoginDetails")
public ResponseEntity<List<Login>> getAllLoginDetails() 
{
	  List<Login> list=iUserService.getAllLoginDetails();
	  return new ResponseEntity<List<Login>>(list, HttpStatus.OK);
  }

@DeleteMapping("/deleteUserDetailsById/{userId}")
 public ResponseEntity<List<UserTable>> deleteUserDetailsById(@PathVariable Integer userId)
	{
	List<UserTable> obj=iUserService.deleteUserDetailsById(userId);
		return new ResponseEntity<List<UserTable>>(obj, HttpStatus.OK);
	}
@DeleteMapping("/deleteLoginDetailsById/{loginId}")
public ResponseEntity<List<Login>> deleteLoginDetailsById(@PathVariable Integer loginId)
	{
	List<Login> obj=iUserService.deleteLoginDetailsById(loginId);
		return new ResponseEntity<List<Login>>(obj, HttpStatus.OK);
	}

@GetMapping("/getUserDetailsById/{userId}")
 public ResponseEntity<UserTable> getUserDetailsById(@PathVariable Integer userId)
	{
	UserTable obj=iUserService.getUserDetailsById(userId);
		return new ResponseEntity<UserTable>(obj, HttpStatus.OK);
	}
@GetMapping("/getLoginDetailsById/{loginId}")
public ResponseEntity<Login> getLoginDetailsById(@PathVariable Integer loginId)
	{
	Login obj=iUserService.getLoginDetailsById(loginId);
		return new ResponseEntity<Login>(obj, HttpStatus.OK);
	}

@PutMapping("/updateUserDetails")
 public ResponseEntity<UserTable> updateUserDetails(@RequestBody UserTable user)
	{
	UserTable obj=iUserService.updateUserDetails(user);
		return new ResponseEntity<UserTable>(obj, HttpStatus.OK);
	}
@PutMapping("/resetPassword")
public ResponseEntity<Login> resetPassword(@RequestBody Login login)
	{
	Login obj=iUserService.resetPassword(login);
		return new ResponseEntity<Login>(obj, HttpStatus.OK);
	}

}
