package com.cg.oas;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.oas.entities.Payment;
import com.cg.oas.entities.UserTable;
import com.cg.oas.repository.IPaymentRepository;
import com.cg.oas.service.IPaymentService;

@SpringBootTest
public class PaymentTest {
	@Autowired
	IPaymentService iPaymentService;
	
	@MockBean
	IPaymentRepository iPaymentRepo;
	@Test
	public void testAddPayment()
	{
		Payment pay = new Payment();
		pay.setPaymentId(503);
		pay.setEmailIdOfStudent("rani@gamil.com");
		pay.setApplicationId("1103");
		pay.setPaymentAmount(50000.00);
		pay.setPaymentDescription("cash");
		pay.setPaymentDate(LocalDate.of(2020, 1, 8));
		pay.setPaymentStatus("paid");
		
		Mockito.when(iPaymentRepo.save(pay)).thenReturn(pay);
		assertThat(iPaymentService.addPayment(pay)).isEqualTo(pay);
	}
	@Test
	public void testViewAllPaymentDetails()
	{
		Payment pay1 = new Payment();
		pay1.setPaymentId(503);
		pay1.setEmailIdOfStudent("sweety@gamil.com");
		pay1.setApplicationId("1103");
		pay1.setPaymentAmount(50000.00);
		pay1.setPaymentDescription("cash");
		pay1.setPaymentDate(LocalDate.of(2020, 1, 8));
		pay1.setPaymentStatus("pending");
		
		Payment pay2 = new Payment();
		pay2.setPaymentId(503);
		pay2.setEmailIdOfStudent("sonali@gamil.com");
		pay2.setApplicationId("1103");
		pay2.setPaymentAmount(50000.00);
		pay2.setPaymentDescription("cash");
		pay2.setPaymentDate(LocalDate.of(2020, 1, 8));
		pay2.setPaymentStatus("paid");

		
		List<Payment> pay = new ArrayList<>();
		pay.add(pay1); pay.add(pay2);
		Mockito.when(iPaymentRepo.findAll()).thenReturn(pay);
		assertThat(iPaymentService.viewAllPaymentDetails()).isEqualTo(pay);
	}
	
//	List<Payment> pay = new ArrayList<>();
//	pay.add(pay1); pay.add(pay2);
//	Mockito.when(iPaymentRepo.findAll()).thenReturn(pay);
//	Exception ex = assertThrows(PaymentNotFoundException.class, ()-> iPaymentService.viewAllPaymentDetails());
//	assertEquals("No Payment Found", ex.getMessage());
	@Test
	public void testDeletePaymentById()
	{
		Payment pay = new Payment();
		pay.setPaymentId(503);
		pay.setEmailIdOfStudent("rani@gamil.com");
		pay.setApplicationId("1103");
		pay.setPaymentAmount(50000.00);
		pay.setPaymentDescription("cash");
		pay.setPaymentDate(LocalDate.of(2020, 1, 8));
		pay.setPaymentStatus("paid");
		
		Mockito.when(iPaymentRepo.findById(503)).thenReturn(Optional.of(pay));
	    Mockito.when(iPaymentRepo.existsById(pay.getPaymentId())).thenReturn(false);
	   assertFalse(iPaymentRepo.existsById(pay.getPaymentId()));
	}
	@Test
	public void testUpdatePayment()
	{
		Payment pay = new Payment();
		pay.setPaymentId(503);
		pay.setEmailIdOfStudent("rani@gamil.com");
		pay.setApplicationId("1103");
		pay.setPaymentAmount(50000.00);
		pay.setPaymentDescription("cash");
		pay.setPaymentDate(LocalDate.of(2020, 1, 8));
		pay.setPaymentStatus("paid");
		
		
		Mockito.when(iPaymentRepo.findById(pay.getPaymentId())).thenReturn(Optional.of(pay));
		
		pay.setEmailIdOfStudent("raja@gmail.com");
		Mockito.when(iPaymentRepo.save(pay)).thenReturn(pay);
		
		assertThat(iPaymentService.updatePaymentDetails(pay)).isEqualTo(pay);
		
	}
	@Test
	public void testGetPaymentById()
	{
		Payment pay = new Payment();
		pay.setPaymentId(503);
		pay.setEmailIdOfStudent("rani@gamil.com");
		pay.setApplicationId("1103");
		pay.setPaymentAmount(50000.00);
		pay.setPaymentDescription("cash");
		pay.setPaymentDate(LocalDate.of(2020, 1, 8));
		pay.setPaymentStatus("paid");
		UserTable user = new UserTable();
		user.setUserId(106);
		Mockito.when(iPaymentRepo.findById(pay.getPaymentId())).thenReturn(Optional.of(pay));
		assertThat(iPaymentService.getPaymentDetailsByPaymentId(pay.getPaymentId())).isEqualTo(pay);
	}
//	List<Customer> cust = new ArrayList<>();
//	cust.add(cust1); cust.add(cust2);
//	Mockito.when(customerRepo.viewAllCustomer("Kolkata")).thenReturn(cust);
//	assertThat(customerService.ViewAllCustomers("Kolkata")).isEqualTo(cust);
}

