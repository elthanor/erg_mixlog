import static org.junit.Assert.*;

import javax.swing.JButton;
import javax.swing.JRadioButton;

import org.junit.Test;


public class mixlogTest {

	@Test
	public void testPushreviewRADIO1() {
		mixlog tester = new mixlog();
		JRadioButton rb1=(JRadioButton)tester.panelCustomer.getComponent(9);
		rb1.setSelected(true);
		assertEquals(true,tester.pushreview());
	}
	
	@Test
	public void testPushreviewRADIO2() {
		mixlog tester = new mixlog();
		JRadioButton rb2=(JRadioButton)tester.panelCustomer.getComponent(7);
		rb2.setSelected(true);
		assertEquals(true,tester.pushreview());
	}
	
	@Test
	public void testPushreviewRADIO3() {
		mixlog tester = new mixlog();
		JRadioButton rb3=(JRadioButton)tester.panelCustomer.getComponent(8);
		rb3.setSelected(true);
		assertEquals(true,tester.pushreview());
	}
	
	@Test
	public void testPushreviewRADIO4() {
		mixlog tester = new mixlog();
		JRadioButton rb4=(JRadioButton)tester.panelCustomer.getComponent(10);
		rb4.setSelected(true);
		assertEquals(true,tester.pushreview());
	}
	
	@Test
	public void testPushreviewRADIO5() {
		mixlog tester = new mixlog();
		JRadioButton rb5=(JRadioButton)tester.panelCustomer.getComponent(11);
		rb5.setSelected(true);
		assertEquals(true,tester.pushreview());
	}
	
	@Test
	public void testPushreviewFALSE() {
		mixlog tester = new mixlog();
		assertEquals(false,tester.pushreview());
	}

	@Test
	public void testNewsearch() {
		mixlog tester = new mixlog();
		assertEquals(true,tester.newsearch());
	}

	@Test
	public void testFetchreviews() {
		mixlog tester = new mixlog();
		tester.id_product=1;
		assertEquals(true,tester.fetchreviews().size()>1);
	}
	
	@Test
	public void testFetchreviewsFALSE() {
		mixlog tester = new mixlog();
		tester.id_product=15;
		assertEquals(true,tester.fetchreviews().size()==0);
	}

	@Test
	public void testProductclickedUSER() {
		mixlog tester = new mixlog();
		tester.rights="User";
		assertEquals(true,tester.productclicked(1));
	}
	
	@Test
	public void testProductclickedADMIN() {
		mixlog tester = new mixlog();
		tester.rights="Administrator";
		assertEquals(true,tester.productclicked(1));
	}
	
	@Test
	public void testProductclickedFALSE() {
		mixlog tester = new mixlog();
		tester.rights="qwfwqf";
		assertEquals(false,tester.productclicked(1));
	}

	@Test
	public void testDbgetproducts() {
		mixlog tester = new mixlog();
		assertEquals(true,tester.dbgetproducts("galaxy", (JButton)tester.panelSearch.getComponent(3), (JButton)tester.panelSearch.getComponent(4), (JButton)tester.panelSearch.getComponent(5), (JButton)tester.panelSearch.getComponent(6)));
	}

	@Test
	public void testCheckaccountUSER() {
		mixlog tester = new mixlog();
		assertEquals(true,tester.checkaccount("Lefteris", "1991"));
	}

	@Test
	public void testCheckaccountADMIN() {
		mixlog tester = new mixlog();
		assertEquals(true,tester.checkaccount("Giannis", "1982"));
	}
	
	@Test
	public void testCheckaccountFALSE() {
		mixlog tester = new mixlog();
		assertEquals(false,tester.checkaccount("qwfwfq", "qwfqwf"));
	}
	
	@Test
	public void testSignout() {
		mixlog tester = new mixlog();
		assertEquals(true,tester.signout());
	}

}
