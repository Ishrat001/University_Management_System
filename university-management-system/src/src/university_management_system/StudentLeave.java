package university_management_system;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

import java.awt.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class StudentLeave extends JFrame implements ActionListener {
	Choice crollno, ctime;
	JDateChooser dcdate;
	JButton submit, cancel;
	
	StudentLeave(){
		
		
		setSize(500, 500);
		setLocation(600, 210);
		setLayout(null);
		
		getContentPane().setBackground(Color.decode("#A0C0F0"));
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icon3.png"));
		Image i2 = i1.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(300, 170, 120, 120);
		add(image);
		
		JLabel heading  = new JLabel("Apply Leave (Student)");
		heading.setBounds(160, 50, 300, 30);
		heading.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(heading);
		
		JLabel lblrollno = new JLabel("Search by Roll Number");
		lblrollno.setBounds(90, 120, 200, 20);
		lblrollno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblrollno);
		
		crollno = new Choice();
		crollno.setBounds(90, 150, 160, 20);
		add(crollno);
		
		try {
			DatabaseConnection c = new DatabaseConnection();
			ResultSet rs = c.s.executeQuery("SELECT * FROM student");
			while(rs.next()) {
				crollno.add(rs.getString("rollno"));
			}
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
		JLabel lbldate = new JLabel("Date");
		lbldate.setBounds(90, 190, 200, 20);
		lbldate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lbldate);
		
		dcdate = new JDateChooser();	
		dcdate.setBounds(90, 220, 160, 20);
		add(dcdate);
		
		JLabel lbltime = new JLabel("Time Duration");
		lbltime.setBounds(90, 270, 200, 20);
		lbltime.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lbltime);
		
		ctime = new Choice();
		ctime.setBounds(90, 300, 160, 20);
		ctime.add("Single Day");
		ctime.add("Multi Day");
		add(ctime);
		
		submit = new JButton("Submit");
		submit.setBounds(70, 380, 100, 25);
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.addActionListener(this);
		submit.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(submit);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(300, 380, 100, 25);
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.addActionListener(this);
		cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(cancel);
		
		
		
		setVisible(true);
	
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == submit) {
			String rollno = crollno.getSelectedItem();
			String date = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
			String duration = ctime.getSelectedItem();
			
			String query = "INSERT INTO studentleave VALUES('"+rollno+"', '"+date+"', '"+duration+"')";
			
			try {
				DatabaseConnection c = new DatabaseConnection();
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Leave Confirmed");
				setVisible(false);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			setVisible(false);
		}
		
	}	

	
	
	public static void main(String[] args) {
		new StudentLeave();
	}

}
