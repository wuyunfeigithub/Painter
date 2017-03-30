package Sprite;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Sprite{

	public int width = 0;
	public int height = 0;
	
	public Rectangle(int x,int y,int width,int height){
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
		g.drawRect(x, y, width, height);
	}
	
	public void draw(Graphics g,int x,int y,int width,int height) {
		// TODO Auto-generated method stub
		setProperty(x, y, width, height);
		g.drawRect(this.x, this.y, this.width, this.height);
	}

}
