package University_Management_System;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class EnterMarks extends JFrame implements ActionListener
{

    Choice crollno;

    JComboBox  cbsemester;

    JTextField sub1,sub2,sub3,sub4,sub5;
    JTextField marks1,marks2,marks3,marks4,marks5;

    JButton submit, cancel;

    EnterMarks()
    {

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 40, 400, 300);
        add(image);


        JLabel Heading = new JLabel("Enter Marks Of Student");
        Heading.setFont(new Font("Tahoma", Font.BOLD, 25));
        Heading.setBounds(30,0, 900, 25);
        add(Heading);

        JLabel RHeading = new JLabel("Search By Roll Number - ");
        RHeading.setFont(new Font("Osward", Font.BOLD, 14));
        RHeading.setBounds(30,50, 180, 20);
        add(RHeading);

        crollno = new Choice();
        crollno.setBounds(220, 50, 150, 20);
        add(crollno);

        try 
        {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while (rs.next())
            {
                crollno.add(rs.getString("Roll_No"));
            }
            
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }

        JLabel semister = new JLabel("Select Semister - ");
        semister.setFont(new Font("Osward", Font.BOLD, 14));
        semister.setBounds(30,90, 180, 20);
        add(semister);

        String semester[] = {"1st Semester","2nd Semester","3rd Semester","4th Semester","5th Semester","6th Semester","7th Semester","8th Semester",};
        cbsemester = new JComboBox(semester);
        cbsemester.setBounds(220, 90, 150, 20);
        add(cbsemester);

        JLabel subject = new JLabel("Enter Subject");
        subject.setFont(new Font("Osward", Font.BOLD, 14));
        subject.setBounds(70,140, 180, 20);
        add(subject);

        JLabel marks = new JLabel("Enter Marks");
        marks.setFont(new Font("Osward", Font.BOLD, 14));
        marks.setBounds(260,140, 180, 20);
        add(marks);

        
        sub1 = new JTextField();
        sub1.setBounds(30, 180, 180, 20);
        add(sub1);

        sub2 = new JTextField();
        sub2.setBounds(30, 210, 180, 20);
        add(sub2);

        sub3 = new JTextField();
        sub3.setBounds(30, 240, 180, 20);
        add(sub3);

        sub4 = new JTextField();
        sub4.setBounds(30, 270, 180, 20);
        add(sub4);

        sub5 = new JTextField();
        sub5.setBounds(30, 300, 180, 20);
        add(sub5);


        marks1 = new JTextField();
        marks1.setBounds(215, 180, 180, 20);
        add(marks1);

        marks2 = new JTextField();
        marks2.setBounds(215, 210, 180, 20);
        add(marks2);

        marks3 = new JTextField();
        marks3.setBounds(215, 240, 180, 20);
        add(marks3);

        marks4 = new JTextField();
        marks4.setBounds(215, 270, 180, 20);
        add(marks4);

        marks5 = new JTextField();
        marks5.setBounds(215, 300, 180, 20);
        add(marks5);

        submit = new JButton("Submit");
        submit.setBounds(80, 400, 120, 40);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(220, 400, 120, 40);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);



        getContentPane().setBackground(Color.WHITE);

        setSize(1000,500);
        setLocation(300,150);
        setLayout(null);
        setVisible(true);


    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == submit)
        {
            try 
            {
                Conn c = new Conn();

                String query1 = "insert into subject values('"+crollno.getSelectedItem()+"', '"+cbsemester.getSelectedItem()+"', '"+sub1.getText()+"', '"+sub2.getText()+"', '"+sub3.getText()+"', '"+sub4.getText()+"', '"+sub5.getText()+"')";

                String query2 = "insert into marks values('"+crollno.getSelectedItem()+"', '"+cbsemester.getSelectedItem()+"', '"+marks1.getText()+"', '"+marks2.getText()+"', '"+marks3.getText()+"', '"+marks4.getText()+"', '"+marks5.getText()+"')";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Marks Inserted Successfully");
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

    
    public static void main(String[] args) 
    {
        new EnterMarks();
    }
}
