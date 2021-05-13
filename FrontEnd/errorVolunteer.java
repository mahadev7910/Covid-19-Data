package typroject;

import javax.swing.*;

class errorVolunteer {
 
    public void error(){
        
        JOptionPane.showMessageDialog(null,"Enter Required Fields","Error",JOptionPane.ERROR_MESSAGE);
    }
    
    public void success(){
        
        JOptionPane.showMessageDialog(null,"Successfully Registered","",JOptionPane.PLAIN_MESSAGE);
    }
    
    public void invalidUser(){
        
        JOptionPane.showMessageDialog(null,"Invalid User","Authuntication",JOptionPane.ERROR_MESSAGE);
    }
}
