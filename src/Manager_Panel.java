import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextPane;


public class Manager_Panel extends JApplet {

	/**
	 * Create the applet.
	 */
	public Manager_Panel() {
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u039C\u03AD\u03C3\u03BF\u03C2 \u038C\u03C1\u03BF\u03C2");
		label.setBounds(10, 60, 100, 38);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("1");
		label_1.setBounds(120, 60, 100, 38);
		getContentPane().add(label_1);
		
		JButton btnPreview = new JButton("Previous");
		btnPreview.setBounds(10, 225, 89, 23);
		getContentPane().add(btnPreview);
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(109, 225, 89, 23);
		getContentPane().add(btnNext);
		
		JLabel label_2 = new JLabel("\u03A3\u03C4\u03B1\u03C4\u03B9\u03C3\u03C4\u03B9\u03BA\u03AC");
		label_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(10, 11, 430, 38);
		getContentPane().add(label_2);
		
		JButton btnBack = new JButton("New Search");
		btnBack.setBounds(208, 225, 122, 23);
		getContentPane().add(btnBack);
		
		JButton btnLogout = new JButton("Sign Out");
		btnLogout.setBounds(340, 225, 89, 23);
		getContentPane().add(btnLogout);
		
		JTextPane txtpnReview = new JTextPane();
		txtpnReview.setText("Review");
		txtpnReview.setEditable(false);
		txtpnReview.setBounds(10, 89, 430, 126);
		getContentPane().add(txtpnReview);

	}

}
