package covindata;

import java.sql.*; 
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

class BigDataState {
   
    public static void main(String args[]) throws SQLException,IOException, ParseException {
        
        Connection c;
        java.sql.PreparedStatement smt,ssmt = null;
            
        try{
            // Database Connection :
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","maddy","maddy20");
            System.out.println("Opened DB");
            
            // Opening File For insert :
            BufferedReader br = new BufferedReader(new FileReader("/home/maddy/NetBeansProjects/TYProject/src/typroject/csvfiles/covid_19_india.csv"));
            br.readLine();
            
            String line,p,q,rec[],scode;
            int active,count=0;
          
            java.util.Date d1;
          
	while((line = br.readLine()) != null){
	            
	    rec = line.split(",");

            // Converting String to Date :-
            d1 = new SimpleDateFormat("yyyy-MM-dd").parse(rec[1]);
            java.sql.Date sqd = new java.sql.Date(d1.getTime());
            
            // Query For availble district or not :-
            p = "SELECT * FROM state WHERE state_name = \'"+rec[3]+"\'";
            
            smt = c.prepareStatement(p);
            ResultSet sid = smt.executeQuery();
       
            if(sid.next()){
        
                // Query For InsertData into State Table :
                q = "INSERT INTO state_data(state_code,cases,active,recovered,deaths,last_update) values (?,?,?,?,?,?)";	
            	
            	ssmt = c.prepareStatement(q);
                
                ssmt.setString(1,sid.getString(2));
                ssmt.setInt(2,Integer.parseInt(rec[8]));
                // Active Cases :-
                active = Integer.parseInt(rec[8]) - (Integer.parseInt(rec[6]) + Integer.parseInt(rec[7]));                
                ssmt.setInt(3,active);				
                ssmt.setInt(4,Integer.parseInt(rec[6]));
                ssmt.setInt(5,Integer.parseInt(rec[7]));
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
                System.out.println(e);
            }
        }
            
            c.close();
                        
        } catch (ClassNotFoundException | FileNotFoundException ex){//| ParseException | ClassCastException ex ) {
        
	  		    System.out.println(ex);
          }
      }     
    
}
