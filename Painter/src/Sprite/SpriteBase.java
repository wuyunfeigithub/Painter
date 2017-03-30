package Sprite;

import java.awt.Graphics;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JPanel;

public class SpriteBase extends JPanel implements Runnable {

	private int base_X;
	private int base_Y;
	
	private Vector<Object> vector = new Vector<>();
	
	public SpriteBase(int x, int y){
		base_X = x;
		base_Y = y;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
//		g.fillRect(0, 0, base_X, base_Y);

		
		for (Iterator iterator = vector.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			
			g.setColor(((Sprite)object).color);
			if(object instanceof Rectangle){
				((Rectangle) object).draw(g);
			}
			else if (object instanceof Circle) {
				((Circle) object).draw(g);				
			}
			else if (object instanceof Line) {
				((Line) object).draw(g);
			}
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				Thread.sleep(20);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			// 定时重绘面板
			this.repaint();
		}
	}
	
	public void addSprite(Object o){
		vector.add(o);
	}
	
	public void cleanAll(){
		vector.clear();
	}
	
	public void cleanLast(){
		if (vector.size() != 0) {
			vector.remove(vector.lastElement());
		}
	}
}
