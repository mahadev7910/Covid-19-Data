package typroject;

import java.sql.*;

class covidCenterData extends javax.swing.JFrame {
    
    public covidCenterData(){}
    
    public covidCenterData(int id,String name,String mail,int cid) {
        initComponents();
        userInfo(id,name,mail,cid);
        setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();

        jMenuBar1.setBackground(new java.awt.Color(219, 96, 40));

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 767, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(253, 236, 139));
        setLocation(new java.awt.Point(200, 0));
        setPreferredSize(new java.awt.Dimension(1020, 598));
        setSize(new java.awt.Dimension(900, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(253, 236, 163));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 2, 1, new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(860, 160));

        jLabel1.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        jLabel1.setText("Name :");
        jLabel1.setPreferredSize(new java.awt.Dimension(60, 20));

        jLabel2.setFont(new java.awt.Font("URW Palladio L", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel3.setText("Email :");

        jLabel4.setFont(new java.awt.Font("URW Palladio L", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel5.setText("UID :");

        jLabel6.setFont(new java.awt.Font("URW Palladio L", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel7.setText("Covid Center ID :");

        jLabel8.setFont(new java.awt.Font("URW Palladio L", 1, 18)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel9.setText(" Center Name :");

        jLabel10.setBackground(new java.awt.Color(252, 253, 139));
        jLabel10.setFont(new java.awt.Font("URW Palladio L", 1, 18)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel11.setText("City :");

        jLabel12.setFont(new java.awt.Font("URW Palladio L", 1, 18)); // NOI18N
        jLabel12.setText("Pune");

        jLabel20.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        jLabel20.setText("jLabel20");

        jLabel22.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        jLabel22.setText("jLabel22");

        jLabel23.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        jLabel23.setText("jLabel23");

        jLabel24.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        jLabel24.setText("jLabel24");

        jLabel25.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        jLabel25.setText("jLabel25");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(54, 54, 54)
                .addComponent(jLabel2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel4)
                        .addGap(127, 127, 127)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel20)
                        .addComponent(jLabel3)
                        .addComponent(jLabel5)
                        .addComponent(jLabel22)
                        .addComponent(jLabel25))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel6)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(jLabel23)
                        .addComponent(jLabel9)
                        .addComponent(jLabel11))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel8))
                    .addComponent(jLabel12)
                    .addComponent(jLabel24))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 114));

        jLabel13.setFont(new java.awt.Font("Ubuntu Light", 1, 20)); // NOI18N
        jLabel13.setText("Confirmed Cases :");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 157, -1, -1));

        jLabel14.setFont(new java.awt.Font("Ubuntu Light", 1, 20)); // NOI18N
        jLabel14.setText("Recovered Cases:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 157, -1, -1));

        jLabel15.setFont(new java.awt.Font("Ubuntu Light", 1, 20)); // NOI18N
        jLabel15.setText("Deaths :");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(658, 157, -1, -1));

        jLabel16.setFont(new java.awt.Font("Ubuntu Light", 1, 20)); // NOI18N
        jLabel16.setText("Active Cases   :");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 231, -1, -1));

        jTextField4.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        jTextField4.setPreferredSize(new java.awt.Dimension(100, 30));
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 229, -1, -1));

        jLabel17.setFont(new java.awt.Font("Ubuntu Light", 1, 20)); // NOI18N
        jLabel17.setText("Critical  :");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(368, 231, -1, -1));

        jTextField5.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        jTextField5.setPreferredSize(new java.awt.Dimension(100, 30));
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 229, -1, -1));

        jLabel18.setFont(new java.awt.Font("Ubuntu Light", 1, 20)); // NOI18N
        jLabel18.setText("Date :");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(669, 231, -1, -1));

        jTextField6.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        jTextField6.setPreferredSize(new java.awt.Dimension(100, 30));
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(733, 230, -1, -1));

        jTextField7.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        jTextField7.setPreferredSize(new java.awt.Dimension(100, 30));
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 155, -1, -1));

        jTextField8.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jTextField8.setPreferredSize(new java.awt.Dimension(100, 30));
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(487, 155, -1, -1));

        jTextField9.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jTextField9.setPreferredSize(new java.awt.Dimension(100, 30));
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(738, 155, -1, -1));

        jButton1.setBackground(new java.awt.Color(28, 108, 158));
        jButton1.setFont(new java.awt.Font("Ubuntu Light", 1, 16)); // NOI18N
        jButton1.setText("Submit");
        jButton1.setBorder(null);
        jButton1.setPreferredSize(new java.awt.Dimension(85, 30));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(278, 338, -1, -1));

        jButton2.setBackground(new java.awt.Color(238, 241, 102));
        jButton2.setFont(new java.awt.Font("Ubuntu Light", 1, 17)); // NOI18N
        jButton2.setText("Reset");
        jButton2.setBorder(null);
        jButton2.setPreferredSize(new java.awt.Dimension(90, 30));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(411, 337, -1, -1));

        jButton3.setBackground(new java.awt.Color(212, 34, 76));
        jButton3.setFont(new java.awt.Font("Ubuntu Light", 1, 17)); // NOI18N
        jButton3.setForeground(new java.awt.Color(12, 23, 26));
        jButton3.setText("Cancel");
        jButton3.setBorder(null);
        jButton3.setPreferredSize(new java.awt.Dimension(90, 30));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(549, 337, -1, -1));

        jLabel21.setBackground(new java.awt.Color(32, 23, 14));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/typroject/images/download (1).jpg"))); // NOI18N
        jLabel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 535, -1));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/typroject/images/images (1).jpg"))); // NOI18N
        jLabel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 420, 450, 110));

        jMenuBar2.setBackground(new java.awt.Color(250, 195, 116));
        jMenuBar2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jMenuBar2.setPreferredSize(new java.awt.Dimension(72, 35));

        jMenu3.setForeground(new java.awt.Color(23, 17, 4));
        jMenu3.setText("Log Out");
        jMenu3.setFont(new java.awt.Font("URW Palladio L", 1, 17)); // NOI18N
        jMenuBar2.add(jMenu3);

        setJMenuBar(jMenuBar2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed

    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
   
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
   
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
     
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    
        String cs, rec, de, ac, cr;
        int c,r,d,a,cc;
        
        ac = jTextField4.getText();
        cr = jTextField5.getText();
        de = jTextField9.getText();
        cs = jTextField7.getText();
        rec = jTextField8.getText();
        
        if(cs.isEmpty() || rec.isEmpty() || de.isEmpty() || ac.isEmpty() || cr.isEmpty())
            new Dialog().submitCovData();
        else
        {
            try{
                  c = Integer.parseInt(cs);
                  r = Integer.parseInt(rec);
                  d = Integer.parseInt(de);
                  a = Integer.parseInt(ac);
                  cc = Integer.parseInt(cr);
                  
                  if(c < 0 || r < 0 || d < 0 || a < 0 || cc < 0)
                      new Dialog().errorCovData();
                  else
                      insertCovData(c,a,r,d);
                      
            }
            catch(Exception e){ new Dialog().errorCovData(); }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

            new Dialog().cancelCovData();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        clearText();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed
    
     void userInfo(int id,String name,String mail,int cid){
        
        Connection con1;
        PreparedStatement s;
        
        try{
            
            Class.forName("org.postgresql.Driver");
            con1 = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","maddy","maddy20");
            System.out.println("UserInfo connection eshtablished");
            
            String q1 = "SELECT * FROM covid_center WHERE cov_id = \'"+cid+"\'";
            s = con1.prepareStatement(q1);
            ResultSet r = s.executeQuery();
            
            if(r.next()){
                
                int cii = r.getInt(2);
                jLabel24.setText(Integer.toString(cii));
                System.out.println(r.getString(3));
                jLabel23.setText(r.getString(3));
                jLabel20.setText(name);
                jLabel22.setText(mail);
                jLabel25.setText(Integer.toString(id));
            } 
            con1.close();
        }
        catch(ClassNotFoundException | SQLException e){}    
}
     
    void insertCovData(int c,int a,int r,int d) {
        
            Connection con;
            PreparedStatement smt;
            
            try {
                  Class.forName("org.postgresql.Driver");
                  con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","maddy","maddy20");
                  jLabel20.setText("Mahadev Bansode");
                  System.out.println("Connection Eshtablished");
                  
                  String q = "INSERT INTO covid_center_data(cov_id,cases,active,recovered,deaths) values(?,?,?,?,?)";            
                  
                  smt = con.prepareStatement(q);
                  
                  smt.setInt(1,1);
                  smt.setInt(2,c);
                  smt.setInt(3,a);
                  smt.setInt(4,r);
                  smt.setInt(5,d);
                  
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
    
    void clearText(){
        
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField9.setText("");
        jTextField7.setText("");
        jTextField8.setText("");
    }
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new covidCenterData();//.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
