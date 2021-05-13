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
            float d = 0;
            // Query For InsertData into State Table :
            q = "INSERT INTO district_data(dist_id,cases,active,recovered,deaths,recovery_rate,death_rate) values (?,?,?,?,?,?,?)";
            
            smt = c.prepareStatement(q);
           
            while((line = br.readLine()) != null){
                
                rec = line.split(",");
               
                smt.setInt(1,id++);
                //smt.setString(2,rec[1]);
                //smt.setString(3,rec[4]);
                smt.setInt(2,Integer.parseInt(rec[5]));
                smt.setInt(3,Integer.parseInt(rec[6]));
                smt.setInt(4,Integer.parseInt(rec[7]));
                smt.setInt(5,Integer.parseInt(rec[8]));
                smt.setFloat(6, d);
                smt.setFloat(7, d);
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