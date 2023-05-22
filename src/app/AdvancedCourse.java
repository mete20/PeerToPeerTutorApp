package app;

import java.util.List;

public class AdvancedCourse extends Course {
	/**
	 * This class is a subclass of Course class.
	 */
	/**
	 * The constructor of the class.
	 * @param name
	 */

	public AdvancedCourse(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	  public boolean canAddTutor(Tutor tutor) {
	    return (tutor instanceof ALevelTutor);  // return true if tutor is a Alevel tutor.
	  }
	
	
	
}
	

