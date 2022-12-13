package src.com.java.splitwise.model;

public class UserShareByPercentage extends UserShare {
	double percent;
	public UserShareByPercentage(User user,double percent) {
		super(user);
		// TODO Auto-generated constructor stub
		this.percent = percent;
	}
	public double getPercent() {
		return percent;
	}
	public void setPercent(double percent) {
		this.percent = percent;
	}

}
