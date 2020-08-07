import java.awt.Color;
import java.awt.Graphics;


public class Ball {
	
	//member variables
	private int x;
	private int y;
	private int xVel;
	private int yVel;

	//constructor
	public Ball(int x, int y){
		this.x = x;
		this.y = y;
		xVel = 5;
		yVel = 5;
	}

	//draw function for ball
	public void draw(Graphics g){
		g.setColor(Color.WHITE);
		g.fillOval(x, y, 15, 15);
	}

	//update location for ball
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
