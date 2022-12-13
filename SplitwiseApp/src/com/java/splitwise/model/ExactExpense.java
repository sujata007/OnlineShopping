package src.com.java.splitwise.model;

import java.util.List;

public class ExactExpense extends Expense {

	public ExactExpense(double totalAmount, User amountPayedBy, ExpenseData expenseData,
			List<UserShare> moneyTobeSplittedAmong) {
		super(totalAmount, amountPayedBy, expenseData, moneyTobeSplittedAmong);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		double totalAmount = getTotalAmount();
		int amount =0;
		for(UserShare shareOfEachUser : getMoneyTobeSplittedAmong()) {
			UserShareByAmount share = (UserShareByAmount)shareOfEachUser;
			amount+=share.getAmount();
		}
		return amount==totalAmount;
	}

}
