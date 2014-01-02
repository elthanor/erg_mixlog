import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class mixlog {

	private JFrame frame;
	protected String rights;
	JPanel panelLogin=new JPanel();
	JPanel panelSearch=new JPanel();
	JPanel panelManager = new JPanel();
	JPanel panelCustomer = new JPanel();
	protected int id_product;
	ArrayList<String> critics;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mixlog window = new mixlog();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mixlog() {
		initialize();
		initializepanels();
	}

	/**
	 * Initialize the contents of the frame.
	 * @return 
	 */
	private boolean initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 457, 329);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(panelLogin, BorderLayout.CENTER);
		frame.getContentPane().add(panelSearch, BorderLayout.CENTER);
		frame.getContentPane().add(panelManager, BorderLayout.CENTER);
		frame.getContentPane().add(panelCustomer, BorderLayout.CENTER);
		return true;
	}

	protected void initializepanels() {
		panelLogin.setBounds(0, 0, 450, 300);
		panelLogin.setLayout(null);
		JLabel lblTitle = new JLabel("Online \u03A3\u03C5\u03C3\u03C4\u03B7\u03BC\u03B1 \u0391\u03BE\u03B9\u03BF\u03BB\u03BF\u03B3\u03B7\u03C3\u03B7\u03C2 \u03A0\u03C1\u03BF\u03B9\u03CC\u03BD\u03C4\u03C9\u03BD");
		lblTitle.setBounds(29, 5, 411, 32);
		panelLogin.add(lblTitle);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 16));
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(10, 89, 79, 14);
		panelLogin.add(lblUsername);
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(10, 148, 79, 14);
		panelLogin.add(lblPassword);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		final JTextField textUser = new JTextField();
		textUser.setBounds(99, 86, 157, 20);
		panelLogin.add(textUser);
		textUser.setColumns(10);
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(29, 239, 116, 23);
		panelLogin.add(btnClear);
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(193, 239, 116, 23);
		panelLogin.add(btnOk);
		final JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(99, 145, 157, 20);
		panelLogin.add(passwordField);
		final JLabel lblpic = new JLabel("New label");
		lblpic.setBounds(277, 59, 163, 163);
		panelLogin.add(lblpic);
		lblpic.setHorizontalAlignment(SwingConstants.CENTER);
		lblpic.setIcon(new ImageIcon(mixlog.class.getResource("/images/starrating.jpg")));
		btnOk.addActionListener(new ActionListener() {
		btnClear.addActionListener(new ActionListener() {
		
		panelSearch.setVisible(false);
		panelSearch.setBounds(0, 0, 450, 300);
		panelSearch.setLayout(null);
		final JTextField txtSearchbox = new JTextField();
		txtSearchbox.setBounds(10, 6, 236, 20);
		panelSearch.add(txtSearchbox);
		txtSearchbox.setColumns(10);
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(256, 5, 83, 23);
		panelSearch.add(btnSearch);
		JButton btnSignOut = new JButton("Sign Out");
		btnSignOut.setBounds(349, 5, 91, 23);
		panelSearch.add(btnSignOut);
		final JButton btnProduct1 = new JButton("");
		btnProduct1.setIcon(null);
		btnProduct1.setBounds(10, 37, 208, 120);
		btnProduct1.setVisible(false);
		panelSearch.add(btnProduct1);
		final JButton btnProduct2 = new JButton("");
		btnProduct2.setBounds(232, 37, 208, 120);
		btnProduct2.setVisible(false);
		panelSearch.add(btnProduct2);
		final JButton btnProduct4 = new JButton("");
		btnProduct4.setBounds(242, 168, 208, 120);
		btnProduct4.setVisible(false);
		panelSearch.add(btnProduct4);
		final JButton btnProduct3 = new JButton("");
		btnProduct3.setSelectedIcon(null);
		btnProduct3.setBounds(10, 168, 208, 120);
		btnProduct3.setVisible(false);
		panelSearch.add(btnProduct3);
		btnSignOut.addActionListener(new ActionListener() {
		btnSearch.addActionListener(new ActionListener() {
		btnProduct1.addActionListener(new ActionListener() {
		btnProduct2.addActionListener(new ActionListener() {
		btnProduct3.addActionListener(new ActionListener() {
		btnProduct4.addActionListener(new ActionListener() {
		
		panelManager.setVisible(false);
		panelManager.setBounds(0, 0, 450, 300);
		panelManager.setLayout(null);
		JLabel lblmesosoros = new JLabel("\u039C\u03AD\u03C3\u03BF\u03C2 \u038C\u03C1\u03BF\u03C2");
		lblmesosoros.setBounds(14, 59, 79, 14);
		panelManager.add(lblmesosoros);
		final JLabel lbl_stars = new JLabel("");
		lbl_stars.setBounds(103, 59, 33, 14);
		panelManager.add(lbl_stars);
		final JButton btnPrevious = new JButton("Previous");
		btnPrevious.setBounds(14, 266, 86, 23);
		btnPrevious.setEnabled(false);
		panelManager.add(btnPrevious);
		final JButton btnNext = new JButton("Next");
		btnNext.setBounds(110, 266, 86, 23);
		btnNext.setEnabled(false);
		panelManager.add(btnNext);
		JLabel lbl_title = new JLabel("\u03A3\u03C4\u03B1\u03C4\u03B9\u03C3\u03C4\u03B9\u03BA\u03AC");
		lbl_title.setBounds(10, 11, 430, 19);
		panelManager.add(lbl_title);
		lbl_title.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		JButton btnNewSearch = new JButton("New Search");
		btnNewSearch.setBounds(211, 266, 113, 23);
		panelManager.add(btnNewSearch);
		JButton btnLogout = new JButton("Sign Out");
		btnLogout.setBounds(342, 266, 98, 23);
		panelManager.add(btnLogout);
		final JTextPane txtpnReview = new JTextPane();
		txtpnReview.setBounds(0, 103, 450, 154);
		panelManager.add(txtpnReview);
		txtpnReview.setEditable(false);
		txtpnReview.setText("Review");
		btnLogout.addActionListener(new ActionListener() {
		btnNewSearch.addActionListener(new ActionListener() {
		btnPrevious.addActionListener(new ActionListener() {
		btnNext.addActionListener(new ActionListener() {
		
		panelCustomer.setVisible(false);
		panelCustomer.setBounds(0, 0, 450, 300);
		panelCustomer.setLayout(null);
		JLabel label_1 = new JLabel("\u0391\u03BE\u03B9\u03BF\u03BB\u03CC\u03B3\u03B7\u03C3\u03B7 \u03A0\u03C1\u03BF\u03CA\u03CC\u03BD\u03C4\u03BF\u03C2");
		label_1.setBounds(10, 11, 430, 19);
		panelCustomer.add(label_1);
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel lblnumbers = new JLabel("  1      2     3     4     5");
		lblnumbers.setBounds(155, 48, 111, 14);
		panelCustomer.add(lblnumbers);
		JLabel lblReview_ = new JLabel("Review");
		lblReview_.setBounds(10, 80, 45, 14);
		panelCustomer.add(lblReview_);
		JButton btnClearReview = new JButton("Clear");
		btnClearReview.setBounds(20, 266, 94, 23);
		panelCustomer.add(btnClearReview);
		JButton btnReview = new JButton("OK");
		btnReview.setBounds(124, 266, 74, 23);
		panelCustomer.add(btnReview);
		JButton btnLogOutCustomer = new JButton("Sign Out");
		btnLogOutCustomer.setBounds(330, 266, 94, 23);
		panelCustomer.add(btnLogOutCustomer);
		final JTextPane txtpnWriteReview = new JTextPane();
		txtpnWriteReview.setBounds(10, 95, 430, 160);
		panelCustomer.add(txtpnWriteReview);
		ButtonGroup radio=new ButtonGroup();
		final JRadioButton radioButton_2 = new JRadioButton("");
		radioButton_2.setBounds(179, 65, 21, 19);
		panelCustomer.add(radioButton_2);
		radio.add(radioButton_2);
		final JRadioButton radioButton_3 = new JRadioButton("");
		radioButton_3.setBounds(202, 65, 21, 19);
		panelCustomer.add(radioButton_3);
		radio.add(radioButton_3);
		final JRadioButton radioButton_1 = new JRadioButton("");
		radioButton_1.setBounds(155, 65, 21, 19);
		panelCustomer.add(radioButton_1);
		radio.add(radioButton_1);
		final JRadioButton radioButton_4 = new JRadioButton("");
		radioButton_4.setBounds(225, 65, 21, 19);
		panelCustomer.add(radioButton_4);
		radio.add(radioButton_4);
		final JRadioButton radioButton_5 = new JRadioButton("");
		radioButton_5.setBounds(245, 65, 21, 19);
		panelCustomer.add(radioButton_5);
		radio.add(radioButton_5);
		JButton btnNewSearch_Customer = new JButton("New Search");
		btnNewSearch_Customer.setBounds(208, 266, 112, 23);
		panelCustomer.add(btnNewSearch_Customer);
		btnClearReview.addActionListener(new ActionListener() {
		btnLogOutCustomer.addActionListener(new ActionListener() {
		btnNewSearch_Customer.addActionListener(new ActionListener() {
		btnReview.addActionListener(new ActionListener() {
	}

	protected boolean pushreview() {
		boolean graded=false;
		int star=0;
		String review_text;
		JRadioButton rb2=(JRadioButton)panelCustomer.getComponent(7);
		JRadioButton rb3=(JRadioButton)panelCustomer.getComponent(8);
		JRadioButton rb1=(JRadioButton)panelCustomer.getComponent(9);
		JRadioButton rb4=(JRadioButton)panelCustomer.getComponent(10);
		JRadioButton rb5=(JRadioButton)panelCustomer.getComponent(11);
		JTextPane txtpn=(JTextPane)panelCustomer.getComponent(6);
		if (rb1.isSelected()) {star=1;graded=true;}
		if (rb2.isSelected()) {star=2;graded=true;}
		if (rb3.isSelected()) {star=3;graded=true;}
		if (rb4.isSelected()) {star=4;graded=true;}
		if (rb5.isSelected()) {star=5;graded=true;}
		review_text=txtpn.getText();
		if(graded)
		{
			Connection conn=null;
			Statement stmt=null;
			ResultSet rs=null;
			try{
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				String connectionUrl="jdbc:mysql://localhost:3306/db_mixlog";
				String connectionUser="root";
				String connectionPassword="kaparomilo";
				conn=DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
				stmt=conn.createStatement();
				String querry="INSERT INTO critics VALUES("+id_product+","+star+",'"+review_text+"');";
				stmt.executeUpdate(querry);    					
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
			finally
			{
				closedb(rs,stmt,conn);
			}
			return true;
		}
		else {JOptionPane.showMessageDialog(null, "Please evaluate the product from 1 to 5");}
		return false;
	}

	protected boolean newsearch() {
		panelManager.setVisible(false);
		panelCustomer.setVisible(false);
		JTextPane txtpn=(JTextPane)panelCustomer.getComponent(6);
		txtpn.setText("");
		JRadioButton rb1=(JRadioButton)panelCustomer.getComponent(7);
		rb1.setSelected(false);
		JRadioButton rb2=(JRadioButton)panelCustomer.getComponent(8);
		rb2.setSelected(false);
		JRadioButton rb3=(JRadioButton)panelCustomer.getComponent(9);
		rb3.setSelected(false);
		JRadioButton rb4=(JRadioButton)panelCustomer.getComponent(10);
		rb4.setSelected(false);
		JRadioButton rb5=(JRadioButton)panelCustomer.getComponent(11);
		rb5.setSelected(false);
		JTextField txtfld=(JTextField)panelSearch.getComponent(0);
		txtfld.setText("");
		panelSearch.setVisible(true);
		return true;
	}
	
	protected ArrayList<String> fetchreviews() {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<String> critics=new ArrayList<String>();
		double stars=0;
		JTextPane txtpn=(JTextPane)panelManager.getComponent(7);
		txtpn.setText("");
		JLabel lbl_stars=(JLabel)panelManager.getComponent(1);
		lbl_stars.setText("");
		JButton btnNext;
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String connectionUrl="jdbc:mysql://localhost:3306/db_mixlog";
			String connectionUser="root";
			String connectionPassword="kaparomilo";
			conn=DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
			stmt=conn.createStatement();
			String querry="SELECT * FROM critics WHERE ID="+id_product+";";
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
			closedb(rs,stmt,conn);
		}
		if (critics.size()>0) {
			txtpn.setText(critics.get(0));
			lbl_stars=(JLabel)panelManager.getComponent(1);
			lbl_stars.setText(""+stars/critics.size());
			if(critics.size()>1) {
				btnNext=(JButton) panelManager.getComponent(3);
				btnNext.setEnabled(true);
			}
		}
		else {JOptionPane.showMessageDialog(null, "No reviews found for current product selected");}
		return critics;
		
	}

	protected boolean productclicked(int id) {
		panelSearch.getComponent(3).setVisible(false);
		panelSearch.getComponent(4).setVisible(false);
		panelSearch.getComponent(5).setVisible(false);
		panelSearch.getComponent(6).setVisible(false);
		panelSearch.setVisible(false);
		if(rights.contains("User")) {
			panelCustomer.setVisible(true);
			id_product=id;
			return true;
		}
		else if(rights.contains("Administrator")) {
			id_product=id;
			panelManager.setVisible(true);
			critics=fetchreviews();
			return true;
		}
		return false;
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
			String connectionUrl="jdbc:mysql://localhost:3306/db_mixlog";
			String connectionUser="root";
			String connectionPassword="kaparomilo";
			conn=DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
			stmt=conn.createStatement();
			String querry="SELECT * FROM products WHERE Full_name LIKE '%"+text+"%'";
			rs=stmt.executeQuery(querry);
			int i=0;
			while(rs.next()){
				found=true;
				if(i==0){btnProduct1.setText(""+rs.getInt("ID"));btnProduct1.setVisible(true);btnProduct1.setIcon(new ImageIcon(mixlog.class.getResource("/images/path"+rs.getInt("ID")+".jpg")));}
				if(i==1){btnProduct2.setText(""+rs.getInt("ID"));btnProduct2.setVisible(true);btnProduct2.setIcon(new ImageIcon(mixlog.class.getResource("/images/path"+rs.getInt("ID")+".jpg")));}
				if(i==2){btnProduct3.setText(""+rs.getInt("ID"));btnProduct3.setVisible(true);btnProduct3.setIcon(new ImageIcon(mixlog.class.getResource("/images/path"+rs.getInt("ID")+".jpg")));}
				if(i==3){btnProduct4.setText(""+rs.getInt("ID"));btnProduct4.setVisible(true);btnProduct4.setIcon(new ImageIcon(mixlog.class.getResource("/images/path"+rs.getInt("ID")+".jpg")));}
				i++;
			}
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
		finally
		{
			closedb(rs,stmt,conn);
		}
		return found;
	}

	private void closedb(ResultSet rs, Statement stmt, Connection conn) {
		try{if(rs!=null)rs.close();}catch(SQLException e1){
			e1.printStackTrace();}
		try{if(stmt!=null)stmt.close();}catch(SQLException e1){
			e1.printStackTrace();}
		try{if(conn!=null)conn.close();}catch(SQLException e1){
			e1.printStackTrace();}
		
	}

	protected boolean checkaccount(String text, String pass) {
		String rights = "";
		Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        boolean authentication=false;
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String connectionUrl="jdbc:mysql://localhost:3306/db_mixlog";
            String connectionUser="root";
            String connectionPassword="kaparomilo";
            conn=DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
            stmt=conn.createStatement();                     
            String querry="select * from users where Username='"+ text + "' and Password='" + pass + "';";
            rs=stmt.executeQuery(querry);   
            while(rs.next()){
				rights = rs.getString("rights");
            }
        }
        catch(Exception e1)
        {e1.printStackTrace();}
        finally
        {closedb(rs,stmt,conn);}
        if(rights.contains("User")) {
			this.rights="User";
			panelLogin.setVisible(false);
			panelSearch.setVisible(true);
			authentication=true;
		}
		else if (rights.contains("Administrator"))
		{	
			this.rights="Administrator";
			panelLogin.setVisible(false);
			panelSearch.setVisible(true);
			authentication=true;
		}
		else {authentication=false;}
        return authentication;
		}
	
	protected boolean signout() {
		rights="";
		JTextField user=(JTextField)panelLogin.getComponent(3);
		user.setText("");
		JPasswordField pass=(JPasswordField)panelLogin.getComponent(6);
		pass.setText("");
		panelSearch.setVisible(false);
		panelManager.setVisible(false);
		panelCustomer.setVisible(false);
		JTextField txtfld=(JTextField)panelSearch.getComponent(0);
		txtfld.setText("");
		panelSearch.getComponent(3).setVisible(false);
		panelSearch.getComponent(4).setVisible(false);
		panelSearch.getComponent(5).setVisible(false);
		panelSearch.getComponent(6).setVisible(false);
		panelLogin.setVisible(true);
		JTextPane txtpn=(JTextPane)panelCustomer.getComponent(6);
		txtpn.setText("");
		JRadioButton rb1=(JRadioButton)panelCustomer.getComponent(7);
		rb1.setSelected(false);
		JRadioButton rb2=(JRadioButton)panelCustomer.getComponent(8);
		rb2.setSelected(false);
		JRadioButton rb3=(JRadioButton)panelCustomer.getComponent(9);
		rb3.setSelected(false);
		JRadioButton rb4=(JRadioButton)panelCustomer.getComponent(10);
		rb4.setSelected(false);
		JRadioButton rb5=(JRadioButton)panelCustomer.getComponent(11);
		rb5.setSelected(false);
		return true;
	}
}