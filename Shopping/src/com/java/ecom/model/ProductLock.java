package com.java.ecom.model;

import java.util.Date;

public class ProductLock {
	private Product product;
	private Date lockTime;
	private int lockedQuantity;

	public ProductLock(Product product, Date lockTime, int lockedQuantity) {
		super();
		this.product = product;
		this.lockTime = lockTime;
		this.lockedQuantity = lockedQuantity;

	}

	public Product getProduct() {
		return product;
	}

	public Date getLockTime() {
		return lockTime;
	}

	public int getLockedQuantity() {
		return lockedQuantity;
	}
}
