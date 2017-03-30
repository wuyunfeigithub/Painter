package Sprite;

import java.awt.Graphics;

public class Line extends Sprite{

	public int end_x;
	public int end_y;
	
	public Line(int x, int y, int endx, int endy){
		this.x = x;
		this.y = y;
		this.end_x = endx;
		this.end_y = endy;
	}
	
	public void setProperty(int x,int y,int endx, int endy){
		this.x = x;
		this.y = y;
		this.end_x = endx;
		this.end_y = endy;
	}
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawLine(x, y, end_x, end_y);
	}

	public void draw(Graphics g, int x,int y,int endx, int endy) {
		setProperty(x, y, endx, endy);
		g.drawLine(this.x, this.y, this.end_x, this.end_y);
	}
}
