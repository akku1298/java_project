import java.io.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class firstpage implements ActionListener{
JFrame f;
JLabel l1,l2,l3;
JButton b1,b2;
JTextField t1;
JPasswordField t2;

firstpage(){
f = new JFrame("Index Page");
f.setBackground(Color.white);
l1= new JLabel(new ImageIcon("kr.jpeg"));
l1.setBounds(0,0,600,150);
l2=new JLabel ("ID :-",JLabel.CENTER);
l2.setBounds(80,210,200,50);
l2.setForeground(Color.black);
l3=new JLabel ("Password :-",JLabel.CENTER);
l3.setBounds(80,280,200,50);
l3.setForeground(Color.black);
t1 = new JTextField(" ");
t1.setBounds(300,210,200,50);
t2 = new JPasswordField(" ");
t2.setBounds(300,280,200,50);
b1 = new JButton("RESET");
b1.setBounds(80,350,200,50);
b2 = new JButton("SUBMIT");
b2.setBounds(300,350,200,50);
Font fo=new Font("Serif",Font.BOLD,20);   
          l2.setFont(fo);
          l3.setFont(fo);
          Font fon=new Font("Serif",Font.BOLD,15);
          b1.setFont(fon);
          b2.setFont(fon);
          b1.addActionListener(this);
          b2.addActionListener(this);
          f.add(l1);
          f.add(l2);
          f.add(l3);
          f.add(t1);
          f.add(t2);
          f.add(b1);
          f.add(b2);
          f.setSize(600,600);
          f.setLayout(null);
          f.setVisible(true);
      }
public void actionPerformed(ActionEvent e)
{
                String s1 = t1.getText();
                String s2 = t2.getText();
		if(e.getSource()==b2)
		{                              if(s1.length()<4)
			{	
                                			l2.setForeground(Color.red);
                                			l3.setForeground(Color.white);
                                			JOptionPane.showMessageDialog(f,"The value in ID Field must be greater than 4");
                            		}
                            		if(s2.length()<4)
			{
                                 			l3.setForeground(Color.red);
                                 			l2.setForeground(Color.white);
                                 			JOptionPane.showMessageDialog(f,"Enter correct password");
                            		}
                         if (s1.equals("admin") && s2.equals("1234"))
			 {
				secondpage ob=new secondpage();
				
        				
			}
                else
			{
				System.out.println("enter the valid username and password");
				JOptionPane.showMessageDialog(f,"Incorrect login or password","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
                if(e.getSource()==b1)
		{       l3.setForeground(Color.white);
                        l2.setForeground(Color.white);  
			t1.setText("");
                        t2.setText("");
		}
	}
      public static void main(String[] s){
          Connection con=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/","root","");
			
			Statement stat=con.createStatement();
			stat.executeUpdate("CREATE DATABASE Project_Java");
			
		}
		catch(Exception e)
		{}
          firstpage ob=new firstpage();

      }
 
}

 

