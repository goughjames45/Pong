import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class GameWindow extends JFrame implements KeyListener{

	//private class variables
	private Player player1, player2;
	private JPanel panel;
	private Ball ball;

	private Graphics offgc;
	private Image offscreen = null;
	private Dimension d;



	public GameWindow(){
		//add key listener and constructs window
		addKeyListener(this);
		setTitle("Pong");
		setSize(640, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);

		//sets up panel
		panel = new JPanel();
		panel.setSize(640, 480);
		panel.setBackground(Color.BLACK);
		add(panel);


		//creates player
		player1 = new Player(10, 100, 240);
		player2 = new Player(615, 100, 375);
		ball = new Ball(300, 240);

		d = getSize();

	}

	public void paint(Graphics g){

		//double buffering
		offscreen = createImage(d.width, d.height);
		offgc = offscreen.getGraphics();
		// clear the exposed area
		
		offgc.setColor(getBackground());
		offgc.fillRect(0, 0, d.width, d.height);
		offgc.setColor(getForeground());
		
		// do normal redraw
		
		super.paint(offgc);
		// transfer offscreen to window
		g.drawImage(offscreen, 0, 0, this);
		
		
		int fontSize = 40;
		g.setFont(new Font("Serif", Font.BOLD, fontSize));
		g.setColor(Color.WHITE);
		g.drawString("Score", 270, 60);
		
		
		player1.draw(g);
		player2.draw(g);
		ball.draw(g);
		ball.updateLocation();
		player1.updateLocation();
		player2.updateLocation();

		

		//collision
		if(ball.getX() >= 615){		//right side of screen
			ball.setXVel(-5);
			player1.updateScore();
		}
		if(ball.getY() >= 450){		//bottom of screen
			ball.setYVel(-5);
		}
		if(ball.getX() <= 6){		//left of screen
			ball.setXVel(5);
			player2.updateScore();
		}
		if(ball.getY() <= 25){		//top of screen
			ball.setYVel(5);
		}
		//player-ball collision
		if(ball.getX() - 15 == player1.getX() && ball.getY() >= player1.getY() && ball.getY() <= (player1.getY() + 75)){
			ball.setXVel(5);
			
		}
		if(ball.getX() + 15 == player2.getX() && ball.getY() >= player2.getY() && ball.getY() <= (player2.getY() + 75)){
			ball.setXVel(-5);
			
		}
		if(player1.getY() - 25 <= 0 || player1.getY() + 90 >= 480){
			player1.setYVel(0);
		}
		if(player2.getY() - 25 <= 0 || player2.getY() + 90 >= 480){
			player2.setYVel(0);
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		//player 1 controls
		if(e.getKeyCode() == KeyEvent.VK_W){
			if(player1.getY() - 25 >= 0)
				player1.setYVel(-5);
		}
		if(e.getKeyCode() == KeyEvent.VK_A){
			//player1.updateLocation(-5, 0);
		}
		if(e.getKeyCode() == KeyEvent.VK_S){
			if(player1.getY() + 90 <= 480)
				player1.setYVel(5);

		}
		if(e.getKeyCode() == KeyEvent.VK_D){
			//player1.updateLocation(5, 0);
		}


		//player two controls
		if(e.getKeyCode() == KeyEvent.VK_UP){
			if(player2.getY() - 25 >= 0)
				player2.setYVel(-5);
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			//player2.updateLocation(-5, 0);

		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			if(player2.getY() + 90 <= 480)
				player2.setYVel(5);
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			//player2.updateLocation(5, 0);
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		//player 1 controls
		if(e.getKeyCode() == KeyEvent.VK_W){
			player1.setYVel(0);
		}
		if(e.getKeyCode() == KeyEvent.VK_A){
			//player1.updateLocation(-5, 0);
		}
		if(e.getKeyCode() == KeyEvent.VK_S){
			player1.setYVel(0);
		}
		if(e.getKeyCode() == KeyEvent.VK_D){
			//player1.updateLocation(5, 0);
		}


		//player two controls
		if(e.getKeyCode() == KeyEvent.VK_UP){
			player2.setYVel(0);
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			//player2.updateLocation(-5, 0);

		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			player2.setYVel(0);

		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			//player2.updateLocation(5, 0);
		}

	}

	@Override
	public void keyTyped(KeyEvent arg0) {	}

}
