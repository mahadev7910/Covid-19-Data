import java.awt.*;
import java.awt.Image.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

class cloneHome implements ActionListener {
	
	JFrame f;
	JButton jb,js;
	JTextField searchBar;
	JTextArea t1,t2,t3;
	JComboBox cb1,cb2;
	JLabel jBack,jl;
	ImageIcon img1,img2;
	Image dab1,cdab1,dab2,cdab2;
	JMenu m1,m2,m3,m4,m5,m6;
	JMenuBar bar;
 
	public cloneHome(){
		
		f = new JFrame("COVID-19 DATA");

		// changing Size Of the Image for fit into JButton;
		img1 = new ImageIcon("images/download.jpg");
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
		t1 = new JTextArea(4,11);
		t2 = new JTextArea(4,11);
		t3 = new JTextArea(4,11);
		
		t1.setFont(new Font("Verdana",Font.BOLD,21));
		t2.setFont(new Font("Verdana",Font.BOLD,21));
		t3.setFont(new Font("Verdana",Font.BOLD,21));
		
		t1.setBackground(Color.LIGHT_GRAY);
		t2.setBackground(Color.PINK);
		t3.setBackground(Color.cyan);
		
		t1.setBorder(new LineBorder(Color.BLACK,1));
		t2.setBorder(new LineBorder(Color.BLACK,1));
		t3.setBorder(new LineBorder(Color.BLACK,1));
		
		t1.setWrapStyleWord(true);
		t1.setLineWrap(true);
		t2.setWrapStyleWord(true);
		t2.setLineWrap(true);
		t3.setWrapStyleWord(true);
		t3.setLineWrap(true);
		
		t1.setText("CASES");
		t1.append(" ");
		t1.append(" ");
		t1.append("9,89,980");
		
		// icrease radioButton Text size :-
		//Font newRadioButtonFont=new Font(rb1.getFont().getName(),rb1.getFont().getStyle(),22);
        	//rb1.setFont(newRadioButtonFont);
		
		
		// Setting BackGround Image to Frame :-
		ImageIcon img = new ImageIcon("wp3364732-plen-background.jpg");//"images/istock-1214212730.jpg");
		jBack = new JLabel("",img,JLabel.CENTER);
		jBack.setBounds(0,0,1200,600);
		f.add(jBack);
		
		jb.setBounds(7,57,1190,150);
		t1.setBounds(130,218,270,100);
		t2.setBounds(437,218,270,100);
		t3.setBounds(740,218,270,100);
		menuBar();
		searchBar();

		// adding components into frame on Background Image :-
		jBack.setLayout(null);//new FlowLayout(FlowLayout.CENTER,40,0));
		
		jBack.add(jb);
		jBack.add(t1);
		jBack.add(t2);
		jBack.add(t3);
		
		f.pack();
		f.setSize(1200,700);
		f.setVisible(true);
		f.setLocation(0,0);
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
		bar.add(m1);  bar.add(m2);  bar.add(m3);  
		bar.add(m4);  bar.add(m5);  bar.add(m6);

		bar.setPreferredSize(new Dimension(1200,30));
		bar.setBackground(new Color(0,0,0));//102,0,153));

		f.setJMenuBar(bar);
		
	}

	public void searchBar(){


		searchBar = new JTextField("MAHARSHTRA",25);
		
		searchBar.setFont(new Font("serif",Font.BOLD,15));
		searchBar.setBorder(new LineBorder(new Color(255,204,51),1));
		searchBar.setBackground(new Color(0,0,0,80));
		searchBar.setForeground(new Color(255,204,51));

		js = new JButton(new ImageIcon("images/search.png"));;
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
		if(ae.getSource() == js){
			
			new login();
			f.dispose();
		}

	}

	/*public void menuSelected(MenuEvent me){

		if(me.getSource() == m2){
	
			new login();
			f.dispose();
		}
	}*/

	public static void main(String args[]){
	
		new cloneHome();
	}

}

