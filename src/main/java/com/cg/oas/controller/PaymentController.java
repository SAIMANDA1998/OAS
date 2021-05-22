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

import com.cg.oas.entities.Payment;
import com.cg.oas.repository.IPaymentRepository;
import com.cg.oas.service.IPaymentService;

@RestController
@RequestMapping("/Payment")
public class PaymentController {
	@Autowired
	private IPaymentService iPaymentService;
	@PostMapping("/addPayment")
	public ResponseEntity<Payment> addPayment(@RequestBody Payment payment)
	{
		Payment obj=iPaymentService.addPayment(payment);
		return new ResponseEntity<Payment>(obj, HttpStatus.OK);
	}
	
	@GetMapping("/Viewallpaymentdetails")
	public ResponseEntity<List<Payment>> viewAllPaymentDetails() 
  {
		  List<Payment> list=iPaymentService.viewAllPaymentDetails();
		  return new ResponseEntity<List<Payment>>(list, HttpStatus.OK);
	  }
	
	@GetMapping("/getPaymentDetailsById/{paymentId}")
	 public ResponseEntity<Payment> getPaymentDetailsByPaymentId(@PathVariable Integer paymentId)
		{
			Payment obj=iPaymentService.getPaymentDetailsByPaymentId(paymentId);
			return new ResponseEntity<Payment>(obj, HttpStatus.OK);
		}
	
	@DeleteMapping("/deletePaymentById/{paymentId}")
	 public ResponseEntity<List<Payment>> deletePayment(@PathVariable Integer paymentById)
		{
		List<Payment> obj=iPaymentService.deletePaymentById(paymentById);
			return new ResponseEntity<List<Payment>>(obj, HttpStatus.OK);
		}
	
	@PutMapping("/updatePaymentDetails")
	 public ResponseEntity<Payment> updatePayment(@RequestBody Payment payment)
		{
			Payment obj=iPaymentService.updatePaymentDetails(payment);
			return new ResponseEntity<Payment>(obj, HttpStatus.OK);
		}
	
}
