package src.com.java.splitwise.service;

import java.util.List;

import src.com.java.splitwise.model.EqualExpense;
import src.com.java.splitwise.model.ExactExpense;
import src.com.java.splitwise.model.Expense;
import src.com.java.splitwise.model.ExpenseData;
import src.com.java.splitwise.model.ExpenseType;
import src.com.java.splitwise.model.PercentageExpense;
import src.com.java.splitwise.model.User;
import src.com.java.splitwise.model.UserShare;
import src.com.java.splitwise.model.UserShareByPercentage;

public class ExpenseServiceImpl implements ExpenseService {

	@Override
	public Expense createExpense(ExpenseType expenseType, double amount, User expensePaidBy, List<UserShare> splits,
			ExpenseData expenseData) {
		// TODO Auto-generated method stub
		switch(expenseType) {
		case EXACT:
			return new ExactExpense(amount,expensePaidBy,expenseData,splits);
		case PERCENTAGE:
			for(UserShare userSharer: splits) {
				UserShareByPercentage percentSplit = (UserShareByPercentage) userSharer;
				userSharer.setAmount((amount*percentSplit.getPercent())/100.0);
			}
			return new PercentageExpense(amount, expensePaidBy, expenseData, splits);
		case EQUAL:
			int totalSplits = splits.size();
            double splitAmount = ((double) Math.round(amount*100/totalSplits))/100.0;
            for (UserShare userSharer: splits) {
            	userSharer.setAmount(splitAmount);
            }
            return new EqualExpense(amount, expensePaidBy, expenseData, splits);
		 default:
			return null;
		
		}
	}

}
