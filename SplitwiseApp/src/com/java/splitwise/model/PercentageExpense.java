package src.com.java.splitwise.model;

import java.util.List;

public class PercentageExpense extends Expense {

	public PercentageExpense(double totalAmount, User amountPayedBy, ExpenseData expenseData,
			List<UserShare> sharesTobeSplittedAmong) {
		super(totalAmount, amountPayedBy, expenseData, sharesTobeSplittedAmong);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		double totalAmount = getTotalAmount();
		int amount =0;
		for(UserShare shareOfEachUser : getMoneyTobeSplittedAmong()) {
			if(!(shareOfEachUser instanceof UserShareByPercentage)) {
				return false;
			}
			UserShareByPercentage share = (UserShareByPercentage)shareOfEachUser;
			amount+=share.getPercent();
		}
		return amount==totalAmount;
	}

}
