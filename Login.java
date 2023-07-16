package bank.management.system;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{
    
    JLabel text,crd,pin;
    JTextField tf1;
    JPasswordField pf2;
    JButton b1,b2,b3;
     Login(){
           setTitle("BANKING MANAGEMENT SYSTEM");
           setLayout(null);
           
           ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.png"));
           Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
           ImageIcon i3 = new ImageIcon(i2);
           JLabel label=new JLabel(i3);
           label.setBounds(70, 10, 100, 100);
           add(label);
           
           text = new JLabel("WELCOME");
           text.setFont(new Font("Osward", Font.BOLD, 38));
           text.setBounds(200,40,450,40);
           add(text);
           
           crd = new JLabel("Card No:");
           crd.setFont(new Font("Raleway", Font.BOLD, 28));
           crd.setBounds(125,150,375,30);
           add(crd);
           
           tf1 = new JTextField(15);
           tf1.setBounds(300,150,230,30);
           tf1.setFont(new Font("Arial", Font.BOLD, 14));
           add(tf1);
           
           pin = new JLabel("PIN:");
           pin.setFont(new Font("Raleway", Font.BOLD, 28));
           pin.setBounds(125,220,375,30);
           add(pin);
           getContentPane().setBackground(Color.WHITE);
           
           pf2 = new JPasswordField(15);
           pf2.setFont(new Font("Arial", Font.BOLD, 14));
           pf2.setBounds(300,220,230,30);
           add(pf2);
           
           b1 = new JButton("SIGN IN");
           b1.setBackground(Color.BLACK);
           b1.setForeground(Color.WHITE);
           b1.setBounds(300,300,100,30);
           b1.addActionListener(this);
           add(b1);
           
           b2 = new JButton("CLEAR");
           b2.setBackground(Color.BLACK);
           b2.setForeground(Color.WHITE);
           b2.setBounds(430,300,100,30);
            b2.addActionListener(this);
           add(b2);
           
           b3 = new JButton("SIGN UP");
           b3.setBackground(Color.BLACK);
           b3.setForeground(Color.WHITE);
           b3.setBounds(300,350,230,30);
           b3.addActionListener(this);
           add(b3);
          
          
           
          
           setSize(800,600);
           setVisible(true);
           setLocation(550,200);
          
     }
     
    @Override
      public void actionPerformed(ActionEvent ae){
         try{        
            if(ae.getSource()==b1){
                Conn c1 = new Conn();
                String cardno  = tf1.getText();
                String pin  = pf2.getText();
                String q  = "select * from login where cardno = '"+cardno+"' and pin = '"+pin+"'";

                ResultSet rs = c1.s.executeQuery(q);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            }else if(ae.getSource()==b2){
                tf1.setText("");
                pf2.setText("");
            }else if(ae.getSource()==b3){
                setVisible(false);
                new SignupOne().setVisible(true);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String args[]) {
      
        new Login().setVisible(true);
    }
}
