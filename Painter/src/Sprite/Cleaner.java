package Sprite;

import java.awt.Graphics;

import palette.Recorder;

public class Cleaner extends Sprite{

	int width;
	int height;
	
	public Cleaner(int x, int y){
		this.x = x;
		this.y = y;
		
		this.width = 10;
		this.height = 10;
		
		this.color = Recorder.color_bg;
	}
	
	public void setPosition(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
//		g.setColor(color);
		g.clearRect(this.x, this.y, this.width, this.height);
	}

}
