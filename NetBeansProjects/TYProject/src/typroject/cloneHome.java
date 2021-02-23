package typroject;

import java.awt.*;
import java.awt.Image.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

class cloneHome implements ActionListener {
	
	JFrame f;
	JButton jb,js;
	JTextField searchBar;
	JLabel l1,l2,l3;
	JComboBox cb1,cb2;
	JLabel jBack,jl;
	ImageIcon img1,img2;
	Image dab1,cdab1,dab2,cdab2;
	JMenu m1,m2,m3,m4,m5,m6;
	JMenuBar bar;
	JMenuItem staff;
 
	public cloneHome(){
		
		f = new JFrame("COVID-19 DATA");

		// changing Size Of the Image for fit into JButton;
		img1 = new ImageIcon("/home/maddy/NetBeansProjects/TYProject/src/typroject/images/download.jpg");
		dab1 = img1.getImage();
		cdab1 = dab1.getScaledInstance(1190,150,java.awt.Image.SCALE_SMOOTH);
		img1 = new ImageIcon(cdab1);
		
		jb = new JButton(img1);

		// JButton Jb Size Setting :-  
		jb.setPreferredSize(new Dimension(1190,150));
		jb.setBorder(new LineBorder(Color.BLACK,2));

		jb.addActionListener(this);
		
		// Frame Background color :-
		//f.getContentPane().setBackground(Color.BLACK);
		
		// Text Area :-
		l1 = new JLabel();
		l2 = new JLabel();
		l3 = new JLabel();
		
		l1.setFont(new Font("Verdana",Font.BOLD,21));
		l2.setFont(new Font("Verdana",Font.BOLD,21));
		l3.setFont(new Font("Verdana",Font.BOLD,21));
		
		/*l1.setBackground(Color.LIGHT_GRAY);
		l2.setBackground(new Color(121,22,12));
		l3.setBackground(Color.cyan);*/
		
		l1.setBorder(new LineBorder(Color.BLACK,1));
		l2.setBorder(new LineBorder(Color.BLACK,1));
		l3.setBorder(new LineBorder(Color.BLACK,1));
		
		/*l1.setWrapStyleWord(true);
		l1.setLineWrap(true);
		l2.setWrapStyleWord(true);
		l2.setLineWrap(true);
		l3.setWrapStyleWord(true);
		l3.setLineWrap(true);*/
		
		// icrease radioButton Text size :-
		//Font newRadioButtonFont=new Font(rb1.getFont().getName(),rb1.getFont().getStyle(),22);
                //rb1.setFont(newRadioButtonFont);
		
		
		// Setting BackGround Image to Frame :-
		ImageIcon img = new ImageIcon("/home/maddy/NetBeansProjects/TYProject/src/typroject/images/istock-1214212730.jpg");
		jBack = new JLabel("",img,JLabel.CENTER);
		jBack.setBounds(0,0,1200,600);
		f.add(jBack);
		
		jb.setBounds(7,57,1190,150);
		l1.setBounds(130,218,270,100);
		l2.setBounds(437,218,270,100);
		l3.setBounds(740,218,270,100);
		menuBar();
		searchBar();

		// adding components into frame on Background Image :-
		jBack.setLayout(null);//new FlowLayout(FlowLayout.CENTER,40,0));
		
		jBack.add(jb);
		jBack.add(l1);
		jBack.add(l2);
		jBack.add(l3);
		
		f.pack();
		f.setSize(1200,700);
		f.setVisible(true);
		f.setLocation(0,0);
                //f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}


	public void menuBar(){

		bar = new JMenuBar();
		 
		m1 = new JMenu("Home ");
		m2 = new JMenu(" Login  ");
		m3 = new JMenu(" States  ");
		m4 = new JMenu(" Cities  ");
		m5 = new JMenu(" Covid-Center ");
		m6 = new JMenu(" About ");

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

		/*m1.addMenuListener(this);
		m2.addMenuListener(this);
		m3.addMenuListener(this);
		m4.addMenuListener(this);
		m5.addMenuListener(this);
		m6.addMenuListener(this);
*/
		staff = new JMenuItem("Staff");
		
		m2.add(staff);
		staff.addActionListener(this);
		
		bar.add(m1);  bar.add(m2);  bar.add(m3);  
		bar.add(m4);  bar.add(m5);  bar.add(m6);

		bar.setPreferredSize(new Dimension(1200,30));
		bar.setBackground(new Color(0,0,0));//102,0,153));

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

		jBack.add(sp);
	}

	public void actionPerformed(ActionEvent ae){

		if(ae.getSource() == jb){

			new regForm();
			f.dispose();
		}
		if(ae.getSource() == staff){
			
			new login();
			f.dispose();
		}
                if(ae.getSource() == js){
                    
                    int[] r = new search().searchData(searchBar.getText());
                    for(int a : r)
                        System.out.println(a+" ");
                    
//                    JLabel cs = new JLabel("Cases");
//                    JLabel rd = new JLabel("Recovered");
//                    JLabel dt = new JLabel("Deaths");
//                    
//                    t1.setText(cs);
                    
                        
                }

	}

	public static void main(String args[]){
	
		new cloneHome();
	}

}

