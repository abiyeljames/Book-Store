
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.*; //This is new

class MyFrame3 extends JFrame implements ActionListener{
	private JLabel l0 = new JLabel("Book Store");
	private JLabel l1 = new JLabel("Book ID");
	private JLabel l2 = new JLabel("Book Name");
	private JLabel l3 = new JLabel("Edition");
	
	private JTextField t1=new JTextField("",9);
	private JTextField t2=new JTextField("",9);
	private JTextField t3=new JTextField("",9);

	private JButton b1=new JButton("Insert");
	private JButton b2=new JButton("Search");
	private JButton b3=new JButton("Close");
	private JButton b4=new JButton("Display");
	private JButton b5=new JButton("Delete");
	
	
	private JPanel p1=new JPanel();
	private HashTable tree=new HashTable();//This is new
	private int current=0; //This is new
	private final JLabel l4 = new JLabel("Author");
	private final JTextField t4 = new JTextField();

//CONSTRUCTOR
	public MyFrame3(String s){
		super(s);
		getContentPane().setBackground(SystemColor.inactiveCaption);
		setForeground(Color.GRAY);
		t4.setBounds(203, 127, 203, 42);
		t4.setColumns(10);
		setTitle("Book Store");
		
		InsertInitialItems();
		Container content=getContentPane();
		Font f=new Font("TimesRoman", Font.BOLD,20);
		l0.setBounds(250, 10, 114, 27);
		l0.setFont(new Font("Serif", Font.BOLD, 20));  l1.setBounds(0, 2, 203, 42);
  l1.setFont(new Font("Serif", Font.BOLD, 18));
		getContentPane().setLayout(null);
		content.add(l0);		
		p1.setBackground(SystemColor.activeCaption);
		p1.setBounds(82, 44, 410, 351);
		p1.setLayout(null);
		p1.add(l1); t1.setBounds(203, 2, 203, 42);
 p1.add(t1);
		l2.setBounds(0, 44, 203, 42);
		l2.setFont(new Font("Serif", Font.BOLD, 18));
		p1.add(l2); t2.setBounds(203, 44, 203, 42);
 p1.add(t2);
		l3.setBounds(0, 86, 203, 42);
		l3.setFont(new Font("Serif", Font.BOLD, 18));
		p1.add(l3); t3.setBounds(203, 86, 203, 42);
 p1.add(t3);
		b1.setBounds(0, 247, 203, 42);
		p1.add(b1); b2.setBounds(203, 247, 203, 42);
 p1.add(b2);
		b5.setBounds(0, 299, 203, 42);
		p1.add(b5);
		content.add(p1);
		
		JButton b6 = new JButton("Clear");
		b6.setBounds(203, 299, 203, 42);
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  t1.setText("");
		          t2.setText("");
		          t3.setText("");
		          t4.setText("");
			}
		});
		p1.add(b6);
		l4.setFont(new Font("Serif", Font.BOLD, 18));
		l4.setBounds(0, 138, 78, 13);
		
		p1.add(l4);
		
		p1.add(t4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Action", "Fantasy", "Novel", "Comic", "Historical Fiction", "Christian Classics", "Horror"}));
		comboBox.setBounds(203, 166, 203, 48);
		p1.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Genre");
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 18));
		lblNewLabel.setBounds(0, 166, 64, 31);
		p1.add(lblNewLabel);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Book Available");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxNewCheckBox.setSelected(true);
		chckbxNewCheckBox.setBounds(203, 220, 201, 21);
		p1.add(chckbxNewCheckBox);
b4.setBounds(210, 418, 89, 27);
content.add(b4);
b3.setBounds(341, 418, 81, 27);
content.add(b3);
		b1.addActionListener(this);b2.addActionListener(this);
		b3.addActionListener(this);b4.addActionListener(this);
		b5.addActionListener(this);
		   //Horizontal , Vertical
		setSize(601,507);    setVisible(true);}

	public HashTable readTable() {return tree;}

	public void actionPerformed(ActionEvent e){

	  	Object target=e.getSource();
	 	if (target==b1)
	 		{    int id=Integer.parseInt(t1.getText());
	 		     String nm= t2.getText();
	 		     int ag=Integer.parseInt(t3.getText());
	 		     String at= t4.getText();
	 		     tree.insert(id, nm, ag, at);
	         }

	     if (target==b2)
	     	{
	    	 int id=Integer.parseInt(t1.getText());
	    	 HNode temp=tree.search(id);
	    	 if (temp==null){  t2.setText("Unknown");
	    	                   t3.setText("");
	    	                   t4.setText("Unknown");}
	    	 else       { t1.setText(""+temp.readKey());
	    	              t2.setText(""+temp.readName());
	    	              t3.setText(""+temp.readAge());
	    	              t4.setText(""+temp.readAuthor());
	    	            }
	     	}
	     if (target==b3)
	     	{
	    	 this.setVisible(false);
	     	}
	     if (target==b4)
	     	{
	    	 new HashDisplay(this);
	     	}
	     if (target==b5)
	     	{
	    	 int id=Integer.parseInt(t1.getText());
	    	 tree.delete(id);
	    	 new HashDisplay(this);
	     	}
	    
	     
          }
	
	public void InsertInitialItems() {
		tree.insert(01,"The Pilgrim's Progress",4,"John");
		tree.insert(02,"Mere Christianity",2,"C. S. Lewis");
		tree.insert(03,"Confessions",4,"Augustine");
		tree.insert(04,"The Imitation of Christ",2,"Thomas à Kempis");
		tree.insert(05,"The Cost of Discipleship",6,"Dietrich Bonhoeffer");
		tree.insert(06,"The City of God",2,"Augustine");
		tree.insert(07,"The Case for Christ",4,"Lee Strobel");
		tree.insert(15,"Life Together",4, "Dietrich Bonhoeffer");
		tree.insert(16,"Orthodoxy",2,"G. K. Chesterton");
		tree.insert(18,"The Pursuit of God",7,"A. W. Tozer");
		tree.insert(17,"The Hiding Place",6,"Corrie Ten Boom");
		
		tree.insert(21,"Leading with Love",8,"Alexander Strauch");
		tree.insert(22,"Book of Martyrs",9,"John Foxe");
		tree.insert(23,"All of Grace",7,"Charles Spurgeon");
		
		
		tree.insert(26,"True Discipleship",4,"William Macdonald");
		tree.insert(27,"When Life is Hard",9,"James MacDonald");
		tree.insert(28,"Surprised by Joy",4, "C. S. Lewis");
		tree.insert(29,"Knowing God",2, "J. I. Packer");
		tree.insert(30,"The Screwtape Letters",4,"C. S. Lewis");
		tree.insert(31,"A Grief Obseverd",7,"C. S. Lewis");
		tree.insert(32,"The Chronicles of Narnia",2,"C. S. Lewis");
		
	}
}

