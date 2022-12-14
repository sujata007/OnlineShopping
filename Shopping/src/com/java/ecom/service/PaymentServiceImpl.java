package com.java.ecom.service;

import com.java.ecom.model.Payment;
import com.java.ecom.model.PaymentStatus;

public class PaymentServiceImpl implements PaymentService {


	@Override
	public Payment processPayment(Payment payment) {
		// TODO Auto-generated method stub
		payment.setPaymentStatus(PaymentStatus.COMPLETED);
		return payment;
	}

}
