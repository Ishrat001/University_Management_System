package university_management_system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class StudentFeeForm extends JFrame implements ActionListener{
	
	Choice crollno;
	JComboBox cbcourse, cbdepartment, cbsemester;
	JLabel lbltotal, labeltotal;
	JButton update, pay, back;
	
	StudentFeeForm(){
		setSize(600, 500);
		setLocation(550, 210);
		setLayout(null);
		getContentPane().setBackground(Color.decode("#A0C0F0"));
	
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icon7.png"));
		Image i2 = i1.getImage().getScaledInstance(100, 110, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(400, 150, 100, 110);
		add(image);
		
		JLabel lblrollnumber = new JLabel("Select Roll No");
		lblrollnumber.setBounds(40, 60, 150, 20);
		lblrollnumber.setFont(new Font("Tahoma",Font.BOLD,16));
		add(lblrollnumber);
		
		crollno = new Choice();
		crollno.setBounds(200, 60, 150, 20);
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
		lblname.setBounds(40, 100, 150, 20);
		lblname.setFont(new Font("Tahoma",Font.BOLD,16));
		add(lblname);
		
		JLabel labelname = new JLabel();
		labelname.setBounds(200, 100, 150, 20);
		labelname.setFont(new Font("Tahoma",Font.BOLD,16));
		add(labelname);
		
		JLabel lblfname = new JLabel ("Father's Name");
		lblfname.setBounds(40, 140, 150, 20);
		lblfname.setFont(new Font("Tahoma",Font.BOLD,16));
		add(lblfname);
		
		JLabel labelfname = new JLabel();
		labelfname.setBounds(200, 140, 150, 20);
		labelfname.setFont(new Font("Tahoma",Font.BOLD,16));
		add(labelfname);
		
		try {
			
			DatabaseConnection c = new DatabaseConnection();
			String query = "SELECT * FROM student WHERE rollno='"+crollno.getSelectedItem()+"'";
			ResultSet rs = c.s.executeQuery(query);
			while(rs.next()) {
				labelname.setText(rs.getString("name"));
				labelfname.setText(rs.getString("fname"));
				
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
				
					}
			
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		

		JLabel lblcourse = new JLabel ("Courses");
		lblcourse.setBounds(40, 180,150, 20);
		lblcourse.setFont(new Font("Tahoma",Font.BOLD,16));
		add(lblcourse);
		
		String course[] = {" ","Bsc","MSc","BBA","MBA","BA","MA"};
		cbcourse = new JComboBox(course);
		cbcourse.setBounds(200, 180, 150, 20);
		cbcourse.setBackground(Color.WHITE);
		add(cbcourse);
		
		JLabel lbldepartment = new JLabel ("Department");
		lbldepartment.setBounds(40, 220, 150, 20);
		lbldepartment.setFont(new Font("Tahoma",Font.BOLD,16));
		add(lbldepartment);
		
		String department[] = {" ","CSE","EEE","RME","GEB","NE","ACCE","Marketing","Finance","BI","AIS","Management","Economics","PS","IR"};
		cbdepartment = new JComboBox(department);
		cbdepartment.setBounds(200, 220, 150, 20);
		cbdepartment.setBackground(Color.WHITE);
		add(cbdepartment);
		
		JLabel lblsemester = new JLabel("Semester");
		lblsemester.setBounds(40, 260, 150, 20);
		lblsemester.setFont(new Font("Tahoma",Font.BOLD,16));
		add(lblsemester);
		
		String semester[] = {" ", "Semester1", "Semester2", "Semester3", "Semester4", "Semester5", "Semester6", "Semester7", "Semester8"};
		cbsemester = new JComboBox(semester);
		cbsemester.setBounds(200, 260, 150, 20);
		cbsemester.setBackground(Color.WHITE);
		add(cbsemester);
		
		lbltotal = new JLabel ("Total Payable");
		lbltotal.setBounds(40, 300, 500, 20);
		lbltotal.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(lbltotal);
		
		labeltotal = new JLabel ();
		labeltotal.setBounds(200, 300, 500, 20);
		labeltotal.setFont(new Font("Tahoma",Font.PLAIN,16));
		add(labeltotal);
		
		update = new JButton("Update");
		update.setBounds(30, 380, 100, 25);
		update.setBackground(Color.BLACK);
		update.setForeground(Color.WHITE);
		update.addActionListener(this);
		add(update);
		
		pay = new JButton("Pay");
		pay.setBounds(150, 380, 100, 25);
		pay.setBackground(Color.BLACK);
		pay.setForeground(Color.WHITE);
		pay.addActionListener(this);
		add(pay);
		
		back = new JButton("Back");
		back.setBounds(270, 380, 100, 25);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		add(back);
		
	
	
		setVisible(true);
	
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == update) {
			String course = (String)cbcourse.getSelectedItem();
			String semester = (String)cbsemester.getSelectedItem();
			try {
				DatabaseConnection c = new DatabaseConnection();
				ResultSet rs = c.s.executeQuery("SELECT * FROM fee WHERE course ='"+course+"'");
				while(rs.next()) {
					labeltotal.setText(rs.getString(semester));
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(ae.getSource() == pay) {
			String rollno = crollno.getSelectedItem();
			String course = (String)cbcourse.getSelectedItem();
			String semester = (String)cbsemester.getSelectedItem();
			String department = (String) cbdepartment.getSelectedItem();
			String total = labeltotal.getText();
			try {
				DatabaseConnection c = new DatabaseConnection();
				String query = "INSERT INTO studentfee VALUES('"+rollno+"', '"+course+"', '"+department+"', '"+semester+"', '"+total+"')";  
				c.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null, "Student fee payed successfully");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			setVisible(false);
		}
		
	}
	
	public static void main(String[] args) {
		new StudentFeeForm();
	}
	
}
