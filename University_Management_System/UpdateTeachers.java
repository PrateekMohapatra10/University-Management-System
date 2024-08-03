package University_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;


public class UpdateTeachers extends JFrame implements ActionListener
{

    JTextField  addTextField, emailTextField, phoneTextField, cbcourse, cbbranch;

    JLabel labelrollno , class10TextField, class12TextField ;

    JButton submit, cancel;

    Choice cEmpId;

    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L); 

    UpdateTeachers()
    {
        JLabel Heading = new JLabel("Update Teacher Details");
        Heading.setFont(new Font("Tahoma", Font.PLAIN, 30));
        Heading.setBounds(90,0, 900, 30);
        add(Heading);

        JLabel RHeading = new JLabel("Select Employee ID - ");
        RHeading.setFont(new Font("Osward", Font.BOLD, 16));
        RHeading.setBounds(90,50, 200, 20);
        add(RHeading);

        cEmpId = new Choice();
        cEmpId.setBounds(290, 50, 150, 20);
        add(cEmpId);

        try 
        {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            while (rs.next())
            {
                cEmpId.add(rs.getString("Roll_No"));
            }
            
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }


        JLabel name = new JLabel("Name :");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(90, 110, 200, 25);
        add(name);

        JLabel nameTextField = new JLabel();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 16));
        nameTextField.setBounds(220, 110, 180, 25);
        add(nameTextField);

        JLabel roll = new JLabel("Employee ID:");
        roll.setFont(new Font("Raleway", Font.BOLD, 20));
        roll.setBounds(90, 160, 200, 25);
        add(roll);

        labelrollno = new JLabel();
        labelrollno.setFont(new Font("Raleway", Font.BOLD, 20));
        labelrollno.setBounds(220, 160, 200, 25);
        add(labelrollno);


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

        class10TextField = new JLabel();
        class10TextField.setFont(new Font("Raleway", Font.BOLD, 16));
        class10TextField.setBounds(220, 310, 180, 25);
        add(class10TextField);

        JLabel course = new JLabel("Education :");
        course.setFont(new Font("Raleway", Font.BOLD, 20));
        course.setBounds(90, 360, 180, 25);
        add(course);

        cbcourse = new JTextField();
        cbcourse.setBounds(220, 360, 180, 25);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);

        JLabel fname = new JLabel("Father's Name :");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(450, 110, 200, 25);
        add(fname);

        JLabel fnameTextField = new JLabel();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 16));
        fnameTextField.setBounds(610, 110, 180, 25);
        add(fnameTextField);

        JLabel dob = new JLabel("Date Of Birth :");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(450, 160, 200, 25);
        add(dob);

        JLabel dcdob = new JLabel();
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
        
        JLabel aadharTextField = new JLabel();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD, 16));
        aadharTextField.setBounds(610, 260, 180, 25);
        add(aadharTextField);        

        JLabel class12 = new JLabel("Class XII(%) :");
        class12.setFont(new Font("Raleway", Font.BOLD, 20));
        class12.setBounds(450, 310, 200, 25);
        add(class12);

        class12TextField = new JLabel();
        class12TextField.setFont(new Font("Raleway", Font.BOLD, 16));
        class12TextField.setBounds(610, 310, 180, 25);
        add(class12TextField);

        JLabel branch = new JLabel("Department :");
        branch.setFont(new Font("Raleway", Font.BOLD, 20));
        branch.setBounds(450, 360, 200, 25);
        add(branch);
        
        cbbranch = new JTextField();
        cbbranch.setBounds(610, 360, 180, 25);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);


        try
        {
            Conn c = new Conn();
            String query = "select * from teacher where Roll_No= '"+cEmpId.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next())
            {
                nameTextField.setText(rs.getString("Name"));
                fnameTextField.setText(rs.getString("Fname"));
                labelrollno.setText(rs.getString("Roll_No"));
                dcdob.setText(rs.getString("DOB"));
                aadharTextField.setText(rs.getString("Aadhar"));
                class10TextField.setText(rs.getString("Class_10"));
                class12TextField.setText(rs.getString("Class_12"));
                addTextField.setText(rs.getString("Address"));
                emailTextField.setText(rs.getString("Email"));
                phoneTextField.setText(rs.getString("Phone"));
                cbbranch.setText(rs.getString("Department"));
                cbcourse.setText(rs.getString("Education"));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        cEmpId.addItemListener(new ItemListener() 
        {
            public void itemStateChanged(ItemEvent ie)
            {
                try
                    {
                        Conn c = new Conn();
                        String query = "select * from teacher where Roll_No= '"+cEmpId.getSelectedItem()+"'";
                        ResultSet rs = c.s.executeQuery(query);
                        while(rs.next())
                        {
                            nameTextField.setText(rs.getString("Name"));
                            fnameTextField.setText(rs.getString("Fname"));
                            labelrollno.setText(rs.getString("Roll_No"));
                            dcdob.setText(rs.getString("DOB"));
                            aadharTextField.setText(rs.getString("Aadhar"));
                            class10TextField.setText(rs.getString("Class_10"));
                            class12TextField.setText(rs.getString("Class_12"));
                            addTextField.setText(rs.getString("Address"));
                            emailTextField.setText(rs.getString("Email"));
                            phoneTextField.setText(rs.getString("Phone"));
                            cbbranch.setText(rs.getString("Department"));
                            cbcourse.setText(rs.getString("Education"));
                        }
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
            }
            
        });


        submit = new JButton("Update");
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
            String rollno = labelrollno.getText();
            String address = addTextField.getText();
            String phone = phoneTextField.getText();
            String email = emailTextField.getText();
            String course = cbcourse.getText();
            String branch = cbbranch.getText();

            try 
            {
                String query = "update teacher set Address = '"+address+"', Phone = '"+phone+"', Email = '"+email+"', Education = '"+course+"', Department = '"+branch+"' where Roll_No = '"+rollno+"'";

                Conn c = new Conn();
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Student Details Updated Successfully");
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
        new UpdateTeachers();
    }
}
