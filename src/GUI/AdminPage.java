package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminPage extends JFrame {
	/**
	 * This page is the Admin home page.
	 */

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public AdminPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 1050, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CONTROL PANEL");
		lblNewLabel.setBounds(472, 30, 106, 16);
		contentPane.add(lblNewLabel);
		
		JButton addCourse = new JButton("Add Course");
		addCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AddCoursePage a = new AddCoursePage();
				a.setVisible(true);
				
			}
		});
		addCourse.setBounds(230, 227, 117, 29);
		contentPane.add(addCourse);
		
		JButton profitButton = new JButton("Profit");
		profitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AdminProfitPage a = new AdminProfitPage();
				a.setVisible(true);
			}
		});
		profitButton.setBounds(696, 227, 117, 29);
		contentPane.add(profitButton);
		
		JButton schedulesButton = new JButton("Schedules");
		schedulesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AdminSchedulesPage a = new AdminSchedulesPage();
				a.setVisible(true);
			}
		});
		schedulesButton.setBounds(230, 460, 117, 29);
		contentPane.add(schedulesButton);
		
		JButton incomesButton = new JButton("Incomes");
		incomesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AdminIncomePage a = new AdminIncomePage();
				a.setVisible(true);
			}
		});
		incomesButton.setBounds(696, 460, 117, 29);
		contentPane.add(incomesButton);
		
		JButton registeredStudentsButton = new JButton("Registered Students");
		registeredStudentsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AdminRegisteredStudentsPage a = new AdminRegisteredStudentsPage();
				a.setVisible(true);
			}
		});
		registeredStudentsButton.setBounds(440, 346, 169, 29);
		contentPane.add(registeredStudentsButton);
		
		JButton signOutButton = new JButton("Sign Out");
		signOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				StartPage st = new StartPage();
				st.setVisible(true);
			}
		});
		signOutButton.setBounds(6, 6, 117, 29);
		contentPane.add(signOutButton);
	}

}
