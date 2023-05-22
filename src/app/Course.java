package app;

import java.util.ArrayList;
import java.util.List;

public abstract class Course {

  /**
   * This class is Course class which stores all information about the courses.
   */
  private String name;
  private List<Tutor> tutors; // the list of its tutors.
  private List<Student> students; // the list of its students.
  protected List<Course> prerequisites; // the list of its prerequisites.
  private List<Equipment> equipmentRequirements; // the list of its required equipments.
  private double profit; // the double number to store the profit gained from this course by tutoring center's.

  /**
   * The constructor of the class.
   * @param name
   */
  public Course(String name) {
	super();
	this.name = name;
	this.tutors = new ArrayList<>();
	this.students = new ArrayList<>();
	this.prerequisites = new ArrayList<>();
	this.equipmentRequirements = new ArrayList<>();
  }
  /**
   * This method is to check the tutors level before adding he/she to the tutors list.
   * @param tutor
   * @return true if he/she is a ALevel tutor, and if he/she is a BLevel tutor when the course is a Beginner Course, otherwise false.
   */
  public abstract boolean canAddTutor(Tutor tutor);

  /**
   * The method is to check canAddTutor status and add the tutor to tutors list.
   * @param tutor
   */
  public void addTutor(Tutor tutor) {
    if (canAddTutor(tutor)) {
      this.tutors.add(tutor);
    }
  }
  /**
   * Getter and Setter methods.
   * 
   */

  public void setPrerequisites(List<Course> prerequisites) {
  		this.prerequisites = prerequisites;
  }

  public void setEquipmentRequirements(List<Equipment> equipmentRequirements) {
  		this.equipmentRequirements = equipmentRequirements;
  }

  public void addStudent(Student student) {
		this.students.add(student);
  }

  public void addPrerequisite(Course course) {
		this.prerequisites.add(course);
  }

  public void addEquipmentRequirement(Equipment equipment) {
    this.equipmentRequirements.add(equipment);
  }

  public String getName() {
    return name;
  }

  public List<Tutor> getTutors() {
    return tutors;
  }

  public List<Student> getStudents() {
    return students;
  }

  public List<Course> getPrerequisites() {
    return prerequisites;
  }

  public List<Equipment> getEquipmentRequirements() {
    return equipmentRequirements;
  }

  public double getProfit() {
	return profit;
  }

  public void setProfit(double profit) {
	this.profit = profit;
  }
}


