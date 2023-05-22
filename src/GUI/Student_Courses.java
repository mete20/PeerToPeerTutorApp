package GUI;

import java.awt.EventQueue;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import app.BeginnerCourse;
import app.Course;
import app.Main;
import app.Schedule;
import app.Student;
import app.Tutor;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Student_Courses extends JFrame {
	/**
	 * This Page shows the current lessons of the students with the necessary information.
	 */

	private JPanel contentPane;
	private JTable table;

	

	/**
	 * Create the frame.
	 */
	public Student_Courses() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 1050, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		/**
		 * This JTable shows the all current lessons.
		 */
		String col[] = {"Name","Tutor","Level","Start Time","End Time"};
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		JTable table = new JTable(tableModel);
		String courseName="";
		String tutorName="";
		String level="";
		String startTime="";
		String endTime="";
		
		Map<Course, HashMap<Tutor, Schedule>> map = StudentPage.activeStudent.getRegisteredCourses();
		
		for (Course course : map.keySet()) {
			HashMap<Tutor,Schedule> map1 = map.get(course);
			courseName = course.getName();
			if (course instanceof BeginnerCourse) {
				level = "Beginner";
			}
			else {
				level = "Advanced";
			}
			for (Tutor tutor: map1.keySet()) {
				tutorName = tutor.getName();
				Schedule sc = map1.get(tutor);
				startTime = sc.getStartTime().toString();
				endTime = sc.getEndTime().toString();
					
			}
			Object [] objs = {courseName,tutorName,level,startTime,endTime};
			tableModel.addRow(objs);
		}
		
		Object [] objs = {courseName,tutorName,level,startTime,endTime};

		table.setBounds(201, 144, 637, 516);
		contentPane.add(table);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(240, 127, 570, 533);
		contentPane.add(scrollPane);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				StudentPage st = new StudentPage();
				st.setVisible(true);
			}
		});
		backButton.setBounds(27, 12, 117, 29);
		contentPane.add(backButton);
	}

}
