package covindata;

class dataClass {

    String name;
    String stcode;
    int did;
    int cases;
    int active;
    int recovered;
    int deaths;
    float rrate;
    float drate;
    String date;

    public dataClass(){
        
        name = null;
        stcode = null;
        cases = 0;
        active = 0;
        recovered = 0;
        deaths = 0;
        date = "";
    }
    
    public dataClass(int ca,int re,int de,String dd){
    
        cases = ca;
        recovered = re;
        deaths = de;
        date = dd;
    }
    
    public dataClass(String na,String code,int ca,int ac,int re,int de,String dd){
    
        name = na;
        stcode = code;
        cases = ca;
        active = ac;
        recovered = re;
        deaths = de;
        date = dd;
    }
    
    public dataClass getDataState(String code,int ca,int ac,int re,int de,String dd){
    
        stcode = code;
        cases = ca;
        active = ac;
        recovered = re;
        deaths = de;
        date = dd;
        
        return this;
    }
    
    public dataClass getDataDistrict(int id,int ca,int ac,int re,int de,String dd){
    
        did = id;
        cases = ca;
        active = ac;
        recovered = re;
        deaths = de;
        date = dd;
        
        return this;
    }
    
    
}/*
    public void insertStateTable(){
     
    try{
        Connection con;
        PreparedStatement smt;
        
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","maddy","maddy20");
    
        BufferedReader br = new  BufferedReader(new FileReader("/home/maddy/NetBeansProjects/TYProject/src/typroject/stateName.txt"));
        
        String d = "2021-05-14",line,rec[];
        dataClass dc[] = null;
        ResultSet rs;
        int i = 0;
        
        
        while((line = br.readLine()) != null){
            
            rec = line.split(",");
            
            String q = "SELECT * FROM state_data2 WHERE state_code = \'"+rec[0]+"\'"+"and last_update = \'"+d+"\'";
            
            smt = con.prepareStatement(q);
            rs = smt.executeQuery();
            
            dc[i] = new stateDataClass(rs.getString(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5));
            i++;
            
        }
        
        System.out.println("state data :-");
        for(int j=0 ; j<i ; j++){
            
            System.out.println(dc[j].stcode+" "+dc[j].cases+" "+dc[j].active+" "+dc[j].recovered+" "+dc[j].deaths);
        }
    }catch( IOException | ClassNotFoundException | SQLException e){
        
        System.out.println(e);
    }    
    
    }
    
    public static void main(String[] args){
        
        new stateDataClass().insertStateTable();
    }
        
}
*/