package src.com.java.splitwise.model;

import java.util.List;
import java.util.UUID;

public abstract class Expense {
	private final String expenseId;
	private double totalAmount;
	private User amountPayedBy;
	private ExpenseData expenseData;
	private List<UserShare> moneyTobeSplittedAmong;

	public Expense(double totalAmount, User amountPayedBy, ExpenseData expenseData,
			List<UserShare> moneyTobeSplittedAmong) {
		this.expenseId = UUID.randomUUID().toString();
		this.totalAmount = totalAmount;
		this.amountPayedBy = amountPayedBy;
		this.expenseData = expenseData;
		this.moneyTobeSplittedAmong = moneyTobeSplittedAmong;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public User getAmountPayedBy() {
		return amountPayedBy;
	}

	public void setAmountPayedBy(User amountPayedBy) {
		this.amountPayedBy = amountPayedBy;
	}

	public ExpenseData getExpenseData() {
		return expenseData;
	}

	public void setExpenseData(ExpenseData expenseData) {
		this.expenseData = expenseData;
	}

	public List<UserShare> getMoneyTobeSplittedAmong() {
		return moneyTobeSplittedAmong;
	}

	public void setMoneyTobeSplittedAmong(List<UserShare> moneyTobeSplittedAmong) {
		this.moneyTobeSplittedAmong = moneyTobeSplittedAmong;
	}

	public String getExpenseId() {
		return expenseId;
	}
}
