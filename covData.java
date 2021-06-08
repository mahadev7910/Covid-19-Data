package covindata;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.*;

public class covData extends javax.swing.JFrame implements ActionListener{

    Connection con1;
    PreparedStatement s;
    ResultSet r;
    String dd = null;
    int Uid;
    JMenuBar bar;
    JButton logout,update;
        
    public covData(){}
    
    public covData(int id,String name,String mail,int cid) {
        
        initComponents();
        
        userInfo(id,name,mail,cid);
        Uid = id;
        
        // System date :-
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        dd = f.format(new Date());
        System.out.println("d = "+dd);
        
        datet.setText(dd);
        datet.setEditable(false);
        setVisible(true);
        
        logout = new JButton(" Log Out    ");
        update = new JButton(" Update ");
        Font ff = new Font("serif",Font.BOLD,15);

        logout.setFont(ff);
        update.setFont(ff);
        
        logout.setForeground(Color.WHITE);
        update.setForeground(Color.WHITE);
        
        logout.setBackground(new Color(12,21,117));
        update.setBackground(new Color(12,21,117));
        
        logout.setBorder(new LineBorder(new Color(12,21,117),1));
        update.setBorder(new LineBorder(new Color(12,21,117),1));
        
        logout.addActionListener(this);
        update.addActionListener(this);
        bar = new JMenuBar();
        
        bar.setPreferredSize(new Dimension(11,30));
        bar.setBackground(new Color(12,21,117));
        
        bar.add(logout);
        bar.add(update);
        setJMenuBar(bar);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        uname = new javax.swing.JLabel();
        umail = new javax.swing.JLabel();
        userid = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cname = new javax.swing.JLabel();
        covid = new javax.swing.JLabel();
        cases = new javax.swing.JLabel();
        ct = new javax.swing.JTextField();
        recover = new javax.swing.JLabel();
        rt = new javax.swing.JTextField();
        deaths = new javax.swing.JLabel();
        dt = new javax.swing.JTextField();
        critical = new javax.swing.JLabel();
        vent = new javax.swing.JLabel();
        cct = new javax.swing.JTextField();
        ovt = new javax.swing.JTextField();
        dat = new javax.swing.JLabel();
        datet = new javax.swing.JTextField();
        submit = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(100, 0));
        setPreferredSize(new java.awt.Dimension(1020, 700));
        setSize(new java.awt.Dimension(900, 700));

        jPanel1.setBackground(new java.awt.Color(251, 209, 89));

        jLabel1.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        jLabel1.setText("Name :");

        jLabel2.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        jLabel2.setText("Covid Center ID :");

        jLabel3.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        jLabel3.setText("Email :");

        jLabel4.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        jLabel4.setText("User ID :");

        uname.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        uname.setText("Prathamesh Bhamare");

        umail.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        umail.setText("mahadev110631@gmail.com");

        userid.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        userid.setText("100");

        jLabel8.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        jLabel8.setText("Covid Center :");

        cname.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        cname.setText("Sahyadri Super Speciality Hospital");

