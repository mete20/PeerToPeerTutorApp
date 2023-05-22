package GUI;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import app.Course;
import app.Schedule;
import app.Student;

import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

public class TutorCourses extends JFrame {
	/*
	 * This Page shows all schedules of the tutor and tutor can select e lesson and can get the registered student information and can change the student's status (pass,fail)
	 */
	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public TutorCourses() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 1050, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/**
		 * This JTable shows the all lessons of this tutors
		 */
		String [] col = {"Name","Start Time", "End Time","Price"};
		DefaultTableModel tableModel = new DefaultTableModel(col,0);
		JTable table = new JTable(tableModel);
		table.setBounds(116, 145, 186, 419);
		contentPane.add(table);
		
		// filling the table
		for (Schedule sc : TutorPage.activeTutor.getCourses().keySet()) {
			Course c = TutorPage.activeTutor.getCourses().get(sc);
			String courseName = c.getName();
			String startTime = sc.getStartTime().toString();
			String endTime = sc.getEndTime().toString();
			String price = Double.toString(sc.getPrice());
			Object [] obj = {courseName,startTime,endTime,price};
			tableModel.addRow(obj);
		}
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(21, 144, 279, 419);
		contentPane.add(scrollPane);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TutorPage t = new TutorPage();
				t.setVisible(true);
			}
		});
		backButton.setBounds(21, 16, 117, 29);
		contentPane.add(backButton);
		
		JLabel lblNewLabel = new JLabel("Registered Student Information");
		lblNewLabel.setBounds(348, 145, 196, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setBounds(348, 214, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel name = new JLabel("New label");
		name.setBounds(436, 214, 61, 16);
		contentPane.add(name);
		
		JLabel lblNewLabel_1_1 = new JLabel("Status:");
		lblNewLabel_1_1.setBounds(348, 242, 61, 16);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel status = new JLabel("New label");
		status.setBounds(436, 242, 61, 16);
		contentPane.add(status);
		/**
		 * This button shows the information about the selected lessons registered students.
		 */
		JButton infoButton = new JButton("Get Info");
		infoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				
				if (row>= 0) {
					String courseName = (String) tableModel.getValueAt(row, 0);
					String startTime = (String) tableModel.getValueAt(row, 1);
					String endTime = (String) tableModel.getValueAt(row, 2);
					
					for(Schedule sch : TutorPage.activeTutor.getCourses().keySet()) {
						if(TutorPage.activeTutor.getCourses().get(sch).getName().equals(courseName)) {
							if(sch.getStartTime().toString().equals(startTime) && sch.getEndTime().toString().equals(endTime)) {
								Student st = sch.getRegisteredStudents().get(0);
								name.setText(st.getName());
								String stat = "";
								for (Course course : st.getCourseHistory().keySet()) {
									if (course.getName().equals(courseName)) {
										if(st.getPassedCourses().contains(course)) {
											stat = "Passed";
										}
										else if (st.getRegisteredCourses().containsKey(course)){
											stat = "Progress";
										}
										else {
											stat = "Failed";
										}
									}
								}
								status.setText(stat);
								
								
							}
						}
						
					}
				}
			}
		});
		infoButton.setBounds(380, 173, 117, 29);
		contentPane.add(infoButton);
		/**
		 * This button change the students status 
		 */
		JButton passButton = new JButton("Pass");
		passButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				
				if (row>= 0) {
					String courseName = (String) tableModel.getValueAt(row, 0);
					String startTime = (String) tableModel.getValueAt(row, 1);
					String endTime = (String) tableModel.getValueAt(row, 2);
					
					for(Schedule sch : TutorPage.activeTutor.getCourses().keySet()) {
						if(TutorPage.activeTutor.getCourses().get(sch).getName().equals(courseName)) {
							if(sch.getStartTime().toString().equals(startTime) && sch.getEndTime().toString().equals(endTime)) {
								Student st = sch.getRegisteredStudents().get(0);
								for (Course course : st.getCourseHistory().keySet()) {
									st.getRegisteredCourses().remove(course);
									st.getPassedCourses().add(course);
									status.setText("Passed");
								}

								
								
							}
						}
						
					}
				}
				
			}
		});
		passButton.setBounds(380, 279, 117, 29);
		contentPane.add(passButton);
		
		/**
		 * This button change the students status 
		 */
		JButton btnFail = new JButton("Fail");
		btnFail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				
				if (row>= 0) {
					String courseName = (String) tableModel.getValueAt(row, 0);
					String startTime = (String) tableModel.getValueAt(row, 1);
					String endTime = (String) tableModel.getValueAt(row, 2);
					
					for(Schedule sch : TutorPage.activeTutor.getCourses().keySet()) {
						if(TutorPage.activeTutor.getCourses().get(sch).getName().equals(courseName)) {
							if(sch.getStartTime().toString().equals(startTime) && sch.getEndTime().toString().equals(endTime)) {
								Student st = sch.getRegisteredStudents().get(0);
								for (Course course : st.getCourseHistory().keySet()) {
									st.getRegisteredCourses().remove(course);
									if (st.getPassedCourses().contains(course)) st.getPassedCourses().remove(course);
									status.setText("Failed");
								}

								
								
							}
						}
						
					}
				}
				
				
			}
		});
		btnFail.setBounds(380, 320, 117, 29);
		contentPane.add(btnFail);
		
	}
}
