package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import app.Course;
import app.Student;
import app.Tutor;
import javax.swing.JLabel;

public class AdminStudentHistory extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton backButton;
	private Student student;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;


	/**
	 * Create the frame.
	 */
	public AdminStudentHistory() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 1050, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
				AdminSchedulesPage a = new AdminSchedulesPage();
				a.setVisible(true);
				
			}
		});
		backButton.setBounds(10, 12, 117, 29);
		contentPane.add(backButton);
		
		lblNewLabel = new JLabel("Course History of");
		lblNewLabel.setBounds(313, 63, 111, 16);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(441, 63, 61, 16);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setText(AdminSchedulesPage.currentStudent.getName());
		
		
		
		Map<Course, Tutor> newMap = AdminSchedulesPage.currentStudent.getCourseHistory();
		for (Course c: newMap.keySet()) {
			String courseName = c.getName();
			String tutorName = newMap.get(c).getName();
			String status;
			
			if (AdminSchedulesPage.currentStudent.getPassedCourses().contains(c)) {
				status = "Passed";
				
			}
			else if (AdminSchedulesPage.currentStudent.getRegisteredCourses().containsKey(c)) {
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
