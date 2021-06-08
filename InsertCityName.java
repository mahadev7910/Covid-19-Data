package covindata;

import java.sql.*; 
import java.io.*;

public class InsertCityName {
   
    public static void main(String args[]) throws SQLException,IOException {
        
        Connection c;
        java.sql.PreparedStatement smt;
            
        try{
            // Database Connection :
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","maddy","maddy20");
            System.out.println("Opened DB");
            
            // Opening File For insert :
            BufferedReader br = new BufferedReader(new FileReader("/home/maddy/NetBeansProjects/TYProject/src/typroject/csvfiles/district_wise.csv"));
            br.readLine();
            
            String line,q,rec[];
            int id = 1;
            float d = 0;
            // Query For InsertData into State Table :
            q = "INSERT INTO district2(dist_id,state_code,dist) values (?,?,?)";
            
            smt = c.prepareStatement(q);
           
            while((line = br.readLine()) != null){
                
                rec = line.split(",");
               
                smt.setInt(1,id++);
                smt.setString(2,rec[1]);
                smt.setString(3,rec[4]);
                /*if(Integer.parseInt(rec[5]) <= 0 ) continue;
                smt.setInt(2,Integer.parseInt(rec[5]));
                if(Integer.parseInt(rec[6]) <= 0 ) continue;
                smt.setInt(3,Integer.parseInt(rec[6]));
                smt.setInt(4,Integer.parseInt(rec[7]));
                smt.setInt(5,Integer.parseInt(rec[8]));
                smt.setFloat(6, d);
                smt.setFloat(7, d);*/
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