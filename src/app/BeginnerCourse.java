package app;

import java.util.ArrayList;
import java.util.List;

public class BeginnerCourse extends Course {
	/**
	 * This class is a subclass of Course class.
	 */
	/**
	 * The constructor of the class.
	 * @param name
	 */
	public BeginnerCourse(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canAddTutor(Tutor tutor) {
	    return true;
	  }

	@Override
	public void addPrerequisite(Course course) {
		// TODO Auto-generated method stub
		
		if (course instanceof BeginnerCourse) {
			this.prerequisites.add(course); // add the course if it is a beginner course.
		}
		
	}
	
	
	  
	  
}