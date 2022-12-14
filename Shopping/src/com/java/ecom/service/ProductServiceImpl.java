package com.java.ecom.service;

import com.java.ecom.model.Product;
import com.java.ecom.repo.ProductRepo;

public class ProductServiceImpl implements ProductService {
	ProductRepo productRepo;
	public ProductServiceImpl(ProductRepo productRepo){
		this.productRepo = productRepo;
	}
	@Override
	public int getInventory(String productId) throws Exception {
		// TODO Auto-generated method stub
		if(productRepo.getProduct(productId)!=null) {
			return productRepo.getProduct(productId).getAvailableCount();
		}else {
			throw new Exception("The inventory is not found");
		}
	}

	@Override
	public void createProduct(String productId, String productName, int count) throws Exception {
		// TODO Auto-generated method stub
		if(productRepo.getProduct(productId)!=null) {
			throw new Exception("Product id already exists");
		}
		Product product = new Product(productId,productName,count);
		productRepo.addProducts(product);
	}

}
