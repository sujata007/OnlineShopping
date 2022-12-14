package com.java.ecom.model;

public class Product {
	private String productId;
	private String name;
	private double price;
	private int availableCount;
	public Product(String productId, String name, int availableCount) {
		this.productId = productId;
		this.name = name;
		this.availableCount = availableCount;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAvailableCount() {
		return availableCount;
	}

	public void setAvailableCount(int availableCount) {
		this.availableCount = availableCount;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

}
