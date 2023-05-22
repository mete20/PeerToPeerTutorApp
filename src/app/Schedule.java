package app;


import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Schedule  {
	
	/**
	 * This class is the Schedule class which stores the start and end time information of a unique schedule (given by tutor).
	 * It has also a price to store the price of that lesson and list of student who took this schedule from the tutor.
	 * 
	 */
	private LocalTime startTime;
	private LocalTime endTime;
	private double price;
	private List <Student> registeredStudents;
	
	/**
	 * The constructor of the class.
	 * @param startTime
	 * @param endTime
	 */
	public Schedule(LocalTime startTime, LocalTime endTime) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.setRegisteredStudents(new ArrayList<>());
	
	}
	/**
	 * This method is for check given start and end time is in given range or not.
	 * isBefore and isAfter methods of LocalTime is using '<' and '>' that's why this method first check the equalities.
	 * Then both check the start and end time is in range or not with using isBefore and isAfter.
	 */
	public boolean isInRange(LocalTime startTime,LocalTime endTime,LocalTime rangeStart, LocalTime rangeEnd)  {
		
		if(startTime.equals(rangeEnd)) { 
			return true;
		}
		if(endTime.equals(rangeStart)) {
			return true;
		}
		
		if(!( ! startTime.isBefore( rangeStart ) ) && ( startTime.isBefore( rangeEnd ))){
			if (!( ! endTime.isBefore( rangeStart ) ) && ( endTime.isBefore( rangeEnd ))) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	
	}
	
	/**
	 * 
	 * Getter and Setter methods, if needed.
	 */
	
	public LocalTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	public LocalTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public List <Student> getRegisteredStudents() {
		return registeredStudents;
	}
	public void setRegisteredStudents(List <Student> registeredStudents) {
		this.registeredStudents = registeredStudents;
	}
	
	
	

	

}
