package typroject;

import javax.swing.*;

class Dialog {
 
    public void error(){
        
        JOptionPane.showMessageDialog(null,"Enter Required Fields","Error",JOptionPane.ERROR_MESSAGE);
    }
    
    public void success(){
        
        JOptionPane.showMessageDialog(null,"Successfully Registered","",JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void invalidUser(){
        
        JOptionPane.showMessageDialog(null,"Invalid User Data","Authuntication",JOptionPane.ERROR_MESSAGE);
    }
    
    public void invalidSearch(){
        
        JOptionPane.showMessageDialog(null,"Invalid Search","Not Found",JOptionPane.ERROR_MESSAGE);
    }
    
    public void cancelCovData(){
        
        JOptionPane.showMessageDialog(null,"You really want to cancel ?","",JOptionPane.YES_NO_OPTION);

    }
}
