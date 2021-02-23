/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typroject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author maddy
 */
public class demo {
    
 public demo(){
 
     userInfo(100,1);
 }   
 
 void userInfo(int id,int cid){
        
        Connection con1;
        PreparedStatement s;
        
        try{
            
            Class.forName("org.postgresql.Driver");
            con1 = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","maddy","maddy20");
            System.out.println("UserInfo connection eshtablished");
            
            String q1 = "SELECT * FROM covid_center WHERE cov_id = \'"+cid+"\'";
            s = con1.prepareStatement(q1);
            ResultSet r = s.executeQuery();
            if(r.next()){ // will not work without re.next() statement
                System.out.print(r.getInt(1));
            }
            System.out.println(r.getInt(1));
            
            con1.close();
        }
        catch(ClassNotFoundException | SQLException e){}    
}
 
 public static void main(String[] args){
     
     new demo();
 }
}
