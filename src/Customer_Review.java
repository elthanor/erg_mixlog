import javax.swing.ButtonGroup;
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import javax.swing.JTextPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JRadioButtonMenuItem;


public class Customer_Review extends JApplet {

	/**
	 * Create the applet.
	 */
	public Customer_Review() {
		getContentPane().setLayout(null);
		
		final JPanel panelCustomer = new JPanel();
		panelCustomer.setBounds(0, 0, 450, 300);
		getContentPane().add(panelCustomer);
		panelCustomer.setLayout(null);
		
		JLabel label_1 = new JLabel("\u0391\u03BE\u03B9\u03BF\u03BB\u03CC\u03B3\u03B7\u03C3\u03B7 \u03A0\u03C1\u03BF\u03CA\u03CC\u03BD\u03C4\u03BF\u03C2");
		label_1.setBounds(10, 11, 430, 19);
		panelCustomer.add(label_1);
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("  1      2     3     4     5");
		lblNewLabel_1.setBounds(20, 33, 111, 14);
		panelCustomer.add(lblNewLabel_1);
		
		JLabel lblReview = new JLabel("Review");
		lblReview.setBounds(10, 80, 45, 14);
		panelCustomer.add(lblReview);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(20, 266, 94, 23);
		panelCustomer.add(btnClear);
		
		JButton btnOK = new JButton("OK");
		
		btnOK.setBounds(124, 266, 74, 23);
		panelCustomer.add(btnOK);
		
		JButton btnSignOut = new JButton("Sign Out");
		btnSignOut.setBounds(330, 266, 94, 23);
		panelCustomer.add(btnSignOut);
		
		final JTextPane txtpnReview = new JTextPane();
		txtpnReview.setBounds(10, 95, 430, 160);
		panelCustomer.add(txtpnReview);
		
		ButtonGroup radio=new ButtonGroup();
		
		final JRadioButton radioButton_2 = new JRadioButton("");
		radioButton_2.setBounds(44, 50, 21, 19);
		panelCustomer.add(radioButton_2);
		radio.add(radioButton_2);
		
		final JRadioButton radioButton_3 = new JRadioButton("");
		radioButton_3.setBounds(67, 50, 21, 19);
		panelCustomer.add(radioButton_3);
		radio.add(radioButton_3);
		
		final JRadioButton radioButton_1 = new JRadioButton("");
		radioButton_1.setBounds(20, 50, 21, 19);
		panelCustomer.add(radioButton_1);
		radio.add(radioButton_1);
		
		final JRadioButton radioButton_4 = new JRadioButton("");
		radioButton_4.setBounds(90, 50, 21, 19);
		panelCustomer.add(radioButton_4);
		radio.add(radioButton_4);
		
		final JRadioButton radioButton_5 = new JRadioButton("");
		radioButton_5.setBounds(110, 50, 21, 19);
		panelCustomer.add(radioButton_5);
		radio.add(radioButton_5);
		
		JButton btnSearch = new JButton("New Search");
		
		btnSearch.setBounds(208, 266, 112, 23);
		panelCustomer.add(btnSearch);
		
		final JLabel lblStatus = new JLabel("");
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setBounds(152, 41, 288, 43);
		panelCustomer.add(lblStatus);
		
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtpnReview.setText("");
			}
		});

		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelCustomer.hide();
				//panelLogin.show();
			}
		});
		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelCustomer.hide();
				//panelSearch.show();
			}
		});
		
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean push=false;
				int star=0;
				String review_text;
				if (radioButton_1.isSelected()) {star=1;push=true;}
				if (radioButton_2.isSelected()) {star=2;push=true;}
				if (radioButton_3.isSelected()) {star=3;push=true;}
				if (radioButton_4.isSelected()) {star=4;push=true;}
				if (radioButton_5.isSelected()) {star=5;push=true;}
				review_text=txtpnReview.getText();
				if(push)
				{
					Connection conn=null;
					Statement stmt=null;
					ResultSet rs=null;
					try{
						Class.forName("com.mysql.jdbc.Driver").newInstance();
						String connectionUrl="jdbc:mysql://localhost:3306/test";
						String connectionUser="root";
						String connectionPassword="kaparomilo";
						conn=DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
						stmt=conn.createStatement();
						String querry="INSERT INTO critics VALUES(1,"+star+",'"+review_text+"');";
						stmt.executeUpdate(querry);    //executeQuery(querry);					
					}
					catch(Exception e1)
					{
						e1.printStackTrace();
					}
					finally
					{
						try{if(rs!=null)rs.close();}catch(SQLException e1){
							e1.printStackTrace();}
						try{if(stmt!=null)stmt.close();}catch(SQLException e1){
							e1.printStackTrace();}
						try{if(conn!=null)conn.close();}catch(SQLException e1){
							e1.printStackTrace();}
					}
					lblStatus.setText("<html>Review has been succesfully registered");
				}
				else {lblStatus.setText("<html>Please choose a number from 1 to 5 to review this product");}
			}
		});
	}
}
