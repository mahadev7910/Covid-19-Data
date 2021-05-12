import java.awt.*;
import javax.swing.*;

class covidData extends JFrame {

	JPanel p1;
	JLabel name,email,mob,cid,cname,ln,le,lm,lcid,lcn,lc,city,cc,ac,rc,dc,ov,c;
	JTextField cct,rt,dt,ot,ct;
	JButton submit,reset,cancel;
	
	public covidData(){
	
		// 1.creating Labels For user Data : 
		name = new JLabel("Name :");
		email = new JLabel("Email :");
		mob = new JLabel("mob :");
		cid = new JLabel("Covid Center ID :");
		cname = new JLabel("Center Name :");
		city = new JLabel("City :");
		
		// 2.creating Labels for hold data :
		ln = new JLabel("mahadev bansode");
		le = new JLabel("mahadevnnhhshsj");
		lm = new JLabel("8837736636");
		lcid = new JLabel("100");
		lc = new JLabel("pune");
		lcn = new JLabel("Rajiv Gandhi Hospital,Yerwada");
		
		// 3.creating Labels For Insert Data :
		cc = new JLabel("Confirmed Cases :");
		ac = new JLabel("Active Cases :");
		rc = new JLabel("Recovered Cases :");
		ov = new JLabel("On Ventilator :");
	
		// Settign Font size for Labels :
		Font f = new java.awt.Font("Arial", 0, 18);
		
		name.setFont(f);
		email.setFont(f);
		mob.setFont(f);
		cid.setFont(f);
		cname.setFont(f);
		ln.setFont(f);
		le.setFont(f);
		lm.setFont(f);
		lcid.setFont(f);
		lcn.setFont(f);
		lc.setFont(f);
		city.setFont(f);
		cc.setFont(f);
		/*ac.setFont(f);
		rc.setFont(f);
		ac.setFont(f);
		ov.setFont(f);
		c.setFont(f);*/
		
		// Creating textfield for insert data :
		cct = new JTextField();		
		rt  = new JTextField();
		dt  = new JTextField();
		ot  = new JTextField();
		ct  = new JTextField();
		
		// Button for operation :
		submit  = new JButton("Submit");
		reset  = new JButton("Reset");
		cancel  = new JButton("Cancel");
		
		// Setting 1.Labels into panel p1 :
		p1 = new JPanel();
		p1.setLayout(new GridLayout(2, 3, 15, 5));
		p1.add(name); p1.add(ln);   p1.add(email); p1.add(le);   p1.add(mob);  p1.add(lm);
		p1.add(cid);  p1.add(lcid); p1.add(cname); p1.add(lcn);  p1.add(city); p1.add(lc);
		
		setLayout(new BorderLayout());
		add(p1,BorderLayout.NORTH);
		setVisible(true);
        setSize(860,700);
        setLocation(200,0);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args){
	
		new covidData();
	}
}

