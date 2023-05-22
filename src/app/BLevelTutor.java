package app;

import java.awt.Image;

import javax.swing.ImageIcon;

public class BLevelTutor extends Tutor implements Teachable {
	
	/**
	 * This class is subclass of Tutor class.
	 */
	
	/**
	 * The constructor of the class.
	 * The parameters are information about the tutor.
	 * @param name
	 * @param id
	 * @param age
	 * @param portraitPhoto
	 * @param balance
	 * @param userName
	 * @param password
	 */

	public BLevelTutor(String name, String id, String age, ImageIcon portraitPhoto, double balance, String userName, String password) {
		super(name, id, age, portraitPhoto, balance, userName, password);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canTeachCourse(Course course) {
	   return course instanceof BeginnerCourse; // return true if the course is beginner course because the tutor is a B Level tutor.
	}

	
	
}
