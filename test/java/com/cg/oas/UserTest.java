package com.cg.oas;

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

import com.cg.oas.entities.Login;
import com.cg.oas.entities.UserTable;
import com.cg.oas.repository.ILoginRepository;
import com.cg.oas.repository.IUserRepository;
import com.cg.oas.service.IUserService;

@SpringBootTest
public class UserTest {
	@Autowired
	IUserService iUserServie;
	@MockBean
	IUserRepository iUserRepo;
	@MockBean
	ILoginRepository iLoginRepo;
	
	@Test
	public void addUserDetails() {
		
		UserTable user = new UserTable();
		user.setUserId(1);
		user.setFirstName("Narsimha Reddy");
		user.setLastName("Subbagari");
		user.setMiddleName("ReSddy");
		user.setEmail("na@na.com");
		user.setMobileNumber("8142360315");
		user.setAadharCardNo("123456781234");
		
		when(iUserServie.addUserDetails(user)).thenReturn(user);
		UserTable userNew = iUserServie.addUserDetails(user);
		assertEquals(userNew,user);
		
	}
	
	@Test
	public void addLoginDetails() {
		Login login = new Login();
		login.setLoginId(1);
		login.setPassword("Naasdas");
		login.setRole("USER");
		
		when(iUserServie.addLoginDetails(login)).thenReturn(login);
		Login loginNew = iUserServie.addLoginDetails(login);
		assertEquals(loginNew,login);
		
	}
	
	@Test
	public void getAllUserDetails() {
		UserTable user = new UserTable();
		user.setUserId(1);
		user.setFirstName("Narsimha Reddy");
		user.setLastName("Subbagari");
		user.setMiddleName("REddy");
		user.setEmail("na@na.com");
		user.setMobileNumber("8142360315");
		user.setAadharCardNo("123456781234");
		
		UserTable user1 = new UserTable();
		user1.setUserId(2);
		user1.setFirstName("Narsimha Reddy");
		user1.setLastName("Subbagari");
		user1.setMiddleName("REddy");
		user1.setEmail("na@na.com");
		user1.setMobileNumber("8142360315");
		user.setAadharCardNo("123456781234");
		
		List<UserTable> userTableList = new ArrayList<>();
		userTableList.add(user); 
		userTableList.add(user1); 
		when(iUserRepo.findAll()).thenReturn(userTableList);
		List<UserTable> userTableListNew = iUserRepo.findAll();
		assertEquals(userTableListNew,userTableList);
	}
	
	
	@Test
	public void getUserDetailsById() {
		UserTable user = new UserTable();
		user.setUserId(1);
		user.setFirstName("Narsimha Reddy");
		user.setLastName("Subbagari");
		user.setMiddleName("REddy");
		user.setEmail("na@na.com");
		user.setMobileNumber("8142360315");
		user.setAadharCardNo("123456781234");
		when(iUserRepo.findById(user.getUserId())).thenReturn(Optional.of(user));
		Optional<UserTable> userTable =iUserRepo.findById(user.getUserId());
		assertEquals(user,userTable.get());
	}
	
	@Test
	public void getLoginDetailsById() {

		Login login = new Login();
		login.setLoginId(1);
		login.setPassword("Naasdas");
		login.setRole("USER");
		when(iLoginRepo.findById(login.getLoginId())).thenReturn(Optional.of(login));
		Optional<Login> loginNew = iLoginRepo.findById(login.getLoginId());
		assertEquals(login,loginNew.get());
	}

	@Test
	public void deleteLoginDetailsById() {
		
		Login login = new Login();
		login.setLoginId(1);
		login.setPassword("Naasdas");
		login.setRole("USER");
		
		when(iLoginRepo.findById(login.getLoginId())).thenReturn(Optional.of(login));
		iUserServie.deleteLoginDetailsById(login.getLoginId());
		verify(iLoginRepo).deleteById(login.getLoginId());
	}
	
	@Test
	public void updateUserDetails() {
		UserTable user = new UserTable();
		user.setUserId(1);
		user.setFirstName("Narsimha Reddy");
		user.setLastName("Subbagari");
		user.setMiddleName("REddy");
		user.setEmail("na@na.com");
		user.setMobileNumber("8142360315");
		user.setAadharCardNo("123456781234");
		
		when(iUserServie.addUserDetails(user)).thenReturn(user);
		UserTable userNew = iUserServie.addUserDetails(user);
		assertEquals(userNew,user);
	}
	
	@Test
	public void resetPassword() {
		Login login = new Login();
		login.setLoginId(1);
		login.setPassword("Naasdas");
		login.setRole("USER");
		
		
		when(iUserServie.addLoginDetails(login)).thenReturn(login);
		Login loginNew = iUserServie.addLoginDetails(login);
		assertEquals(loginNew,login);
	}
	
	@Test
	public void getAllLoginDetails() {

		Login login = new Login();
		login.setLoginId(1);
		login.setPassword("Naasdas");
		login.setRole("USER");
		

		Login login1 = new Login();
		login1.setLoginId(2);
		login1.setPassword("RADaasdas");
		login1.setRole("USER");
		
		List<Login> loginUserDetailsTable = new ArrayList<>();
		loginUserDetailsTable.add(login); 
		loginUserDetailsTable.add(login1); 
		when(iLoginRepo.findAll()).thenReturn(loginUserDetailsTable);
		List<Login> loginUserDetailsTable1 = iLoginRepo.findAll();
		assertEquals(loginUserDetailsTable1,loginUserDetailsTable);
	}


}
