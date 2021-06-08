package covindata;

import java.sql.*;
import java.text.SimpleDateFormat;

class search {
            
    public int[] searchData(String name) {

        Connection c;
        PreparedStatement smt;
        //java.sql.Date sqd = null;
        
        /*try{
            String s = "2021-05-14";
            
            java.util.Date d1 = new SimpleDateFormat("yyyy-MM-dd").parse(s);
            
            sqd = new java.sql.Date(d1.getTime());
            
            //System.out.println("Date = "+sqd);
            
        } catch (ParseException ex) {
            System.out.println(ex);
        }*/
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String dd = f.format(new java.util.Date());
        System.out.println("System d = "+dd); 
        String sqd = "2021-05-14";
        
        try{
            
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","maddy","maddy20");
            //System.out.println("Connection Eshtablished");
            //System.out.println(name);
            
            // Search into STATE weather availble or NOT :-
            String p = "SELECT * FROM state2 WHERE state_name = \'"+name+"\'";
            
            smt = c.prepareStatement(p);
            ResultSet rs = smt.executeQuery();
            
            if(rs.next()){
             
                System.out.println("stcode = "+rs.getString(2));
                String stcode = rs.getString(2);
             
                String q = "SELECT * FROM state_data2 WHERE state_code = \'"+stcode+"\'"+"and last_update = \'"+sqd+"\'";
                     
                smt = c.prepareStatement(q);
                rs = smt.executeQuery();
                
                if(rs.next()){
                    System.out.println("Inside state nested ");
                    int[] rec = new int[6];
                    rec[0] = rs.getInt(2); //cases
                    rec[1] = rs.getInt(3); //active
                    rec[2] = rs.getInt(4); //recovered
                    rec[3] = rs.getInt(5); //deaths
                    
                     //recovery rate :-
                    float rt = (float)rec[2]/rec[0];  
                    rec[4] = (int) (rt*100); //Recovery Rate
                  
                    float dt = (float)rec[3]/rec[0]; //death rate
                    rec[5] = (int)(dt*100);
                    if(rec[5] == 0)
                        rec[5] = 1;
        
                    c.close();
                    return rec;
                  
                }else
                    System.out.println("No Data availble For given Value");
            }
            else
            {   // Search into STATE weather availble or NOT :-
            
                p = "SELECT * FROM district2 WHERE dist = \'"+name+"\'";
         
                smt = c.prepareStatement(p);
                rs = smt.executeQuery();
                        
            if(rs.next()){
                
                System.out.println("dist_Id = "+rs.getInt(1));
                int did = rs.getInt(1);
             
                String q = "SELECT * FROM district_data2 WHERE dist_id = \'"+did+"\'"+"and last_update = \'"+sqd+"\'";
                     
                smt = c.prepareStatement(q);
                rs = smt.executeQuery();
                
                if(rs.next()){
                    
                    //System.out.println("Inside nested ");
                    int[] rec = new int[6];
                    rec[0] = rs.getInt(2); //cases
                    rec[1] = rs.getInt(3); //active
                    rec[2] = rs.getInt(4); //recovered
                    rec[3] = rs.getInt(5); //deaths
                
                    //recovery rate :-
                    float rt = (float)rec[2]/rec[0];  
                    rec[4] = (int) (rt*100); //Recovery Rate
                  
                    float dt = (float)rec[3]/rec[0]; //death rate
                    rec[5] = (int)(dt*100);
                    if(rec[5] == 0)
                        rec[5] = 1;
                    
                    c.close();
                    return rec;  
                }
               }else
                    return null;
           }
                                
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }
  
}

