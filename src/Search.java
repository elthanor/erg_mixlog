import javax.swing.JApplet;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Search extends JApplet {
	private JTextField txtSearchbox;
	int id[]=new int[4];
	int id_product;
	String name_product;

	/**
	 * Create the applet.
	 */
	public Search() {
		getContentPane().setLayout(null);
		
		final JPanel panelSearch = new JPanel();
		panelSearch.setBounds(0, 0, 450, 300);
		getContentPane().add(panelSearch);
		panelSearch.setLayout(null);
		
		txtSearchbox = new JTextField();
		txtSearchbox.setBounds(10, 6, 236, 20);
		panelSearch.add(txtSearchbox);
		txtSearchbox.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		
		btnNewButton.setBounds(256, 5, 83, 23);
		panelSearch.add(btnNewButton);
		
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
		btnProduct4.setBounds(232, 168, 208, 120);
		btnProduct4.setVisible(false);
		panelSearch.add(btnProduct4);
		
		final JButton btnProduct3 = new JButton("");
		btnProduct3.setSelectedIcon(null);
		btnProduct3.setBounds(10, 168, 208, 120);
		btnProduct3.setVisible(false);
		panelSearch.add(btnProduct3);
		
		final JLabel lblnores = new JLabel("");
		lblnores.setHorizontalAlignment(SwingConstants.CENTER);
		lblnores.setBounds(49, 117, 359, 40);
		panelSearch.add(lblnores);
		
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				id=null;
				name_product=null;
				id_product=-1;
				panelSearch.hide();
				//panelLogin.show();
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String producttxt=txtSearchbox.getText();
				Connection conn=null;
				Statement stmt=null;
				ResultSet rs=null;
				lblnores.setText("");
				btnProduct1.setVisible(false);
				btnProduct2.setVisible(false);
				btnProduct3.setVisible(false);
				btnProduct4.setVisible(false);
				try{
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					String connectionUrl="jdbc:mysql://localhost:3306/test";
					String connectionUser="root";
					String connectionPassword="kaparomilo";
					conn=DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
					stmt=conn.createStatement();
					String querry="SELECT * FROM products WHERE Full_name LIKE '%"+producttxt+"%'";
					rs=stmt.executeQuery(querry);
					int i=0;
					while(rs.next()){
						String name=rs.getString("Full_name");
						if(i<4) {id[i]=rs.getInt("ID");}
						if(i==0){btnProduct1.setText(name);btnProduct1.setVisible(true);btnProduct1.setIcon(new ImageIcon(Search.class.getResource("/images/path"+id[i]+".jpg")));}
						if(i==1){btnProduct2.setText(name);btnProduct2.setVisible(true);btnProduct2.setIcon(new ImageIcon(Search.class.getResource("/images/path"+id[i]+".jpg")));}
						if(i==2){btnProduct3.setText(name);btnProduct3.setVisible(true);btnProduct3.setIcon(new ImageIcon(Search.class.getResource("/images/path"+id[i]+".jpg")));}
						if(i==3){btnProduct4.setText(name);btnProduct4.setVisible(true);btnProduct4.setIcon(new ImageIcon(Search.class.getResource("/images/path"+id[i]+".jpg")));}
						i++;
					}
					if(i==0){lblnores.setText("No Results Found");}
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
			}
		});
		
		btnProduct1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelSearch.hide();
				id_product=id[0];
				name_product = btnProduct1.getText();
				//if(rights=="manager"){panelManager.show();id_product=id[0];}
				//else{panelCustomer.Show();}
			}
		});
		
		btnProduct2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelSearch.hide();
				id_product=id[1];
				name_product = btnProduct2.getText();
				//if(rights=="manager"){panelManager.show();}
				//else{panelCustomer.Show();}
			}
		});
		
		btnProduct3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelSearch.hide();
				id_product=id[2];
				name_product = btnProduct3.getText();
				//if(rights=="manager"){panelManager.show();}
				//else{panelCustomer.Show();}
			}
		});
		
		btnProduct4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelSearch.hide();
				id_product=id[3];
				name_product = btnProduct4.getText();
				//if(rights=="manager"){panelManager.show();}
				//else{panelCustomer.Show();}
			}
		});
	}
}
