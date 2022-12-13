package src.com.java.splitwise.service;

import java.util.List;

import src.com.java.splitwise.model.Expense;
import src.com.java.splitwise.model.ExpenseData;
import src.com.java.splitwise.model.ExpenseType;
import src.com.java.splitwise.model.User;
import src.com.java.splitwise.model.UserShare;

public class ExpenseServiceImpl implements ExpenseService {

	@Override
	public Expense createExpense(ExpenseType expenseType, double amount, User expensePaidBy, List<UserShare> splits,
			ExpenseData expenseData) {
		// TODO Auto-generated method stub
		return null;
	}

}
