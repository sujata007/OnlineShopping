package com.java.ecom.service;

import java.util.List;

import com.java.ecom.model.Item;
import com.java.ecom.model.Payment;

public interface OrderService {
	public boolean makePayment(Payment payment);

	public String placeOrder(List<Item> orderedItems);

	String confirmOrder(String orderId);
}
