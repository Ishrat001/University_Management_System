package university_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Marks extends JFrame implements ActionListener {
    
    JButton search, cancel;
    Choice crollno;
    JComboBox<String> cbsemester;
    JLabel sub1, sub2, sub3, sub4, sub5;
    
    Marks() {
        setSize(500, 500);
        setLocation(600, 210);
        setLayout(null);
        
        getContentPane().setBackground(Color.decode("#A0C0F0"));
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icon4.jpg"));
		Image i2 = i1.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(300, 150, 120, 120);
		add(image);
        
        JLabel heading = new JLabel("Result of Examination");
        heading.setBounds(100, 50, 300, 20);
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(heading);
        
        JLabel lblrollno = new JLabel("Select Roll Number");
        lblrollno.setBounds(90, 100, 200, 20);
        lblrollno.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(lblrollno);
        
        crollno = new Choice();
        crollno.setBounds(90, 130, 160, 20);
        add(crollno);
        
        try {
            DatabaseConnection c = new DatabaseConnection();
            ResultSet rs = c.s.executeQuery("SELECT * FROM student");
            while (rs.next()) {
                crollno.add(rs.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel lblsemester = new JLabel("Select Semester");
        lblsemester.setBounds(90, 160, 150, 20);
        lblsemester.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(lblsemester);
        
        String semester[] = {"1st Semester", "2nd Semester", "3rd Semester", "4th Semester", "5th Semester", "6th Semester", "7th Semester", "8th Semester"};
        cbsemester = new JComboBox<>(semester);
        cbsemester.setBounds(90, 190, 160, 20);
        cbsemester.setBackground(Color.WHITE);
        add(cbsemester);
        
        sub1 = new JLabel();
        sub1.setBounds(100, 230, 300, 20);
        sub1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub1);
        
        sub2 = new JLabel();
        sub2.setBounds(100, 260, 300, 20);
        sub2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub2);
        
        sub3 = new JLabel();
        sub3.setBounds(100, 290, 300, 20);
        sub3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub3);
        
        sub4 = new JLabel();
        sub4.setBounds(100, 320, 300, 20);
        sub4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub4);
        
        sub5 = new JLabel();
        sub5.setBounds(100, 350, 300, 20);
        sub5.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(sub5);
        
        search = new JButton("Submit");
        search.setBounds(90, 390, 150, 25);
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        search.addActionListener(this);
        search.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(search);
        
        cancel = new JButton("Back");
        cancel.setBounds(250, 390, 150, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            try {
                DatabaseConnection c = new DatabaseConnection();
                String rollno = crollno.getSelectedItem();
                String semester = cbsemester.getSelectedItem().toString();
                
                ResultSet rs1 = c.s.executeQuery("SELECT * FROM subject WHERE rollno ='" + rollno + "' AND semester = '" + semester + "'");
                while (rs1.next()) {
                    sub1.setText(rs1.getString("subject1"));
                    sub2.setText(rs1.getString("subject2"));
                    sub3.setText(rs1.getString("subject3"));
                    sub4.setText(rs1.getString("subject4"));
                    sub5.setText(rs1.getString("subject5"));
                }
                
                ResultSet rs2 = c.s.executeQuery("SELECT * FROM marks WHERE rollno ='" + rollno + "' AND semester = '" + semester + "'");
                while (rs2.next()) {
                    sub1.setText(sub1.getText() + " - " + rs2.getString("marks1"));
                    sub2.setText(sub2.getText() + " - " + rs2.getString("marks2"));
                    sub3.setText(sub3.getText() + " - " + rs2.getString("marks3"));
                    sub4.setText(sub4.getText() + " - " + rs2.getString("marks4"));
                    sub5.setText(sub5.getText() + " - " + rs2.getString("marks5"));
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new Marks();
    }
}
