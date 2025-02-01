package university_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateFee extends JFrame implements ActionListener {
    JButton submit, cancel;
    JComboBox<String> cbcourse, cbsemester;
    JTextField tfamount;

    UpdateFee() {
        setSize(500, 450);
        setLocation(600, 250);
        setLayout(null);

        getContentPane().setBackground(Color.decode("#A0C0F0"));

        JLabel heading = new JLabel("Update Fee");
        heading.setBounds(200, 20, 150, 20);
        add(heading);

        JLabel lblcourse = new JLabel("Courses");
        lblcourse.setBounds(100, 80, 200, 30);
        lblcourse.setFont(new Font("serif", Font.BOLD, 20));
        add(lblcourse);

        String course[] = {"BSc", "MSc", "BBA", "MBA", "BA", "MA"};
        cbcourse = new JComboBox<>(course);
        cbcourse.setBounds(250, 80, 150, 30);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);

        JLabel lblsemester = new JLabel("Semester");
        lblsemester.setBounds(100, 140, 150, 30);
        lblsemester.setFont(new Font("serif", Font.BOLD, 20));
        add(lblsemester);

        String semester[] = {"semester1", "semester2", "semester3", "semester4", "semester5", "semester6", "semester7", "semester8"};
        cbsemester = new JComboBox<>(semester);
        cbsemester.setBounds(250, 140, 150, 30);
        cbsemester.setBackground(Color.WHITE);
        add(cbsemester);

        JLabel lblname = new JLabel("Amount");
        lblname.setBounds(100, 200, 100, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblname);

        tfamount = new JTextField();
        tfamount.setBounds(250, 200, 150, 30);
        add(tfamount);

        submit = new JButton("Update");
        submit.setBounds(90, 300, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(310, 300, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String course = (String) cbcourse.getSelectedItem();
            String semester = (String) cbsemester.getSelectedItem();
            String amount = tfamount.getText();

            try {
                DatabaseConnection c = new DatabaseConnection();
                String query = "UPDATE fee SET " + semester + " ='" + amount + "' WHERE course = '" + course + "'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Fee updated successfully");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateFee();
    }
}
