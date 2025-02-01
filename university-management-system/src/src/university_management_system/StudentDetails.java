package university_management_system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;
public class StudentDetails extends JFrame implements ActionListener {
	
	Choice crollno;
	JTable table;
	JButton search, print, update, add, cancel;
	
	StudentDetails(){
		
		
		
		getContentPane().setBackground(Color.decode("#A0C0F0"));
		setLayout(null);
		
		JLabel heading  = new JLabel("Search by Roll Number");
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
			ResultSet rs = c.s.executeQuery("SELECT * FROM student");
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		}catch(Exception e){
			e.printStackTrace();	
		}
		
		JScrollPane jsp = new JScrollPane(table);
		jsp.setBounds(0, 100, 950, 300);
		add(jsp);
		
		search = new JButton("Search");
		search.setBounds(100, 70, 80, 20);
		search.addActionListener(this);
		add(search);
		
		print = new JButton("Print");
		print.setBounds(250, 70, 80, 20);
		print.addActionListener(this);
		add(print);
		
		update = new JButton("Update");
		update.setBounds(400, 70, 80, 20);
		update.addActionListener(this);
		add(update);
		
		add = new JButton("Add");
		add.setBounds(550, 70, 80, 20);
		add.addActionListener(this);
		add(add);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(700, 70, 80, 20);
		cancel.addActionListener(this);
		add(cancel);
		
		
		
		
		
		
		
		
		setSize(950, 550);
		setLocation(380, 200);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == search) {
			String query = "SELECT * FROM student WHERE rollno = '"+crollno.getSelectedItem()+"'";
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
		}else if(ae.getSource() == add) {
			//setVisible(false);
			new AddStudent();
		}else if(ae.getSource() == update) {
			//setVisible(false);
			new UpdateStudent();
		}else {
			setVisible(false);
		}
		
	}
	
	
	public static void main(String[] args) {
		new StudentDetails();
	}	
}
