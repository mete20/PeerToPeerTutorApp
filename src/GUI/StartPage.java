package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.Student;
import app.User;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.LayoutManager;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.awt.Toolkit;

public class StartPage extends JFrame {
	/**
	 * This page is the start page which opens when the program runs.
	 * It is contains two button sign in and sign up.
	 * It has two panels.
	 * It has also other design component image and labels.
	 */

	private JPanel contentPane;
	private BufferedImage image;

	/**
	 * Create the frame.
	 */
	public StartPage() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 700, 500);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 236, 70));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		try {                
	          image = ImageIO.read(new File("src/img/kocBg.png"));
	       } 
		catch (IOException ex) {
	            // handle exception...
	       }
		
		// the panel which contains a image
		JPanel panel = new JPanel();
		panel.setBackground(new Color(238, 238, 238));
		panel.setBounds(0, 0, 296, 472);
		contentPane.add(panel);
		panel.setLayout(null);
		
		/**
		 *  the label which contains the image of KOÇ University view.
		 */
		JLabel lblNewLabel = new JLabel(new ImageIcon(image));
		lblNewLabel.setBounds(0, 0, 296, 472);
		panel.add(lblNewLabel);
		
		// the label which contains the other things.
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(238, 238, 238));
		panel_1.setBounds(297, 0, 403, 472);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		// buttons
		JButton signInButton = new JButton("Sign In");
		signInButton.setBounds(199, 283, 117, 29);
		panel_1.add(signInButton);
		
		JButton signUpButton = new JButton("Sign Up");
		signUpButton.setBackground(new Color(0, 0, 0));
		signUpButton.setBounds(82, 283, 117, 29);
		panel_1.add(signUpButton);
		
		// Program Name
		JLabel lblNewLabel_1 = new JLabel("tutORfail");
		lblNewLabel_1.setBounds(97, 61, 210, 79);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Chalkboard", Font.BOLD, 45));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(204, 120, 45));
		
		// welcome text
		JLabel lblNewLabel_2 = new JLabel("Welcome!");
		lblNewLabel_2.setBounds(146, 179, 115, 31);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		
		// from @author text
		JLabel lblNewLabel_3 = new JLabel("from Metehan Yaka");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(141, 431, 121, 16);
		panel_1.add(lblNewLabel_3);
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		
		/**
		 * Adding action to both sign in and sign up buttons to open the sign up or sign in page.
		 */
		signUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				Register register = new Register();
				register.setVisible(true);

			}
		});
		signInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				Login login = new Login();
				login.frame.setVisible(true);
			}
		});
		

	}
}
