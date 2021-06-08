import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

class home implements AdjustmentListener,ActionListener {

        JFrame f;
	JButton jb,js;
	JTextField searchBar;
	JLabel cases,recover,death,l1,l2,l3,cper,rper,dper;
	JLabel jBack,jl;
	ImageIcon img1,img2;
	Image dab1,cdab1,dab2,cdab2;
	JButton m1,m2,m3,m4,m5,m6;
	JMenuBar bar;
	JMenuItem staff;
        JScrollBar jsb;
        
	public home(){
		
		f = new JFrame("COVID-19 DATA");

		// changing Size Of the Image for fit into JButton;
		img1 = new ImageIcon("/home/maddy/NetBeansProjects/TYProject/src/typroject/images/download.jpg");
		dab1 = img1.getImage();
		cdab1 = dab1.getScaledInstance(1165,150,java.awt.Image.SCALE_SMOOTH);
		img1 = new ImageIcon(cdab1);
		
		jb = new JButton(img1);
		jb.setBorder(new LineBorder(Color.BLACK,2));

		jb.addActionListener(this);
		
		//Frame Background color :-
		f.getContentPane().setBackground(new Color(255,255,255));
		
		// Labels For Data :-
                cases = new JLabel("TOTAL CASES",JLabel.CENTER);
                recover = new JLabel("RECOVERED",JLabel.CENTER);
                death = new JLabel("DEATHS",JLabel.CENTER);

		l1 = new JLabel("",JLabel.CENTER);
		l2 = new JLabel("",JLabel.CENTER);
		l3 = new JLabel("",JLabel.CENTER);
		
                cper = new JLabel("98.28%",JLabel.CENTER);
                rper = new JLabel("90.67%",JLabel.CENTER);
                dper = new JLabel("3.21%",JLabel.CENTER);
                
                cases.setFont(new Font("Verdana",Font.BOLD,23));
                recover.setFont(new Font("Verdana",Font.BOLD,23));
                death.setFont(new Font("Verdana",Font.BOLD,23));
                
		l1.setFont(new Font("Verdana",Font.BOLD,27));
		l2.setFont(new Font("Verdana",Font.BOLD,27));
		l3.setFont(new Font("Verdana",Font.BOLD,27));
		
                cper.setFont(new Font("Verdana",Font.BOLD,18));
                rper.setFont(new Font("Verdana",Font.BOLD,18));
                dper.setFont(new Font("Verdana",Font.BOLD,18));
                
		l1.setBorder(new LineBorder(Color.BLACK,1));
		l2.setBorder(new LineBorder(Color.BLACK,1));
		l3.setBorder(new LineBorder(Color.BLACK,1));
		
		// icrease radioButton Text size :-
		//Font newRadioButtonFont=new Font(rb1.getFont().getName(),rb1.getFont().getStyle(),22);
                //rb1.setFont(newRadioButtonFont);
		
		
		// Setting BackGround Image to Frame :-
		/*ImageIcon img = new ImageIcon("/home/maddy/NetBeansProjects/TYProject/src/typroject/images/istock-1214212730.jpg");
		jBack = new JLabel("",img,JLabel.CENTER);
		jBack.setBounds(0,0,1200,600);
		f.add(jBack);*/
		
		jb.setBounds(7,57,1165,150);
                
                cases.setBounds(130,247,270,30);
                l1.setBounds(130,246,260,100);
		cper.setBounds(130,315,270,25);
                
                recover.setBounds(437,247,270,30);
                l2.setBounds(437,246,270,100);
		rper.setBounds(437,315,270,25);
                
                death.setBounds(740,247,270,30);
                l3.setBounds(740,246,270,100);
                dper.setBounds(740,315,270,25);

                menuBar();
		searchBar();
                scrollBar();
                
		// adding components into frame on Background Image :-
		f.setLayout(null);
		                
		f.add(jb);
                f.add(cases);
                f.add(recover);
                f.add(death);
		f.add(l1);
		f.add(l2);
		f.add(l3);
		f.add(cper);
                f.add(rper);
                f.add(dper);
		f.pack();
		f.setSize(1200,700);
		f.setVisible(true);
		f.setLocation(0,0);
        //f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}


	public void menuBar(){

		bar = new JMenuBar();
		 
		m1 = new JButton("Home ");
		m2 = new JButton(" Login  ");
		m3 = new JButton(" States  ");
		m4 = new JButton(" Cities  ");
		m5 = new JButton(" Covid-Center ");
		m6 = new JButton(" About ");

		Font ff = new Font("serif",Font.BOLD,15);

		m1.setFont(ff);
		m2.setFont(ff);
		m3.setFont(ff);
		m4.setFont(ff);
		m5.setFont(ff);
		m5.setFont(ff);
		m6.setFont(ff);

		Color c = new Color(255,204,51);
		
		m1.setForeground(c);
		m2.setForeground(c);
		m3.setForeground(c);
		m4.setForeground(c);
		m5.setForeground(c);
		m6.setForeground(c);

		m1.setBackground(new Color(0,0,0));
		m2.setBackground(new Color(0,0,0));
		m3.setBackground(new Color(0,0,0));
		m4.setBackground(new Color(0,0,0));
		m5.setBackground(new Color(0,0,0));
		m6.setBackground(new Color(0,0,0));
		
		m1.setBorder(new LineBorder(Color.BLACK,1));
		m2.setBorder(new LineBorder(Color.BLACK,1));
		m3.setBorder(new LineBorder(Color.BLACK,1));
		m4.setBorder(new LineBorder(Color.BLACK,1));
		m5.setBorder(new LineBorder(Color.BLACK,1));
		m6.setBorder(new LineBorder(Color.BLACK,1));
		
		m2.addActionListener(this);
		
		bar.add(m1);  bar.add(m2);  bar.add(m3);  
		bar.add(m4);  bar.add(m5);  bar.add(m6);

		bar.setPreferredSize(new Dimension(1200,30));
		bar.setBackground(new Color(0,0,0));

		f.setJMenuBar(bar);
		
	}

	public void searchBar(){


		searchBar = new JTextField("",25);
		
		searchBar.setFont(new Font("serif",Font.BOLD,15));
		searchBar.setBorder(new LineBorder(new Color(255,204,51),1));
		searchBar.setBackground(new Color(0,0,0,80));
		searchBar.setForeground(new Color(255,204,51));

		js = new JButton(new ImageIcon("/home/maddy/NetBeansProjects/TYProject/src/typroject/images/search.png"));
		js.setBackground(new Color(255,204,51));
		js.setBorder(new LineBorder(Color.BLACK,2));

		searchBar.setBounds(350,0,400,45);
		js.setBounds(750,0,50,46);
		
		js.addActionListener(this);

		JPanel sp = new JPanel();
		sp.setLayout(null);		
		sp.setBackground(new Color(0,0,0));
		sp.setOpaque(false);
				
		sp.add(searchBar);
		sp.add(js);
		sp.setBounds(0,5,1200,45);

		f.add(sp);
	}
        
        void scrollBar(){
            
            jsb = new JScrollBar(JScrollBar.VERTICAL);
            jsb.setBounds(1183,0,17,670);
            jsb.setBlockIncrement(30);
            jsb.setValue(20);
            jsb.addAdjustmentListener(this);
            f.add(jsb);
        }

        public void adjustmentValueChanged(AdjustmentEvent aa){
            
            if(aa.getSource() == jsb){
                
                int val = jsb.getValue();
                System.out.println(val);
                int max = jsb.getMaximum();
                int newY = val*f.getHeight();
                Point p = f.getLocation();
                l1.setLocation((int)p.getX(),newY);
                l2.setLocation((int)p.getX(),newY);
                l3.setLocation((int)p.getX(),newY);
                cases.setLocation((int)p.getX(),newY);
                recover.setLocation((int)p.getX(),newY);
                death.setLocation((int)p.getX(),newY);
                jb.setLocation((int)p.getX(),newY);
                searchBar.setLocation((int)p.getX(),newY);
                f.repaint();
            }
        }
	public void actionPerformed(ActionEvent ae){

		/*if(ae.getSource() == jb){

			new regForm();
			f.dispose();
		}
		if(ae.getSource() == staff){
			
			new login();
			f.dispose();
		}
                if(ae.getSource() == js){
                    
                   int[] r = new search().searchData(searchBar.getText());
                 
                   if(r == null)
                      new Dialog().invalidSearch();
                   else{
                        
                    l1.setText(Integer.toString(r[0]));
                    l2.setText(Integer.toString(r[1]));
                    l3.setText(Integer.toString(r[3]));
                    rper.setText(Float.toString(r[4])+"%");
                    dper.setText(Float.toString(r[5])+"%"); 
                   }
                }
*/
	if( ae.getSource() == m2){
		System.out.println("success");
	}
	}
	public static void main(String args[]){
	
           new home();
        }
}
