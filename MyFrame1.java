
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.*; //This is new

class MyFrame1 extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private JLabel l0 = new JLabel("Book Store");
	

	private JButton b1=new JButton("");
	private JButton b2=new JButton("Open Store");
	private JButton b3=new JButton("Exit");
	private JPanel p1=new JPanel();


//CONSTRUCTOR
	public MyFrame1(String s){
		super(s);
		setTitle("Book Store");

		Container content=getContentPane();
		Font f=new Font("TimesRoman", Font.BOLD,20);
		p1.setBounds(80, 37, 90, 60);
		p1.setLayout(new GridLayout(2,1));
		getContentPane().setLayout(null);
		l0.setBounds(75, 10, 119, 27);
		l0.setFont(f);  
		content.add(l0);		
		 b2.setFont(new Font("Tahoma", Font.BOLD, 10));

		 p1.add(b2);p1.add(b3);
		content.add(p1);

		b2.addActionListener(this);		b3.addActionListener(this);
		   //Horizontal , Vertical
		setSize(267,183);    setVisible(true);}



	public void actionPerformed(ActionEvent e){

	  	Object target=e.getSource();


	     if (target==b2)
	     	{
	    	     new MyFrame3("H Table");
	     	}
	     if (target==b3)
	     	{
	    	 System.exit(0);
	     	}
	     
	     
          }
}

