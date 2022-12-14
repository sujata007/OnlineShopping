package com.java.ecom.model;

import java.sql.Date;
import java.util.List;

public class Order {
	String orderNumber;
	long creationDate;
	List<Item> orderedItems;
	double amount;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount2) {
		this.amount = amount2;
	}

	public Order(String orderNumber, long creationDate, List<Item> orderedItems) {
		super();
		this.orderNumber = orderNumber;
		this.creationDate = creationDate;
		this.orderedItems = orderedItems;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public long getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(long creationDate) {
		this.creationDate = creationDate;
	}

	public List<Item> getOrderedItems() {
		return orderedItems;
	}

	public void setOrderedItems(List<Item> orderedItems) {
		this.orderedItems = orderedItems;
	}

}
