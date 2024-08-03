package University_Management_System;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;

public class TeacherLeave extends JFrame implements ActionListener
{

    Choice crollno, ctime;
    JDateChooser dcdate;
    JButton cancel, submit;

    TeacherLeave()
    {

        JLabel Heading = new JLabel("Apply Leave (Teacher)");
        Heading.setFont(new Font("Osward", Font.BOLD, 25));
        Heading.setBounds(140,10, 350, 50);
        add(Heading);

        JLabel rollno = new JLabel("Search By Employee ID : ");
        rollno.setFont(new Font("Osward", Font.PLAIN, 16));
        rollno.setBounds(60, 70, 900, 30);
        add(rollno);

        crollno = new Choice();
        crollno.setBounds(60, 100, 150, 25);
        add(crollno);

        try 
        {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            while (rs.next())
            {
                crollno.add(rs.getString("Roll_No"));
            }
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }

        JLabel date = new JLabel("Date ");
        date.setFont(new Font("Osward", Font.PLAIN, 16));
        date.setBounds(60,150, 200, 30);
        add(date);

        dcdate = new JDateChooser();
        dcdate.setBounds(60, 180, 150, 25);
        add(dcdate);

        JLabel time = new JLabel("Time Duration ");
        time.setFont(new Font("Osward", Font.PLAIN, 16));
        time.setBounds(60,230, 300, 30);
        add(time);

        ctime = new Choice();
        ctime.setBounds(60, 260, 150, 30);
        ctime.add("Full Time");
        ctime.add("Half Time");
        add(ctime);

        submit = new JButton("Submit");
        submit.setBounds(300, 320, 80, 25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(330, 230, 80, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
       

        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
        setSize(550, 400);
        setLocation( 400, 200 );
        setLayout(null);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == submit)
        {
            String rollno = crollno.getSelectedItem();
            String date = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
            String time = ctime.getSelectedItem();
            String query = "insert into teacherleave value('"+rollno+"', '"+date+"', '"+time+"')";

            try 
            {
              Conn c = new Conn();
              c.s.executeUpdate(query);
              JOptionPane.showMessageDialog(null, "Leave Confired");
              setVisible(false);   
            }
            catch (Exception e)
            {
             e.getStackTrace();
            }

        }
        else if(ae.getSource() == cancel)
        {
            setVisible(false);
        }
    }

    public static void main(String args [])
    {
        new TeacherLeave();
    }
}
