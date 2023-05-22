package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import app.ALevelTutor;
import app.BLevelTutor;
import app.Main;
import app.Student;
import app.Tutor;
import app.User;

public class Register extends JFrame {
	/**
	 * This is the Register page which contains two panels(image contains panel, and other things contains panel)
	 * 
	 */
	private JPanel contentPane;
	private JTextField userName;
	private JTextField pass;
	private boolean isTutor; // to check the user is tutor or student.
	private JTextField nameInput;
	private JTextField ageInput;
	private JTextField tcknInput;
	ImageIcon image;
	
	

	/**
	 * Create the frame.
	 */
	public Register() {
		setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// creting the panel
		JPanel panel = new JPanel();
		panel.setBackground(new Color(238, 238, 238));
		panel.setBounds(296, 0, 404, 472);
		contentPane.add(panel);
		panel.setLayout(null);
		
		/**
		 * JTextFields to get input from user
		 */
		userName = new JTextField();
		userName.setBounds(145, 293, 223, 26);
		panel.add(userName);
		userName.setFont(new Font("Dialog", Font.PLAIN, 13));
		userName.setColumns(10);
		
		pass = new JTextField();
		pass.setBounds(145, 331, 223, 26);
		panel.add(pass);
		pass.setFont(new Font("Dialog", Font.PLAIN, 13));
		pass.setColumns(10);
		
		nameInput = new JTextField();
		nameInput.setBounds(145, 150, 220, 26);
		panel.add(nameInput);
		nameInput.setFont(new Font("Dialog", Font.PLAIN, 13));
		nameInput.setColumns(10);
		
		ageInput = new JTextField();
		ageInput.setBounds(145, 188, 221, 26);
		panel.add(ageInput);
		ageInput.setFont(new Font("Dialog", Font.PLAIN, 13));
		ageInput.setColumns(10);
		
		tcknInput = new JTextField();
		tcknInput.setBounds(145, 259, 223, 26);
		panel.add(tcknInput);
		tcknInput.setFont(new Font("Dialog", Font.PLAIN, 13));
		tcknInput.setColumns(10);
		
		/**
		 * JLabels to show corresponding texts
		 */
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(60, 302, 62, 16);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(63, 337, 59, 16);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblNewLabel_2 = new JLabel("Member Type");
		lblNewLabel_2.setBounds(38, 88, 84, 16);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		
		
		JLabel level_label = new JLabel("Level");
		level_label.setBounds(90, 114, 32, 16);
		panel.add(level_label);
		level_label.setFont(new Font("Dialog", Font.PLAIN, 13));
		level_label.setHorizontalAlignment(SwingConstants.LEFT);
		
		
		
		JLabel lblNewLabel_3 = new JLabel("Profile Picture");
		lblNewLabel_3.setBounds(35, 233, 87, 16);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Dialog", Font.PLAIN, 13));
		
		JLabel lblNewLabel_4 = new JLabel("Name");
		lblNewLabel_4.setBounds(86, 154, 36, 16);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Dialog", Font.PLAIN, 13));
		
		JLabel lblNewLabel_6 = new JLabel("Age");
		lblNewLabel_6.setBounds(98, 193, 24, 16);
		panel.add(lblNewLabel_6);
		lblNewLabel_6.setFont(new Font("Dialog", Font.PLAIN, 13));
		
		JLabel lblNewLabel_7 = new JLabel("TCKN");
		lblNewLabel_7.setBounds(87, 268, 35, 16);
		panel.add(lblNewLabel_7);
		lblNewLabel_7.setFont(new Font("Dialog", Font.PLAIN, 13));
		
		/**
		 * This is a comboBox which provides tutors to select their levels.
		 */
		String str[] = {"A Level", "B Level"};
		JComboBox TutorLevel = new JComboBox(str);
		TutorLevel.setBounds(145, 111, 223, 26);
		panel.add(TutorLevel);
		TutorLevel.setFont(new Font("Dialog", Font.PLAIN, 13));
		/**
		 * level_label and Tutorlevel are not visible first when memberType is selected as Tutor they are getting visible.
		 */
		level_label.setVisible(false);
		TutorLevel.setVisible(false);
		
		/**
		 * This is a comboBox which provides user to select the member type.
		 */
		String s[] = {"Student", "Tutor"};
		JComboBox memberType = new JComboBox(s);
		/**
		 * This itemStateChange method is checking the selected item of the memberType comboBox and if it is tutor make isTutor = true, otherwise false;
		 */
		memberType.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				if (((String)memberType.getSelectedItem()).equals("Tutor")) {
					
					isTutor = true;
					TutorLevel.setVisible(true);
					level_label.setVisible(true);
					
					
					}
				else {
					isTutor = false;
					TutorLevel.setVisible(false);
					level_label.setVisible(false);
					
				}
				
				
			}
		});
		memberType.setBounds(145, 83, 223, 26);
		panel.add(memberType);
		memberType.setFont(new Font("Dialog", Font.PLAIN, 13));
		
		

		/**
		 * This is upload button to select a file which is a profile picture of user from file system.
		 */
		JButton uploadButton = new JButton("Upload");
		uploadButton.setBounds(145, 226, 221, 26);
		panel.add(uploadButton);
		uploadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fc = new JFileChooser();
				int response = fc.showOpenDialog(null);
				if(response ==JFileChooser.APPROVE_OPTION) {
					image = new ImageIcon(fc.getSelectedFile().getAbsolutePath());
					
				}
			}
		});
		uploadButton.setFont(new Font("Dialog", Font.PLAIN, 13));
		
		/**
		 * This is the register button.
		 * It gets the inputs and and check corresponding information and create the user with these information and add it to corresponding list
		 */
		JButton registerButton = new JButton("Register");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Random random = new Random();
				// get the inputs
				String name = nameInput.getText();
			    String age = ageInput.getText();
			    String tckn = tcknInput.getText();
				String userNameInput = userName.getText();
			    String passwordInput = pass.getText();
			    
			    // check this user name is taken by another user or not
			    boolean valid = true;
			    for (User user : Main.userList) {
			    	if (userNameInput.equals(user.getUserName())) {
			    		valid = false;
			    		JOptionPane.showMessageDialog(null, "This username is taken. Please try again.",
					               "Message", JOptionPane.ERROR_MESSAGE);
			    	}
			    	
			    }
				if (valid) {
					/**
					 *  If member type is tutor it creates a tutor(A or B Level), make activeUser this tutor, and opens the tutorPage;
					 *  otherwise it creates a student, make activeUser this student and opens the StudentPage
					 */
					if (isTutor) {
						// It checks tutorLevel, if it is A level creates A Level tutor and add it to the list, otherwise creates B level and add it to the list
						if (TutorLevel.getSelectedItem().equals("A Level")) {
							Tutor tutor = new ALevelTutor(name,tckn,age,image,0,userNameInput,passwordInput);
							
							Main.userList.add(tutor);
							Main.tutorList.add(tutor);
							Main.activeUser = tutor;
						}
						else {
							Tutor tutor = new BLevelTutor(name,tckn,age,image,0,userNameInput,passwordInput);
							Main.userList.add(tutor);
							Main.tutorList.add(tutor);
							Main.activeUser = tutor;
						}
						
						setVisible(false);
						
						TutorPage tutorPage = new TutorPage();
						
						tutorPage.setVisible(true);
					}
					else {
						
						Student student = new Student(name,tckn,age,image,random.nextDouble(2000,5000),userNameInput,passwordInput);
						Main.userList.add(student);
						Main.studentList.add(student);
						Main.activeUser= student;
						StudentPage.activeStudent = student;
						setVisible(false);
						StudentPage studentPage = new StudentPage();
						studentPage.setVisible(true);
						
					}
				}
				
			}
		});
		registerButton.setBounds(148, 389, 108, 29);
		registerButton.setForeground(new Color(86, 83, 84));
		getRootPane().setDefaultButton(registerButton);
		panel.add(registerButton);
		registerButton.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		
		
		/**
		 * This button to turn back to the startPage.
		 */
		JButton backButton = new JButton("Back");
		backButton.setBounds(323, 6, 75, 29);
		backButton.setForeground(new Color(86, 83, 84));
		panel.add(backButton);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				StartPage startPage = new StartPage();
				startPage.setVisible(true);
				
			}
		});
		
		
		// creating the other panel which contains a image of KOÇ University view.
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 297, 472);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		// the label which has an ImageIcon
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon(Register.class.getResource("/img/kocBg_2.png")));
		lblNewLabel_5.setBounds(0, 0, 297, 472);
		panel_1.add(lblNewLabel_5);
	
		
		
		

		
		
		
		
	}
}
