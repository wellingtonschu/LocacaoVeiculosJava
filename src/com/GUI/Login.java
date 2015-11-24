package com.GUI;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.table.TableColumn;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JEditorPane;
import javax.swing.JTable;

public class Login {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		frame = new JFrame();
		frame.setBounds(100, 100, 230, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JButton btnLogIn = new JButton("Log In");
		springLayout.putConstraint(SpringLayout.WEST, btnLogIn, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnLogIn, -10, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().add(btnLogIn);
		
		JButton btnSignUp = new JButton("Sign Up");
		springLayout.putConstraint(SpringLayout.SOUTH, btnSignUp, 0, SpringLayout.SOUTH, btnLogIn);
		springLayout.putConstraint(SpringLayout.EAST, btnSignUp, -10, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(btnSignUp);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField, 94, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textField, 0, SpringLayout.WEST, btnLogIn);
		springLayout.putConstraint(SpringLayout.EAST, textField, 0, SpringLayout.EAST, btnSignUp);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblSenha = new JLabel("Password:");
		springLayout.putConstraint(SpringLayout.WEST, lblSenha, 10, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(lblSenha);
		
		JLabel lblUser = new JLabel("User:");
		springLayout.putConstraint(SpringLayout.WEST, lblUser, 0, SpringLayout.WEST, btnLogIn);
		springLayout.putConstraint(SpringLayout.SOUTH, lblUser, -6, SpringLayout.NORTH, textField);
		frame.getContentPane().add(lblUser);
		
		passwordField = new JPasswordField();
		springLayout.putConstraint(SpringLayout.NORTH, passwordField, 160, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblSenha, -6, SpringLayout.NORTH, passwordField);
		springLayout.putConstraint(SpringLayout.WEST, passwordField, 0, SpringLayout.WEST, btnLogIn);
		springLayout.putConstraint(SpringLayout.EAST, passwordField, 0, SpringLayout.EAST, btnSignUp);
		frame.getContentPane().add(passwordField);
	}
}
