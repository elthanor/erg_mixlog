import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Manager_Panel extends JApplet {
	String critics[]=new String [10];
	double stars;
	int critics_len;
	int index;

	/**
	 * Create the applet.
	 */
	public Manager_Panel() {
		getContentPane().setLayout(null);
		
		final JPanel panelManager = new JPanel();
		panelManager.setBounds(0, 0, 450, 300);
		getContentPane().add(panelManager);
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
		
		JLabel lbl_title = new JLabel("\u03A3\u03C4\u03B1\u03C4\u03B9\u03C3\u03C4\u03B9\u03BA\u03AC");//+name_product);
		lbl_title.setBounds(10, 11, 430, 19);
		panelManager.add(lbl_title);
		lbl_title.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnSearch = new JButton("New Search");
		btnSearch.setBounds(211, 266, 113, 23);
		panelManager.add(btnSearch);
		
		JButton btnLogout = new JButton("Sign Out");
		btnLogout.setBounds(342, 266, 98, 23);
		panelManager.add(btnLogout);
		
		final JTextPane txtpnReview = new JTextPane();
		txtpnReview.setBounds(0, 103, 450, 154);
		panelManager.add(txtpnReview);
		txtpnReview.setEditable(false);
		txtpnReview.setText("Review");
		
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
			String querry="SELECT * FROM critics WHERE ID=1";//+id_product;
			rs=stmt.executeQuery(querry);
			int i=0;
			while(rs.next()){
				critics[i]=rs.getString("Review_Text");
				stars+=rs.getInt("Stars");
				i++;
			}
			critics_len=i;
			if (critics_len>0) {
				txtpnReview.setText(critics[0]);
				index=0;
				stars=stars/critics_len;
				lbl_stars.setText(""+stars);
				if(critics_len>1) {btnNext.setEnabled(true);}
			}
			else {txtpnReview.setText("No reviews found for current product");}
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
		
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				critics=null;
				index=-1;
				critics_len=0;
				stars=0;
				panelManager.hide();
				//panelLogin.show();
			}
		});
		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				critics=null;
				index=-1;
				critics_len=0;
				stars=0;
				panelManager.hide();
				//panelSearch.show();
			}
		});
		
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index--;
				txtpnReview.setText(critics[index]);
				if (index == 0 )
				{
					btnPrevious.setEnabled(false);
				}
				if(index<critics_len-1) {btnNext.setEnabled(true);}
			}
		});
		
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index++;
				txtpnReview.setText(critics[index]);
				if (index == critics_len-1 )
				{
					btnNext.setEnabled(false);
				}
				if (index>0) {btnPrevious.setEnabled(true);}
			}
		});
	}

}
