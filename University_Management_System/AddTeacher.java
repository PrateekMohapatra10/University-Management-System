package University_Management_System;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import com.toedter.calendar.JDateChooser;


public class AddTeacher extends JFrame implements ActionListener
{

    JTextField nameTextField, addTextField, emailTextField, class10TextField, class12TextField, fnameTextField, dobTextField, phoneTextField, aadharTextField;

    JLabel labelempId;

    JDateChooser dcdob;

    JComboBox cbcourse, cbbranch;

    JButton submit, cancel;

    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L); 

    AddTeacher()
    {
        JLabel Heading = new JLabel("New Teacher Details");
        Heading.setFont(new Font("Osward", Font.BOLD, 40));
        Heading.setBounds(250,10, 900, 70);
        add(Heading);

        JLabel name = new JLabel("Name :");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(90, 110, 200, 25);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 16));
        nameTextField.setBounds(220, 110, 180, 25);
        add(nameTextField);

        JLabel roll = new JLabel("Employee ID :");
        roll.setFont(new Font("Raleway", Font.BOLD, 20));
        roll.setBounds(90, 160, 200, 25);
        add(roll);

        labelempId = new JLabel("A100"+first4);
        labelempId.setFont(new Font("Raleway", Font.BOLD, 20));
        labelempId.setBounds(220, 160, 200, 25);
        add(labelempId);


        JLabel add = new JLabel("Address :");
        add.setFont(new Font("Raleway", Font.BOLD, 20));
        add.setBounds(90, 210, 200, 25);
        add(add);

        addTextField = new JTextField();
        addTextField.setFont(new Font("Raleway", Font.BOLD, 16));
        addTextField.setBounds(220, 210, 180, 25);
        add(addTextField);

        JLabel email = new JLabel("Email Id :");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(90, 260, 200, 25);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 16));
        emailTextField.setBounds(220, 260, 180, 25);
        add(emailTextField);

        JLabel class10 = new JLabel("Class X(%) :");
        class10.setFont(new Font("Raleway", Font.BOLD, 20));
        class10.setBounds(90, 310, 200, 25);
        add(class10);

        class10TextField = new JTextField();
        class10TextField.setFont(new Font("Raleway", Font.BOLD, 16));
        class10TextField.setBounds(220, 310, 180, 25);
        add(class10TextField);

        JLabel course = new JLabel("Qualification :");
        course.setFont(new Font("Raleway", Font.BOLD, 20));
        course.setBounds(90, 360, 200, 25);
        add(course);

        String ccourse[] = {"B.Tech", "BBA", "MCA", "MBA", "Mtech"};
        cbcourse = new JComboBox(ccourse);
        cbcourse.setBounds(220, 360, 200, 25);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);

        JLabel fname = new JLabel("Father's Name :");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(450, 110, 200, 25);
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 16));
        fnameTextField.setBounds(610, 110, 180, 25);
        add(fnameTextField);

        JLabel dob = new JLabel("Date Of Birth :");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(450, 160, 200, 25);
        add(dob);

        dcdob = new JDateChooser();
        dcdob.setBounds(610, 160, 200, 25);
        add(dcdob);

        JLabel phone = new JLabel("Phone No. :");
        phone.setFont(new Font("Raleway", Font.BOLD, 20));
        phone.setBounds(450, 210, 200, 25);
        add(phone);

        phoneTextField = new JTextField();
        phoneTextField.setFont(new Font("Raleway", Font.BOLD, 16));
        phoneTextField.setBounds(610, 210, 180, 25);
        add(phoneTextField);

        JLabel aadhar = new JLabel("Aadhar No. :");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhar.setBounds(450, 260, 200, 25);
        add(aadhar);
        
        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD, 16));
        aadharTextField.setBounds(610, 260, 180, 25);
        add(aadharTextField);        

        JLabel class12 = new JLabel("Class XII(%) :");
        class12.setFont(new Font("Raleway", Font.BOLD, 20));
        class12.setBounds(450, 310, 200, 25);
        add(class12);

        class12TextField = new JTextField();
        class12TextField.setFont(new Font("Raleway", Font.BOLD, 16));
        class12TextField.setBounds(610, 310, 180, 25);
        add(class12TextField);

        JLabel branch = new JLabel("Department :");
        branch.setFont(new Font("Raleway", Font.BOLD, 20));
        branch.setBounds(450, 360, 200, 25);
        add(branch);

        String bbranch[] = {"CSE", "CST", "CS-IT", "CS AI/ML", "Civil", "Mechanical"};
        cbbranch = new JComboBox(bbranch);
        cbbranch.setBounds(610, 360, 200, 25);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);

        submit = new JButton("Submit");
        submit.setBounds(510, 450, 120, 40);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(670, 450, 120, 40);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        

        setLayout(null);

        getContentPane().setBackground(Color.WHITE);
        
        setSize(900, 600);
        setLocation( 250, 50 );
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == submit)
        {
            String name = nameTextField.getText();
            String fname = fnameTextField.getText();
            String rollno = labelempId.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String address = addTextField.getText();
            String phone = phoneTextField.getText();
            String email = emailTextField.getText();
            String class10 = class10TextField.getText();
            String class12 = class12TextField.getText();
            String aadhar = aadharTextField.getText();
            String course = (String) cbcourse.getSelectedItem();
            String branch = (String) cbbranch.getSelectedItem();

            try 
            {
                String query = "insert into teacher value('"+name+"', '"+fname+"', '"+rollno+"', '"+dob+"', '"+address+"', '"+phone+"', '"+email+"', '"+class10+"', '"+class12+"', '"+aadhar+"', '"+course+"', '"+branch+"')";

                Conn c = new Conn();
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Teacher Details Inserted Successfully");
                setVisible(false);
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }


        }
        else
        {
            setVisible(false);
        }

    }

    public static void main(String args [])
    {
        new AddTeacher();
    }
}

