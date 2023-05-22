package app;

import java.util.Random;

public class Equipment {
	/**
	 * This class is Equipment class which stores all information about equipments.
	 */
	private int price;
	private String name;
	private double percentage;
	
	/**
	 * The constructor of the class.
	 * @param name
	 */
	public Equipment(String name) {
		super();
		this.name = name;
		Random rand = new Random();
		this.price = rand.nextInt(100); // the equipments prices are random integer number between (0-100).
		
	}
	/**
	 * Getter and Setter methods, if needed.
	 * 
	 */

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	
	
	
}
