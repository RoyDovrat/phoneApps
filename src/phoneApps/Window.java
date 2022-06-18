package phoneApps;

import javax.swing.JFrame;


public class Window {

	
	private JFrame frame;
	
	public Window(String title, SuperMarket supmar){
		frame = new JFrame(title);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close window after click on X
		frame.setResizable(false);	// the size of the window can not be changed
		
		
		frame.add(supmar);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		
		
		//game.start();
		
	}
	
}