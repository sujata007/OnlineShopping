package com.java.ecom.repo;

import java.util.HashMap;
import java.util.Map;

import com.java.ecom.model.Order;
import com.java.ecom.model.Payment;

public class OrderRepo {
	Map<String, Order> listOfOrders;
	Map<String, Payment> paymentDetailsForEachOrder;

	OrderRepo() {
		this.listOfOrders = new HashMap<>();
	}
	public void placeOrder(Order order) {
		listOfOrders.put(order.getOrderNumber(), order);
	}
	public Order getOrder(String orderId) {
		// TODO Auto-generated method stub
		return listOfOrders.get(orderId);
	}
	public void paymentDetails(String orderId,Payment payment) {
		paymentDetailsForEachOrder.put(orderId, payment);
	}
	public Payment getPaymentDetail(String orderId) {
		// TODO Auto-generated method stub
		return paymentDetailsForEachOrder.get(orderId);
	}
}
