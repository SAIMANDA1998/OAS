package com.cg.oas.service;

import java.util.List;

import com.cg.oas.entities.Payment;

public interface IPaymentService
{
	public Payment addPayment(Payment payment);
	public List<Payment> viewAllPaymentDetails();
	//public  ArrayList<Payment> getPaymentDetailsByEmail(String emailId);
	public  Payment getPaymentDetailsByPaymentId(int paymentId);
	//public  Payment getPaymentDetailsByApplicationId(int applicationId);
	//public ArrayList<Payment> getPayementDetailsByStatus(String paymentStatus);
	public List<Payment> deletePaymentById(int paymentById);
	public Payment  updatePaymentDetails(Payment payemnt);
}
