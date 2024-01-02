package Main;

import javax.swing.JFrame;
import GUI.Interface;

public class MainWindow 
{
	static JFrame frame;
	static Interface inter;
	
	//Setup of Calculator
	public static void main(String[] args) {
		init();
		configureWindow();
		startClient();
	}
	
	static void init() {
		// Initialize
		frame = new JFrame();
		inter = new Interface();
	}
	
	static void configureWindow() {
		// Setup Window or frame
		frame.setTitle("Calculator");
		//inter.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(inter);
		frame.setVisible(true);
		frame.pack();
		frame.setResizable(false);
		inter.setFocusable(true);
		inter.requestFocusInWindow();
	}
	
	
	static void startClient() {
		while(true) {
			inter.repaint();
		}
	}
}
