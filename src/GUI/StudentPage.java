package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import app.ALevelTutor;
import app.Administrator;
import app.BeginnerCourse;
import app.Course;
import app.Main;
import app.Schedule;
import app.Student;
import app.Tutor;

public class StudentPage extends JFrame {
	/**
	 * This Page is Students Home Page.
	 */
	private JPanel contentPane;
	private JTable table;
	public static Student activeStudent = (Student) Main.activeUser;
	public static List <Object []> objs = new ArrayList<>(); // This list for store the tables rows.
	private static final DecimalFormat df = new DecimalFormat("0.00");
	
	/**
	 * Create the frame.
	 */
	public StudentPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 1050, 750);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 1050, 722);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel welcomeLabel = new JLabel("Welcome!");
		welcomeLabel.setBounds(343, 6, 139, 36);
		welcomeLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		panel.add(welcomeLabel);
		
		JLabel userNameLabel = new JLabel(Main.activeUser.getUserName());
		userNameLabel.setBounds(513, 6, 334, 36);
		userNameLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		panel.add(userNameLabel);
		
		JPanel menu_panel = new JPanel();
		menu_panel.setBounds(0, 0, 198, 722);
		panel.add(menu_panel);
		menu_panel.setLayout(null);
		
		JButton myProfileButton = new JButton("My Profile");
		myProfileButton.setBounds(6, 147, 185, 44);
		menu_panel.add(myProfileButton);
		myProfileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Student_Profile s = new Student_Profile();
				s.setVisible(true);
			}
		});
		myProfileButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		JButton myCoursesButton = new JButton("My Courses");
		myCoursesButton.setBounds(6, 259, 185, 44);
		menu_panel.add(myCoursesButton);
		myCoursesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Student_Courses s = new Student_Courses();
				s.setVisible(true);
				objs = new ArrayList<>();
			}
		});
		myCoursesButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(26, 34, 48, 44);
		menu_panel.add(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon(StudentPage.class.getResource("/img/7124209_menu_icon (1).png")));
		
		JLabel menuLabel = new JLabel("MENU");
		menuLabel.setHorizontalAlignment(SwingConstants.LEFT);
		menuLabel.setBounds(80, 34, 95, 44);
		menu_panel.add(menuLabel);
		menuLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		
		JButton courseHistorybutton = new JButton("Course History");
		courseHistorybutton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		courseHistorybutton.setBounds(6, 203, 185, 44);
		menu_panel.add(courseHistorybutton);
		
		
		
		JButton marketButton = new JButton("Market");
		marketButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Market market = new Market();
				market.setVisible(true);
				objs = new ArrayList<>();
			}
		});
		marketButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		marketButton.setBounds(6, 371, 185, 44);
		menu_panel.add(marketButton);
		courseHistorybutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Student_CourseHistory s = new Student_CourseHistory();
				s.setVisible(true);
				objs = new ArrayList<>();
			}
		});
		
		JPanel menu_panel_1 = new JPanel();
		menu_panel_1.setBounds(852, 0, 198, 722);
		menu_panel_1.setLayout(null);
		panel.add(menu_panel_1);
		
		JButton signOutButton = new JButton("Sign Out");
		signOutButton.setBounds(6, 21, 185, 44);
		menu_panel_1.add(signOutButton);
		signOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				StartPage startPage = new StartPage();
				startPage.setVisible(true);
				objs = new ArrayList<>();
			}
		});
		signOutButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		DecimalFormat df = new DecimalFormat("#,###.##");
		
        String bln = df.format(activeStudent.getBalance());
        JLabel balanceLabe = new JLabel("Your Balance:");
		balanceLabe.setBounds(240, 81, 84, 16);
		panel.add(balanceLabe);
		
		JLabel balance = new JLabel("");
		balance.setBounds(336, 81, 146, 16);
		panel.add(balance);
		
		balance.setText(bln + "TL");
		/**
		 * This JTable shows the all sections.
		 */
		String col[] = {"Course","Tutor","Price","Level","Start Time","End Time","Status"};
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		JTable table = new JTable(tableModel);	
		// adding elements to the table
		fillTable();
		for (Object[] obj: objs) tableModel.addRow(obj);
		table.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		table.setAutoCreateRowSorter(true);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(240, 127, 570, 533);
		panel.add(scrollPane);
		
		/**
		 * This is the register button which checks the situations and register the student to that schedule.
		 */
		JButton registerButton = new JButton("Register");
		registerButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int row = table.getSelectedRow();
				String courseName = table.getModel().getValueAt(row, 0).toString();
				String tutorName = table.getModel().getValueAt(row, 1).toString();
				String startTime = table.getModel().getValueAt(row, 4).toString();
				String endTime = table.getModel().getValueAt(row, 5).toString();
				String status = table.getModel().getValueAt(row, 6).toString();
				String price = table.getModel().getValueAt(row, 2).toString();
				
				
				for (Tutor tutor : Main.tutorList) {
					if (tutor.getName().equals(tutorName)) {
						for (Course course : Main.courseList) {
							if (course.getName().equals(courseName)) {
								// check is he passed this course before or already registered
								if(activeStudent.getPassedCourses().contains(course)) {
									JOptionPane.showMessageDialog(null, "You have already passed this course",
								               "Message", JOptionPane.ERROR_MESSAGE);
								}
								else if (activeStudent.getRegisteredCourses().containsKey(course)) {
									JOptionPane.showMessageDialog(null, "You have already registered this course",
								               "Message", JOptionPane.ERROR_MESSAGE);
								}
								else {
									// check prerequsites
									List<Course> pres = course.getPrerequisites();
									
									boolean valid = true;
									for (Course pre : pres) {
										if (pres != null) {
											if (activeStudent.getPassedCourses().contains(pre)) {
												valid = valid && true;
											}
											else valid = false;
										}
									}
									if (valid) {
										// check time
										LocalTime start = LocalTime.parse(startTime);
										LocalTime end = LocalTime.parse(endTime);
										LocalTime controlStart;
										LocalTime controlEnd;
										boolean isTimeValid = true;
										for (Schedule sc: activeStudent.getSchedules()) {
											controlStart= sc.getStartTime();
											controlEnd= sc.getEndTime();
											isTimeValid = isTimeValid && sc.isInRange(start,end, controlStart, controlEnd);
										}
										
										if (isTimeValid) {
											Schedule sc = new Schedule(start,end);
											if(status.equals("Available")) {
												
												
												String p = price.substring(0, price.length()-1);
												double doublePrice = Double.parseDouble(p);
												/// check the balance
												
												if (activeStudent.getBalance() < doublePrice) {
													JOptionPane.showMessageDialog(null, "You do not have enough money.",
												               "Message", JOptionPane.ERROR_MESSAGE);
												}
												else {
													course.addStudent(activeStudent);
													activeStudent.getSchedules().add(sc);
													HashMap<Tutor, Schedule> newMap = new HashMap<>();
													newMap.put(tutor, sc);
													activeStudent.getRegisteredCourses().put(course, newMap);
													activeStudent.getCourseHistory().put(course, tutor);
													// adding student to the tutor's registered students in that schedule
													
													for(Schedule sch : tutor.getCourses().keySet()) {
														if(tutor.getCourses().get(sch).getName().equals(courseName)) {
															if(sch.getStartTime().equals(start) && sch.getEndTime().equals(end)) {
																sch.getRegisteredStudents().add(activeStudent);
															}
														}
														
													}
													
													tableModel.setValueAt("Taken", row, 6);
													
													activeStudent.setBalance(activeStudent.getBalance() - doublePrice);
													Random random = new Random();
													if(tutor instanceof ALevelTutor) {
														int randInt = random.nextInt(1,10);
														tutor.setBalance(tutor.getBalance() + (doublePrice*(100-randInt)/100));
														Administrator.profit += (doublePrice*randInt/100);
														course.setProfit(course.getProfit() + (doublePrice*randInt/100));
													}
													else {
														int randInt = random.nextInt(1,15);
														tutor.setBalance(tutor.getBalance() + (doublePrice*(100-randInt)/100));
														Administrator.profit += (doublePrice*randInt/100);
														course.setProfit(course.getProfit() + (doublePrice*randInt/100));
													}
													tutor.setBalance(tutor.getBalance() + doublePrice);
													
													String bln1 = df.format(activeStudent.getBalance());
													balance.setText(bln1 + "TL");

													
													JOptionPane.showMessageDialog(null, "You have successfully registered.",
												               "Message", JOptionPane.ERROR_MESSAGE);
													
												}
												
												
											}
											else {
												JOptionPane.showMessageDialog(null, "This course is taken",
											               "Message", JOptionPane.ERROR_MESSAGE);
											}
											
											
											
										}
										
										else {
											JOptionPane.showMessageDialog(null, "You have another course in that time range.",
										               "Message", JOptionPane.ERROR_MESSAGE);
										}
										
									}
										
										
										
									
									else {
										JOptionPane.showMessageDialog(null, "You do not have this courses prerequsities.",
									               "Message", JOptionPane.ERROR_MESSAGE);
									}
									
								}
								
							}
								
							}
						}
					}
					
				}
		});
		registerButton.setBounds(6, 121, 185, 44);
		menu_panel_1.add(registerButton);
		

		
		
		
		

		
		
		
	}

	/**
	 * This method is filling the table. To show all sections.
	 */
	public void fillTable() {
		
		df.setRoundingMode(RoundingMode.DOWN);
		
		for (Tutor tutor : Main.tutorList) {
			
			for (Schedule sc: tutor.getCourses().keySet()) {
				Course course = tutor.getCourses().get(sc);
				String courseName = course.getName();
				String tutorName = tutor.getName();
				double doublePrice = sc.getPrice();
				String price = df.format(doublePrice) +"$";
				String level;
				String startTime = sc.getStartTime().toString();
				String endTime = sc.getEndTime().toString();
				if (course instanceof BeginnerCourse) {
					level = "Beginner";
				}
				else level = "Advanced";
				
				String status;
				
				if(sc.getRegisteredStudents().isEmpty()) {
					status = "Available";
				}
				else {
					status = "Taken";
				}

				Object[] obj = {courseName,tutorName,price,level,startTime,endTime,status};
				if (objs.isEmpty()) {
					objs.add(obj);
				}
				else {
					if (!objs.contains(obj)) objs.add(obj);
				}

			}
		}
	
		
	}
	
	

}
