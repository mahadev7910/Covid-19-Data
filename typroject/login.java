package typroject;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class login extends JFrame implements ActionListener {

	JPanel p1;
	JLabel j1,j2;
	JButton b1,b2;
	JTextField t1,t3;
	JPasswordField t2;

	public login(){

		setTitle("Login");
		
		ImageIcon img = new ImageIcon("/home/maddy/NetBeansProjects/TYProject/src/typroject/images/wp3248934-plain-colour-wallpaper.jpg");
		j1 = new JLabel("",img,JLabel.CENTER);
		j1.setBounds(0,0,860,670);
		
		j2 = new JLabel("Staff",JLabel.CENTER);
		j2.setFont(new Font("Serif",Font.BOLD,33));
		j2.setForeground(Color.WHITE);

		j2.setBounds(150,10,100,50);

		t1 = new JTextField();
		t2 = new JPasswordField();
		t3 = new JTextField();
		
		t2.setEchoChar('*');

		t1.setBounds(30,80,330,50);
		t2.setBounds(30,170,330,50);
		t3.setBounds(30,260,330,50);
	
		Font f = new Font("Serif",Font.BOLD,15);
		
		t1.setFont(f);
		t2.setFont(f);
		t3.setFont(f);

		b1 = new JButton("Login");
		b2 = new JButton("Cancel");

		b1.setBounds(90,345,95,40);
		b2.setBounds(200,345,95,40);
		
		//b1.setForeground(Color.RED);
		//b2.setForeground(Color.RED);
		b1.setFont(f);
		b2.setFont(f);
		b1.setBackground(new Color(120,230,120));
		b2.setBackground(new Color(234,244,127));
                b1.addActionListener(this);
                b2.addActionListener(this);
                
		p1 = new JPanel();

		p1.setLayout(null);		
		p1.setSize(400,500);		
		p1.setBounds(225,70,400,500);
		p1.setBackground(new Color(0,0,0,70));
		
		p1.add(j2);
		p1.add(t1);
		p1.add(t2);
		p1.add(t3);
		p1.add(b1);
		p1.add(b2);

		setLayout(null);
		add(j1);
		j1.add(p1);

		setVisible(true);
		setSize(860,670);
		//setLocation(200,0);
		setLocationRelativeTo(null);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
        
        
        public void actionPerformed(ActionEvent ae){
        
            String password,uid,covid;
            
            if(ae.getSource() == b1){
                
               uid = t1.getText();
               password = t2.getText();
               covid = t3.getText();
               
               if(uid.equals("") || password.equals("") || covid.equals(""))
                   new Dialog().error();
               else
                   try{
                       validateUser(password,uid,covid);
               } catch (SQLException ex) {
                   System.out.println(ex);
               }   
            }
            else
                if(ae.getSource() == b2){
                    dispose();
                    new home();
                }
        }
        
        public void validateUser(String pass,String uid,String covid) throws SQLException {
            
            Connection c;
            PreparedStatement smt;
            
            try{
                Class.forName("org.postgresql.Driver");
                c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","maddy","maddy20");
                System.out.println("Connection Eshtablished");
               
                int id,cid;
                id = Integer.parseInt(uid);
                cid = Integer.parseInt(covid);
                String q;
                q = "SELECT * FROM staff WHERE id = \'"+id+"\'"+" and password = \'"+pass+"\'"+" and cov_id = \'"+cid+"\'";
                
                smt = c.prepareStatement(q);
              
                ResultSet rs = smt.executeQuery();
                
                if(rs.next()){

                    dispose();
                    new covidCenterData();
                }
                else
                    new Dialog().invalidUser();
                
                c.close();
                        
            }catch(ClassNotFoundException | NumberFormatException e){System.out.println(e);}
        }    
	public static void main(String[] args){

		new login();
	}
}
