package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import app.Main;
import app.Tutor;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminIncomePage extends JFrame {
	/**
	 * Admin can show the all tutors incomes with this page.
	 */

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public AdminIncomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 1050, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		String [] col = {"Name","Income"};
		DefaultTableModel model = new DefaultTableModel(col,0);
		JTable table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(144, 109, 652, 522);
		contentPane.add(scrollPane);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AdminPage a = new AdminPage();
				a.setVisible(true);
			}
		});
		backButton.setBounds(6, 21, 117, 29);
		contentPane.add(backButton);
		
		for (Tutor tutor : Main.tutorList) {
			String name = tutor.getName();
			double balance = tutor.getBalance();
			String bln = Double.toString(balance);
			Object [] row = {name,bln};
			model.addRow(row);
		}
	}

}
