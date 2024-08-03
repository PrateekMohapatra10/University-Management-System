package University_Management_System;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener
{


    JButton login ,cancel; 
    JTextField userTextField,passwordTextField;

    Login()
    {
        setLayout(null);

        JLabel Heading = new JLabel("Prateek's College");
        Heading.setFont(new Font("Osward", Font.BOLD, 40));
        Heading.setBounds(100,10, 900, 70);
        add(Heading);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,60, 200, 200);
        add(image);

        JLabel username = new JLabel("Username :");
        username.setBounds(40,110, 200, 20);
        username.setFont(new Font("Raleway", Font.BOLD, 20));
        add(username);

        userTextField = new JTextField();
        userTextField.setBounds(160,110, 200 ,28);
        userTextField.setFont(new Font("Arial", Font.BOLD, 20));
        add(userTextField);
        
        JLabel password = new JLabel("Password :");
        password.setBounds(40,150, 200, 20);
        password.setFont(new Font("Raleway", Font.BOLD, 20));
        add(password);

        passwordTextField = new JPasswordField();
        passwordTextField.setBounds(160,150, 200 ,28);
        passwordTextField.setFont(new Font("Arial", Font.BOLD, 20));
        add(passwordTextField);

        login = new JButton("Login");
        login.setBounds(40, 200, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setFont(new Font("Tahoma", Font.BOLD, 15));
        login.addActionListener(this);
        add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(170, 200, 100, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        cancel.addActionListener(this);
        add(cancel);  

        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
        setSize(550, 350);
        setLocation( 400, 200 );
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == login)
        {
            String username = userTextField.getText();
            String password = passwordTextField.getText();

            String query = "select * from login where Username = '"+username+"' and Password = '"+password+"'";

            try 
            {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);

                if(rs.next())
                {
                    setVisible(false);
                    new Project();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                    setVisible(false);

                }
            } 
            catch (Exception e) 
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
        new Login();
    }
    
}
