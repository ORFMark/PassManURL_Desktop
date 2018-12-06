package gui;

import javax.swing.*;
public class GUITest {


	public static void createTestGUI() {
		// TODO Auto-generated method stub
		JFrame newFrame = new JFrame("HelloWorld");
		JLabel newLabel = new JLabel("HI!");
		newFrame.add(newLabel);
		newFrame.pack();
		newFrame.setVisible(true);
	}
	
}
