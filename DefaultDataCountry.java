package covindata;

import java.awt.Color;
import java.awt.Dimension;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import javax.swing.border.LineBorder;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class DefaultDataCountry {
    
    protected int cases;
    protected int active;
    protected int recovered;
    protected int deaths;
    protected float rrate;
    protected float drate;
    protected String update;
    
    Connection con;
    PreparedStatement smt;
    dataClass countryData[] = new dataClass[21];
    
    public DefaultDataCountry(){
        
        // To get System Date :-
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String sdate = f.format(Calendar.getInstance().getTime());
        
        // Default Date Present in DB :-
        String mdate = "2021-05-14";
                
        try{
            
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","maddy","maddy20");
            //System.out.println("Connection Eshtablished");
            
            // Search into Ind weather availble or NOT :-
            String q = "SELECT * FROM Country_data2 WHERE last_update = \'"+mdate+"\'";
            
            smt = con.prepareStatement(q);
            ResultSet rs = smt.executeQuery();
            
            if(rs.next()){
                
                cases = rs.getInt(2);
                recovered = rs.getInt(3);
                deaths = rs.getInt(5);
                update = rs.getString(6);

                float rt = (float)recovered/cases;  
                rrate = (int) (rt*100);
                
                rt = (float)deaths/cases;  
                drate = (int) (rt*100);
                
            }
         }catch(ClassNotFoundException | SQLException e){}
        
    }  
    
    public ChartPanel[] allGraph() throws ClassNotFoundException, SQLException{
           
        // For LineChart :-
        DefaultCategoryDataset casesd,recoverd,deathd;

        casesd = new DefaultCategoryDataset();
        recoverd = new DefaultCategoryDataset();
        deathd = new DefaultCategoryDataset();
        
      try{
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date d = f.parse("2020-03-30");

            Calendar c = Calendar.getInstance();
            c.setTime(d);
            // c.add(Calendar.DATE, 5); // Adding 5 day
            String cdate = f.format(c.getTime());
            
            int cv = 20;

       for(int i = 0 ; i < 21 ; i++){

           //System.out.println("cdate = "+cdate);
           String q = "select * from country_data WHERE last_update = \'"+cdate+"\'";

           smt = con.prepareStatement(q);
           ResultSet rs = smt.executeQuery();
           
           if(rs.next()){

            countryData[i] = new dataClass(rs.getInt(2),rs.getInt(3),rs.getInt(5),rs.getString(6));
            // inserting Values into CategoryDataset for LineChart :-
            casesd.setValue(countryData[i].cases,"Cases",countryData[i].date);
            recoverd.setValue(countryData[i].recovered,"Cases",countryData[i].date);
            deathd.setValue(countryData[i].deaths,"Cases",countryData[i].date);
            c.add(Calendar.DATE, cv);
            cdate = f.format(c.getTime());

           }
       }
       
    }catch(Exception e){}
      
//***************************************** LineChart ******************************************************************************      
        
      
// Createing Graphs Here :-
        ChartPanel pan1[] = new ChartPanel[4];
        
        JFreeChart fc1 = ChartFactory.createLineChart("Total Cases", "Date", "Cases", casesd,PlotOrientation.VERTICAL,false,true,false);
        
        CategoryPlot p1 = fc1.getCategoryPlot();
       
        // adjusting xAxis dates to fit :-
        org.jfree.chart.axis.CategoryAxis x1Axis = p1.getDomainAxis();
        x1Axis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        
        p1.setRangeGridlinePaint(Color.BLUE);
        p1.setBackgroundPaint(Color.white);
        
        LineAndShapeRenderer renderer1 = new LineAndShapeRenderer();
 
        // sets paint color for each series
        renderer1.setSeriesPaint(0, Color.BLUE);
        
        p1.setRenderer(renderer1);

        p1.setRangeGridlinesVisible(true);
        p1.setDomainGridlinesVisible(false);
       
        pan1[0] = new ChartPanel(fc1);
        
        pan1[0].setVisible(true);
        pan1[0].setPreferredSize(new Dimension(700,450));
        //pan1[0].setBorder(new LineBorder(Color.BLACK,1));
        
        // Recovered Graph 2 :-
        JFreeChart fc2 = ChartFactory.createLineChart("Recovered Cases", "Date", "Recovered", recoverd,PlotOrientation.VERTICAL,false,true,false);
       
        CategoryPlot p2 = fc2.getCategoryPlot();

        // adjusting xAxis dates to fit :-
        org.jfree.chart.axis.CategoryAxis x2Axis = p2.getDomainAxis();
        x2Axis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        
        // customization :-
        renderer1 = new LineAndShapeRenderer();
 
        // sets paint color for each series
        renderer1.setSeriesPaint(0, Color.GREEN);
        p2.setRenderer(renderer1);
        
        p2.setRangeGridlinesVisible(true);
        p2.setDomainGridlinesVisible(false);
        p2.setRangeGridlinePaint(Color.GREEN);
        p2.setBackgroundPaint(Color.WHITE);
        
        p2.setRangeGridlinePaint(Color.BLUE);
        p2.setBackgroundPaint(Color.WHITE);

        pan1[1] = new ChartPanel(fc2);
        
        pan1[1].setVisible(true);
        pan1[1].setPreferredSize(new Dimension(700,450));
        //pan1[1].setBorder(new LineBorder(Color.BLACK,1));
        
        // Deaths Graph 3 :-
        JFreeChart fc3 = ChartFactory.createLineChart("Deaths Cases", "Date", "Deaths", deathd,PlotOrientation.VERTICAL,false,true,false);
       
        CategoryPlot p3 = fc3.getCategoryPlot();
        
        // adjusting xAxis dates to fit :-
        org.jfree.chart.axis.CategoryAxis x3Axis = p3.getDomainAxis();
        x3Axis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        
        // customization :-
        renderer1 = new LineAndShapeRenderer();
 
        // sets paint color for each series
        renderer1.setSeriesPaint(0, Color.RED);
        
        p3.setRenderer(renderer1);
        p3.setRangeGridlinePaint(Color.RED);
        p3.setBackgroundPaint(Color.WHITE);
        p3.setRangeGridlinesVisible(true);
        p3.setDomainGridlinesVisible(false);
        
        p3.setRangeGridlinePaint(Color.RED);
        p3.setBackgroundPaint(Color.WHITE);
        pan1[2] = new ChartPanel(fc3);
        
        pan1[2].setVisible(true);
        pan1[2].setPreferredSize(new Dimension(700,450));
        //pan1[2].setBorder(new LineBorder(Color.BLACK,1));
        
        // Graph 4 :-
        
        DefaultCategoryDataset dcd = new DefaultCategoryDataset();
        
        for(int i = 0 ; i < 21 ; i++)
            dcd.setValue(countryData[i].cases,"Cases",countryData[i].date);
        
        for(int i = 0 ; i < 21 ; i++)
            dcd.setValue(countryData[i].recovered,"Recovered",countryData[i].date);
        
        for(int i = 0 ; i < 21 ; i++)
            dcd.setValue(countryData[i].deaths,"Deaths",countryData[i].date);
           
        JFreeChart fc4 = ChartFactory.createLineChart("Comparison", "Date", "Cases", dcd, PlotOrientation.VERTICAL, true, true, false);
        
        CategoryPlot p4 = fc4.getCategoryPlot();
        // adjusting xAxis dates to fit :-
        org.jfree.chart.axis.CategoryAxis x4Axis = p4.getDomainAxis();
        x4Axis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        
        // customization :-
        renderer1 = new LineAndShapeRenderer();
 
        // sets paint color for each series
        renderer1.setSeriesPaint(0, Color.BLUE);
        renderer1.setSeriesPaint(1, Color.GREEN);
        renderer1.setSeriesPaint(2, Color.RED);
        p4.setRenderer(renderer1);
        
        p4.setRangeGridlinePaint(Color.BLACK);
        p4.setBackgroundPaint(Color.WHITE);
        p4.setRangeGridlinesVisible(true);
        p4.setDomainGridlinesVisible(false);
        
        pan1[3] = new ChartPanel(fc4);
        
        pan1[3].setVisible(true);
        pan1[3].setPreferredSize(new Dimension(700,550));
        //pan1[3].setBorder(new LineBorder(Color.BLACK,1));
        
        
//************************************************ END LineChart *************************************************************************        
    
 return pan1;
}

public ChartPanel pieGraph(){
    
    DefaultPieDataset pieData = new DefaultPieDataset();

    pieData.setValue("Maharashtra",5170798);                                                                                                             
    pieData.setValue("Mizoram", 8377);                                                                                                           
    pieData.setValue("Jammu and Kashmir", 236790);                                                                                                       
    pieData.setValue("Hariyana",675636);                                                                                                                
    pieData.setValue("Bihar",637679);                                                                                                                   
    pieData.setValue("Chandigarh",54043);                                                                                                              
    pieData.setValue("Kerala",2085584);                                                                                                                  
    pieData.setValue("Ladakh",15916);                                                                                                                  
    pieData.setValue("Lakshdweep",4568);                                                                                                              
    pieData.setValue("Puducherry",80947);                                                                                                              
    pieData.setValue("West Bengal",1094736);                                                                                                             
    pieData.setValue("Uttarakhand",277585);                                                                                                             
    pieData.setValue("Arunachal Pradesh", 21110);                                                                                                       
    pieData.setValue("Meghalaya",22203);                                                                                                               
    pieData.setValue("Gujrat",735186);                                                                                                                  
    pieData.setValue("Odisa", 588687);                                                                                                                   
    pieData.setValue("Nagaland", 17531);                                                                                                                
    pieData.setValue("Rajstan",835625);                                                                                                                 
    pieData.setValue("Assam",2079);                                                                                                                   
    pieData.setValue("Andaman and Nicobar",6542);                                                                                                     
    pieData.setValue("Himachal Pradesh",144148);                                                                                                        
    pieData.setValue("Chattisgarh",891670);                                                                                                             
    pieData.setValue(" Jharkhand", 306248);                                                                                                               
    pieData.setValue("Dadra and Nagar Haveli",9486);                                                                                                  
    pieData.setValue("Andhra Pradesh",1388803);                                                                                                          
    pieData.setValue("Karnataka",2130231);                                                                                                               
    pieData.setValue("Madhya Pradesh", 716708);                                                                                                          
    pieData.setValue("Tamil Nadu", 1529298);                                                                                                              
    pieData.setValue("Uttar Pradesh", 1570161);                                                                                                           
    pieData.setValue("Punjab",483984);                                                                                                                  
    pieData.setValue("Tripura",39603);     
        
    JFreeChart pieChart = ChartFactory.createPieChart3D("StateWise Cases", pieData, true, true, Locale.UK);//createPieChart("State Data", pieData, true, true, true);

    PiePlot3D pie1 = (PiePlot3D) pieChart.getPlot();

    ChartPanel piePanel;
    piePanel = new ChartPanel(pieChart);
    piePanel.setPreferredSize(new Dimension(700,550));
    pie1.setBackgroundPaint(Color.WHITE);
    //piePanel.setBorder(new LineBorder(Color.BLACK,1));
    
    return piePanel;
}
}
