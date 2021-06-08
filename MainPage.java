package covindata;

import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import javax.swing.*;
import javax.swing.border.LineBorder;
import org.jfree.chart.ChartPanel;
import java.awt.event.*;

public class MainPage extends JFrame implements ActionListener {
    
    JPanel panel,homeP,statep;
    JButton jb,js;
    JTextField searchBar;
    JLabel cases,recover,death,l1,l2,l3,cper,rper,dper;
    JLabel jBack,jl,staten,stamp;
    ImageIcon img1,img2;
    Image dab1,cdab1,dab2,cdab2;
    JButton m1,m2,m3,m4;
    JMenuBar bar;
    ChartPanel gp[] = new ChartPanel[5];
    ChartPanel piep;
    
    public MainPage() throws ClassNotFoundException, SQLException, ParseException{
       
        // Panel for Handle Scrolling :-
        panel=new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new GridLayout(11,1,0,20));

        // Panel to add Home Page Components :-
        homeP = new JPanel();

        homeP.setSize(1200,500);
        homeP.setVisible(true);
        homeP.setLocation(0,0);
        homeP.setLayout(null);              
        
        // changing Size Of the Image for fit into JButton;
        img1 = new ImageIcon("/home/maddy/NetBeansProjects/CovIndata/src/images/download.jpg");
        dab1 = img1.getImage();
        cdab1 = dab1.getScaledInstance(1165,150,java.awt.Image.SCALE_SMOOTH);
        img1 = new ImageIcon(cdab1);

        jb = new JButton(img1);
        jb.setBorder(new LineBorder(Color.BLACK,2));
        jb.addActionListener(this);
        
        //Frame Background color :-
        getContentPane().setBackground(Color.WHITE);//new Color(12,21,117));//(255,255,255));
        homeP.setBackground(Color.WHITE);
        
        // Labels For Data :-
        cases = new JLabel("TOTAL CASES",JLabel.CENTER);
        recover = new JLabel("RECOVERED",JLabel.CENTER);
        death = new JLabel("DEATHS",JLabel.CENTER);

        l1 = new JLabel("",JLabel.CENTER);
        l2 = new JLabel("",JLabel.CENTER);
        l3 = new JLabel("",JLabel.CENTER);

        cper = new JLabel("",JLabel.CENTER);
        rper = new JLabel("",JLabel.CENTER);
        dper = new JLabel("",JLabel.CENTER);

        cases.setFont(new Font("Verdana",Font.BOLD,23));
        recover.setFont(new Font("Verdana",Font.BOLD,23));
        death.setFont(new Font("Verdana",Font.BOLD,23));

        l1.setFont(new Font("Verdana",Font.BOLD,27));
        l2.setFont(new Font("Verdana",Font.BOLD,27));
        l3.setFont(new Font("Verdana",Font.BOLD,27));

        cper.setFont(new Font("Verdana",Font.BOLD,18));
        rper.setFont(new Font("Verdana",Font.BOLD,18));
        dper.setFont(new Font("Verdana",Font.BOLD,18));

        l1.setBorder(new LineBorder(Color.BLACK,1));
        l2.setBorder(new LineBorder(Color.BLACK,1));
        l3.setBorder(new LineBorder(Color.BLACK,1));

        jb.setBounds(7,77,1165,150);
        
        // Flag Setting :-
        ImageIcon img = new ImageIcon("/home/maddy/NetBeansProjects/CovIndata/src/images/india.png");
        Image dab = img.getImage();
        Image cdab = dab.getScaledInstance(100, 95, java.awt.Image.SCALE_SMOOTH);
        img = new ImageIcon(cdab);
        JLabel ind = new JLabel(img);
        
        // adding flag into panel :-
        ind.setBounds(538,216,100,95);       
        homeP.add(ind);
        
        // Blue Panel for name :-
        statep = new JPanel();
        statep.setBounds(5,300,1170,40);
        statep.setBackground(new Color(12,21,117));
        
        staten = new JLabel("INDIA",JLabel.CENTER);
        staten.setForeground(Color.WHITE);
        staten.setFont(new Font("Verdana",Font.BOLD,25));
        //staten.setBounds(500,450,100, 50);
        statep.add(staten);
        homeP.add(statep);
        
        // last update Label for TIMESTAMP :-
        
        stamp = new JLabel(" time stamp : ");
        
        // setting position of timeStamp :-
        
        stamp.setBounds(445,460,300,80);
        
        // setting data showing labels :-
        cases.setBounds(130,372,270,30);
        l1.setBounds(130,371,260,100);
        cper.setBounds(130,440,270,25);

        recover.setBounds(437,372,270,30);
        l2.setBounds(437,371,270,100);
        rper.setBounds(437,440,270,25);

        death.setBounds(740,372,270,30);
        l3.setBounds(740,371,270,100);
        dper.setBounds(740,440,270,25);
                        
        // adding components into HomePanel :-
        homeP.add(jb);
        homeP.add(cases);
        homeP.add(recover);
        homeP.add(death);
        homeP.add(l1);
        homeP.add(l2);
        homeP.add(l3);
        homeP.add(cper);
        homeP.add(rper);
        homeP.add(dper);
        homeP.add(stamp);
        
