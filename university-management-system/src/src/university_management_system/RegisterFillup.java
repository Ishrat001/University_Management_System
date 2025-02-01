package university_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class RegisterFillup extends JFrame implements ActionListener{
	
	JButton register, cancel;
	JTextField tfUsername,tfPassword;
	
	RegisterFillup(){
		
		getContentPane().setBackground(Color.decode("#A0C0FF"));
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
		
		register = new JButton("Register");
		register.setBounds(40, 140, 120, 30);
		register.setBackground(Color.BLACK);
		register.setForeground(Color.WHITE);
		register.addActionListener(this);
		register.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(register);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(180, 140, 120, 30);
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.addActionListener(this);
		cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(cancel);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icon16.png"));
		Image i2 = i1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(350, 0, 200, 200);
		add(image);
		
		setSize(600,300);
		setLocation(550,300);
		setVisible(true);
				
	}
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
	    if (ae.getSource() == register) {
	        String username = tfUsername.getText();
	        String password = tfPassword.getText();
	        
	        try {
	            DatabaseConnection c = new DatabaseConnection();
	            
	            
	            String query1 = "SELECT * FROM login WHERE username='" + username + "' AND password='" + password + "'";
	            ResultSet rs = c.s.executeQuery(query1);
	            
	            if (rs.next()) {
	                
	                JOptionPane.showMessageDialog(null, "This username or password is already taken");
	            } else {
	                
	                String query2 = "INSERT INTO login VALUES('" + username + "', '" + password + "')";
	                c.s.executeUpdate(query2);
	                
	                JOptionPane.showMessageDialog(null, "Registration successful!");
	                setVisible(false);
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	    } else if (ae.getSource() == cancel) {
	        setVisible(false);
	    }
	}

	
	public static void main(String[] args) {
		new RegisterFillup();
	}

	
}
