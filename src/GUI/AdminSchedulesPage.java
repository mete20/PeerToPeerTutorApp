package GUI;

import java.awt.EventQueue;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import app.BeginnerCourse;
import app.Course;
import app.Main;
import app.Schedule;
import app.Student;
import app.Tutor;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class AdminSchedulesPage extends JFrame {

	private JPanel contentPane;
	private static final DecimalFormat df = new DecimalFormat("0.00");
	public static List <Object []> objs = new ArrayList<>();
	public static Student currentStudent;
	

	/**
	 * Create the frame.
	 */
	public AdminSchedulesPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 1050, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String col[] = {"Course","Tutor","Price","Level","Start Time","End Time","Status"};
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		JTable table = new JTable(tableModel);	
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(41, 101, 642, 537);
		contentPane.add(scrollPane);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AdminPage a = new AdminPage();
				a.setVisible(true);
			}
		});
		backButton.setBounds(6, 18, 117, 29);
		contentPane.add(backButton);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(717, 137, 61, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(717, 165, 61, 16);
		contentPane.add(lblStatus);
		
		JLabel stName = new JLabel("New label");
		stName.setBounds(803, 137, 61, 16);
		contentPane.add(stName);
		
		JLabel stStatus = new JLabel("New label");
		stStatus.setBounds(803, 165, 61, 16);
		contentPane.add(stStatus);
		
		JButton getButton = new JButton("Get Registered Student Info");
		getButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				
				if (row>= 0) {
					String courseName = (String) tableModel.getValueAt(row, 0);
					String startTime = (String) tableModel.getValueAt(row, 4);
					String endTime = (String) tableModel.getValueAt(row, 5);
					String tutorname = (String) tableModel.getValueAt(row, 1);
					for(Tutor tutor : Main.tutorList) {
						if(tutor.getName().equals(tutorname)) {
							for(Schedule sch : tutor.getCourses().keySet()) {
								if(tutor.getCourses().get(sch).getName().equals(courseName)) {
									if(sch.getStartTime().toString().equals(startTime) && sch.getEndTime().toString().equals(endTime)) {
										Student st = sch.getRegisteredStudents().get(0);
										currentStudent = st;
										stName.setText(st.getName());
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
										stStatus.setText(stat);
										
										
									}
								}
								
							}
							
						}
					}
				
				}
			}
		});
		getButton.setBounds(740, 97, 241, 29);
		contentPane.add(getButton);
		
		JButton passButton = new JButton("Pass");
		passButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				
				if (row>= 0) {
					String courseName = (String) tableModel.getValueAt(row, 0);
					String startTime = (String) tableModel.getValueAt(row, 4);
					String endTime = (String) tableModel.getValueAt(row, 5);
					String tutorname = (String) tableModel.getValueAt(row, 1);
					
					for(Tutor tutor : Main.tutorList) {
						if(tutor.getName().equals(tutorname)) {
							for(Schedule sch : tutor.getCourses().keySet()) {
								if(tutor.getCourses().get(sch).getName().equals(courseName)) {
									if(sch.getStartTime().toString().equals(startTime) && sch.getEndTime().toString().equals(endTime)) {
										Student st = sch.getRegisteredStudents().get(0);
										for (Course course : st.getCourseHistory().keySet()) {
											st.getRegisteredCourses().remove(course);
											st.getPassedCourses().add(course);
											stStatus.setText("Passed");
										}
										
										
									}
								}
								
							}
							
						}
					}
				}
			}
		});
		passButton.setBounds(891, 132, 117, 29);
		contentPane.add(passButton);
		
		JButton failButton = new JButton("Fail");
		failButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				
				if (row>= 0) {
					String courseName = (String) tableModel.getValueAt(row, 0);
					String startTime = (String) tableModel.getValueAt(row, 4);
					String endTime = (String) tableModel.getValueAt(row, 5);
					String tutorname = (String) tableModel.getValueAt(row, 1);
					
					for(Tutor tutor : Main.tutorList) {
						if(tutor.getName().equals(tutorname)) {
							for(Schedule sch : tutor.getCourses().keySet()) {
								if(tutor.getCourses().get(sch).getName().equals(courseName)) {
									if(sch.getStartTime().toString().equals(startTime) && sch.getEndTime().toString().equals(endTime)) {
										Student st = sch.getRegisteredStudents().get(0);
										for (Course course : st.getCourseHistory().keySet()) {
											st.getRegisteredCourses().remove(course);
											if (st.getPassedCourses().contains(course)) st.getPassedCourses().remove(course);
											stStatus.setText("Failed");
										}
										
										
									}
								}
								
							}
							
						}
					}
				}
			}
		});
		failButton.setBounds(891, 160, 117, 29);
		contentPane.add(failButton);
		
		JButton displayButton = new JButton("Display Student Course History");
		displayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AdminStudentHistory a = new AdminStudentHistory();
				a.setVisible(true);
			}
		});
		displayButton.setBounds(740, 193, 241, 29);
		contentPane.add(displayButton);
		
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
		
		for (Object[] obj: objs) tableModel.addRow(obj);
		
		
	}

}
