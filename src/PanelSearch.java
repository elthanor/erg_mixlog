import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class PanelSearch extends JPanel {

	private String database;
	private String dbuser;
	private String dbpass;
	int idproduct;

	/**
	 * Create the panel.
	 */
	public PanelSearch(String database,String dbuser,String dbpass) {
		this.database=database;
		this.dbuser=dbuser;
		this.dbpass=dbpass;
		this.setVisible(false);
		this.setBounds(0, 0, 450, 300);
		this.setLayout(null);
		final JTextField txtSearchbox = new JTextField();
		txtSearchbox.setBounds(10, 6, 236, 20);
		this.add(txtSearchbox);
		txtSearchbox.setColumns(10);
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(256, 5, 83, 23);
		this.add(btnSearch);
		JButton btnSignOut = new JButton("Sign Out");
		btnSignOut.setBounds(349, 5, 91, 23);
		this.add(btnSignOut);
		final JButton btnProduct1 = new JButton("");
		btnProduct1.setIcon(null);
		btnProduct1.setBounds(10, 37, 208, 120);
		btnProduct1.setVisible(false);
		this.add(btnProduct1);
		final JButton btnProduct2 = new JButton("");
		btnProduct2.setBounds(232, 37, 208, 120);
		btnProduct2.setVisible(false);
		this.add(btnProduct2);
		final JButton btnProduct4 = new JButton("");
		btnProduct4.setBounds(242, 168, 208, 120);
		btnProduct4.setVisible(false);
		this.add(btnProduct4);
		final JButton btnProduct3 = new JButton("");
		btnProduct3.setSelectedIcon(null);
		btnProduct3.setBounds(10, 168, 208, 120);
		btnProduct3.setVisible(false);
		this.add(btnProduct3);
	}

	protected boolean dbgetproducts(String text, JButton btnProduct1, JButton btnProduct2, JButton btnProduct3, JButton btnProduct4) {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		btnProduct1.setVisible(false);
		btnProduct2.setVisible(false);
		btnProduct3.setVisible(false);
		btnProduct4.setVisible(false);
		boolean found=false;
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn=DriverManager.getConnection(database, dbuser, dbpass);
			stmt=conn.createStatement();
			String querry="SELECT * FROM products WHERE Full_name LIKE '%"+text+"%'";
			rs=stmt.executeQuery(querry);
			int i=0;
			while(rs.next()){
				found=true;
				if(i==0){btnProduct1.setText(String.valueOf(rs.getInt("ID")));btnProduct1.setVisible(true);btnProduct1.setIcon(new ImageIcon(Mixlog.class.getResource("/images/path"+rs.getInt("ID")+".jpg")));}
				if(i==1){btnProduct2.setText(String.valueOf(rs.getInt("ID")));btnProduct2.setVisible(true);btnProduct2.setIcon(new ImageIcon(Mixlog.class.getResource("/images/path"+rs.getInt("ID")+".jpg")));}
				if(i==2){btnProduct3.setText(String.valueOf(rs.getInt("ID")));btnProduct3.setVisible(true);btnProduct3.setIcon(new ImageIcon(Mixlog.class.getResource("/images/path"+rs.getInt("ID")+".jpg")));}
				if(i==3){btnProduct4.setText(String.valueOf(rs.getInt("ID")));btnProduct4.setVisible(true);btnProduct4.setIcon(new ImageIcon(Mixlog.class.getResource("/images/path"+rs.getInt("ID")+".jpg")));}
				i++;
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
		return found;
	}
}
