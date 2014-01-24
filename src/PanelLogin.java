import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class PanelLogin extends JPanel {

	String rights="";
	String database;
	String dbpass;
	String dbuser;

	public PanelLogin(String database,String dbuser,String dbpass) {
		this.database=database;
		this.dbuser=dbuser;
		this.dbpass=dbpass;
		this.setBounds(0, 0, 450, 300);
		this.setLayout(null);
		JLabel lblTitle = new JLabel("Online \u03A3\u03C5\u03C3\u03C4\u03B7\u03BC\u03B1 \u0391\u03BE\u03B9\u03BF\u03BB\u03BF\u03B3\u03B7\u03C3\u03B7\u03C2 \u03A0\u03C1\u03BF\u03B9\u03CC\u03BD\u03C4\u03C9\u03BD");
		lblTitle.setBounds(29, 5, 411, 32);
		this.add(lblTitle);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 16));
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(10, 89, 79, 14);
		this.add(lblUsername);
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(10, 148, 79, 14);
		this.add(lblPassword);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		final JTextField textUser = new JTextField();
		textUser.setBounds(99, 86, 157, 20);
		this.add(textUser);
		textUser.setColumns(10);
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(29, 239, 116, 23);
		this.add(btnClear);
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(193, 239, 116, 23);
		this.add(btnOk);
		final JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(99, 145, 157, 20);
		this.add(passwordField);
		final JLabel lblpic = new JLabel("New label");
		lblpic.setBounds(266, 48, 174, 174);
		this.add(lblpic);
		lblpic.setHorizontalAlignment(SwingConstants.CENTER);
		lblpic.setIcon(new ImageIcon(Mixlog.class.getResource("/images/starrating.jpg")));
	}

	public boolean checkaccount(String text, String pass) {
		String rights = "";
		Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        boolean authentication=false;
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn=DriverManager.getConnection(database, dbuser, dbpass);
            stmt=conn.createStatement();                     
            String querry="select * from users where Username='"+ text + "' COLLATE utf8_bin and Password='" + pass + "' COLLATE utf8_bin;";
            rs=stmt.executeQuery(querry);   
            while(rs.next()){
				rights = rs.getString("rights");
            }
        }
        catch(Exception e1)
        {e1.printStackTrace();}
        finally
        {try{if(rs!=null)rs.close();}catch(SQLException e1){
			e1.printStackTrace();}
		try{if(stmt!=null)stmt.close();}catch(SQLException e1){
			e1.printStackTrace();}
		try{if(conn!=null)conn.close();}catch(SQLException e1){
			e1.printStackTrace();}}
        if(rights.contains("User")) {
			this.rights="User";
			this.setVisible(false);
			authentication=true;
		}
		else if (rights.contains("Administrator"))
		{	
			this.rights="Administrator";
			this.setVisible(false);
			authentication=true;
		}
		else {authentication=false;}
        return authentication;
		}
}
