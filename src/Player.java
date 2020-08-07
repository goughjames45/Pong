import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JPanel;


public class Player{

	//member variables
	private int x;
	private int y;
	private int xVel;
	private int yVel;
	private int score;
	private int scorePosX;
	
	//constructor
	public Player(int x, int y, int scorePosX){
		this.x = x;
		this.y = y;
		xVel = 0;
		yVel = 0;
		score = 0;
		this.scorePosX = scorePosX;
	}
	
	public void updateScore(){
		score++;
	}

	//draw function for player
	public void draw(Graphics g){
		
		
		g.setColor(Color.WHITE);
        g.fillRect(x, y, 15, 75);
        
        int fontSize = 40;
		g.setFont(new Font("Serif", Font.BOLD, fontSize));
		g.setColor(Color.WHITE);
		g.drawString(Integer.toString(score), scorePosX, 60);
    }

	//updates the location of player
	public void updateLocation(){	
		x+=xVel;
		y+=yVel;
	}
	
	//getters and setters
	public int getX(){
		return x;
	}

	public void setX(int x){
		this.x = x;
	}

	public int getY(){
		return y;
	}

	public void setY(int y){
		this.y = y;
	}
	
	public int getXVel(){
		return xVel;
	}

	public void setXVel(int xVel){
		this.xVel = xVel;
	}

	public int getYVel(){
		return yVel;
	}

	public void setYVel(int yVel){
		this.yVel = yVel;
	}


}
