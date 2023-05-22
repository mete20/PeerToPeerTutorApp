package app;

public class Administrator extends User {
	/**
	 * This class is a subclass of the User class.
	 * This is the admin class which is the manager of the whole system.
	 */
	
	public static double profit; // This is the total profit of the tutoring center system.
	
	/**
	 * The constructor of the class.
	 * @param userName
	 * @param password
	 */
	public Administrator(String userName, String password) {
		super(userName, password);
		// TODO Auto-generated constructor stub
	}
	/**
	 * Getter and setter method, if needed.
	 *
	 */
	public double getProfit() {
		return profit;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}
	
	

}
