package covindata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;


class search2 {
             
    protected dataClass rec;
    
    public dataClass searchData(String name) {

        Connection c;
        PreparedStatement smt;
        
        String sqd = "2021-05-14";
        
        try{
            
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
            String dd = f.format(new java.util.Date());
            System.out.println("System d = "+dd); 
            
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
             
                String q = "SELECT * FROM state_data2 WHERE state_code = \'"+stcode+"\'"+"and last_update = \'"+dd+"\'";
                     
                smt = c.prepareStatement(q);
                rs = smt.executeQuery();
                
                if(rs.next()){
                    System.out.println("Inside state nested ");
                    rec = new dataClass().getDataState(rs.getString(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getString(6));
                    
                    
                     //recovery rate :-
                    float rt = (float)rec.recovered/rec.cases;  
                    rec.rrate = rt*100; //Recovery Rate
                  
                    float dt = (float)rec.deaths/rec.cases; //death rate
                    rec.drate = dt*100;
                    
                    c.close();
                    return rec;
                  
                }else{
                    
                    q = "SELECT * FROM state_data2 WHERE state_code = \'"+stcode+"\'"+"and last_update = \'"+sqd+"\'";
                     
                    smt = c.prepareStatement(q);
                    rs = smt.executeQuery();

                    if(rs.next()){
                        System.out.println("Inside state nested ");
                        rec = new dataClass().getDataState(rs.getString(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getString(6));


                         //recovery rate :-
                        float rt = (float)rec.recovered/rec.cases;  
                        rec.rrate = rt*100; //Recovery Rate

                        float dt = (float)rec.deaths/rec.cases; //death rate
                        rec.drate = dt*100;

                        c.close();
                        return rec;

                    }
                    else
                        System.out.println("Not availble in state");
                }
            }
        
            else
            {   // Search into STATE weather availble or NOT :-
            
                String p1 = "SELECT * FROM district2 WHERE dist = \'"+name+"\'";
         
                smt = c.prepareStatement(p1);
                rs = smt.executeQuery();
                        
                if(rs.next()){

                    System.out.println("dist_Id = "+rs.getInt(1));
                    int did = rs.getInt(1);

                    String q1 = "SELECT * FROM district_data2 WHERE dist_id = \'"+did+"\'"+"and last_update = \'"+dd+"\'";

                    smt = c.prepareStatement(q1);
                    rs = smt.executeQuery();

                    if(rs.next()){

                        System.out.println("Inside nested district_data2");
                        rec = new dataClass().getDataState(Integer.toString(did), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),rs.getString(6) );

                         //recovery rate :-
                        float rt = (float)rec.recovered/rec.cases;  
                        rec.rrate = rt*100; //Recovery Rate

                        float dt = (float)rec.deaths/rec.cases; //death rate
                        rec.drate = dt*100;

                        c.close();
                        return rec; 
                    
                }else{
                    
                    q1 = "SELECT * FROM district_data2 WHERE dist_id = \'"+did+"\'"+"and last_update = \'"+sqd+"\'";
                     
                    smt = c.prepareStatement(q1);
                    rs = smt.executeQuery();

                    if(rs.next()){

                        System.out.println("Inside nested district_data2");
                        rec = new dataClass().getDataState(Integer.toString(did), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),rs.getString(6) );

                         //recovery rate :-
                        float rt = (float)rec.recovered/rec.cases;  
                        rec.rrate = rt*100; //Recovery Rate

                        float dt = (float)rec.deaths/rec.cases; //death rate
                        rec.drate = dt*100;

                        c.close();
                        return rec; 
                    
                    }else
                        return null;
               }
                    
            }
          }
                                
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }
  
}
    
