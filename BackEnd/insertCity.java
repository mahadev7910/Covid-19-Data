package typroject;

import java.sql.*;
import java.io.*;

public class insertCity {
   
    public static void main(String args[]) throws SQLException,IOException {
        
        Connection c;
        java.sql.PreparedStatement smt;
            
        try{
            // Database Connection :
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","maddy","maddy20");
            System.out.println("Opened DB");
            
            // Opening File For insert :
            BufferedReader br = new BufferedReader(new FileReader("/home/maddy/NetBeansProjects/TYProject/src/typroject/district_wise.csv"));
            br.readLine();
            
            String line,q,rec[];
            int id = 1;    
            // Query For InsertData into State Table :
            q = "INSERT INTO municipal_corporation(c_id,state_code,city,cases,active,recovered,deaths) values (?,?,?,?,?,?,?)";
            
            smt = c.prepareStatement(q);
           
            while((line = br.readLine()) != null){
                
                rec = line.split(",");
               
                smt.setInt(1,id++);
                smt.setString(2,rec[1]);
                smt.setString(3,rec[4]);
                smt.setInt(4,Integer.parseInt(rec[5]));
                smt.setInt(5,Integer.parseInt(rec[6]));
                smt.setInt(6,Integer.parseInt(rec[7]));
                smt.setInt(7,Integer.parseInt(rec[8]));
                
                smt.addBatch();
                
                rec = null;
            }
            smt.executeBatch();
            c.close();
                        
        } catch (ClassNotFoundException | FileNotFoundException ex) {
                //Logger.getLogger(insertState.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex);
        
        }
            
    }
}