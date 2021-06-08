package covindata;

import javax.swing.*;

class Dialog {
 
    public void error(){
        
        JOptionPane.showMessageDialog(null,"Enter all fields","Error",JOptionPane.ERROR_MESSAGE);
    }
    
    public void success(){
        
        JOptionPane.showMessageDialog(null,"","",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("/home/maddy/NetBeansProjects/CovIndata/src/images/thnk.png"));
    }
    
    public void alreadyInsertCovData(){
        
        JOptionPane.showMessageDialog(null,"Already Inserted Today's Records","",JOptionPane.INFORMATION_MESSAGE);
    }
    public void invalidUser(){
        
        JOptionPane.showMessageDialog(null,"Invalid User Data","Authuntication",JOptionPane.ERROR_MESSAGE);
    }
    
    public void invalidSearch(){
        
        JOptionPane.showMessageDialog(null,"Invalid Search","Not Found",JOptionPane.ERROR_MESSAGE);
    }
    
    public void submitCovData(){
        
        JOptionPane.showMessageDialog(null,"Enter All Fields","",JOptionPane.ERROR_MESSAGE);
    }
    
     public void errorCovData(){
        
        JOptionPane.showMessageDialog(null,"Invalid Input","",JOptionPane.ERROR_MESSAGE);
    }
     
    public void successRecord(){
        
         JOptionPane.showMessageDialog(null,"Successfully submited","",JOptionPane.INFORMATION_MESSAGE);
    } 
}
