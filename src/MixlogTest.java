import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JRadioButton;

import org.junit.AfterClass;
import org.junit.Test;


public class MixlogTest {
	
	@AfterClass
	public static void dbCleanup() {
		Mixlog tester = new Mixlog();
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn=DriverManager.getConnection(tester.database, tester.dbuser, tester.dbpass);
			stmt=conn.createStatement();
			String querry="DELETE FROM critics WHERE ID=0;";
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
	}

	@Test
	public void testPushreviewRADIO1() {
		Mixlog tester = new Mixlog();
		JRadioButton rb1=(JRadioButton)tester.panelCustomer.getComponent(9);
		rb1.setSelected(true);
		assertEquals(true,((PanelCustomer)tester.panelCustomer).pushreview());
	}
	
	@Test
	public void testPushreviewRADIO2() {
		Mixlog tester = new Mixlog();
		JRadioButton rb2=(JRadioButton)tester.panelCustomer.getComponent(7);
		rb2.setSelected(true);
		assertEquals(true,((PanelCustomer)tester.panelCustomer).pushreview());
	}
	
	@Test
	public void testPushreviewRADIO3() {
		Mixlog tester = new Mixlog();
		JRadioButton rb3=(JRadioButton)tester.panelCustomer.getComponent(8);
		rb3.setSelected(true);
		assertEquals(true,((PanelCustomer)tester.panelCustomer).pushreview());
	}
	
	@Test
	public void testPushreviewRADIO4() {
		Mixlog tester = new Mixlog();
		JRadioButton rb4=(JRadioButton)tester.panelCustomer.getComponent(10);
		rb4.setSelected(true);
		assertEquals(true,((PanelCustomer)tester.panelCustomer).pushreview());
	}
	
	@Test
	public void testPushreviewRADIO5() {
		Mixlog tester = new Mixlog();
		JRadioButton rb5=(JRadioButton)tester.panelCustomer.getComponent(11);
		rb5.setSelected(true);
		assertEquals(true,((PanelCustomer)tester.panelCustomer).pushreview());
	}
	
	@Test
	public void testPushreviewFALSE() {
		Mixlog tester = new Mixlog();
		assertEquals(false,((PanelCustomer)tester.panelCustomer).pushreview());
	}

	@Test
	public void testNewsearchCustomer() {
		Mixlog tester = new Mixlog();
		assertEquals(true,((PanelCustomer)tester.panelCustomer).newsearch(tester.panelSearch));
	}
	
	@Test
	public void testNewsearchManager() {
		Mixlog tester = new Mixlog();
		assertEquals(true,((PanelManager)tester.panelManager).newsearch(tester.panelSearch));
	}

	@Test
	public void testFetchreviews() {
		Mixlog tester = new Mixlog();
		((PanelManager)tester.panelManager).idproduct=3;
		assertEquals(true,((PanelManager)tester.panelManager).fetchreviews().size()>0);
	}
	
	@Test
	public void testFetchreviewsFALSE() {
		Mixlog tester = new Mixlog();
		((PanelManager)tester.panelManager).idproduct=15;
		assertEquals(true,((PanelManager)tester.panelManager).fetchreviews().size()==0);
	}

	@Test
	public void testProductclickedUSER() {
		Mixlog tester = new Mixlog();
		tester.rights="User";
		assertEquals(true,tester.productclicked(1));
	}
	
	@Test
	public void testProductclickedADMIN() {
		Mixlog tester = new Mixlog();
		tester.rights="Administrator";
		assertEquals(true,tester.productclicked(1));
	}
	
	@Test
	public void testProductclickedFALSE() {
		Mixlog tester = new Mixlog();
		tester.rights="qwfwqf";
		assertEquals(false,tester.productclicked(1));
	}

	@Test
	public void testDbgetproducts() {
		Mixlog tester = new Mixlog();
		assertEquals(true,((PanelSearch)tester.panelSearch).dbgetproducts("galaxy", (JButton)tester.panelSearch.getComponent(3), (JButton)tester.panelSearch.getComponent(4), (JButton)tester.panelSearch.getComponent(5), (JButton)tester.panelSearch.getComponent(6)));
	}

	@Test
	public void testCheckaccountUSER() {
		Mixlog tester = new Mixlog();
		assertEquals(true,((PanelLogin)tester.panelLogin).checkaccount("Lefteris", "1991"));
	}

	@Test
	public void testCheckaccountADMIN() {
		Mixlog tester = new Mixlog();
		assertEquals(true,((PanelLogin)tester.panelLogin).checkaccount("Giannis", "1982"));
	}
	
	@Test
	public void testCheckaccountFALSE() {
		Mixlog tester = new Mixlog();
		assertEquals(false,((PanelLogin)tester.panelLogin).checkaccount("qwfwfq", "qwfqwf"));
	}
	
	@Test
	public void testSignout() {
		Mixlog tester = new Mixlog();
		assertEquals(true,tester.signout());
	}
	
	@Test
	public void testBrowseUP() {
		Mixlog tester=new Mixlog();
		ArrayList<String> critics = new ArrayList<String>();
		critics.add("fqwfqwf");
		critics.add("fqwfqwf");
		assertEquals(true,((PanelManager)tester.panelManager).browse(0,true,critics));
	}
	
	@Test
	public void testBrowseDOWN() {
		Mixlog tester=new Mixlog();
		ArrayList<String> critics = new ArrayList<String>();
		critics.add("fqwfqwf");
		critics.add("fqwfqwf");
		assertEquals(true,((PanelManager)tester.panelManager).browse(2,false,critics));
	}
}
