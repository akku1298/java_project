import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.time.*;
import java.time.format.*;
import java.sql.*;

public class thirdpage implements ActionListener{
       JFrame f;
      JLabel l1,l2,l3,l4,l5,l6;
      JButton b1,b2;
      JTextField t1,t2,t3;
 thirdpage(){
           f=new JFrame("Registration Page");
          f.getContentPane().setBackground(Color.white);
          l1= new JLabel(new ImageIcon("kr.jpeg"));
          l1.setBounds(0,0,600,150);

          l2= new JLabel("DATE :-",JLabel.CENTER);
          l2.setForeground(Color.black);
          l2.setBounds(80,210,200,40);

          l3= new JLabel("NAME :-",JLabel.CENTER);
          l3.setForeground(Color.white); 
          l3.setBounds(80,260,200,40);
          l4= new JLabel("FATHER'S NAME :-",JLabel.CENTER);
          l4.setForeground(Color.black); 
          l4.setBounds(80,310,200,40);
          l5= new JLabel("MOTHER'S NAME :-",JLabel.CENTER);
          l5.setForeground(Color.black); 
          l5.setBounds(80,360,200,40);

          LocalTime   no=LocalTime.now();
          DateTimeFormatter d=DateTimeFormatter.ofPattern("HH:mm:ss");
          String da =d.format(no);
          l6= new JLabel(d.format(no),JLabel.CENTER);
          l6.setForeground(Color.black);
          l6.setBounds(300,210,200,40);



          t1= new JTextField();
          t1.setBounds(300,260,200,40);
          t2= new JTextField();
          t2.setBounds(300,310,200,40);
          t3= new JTextField();
          t3.setBounds(300,360,200,40);

          b1= new JButton("RESET");
          b1.setBounds(80,430,200,40);

          b2= new JButton("SUBMIT");
          b2.setBounds(300,430,200,40);
          Font fo=new Font("Serif",Font.BOLD,20);   
          l2.setFont(fo);
          l3.setFont(fo);
          l4.setFont(fo);
          l5.setFont(fo);
          l6.setFont(fo);
          Font fon=new Font("Serif",Font.BOLD,15);
          b1.setFont(fon);
          b2.setFont(fon);
          b1.addActionListener(this);
          b2.addActionListener(this);
          f.add(l1);
          f.add(l2);
          f.add(l3);
          f.add(l4);
          f.add(l5);
          f.add(l6);
          f.add(t1);
          f.add(t2);
          f.add(t3);
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
                String s3 = t3.getText();
              
                if(e.getSource()==b2)
		{        if(s1.length()<4 && s2.length()<4 && s3.length()<4){
                                 l3.setForeground(Color.red);
                                 l4.setForeground(Color.red);
                                 l5.setForeground(Color.red);
                                 JOptionPane.showMessageDialog(f,"The value in ALL Field must be greater than 4");
                         
                         }else if(s1.length()<4 || s2.length()<4 || s3.length()<4){
                                if(s1.length()<4 && s2.length()<4 ){
                                    l3.setForeground(Color.red);
                                    l4.setForeground(Color.red);
                                    l5.setForeground(Color.white);
                                    JOptionPane.showMessageDialog(f,"The value in NAME and FATHER'S NAME Field must be greater than 4");
                                }
                                else if(s2.length()<4 && s3.length()<4 ){
                                    l3.setForeground(Color.white);
                                    l4.setForeground(Color.red);
                                    l5.setForeground(Color.red);
                                    JOptionPane.showMessageDialog(f,"The value in FATHER'S NAME and MOTHER'S NAME Field must be greater than 4");
                                }
                                else if(s1.length()<4 && s3.length()<4 ){
                                    l3.setForeground(Color.red);
                                    l4.setForeground(Color.white);
                                    l5.setForeground(Color.red);
                                    JOptionPane.showMessageDialog(f,"The value in NAME and MOTHER'S NAME Field must be greater than 4");
                                }
                                else if(s1.length()<4){
                                     l3.setForeground(Color.red);
                                     l4.setForeground(Color.white);
                                     l5.setForeground(Color.white);
                                     JOptionPane.showMessageDialog(f,"The value in NAME Field must be greater than 4");
                                }
                                else if(s2.length()<4){
                                     l4.setForeground(Color.red);
                                     l3.setForeground(Color.white);
                                     l5.setForeground(Color.white);
                                     JOptionPane.showMessageDialog(f,"The value in FATHER'S NAME Field must be greater than 4");
                                }
                                else if(s3.length()<4){
                                     l4.setForeground(Color.white);
                                     l3.setForeground(Color.white);
                                     l5.setForeground(Color.red);
                                     JOptionPane.showMessageDialog(f,"The value in MOTHER'S NAME Field must be greater than 4");
                                }
                                
                         }else{
                            JOptionPane.showMessageDialog(f,"You are Registered !");
			    secondpage ob=new secondpage();
                         }
		}
                if(e.getSource()==b1)
		{
                        l3.setForeground(Color.white);
                        l4.setForeground(Color.white);
                        l5.setForeground(Color.white);
			t1.setText("");
                        t2.setText("");
                        t3.setText("");
		}
	}
        public static void main(String[] s){
            thirdpage ob=new thirdpage(); 
        
		Connection con = null;
		try{
		Class.forName ("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/Project_Java","root"," ");
        Statement stat=con.createStatement();
        String yname="akansha";
        String yfathers_name="jitender";
        String ymothers_name="kiran";
        String inser="INSERT INTO 'student'(name,fathers_name,mothers_name)VALUE(" "+yname+" " ,+ " " +yfathers_name+" ",+" "+ymothers_name+" ");
        Stat.executeUpdate(inser);
System.out.println("value inserted successfully");
}
catch (Exception e){
    System.out.println("not connected");
}
}	
 
}
