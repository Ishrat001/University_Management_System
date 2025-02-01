package university_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Project extends JFrame implements ActionListener{

	Project(){
		
		//getContentPane().setBackground(Color.decode("#A0E0DD"));
		setSize(1000,700);
		setLocation(350, 120);
		//setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/University-Of-Dhaka-campus.jpeg"));
		Image i2 = i1.getImage().getScaledInstance(1000, 631, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		//image.setBounds(500, 70, 200, 200);
		add(image);
		
		JMenuBar mb = new JMenuBar();
		mb.setPreferredSize(new Dimension(100, 50));
		
		
		//for add
		JMenu newInformation = new JMenu("Add New");
		newInformation.setForeground(Color.BLACK);
		mb.add(newInformation);
		
		JMenuItem facultyInfo = new JMenuItem("Add New Faculty");
		facultyInfo.setBackground(Color.WHITE);
		facultyInfo.addActionListener(this);
		newInformation.add(facultyInfo);
		
		JMenuItem studentInfo = new JMenuItem("Add New Student");
		studentInfo.setBackground(Color.WHITE);
		studentInfo.addActionListener(this);
		newInformation.add(studentInfo);
		
		//for show details
		JMenu details = new JMenu("View Details");
		details.setForeground(Color.BLACK);
		mb.add(details);
		
		JMenuItem facultydetails = new JMenuItem("Faculty Details");
		facultydetails.setBackground(Color.WHITE);
		facultydetails.addActionListener(this);
		details.add(facultydetails);
		
		JMenuItem studentdetails = new JMenuItem("Student Details");
		studentdetails.setBackground(Color.WHITE);
		studentdetails.addActionListener(this);
		details.add(studentdetails);
		
		//for leave
		JMenu leave  = new JMenu("Apply Leave");
		leave.setForeground(Color.BLACK);
		mb.add(leave);
		
		JMenuItem facultyleave = new JMenuItem("Faculty Leave");
		facultyleave.setBackground(Color.WHITE);
		facultyleave.addActionListener(this);
		leave.add(facultyleave);
		
		JMenuItem studentleave = new JMenuItem("Student Leave");
		studentleave.setBackground(Color.WHITE);
		studentleave.addActionListener(this);
		leave.add(studentleave);
		
		//for leave details
		JMenu leavedetails  = new JMenu("Leave Details");
		leavedetails.setForeground(Color.BLACK);
		mb.add(leavedetails);
		
		JMenuItem facultyleavedetails = new JMenuItem("Faculty Leave Details");
		facultyleavedetails.setBackground(Color.WHITE);
		facultyleavedetails.addActionListener(this);
		leavedetails.add(facultyleavedetails);
		
		JMenuItem studentleavedetails = new JMenuItem("Student Leave Details");
		studentleavedetails.setBackground(Color.WHITE);
		studentleavedetails.addActionListener(this);
		leavedetails.add(studentleavedetails);
		
		//for exams
		JMenu exam = new JMenu("Examination");
		exam.setForeground(Color.BLACK);
		mb.add(exam);
		
		JMenuItem examdetails = new JMenuItem("Exam Details");
		examdetails.setBackground(Color.WHITE);
		examdetails.addActionListener(this);
		exam.add(examdetails);
		
		JMenuItem entermarks = new JMenuItem("Enter Marks");
		entermarks.setBackground(Color.WHITE);
		entermarks.addActionListener(this);
		exam.add(entermarks);
		
		JMenuItem veiwresult = new JMenuItem("Veiw Result");
		veiwresult.setBackground(Color.WHITE);
		veiwresult.addActionListener(this);
		exam.add(veiwresult);
		
		//for update information
		JMenu updateInfo = new JMenu("Update");
		updateInfo.setForeground(Color.BLACK);
		mb.add(updateInfo);
		
		JMenuItem updatefacultyInfo= new JMenuItem("Update Faculty");
		updatefacultyInfo.setBackground(Color.WHITE);
		updatefacultyInfo.addActionListener(this);
		updateInfo.add(updatefacultyInfo);
		
		JMenuItem updatestudentInfo = new JMenuItem("Update Student");
		updatestudentInfo.setBackground(Color.WHITE);
		updatestudentInfo.addActionListener(this);
		updateInfo.add(updatestudentInfo);
		
		//for fee
		JMenu fee = new JMenu("Fee Details");
		fee.setForeground(Color.BLACK);
		mb.add(fee);
		
		JMenuItem feeStucture= new JMenuItem("Semester Fee");
		feeStucture.setBackground(Color.WHITE);
		feeStucture.addActionListener(this);
		fee.add(feeStucture);
		
		JMenuItem feeform = new JMenuItem("Student Fee Form");
		feeform.setBackground(Color.WHITE);
		feeform.addActionListener(this);
		fee.add(feeform);
		
		//for utility
		JMenu utility = new JMenu("Utility");
		utility.setForeground(Color.BLACK);
		mb.add(utility);
		
		JMenuItem notepad= new JMenuItem("Notepad");
		notepad.setBackground(Color.WHITE);
		notepad.addActionListener(this);
		utility.add(notepad);
		
		JMenuItem calc = new JMenuItem("Calculator");
		calc.setBackground(Color.WHITE);
		calc.addActionListener(this);
		utility.add(calc);
		
		//about
		/*JMenu about = new JMenu("About");
		about.setForeground(Color.BLUE);
		mb.add(about);
		
		JMenuItem ab = new JMenuItem("About");
		ab.setBackground(Color.WHITE);
		ab.addActionListener(this);
		about.add(ab);*/
		
		//for exit
		JMenu exit = new JMenu("Exit");
		exit.setForeground(Color.BLACK);
		mb.add(exit);
		
		JMenuItem ex = new JMenuItem("Exit");
		ex.setBackground(Color.WHITE);
		ex.addActionListener(this);
		exit.add(ex);
		
		
		
		
		setJMenuBar(mb);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		 String msg = ae.getActionCommand();
		 
		 if(msg.equals("Exit")) {
			 setVisible(false);
		 }else if(msg.equals("Calculator")) {
			 try {
				 Runtime.getRuntime().exec("calc.exe");
			 }catch(Exception e){
				 
			 }
		 }else if(msg.equals("Notepad")) {
			 try {
				 Runtime.getRuntime().exec("notepad.exe");
			 }catch(Exception e){
				 
			 }
		 }else if(msg.equals("Add New Faculty")) {
			 new AddTeacher();
		 }else if(msg.equals("Add New Student")) {
			 new AddStudent();
		 }else if(msg.equals("Faculty Details")) {
			 new TeacherDetails();
		 }else if(msg.equals("Student Details")) {
			 new StudentDetails();
		 }else if(msg.equals("Faculty Leave")) {
			 new TeacherLeave();
		 }else if(msg.equals("Student Leave")) {
			 new StudentLeave();
		 }else if(msg.equals("Faculty Leave Details")) {
			 new TeacherLeaveDetails();
		 }else if(msg.equals("Student Leave Details")) {
			 new StudentLeaveDetails();
		 }else if(msg.equals("Update Faculty")) {
			 new UpdateTeacher();
		 }else if(msg.equals("Update Student")) {
			 new UpdateStudent();
		 }else if(msg.equals("Enter Marks")) {
			 new EnterMarks();
		 }else if(msg.equals("Exam Details")) {
			 new ExaminationDetails();
		 }else if(msg.equals("Veiw Result")) {
			 new Marks();
		 }else if(msg.equals("Semester Fee")) {
			 new FeeStructure();
		 }/*else if(msg.equals("About")) {
			 new About();
		 }*/else if(msg.equals("Student Fee Form")) {
			 new StudentFeeForm();
		 }
		 
		 
	}
	
	
	public static void main(String[] args) {
		new Project();

	}

}
