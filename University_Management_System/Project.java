package University_Management_System;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Project extends JFrame implements ActionListener
{

    Project()
    {
        //setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1650, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        JMenuBar mb = new JMenuBar();

        //New Information
        JMenu newInformation = new JMenu("New Information");
        newInformation.setForeground(Color.BLUE);
        mb.add(newInformation);

        JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
        facultyInfo.setBackground(Color.WHITE);
        facultyInfo.addActionListener(this);
        newInformation.add(facultyInfo);

        JMenuItem studentInfo = new JMenuItem("New Student Information");
        studentInfo.setBackground(Color.WHITE);
        studentInfo.addActionListener(this);
        newInformation.add(studentInfo);

        //Details
        JMenu details = new JMenu("View Details");
        details.setForeground(Color.BLUE);
        mb.add(details);

        JMenuItem facultydetails = new JMenuItem("View Faculty Details");
        facultydetails.setBackground(Color.WHITE);
        facultydetails.addActionListener(this);
        details.add(facultydetails);

        JMenuItem studentdetails = new JMenuItem("View Student Details");
        studentdetails.setBackground(Color.WHITE);
        studentdetails.addActionListener(this);
        details.add(studentdetails);

        //Leave
        JMenu leave = new JMenu("Apply Leave");
        leave.setForeground(Color.BLUE);
        mb.add(leave);
 
        JMenuItem facultyleave = new JMenuItem("Faculty Leave");
        facultyleave.setBackground(Color.WHITE);
        facultyleave.addActionListener(this);
        leave.add(facultyleave);
 
        JMenuItem studentleave = new JMenuItem("Student Leave");
        studentleave.setBackground(Color.WHITE);
        studentleave.addActionListener(this);
        leave.add(studentleave);
 
        //Leave Details
        JMenu leavedetails = new JMenu("Leave Details");
        leavedetails.setForeground(Color.BLUE);
        mb.add(leavedetails);

        JMenuItem facultyleavedetails = new JMenuItem("Faculty Leave Details");
        facultyleavedetails.setBackground(Color.WHITE);
        facultyleavedetails.addActionListener(this);
        leavedetails.add(facultyleavedetails);

        JMenuItem studentleavedetails = new JMenuItem("Student Leave Details");
        studentleavedetails.setBackground(Color.WHITE);
        studentleavedetails.addActionListener(this);
        leavedetails.add(studentleavedetails);

        //Exams
        JMenu exams = new JMenu("Examination");
        exams.setForeground(Color.BLUE);
        mb.add(exams);
 
        JMenuItem examinationresult = new JMenuItem("Examination Results");
        examinationresult.setBackground(Color.WHITE);
        examinationresult.addActionListener(this);
        exams.add(examinationresult);
 
        JMenuItem entermarks = new JMenuItem("Enter Marks");
        entermarks.setBackground(Color.WHITE);
        entermarks.addActionListener(this);
        exams.add(entermarks);
 
        //UpdateInfo
        JMenu updateInfo = new JMenu("Update Details");
        updateInfo.setForeground(Color.BLUE);
        mb.add(updateInfo);
 
        JMenuItem updatefacultyinfo = new JMenuItem("Update Faculty Information");
        updatefacultyinfo.setBackground(Color.WHITE);
        updatefacultyinfo.addActionListener(this);
        updateInfo.add(updatefacultyinfo);
 
        JMenuItem updatestudentinfo = new JMenuItem("Update Student Information");
        updatestudentinfo.setBackground(Color.WHITE);
        updatestudentinfo.addActionListener(this);
        updateInfo.add(updatestudentinfo);

        //Fee
        JMenu fee = new JMenu("Fee Details");
        fee.setForeground(Color.BLUE);
        mb.add(fee);
 
        JMenuItem feestructure = new JMenuItem("Fee Structure");
        feestructure.setBackground(Color.WHITE);
        feestructure.addActionListener(this);
        fee.add(feestructure);
 
        JMenuItem feeform = new JMenuItem("Studend Fee Form");
        feeform.setBackground(Color.WHITE);
        feeform.addActionListener(this);
        fee.add(feeform);
 
        //Utility
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.BLUE);
        mb.add(utility);
  
        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setBackground(Color.WHITE);
        notepad.addActionListener(this);
        utility.add(notepad);
  
        JMenuItem calc = new JMenuItem("Calculator");
        calc.setBackground(Color.WHITE);
        calc.addActionListener(this);
        utility.add(calc);
  
        //About
        JMenu about = new JMenu("About");
        about.setForeground(Color.BLUE);
        mb.add(about);
  
        JMenuItem ab = new JMenuItem("About");
        ab.setBackground(Color.WHITE);
        ab.addActionListener(this);
        about.add(ab);

        //Exit
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.BLUE);
        mb.add(exit);
  
        JMenuItem ex = new JMenuItem("Exit");
        ex.setBackground(Color.WHITE);
        ex.addActionListener(this);
        exit.add(ex);
 
 

        setJMenuBar(mb);

        setSize(1400, 800);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {

        String msg = ae.getActionCommand();

        if(msg.equals("Exit"))
        {
            setVisible(false);
        }
        else if (msg.equals("Calculator"))
        {
            try 
            {
                
            } 
            catch (Exception e) 
            {
                
            }
        }
        else if (msg.equals("Notepad"))
        {
            try 
            {
                
            } 
            catch (Exception e) 
            {
                
            }
        }
        else if (msg.equals("New Faculty Information"))
        {
            new AddTeacher();
        }
        else if (msg.equals("New Student Information"))
        {
            new AddStudent();
        }
        else if (msg.equals("View Faculty Details"))
        {
            new TeacherDetails();
        }
        else if (msg.equals("View Student Details"))
        {
            new StudentDetails();
        }
        else if (msg.equals("Faculty Leave"))
        {
            new TeacherLeave();
        }
        else if (msg.equals("Student Leave"))
        {
            new StudentLeave();
        }
        else if (msg.equals("Faculty Leave Details"))
        {
            new TeacherLeaveDetails();
        }
        else if (msg.equals("Student Leave Details"))
        {
            new StudentLeaveDetails();
        }
        else if (msg.equals("Update Faculty Information"))
        {
            new UpdateTeachers();
        }
        else if (msg.equals("Update Student Information"))
        {
            new UpdateStudents();
        }
        else if (msg.equals("Examination Results"))
        {
            new ExaminationDetails();
        }
        else if (msg.equals("Enter Marks"))
        {
            new EnterMarks();
        }
        else if (msg.equals("Fee Structure"))
        {
            new FeeStructure();
        }
        else if (msg.equals("About"))
        {
            new About();
        }
        else if (msg.equals("Studend Fee Form"))
        {
            new StudentFeeForm();
        }


    }
    public static void main(String args [])
    {
        new Project();
    }
    
}
