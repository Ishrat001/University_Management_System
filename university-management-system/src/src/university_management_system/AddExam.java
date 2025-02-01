package university_management_system;

import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import net.proteanit.sql.DbUtils;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddExam extends JFrame implements ActionListener {

    JComboBox<String> cbcourse, cbdepartment;
    JDateChooser dcdate1, dcdate2;
    JButton submit, cancel;
    JTextField tfname;
    JTable table; // Add a JTable object

    AddExam() {
        setSize(500, 500);
        setLocation(550, 150);
        setLayout(null);

        getContentPane().setBackground(Color.decode("#A0C0F0"));

        JLabel heading = new JLabel("Add New Exam");
        heading.setBounds(160, 50, 300, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);

        JLabel lblname = new JLabel("Exam Name");
        lblname.setBounds(90, 100, 120, 30);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(210, 100, 160, 30);
        add(tfname);

        JLabel lbldate1 = new JLabel("Start Date");
        lbldate1.setBounds(90, 150, 200, 20);
        lbldate1.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lbldate1);

        dcdate1 = new JDateChooser();
        dcdate1.setBounds(210, 150, 160, 30);
        add(dcdate1);

        JLabel lbldate2 = new JLabel("End Date");
        lbldate2.setBounds(90, 190, 200, 20);
        lbldate2.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lbldate2);

        dcdate2 = new JDateChooser();
        dcdate2.setBounds(210, 190, 160, 30);
        add(dcdate2);

        JLabel lblcourse = new JLabel("Courses");
        lblcourse.setBounds(90, 230, 200, 30);
        lblcourse.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblcourse);

        String course[] = {"BSc", "MSc", "BBA", "MBA", "BA", "MA"};
        cbcourse = new JComboBox<>(course);
        cbcourse.setBounds(210, 230, 160, 30);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);

        JLabel lbldepartment = new JLabel("Department");
        lbldepartment.setBounds(90, 280, 200, 30);
        lbldepartment.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lbldepartment);

        String department[] = {"CSE", "EEE", "RME", "GEB", "NE", "ACCE", "Marketing", "Finance", "BI", "AIS", "Management", "Economics", "PS", "IR"};
        cbdepartment = new JComboBox<>(department);
        cbdepartment.setBounds(210, 280, 160, 30);
        cbdepartment.setBackground(Color.WHITE);
        add(cbdepartment);

        submit = new JButton("Add");
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

       /* table = new JTable(); // Initialize the JTable
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(20, 420, 450, 200);
        add(sp);*/

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String examname = tfname.getText();
            String startdate = ((JTextField) dcdate1.getDateEditor().getUiComponent()).getText();
            String enddate = ((JTextField) dcdate2.getDateEditor().getUiComponent()).getText();
            String course = (String) cbcourse.getSelectedItem();
            String department = (String) cbdepartment.getSelectedItem();

            try {
                DatabaseConnection con = new DatabaseConnection();
                String query = "INSERT INTO examdetails (course, department, examname, startdate, enddate) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement pstmt = con.c.prepareStatement(query);
                pstmt.setString(1, course);
                pstmt.setString(2, department);
                pstmt.setString(3, examname);
                pstmt.setString(4, startdate);
                pstmt.setString(5, enddate);
                pstmt.executeUpdate();

                /*String query1 = "SELECT * FROM examdetails";
                ResultSet rs = con.s.executeQuery(query1);
                table.setModel(DbUtils.resultSetToTableModel(rs));*/

                JOptionPane.showMessageDialog(null, "Exam Added Successfully");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddExam();
    }
}
