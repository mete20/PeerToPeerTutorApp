package app;

import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;

public class Student extends User{
	/**
	 * This is the Student class which is a subclass of User class. 
	 */
	  private String name;
	  private String TCKN;
	  private String age;
	  private ImageIcon portraitPhoto;
	  private double balance;
	  private List<Course> passedCourses; // the list of courses which contains the student's passed courses,
	  private Map<Course,Tutor> courseHistory; // the map which contains courses as a key and tutors as a value to store students course history(passed,progress, and failed courses).
	  
	  private Map<Course,HashMap<Tutor,Schedule>> registeredCourses; 
	  /**
	  the map which contains courses as a key and a HashMap<Tutor,Schedule> as a value to store information (which course? who teaches? when?)) about the students registered lessons.
	   */
	  private List<Schedule> schedules; // the list of schedules which contains the all schedules that the student has to know students busy times.
	  
	  private List<Equipment> equipments; // the list of equipments which contains the all equipments that the student has.
	  
	/**
	 * Class Constructor
	 * @param name the string which is the name of the student
	 * @param tCKN the string which is the identifaciton number of the student
	 * @param age  the string which is the age of the student
	 * @param portraitPhoto the ImageIcon which is the profile photo of the student
	 * @param balance the double number which is the monetary balance of the student
	 * @param userName the string which is the user name of the student
	 * @param password the string which is the password of the student
	 */
	  public Student(String name, String tCKN, String age, ImageIcon portraitPhoto, double balance, String userName, String password) {
		super(userName, password);
		this.name = name;
		TCKN = tCKN;
		this.age = age;
		this.portraitPhoto = portraitPhoto;
		this.passedCourses = new ArrayList<>();
		this.registeredCourses = new HashMap<>();
		this.schedules = new ArrayList<>();
		this.equipments= new ArrayList<>();
		this.balance = balance;
		this.courseHistory = new HashMap<>();
	  }
	/**
	 * Getter and Setter methods of the corresponding variables.
	 * 
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTCKN() {
		return TCKN;
	}

	public void setTCKN(String tCKN) {
		TCKN = tCKN;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public ImageIcon getPortraitPhoto() {
		return portraitPhoto;
	}

	public void setPortraitPhoto(ImageIcon portraitPhoto) {
		this.portraitPhoto = portraitPhoto;
	}

	public List<Course> getPassedCourses() {
		return passedCourses;
	}

	public void setPassedCourses(List<Course> passedCourses) {
		this.passedCourses = passedCourses;
	}

	public List<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}

	public Map<Course, HashMap<Tutor, Schedule>> getRegisteredCourses() {
		return registeredCourses;
	}

	public void setRegisteredCourses(Map<Course, HashMap<Tutor, Schedule>> registeredCourses) {
		this.registeredCourses = registeredCourses;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Map<Course, Tutor> getCourseHistory() {
		return courseHistory;
	}

	public void setCourseHistory(Map<Course, Tutor> courseHistory) {
		this.courseHistory = courseHistory;
	}

	public List<Equipment> getEquipments() {
		return equipments;
	}

	public void setEquipments(List<Equipment> equipments) {
		this.equipments = equipments;
	}
	
	/**
	 * toString method to test the students information if needed.
	 */

	@Override
	public String toString() {
		return super.toString() + "Student [name=" + name + ", TCKN=" + TCKN + ", age=" + age + ", balance=" + balance + "]";
	}

	
	  
	}