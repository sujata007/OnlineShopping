package com.java.ecom.model;

public class Payment {
	private double amount;
	private PaymentStatus paymentStatus;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Payment(double amount, PaymentStatus paymentStatus) {
		super();
		this.amount = amount;
		this.paymentStatus = paymentStatus;
	}

}
