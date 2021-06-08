
package covindata;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class stateTableData extends javax.swing.JFrame {

    public stateTableData() {
        initComponents();
        insertStateTable();
        setVisible(true);
        setLocation(100,0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1100, 700));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "State", "State Code", "Cases", "Recovered", "Deaths"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(159, 252, 59));
        jTable1.setMinimumSize(new java.awt.Dimension(900, 72));
        jTable1.setPreferredSize(new java.awt.Dimension(1100, 600));
        jTable1.setRowHeight(25);
        jTable1.setRowMargin(4);
        jScrollPane1.setViewportView(jTable1);

        jButton1.setBackground(new java.awt.Color(159, 215, 59));
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    
        dispose();
        try {
            new MainPage();
        } catch (Exception ex) {
            System.out.println(ex);
        } 
    }//GEN-LAST:event_jButton1ActionPerformed

    public void insertStateTable(){
     
    try{
        Connection con;
        PreparedStatement smt;
        
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","maddy","maddy20");
    
        BufferedReader br = new  BufferedReader(new FileReader("/home/maddy/NetBeansProjects/CovIndata/src/covindata/stateName.txt"));
        
        String d = "2021-05-05",line,rec[];
        dataClass[] dc = new dataClass[37];
        ResultSet rs;
        int i = 0;
        
        
        while((line = br.readLine()) != null){
            
            rec = line.split(",");
            
            String q = "SELECT * FROM state_data WHERE state_code = \'"+rec[0]+"\'"+"and last_update = \'"+d+"\'";
            
            smt = con.prepareStatement(q);
            rs = smt.executeQuery();
            
            if(rs.next()){
                
            dc[i] = new dataClass(rec[1],rs.getString(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getString(6));
            i++;
           }
            
        }
        
        DefaultTableModel tbl = (DefaultTableModel)jTable1.getModel();
        for(int j=0 ; j<i ; j++){
            
           //System.out.println(dc[j].stcode+" "+dc[j].cases+" "+dc[j].active+" "+dc[j].recovered+" "+dc[j].deaths);
           tbl.addRow(new Object[]{dc[j].name,dc[j].stcode,dc[j].cases,dc[j].active,dc[j].recovered,dc[j].deaths});  
        }
        
    }catch( IOException | ClassNotFoundException | SQLException e){
        
        System.out.println(e);
    }        
}   
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new stateTableData();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
