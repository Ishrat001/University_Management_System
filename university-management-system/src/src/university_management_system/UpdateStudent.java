package university_management_system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateStudent extends JFrame implements ActionListener {
	
	 JTextField tfaddress,tfphone,tfemail, tfcourse, tfdepartment;
	 JLabel labelrollno;
	 JButton submit,cancel;
	 Choice crollno;
	 
	 
	UpdateStudent(){
		
		setSize(850, 600);
		setLocation(400, 210);
		
		setLayout(null);
		getContentPane().setBackground(Color.decode("#A0C0F0"));
		
		JLabel heading = new JLabel ("Update Student Details");
		heading.setBounds(50, 10, 500, 50);
		heading.setFont(new Font("Tahoma",Font.BOLD,30));
		add(heading);
		
		
		JLabel lblrollnumber = new JLabel("Select Roll Number");
		lblrollnumber.setBounds(50, 100, 200, 20);
		lblrollnumber.setFont(new Font("Tahoma",Font.BOLD,16));
		add(lblrollnumber);
		
		crollno = new Choice();
		crollno.setBounds(250, 100, 200, 20);
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

		
		JLabel lblname = new JLabel ("Name");
		lblname.setBounds(50, 150, 100, 30);
		lblname.setFont(new Font("Tahoma",Font.BOLD,16));
		add(lblname);
		
		JLabel labelname = new JLabel();
		labelname.setBounds(200, 150, 150, 30);
		labelname.setFont(new Font("Tahoma",Font.BOLD,16));
		add(labelname);
		
		JLabel lblfname = new JLabel ("Father's Name");
		lblfname.setBounds(400, 150, 200, 30);
		lblfname.setFont(new Font("Tahoma",Font.BOLD,16));
		add(lblfname);
		
		JLabel labelfname = new JLabel();
		labelfname.setBounds(600, 150, 150, 30);
		labelfname.setFont(new Font("Tahoma",Font.BOLD,16));
		add(labelfname);
		
		JLabel lblrollno = new JLabel ("Roll Number");
		lblrollno.setBounds(50, 200, 200, 30);
		lblrollno.setFont(new Font("Tahoma",Font.BOLD,16));
		add(lblrollno);
		
		labelrollno = new JLabel ();
		labelrollno.setBounds(200, 200, 200, 30);
		labelrollno.setFont(new Font("Tahoma",Font.BOLD,16));
		add(labelrollno);
		
		JLabel lbldob = new JLabel ("Date of Birth");
		lbldob.setBounds(400, 200, 200, 30);
		lbldob.setFont(new Font("Tahoma",Font.BOLD,16));
		add(lbldob);
		
		JLabel labeldob = new JLabel();	
		labeldob.setBounds(600, 200, 150, 30);
		labeldob.setFont(new Font("Tahoma",Font.BOLD,16));
		add(labeldob);
		
		JLabel lbladdress = new JLabel ("Address");
		lbladdress.setBounds(50, 250, 200, 30);
		lbladdress.setFont(new Font("Tahoma",Font.BOLD,16));
		add(lbladdress);
		
		tfaddress = new JTextField();
		tfaddress.setBounds(200, 250, 150, 30);
		add(tfaddress);
		
		JLabel lblphone = new JLabel ("Phone");
		lblphone.setBounds(400, 250, 200, 30);
		lblphone.setFont(new Font("Tahoma",Font.BOLD,16));
		add(lblphone);
		
		tfphone = new JTextField();
		tfphone.setBounds(600, 250, 150, 30);
		add(tfphone);
		
		JLabel lblemail = new JLabel ("Email Id");
		lblemail.setBounds(50, 300, 200, 30);
		lblemail.setFont(new Font("Tahoma",Font.BOLD,16));
		add(lblemail);
		
		tfemail = new JTextField();
		tfemail.setBounds(200, 300, 150, 30);
		add(tfemail);
		
		JLabel lblx = new JLabel ("SSC GPA");
		lblx.setBounds(400, 300, 200, 30);
		lblx.setFont(new Font("Tahoma",Font.BOLD,16));
		add(lblx);
		
		JLabel labelx = new JLabel();
		labelx.setBounds(600, 300, 150, 30);
		labelx.setFont(new Font("Tahoma",Font.BOLD,16));
		add(labelx);
		
		JLabel lblxii = new JLabel ("HSC GPA");
		lblxii.setBounds(50, 350, 200, 30);
		lblxii.setFont(new Font("Tahoma",Font.BOLD,16));
		add(lblxii);
		
		JLabel labelxii = new JLabel();
		labelxii.setBounds(200, 350, 150, 30);
		labelxii.setFont(new Font("Tahoma",Font.BOLD,16));
		add(labelxii);
		
		JLabel lblnid = new JLabel ("NID Number");
		lblnid.setBounds(400, 350, 200, 30);
		lblnid.setFont(new Font("Tahoma",Font.BOLD,16));
		add(lblnid);
		
		JLabel labelnid = new JLabel();
		labelnid.setBounds(600, 350, 150, 30);
		labelnid.setFont(new Font("Tahoma",Font.BOLD,16));
		add(labelnid);
		
		JLabel lblcourse = new JLabel ("Courses");
		lblcourse.setBounds(50, 400, 200, 30);
		lblcourse.setFont(new Font("Tahoma",Font.BOLD,16));
		add(lblcourse);
		
		tfcourse = new JTextField();
		tfcourse.setBounds(200, 400, 150, 30);
		tfcourse.setBackground(Color.WHITE);
		add(tfcourse);
		
		JLabel lbldepartment = new JLabel ("Department");
		lbldepartment.setBounds(400, 400, 200, 30);
		lbldepartment.setFont(new Font("Tahoma",Font.BOLD,16));
		add(lbldepartment);
		
		tfdepartment = new JTextField();
		tfdepartment.setBounds(600, 400, 150, 30);
		tfdepartment.setBackground(Color.WHITE);
		add(tfdepartment);
		
		try {
			
			DatabaseConnection c = new DatabaseConnection();
			String query = "SELECT * FROM student WHERE rollno='"+crollno.getSelectedItem()+"'";
			ResultSet rs = c.s.executeQuery(query);
			while(rs.next()) {

				labelname.setText(rs.getString("name"));
				labelfname.setText(rs.getString("fname"));
				labeldob.setText(rs.getString("dob"));
				tfaddress.setText(rs.getString("address"));
				tfphone.setText(rs.getString("phone"));
				tfemail.setText(rs.getString("email"));
				labelx.setText(rs.getString("class_x"));
				labelxii.setText(rs.getString("class_xii"));
				labelnid.setText(rs.getString("nid"));
				labelrollno.setText(rs.getString("rollno"));
				tfcourse.setText(rs.getString("course"));
				tfdepartment.setText(rs.getString("department"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		crollno.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent ie) {
				try {
					
					DatabaseConnection c = new DatabaseConnection();
					String query = "SELECT * FROM student WHERE rollno='"+crollno.getSelectedItem()+"'";
					ResultSet rs = c.s.executeQuery(query);
					while(rs.next()) {

						labelname.setText(rs.getString("name"));
						labelfname.setText(rs.getString("fname"));
						labeldob.setText(rs.getString("dob"));
						tfaddress.setText(rs.getString("address"));
						tfphone.setText(rs.getString("phone"));
						tfemail.setText(rs.getString("email"));
						labelx.setText(rs.getString("class_x"));
						labelxii.setText(rs.getString("class_xii"));
						labelnid.setText(rs.getString("nid"));
						labelrollno.setText(rs.getString("rollno"));
						tfcourse.setText(rs.getString("course"));
						tfdepartment.setText(rs.getString("department"));
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		submit = new JButton("Update");
		submit.setBounds(220, 480, 120, 30);
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.addActionListener(this);
		submit.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(submit);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(500, 480, 120, 30);
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
			String rollno = labelrollno.getText();
			String address = tfaddress.getText();
			String phone = tfphone.getText();
			String email = tfemail.getText();
			String course = tfcourse.getText();
			String department = tfdepartment.getText();
			
			
			try {
				String query = "UPDATE student SET address='"+address+"', phone='"+phone+"', email='"+email+"', course='"+course+"', department='"+department+"' WHERE rollno='"+rollno+"'";   
				
				DatabaseConnection con = new DatabaseConnection();
				con.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null, "Student Details Updated Succsessfully");
				setVisible(false);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
				
		} else {
			setVisible(false);
		}
		
	}
	
	
	public static void main(String[] args) {
		new UpdateStudent();
	}

}

