package app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;

public abstract class Tutor extends User{
	/**
	 * This is the Tutor class which is the subclass of User class.
	 */
	private String name;
	private String tckn;
	private String age;
	private ImageIcon portraitPhoto;
	private double balance;
	private List<Schedule> schedules; // the list of schedules to store tutor's filled schedules.
	private Map<HashMap<Course,Schedule>,Student> registeredStudents; 
	/**
	 * This is the map which contains a HashMap<Course,Schedule> as a key and a Student as a value in order to store the registered students information(Which course? When? Who?).
	 */
	private Map<Schedule,Course> courses;
	  /**
	   * The constructor of the class.
	   * These parameters provide the information about the tutor.
	   * @param name
	   * @param tckn
	   * @param age
	   * @param portraitPhoto
	   * @param balance
	   * @param userName
	   * @param password
	   */
	  
	public Tutor(String name, String tckn,String age, ImageIcon portraitPhoto, double balance, String userName, String password) {
		super(userName,password);
		this.setAge(age);
	    this.name = name;
	    this.tckn = tckn;
	    this.balance = balance;
	    this.portraitPhoto = portraitPhoto;
	    this.schedules = new ArrayList<>();
	    this.registeredStudents = new HashMap<>();
	    this.courses = new HashMap<>();
	}
	/**
	 * This is a abstract method which is to know tutor canTeach the course.
	 * @param course the course which tutor want to teach.
	 * @return true if the tutor is ALevel, also true if the tutor is BLevel only course parameter is a Beginner course.
	 */
	public abstract boolean canTeachCourse(Course course);
	
	/**
	 * This method is to add a course to tutors courses map. The method check the tutor canTeachCourse status.
	 * @param course the course tutor wants to teach
	 * @param schedule the schedule which is the information about when the tutor wants to teach the course.
	 */
	public void addCourse(Course course, Schedule schedule ) {
	    if (canTeachCourse(course)) {
	      courses.put(schedule,course);
	    }
	  }
	
	/**
	 * Getter and Setter methods, if needed.
	 * 
	 */
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getName() {
	    return name;
	  }
	public String getTckn() {
	    return tckn;
	  }
	
	public double getBalance() {
	    return balance;
	  }
	public List<Schedule> getSchedules() {
	    return schedules;
	}
	
	public Map<Schedule,Course> getCourses() {
		return courses;
	}

	public void setCourses(Map<Schedule,Course > courses) {
		this.courses = courses;
	}

	public ImageIcon getPortraitPhoto() {
		return portraitPhoto;
	}
	
	public void setPortraitPhoto(ImageIcon portraitPhoto) {
		this.portraitPhoto = portraitPhoto;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTckn(String tckn) {
		this.tckn = tckn;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}

	public Map<HashMap<Course, Schedule>,Student> getRegisteredStudents() {
		return registeredStudents;
	}

	public void setRegisteredStudents(Map<HashMap<Course, Schedule>,Student> registeredStudents) {
		this.registeredStudents = registeredStudents;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

}

	  
	  
	
