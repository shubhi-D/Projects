package bank.management.system;

import java.sql.*;  

public class Conn{
    Connection c;
    Statement s;
    public Conn(){  
        try{  
           // Class.forName("com.mysql.jdbc.Driver");  
            c =DriverManager.getConnection("jdbc:mysql:///bms","root","shubhi9259@spdf");    
            s =c.createStatement(); 
           
          
            
        }catch(Exception e){ 
            System.out.println(e);
        }  
    }  
}  

