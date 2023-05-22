package app;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;

import GUI.StartPage;

public class Main {
	/************** Pledge of Honor ******************************************
	I hereby certify that I have completed this programming project on my own
	without any help from anyone else. The effort in the project thus belongs
	completely to me. I did not search for a solution, or I did not consult any
	program written by others or did not copy any program from other sources. I
	read and followed the guidelines provided in the project description.
	READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID
	SIGNATURE: <Metehan Yaka, 75852>
	*************************************************************************/
	/**
	 * 
	 * @author Metehan Yaka
	 */
	
	/**
	 * The lists of corresponding types to store the users,tutors,students,courses(beginner,advanced),equipments.
	 */
	public static List<User> userList = new ArrayList<>();
	public static List<Student> studentList = new ArrayList<>();
	public static List<Tutor> AlevelTutorList = new ArrayList<>();
	public static List<Tutor> BlevelTutorList = new ArrayList<>();
	public static List<Tutor> tutorList =  new ArrayList<>();
	public static List<Course> advancedCourseList = new ArrayList<>();
	public static List<Course> beginnerCourseList = new ArrayList<>();
	public static List<Course> courseList = new ArrayList<>();
	public static List <Equipment> equipmentList = new ArrayList<>();
	public static User activeUser;
	/**
	 * The main method which runs the start page and create the all default users,courses,equipments...
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		/**
		 * Creating students
		 */
		ImageIcon image = new ImageIcon("src/img/pp.png");
        File file = new File("src/names.txt");
        File file1 = new File("src/a.txt");
        File file2 = new File("src/b.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
       
        Random rand = new Random();
        while (br.ready()) {
        	String st = br.readLine();
        	long numbers = (long)(rand.nextInt(10)*10000000000L) + (long)(rand.nextDouble() * 9999999999L);
        	String tckn = Long.toString(numbers);
        	String age = Integer.toString(rand.nextInt(18,90));
        	double balance = rand.nextDouble(2000,3000);
        	String username = st.toLowerCase();
        	String pass = "1234";
        	Student newUser = new Student(st,tckn,age,image,balance,username,pass);
        	userList.add(newUser);
        	studentList.add(newUser);
        	
        }
        /**
		 * Creating Admin
		 */
     
		User admin = new Administrator("admin","admin");
		userList.add(admin);
		
		/**
		 * Creating courses
		 */
		
		// beginner courses
		
		Course course1 = new BeginnerCourse("Comp 100");beginnerCourseList.add(course1);
		Course course2 = new BeginnerCourse("Comp 106");beginnerCourseList.add(course2);
		Course course3 = new BeginnerCourse("Math 106");beginnerCourseList.add(course3);
		Course course4 = new BeginnerCourse("Physic 101");beginnerCourseList.add(course4);
		Course course5 = new BeginnerCourse("Acwr 101");beginnerCourseList.add(course5);
		Course course6 = new BeginnerCourse("Sosc 105");beginnerCourseList.add(course6);
		
		//advanced courses
		Course course7 = new AdvancedCourse("Comp 132");advancedCourseList.add(course7);
		Course course8 = new AdvancedCourse("Comp 201");advancedCourseList.add(course8);
		Course course9 = new AdvancedCourse("Math 203");advancedCourseList.add(course9);
		Course course10 = new AdvancedCourse("Physic 102");advancedCourseList.add(course10);
		Course course11 = new AdvancedCourse("Acwr 106");advancedCourseList.add(course11);
		Course course12 = new AdvancedCourse("Comp 191");advancedCourseList.add(course12);
		
		/**
		 * Adding the prerequisites to the courses.
		 */
		
		course7.getPrerequisites().add(course1);
		
		courseList.addAll(beginnerCourseList);
		courseList.addAll(advancedCourseList);
		
		
		/**
		 * Creating tutors
		 */
		
//		creating A Level Tutors
		BufferedReader br1 = new BufferedReader(new FileReader(file1));
		while (br1.ready()) {
			String st = br1.readLine();
        	long numbers = (long)(rand.nextInt(10)*10000000000L) + (long)(rand.nextDouble() * 9999999999L);
        	String tckn = Long.toString(numbers);
        	String age = Integer.toString(rand.nextInt(18,90));
        	double balance = 0;
        	String username = "tutor"+st.toLowerCase();
        	String pass = "1234";
        	Tutor user = new ALevelTutor(st,tckn,age,image,balance,username,pass);
        	userList.add(user);
        	AlevelTutorList.add(user);
        	if (AlevelTutorList.size() == 18) break;
        }
//		creating B Level Tutors
		BufferedReader br2 = new BufferedReader(new FileReader(file2));
		while (br2.ready()) {
			String st = br2.readLine();
        	long numbers = (long)(rand.nextInt(10)*10000000000L) + (long)(rand.nextDouble() * 9999999999L);
        	String tckn = Long.toString(numbers);
        	String age = Integer.toString(rand.nextInt(18,90));
        	double balance = 0;
        	String username = "tutor"+st.toLowerCase();
        	String pass = "1234";
        	Tutor user = new BLevelTutor(st,tckn,age,image,balance,username,pass);
        	userList.add(user);
        	BlevelTutorList.add(user);
        	if (BlevelTutorList.size() == 18) break;
        }
		// adding both A level and B level tutors to tutorlist.
		tutorList.addAll(BlevelTutorList);
		tutorList.addAll(AlevelTutorList);
		
		/**
		 * Creating default schedules to default tutor teach the courses.
		 * To meet the project demo requirements.
		 */
		
		LocalTime startTime = LocalTime.parse("08:00:00");
		LocalTime endTime = startTime.plusHours(1);
		LocalTime startTime1 = endTime;
		LocalTime endTime1 = startTime1.plusHours(1);
		LocalTime startTime2 = endTime1;
		LocalTime endTime2 = startTime2.plusHours(1);
		Random random = new Random();
		
		//Beginner
		
		BlevelTutorList.get(0).addCourse(course1, new Schedule(startTime,endTime));
		BlevelTutorList.get(0).addCourse(course1, new Schedule(startTime1,endTime1));
		BlevelTutorList.get(0).addCourse(course1, new Schedule(startTime2,endTime2));
		BlevelTutorList.get(1).addCourse(course1, new Schedule(startTime,endTime));
		BlevelTutorList.get(1).addCourse(course1, new Schedule(startTime1,endTime1));
		BlevelTutorList.get(1).addCourse(course1, new Schedule(startTime2,endTime2));
		BlevelTutorList.get(2).addCourse(course1, new Schedule(startTime,endTime));
		BlevelTutorList.get(2).addCourse(course1, new Schedule(startTime1,endTime1));
		
		BlevelTutorList.get(3).addCourse(course2, new Schedule(startTime,endTime));
		BlevelTutorList.get(3).addCourse(course2, new Schedule(startTime1,endTime1));
		BlevelTutorList.get(3).addCourse(course2, new Schedule(startTime2,endTime2));
		BlevelTutorList.get(4).addCourse(course2, new Schedule(startTime,endTime));
		BlevelTutorList.get(4).addCourse(course2, new Schedule(startTime1,endTime1));
		BlevelTutorList.get(4).addCourse(course2, new Schedule(startTime2,endTime2));
		BlevelTutorList.get(5).addCourse(course2, new Schedule(startTime,endTime));
		BlevelTutorList.get(5).addCourse(course2, new Schedule(startTime1,endTime1));
		
		BlevelTutorList.get(6).addCourse(course3, new Schedule(startTime,endTime));
		BlevelTutorList.get(6).addCourse(course3, new Schedule(startTime1,endTime1));
		BlevelTutorList.get(6).addCourse(course3, new Schedule(startTime2,endTime2));
		BlevelTutorList.get(7).addCourse(course3, new Schedule(startTime,endTime));
		BlevelTutorList.get(7).addCourse(course3, new Schedule(startTime1,endTime1));
		BlevelTutorList.get(7).addCourse(course3, new Schedule(startTime2,endTime2));
		BlevelTutorList.get(8).addCourse(course3, new Schedule(startTime,endTime));
		BlevelTutorList.get(8).addCourse(course3, new Schedule(startTime2,endTime2));
		
		BlevelTutorList.get(9).addCourse(course4, new Schedule(startTime,endTime));
		BlevelTutorList.get(9).addCourse(course4, new Schedule(startTime1,endTime1));
		BlevelTutorList.get(9).addCourse(course4, new Schedule(startTime2,endTime2));
		BlevelTutorList.get(10).addCourse(course4, new Schedule(startTime,endTime));
		BlevelTutorList.get(10).addCourse(course4, new Schedule(startTime1,endTime1));
		BlevelTutorList.get(10).addCourse(course4, new Schedule(startTime2,endTime2));
		BlevelTutorList.get(11).addCourse(course4, new Schedule(startTime2,endTime2));
		BlevelTutorList.get(11).addCourse(course4, new Schedule(startTime1,endTime1));
		
		BlevelTutorList.get(12).addCourse(course5, new Schedule(startTime,endTime));
		BlevelTutorList.get(12).addCourse(course5, new Schedule(startTime1,endTime1));
		BlevelTutorList.get(12).addCourse(course5, new Schedule(startTime2,endTime2));
		BlevelTutorList.get(13).addCourse(course5, new Schedule(startTime,endTime));
		BlevelTutorList.get(13).addCourse(course5, new Schedule(startTime1,endTime1));
		BlevelTutorList.get(13).addCourse(course5, new Schedule(startTime2,endTime2));
		BlevelTutorList.get(14).addCourse(course5, new Schedule(startTime1,endTime1));
		BlevelTutorList.get(14).addCourse(course5, new Schedule(startTime,endTime));
		
		BlevelTutorList.get(15).addCourse(course6, new Schedule(startTime,endTime));
		BlevelTutorList.get(15).addCourse(course6, new Schedule(startTime1,endTime1));
		BlevelTutorList.get(15).addCourse(course6, new Schedule(startTime2,endTime2));
		BlevelTutorList.get(16).addCourse(course6, new Schedule(startTime,endTime));
		BlevelTutorList.get(16).addCourse(course6, new Schedule(startTime1,endTime1));
		BlevelTutorList.get(16).addCourse(course6, new Schedule(startTime2,endTime2));
		BlevelTutorList.get(17).addCourse(course6, new Schedule(startTime2,endTime2));
		BlevelTutorList.get(17).addCourse(course6, new Schedule(startTime1,endTime1));
		
		
		// Advanced 
		
		AlevelTutorList.get(0).addCourse(course7, new Schedule(startTime,endTime));
		AlevelTutorList.get(0).addCourse(course7, new Schedule(startTime1,endTime1));
		AlevelTutorList.get(0).addCourse(course7, new Schedule(startTime2,endTime2));
		AlevelTutorList.get(1).addCourse(course7, new Schedule(startTime,endTime));
		AlevelTutorList.get(1).addCourse(course7, new Schedule(startTime1,endTime1));
		AlevelTutorList.get(1).addCourse(course7, new Schedule(startTime2,endTime2));
		AlevelTutorList.get(2).addCourse(course7, new Schedule(startTime,endTime));
		AlevelTutorList.get(2).addCourse(course7, new Schedule(startTime1,endTime1));
		
		AlevelTutorList.get(3).addCourse(course8, new Schedule(startTime,endTime));
		AlevelTutorList.get(3).addCourse(course8, new Schedule(startTime1,endTime1));
		AlevelTutorList.get(3).addCourse(course8, new Schedule(startTime2,endTime2));
		AlevelTutorList.get(4).addCourse(course8, new Schedule(startTime,endTime));
		AlevelTutorList.get(4).addCourse(course8, new Schedule(startTime1,endTime1));
		AlevelTutorList.get(4).addCourse(course8, new Schedule(startTime2,endTime2));
		AlevelTutorList.get(5).addCourse(course8, new Schedule(startTime,endTime));
		AlevelTutorList.get(5).addCourse(course8, new Schedule(startTime1,endTime1));
		
		AlevelTutorList.get(6).addCourse(course9, new Schedule(startTime,endTime));
		AlevelTutorList.get(6).addCourse(course9, new Schedule(startTime1,endTime1));
		AlevelTutorList.get(6).addCourse(course9, new Schedule(startTime2,endTime2));
		AlevelTutorList.get(7).addCourse(course9, new Schedule(startTime,endTime));
		AlevelTutorList.get(7).addCourse(course9, new Schedule(startTime1,endTime1));
		AlevelTutorList.get(7).addCourse(course9, new Schedule(startTime2,endTime2));
		AlevelTutorList.get(8).addCourse(course9, new Schedule(startTime,endTime));
		AlevelTutorList.get(8).addCourse(course9, new Schedule(startTime2,endTime2));
		
		AlevelTutorList.get(9).addCourse(course10, new Schedule(startTime,endTime));
		AlevelTutorList.get(9).addCourse(course10, new Schedule(startTime1,endTime1));
		AlevelTutorList.get(9).addCourse(course10, new Schedule(startTime2,endTime2));
		AlevelTutorList.get(10).addCourse(course10, new Schedule(startTime,endTime));
		AlevelTutorList.get(10).addCourse(course10, new Schedule(startTime1,endTime1));
		AlevelTutorList.get(10).addCourse(course10, new Schedule(startTime2,endTime2));
		AlevelTutorList.get(11).addCourse(course10, new Schedule(startTime2,endTime2));
		AlevelTutorList.get(11).addCourse(course10, new Schedule(startTime1,endTime1));
		
		AlevelTutorList.get(12).addCourse(course11, new Schedule(startTime,endTime));
		AlevelTutorList.get(12).addCourse(course11, new Schedule(startTime1,endTime1));
		AlevelTutorList.get(12).addCourse(course11, new Schedule(startTime2,endTime2));
		AlevelTutorList.get(13).addCourse(course11, new Schedule(startTime,endTime));
		AlevelTutorList.get(13).addCourse(course11, new Schedule(startTime1,endTime1));
		AlevelTutorList.get(13).addCourse(course11, new Schedule(startTime2,endTime2));
		AlevelTutorList.get(14).addCourse(course11, new Schedule(startTime1,endTime1));
		AlevelTutorList.get(14).addCourse(course11, new Schedule(startTime,endTime));
		
		AlevelTutorList.get(15).addCourse(course12, new Schedule(startTime,endTime));
		AlevelTutorList.get(15).addCourse(course12, new Schedule(startTime1,endTime1));
		AlevelTutorList.get(15).addCourse(course12, new Schedule(startTime2,endTime2));
		AlevelTutorList.get(16).addCourse(course12, new Schedule(startTime,endTime));
		AlevelTutorList.get(16).addCourse(course12, new Schedule(startTime1,endTime1));
		AlevelTutorList.get(16).addCourse(course12, new Schedule(startTime2,endTime2));
		AlevelTutorList.get(17).addCourse(course12, new Schedule(startTime2,endTime2));
		AlevelTutorList.get(17).addCourse(course12, new Schedule(startTime1,endTime1));
		
		/** 
		 * Adding the the created schedules random price
		 * 
		 */
		
		for (Tutor tutor : AlevelTutorList) {
			for (Schedule sc : tutor.getCourses().keySet()) {
				double randPrice = random.nextDouble(700,random.nextInt(1000,2000)); // min price 700 max price 2000
				sc.setPrice(randPrice);
			}
		}
		
		for (Tutor tutor : BlevelTutorList) {
			for (Schedule sc : tutor.getCourses().keySet()) {
				double randPrice = random.nextDouble(100,random.nextInt(200,1000)); // min price 100 max price 1000
				sc.setPrice(randPrice);
			}
		}
		/**
		 * Creating new Equipments and add them to equipmentList
		 */
		equipmentList.add(new Equipment("Macbook"));
		equipmentList.add(new Equipment("Ipad"));
		equipmentList.add(new Equipment("Laptop"));
		equipmentList.add(new Equipment("Tablet"));
		equipmentList.add(new Equipment("Book"));
		equipmentList.add(new Equipment("Kindle"));
		
		/**
		 * Extra user to test the program
		 */
		Student st = new Student("mete","","",image,1000,"mete","1234");
		userList.add(st);
		st.getEquipments().add(equipmentList.get(0));
		
		/**
		 * Running the StartPage to start program.
		 */
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartPage frame = new StartPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		
		
	
	}

}
