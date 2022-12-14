package com.java.ecom.service;

import java.util.Date;
import java.util.List;
import java.util.PriorityQueue;
import java.util.UUID;

import com.java.ecom.model.Item;
import com.java.ecom.model.Order;
import com.java.ecom.model.Payment;
import com.java.ecom.model.PaymentStatus;
import com.java.ecom.model.Product;
import com.java.ecom.model.ProductLock;
import com.java.ecom.repo.OrderRepo;
import com.java.ecom.repo.ProductRepo;

public class OrderServiceImpl implements OrderService {
	ProductRepo productrepo;
	OrderRepo orderRepo;
	PaymentService paymentService;
	PriorityQueue<ProductLock> pq = new PriorityQueue<>(
			(a, b) -> (int) (a.getLockTime().getMinutes() - b.getLockTime().getMinutes()));
	private boolean mIsEviction;
	private long mEvictionPeriod;

	OrderServiceImpl(ProductRepo productrepo) {
		this.productrepo = productrepo;
		this.paymentService = new PaymentServiceImpl();
		this.mIsEviction = false;
		this.mEvictionPeriod = 5;
	}

	@Override
	public boolean makePayment(Payment payment) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public synchronized String placeOrder(List<Item> orderedItems) {
		// TODO Auto-generated method stub
		mIsEviction = true;
		startEvictionService();
		double amount = 0;
		for (Item items : orderedItems) {
			Product product = productrepo.getProduct(items.getProductId());
			// productsToBeLocked.add(product);
			amount += product.getPrice();
			product.setAvailableCount(product.getAvailableCount() - items.getQuantityy());
			ProductLock lock = new ProductLock(product, new Date(), items.getQuantityy());
			pq.add(lock);

		}
		String orderId = UUID.randomUUID().toString();
		Order order = new Order(orderId, System.currentTimeMillis(), orderedItems);
		order.setAmount(amount);
		orderRepo.placeOrder(order);
		mIsEviction = false;
		return orderId;
	}

	@Override
	public synchronized String confirmOrder(String orderId) {
		// TODO Auto-generated method stub
		Order id = orderRepo.getOrder(orderId);

		Payment payment = new Payment(id.getAmount(), PaymentStatus.PENDING);

		payment = paymentService.processPayment(payment);
		orderRepo.paymentDetails(orderId, payment);
		return payment.getPaymentStatus().toString();
	}

	private void startEvictionService() {
		// TODO Auto-generated method stub
		Thread t = new Thread(() -> {
			while (mIsEviction) {
				synchronized (pq) {
					evictData();
				}
				try {
					Thread.sleep(mEvictionPeriod);
				} catch (InterruptedException ex) {
					System.out.print("Exception occured" + ex.getMessage());
					Thread.currentThread().interrupt();
				}
			}
		});
		t.start();
	}

	private void evictData() {
		// TODO Auto-generated method stub
		while (!pq.isEmpty() && pq.peek().getLockTime().getSeconds() <= System.currentTimeMillis()) {
			ProductLock data = pq.poll();
			Product product = data.getProduct();
			product.setAvailableCount(product.getAvailableCount() + data.getLockedQuantity());
		}

	}
}