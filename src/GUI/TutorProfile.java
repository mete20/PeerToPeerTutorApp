package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TutorProfile extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField age;
	private JTextField tckn;
	private JTextField userName;
	private JTextField password;

	
	/**
	 * Create the frame.
	 */
	public TutorProfile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 1050, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JButton backButton = new JButton("Back");
		backButton.setBounds(43, 45, 117, 29);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TutorPage st = new TutorPage();
				st.setVisible(true);
			}
		});
		contentPane.add(backButton);
		
		
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
		
		JLabel picture = new JLabel(TutorPage.activeTutor.getPortraitPhoto());
		picture.setText("picture");
		picture.setBackground(new Color(238, 238, 238));
		picture.setBounds(99, 151, 170, 170);
		contentPane.add(picture);
		
		JButton uploadButton = new JButton("Upload");
		uploadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				int response = fc.showOpenDialog(null);
				if(response ==JFileChooser.APPROVE_OPTION) {
					ImageIcon image = new ImageIcon(fc.getSelectedFile().getAbsolutePath());
					TutorPage.activeTutor.setPortraitPhoto(image);
					picture.setIcon(image);
				}
			}
		});
		
		uploadButton.setBounds(129, 333, 117, 29);
		contentPane.add(uploadButton);
		
		name = new JTextField();
		name.setBounds(192, 438, 130, 26);
		contentPane.add(name);
		name.setColumns(10);
		name.setText(TutorPage.activeTutor.getName());
		
		
		age = new JTextField();
		age.setColumns(10);
		age.setBounds(192, 466, 130, 26);
		contentPane.add(age);
		age.setText(TutorPage.activeTutor.getAge());
		
		tckn = new JTextField();
		tckn.setColumns(10);
		tckn.setBounds(192, 494, 130, 26);
		contentPane.add(tckn);
		tckn.setText(TutorPage.activeTutor.getTckn());
		
		userName = new JTextField();
		userName.setColumns(10);
		userName.setBounds(192, 525, 130, 26);
		contentPane.add(userName);
		userName.setText(TutorPage.activeTutor.getUserName());
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(192, 555, 130, 26);
		contentPane.add(password);
		password.setText(TutorPage.activeTutor.getPassword());
		
		JButton updateButton = new JButton("Update Profile");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newName = name.getText();
				String newAge = age.getText();
				String newTCKN = tckn.getText();
				String newUserName = userName.getText();
				String newPassword = password.getText();
				
				TutorPage.activeTutor.setName(newName);
				TutorPage.activeTutor.setAge(newAge);;
				TutorPage.activeTutor.setTckn(newTCKN);
				TutorPage.activeTutor.setUserName(newUserName);
				TutorPage.activeTutor.setPassword(newPassword);
				JOptionPane.showMessageDialog(null, "Your profile is successfully updated.",
			               "Message", JOptionPane.WARNING_MESSAGE);
			}
		});
		updateButton.setBounds(152, 593, 117, 29);
		contentPane.add(updateButton);
	}

}