        // setting For Adjusting ScrollPane into Frame :-
        int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
        int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS; 
        JScrollPane jsp=new JScrollPane(panel,v,h);
        jsp.setPreferredSize(new Dimension(700,700));
 
        // Adding Panels into Panel for Scrolling purpose :-
        panel.add(homeP);
        menuBar();
        searchBar();
        
      
    // Adding Country Data into Frame :-

    DefaultDataCountry cdata = new DefaultDataCountry();

       if(cdata == null)
           new Dialog().invalidSearch();
       else{

        l1.setText(Integer.toString(cdata.cases));
        l2.setText(Integer.toString(cdata.recovered));
        l3.setText(Integer.toString(cdata.deaths));
        rper.setText(Float.toString(cdata.rrate)+"%");
        dper.setText(Float.toString(cdata.drate)+"%");        
        stamp.setText("Last updated : "+cdata.update+" , 17:05 IST");
        piep = cdata.pieGraph();
        panel.add(piep);
        
        gp = cdata.allGraph();
        panel.add(gp[0]);
        panel.add(gp[1]);
        panel.add(gp[2]);
        panel.add(gp[3]);
        
        // JFrame Setting :-
        add(jsp);
        setVisible(true);
        setSize(1200,740);
        setLocation(60,0);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    
    }
}
  
    public void menuBar(){

        bar = new JMenuBar();

        m1 = new JButton("  Login   ");
        m2 = new JButton(" States   ");
        //m3 = new JButton(" Cities   ");
        m4 = new JButton(" About");


        Font ff = new Font("serif",Font.BOLD,15);

        m1.setFont(ff);
        m2.setFont(ff);
        //m3.setFont(ff);
        m4.setFont(ff);

        //Color c = new Color(255,204,51);

        m1.setForeground(Color.WHITE);
        m2.setForeground(Color.WHITE);
        //m3.setForeground(Color.WHITE);
        m4.setForeground(Color.WHITE);

        m1.setBackground(new Color(12,21,117));
        m2.setBackground(new Color(12,21,117));
        //m3.setBackground(new Color(12,21,117));
        m4.setBackground(new Color(12,21,117));

        m1.setBorder(new LineBorder(new Color(12,21,117),1));
        m2.setBorder(new LineBorder(new Color(12,21,117),1));
        //m3.setBorder(new LineBorder(new Color(12,21,117),1));
        m4.setBorder(new LineBorder(new Color(12,21,117),1));
        
        m1.addActionListener(this);
        m2.addActionListener(this);

        bar.add(m1);  bar.add(m2); 
        bar.add(m4);

        bar.setPreferredSize(new Dimension(1200,30));
        bar.setBackground(new Color(12,21,117));

        setJMenuBar(bar);

    }

    public void searchBar(){

        searchBar = new JTextField("  SEARCH BAR",25);

        searchBar.setFont(new Font("serif",Font.BOLD,15));
        searchBar.setBorder(new LineBorder(new Color(0,0,0),2));
        //searchBar.setBackground(new Color(0,0,0,80));
        searchBar.setForeground(Color.BLACK);//new Color(255,204,51));

        js = new JButton(new ImageIcon("/home/maddy/NetBeansProjects/CovIndata/src/images/search.png"));
        js.setBackground(new Color(255,204,51));
        js.setBorder(new LineBorder(Color.BLACK,2));

        searchBar.setBounds(350,0,400,45);
        js.setBounds(750,0,50,46);

        js.addActionListener(this);

        JPanel sp = new JPanel();
        sp.setLayout(null);		
        sp.setBackground(new Color(0,0,0));
        sp.setOpaque(false);

        sp.add(searchBar);
        sp.add(js);
        sp.setBounds(0,10,1200,45);

        homeP.add(sp);
    }
    
    public void addGraph(String stcode){
        
        // Removing previous Graphs From panel :-
        panel.remove(piep);
        panel.remove(gp[0]);
        panel.remove(gp[1]);
        panel.remove(gp[2]);
        panel.remove(gp[3]);
        
        // Adding Graphs into frame :-
        gp = new DatabaseGraph2(stcode).allGraph();
        panel.add(gp[0]);
        panel.add(gp[1]);
        panel.add(gp[2]);
        panel.add(gp[3]);
        
    }
    
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == jb){

            hide();
            new regForm();

        }
        if(ae.getSource() == m1){

            hide();
            new login();

        }
        if(ae.getSource() == m2){

            hide();
            new stateTableData();
        }
        if(ae.getSource() == js){

           dataClass r = new search2().searchData(searchBar.getText());

           if(r == null)
               new Dialog().invalidSearch();
           else{

            l1.setText(Integer.toString(r.cases));
            l2.setText(Integer.toString(r.recovered));
            l3.setText(Integer.toString(r.deaths));
            rper.setText(Float.toString(r.rrate)+"%");
            dper.setText(Float.toString(r.drate)+"%");
            staten.setText(searchBar.getText());
            stamp.setText("Last updated: "+r.date+", 08:00 IST");
            addGraph(r.stcode);
           }
        }

    }
       
    public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException{
        
        new MainPage();
    }
}
