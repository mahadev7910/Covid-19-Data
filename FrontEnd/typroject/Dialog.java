package typroject;

import javax.swing.*;

class Dialog {
 
    public void error(){
        
        JOptionPane.showMessageDialog(null,"Enter Required Fields","Error",JOptionPane.ERROR_MESSAGE);
    }
    
    public void success(){
        
        JOptionPane.showMessageDialog(null,"Successfully Registered","",JOptionPane.INFORMATION_MESSAGE);
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
    
    public void cancelCovData(){
        
        JOptionPane.showMessageDialog(null,"You really want to cancel ?","",JOptionPane.YES_NO_OPTION);
        new login();

    }
    
    public void submitCovData(){
        
        JOptionPane.showMessageDialog(null,"Enter All Fields","",JOptionPane.ERROR_MESSAGE);
    }
    
     public void errorCovData(){
        
        JOptionPane.showMessageDialog(null,"Invalid Input","",JOptionPane.ERROR_MESSAGE);
    }
     
    public void successRecord(){
        
         JOptionPane.showMessageDialog(null,"Successfully Recorded","",JOptionPane.INFORMATION_MESSAGE);
    } 
}
