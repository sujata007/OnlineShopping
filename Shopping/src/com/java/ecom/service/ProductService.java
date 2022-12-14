package com.java.ecom.service;

public interface ProductService {
	public int getInventory(String productId) throws Exception;

	public void createProduct(String productId, String productName, int count) throws Exception;
}
