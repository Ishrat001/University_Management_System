package university_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class About extends JFrame {
	
	About(){
		setSize(700, 500);
		setLocation(400, 150);
		getContentPane().setBackground(Color.WHITE);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/about.jpg"));
		Image i2 = i1.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(350, 0, 300, 200);
		add(image);
		
		
		JLabel heading = new JLabel ("<html>University<br/>Management System</html>");
		heading.setBounds(70, 20, 300, 130);
		heading.setFont(new Font("serif",Font.BOLD,30));
		add(heading);
		
		//you have to import a file here and then read that file which display the history of your university
		
		
		setLayout(null);
		setVisible(true);
		
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		new About();
	}
}
