package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.ALevelTutor;
import app.Course;
import app.Main;
import app.Schedule;
import app.Tutor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.awt.event.ActionEvent;

public class TutorPage extends JFrame {
	/**
	 * This page is the tutor Home Page 
	 * The tutor can begin a teaching a course 
	 */
	private JPanel contentPane;
	private JTextField startTime;
	private JTextField endTime;
	private JTextField price;
	public static Tutor activeTutor = (Tutor) Main.activeUser;


	/**
	 * Create the frame.
	 */
	public TutorPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 1050, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(362, 213, 277, 255);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel title = new JLabel("Teach A Course");
		title.setBounds(85, 26, 98, 16);
		panel.add(title);
		
		/**
		 * this comboBox for displaying the courses
		 */
		JComboBox comboBox;
		String [] courses = new String[Main.courseList.size()];
		String [] beginnerCourses = new String[Main.beginnerCourseList.size()];
		
		// filling the comboBox
		if (activeTutor instanceof ALevelTutor) {
			for (int i = 0; i< Main.courseList.size(); i++) {
				String courseName = Main.courseList.get(i).getName();
				courses[i] = courseName;
			}
			comboBox = new JComboBox(courses);
		}
		else {
			for (int i = 0; i< Main.beginnerCourseList.size(); i++) {
				String courseName = Main.beginnerCourseList.get(i).getName();
				courses[i] = courseName;
			}
			comboBox = new JComboBox(beginnerCourses);
			
		}
		
		
		comboBox.setBounds(117, 67, 130, 27);
		panel.add(comboBox);
		
		startTime = new JTextField();
		startTime.setBounds(117, 106, 130, 26);
		panel.add(startTime);
		startTime.setColumns(10);
		
		endTime = new JTextField();
		endTime.setBounds(117, 142, 130, 26);
		panel.add(endTime);
		endTime.setColumns(10);
		
		price = new JTextField();
		price.setBounds(117, 176, 130, 26);
		panel.add(price);
		price.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Select");
		lblNewLabel.setBounds(29, 71, 61, 16);
		panel.add(lblNewLabel);
		
		JLabel lblStartTime = new JLabel("Start Time");
		lblStartTime.setBounds(29, 111, 64, 16);
		panel.add(lblStartTime);
		
		JLabel lblEndTime = new JLabel("End Time");
		lblEndTime.setBounds(29, 147, 61, 16);
		panel.add(lblEndTime);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(29, 181, 61, 16);
		panel.add(lblPrice);
		/**
		 * This button for creating a new schedule for corresponding course and times.
		 * Checks all situations.
		 */
		JButton teachButton = new JButton("Teach");
		teachButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String SelectedCourseName = (String)comboBox.getSelectedItem();
				Course course = null;
				for (Course c : Main.courseList) {
					if (c.getName().equals(SelectedCourseName)) course = c;
				}
			
				try {
					LocalTime sTime = LocalTime.parse(startTime.getText());
					LocalTime eTime = LocalTime.parse(endTime.getText());

					LocalTime controlStart;
					LocalTime controlEnd;
					boolean isTimeValid = true;
					for (Schedule sc: activeTutor.getSchedules()) {
						controlStart= sc.getStartTime();
						controlEnd= sc.getEndTime();
						isTimeValid = isTimeValid && sc.isInRange(sTime,eTime, controlStart, controlEnd);
					}
					
					if (isTimeValid) {
						long duration = sTime.until(eTime, ChronoUnit.SECONDS);
						if(duration <= 3600) {
							Schedule sc = new Schedule(sTime,eTime);
							sc.setPrice(Double.parseDouble(price.getText()));
							activeTutor.addCourse(course, sc);
							activeTutor.getSchedules().add(sc);
							JOptionPane.showMessageDialog(null, "Success.",
						               "Message", JOptionPane.ERROR_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(null, "You can give a course maximum 1 hour. Please check start and end times.",
						               "Message", JOptionPane.ERROR_MESSAGE);
						}
						
					}
					else {
						JOptionPane.showMessageDialog(null, "You have another course section in that time range.",
					               "Message", JOptionPane.ERROR_MESSAGE);
					}
				}
				catch(DateTimeParseException p){
					JOptionPane.showMessageDialog(null, "Please write the times with the format 'HH:MM:SS, e.g. 09:00:00'",
				               "Message", JOptionPane.ERROR_MESSAGE);
				}
				
				

				
			}
		});
		teachButton.setBounds(74, 220, 117, 29);
		panel.add(teachButton);
		
		JButton signOutButton = new JButton("Sign Out");
		signOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				StartPage startPage = new StartPage();
				startPage.setVisible(true);
			}
		});
		signOutButton.setBounds(879, 36, 117, 29);
		contentPane.add(signOutButton);
		
		JButton btnNewButton = new JButton("My Profile");
		btnNewButton.setBounds(58, 37, 105, 27);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TutorProfile p  = new TutorProfile();
				p.setVisible(true);
			}
		});
		
		JButton btnMyCourses = new JButton("My Courses");
		btnMyCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TutorCourses t  = new TutorCourses();
				t.setVisible(true);
			}
		});
		btnMyCourses.setBounds(58, 72, 105, 27);
		contentPane.add(btnMyCourses);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome");
		lblNewLabel_1.setBounds(320, 67, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel userNameLabel = new JLabel(Main.activeUser.getUserName());
		userNameLabel.setBounds(403, 67, 73, 16);
		contentPane.add(userNameLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Your Balance");
		lblNewLabel_2.setBounds(874, 96, 80, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel balance = new JLabel(Double.toString(activeTutor.getBalance()));
		balance.setBounds(964, 96, 61, 16);
		contentPane.add(balance);
	}
}
