package src.com.java.splitwise.model;

import java.util.List;

public class EqualExpense extends Expense {

	public EqualExpense(double totalAmount, User amountPayedBy, ExpenseData expenseData,
			List<UserShare> moneyTobeSplittedAmong) {
		super(totalAmount, amountPayedBy, expenseData, moneyTobeSplittedAmong);
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean validate() {
		return false;
		
	}

}
