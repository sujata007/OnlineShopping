package com.java.ecom.repo;

import java.util.HashMap;
import java.util.Map;

import com.java.ecom.model.Product;

public class ProductRepo {
	Map<String, Product> productIs;
	public ProductRepo(){
		this.productIs = new HashMap<>();
	}
	public void addProducts(Product product) {
		productIs.put(product.getProductId(), product);
	}
	public Product getProduct(String productId) {
		// TODO Auto-generated method stub
		return productIs.get(productId);
	}
}
