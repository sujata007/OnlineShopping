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
		int total =0;
		for(UserShare shareOfEachUser : getMoneyTobeSplittedAmong()) {
			if(!(shareOfEachUser instanceof UserShareByPercentage)) {
				return false;
			}
			UserShareByPercentage share = (UserShareByPercentage)shareOfEachUser;
			total+=share.getPercent();
		}
		return 100==total;
	}

}
