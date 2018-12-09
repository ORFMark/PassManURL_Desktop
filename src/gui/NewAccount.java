package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class NewAccount extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewAccount frame = new NewAccount();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NewAccount() {
		setTitle("Create New Account");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 393, 169);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow]", "[][][][][]"));
		
		JLabel lblUsername = new JLabel("Username:");
		contentPane.add(lblUsername, "cell 0 1,alignx trailing");
		
		textField = new JTextField();
		contentPane.add(textField, "cell 1 1,growx");
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		contentPane.add(lblPassword, "cell 0 2,alignx trailing");
		
		passwordField = new JPasswordField();
		contentPane.add(passwordField, "cell 1 2,growx");
		
		JLabel lblConfirm = new JLabel("Confirm:");
		contentPane.add(lblConfirm, "cell 0 3");
		
		passwordField_1 = new JPasswordField();
		contentPane.add(passwordField_1, "cell 1 3,growx");
	}

}
