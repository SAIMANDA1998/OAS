package com.cg.oas.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oas.entities.Payment;
import com.cg.oas.exception.PaymentNotFoundException;
import com.cg.oas.repository.IPaymentRepository;
import com.cg.oas.service.IPaymentService;

@Service
public class IPaymentServiceImpl implements IPaymentService {
	@Autowired
	private IPaymentRepository iPaymentRepo;
	@Override
	public Payment addPayment(Payment payment) {
			return iPaymentRepo.save(payment);
		}

	@Override
	public List<Payment> viewAllPaymentDetails() throws PaymentNotFoundException{
			List<Payment> list=iPaymentRepo.findAll();
			if(list.isEmpty()) {
				throw new PaymentNotFoundException("No Payment Found");
			}
			else
			return iPaymentRepo.findAll();
	}

	@Override
	public Payment getPaymentDetailsByPaymentId(int paymentId) throws PaymentNotFoundException {
				Optional<Payment> optional = iPaymentRepo.findById(paymentId);
				if(optional.isPresent()) {
					return optional.get();	
				}
				else
					throw new PaymentNotFoundException("No Payment Found");
	}

	@Override
	public List<Payment> deletePaymentById(int paymentById)throws PaymentNotFoundException {

			Optional<Payment> optional = iPaymentRepo.findById(paymentById);
			if(optional.isPresent()) {
			iPaymentRepo.deleteById(paymentById);
			return iPaymentRepo.findAll();
			}
			else
				throw new PaymentNotFoundException("No Payment Found");
	}

	@Override
	public Payment updatePaymentDetails(Payment payment) throws PaymentNotFoundException{
			Optional<Payment> optional = iPaymentRepo.findById(payment.getPaymentId());
			if(optional.isPresent()) {
			iPaymentRepo.save(payment);
			return payment;
			}
			else
				throw new PaymentNotFoundException("No Payment Found");
}
}