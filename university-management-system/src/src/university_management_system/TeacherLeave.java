package university_management_system;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

import java.awt.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class TeacherLeave extends JFrame implements ActionListener {
	Choice cEmpId, ctime;
	JDateChooser dcdate;
	JButton submit, cancel;
	
	TeacherLeave(){
		
		
		setSize(500, 500);
		setLocation(600, 210);
		setLayout(null);
		
		getContentPane().setBackground(Color.decode("#A0C0F0"));
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icon15.png"));
		Image i2 = i1.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(300, 170, 120, 120);
		add(image);
		
		JLabel heading  = new JLabel("Apply Leave (Teacher)");
		heading.setBounds(160, 50, 300, 30);
		heading.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(heading);
		
		JLabel lblrollno = new JLabel("Search by Teacher Id");
		lblrollno.setBounds(90, 120, 200, 20);
		lblrollno.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(lblrollno);
		
		cEmpId = new Choice();
		cEmpId.setBounds(90, 150, 160, 20);
		add(cEmpId);
		
		try {
			DatabaseConnection c = new DatabaseConnection();
			ResultSet rs = c.s.executeQuery("SELECT * FROM teacher");
			while(rs.next()) {
				cEmpId.add(rs.getString("empId"));
			}
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
		JLabel lbldate = new JLabel("Date");
		lbldate.setBounds(90, 190, 200, 20);
		lbldate.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(lbldate);
		
		dcdate = new JDateChooser();	
		dcdate.setBounds(90, 220, 160, 20);
		add(dcdate);
		
		JLabel lbltime = new JLabel("Leave type");
		lbltime.setBounds(90, 270, 200, 20);
		lbltime.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(lbltime);
		
		ctime = new Choice();
		ctime.setBounds(90, 300, 160, 20);
		ctime.add("PlLeave(singleday)");
		ctime.add("PlLeave(multiday)");
		ctime.add("Medical Leave");
		ctime.add("Study Leave");
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
			String empId = cEmpId.getSelectedItem();
			String date = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
			String duration = ctime.getSelectedItem();
			
			String query = "INSERT INTO teacherleave VALUES('"+empId+"', '"+date+"', '"+duration+"')";
			
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
		new TeacherLeave();
	}

}

