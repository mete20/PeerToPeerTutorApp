package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import app.Main;
import app.Student;
import app.Tutor;
import app.User;
import javax.swing.JPasswordField;

public class Login {
	/**
	 * This is the Login Page
	 * It had two panels.
	 */

	protected JFrame frame;
	private JTextField userName;
	private JPasswordField pass;
	
	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		/**
		 * creating the frame
		 */
		frame = new JFrame();
		frame.setBounds(500, 200, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		/**
		 * Creating the Panel which contains labels, jTextFields and buttons
		 */
		JPanel panel = new JPanel();
		panel.setBounds(296, 0, 404, 472);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		/**
		 * Creating the labels to show texts
		 */
		JLabel lblNewLabel_1 = new JLabel("Welcome Back, ");
		lblNewLabel_1.setForeground(new Color(129, 129, 129));
		lblNewLabel_1.setBounds(89, 125, 97, 16);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Please login to your account.");
		lblNewLabel_2.setForeground(new Color(129, 129, 129));
		lblNewLabel_2.setBounds(89, 150, 182, 16);
		panel.add(lblNewLabel_2);
		
		JLabel username_label = new JLabel("Username");
		username_label.setBounds(89, 202, 93, 16);
		panel.add(username_label);
		
		JLabel pass_label = new JLabel("Password");
		pass_label.setBounds(89, 251, 93, 16);
		panel.add(pass_label);
			
		/**
		 * Creating the userName and pass JTextFields to get input from user
		 */
		
		userName = new JTextField();
		userName.setBounds(85, 221, 226, 29);
		panel.add(userName);
		userName.setColumns(10);
		
		pass = new JPasswordField();
		pass.setBounds(85, 269, 226, 29);
		panel.add(pass);
		pass.setColumns(10);
		
		/**
		 * This is the Login button  it is compare the input with the systems information and login.
		 */
		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String userNameInput = userName.getText();
				@SuppressWarnings("deprecation")
				String passwordInput = pass.getText();
				for (User user: Main.userList) {
					
					// check the user name and password is correct or not
					if ((user.getUserName().equals(userNameInput)) &&(user.getPassword().equals(passwordInput))) {
						
						Main.activeUser = user;
						/**
						 * Check the user's type, set activeStudent and activeTutor, and open the corresponding page.
						 */
						if (user instanceof Student) {
							StudentPage.activeStudent = (Student) user;
							frame.setVisible(false);
							
							StudentPage studentPage = new StudentPage();
							studentPage.setVisible(true);
							
							return;
							
							
						}
						else if (user instanceof Tutor) {
							TutorPage.activeTutor = (Tutor) user;
							frame.setVisible(false);
							TutorPage tutorPage = new TutorPage();
							tutorPage.setVisible(true);
							return;
						}
						else {   
							// admin login
							frame.setVisible(false);
							AdminPage adminPage = new AdminPage();
							adminPage.setVisible(true);
							return;
							
							
						}
							
						
						
					}
					
					
					
				}
				// If there is nor user with these information it show a error message dialog. 
				
				JOptionPane.showMessageDialog(frame, "Username or password is wrong, please try again.",
			               "Message", JOptionPane.ERROR_MESSAGE);
				
			}
		});
		
		login.setBackground(new Color(129, 0, 1));
		login.setForeground(new Color(86, 83, 84));
		login.setBounds(85, 308, 226, 29);
		frame.getRootPane().setDefaultButton(login);
		panel.add(login);
		
		/**
		 * This is the back button
		 */
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				StartPage startPage = new StartPage();
				startPage.setVisible(true);
			}
		});
		back.setForeground(new Color(86, 83, 84));
		back.setBounds(323, 6, 75, 29);
		panel.add(back);
		
		/**
		 * This is the second panel which contains a Image
		 */
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 296, 472);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/img/kocBg_1.png")));
		lblNewLabel.setBounds(0, 0, 296, 472);
		panel_1.add(lblNewLabel);
		
		
	}
}
