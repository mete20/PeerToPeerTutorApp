package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import app.Course;
import app.Main;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminProfitPage extends JFrame {
	/**
	 * Admin can show the courses profits with this page.
	 */
	private JPanel contentPane;
	
	

	/**
	 * Create the frame.
	 */
	public AdminProfitPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 1050, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String [] col = {"Course Name", "Profit"};
		DefaultTableModel model = new DefaultTableModel(col,0);
		JTable table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(159, 122, 656, 487);
		contentPane.add(scrollPane);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AdminPage a = new AdminPage();
				a.setVisible(true);
			}
		});
		backButton.setBounds(6, 34, 117, 29);
		contentPane.add(backButton);
		
		for (Course c : Main.courseList) {
			String courseName = c.getName();
			double profit = c.getProfit();
			String stProfit = Double.toString(profit);
			Object [] row = {courseName,profit};
			model.addRow(row);
		}
	}

}
