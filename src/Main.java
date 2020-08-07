import java.util.Timer;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Main{

	public static void main(String[] args) {

		//makes the default window for the game
		
		JFrame GameWindow = new GameWindow();
		
		
		while(true){
			GameWindow.repaint();
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}		

}
