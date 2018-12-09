package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSlider;

public class PasswordGeneration extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PasswordGeneration frame = new PasswordGeneration();
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
	public PasswordGeneration() {
		setTitle("Generate New Password");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 378, 198);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][grow][][][][][][][][][][][grow]", "[][][][][][][]"));
		
		JLabel lblDomain = new JLabel("Domain:");
		contentPane.add(lblDomain, "cell 0 0,alignx trailing");
		
		textField = new JTextField();
		contentPane.add(textField, "cell 3 0 9 1,growx");
		textField.setColumns(10);
		
		JLabel lblMinSpecial = new JLabel("Min special");
		contentPane.add(lblMinSpecial, "cell 0 1,alignx trailing");
		
		JSlider slider = new JSlider();
		contentPane.add(slider, "cell 2 1 8 1");
		
		JLabel lblMinNumbers = new JLabel("Min Numbers");
		contentPane.add(lblMinNumbers, "cell 0 2,alignx trailing");
		
		JSlider slider_1 = new JSlider();
		contentPane.add(slider_1, "cell 2 2 8 1");
		
		JLabel lblLength = new JLabel("Length");
		contentPane.add(lblLength, "cell 0 3,alignx trailing");
		
		JSlider slider_2 = new JSlider();
		contentPane.add(slider_2, "cell 1 3 9 1");
		
		JToggleButton tglbtnStoreToFile = new JToggleButton("Store to File");
		contentPane.add(tglbtnStoreToFile, "cell 0 4");
		
		JButton btnGeneratePassword = new JButton("generate Password");
		contentPane.add(btnGeneratePassword, "cell 9 4");
	}

}
