package src.com.java.splitwise.model;

public class ExpenseData {
	private String expenseName;
	private ExpenseType expenseType;

	public ExpenseData(String expenseName, ExpenseType expenseType) {
		this.expenseName = expenseName;
		this.expenseType = expenseType;
	}

	public String getExpenseName() {
		return expenseName;
	}

	public void setExpenseName(String expenseName) {
		this.expenseName = expenseName;
	}

	public ExpenseType getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(ExpenseType expenseType) {
		this.expenseType = expenseType;
	}
}
