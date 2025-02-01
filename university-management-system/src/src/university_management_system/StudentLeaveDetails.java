package university_management_system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class StudentLeaveDetails extends JFrame implements ActionListener {
	Choice crollno;
	JTable table;
	JButton search, print, submit, cancel;
	
	StudentLeaveDetails(){
		
		getContentPane().setBackground(Color.decode("#A0C0F0"));
		setLayout(null);
		
		JLabel heading  = new JLabel("Cancel Leave by Roll No.");
		heading.setBounds(20, 20, 150, 20);
		add(heading);
		
		crollno = new Choice();
		crollno.setBounds(180, 20, 150, 20);
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
		
		table = new JTable();
		
		try {
			DatabaseConnection c = new DatabaseConnection();
			ResultSet rs = c.s.executeQuery("SELECT * FROM studentleave");
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		}catch(Exception e){
			e.printStackTrace();	
		}
		
		JScrollPane jsp = new JScrollPane(table);
		jsp.setBounds(0, 100, 900, 250);
		add(jsp);
		
		search = new JButton("Search");
		search.setBounds(100, 70, 80, 20);
		search.addActionListener(this);
		add(search);
		
		print = new JButton("Print");
		print.setBounds(300, 70, 80, 20);
		print.addActionListener(this);
		add(print);
		
		submit = new JButton("Submit");
		submit.setBounds(500, 70, 80, 20);
		submit.addActionListener(this);
		add(submit);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(700, 70, 80, 20);
		cancel.addActionListener(this);
		add(cancel);
		
		
		setSize(900, 500);
		setLocation(400, 210);
		setVisible(true);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == search) {
			String query = "SELECT * FROM studentleave WHERE rollno = '"+crollno.getSelectedItem()+"'";
			try {
				DatabaseConnection c = new DatabaseConnection();
				ResultSet rs = c.s.executeQuery(query);
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
				
			}catch(Exception e){
				e.printStackTrace();
			}
		
		}else if(ae.getSource() == print) {
			try {
				table.print();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(ae.getSource() == submit) {
			String dquery = "DELETE FROM studentleave WHERE rollno = '"+crollno.getSelectedItem()+"'";
			String rquery = "SELECT * FROM studentleave";
			try {
				DatabaseConnection c = new DatabaseConnection();
				c.s.executeUpdate(dquery);
				ResultSet rs = c.s.executeQuery(rquery);
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}else {
			setVisible(false);
		}
		
	}
	
	public static void main(String[] args) {
		new StudentLeaveDetails();
	}

}
