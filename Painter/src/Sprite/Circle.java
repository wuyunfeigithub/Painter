package Sprite;

import java.awt.Graphics;

public class Circle extends Sprite{

	public int width;
	public int height;
	
	public Circle(int x,int y,int width,int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void setProperty(int x,int y,int width,int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawOval(this.x, this.y, this.width, this.height);
	}

}
