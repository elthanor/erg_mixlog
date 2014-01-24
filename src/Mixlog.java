import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Mixlog {

	private JFrame frame;
	protected String rights;
	protected int idproduct;
	ArrayList<String> critics;
	String database="jdbc:mysql://localhost:3306/db_mixlog";
	String dbuser="root";
	String dbpass="kaparomilo";
	JPanel panelLogin=new PanelLogin(database,dbuser,dbpass);
	JPanel panelSearch=new PanelSearch(database,dbuser,dbpass);
	JPanel panelManager = new PanelManager(database,dbuser,dbpass);
	JPanel panelCustomer = new PanelCustomer(database,dbuser,dbpass);

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mixlog window = new Mixlog();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Mixlog() {
		initialize();
		initializepanelsbuttons();
	}

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

	private void initializepanelsbuttons() {
		JButton btnOk=(JButton)panelLogin.getComponent(5);
		final JTextField textUser=(JTextField)panelLogin.getComponent(3);
		final JPasswordField passwordField=(JPasswordField)panelLogin.getComponent(6);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textUser.getText().length()>0 && new String(passwordField.getPassword()).length()>0) {
					if(!((PanelLogin)panelLogin).checkaccount(textUser.getText(),new String(passwordField.getPassword()))) {
						JOptionPane.showMessageDialog(null, "Wrong username/password!");
					}
					else {
						rights=((PanelLogin)panelLogin).rights;
						panelSearch.setVisible(true);
					}
				}
				else {JOptionPane.showMessageDialog(null, "Enter username and password");}
			}
		});
		JButton btnClear=(JButton)panelLogin.getComponent(4);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				signout();
			}
		});
		
		JButton btnSignOut=(JButton)panelSearch.getComponent(2);
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				signout();
			}
		});
		JButton btnSearch=(JButton)panelSearch.getComponent(1);
		final JTextField txtSearchbox=(JTextField)panelSearch.getComponent(0);
		final JButton btnProduct1=(JButton)panelSearch.getComponent(3);
		final JButton btnProduct2=(JButton)panelSearch.getComponent(4);
		final JButton btnProduct3=(JButton)panelSearch.getComponent(5);
		final JButton btnProduct4=(JButton)panelSearch.getComponent(6);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtSearchbox.getText().length()>0) {
				((PanelSearch)panelSearch).dbgetproducts(txtSearchbox.getText(),btnProduct1,btnProduct2,btnProduct3,btnProduct4);
				}
				else {JOptionPane.showMessageDialog(null, "Enter some text to search");}
			}
		});
		btnProduct1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				productclicked(Integer.parseInt(btnProduct1.getText()));
			}
		});
		btnProduct2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				productclicked(Integer.parseInt(btnProduct2.getText()));
			}
		});
		btnProduct3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				productclicked(Integer.parseInt(btnProduct3.getText()));
			}
		});
		btnProduct4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				productclicked(Integer.parseInt(btnProduct4.getText()));
			}
		});
		
		JButton btnLogout=(JButton)panelManager.getComponent(6);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				signout();
			}
		});
		JButton btnNewSearch=(JButton)panelManager.getComponent(5);
		btnNewSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				((PanelManager)panelManager).newsearch(panelSearch);
			}
		});
		final JButton btnPrevious=(JButton)panelManager.getComponent(2);
		final JTextPane txtpnReview=(JTextPane)panelManager.getComponent(7);
		final JButton btnNext=(JButton)panelManager.getComponent(3);
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				((PanelManager)panelManager).browse(critics.indexOf(txtpnReview.getText()),false,critics);
			}
		});
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				((PanelManager)panelManager).browse(critics.indexOf(txtpnReview.getText()),true,critics);
			}
		});
		
		JButton btnClearReview=(JButton)panelCustomer.getComponent(3);
		btnClearReview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				((JTextPane)panelCustomer.getComponent(6)).setText("");
			}
		});
		JButton btnLogOutCustomer=(JButton)panelCustomer.getComponent(5);
		btnLogOutCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				signout();
			}
		});
		JButton btnNewSearchCustomer=(JButton)panelCustomer.getComponent(12);
		btnNewSearchCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				((PanelCustomer)panelCustomer).newsearch(panelSearch);
			}
		});
		JButton btnReview=(JButton)panelCustomer.getComponent(4);
		btnReview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				((PanelCustomer)panelCustomer).idproduct=idproduct;
				if(((PanelCustomer)panelCustomer).pushreview()) {
					JOptionPane.showMessageDialog(null, "Review Submitted !");
				}
			}
		});
	}	

	protected boolean productclicked(int id) {
		panelSearch.getComponent(3).setVisible(false);
		panelSearch.getComponent(4).setVisible(false);
		panelSearch.getComponent(5).setVisible(false);
		panelSearch.getComponent(6).setVisible(false);
		panelSearch.setVisible(false);
		if(rights.contains("User")) {
			panelCustomer.setVisible(true);
			idproduct=id;
			return true;
		}
		else if(rights.contains("Administrator")) {
			idproduct=id;
			panelManager.setVisible(true);
			((PanelManager)panelManager).idproduct=idproduct;
			critics=((PanelManager)panelManager).fetchreviews();
			if (critics.size()<=1)((JButton)panelManager.getComponent(3)).setEnabled(false);
			return true;
		}
		return false;
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
		JButton btnPrevious=(JButton)panelManager.getComponent(2);
		btnPrevious.setEnabled(false);
		JButton btnNext=(JButton)panelManager.getComponent(3);
		btnNext.setEnabled(true);
		return true;
	}
}