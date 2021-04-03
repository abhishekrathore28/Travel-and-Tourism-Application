import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;


public class UpdateCustomer extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
	JComboBox<Object> c1;
	JRadioButton r1,r2;
	JButton b1,b2;
	UpdateCustomer(String username){
		setBounds(350,185,850,550);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel l1=new JLabel("Username : ");
		l1.setBounds(30,50,150,25);
		add(l1);
		
		t1=new JTextField();
		t1.setBounds(220, 50, 150, 25);
		add(t1);
		
		JLabel l2=new JLabel("ID  : ");
		l2.setBounds(30,95,150,25);
		add(l2);
		
		t8=new JTextField();
		t8.setBounds(220, 95, 150, 25);
		add(t8);
		
		JLabel l3=new JLabel("Number : ");
		l3.setBounds(30,140,150,25);
		add(l3);
		
		t2=new JTextField();
		t2.setBounds(220, 140, 150, 25);
		add(t2);
		
		JLabel l4=new JLabel("Name : ");
		l4.setBounds(30,185,150,25);
		add(l4);
		
		t3=new JTextField();
		t3.setBounds(220, 185, 150, 25);
		add(t3);
		
		JLabel l5=new JLabel("Gender : ");
		l5.setBounds(30,230,150,25);
		add(l5);
		
		t9=new JTextField();
		t9.setBounds(220, 230, 150, 25);
		add(t9);
		
		JLabel l6=new JLabel("Country : ");
		l6.setBounds(30,275,150,25);
		add(l6);
		
		t4=new JTextField();
		t4.setBounds(220, 275, 150, 25);
		add(t4);
		
		JLabel l7=new JLabel("Address : ");
		l7.setBounds(30,320,150,25);
		add(l7);
		
		t5=new JTextField();
		t5.setBounds(220, 320, 150, 25);
		add(t5);
		
		JLabel l8=new JLabel("Phone No. : ");
		l8.setBounds(30,365,150,25);
		add(l8);
		
		t6=new JTextField();
		t6.setBounds(220, 365, 150, 25);
		add(t6);
		
		JLabel l9=new JLabel("Email : ");
		l9.setBounds(30,410,150,25);
		add(l9);
		
		t7=new JTextField();
		t7.setBounds(220,410, 150, 25);
		add(t7);
		
		b1=new JButton("Update");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(70, 455, 100, 25);
		b1.addActionListener(this);
		add(b1);
		
		b2=new JButton("Back");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(210, 455, 100, 25);
		b2.addActionListener(this);
		add(b2);
		
		JLabel l11=new JLabel("UPDATE CUSTOMER DETAILS");
		l11.setBounds(70, 0, 300, 25);
		l11.setFont(new Font("Tahoma",Font.PLAIN,20));
		l11.setForeground(Color.BLUE);
		add(l11);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
		Image i2=i1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel l10=new JLabel(i3);
		l10.setBounds(425, 0, 300	, 540);
		add(l10);
		
		try{
			Conn c= new Conn();
			ResultSet rs=c.s.executeQuery("select * from customer where username = '"+username+"'");
			while(rs.next()){
				t1.setText(rs.getString("username"));
				t2.setText(rs.getString("number"));
				t9.setText(rs.getString("gender"));
				t3.setText(rs.getString("username"));
				t4.setText(rs.getString("country"));
				t5.setText(rs.getString("address"));
				
				t6.setText(rs.getString("phone"));
				t7.setText(rs.getString("email"));
				t8.setText(rs.getString("id"));
				
				t3.setText(rs.getString("name"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static void main(String ar[])
	{
		new UpdateCustomer("").setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1){
		String username = t1.getText();
		String id=t8.getText();
		String number=t2.getText();
		String name=t3.getText();
		String radio=t9.getText();
		String country=t4.getText();
		String address=t5.getText();
		String phone=t6.getText();
		String email=t7.getText();
		
		String q="update customer set username='"+username+"',id= '"+id+"',number= '"+number+"', name='"+name+"',gender='"+radio+"',country='"+country+"' ,address='"+address+"',phone='"+phone+"',email='"+email+"'";
		try{
			Conn c=new Conn();
			c.s.executeUpdate(q);
			
			
			JOptionPane.showMessageDialog(null	, "Customer Details Updated  SucessFully");
			this.setVisible(false);
			
		}catch(Exception e){
			
		}
		}
		else if(ae.getSource()==b2)
		{
			this.setVisible(false);
		}
	}
}
