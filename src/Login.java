import javax.swing.JApplet;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JPanel;
import javax.swing.ImageIcon;


public class Login extends JApplet {
	private JTextField textUser;
	private JPasswordField passwordField;

	/**
	 * Create the applet.
	 */
	public Login() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Online \u03A3\u03C5\u03C3\u03C4\u03B7\u03BC\u03B1 \u0391\u03BE\u03B9\u03BF\u03BB\u03BF\u03B3\u03B7\u03C3\u03B7\u03C2 \u03A0\u03C1\u03BF\u03B9\u03CC\u03BD\u03C4\u03C9\u03BD");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 11, 430, 55);
		getContentPane().add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(10, 77, 113, 55);
		getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(10, 143, 113, 55);
		getContentPane().add(lblPassword);
		
		textUser = new JTextField();
		textUser.setBounds(133, 90, 113, 28);
		getContentPane().add(textUser);
		textUser.setColumns(10);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(57, 209, 89, 23);
		getContentPane().add(btnClear);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(157, 209, 89, 23);
		getContentPane().add(btnOk);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(133, 160, 113, 23);
		getContentPane().add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Bill-Greg\\Pictures\\Samsung\\20130928_021440.jpg"));
		lblNewLabel_1.setBounds(269, 77, 154, 153);
		getContentPane().add(lblNewLabel_1);

	}
}
