import javax.swing.JApplet;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;


public class Customer_search extends JApplet {
	private JTextField txtSearchbox;

	/**
	 * Create the applet.
	 */
	public Customer_search() {
		getContentPane().setLayout(null);
		
		txtSearchbox = new JTextField();
		txtSearchbox.setBounds(10, 11, 233, 30);
		getContentPane().add(txtSearchbox);
		txtSearchbox.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBounds(253, 11, 87, 30);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 52, 209, 117);
		getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setBounds(229, 52, 209, 117);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(10, 180, 209, 117);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(229, 180, 209, 117);
		getContentPane().add(label_2);
		
		JButton btnSignOut = new JButton("Sign Out");
		btnSignOut.setBounds(350, 11, 87, 30);
		getContentPane().add(btnSignOut);

	}
}
