package typroject;

import java.sql.*;

class search {

    public int[] searchData(String name){

        Connection c;
        PreparedStatement smt;
        
        try{
            
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","maddy","maddy20");
            System.out.println("Connection Eshtablished");
            System.out.println(name);
            String q = "SELECT state_data.* FROM state,state_data WHERE state.state_code = state_data.state_code and state_name = \'"+name+"\'";
            
            smt = c.prepareStatement(q);
            ResultSet rs = smt.executeQuery();
            
            if(rs.next()){
                
                System.out.println("success");
                System.out.println("state_code = "+rs.getString(1));
                System.out.println("cases = "+rs.getInt(2));
                System.out.println("active = "+rs.getInt(3));
                System.out.println("recovered = "+rs.getInt(4));
                System.out.println("deaths = "+rs.getInt(5));
                
                int[] rec = new int[6];
                rec[0] = rs.getInt(2);
                rec[1] = rs.getInt(3);
                rec[2] = rs.getInt(4);
                rec[3] = rs.getInt(5);
                rec[4] = rs.getInt(6);
                rec[5] = rs.getInt(7);
                return rec;
            }
            else
            {
                q = "SELECT district_data.* FROM district,district_data WHERE district.dist_id = district_data.dist_id "+
                    "and dist = \'"+name+"\'";   
                
                smt = c.prepareStatement(q);
                rs = smt.executeQuery();
                
                if(rs.next()){
                    
                int[] rec = new int[6];
                rec[0] = rs.getInt(2);
                rec[1] = rs.getInt(3);
                rec[2] = rs.getInt(4);
                rec[3] = rs.getInt(5);
                rec[4] = rs.getInt(6);
                rec[5] = rs.getInt(7);
                return rec;
                }
                else
                    System.out.println("Invlid input");
                return null;
            }
                    
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }
  
}

