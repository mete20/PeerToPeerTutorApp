package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import app.Course;
import app.Main;
import app.Student;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AdminRegisteredStudentsPage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private List<Object[]> rows = new ArrayList<>();

	/**
	 * Create the frame.
	 */
	public AdminRegisteredStudentsPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 1050, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox courseComboBox = new JComboBox();
		courseComboBox.setBounds(66, 120, 130, 27);
		contentPane.add(courseComboBox);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AdminPage a = new AdminPage();
				a.setVisible(true);
			}
		});
		backButton.setBounds(6, 6, 117, 29);
		contentPane.add(backButton);
		
		String [] col = {"Name","User Name", "Age", "TCKN"};
		DefaultTableModel tableModel = new DefaultTableModel(col,0);
		table = new JTable(tableModel);
		table.setAutoCreateRowSorter(true);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(101, 183, 729, 461);
		contentPane.add(scrollPane);
		
		JButton getButton = new JButton("Get");
		getButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rows = new ArrayList<>();
				for ( Course c : Main.courseList) {
					if(c.getName().equals(courseComboBox.getSelectedItem().toString())) {
						for (Student st : c.getStudents()) {
							String name = st.getName();
							String userName = st.getUserName();
							String age = st.getAge();
							String tckn = st.getTCKN();
							Object[] row = {name,userName,age,tckn};
							rows.add(row);
						}
					}
				}
				for (Object [] o : rows) tableModel.addRow(o);
			}
		});
		getButton.setBounds(219, 119, 117, 29);
		contentPane.add(getButton);
		
		
		
		
		
		
		for (Course c: Main.courseList) {
			String courseName = c.getName();
			courseComboBox.addItem(courseName);
		}
	}
}
