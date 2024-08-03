package University_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class StudentDetails extends JFrame implements ActionListener
{

    Choice crollno;
    JTable table;
    JButton search, print, update, add, cancel;


    StudentDetails()
    {
        setLayout(null);

        JLabel Heading = new JLabel("Search By Roll Number - ");
        Heading.setFont(new Font("Osward", Font.BOLD, 16));
        Heading.setBounds(20,20, 200, 20);
        add(Heading);

        crollno = new Choice();
        crollno.setBounds(220, 20, 150, 20);
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


        table = new JTable();

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);

        try 
        {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }

        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        //search.setBackground(Color.BLACK);
        //search.setForeground(Color.WHITE);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        //print.setBackground(Color.BLACK);
        //print.setForeground(Color.WHITE);
        print.addActionListener(this);
        add(print);
        
        add = new JButton("Add");
        add.setBounds(220, 70, 80, 20);
        //add.setBackground(Color.BLACK);
        //add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);
        
        update = new JButton("Update");
        update.setBounds(320, 70, 80, 20);
        //update.setBackground(Color.BLACK);
        //update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);
        

        cancel = new JButton("Cancel");
        cancel.setBounds(420, 70, 80, 20);
        //cancel.setBackground(Color.BLACK);
        //cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        

        getContentPane().setBackground(Color.WHITE);
        
        setSize(900, 600);
        setLocation( 250, 50 );
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == print)
        {
            try 
            {
                table.print();                
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }
        else if (ae.getSource() == search) 
        {
            String query = "select * from student where Roll_No = '"+crollno.getSelectedItem()+"'";
            try
            {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));

            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if (ae.getSource() == add) 
        {
            setVisible(false);
            new AddStudent();
            
        }
        else if (ae.getSource() == update) 
        {
            setVisible(false);
            new UpdateStudents();
        }
        else if (ae.getSource() == cancel) 
        {
            setVisible(false);
        }
    }
    public static void main(String args [])
    {
        new StudentDetails();
    }
}
