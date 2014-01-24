import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;


public class PanelCustomer extends JPanel {

	private String database;
	private String dbpass;
	private String dbuser;
	int idproduct;

	/**
	 * Create the panel.
	 */
	public PanelCustomer(String database,String dbuser,String dbpass) {
		this.database=database;
		this.dbpass=dbpass;
		this.dbuser=dbuser;
		this.setVisible(false);
		this.setBounds(0, 0, 450, 300);
		this.setLayout(null);
		JLabel label1 = new JLabel("\u0391\u03BE\u03B9\u03BF\u03BB\u03CC\u03B3\u03B7\u03C3\u03B7 \u03A0\u03C1\u03BF\u03CA\u03CC\u03BD\u03C4\u03BF\u03C2");
		label1.setBounds(10, 11, 430, 19);
		this.add(label1);
		label1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel lblnumbers = new JLabel("  1      2     3     4     5");
		lblnumbers.setBounds(155, 48, 111, 14);
		this.add(lblnumbers);
		JLabel lblReview = new JLabel("Review");
		lblReview.setBounds(10, 80, 45, 14);
		this.add(lblReview);
		JButton btnClearReview = new JButton("Clear");
		btnClearReview.setBounds(20, 266, 94, 23);
		this.add(btnClearReview);
		JButton btnReview = new JButton("OK");
		btnReview.setBounds(124, 266, 74, 23);
		this.add(btnReview);
		JButton btnLogOutCustomer = new JButton("Sign Out");
		btnLogOutCustomer.setBounds(330, 266, 94, 23);
		this.add(btnLogOutCustomer);
		final JTextPane txtpnWriteReview = new JTextPane();
		txtpnWriteReview.setBounds(10, 95, 430, 160);
		this.add(txtpnWriteReview);
		ButtonGroup radio=new ButtonGroup();
		final JRadioButton radioButton_2 = new JRadioButton("");
		radioButton_2.setBounds(179, 65, 21, 19);
		this.add(radioButton_2);
		radio.add(radioButton_2);
		final JRadioButton radioButton_3 = new JRadioButton("");
		radioButton_3.setBounds(202, 65, 21, 19);
		this.add(radioButton_3);
		radio.add(radioButton_3);
		final JRadioButton radioButton_1 = new JRadioButton("");
		radioButton_1.setBounds(155, 65, 21, 19);
		this.add(radioButton_1);
		radio.add(radioButton_1);
		final JRadioButton radioButton_4 = new JRadioButton("");
		radioButton_4.setBounds(225, 65, 21, 19);
		this.add(radioButton_4);
		radio.add(radioButton_4);
		final JRadioButton radioButton_5 = new JRadioButton("");
		radioButton_5.setBounds(245, 65, 21, 19);
		this.add(radioButton_5);
		radio.add(radioButton_5);
		JButton btnNewSearchCustomer = new JButton("New Search");
		btnNewSearchCustomer.setBounds(208, 266, 112, 23);
		this.add(btnNewSearchCustomer);
	}
	
	protected boolean pushreview() {
		boolean graded=false;
		int star=0;
		String reviewtext;
		JRadioButton rb2=(JRadioButton)this.getComponent(7);
		JRadioButton rb3=(JRadioButton)this.getComponent(8);
		JRadioButton rb1=(JRadioButton)this.getComponent(9);
		JRadioButton rb4=(JRadioButton)this.getComponent(10);
		JRadioButton rb5=(JRadioButton)this.getComponent(11);
		JTextPane txtpn=(JTextPane)this.getComponent(6);
		if (rb1.isSelected()) {star=1;graded=true;}
		if (rb2.isSelected()) {star=2;graded=true;}
		if (rb3.isSelected()) {star=3;graded=true;}
		if (rb4.isSelected()) {star=4;graded=true;}
		if (rb5.isSelected()) {star=5;graded=true;}
		reviewtext=txtpn.getText();
		if(graded)
		{
			Connection conn=null;
			Statement stmt=null;
			ResultSet rs=null;
			try{
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				conn=DriverManager.getConnection(database, dbuser, dbpass);
				stmt=conn.createStatement();
				String querry="INSERT INTO critics VALUES("+idproduct+","+star+",'"+reviewtext+"');";
				stmt.executeUpdate(querry);    					
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
			return true;
		}
		else {JOptionPane.showMessageDialog(null, "Please evaluate the product from 1 to 5");}
		return false;
	}
	
	protected boolean newsearch(JPanel panelSearch) {
		this.setVisible(false);
		JTextPane txtpn=(JTextPane)this.getComponent(6);
		txtpn.setText("");
		JRadioButton rb1=(JRadioButton)this.getComponent(7);
		rb1.setSelected(false);
		JRadioButton rb2=(JRadioButton)this.getComponent(8);
		rb2.setSelected(false);
		JRadioButton rb3=(JRadioButton)this.getComponent(9);
		rb3.setSelected(false);
		JRadioButton rb4=(JRadioButton)this.getComponent(10);
		rb4.setSelected(false);
		JRadioButton rb5=(JRadioButton)this.getComponent(11);
		rb5.setSelected(false);
		JTextField txtfld=(JTextField)panelSearch.getComponent(0);
		txtfld.setText("");
		panelSearch.setVisible(true);
		return true;
	}
}
