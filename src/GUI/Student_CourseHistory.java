package GUI;

import java.awt.EventQueue;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import app.Course;
import app.Schedule;
import app.Tutor;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Student_CourseHistory extends JFrame {
	/**
	 * This page shows the all courses which students pass, fail, or proggress.
	 */

	private JPanel contentPane;
	private JTable table;
	private JButton backButton;

	

	/**
	 * Create the frame.
	 */
	public Student_CourseHistory() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 1050, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		/**
		 * This table shows the lessons inforamations
		 */
		String col[] = {"Course","Tutor","Status"};
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		table = new JTable(tableModel);
		table.setBounds(161, 165, 723, 536);
		contentPane.add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(240, 127, 570, 533);
		contentPane.add(scrollPane);
		
		backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				StudentPage st = new StudentPage();
				st.setVisible(true);
				
			}
		});
		backButton.setBounds(10, 12, 117, 29);
		contentPane.add(backButton);
		/**
		 * Filling the table
		 */
		Map<Course, Tutor> newMap = StudentPage.activeStudent.getCourseHistory();
		for (Course c: newMap.keySet()) {
			String courseName = c.getName();
			String tutorName = newMap.get(c).getName();
			String status;
			
			if (StudentPage.activeStudent.getPassedCourses().contains(c)) {
				status = "Passed";
				
			}
			else if (StudentPage.activeStudent.getRegisteredCourses().containsKey(c)) {
				status = "Progress";
			}
			
			else {
				status = "Failed";
			}
			Object [] objs = {courseName,tutorName,status};
			tableModel.addRow(objs);
		}
		
		
	}
}
