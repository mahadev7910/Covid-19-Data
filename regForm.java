package typroject;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.DriverManager;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class regForm extends JFrame implements ActionListener {

    protected JTextField t1, t2, t3, t4, t5, t6;
    protected JTextField t7, t8, t9, t10, t11, t12, t13, t14, t15;
    protected JLabel jl1, jl2, jl3, jl4, jl5, jl6, jl7;
    protected JLabel jl8, jl9, jl10, jl11, jl12, jl13, jl14, jl15;
    protected JComboBox cg, ce, cf;
    protected JButton cancel, submit;

    public regForm() {

        setTitle("Volunteer Registration Form");

        // TextFields :
        t1 = new JTextField(16);
        t2 = new JTextField(16);
        t3 = new JTextField(16);
        t4 = new JTextField(16);
        t5 = new JTextField(16);
        t6 = new JTextField(16);
        t7 = new JTextField(16);
        t8 = new JTextField(16);
        t9 = new JTextField(16);
        t10 = new JTextField(16);
        t11 = new JTextField(16);
        t12 = new JTextField(16);
        t13 = new JTextField(16);
        t14 = new JTextField(16);
        t15 = new JTextField(16);

        // JLabels :
        jl1 = new JLabel("First Name");
        jl2 = new JLabel("Last Name");
        jl3 = new JLabel("Email");
        jl4 = new JLabel("Gender");
        jl5 = new JLabel("Date of Birth");
        jl6 = new JLabel("Mobile Number");
        jl7 = new JLabel("Address Line 1");
        jl8 = new JLabel("Address Line 2");
        jl9 = new JLabel("City");
        jl10 = new JLabel("District");
        jl11 = new JLabel("State");
        jl12 = new JLabel("Pincode");
        jl13 = new JLabel("Qualification");
        jl14 = new JLabel("Profession");
        jl15 = new JLabel("Availbility");

        // JComboBox :
        cg = new JComboBox(new String[]{"---", "Male", "Female", "Transgender"});
        ce = new JComboBox(new String[]{"---", "SSC", "HSC", "GRADUATE", "POST GRADUATE"});
        cf = new JComboBox(new String[]{"---", "Doctor", "Nurse", "Cleaner", "other"});

        t1.setPreferredSize(new Dimension(100, 32));

        // Font Of TextFields :
        Font f = new Font("Verdana", Font.BOLD, 15);
        t1.setFont(f);
        t2.setFont(f);
        t3.setFont(new Font("Verdana", Font.BOLD, 12));
        t4.setFont(f);
        t5.setFont(f);
        t6.setFont(f);
        t7.setFont(f);
        t8.setFont(f);
        t9.setFont(f);
        t10.setFont(f);
        t11.setFont(f);
        t12.setFont(f);
        t13.setFont(f);
        t14.setFont(f);
        t15.setFont(f);

        // Adding JLabels and JTextFileds into p1 :
        JPanel p1 = new JPanel();

        p1.setLayout(new GridLayout(10, 3, 15, 5));
        p1.setBackground(Color.LIGHT_GRAY);

        p1.add(jl1);
        p1.add(jl2);
        p1.add(jl3);
        p1.add(t1);
        p1.add(t2);
        p1.add(t3);
        p1.add(jl4);
        p1.add(jl5);
        p1.add(jl6);
        p1.add(cg);
        p1.add(t5);
        p1.add(t6);
        p1.add(jl7);
        p1.add(jl8);
        p1.add(jl9);
        p1.add(t7);
        p1.add(t8);
        p1.add(t9);
        p1.add(jl10);
        p1.add(jl11);
        p1.add(jl12);
        p1.add(t10);
        p1.add(t11);
        p1.add(t12);
        p1.add(jl13);
        p1.add(jl14);
        p1.add(jl15);
        p1.add(ce);
        p1.add(cf);
        p1.add(t15);

        // Submit Button :
        submit = new JButton("submit", new ImageIcon("/home/maddy/NetBeansProjects/TYProject/src/typroject/images/submit.png"));
        submit.setPreferredSize(new Dimension(110, 27));
        submit.setBorder(new LineBorder(Color.BLACK, 1));

        // Cancel Button :
        cancel = new JButton("Cancel", new ImageIcon("/home/maddy/NetBeansProjects/TYProject/src/typroject/images/cancel.png"));
        cancel.setPreferredSize(new Dimension(105, 26));
        cancel.setBorder(new LineBorder(Color.BLACK, 1));

        submit.addActionListener(this);
        cancel.addActionListener(this);
        // Adding p1 and submit and cancel button into p2 : 
        JPanel p2 = new JPanel();

        p2.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 30));
        p2.setBorder(new LineBorder(Color.BLACK, 2));
        p2.setPreferredSize(new Dimension(830, 500));
        p2.setBackground(Color.LIGHT_GRAY);
        p2.setBounds(16, 30, 830, 500);

        p2.add(p1);
        p2.add(submit);
        p2.add(cancel);

        // making JLabel and set Image on it :
        ImageIcon img = new ImageIcon("/home/maddy/NetBeansProjects/TYProject/src/typroject/images/download (2).jpg");
        Image dab = img.getImage();
        Image cdab = dab.getScaledInstance(828, 132, java.awt.Image.SCALE_SMOOTH);
        img = new ImageIcon(cdab);

        JLabel ad = new JLabel(img);
        ad.setBorder(new LineBorder(Color.BLACK, 1));
        ad.setBounds(16, 530, 830, 140);

        setLayout(null);
        getContentPane().setBackground(Color.GRAY);

        add(p2);
        add(ad);

        setVisible(true);
        setSize(860, 700);
        setLocation(200, 0);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    String fname, lname , city, dist, state, pin;
    static int cid = 1;
    
    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource() == cancel){
            dispose();
            new home();
            //new covidCenterData();.setVisible(true);
        }
        else
        if (ae.getSource() == submit) {
            
        System.out.println("Execute Listener");
        fname = t1.getText();
        lname = t2.getText();
        city = t9.getText();
        dist = t10.getText();
        state = t11.getText();
        pin = t12.getText();
       
        if (fname.equals("") || lname.equals("")) {

            new Dialog().error();
        }
        else{
             try{
                getData();
                
             }catch (SQLException ex) {
                System.out.println(ex);
              }
            }
       }
    }

    public void getData() throws SQLException {
        
        Connection c;
        PreparedStatement smt;

        try{
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "maddy", "maddy20");
            System.out.println("Connection Esthablished");

            String q = "INSERT INTO volunteer(cid,fname,lname,city,dist,state) values(?,?,?,?,?,?)";

            smt = c.prepareStatement(q);

            smt.setInt(1, cid++);
            smt.setString(2, fname);
            smt.setString(3, lname);
            smt.setString(4, city);
            smt.setString(5, dist);
            smt.setString(6, state);
            //smt.setInt(7, Integer.parseInt(pin));
            smt.addBatch();
            smt.executeBatch();
            c.close();
            new Dialog().success();

        } catch (ClassNotFoundException | NumberFormatException e) {

            System.out.println(e);
        }
        
    }
}

class mainRegForm {

    public static void main(String args[]) {

        new regForm();
    }
}
