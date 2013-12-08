import javax.swing.JApplet;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;


public class Manager_Search extends JApplet {
	private JTextField textField;

	/**
	 * Create the applet.
	 */
	public Manager_Search() {
		getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 11, 233, 30);
		getContentPane().add(textField);
		
		JButton button = new JButton("Search");
		button.setBounds(250, 11, 87, 30);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("Sign Out");
		button_1.setBounds(347, 11, 87, 30);
		getContentPane().add(button_1);
		
		JLabel label = new JLabel("");
		label.setBounds(10, 52, 209, 117);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(225, 52, 209, 117);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(10, 172, 209, 117);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(225, 172, 209, 117);
		getContentPane().add(label_3);

	}

}
