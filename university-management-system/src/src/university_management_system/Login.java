package university_management_system;

import java.awt.Image;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
	
	JButton login, cancel;
	JTextField tfUsername,tfPassword;
	
	Login(){
		
		getContentPane().setBackground(Color.decode("#A0C0F0"));
		setLayout(null);
		
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(40, 20, 100, 20);
		add(lblUsername);
		
		tfUsername = new JTextField();
		tfUsername.setBounds(120, 20, 150, 20);
		add(tfUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(40, 70, 100, 20);
		add(lblPassword);
		
		tfPassword = new JPasswordField();
		tfPassword.setBounds(120, 70, 150, 20);
		add(tfPassword);
		
		login = new JButton("Login");
		login.setBounds(40, 140, 120, 30);
		login.setBackground(Color.BLACK);
		login.setForeground(Color.WHITE);
		login.addActionListener(this);
		login.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(login);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(180, 140, 120, 30);
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.addActionListener(this);
		cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(cancel);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
		Image i2 = i1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(350, 50, 150, 150);
		add(image);
		
		setSize(550,280);
		setLocation(600,300);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == login) {
			String username = tfUsername.getText();
			String password = tfPassword.getText();
			
			String query = "SELECT * FROM login WHERE username='"+username+"'AND password='"+password+"'";
			
			try {
				DatabaseConnection c = new DatabaseConnection();
				ResultSet rs = c.s.executeQuery(query);
				
				if(rs.next()) {
					setVisible(false);
					new Project();
					
				}else {
					JOptionPane.showMessageDialog(null, "Invalid username or password");
					setVisible(false);	
				}
				//c.s.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}else if (ae.getSource() == cancel){
			setVisible(false);
		}
		
	}
	
	public static void main(String[] args) {
		new Login();
	}

	
}
