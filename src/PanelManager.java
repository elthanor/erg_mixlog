import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;


public class PanelManager extends JPanel {

	private String database;
	private String dbuser;
	private String dbpass;
	int idproduct;

	/**
	 * Create the panel.
	 */
	public PanelManager(String database,String dbuser,String dbpass) {
		this.database=database;
		this.dbuser=dbuser;
		this.dbpass=dbpass;
		this.setVisible(false);
		this.setBounds(0, 0, 450, 300);
		this.setLayout(null);
		JLabel lblmesosoros = new JLabel("\u039C\u03AD\u03C3\u03BF\u03C2 \u038C\u03C1\u03BF\u03C2");
		lblmesosoros.setBounds(14, 59, 79, 14);
		this.add(lblmesosoros);
		final JLabel lbl_stars = new JLabel("");
		lbl_stars.setBounds(103, 59, 33, 14);
		this.add(lbl_stars);
		final JButton btnPrevious = new JButton("Previous");
		btnPrevious.setBounds(14, 266, 86, 23);
		btnPrevious.setEnabled(false);
		this.add(btnPrevious);
		final JButton btnNext = new JButton("Next");
		btnNext.setBounds(110, 266, 86, 23);
		btnNext.setEnabled(false);
		this.add(btnNext);
		JLabel lbltitle = new JLabel("\u03A3\u03C4\u03B1\u03C4\u03B9\u03C3\u03C4\u03B9\u03BA\u03AC");
		lbltitle.setBounds(10, 11, 430, 19);
		this.add(lbltitle);
		lbltitle.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lbltitle.setHorizontalAlignment(SwingConstants.CENTER);
		JButton btnNewSearch = new JButton("New Search");
		btnNewSearch.setBounds(211, 266, 113, 23);
		this.add(btnNewSearch);
		JButton btnLogout = new JButton("Sign Out");
		btnLogout.setBounds(342, 266, 98, 23);
		this.add(btnLogout);
		final JTextPane txtpnReview = new JTextPane();
		txtpnReview.setBounds(0, 103, 450, 154);
		this.add(txtpnReview);
		txtpnReview.setEditable(false);
		txtpnReview.setText("Review");
	}
	
	protected ArrayList<String> fetchreviews() {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<String> critics=new ArrayList<String>();
		double stars=0;
		JTextPane txtpn=(JTextPane)this.getComponent(7);
		txtpn.setText("");
		JLabel lblstars=(JLabel)this.getComponent(1);
		lblstars.setText("");
		JButton btnNext;
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn=DriverManager.getConnection(database, dbuser, dbpass);
			stmt=conn.createStatement();
			String querry="SELECT * FROM critics WHERE ID="+idproduct+";";
			rs=stmt.executeQuery(querry);
			while(rs.next()){
				critics.add(rs.getString("Review_Text"));
				stars+=rs.getInt("Stars");
			}
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
		if (critics.size()>0) {
			txtpn.setText(critics.get(0));
			lblstars=(JLabel)this.getComponent(1);
			lblstars.setText(""+stars/critics.size());
			if(critics.size()>1) {
				btnNext=(JButton) this.getComponent(3);
				btnNext.setEnabled(true);
			}
		}
		else {JOptionPane.showMessageDialog(null, "No reviews found for current product selected");}
		return critics;
	}
	
	protected boolean newsearch(JPanel panelSearch) {
		this.setVisible(false);
		((JButton)this.getComponent(2)).setEnabled(false);;
		JTextField txtfld=(JTextField)panelSearch.getComponent(0);
		txtfld.setText("");
		panelSearch.setVisible(true);
		return true;
	}
	
	public boolean browse(int i,boolean countup,ArrayList<String> critics) {
		boolean switched=false;
		int ind=i;
		if(countup){
			ind++;
			((JTextPane)this.getComponent(7)).setText(critics.get(ind));
			if (ind>0) {((JButton)this.getComponent(2)).setEnabled(true);}
			else{((JButton)this.getComponent(2)).setEnabled(false);}
			if (ind>=critics.size()-1) {((JButton)this.getComponent(3)).setEnabled(false);}
			else {((JButton)this.getComponent(3)).setEnabled(true);}
			switched=true;
		}
		else {
			ind--;
			((JTextPane)this.getComponent(7)).setText(critics.get(ind));
			if (ind>0) {((JButton)this.getComponent(2)).setEnabled(true);}
			else{((JButton)this.getComponent(2)).setEnabled(false);}
			if (ind==critics.size()-1) {((JButton)this.getComponent(3)).setEnabled(false);}
			else {((JButton)this.getComponent(3)).setEnabled(true);}
			switched=true;
		}
		return switched;
	}
}