        covid.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        covid.setText("11001");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(uname))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(covid)))
                .addGap(142, 142, 142)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(umail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userid)
                        .addGap(103, 103, 103))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cname)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(umail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(uname)
                        .addComponent(userid)))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8)
                    .addComponent(cname)
                    .addComponent(covid))
                .addGap(30, 30, 30))
        );

        cases.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        cases.setText("Cases :");

        ct.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        ct.setToolTipText("");
        ct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ctActionPerformed(evt);
            }
        });

        recover.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        recover.setText("Recovered :");

        rt.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        rt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rtActionPerformed(evt);
            }
        });

        deaths.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        deaths.setText("Deaths");

        dt.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        dt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dtActionPerformed(evt);
            }
        });

        critical.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        critical.setText("Critical :");

        vent.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        vent.setText("On Ventilator :");

        cct.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        cct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cctActionPerformed(evt);
            }
        });

        ovt.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        ovt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ovtActionPerformed(evt);
            }
        });

        dat.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        dat.setText("Date :");

        datet.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        datet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datetActionPerformed(evt);
            }
        });

        submit.setBackground(new java.awt.Color(92, 215, 28));
        submit.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        clear.setBackground(new java.awt.Color(244, 184, 12));
        clear.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        clear.setText("Clear");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        cancel.setBackground(new java.awt.Color(237, 72, 45));
        cancel.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/download (1).jpg"))); // NOI18N

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images (1).jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(critical)
                            .addComponent(cases))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ct, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                            .addComponent(cct))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(75, 75, 75)
                                .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(75, 75, 75)
                                .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(recover)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rt, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(vent)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ovt, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dat))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(167, 167, 167)
                                        .addComponent(deaths)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(dt, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(datet)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)))
                .addContainerGap(160, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cases)
                    .addComponent(ct, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(recover)
                    .addComponent(rt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deaths)
                    .addComponent(dt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(critical)
                    .addComponent(vent)
                    .addComponent(cct, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ovt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dat)
                    .addComponent(datet, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void actionPerformed(ActionEvent evt){
        
        if(evt.getSource() == logout){
            
            try{
                dispose();
                new MainPage();
            
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }   
  
        if(evt.getSource() == update){

            String q = "Select * from covid_center_data2 where cov_id = \'"+Integer.parseInt(covid.getText())+"\'" +"and last_update = \'"+dd+"\'"; 
            try {
                    s = con1.prepareStatement(q);
                    r = s.executeQuery();

                    if(r.next()){

                          JOptionPane.showMessageDialog(null,"Enter new Data","",JOptionPane.INFORMATION_MESSAGE);
                          submit.setText("Update");
                          
                          ct.setText(Integer.toString(r.getInt(2)));
                          rt.setText(Integer.toString(r.getInt(4)));
                          dt.setText(Integer.toString(r.getInt(5)));
                          
                    }else
                         JOptionPane.showMessageDialog(null, "No record found of "+dd, "", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception ex) {
             JOptionPane.showMessageDialog(null, "No Data availble for update", "", JOptionPane.INFORMATION_MESSAGE);
        }

        }

    }
        
    
     private void updateActionPerformed(java.awt.event.ActionEvent evt){
        
            
    }
    
    private void dtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dtActionPerformed

    private void rtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rtActionPerformed

    private void ctActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ctActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ctActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
                
        
        String cs, rec, de, cr,ovc;
        int c,r,d,vc,cc;
       
        ovc = ovt.getText();
        cr = cct.getText();
        de = dt.getText();
        cs = ct.getText();
        rec = rt.getText();
        
        if(cs.isEmpty() || rec.isEmpty() || de.isEmpty() ||  ovc.isEmpty() || cr.isEmpty())
            new Dialog().submitCovData();
        else
        {
            try{
                  c = Integer.parseInt(cs);
                  r = Integer.parseInt(rec);
                  d = Integer.parseInt(de);
                  vc = Integer.parseInt(ovc);
                  cc = Integer.parseInt(cr);
                  //System.out.println("cas rec de cr ovc "+c+" "+r+" "+d+" "+cc+" "+vc+" ");
                  if(c < 0 || r < 0 || d < 0 || vc < 0 || cc < 0)
                      new Dialog().errorCovData();
                  else
                      if(submit.getText().equals("Submit"))
                            insertCovData(c,r,d);
                  else
                      if(submit.getText().equals("Update"))
                          updateCovData();
                      
            }
            catch(Exception e){ new Dialog().errorCovData(); }
        }

    }//GEN-LAST:event_submitActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        clearText();
    }//GEN-LAST:event_clearActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        
         int r = JOptionPane.showConfirmDialog(null,"You really want to cancel ?","",JOptionPane.YES_NO_OPTION,1);
            if(r==0){
               dispose();
               new login(); 
            }
    }//GEN-LAST:event_cancelActionPerformed

    private void datetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_datetActionPerformed

    private void cctActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cctActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cctActionPerformed

    private void ovtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ovtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ovtActionPerformed

    
    void userInfo(int id,String name,String mail,int cid){
        
        try{
            Class.forName("org.postgresql.Driver");
            con1 = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","maddy","maddy20");
            //System.out.println("UserInfo connection eshtablished");
            
            String q1 = "SELECT * FROM covid_center2 WHERE cov_id = \'"+cid+"\'";
            s = con1.prepareStatement(q1);
            r = s.executeQuery();
            
            if(r.next()){
                
                int cii = r.getInt(2);
                covid.setText(Integer.toString(cii));
                //System.out.println(r.getString(3));
                cname.setText(r.getString(3));
                uname.setText(name);
                umail.setText(mail);
                userid.setText(Integer.toString(id));
            } 
            //con1.close();
        }
        catch(ClassNotFoundException | SQLException e){}    
}
     
    void insertCovData(int c,int r,int d) {
        
            Connection con;
            PreparedStatement smt;
            
            try {                                                 
                  Class.forName("org.postgresql.Driver");
                  con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","maddy","maddy20");
                  //System.out.println("Connection Eshtablished");
                  
                  String q = "INSERT INTO covid_center_data2(cov_id,cases,active,recovered,deaths) values(?,?,?,?,?)";            
                  
                  
                  smt = con.prepareStatement(q);
                  int cid = Integer.parseInt(covid.getText());
                  smt.setInt(1,cid);
                  smt.setInt(2,c);
                  //recovered  = cases - (recovered + deaths )
                  int a = c - (r + d);
                  smt.setInt(3,a);
                  smt.setInt(4,r);
                  smt.setInt(5,d);
                  
                  // Both statement must use during insert or update :-
                  smt.addBatch();
                  smt.executeBatch();
                  
                  new Dialog().successRecord();
                  clearText();
                  con.close();
            }
            catch(ClassNotFoundException | SQLException e)
            { System.out.println("Already Inserted Today's Records");
              new Dialog().alreadyInsertCovData();
            }            
    }
    
    void updateCovData(){
        
        try{
            String q = "UPDATE covid_center_data2 "+
                        "SET cases = ?, active = ?,Recovered = ?,deaths = ?"+
                        "WHERE cov_id = \'"+Integer.parseInt(covid.getText())+"\'";
            
            s = con1.prepareStatement(q);
            s.setInt(1,Integer.parseInt(ct.getText()));
            s.setInt(3,Integer.parseInt(rt.getText()));
            s.setInt(4,Integer.parseInt(dt.getText()));
            int urec = Integer.parseInt(ct.getText()) - ( Integer.parseInt(rt.getText()) + Integer.parseInt(dt.getText()));
            s.setInt(2,urec);
            
            s.addBatch();
            s.executeBatch();
            JOptionPane.showMessageDialog(null,"Successfully Updated","",JOptionPane.INFORMATION_MESSAGE);
            
            } catch (SQLException ex) {
                System.out.println(ex);
            }
    }
    
    void clearText(){
        
        ct.setText("");
        rt.setText("");
        dt.setText("");
        ovt.setText("");
        cct.setText("");
    }
    
    public static void main(String args[]) {
       
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(covData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(covData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(covData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(covData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new covData(100,"mahesh","",11001);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JLabel cases;
    private javax.swing.JTextField cct;
    private javax.swing.JButton clear;
    private javax.swing.JLabel cname;
    private javax.swing.JLabel covid;
    private javax.swing.JLabel critical;
    private javax.swing.JTextField ct;
    private javax.swing.JLabel dat;
    private javax.swing.JTextField datet;
    private javax.swing.JLabel deaths;
    private javax.swing.JTextField dt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField ovt;
    private javax.swing.JLabel recover;
    private javax.swing.JTextField rt;
    private javax.swing.JButton submit;
    private javax.swing.JLabel umail;
    private javax.swing.JLabel uname;
    private javax.swing.JLabel userid;
    private javax.swing.JLabel vent;
    // End of variables declaration//GEN-END:variables

}
