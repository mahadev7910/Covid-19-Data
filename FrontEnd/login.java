import java.awt.*;
import javax.swing.*;



public class login extends JFrame {

	JPanel p1;
	JLabel j1,j2;
	JButton b1,b2;
	JTextField t1,t3;
	JPasswordField t2;

	public login(){

		setTitle("Login");
		
		ImageIcon img = new ImageIcon("wp3248934-plain-colour-wallpaper.jpg");
		j1 = new JLabel("",img,JLabel.CENTER);
		j1.setBounds(0,0,860,670);
		
		j2 = new JLabel("Staff",JLabel.CENTER);
		j2.setFont(new Font("Serif",Font.BOLD,33));
		j2.setForeground(Color.WHITE);

		j2.setBounds(150,10,100,50);

		t1 = new JTextField("Enter UserID");
		t2 = new JPasswordField("Enter Password");
		t3 = new JTextField("Enter Covid Center ID");
		
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
		setLocation(50,0);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args){

		new login();
	}
}
