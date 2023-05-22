package app;

public class User {
	/**
	 * This class is the superclass of both student, tutor, and admin classes.
	 * This class provide programmers to know the user type of the user who trying to register or login.
	 */
	private String userName;
	private String password;
	/**
	 * The constructor of the class.
	 * @param userName
	 * @param password
	 */
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	/**
	 * Getter and Setter methods.
	 * 
	 */

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
