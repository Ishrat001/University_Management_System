package university_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Register extends JFrame implements ActionListener {
	
	JButton register, login, cancel;
	
	Register(){
		getContentPane().setBackground(Color.decode("#A0C0FF"));
		setLayout(null);
		
		JLabel lblheading1 = new JLabel("Welcome to");
		lblheading1.setBounds(300, 20, 100, 20);
		lblheading1.setFont(new Font("Tahoma", Font.BOLD, 15)); 
		lblheading1.setForeground(Color.decode("#000000"));
		add(lblheading1);
		
		JLabel lblheading2 = new JLabel("University Management System");
		lblheading2.setBounds(230, 50, 250, 20);
		lblheading2.setFont(new Font("Tahoma", Font.BOLD, 15)); 
		lblheading2.setForeground(Color.decode("#000000"));
		add(lblheading2);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icon9.png"));
		Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(250, 50, 200, 200);
		add(image);
		
		register = new JButton("Register");
		register.setBounds(160, 220, 120, 30);
		register.setBackground(Color.BLACK);
		register.setForeground(Color.WHITE);
		register.addActionListener(this);
		register.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(register);
		
		login = new JButton("Login");
		login.setBounds(390, 220, 120, 30);
		login.setBackground(Color.BLACK);
		login.setForeground(Color.WHITE);
		login.addActionListener(this);
		login.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(login);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(280, 270, 120, 30);
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.addActionListener(this);
		cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(cancel);
		
		
		
		
		setSize(700,400);
		setLocation(500,250);
		setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == register) {
			try {
				//setVisible(false);
				new RegisterFillup();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	else if(ae.getSource() == login) {
			
			try {
				setVisible(false);
				new Login();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}else if (ae.getSource() == cancel){
			setVisible(false);
		}
		
		
	}
	
	public static void main(String[] args) {
		new Register();
	}

	

}
