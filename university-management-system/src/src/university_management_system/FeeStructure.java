package university_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;


public class FeeStructure extends JFrame implements ActionListener{
	
	JButton submit, cancel;
	JComboBox <String> cbcourse,cbdepartment;
	
	FeeStructure(){
		setSize(900, 500);
		setLocation(400, 210);
		setLayout(null);
		
		getContentPane().setBackground(Color.decode("#A0C0F0"));
		
		JLabel heading = new JLabel ("Semester Fee");
		heading.setBounds(330, 40, 400, 30);
		heading.setFont(new Font("Tahoma",Font.BOLD,30));
		add(heading);
		
		JTable table =  new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JScrollPane jsp = new JScrollPane(table);
		jsp.setBounds(0, 160, 900, 130);
		add(jsp);
		
		try {
			DatabaseConnection c = new DatabaseConnection();
			ResultSet rs = c.s.executeQuery("SELECT * FROM fee");
			table.setModel(DbUtils.resultSetToTableModel(rs));	
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		submit = new JButton("Update");
		submit.setBounds(250, 400, 120, 30);
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.addActionListener(this);
		submit.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(submit);
		
		cancel = new JButton("Back");
		cancel.setBounds(550, 400, 120, 30);
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
			new UpdateFee();
		}else {
			setVisible(false);
		
		}
		
	}
	
	public static void main (String[] args) {
		new FeeStructure();
	}

}
