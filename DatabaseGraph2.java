package covindata;

import java.awt.Color;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.border.LineBorder;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

class DatabaseGraph2 {
    
Connection con;
PreparedStatement smt;
dataClass dc[] = new dataClass[25];

public DatabaseGraph2(){
    
}
public DatabaseGraph2(String id){
    
    System.out.println("In Constructor........");

    try {

       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       Date d = sdf.parse("2020-04-26");

       Calendar c = Calendar.getInstance();
       c.setTime(d);
      // c.add(Calendar.DATE, 5); // Adding 5 day
       String cdate = sdf.format(c.getTime());
       //System.out.println(cdate);

       int cv = 21;

           Class.forName("org.postgresql.Driver");
           con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","maddy","maddy20");
           //System.out.println("Opened DB");
           
       for(int i = 0 ; i < 19 ; i++){

           //System.out.println("cdate = "+cdate);
           String q = "select * from state_data2 where state_code = \'"+id+"\'"+"and last_update = \'"+cdate+"\'";


           smt = con.prepareStatement(q);
           ResultSet rs = smt.executeQuery();

           if(rs.next()){

            dc[i] = new dataClass().getDataState(rs.getString(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getString(6));
            
            c.add(Calendar.DATE, cv);
            cdate = sdf.format(c.getTime());

           }
           else{
                System.out.println("No data availbe for given date :- ");
                break;
           }
       }
       
            int did = Integer.parseInt(id);
            
            for(int i = 0 ; i < 19 ; i++){
                
                //System.out.println("else of city in dataGraph2 = "+did);
                String q = "select * from district_data2 WHERE dist_id = \'"+did+"\'"+"and last_update = \'"+cdate+"\'";

                smt = con.prepareStatement(q);
                ResultSet rc = smt.executeQuery();

               if(rc.next()){

                   dc[i] = new dataClass().getDataDistrict(rc.getInt(1),rc.getInt(2),rc.getInt(3),rc.getInt(4),rc.getInt(5),rc.getString(6));
                   c.add(Calendar.DATE, cv);
                   cdate = sdf.format(c.getTime());

               }
               else{
                    System.out.println("Not Found....");
                    break;
                }
           }

   } catch (ParseException | SQLException | ClassNotFoundException  | NumberFormatException ex) {
       System.out.println(ex);
    }

}
     
public ChartPanel[] allGraph(){
    
        System.out.println("In deathGraph");
     
        DefaultCategoryDataset casesd,recoverd,deathd;
        
        ChartPanel pan1[] = new ChartPanel[4];
        casesd = new DefaultCategoryDataset();
        recoverd = new DefaultCategoryDataset();
        deathd = new DefaultCategoryDataset();
        
        for(int i = 0 ; i < 19 ; i++){
            casesd.setValue(dc[i].cases,"Cases",dc[i].date);
            recoverd.setValue(dc[i].recovered,"Cases",dc[i].date);
            deathd.setValue(dc[i].deaths,"Cases",dc[i].date);
            //System.out.println(cd[i].cases+" "+cd[i].date);
        }
        
        // Cases Graph 1 :-
        JFreeChart fc1 = ChartFactory.createLineChart("Confirmed Cases", "Date", "Cases", casesd,PlotOrientation.VERTICAL,true,true,true);
        
        CategoryPlot p1 = fc1.getCategoryPlot();
        // adjusting xAxis dates to fit :-
        org.jfree.chart.axis.CategoryAxis x1Axis = p1.getDomainAxis();
        x1Axis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        
        // customization :-
        p1.setRangeGridlinePaint(Color.BLUE);
        p1.setBackgroundPaint(Color.white);
        
        LineAndShapeRenderer renderer1 = new LineAndShapeRenderer();
 
        // sets paint color for each series
        renderer1.setSeriesPaint(0, Color.BLUE);
        
        p1.setRenderer(renderer1);

        p1.setRangeGridlinesVisible(true);
        p1.setDomainGridlinesVisible(false);
        //p1.setOutlinePaint(Color.BLUE);
        //p1.setOutlineStroke(new BasicStroke(2.0f));
        
        pan1[0] = new ChartPanel(fc1);
        
        pan1[0].setVisible(true);
        pan1[0].setPreferredSize(new Dimension(700,550));

        // Recovered Graph 2 :-
        JFreeChart fc2 = ChartFactory.createLineChart("Recovered Cases", "Date", "Cases", recoverd,PlotOrientation.VERTICAL,true,true,true);
       
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

        pan1[1] = new ChartPanel(fc2);
        
        pan1[1].setVisible(true);
        pan1[1].setPreferredSize(new Dimension(700,550));
        //pan1[1].setBorder(new LineBorder(Color.BLACK,1));
        
        // Deaths Graph 3 :-
        JFreeChart fc3 = ChartFactory.createLineChart("Deaths Cases", "Date", "Cases", deathd,PlotOrientation.VERTICAL,true,true,true);
       
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
        
        pan1[2] = new ChartPanel(fc3);
        
        pan1[2].setVisible(true);
        pan1[2].setPreferredSize(new Dimension(700,550));
        //pan1[2].setBorder(new LineBorder(Color.BLACK,1));
        
        // GRaph 4 :-
        
        DefaultCategoryDataset dcd = new DefaultCategoryDataset();
        
        for(int i = 0 ; i < 19 ; i++)
            dcd.setValue(dc[i].cases,"Cases",dc[i].date);
        
        for(int i = 0 ; i < 19 ; i++)
            dcd.setValue(dc[i].recovered,"Recovered",dc[i].date);
        
        for(int i = 0 ; i < 19 ; i++)
            dcd.setValue(dc[i].deaths,"Deaths",dc[i].date);
           
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
        
    return pan1;
}

}
