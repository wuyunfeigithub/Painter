package palette;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import Sprite.Circle;
import Sprite.Line;
import Sprite.Rectangle;

public class Controller implements ActionListener, MouseMotionListener, MouseListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getActionCommand().equals("zheng")) {
			Recorder.state = 1;
		}
		if (arg0.getActionCommand().equals("yuan")) {
			Recorder.state = 0;
		}
		if (arg0.getActionCommand().equals("line")) {
			Recorder.state = 2;
		}
		if (arg0.getActionCommand().equals("xiangpi")) {
			Recorder.state = 3;
//			MainClass.myView.myPanel.cleanAll();
			MainClass.myView.myPanel.cleanLast();
		}
		if (arg0.getActionCommand().equals("clean")) {
			MainClass.myView.myPanel.cleanAll();
		}
		if (arg0.getActionCommand().equals("red")) {
			Recorder.tmp_color = Color.red;
		}
		if (arg0.getActionCommand().equals("black")) {
			Recorder.tmp_color = Color.black;
		}
		if (arg0.getActionCommand().equals("white")) {
			Recorder.tmp_color = Color.white;
		}
		if (arg0.getActionCommand().equals("blue")) {
			Recorder.tmp_color = Color.blue;
		}
		if (arg0.getActionCommand().equals("cyan")) {
			Recorder.tmp_color = Color.cyan;
		}
		if (arg0.getActionCommand().equals("gray")) {
			Recorder.tmp_color = Color.gray;
		}
		if (arg0.getActionCommand().equals("green")) {
			Recorder.tmp_color = Color.green;
		}
		if (arg0.getActionCommand().equals("orange")) {
			Recorder.tmp_color = Color.orange;
		}
		if (arg0.getActionCommand().equals("pink")) {
			Recorder.tmp_color = Color.pink;
		}
		if (arg0.getActionCommand().equals("yellow")) {
			Recorder.tmp_color = Color.yellow;
		}
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int x = arg0.getX();
		int y = arg0.getY();
		if (Recorder.state == 0) {
			if (MainClass.myView.tmpSprite != null) {
				Circle tmp = (Circle) MainClass.myView.tmpSprite;
				
				if (Recorder.isFirst) {
					Recorder.tmp_x = tmp.x;
					Recorder.tmp_y = tmp.y;
					Recorder.isFirst = false;
				}
				
				tmp.width = x - Recorder.tmp_x;
				if (x - Recorder.tmp_x < 0) { 
					
					tmp.x = x;
					tmp.width = Math.abs(tmp.width);
				}
				tmp.height = y - Recorder.tmp_y;
				if (y - Recorder.tmp_y < 0) {
					tmp.y = y;
					tmp.height = Math.abs(tmp.height);
				}
			}
		} else if (Recorder.state == 1) {
			if (MainClass.myView.tmpSprite != null) {
				Rectangle tmp = (Rectangle) MainClass.myView.tmpSprite;
				
				if (Recorder.isFirst) {
					Recorder.tmp_x = tmp.x;
					Recorder.tmp_y = tmp.y;
					Recorder.isFirst = false;
				}
				
				tmp.width = x - Recorder.tmp_x;
				if (x - Recorder.tmp_x < 0) { 
					
					tmp.x = x;
					tmp.width = Math.abs(tmp.width);
				}
				tmp.height = y - Recorder.tmp_y;
				if (y - Recorder.tmp_y < 0) {
					tmp.y = y;
					tmp.height = Math.abs(tmp.height);
				}
			}
		} else if (Recorder.state == 2) {
			if (MainClass.myView.tmpSprite != null) {
				Line tmp = (Line) MainClass.myView.tmpSprite;				
				tmp.end_x = x;
				tmp.end_y = y;
			}
		}
//		else if (Recorder.state == 3) {
//			System.out.println("xiangpi drag");
//			MainClass.myView.cleaner.setPosition(x, y);
//			MainClass.myView.cleaner.draw(MainClass.myView.myPanel.getGraphics());
//			
//		}
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		// 0 yuan 1 chang 2 xian
		if (Recorder.state == 0) {
			MainClass.myView.tmpSprite = new Circle(e.getX(), e.getY(), 0, 0);
			MainClass.myView.tmpSprite.color = Recorder.tmp_color;
			MainClass.myView.myPanel.addSprite(MainClass.myView.tmpSprite);
		} else if (Recorder.state == 1) {
			MainClass.myView.tmpSprite = new Rectangle(e.getX(), e.getY(), 0, 0);
			MainClass.myView.tmpSprite.color = Recorder.tmp_color;
			MainClass.myView.myPanel.addSprite(MainClass.myView.tmpSprite);
		} else if (Recorder.state == 2) {
			MainClass.myView.tmpSprite = new Line(e.getX(), e.getY(), e.getX(), e.getY());
			MainClass.myView.tmpSprite.color = Recorder.tmp_color;
			MainClass.myView.myPanel.addSprite(MainClass.myView.tmpSprite);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		Recorder.state = -1;
		Recorder.isFirst = true;
		MainClass.myView.tmpSprite = null;
	}

}
