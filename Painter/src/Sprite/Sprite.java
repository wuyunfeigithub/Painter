package Sprite;

import java.awt.Color;
import java.awt.Graphics;

import palette.Recorder;

public abstract class Sprite {

	public int x;
	public int y;
	
	public Color color = Recorder.color_default;
	
	abstract public void draw(Graphics g);
}
