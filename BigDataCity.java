package covindata;

import java.sql.*; 
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class BigDataCity {
   
    public static void main(String args[]) throws SQLException,IOException, ParseException {
        
        Connection c;
        java.sql.PreparedStatement smt,ssmt = null;
            
        try{
            // Database Connection :
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","maddy","maddy20");
            System.out.println("Opened DB");
            
            // Opening File For insert :
            BufferedReader br = new BufferedReader(new FileReader("/home/maddy/NetBeansProjects/CovIndata/src/csvfiles/districts.csv"));
            br.readLine();
            
            String line,p,q,rec[];
            int id,active,count=0;
          
            java.util.Date d1; 
           
	while((line = br.readLine()) != null){
	            
	    rec = line.split(",");

            // Converting String to Date :-
            d1 = new SimpleDateFormat("yyyy-MM-dd").parse(rec[0]);
            java.sql.Date sqd = new java.sql.Date(d1.getTime());
            
            // Query For availble district or not :-
            p = "SELECT * FROM district2 WHERE dist = \'"+rec[2]+"\'";
            
            smt = c.prepareStatement(p);
            ResultSet sid = smt.executeQuery();
            
            if(sid.next()){
    
                // Query For InsertData into State Table :
                q = "INSERT INTO district_data2(dist_id,cases,active,recovered,deaths,last_update) values (?,?,?,?,?,?)";	
            	
            	ssmt = c.prepareStatement(q);
                
                ssmt.setInt(1,sid.getInt(1));
                ssmt.setInt(2,Integer.parseInt(rec[3]));
                // Active Cases :-
                active = Integer.parseInt(rec[3]) - (Integer.parseInt(rec[5])+Integer.parseInt(rec[6]));                
                ssmt.setInt(3,active);				
                ssmt.setInt(4,Integer.parseInt(rec[4]));
                ssmt.setInt(5,Integer.parseInt(rec[5]));
                // adding date :-                
                ssmt.setDate(6,sqd);
                ssmt.addBatch();
                rec = null;
                System.out.println(++count);
            }
            try {
                  ssmt.executeBatch();
            }
            catch(BatchUpdateException e){
                continue;
            }
        }
            
            c.close();
                        
        } catch (ClassNotFoundException | FileNotFoundException ex){//| ParseException | ClassCastException ex ) {
        
	  		    System.out.println(ex);
          }
      }      
}
                
//INSERT INTO country_data(country_code,cases,active,recovered,deaths) SELECT 'IND',SUM(cases),SUM(active),SUM(recovered),SUM(deaths) from state_data GROUP BY last_update;
             