package GUI;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import app.Equipment;
import app.Main;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Market extends JFrame {
	/**
	 * This Page provides students to buy equipments.
	 */

	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public Market() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 1050, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		String col[] = {"Name","Price"};
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		contentPane.setLayout(null);
		JTable table = new JTable(tableModel);	
		table.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		table.setAutoCreateRowSorter(true);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(203, 146, 586, 466);
		contentPane.add(scrollPane);
		
		
		for (Equipment e :Main.equipmentList) {
			String name = e.getName();
			String price = Integer.toString(e.getPrice()) + "$";
			Object [] obj = {name,price};
			tableModel.addRow(obj);
		}
		
		JLabel balanceLabel = new JLabel("Your balance: ");
		balanceLabel.setBounds(775, 61, 89, 16);
		contentPane.add(balanceLabel);
		
		JLabel balance = new JLabel("");
		balance.setBounds(879, 61, 61, 16);
		contentPane.add(balance);
		balance.setText(Double.toString(StudentPage.activeStudent.getBalance()) + "$");
		/**
		 * This button to buy a equipment.
		 */
		JButton purchaseButton = new JButton("PURCHASE");
		purchaseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				
				if (row >= 0) {
					String price = table.getModel().getValueAt(row, 1).toString();
					String name = table.getModel().getValueAt(row, 0).toString();
					String p = price.substring(0, price.length()-1);
					double doublePrice = Double.parseDouble(p);
					StudentPage.activeStudent.setBalance(StudentPage.activeStudent.getBalance() - doublePrice);
					balance.setText(Double.toString(StudentPage.activeStudent.getBalance()) + "$");
					
					for (Equipment e1 : Main.equipmentList ) {
						if (name.equals(e1.getName())) {
							StudentPage.activeStudent.getEquipments().add(e1);
						}
						
					}
				}
				
			}
		});
		purchaseButton.setBounds(823, 155, 117, 29);
		contentPane.add(purchaseButton);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				StudentPage st = new StudentPage();
				st.setVisible(true);
			}
		});
		backButton.setBounds(43, 45, 117, 29);
		contentPane.add(backButton);
		
		
	}
}
