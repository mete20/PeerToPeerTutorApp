package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import app.Equipment;

public class Student_Profile extends JFrame {
	/**
	 * This page is to show the users informations, and user can update his/her information
	 */

	private JPanel contentPane;
	public static Map<String, Integer> equipments = new HashMap<>();
	private JTextField name;
	private JTextField age;
	private JTextField tckn;
	private JTextField userName;
	private JTextField password;

	

	/**
	 * Create the frame.
	 */
	public Student_Profile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 1050, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		String col[] = {"Name","Number"};
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		contentPane.setLayout(null);
		JTable table = new JTable(tableModel);	
		table.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		table.setAutoCreateRowSorter(true);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(707, 138, 256, 466);
		contentPane.add(scrollPane);

		for (Equipment e :StudentPage.activeStudent.getEquipments()) {
			String name = e.getName();
			if (equipments.containsKey(name)) {
				equipments.replace(name, equipments.get(name) + 1);
			}
			else {
				equipments.put(name, 1);
			}
		}
		
		for (String s : equipments.keySet()) {
			String name = s;
			int number = equipments.get(s);
			String strNumber = Integer.toString(number);
			Object [] obj = {name,strNumber};
			tableModel.addRow(obj);
		}
		
		
		JButton backButton = new JButton("Back");
		backButton.setBounds(43, 45, 117, 29);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				StudentPage st = new StudentPage();
				st.setVisible(true);
			}
		});
		contentPane.add(backButton);
		
		JLabel lblNewLabel = new JLabel("EQUIPMENTS");
		lblNewLabel.setBounds(793, 110, 80, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(109, 443, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Age");
		lblNewLabel_1_1.setBounds(109, 471, 61, 16);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("TCKN");
		lblNewLabel_1_2.setBounds(109, 499, 61, 16);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Username");
		lblNewLabel_1_3.setBounds(109, 530, 62, 16);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Password");
		lblNewLabel_1_4.setBounds(109, 560, 61, 16);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel picture = new JLabel(StudentPage.activeStudent.getPortraitPhoto());
		picture.setText("picture");
		picture.setBackground(new Color(238, 238, 238));
		picture.setBounds(99, 151, 170, 170);
		
		contentPane.add(picture);
		
		JButton btnNewButton = new JButton("Upload");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				int response = fc.showOpenDialog(null);
				if(response ==JFileChooser.APPROVE_OPTION) {
					ImageIcon image = new ImageIcon(fc.getSelectedFile().getAbsolutePath());
					StudentPage.activeStudent.setPortraitPhoto(image);
					picture.setIcon(image);
					
				}
			}
		});
		
		btnNewButton.setBounds(129, 333, 117, 29);
		contentPane.add(btnNewButton);
		
		name = new JTextField();
		name.setBounds(192, 438, 130, 26);
		contentPane.add(name);
		name.setColumns(10);
		name.setText(StudentPage.activeStudent.getName());
		
		
		age = new JTextField();
		age.setColumns(10);
		age.setBounds(192, 466, 130, 26);
		contentPane.add(age);
		age.setText(StudentPage.activeStudent.getAge());
		
		tckn = new JTextField();
		tckn.setColumns(10);
		tckn.setBounds(192, 494, 130, 26);
		contentPane.add(tckn);
		tckn.setText(StudentPage.activeStudent.getTCKN());
		
		userName = new JTextField();
		userName.setColumns(10);
		userName.setBounds(192, 525, 130, 26);
		contentPane.add(userName);
		userName.setText(StudentPage.activeStudent.getUserName());
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(192, 555, 130, 26);
		contentPane.add(password);
		password.setText(StudentPage.activeStudent.getPassword());
		/**
		 * This button updates the users informations.
		 */
		JButton updateButton = new JButton("Update Profile");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newName = name.getText();
				String newAge = age.getText();
				String newTCKN = tckn.getText();
				String newUserName = userName.getText();
				String newPassword = password.getText();
				
				StudentPage.activeStudent.setName(newName);
				StudentPage.activeStudent.setAge(newAge);;
				StudentPage.activeStudent.setTCKN(newTCKN);
				StudentPage.activeStudent.setUserName(newUserName);
				StudentPage.activeStudent.setPassword(newPassword);
				
				JOptionPane.showMessageDialog(null, "Your profile is successfully updated.",
			               "Message", JOptionPane.WARNING_MESSAGE);
			}
		});
		updateButton.setBounds(152, 593, 117, 29);
		contentPane.add(updateButton);
		
		
	}
}
