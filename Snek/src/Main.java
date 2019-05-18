import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Main {
	
	//Konstruktor
	public Main() {
		
		//JFrame window setup
		JFrame frame = new JFrame("Snek");
		GamePanel gamePanel = new GamePanel();
		
		frame.add(gamePanel);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
		
	}

}
