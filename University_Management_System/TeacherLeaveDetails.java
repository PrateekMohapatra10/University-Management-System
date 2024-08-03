package University_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class TeacherLeaveDetails extends JFrame implements ActionListener
{

    Choice cEmpId;
    JTable table;
    JButton search, print, cancel;


    TeacherLeaveDetails()
    {
        setLayout(null);

        JLabel Heading = new JLabel("Search By Employee ID - ");
        Heading.setFont(new Font("Osward", Font.BOLD, 16));
        Heading.setBounds(20,20, 200, 20);
        add(Heading);

        cEmpId = new Choice();
        cEmpId.setBounds(220, 20, 150, 20);
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


        table = new JTable();

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);

        try 
        {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacherleave");
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

        cancel = new JButton("Cancel");
        cancel.setBounds(220, 70, 80, 20);
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
            String query = "select * from studentleave where Roll_No = '"+cEmpId.getSelectedItem()+"'";
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
        else if (ae.getSource() == cancel) 
        {
            setVisible(false);
        }
    }
    public static void main(String args [])
    {
        new TeacherLeaveDetails();
    }
}
