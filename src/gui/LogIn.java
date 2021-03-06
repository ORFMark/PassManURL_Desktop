package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogIn {

	private JFrame frmPasswordManagerLogin;
	private JTextField userNameFeild;
	private JPasswordField passwordField;
	private JButton submitPassword;
	private JButton newLogin;

	/**
	 * Launch the application.
	 */
	public static void launch(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn window = new LogIn();
					window.frmPasswordManagerLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LogIn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPasswordManagerLogin = new JFrame();
		frmPasswordManagerLogin.setTitle("Password Manager: Login");
		frmPasswordManagerLogin.setBounds(100, 100, 449, 160);
		frmPasswordManagerLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPasswordManagerLogin.getContentPane().setLayout(new MigLayout("", "[][grow]", "[][][][][][][][][]"));
		
		JLabel lblUsername = new JLabel("Username:");
		frmPasswordManagerLogin.getContentPane().add(lblUsername, "cell 0 1,alignx trailing");
		
		userNameFeild = new JTextField();
		frmPasswordManagerLogin.getContentPane().add(userNameFeild, "cell 1 1,growx");
		userNameFeild.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		frmPasswordManagerLogin.getContentPane().add(lblPassword, "cell 0 3,alignx trailing");
		
		passwordField = new JPasswordField();
		frmPasswordManagerLogin.getContentPane().add(passwordField, "cell 1 3,growx");
		
		submitPassword = new JButton("Submit");
		submitPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(userNameFeild.getText() != null && !userNameFeild.getText().isEmpty() && passwordField.getPassword() != null && passwordField.getPassword().length != 0) {
					System.out.println("Found stuff to check!");
				}
			}
		});
		frmPasswordManagerLogin.getContentPane().add(submitPassword, "flowx,cell 1 5,alignx center");
		
		newLogin = new JButton("Create a new account");
		frmPasswordManagerLogin.getContentPane().add(newLogin, "cell 1 5");
	}

}
