package src.com.java.splitwise.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import src.com.java.splitwise.model.Expense;
import src.com.java.splitwise.model.User;
import src.com.java.splitwise.model.UserShare;

public class ExpenseRepository {
	List<Expense> expenses;
	Map<String, User> userMap;// userid to User
	Map<String, Map<String, Double>> balancesheets; // user-> paidto, amount

	ExpenseRepository() {
		expenses = new ArrayList<>();
		userMap = new HashMap<>();
		balancesheets = new HashMap<>();
	}

	public void addUser(User user) {
		userMap.put(user.getUserName(), user);
	}

	public User getUser(String userName) {
		return userMap.get(userName);

	}

	public List<String> getBalance(String userName) {
		List<String> balances = new ArrayList<>();
		for (Map.Entry<String, Double> userBalance : balancesheets.get(userName).entrySet()) {
			if (userBalance.getValue() > 0) {
				balances.add(compute(userName, userBalance.getKey(), userBalance.getValue()));
			}
		}
		return balances;
	}

	public List<String> getBalance() {
		List<String> balances = new ArrayList<>();
		for (Map.Entry<String, Map<String, Double>> balance : balancesheets.entrySet()) {
			for (Map.Entry<String, Double> userBalance : balance.getValue().entrySet()) {
				if (userBalance.getValue() > 0) {
					balances.add(compute(balance.getKey(), userBalance.getKey(), userBalance.getValue()));
				}
			}

		}
		return balances;
	}

	private String compute(String user1, String user2, double amount) {
		if (amount < 0) {
            return  user1 + " owes " + user2 + ": " + Math.abs(amount);
        } else if (amount > 0) {
            return user2 + " owes " + user1 + ": " + Math.abs(amount);
        }
        return "";
	}
	public void addExpense(Expense expense ) {
		expenses.add(expense);
		for (UserShare split : expense.getMoneyTobeSplittedAmong()) {
			String paidTo = split.getUser().getUserName();

            Map<String, Double> balances = balancesheets.get(expense.getAmountPayedBy().getUserName());
            if (!balances.containsKey(paidTo)) {
                balances.put(paidTo, 0.0);
            }
            balances.put(paidTo, balances.get(paidTo) + split.getAmount());

            balances = balancesheets.get(paidTo);
            if (!balances.containsKey(expense.getAmountPayedBy().getUserName())) {
                balances.put(expense.getAmountPayedBy().getUserName(), 0.0);
            }
            balances.put(expense.getAmountPayedBy().getUserName(), balances.get(expense.getAmountPayedBy().getUserName()) - split.getAmount());
		}
	}
}
