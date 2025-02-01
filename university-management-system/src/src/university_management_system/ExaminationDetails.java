package university_management_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;



public class ExaminationDetails extends JFrame implements ActionListener {
	
	JTextField search;
	JButton addexam, print, cancel;
	JTable table;
	
	 ExaminationDetails(){
		 
		 setSize(950, 520);
		 setLocation(380, 210);
		 setLayout(null);
		 
		 getContentPane().setBackground(Color.decode("#A0C0F0"));
		 
		 JLabel heading = new JLabel ("Exams");
		 heading.setBounds(400, 15, 400, 50);
		 heading.setFont(new Font("Tahoma",Font.BOLD,24));
		 add(heading);
		 
		 /*search = new JTextField();
		 search.setBounds(80, 90, 200, 30);
		 search.setFont(new Font("Tahoma",Font.PLAIN,18));
		 add(search);*/
		 
		 addexam = new JButton("Add Exam");
		 addexam.setBounds(150, 90, 120, 30);
		 //submit.setBackground(Color.BLACK);
		 //submit.setForeground(Color.WHITE);
		 addexam.addActionListener(this);
		 //submit.setFont(new Font("Tahoma", Font.BOLD, 15));
		 add(addexam);
		 
		 print = new JButton("Print");
		 print.setBounds(400, 90, 120, 30);
		 print.addActionListener(this);
		 add(print);
			
		 cancel = new JButton("Back");
		 cancel.setBounds(650, 90, 120, 30);
		 //cancel.setBackground(Color.BLACK);
		// cancel.setForeground(Color.WHITE);
		 cancel.addActionListener(this);
		 //cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
		 add(cancel);
		 
		 table = new JTable();
		 table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 
		 JScrollPane jsp = new JScrollPane(table);
		 jsp.setBounds(0, 130, 950, 220);
		 add(jsp);
		 
		 try {
			 DatabaseConnection c = new DatabaseConnection();
			 ResultSet rs = c.s.executeQuery("SELECT * FROM examdetails");
			 table.setModel(DbUtils.resultSetToTableModel(rs));
			 
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		 
		 /*table.addMouseListener(new MouseAdapter() {
			 public void mouseClicked(MouseEvent me) {
				 int row = table.getSelectedRowCount();
				 search.setText(table.getModel().getValueAt(row, 2).toString());
				 
			 }
		 });*/
		 
		 setVisible(true);
		 
	 }
	
	
	 @Override
		public void actionPerformed(ActionEvent ae) {
			if(ae.getSource() == addexam) {
				//setVisible(false);
				new AddExam();
				try {
					 DatabaseConnection c = new DatabaseConnection();
					 ResultSet rs = c.s.executeQuery("SELECT * FROM examdetails");
					 table.setModel(DbUtils.resultSetToTableModel(rs));
					 
				 }catch(Exception e) {
					 e.printStackTrace();
				 }
				 
			}else if(ae.getSource() == print) {
				try {
					table.print();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}else {
				setVisible(false);
			}
			
		}
	
	public static void main(String[] args){
		new ExaminationDetails();
	}
}
