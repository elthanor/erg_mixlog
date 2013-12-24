import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTextPane;


public class Customer_Review extends JApplet {

	/**
	 * Create the applet.
	 */
	public Customer_Review() {
		getContentPane().setLayout(null);
		
		JLabel label_1 = new JLabel("\u0391\u03BE\u03B9\u03BF\u03BB\u03CC\u03B3\u03B7\u03C3\u03B7 \u03A0\u03C1\u03BF\u03CA\u03CC\u03BD\u03C4\u03BF\u03C2");
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(10, 0, 430, 58);
		getContentPane().add(label_1);
		
		JRadioButton radioButton = new JRadioButton("New radio button");
		radioButton.setBounds(147, 83, 21, 23);
		getContentPane().add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("New radio button");
		radioButton_1.setBounds(170, 83, 21, 23);
		getContentPane().add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("New radio button");
		radioButton_2.setBounds(193, 83, 21, 23);
		getContentPane().add(radioButton_2);
		
		JRadioButton radioButton_3 = new JRadioButton("New radio button");
		radioButton_3.setBounds(216, 83, 21, 23);
		getContentPane().add(radioButton_3);
		
		JRadioButton radioButton_4 = new JRadioButton("New radio button");
		radioButton_4.setBounds(239, 83, 21, 23);
		getContentPane().add(radioButton_4);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(179, 11, -87, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("  1      2      3      4     5");
		lblNewLabel_1.setBounds(147, 65, 117, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblReview = new JLabel("Review");
		lblReview.setBounds(10, 106, 117, 23);
		getContentPane().add(lblReview);
		
		JButton btnOk = new JButton("Clear");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnOk.setBounds(20, 248, 117, 23);
		getContentPane().add(btnOk);
		
		JButton button = new JButton("OK");
		button.setBounds(147, 248, 117, 23);
		getContentPane().add(button);
		
		JButton btnSignOut = new JButton("Sign Out");
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSignOut.setBounds(274, 248, 117, 23);
		getContentPane().add(btnSignOut);
		
		JPanel panel = new JPanel();
		panel.setBounds(111, 53, 204, 58);
		getContentPane().add(panel);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 140, 430, 97);
		getContentPane().add(textPane);

	}
}
