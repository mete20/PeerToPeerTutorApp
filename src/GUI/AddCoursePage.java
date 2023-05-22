package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.AdvancedCourse;
import app.BeginnerCourse;
import app.Course;
import app.Equipment;
import app.Main;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class AddCoursePage extends JFrame {
	/**
	 * Admin can create a course with this page.
	 */

	private JPanel contentPane;
	private JTextField courseName;
	private List <Equipment> equipments = new ArrayList<>();
	private List <Course> pres = new ArrayList<>();
	

	/**
	 * Create the frame.
	 */
	public AddCoursePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 1050, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel courseNameLabel = new JLabel("Course Name");
		courseNameLabel.setBounds(244, 198, 84, 16);
		contentPane.add(courseNameLabel);
		
		JLabel courseLevelLabel = new JLabel("Level");
		courseLevelLabel.setBounds(244, 235, 32, 16);
		contentPane.add(courseLevelLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Prerequisities");
		lblNewLabel_2.setBounds(244, 275, 85, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Required Equipments");
		lblNewLabel_3.setBounds(244, 320, 133, 16);
		contentPane.add(lblNewLabel_3);
		
		courseName = new JTextField();
		courseName.setBounds(379, 193, 130, 26);
		contentPane.add(courseName);
		courseName.setColumns(10);
		
		String [] str = {"Beginner", "Advanced"};
		JComboBox levelComboBox = new JComboBox(str);
		levelComboBox.setBounds(379, 231, 130, 27);
		contentPane.add(levelComboBox);
		
		
		JComboBox preComboBox = new JComboBox();
		preComboBox.setBounds(379, 271, 130, 27);
		contentPane.add(preComboBox);
		for (Course c : Main.courseList) {
			String name = c.getName();
			preComboBox.addItem(name);
		}
		
		JComboBox equipmentComboBox = new JComboBox();
		equipmentComboBox.setBounds(379, 316, 130, 27);
		contentPane.add(equipmentComboBox);
		for (Equipment e : Main.equipmentList) {
			String n = e.getName();
			equipmentComboBox.addItem(n);
		}
		
		JButton addPre = new JButton("Add");
		addPre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = preComboBox.getSelectedItem().toString();
				for ( Course c : Main.courseList) {
					if (c.getName().equals(name)) {
						pres.add(c);
					}
				}
			}
		});
		addPre.setBounds(521, 270, 117, 29);
		contentPane.add(addPre);
		
		JButton addEquipment = new JButton("Add");
		addEquipment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = equipmentComboBox.getSelectedItem().toString();
				for ( Equipment eq : Main.equipmentList) {
					if ( eq.getName().equals(name)) {
						equipments.add(eq);
					}
				}
			}
		});
		addEquipment.setBounds(521, 315, 117, 29);
		contentPane.add(addEquipment);
		
		JButton createButton = new JButton("Create");
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (courseName.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "You must write the course name. ",
				               "Message", JOptionPane.ERROR_MESSAGE);
				}
				else {
					String name = courseName.getText();
					if (levelComboBox.getSelectedItem().toString().equals("Beginner")) {
						for(Course c : pres) {
							if (c instanceof AdvancedCourse) {
								JOptionPane.showMessageDialog(null, "Beginner courses cannot have a Advanced course as a prerequisite ",
							               "Message", JOptionPane.ERROR_MESSAGE);
							}
							
						}
						
						Course course = new BeginnerCourse(name);
						Main.beginnerCourseList.add(course);
						Main.courseList.add(course);
						course.setPrerequisites(pres);
						course.setEquipmentRequirements(equipments);
						
						
					}
					else {
						Course course = new BeginnerCourse(name);
						Main.advancedCourseList.add(course);
						Main.courseList.add(course);
						course.setPrerequisites(pres);
						course.setEquipmentRequirements(equipments);
						
					}
					JOptionPane.showMessageDialog(null, "Success",
				               "Message", JOptionPane.WARNING_MESSAGE);
				}
				
				
			}
		});
		createButton.setBounds(345, 381, 117, 29);
		contentPane.add(createButton);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AdminPage a = new AdminPage();
				a.setVisible(true);
				
			}
		});
		backButton.setBounds(6, 49, 117, 29);
		contentPane.add(backButton);
		
		
		
	}
}
