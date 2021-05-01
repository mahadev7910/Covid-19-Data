package typroject;

import java.sql.*;
import java.io.*;

public class insertState {
 
    public static void main(String[] args) throws SQLException,IOException {
        
        
            Connection c;
            java.sql.PreparedStatement smt;
            
        try{
            // Database Connection :
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","maddy","maddy20");
            System.out.println("Opened DB");
            
            // Opening File For insert :
            BufferedReader br = new BufferedReader(new FileReader("/home/maddy/NetBeansProjects/TYProject/src/typroject/stateName.txt"));
            
            String line,q,rec[],cc = "IND";
                
            // Query For InsertData into State Table :
            q = "INSERT INTO state_health_department(country_code,state_code,state_name,cases,active,recovered,deaths) values (?,?,?,?,?,?,?)";
            
            smt = c.prepareStatement(q);
            
            while((line = br.readLine()) != null){
                
                rec = line.split(",");
               
                smt.setString(1,cc);
                smt.setString(2,rec[0]);
                smt.setString(3,rec[1]);
                smt.setInt(4,0);
                smt.setInt(5, 0);
                smt.setInt(6, 0);
                smt.setInt(7, 0);
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
