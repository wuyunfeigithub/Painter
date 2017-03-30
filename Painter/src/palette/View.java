package palette;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.MenuBar;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.text.AbstractDocument.LeafElement;

import Sprite.Cleaner;
import Sprite.Sprite;
import Sprite.SpriteBase;


public class View extends JFrame {

	Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
	int screen_width = (int) screensize.getWidth();
	int screen_height = (int) screensize.getHeight();

	int window_width = 800;
	int window_heigth = 480;

	JPanel leftPanel = null;
	JPanel top = null;
	
	//橡皮擦
//	Cleaner cleaner = new Cleaner(0, 0);
	// 添加组件
	JMenuBar menubar = null;

	public SpriteBase myPanel;
	public Sprite tmpSprite;
	
	JLabel label = null;
	JButton yuan = null;
	JButton zheng = null;
	JButton line = null;
	JButton xiangpi = null;
	JButton clean = null;
	
	JLabel  color_label = null;
	JButton red = null;
	JButton black = null;
	JButton white = null;
	JButton cyan = null;
	JButton gray = null;
	JButton green = null;
	JButton orange = null;
	JButton pink = null;
	JButton yellow = null;
	
	// 图标
	Image icon = null;
	Image icon_zheng = null;
	Image icon_yuan = null;
	Image icon_line = null;
	
	Controller listener = null;

	public View() {

		icon = new ImageIcon(getClass().getResource("/img/icon.jpg")).getImage();
		icon_zheng = new ImageIcon(getClass().getResource("/img/zheng.png")).getImage();
		icon_yuan = new ImageIcon(getClass().getResource("/img/yuan.png")).getImage();
		icon_line = new ImageIcon(getClass().getResource("/img/line.png")).getImage();
		

		listener = new Controller();
		
		// 组件布局
		menubar = new JMenuBar();

		color_label = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("/img/color.png")).getImage()));
//		color_label.setSize(width, height);;
		
		
		red = new JButton();
		red.setBackground(Color.red);
		red.setActionCommand("red");
		red.addActionListener(listener);;
		black = new JButton();
		black.setBackground(Color.black);
		black.setActionCommand("black");
		black.addActionListener(listener);;
		white = new JButton();
		white.setBackground(Color.white);
		white.setActionCommand("white");
		white.addActionListener(listener);;
		cyan = new JButton();
		cyan.setBackground(Color.cyan);
		cyan.setActionCommand("cyan");
		cyan.addActionListener(listener);;
		gray = new JButton();
		gray.setBackground(Color.gray);
		gray.setActionCommand("gray");
		gray.addActionListener(listener);;
		green = new JButton();
		green.setBackground(Color.green);
		green.setActionCommand("green");
		green.addActionListener(listener);;
		orange = new JButton();
		orange.setBackground(Color.orange);
		orange.setActionCommand("orange");
		orange.addActionListener(listener);;
		pink = new JButton();
		pink.setBackground(Color.pink);
		pink.setActionCommand("pink");
		pink.addActionListener(listener);;
		yellow = new JButton();
		yellow.setBackground(Color.yellow);
		yellow.setActionCommand("yellow");
		yellow.addActionListener(listener);;
		
		
		menubar.add(new JLabel("      "));
		menubar.add(color_label);
		menubar.add(new JLabel("   颜色    "));
		menubar.add(red);
		menubar.add(new JLabel(" "));
		menubar.add(black);
		menubar.add(new JLabel(" "));
		menubar.add(white);
		menubar.add(new JLabel(" "));
		menubar.add(cyan);
		menubar.add(new JLabel(" "));
		menubar.add(cyan);
		menubar.add(new JLabel(" "));
		menubar.add(gray);
		menubar.add(new JLabel(" "));
		menubar.add(green);
		menubar.add(new JLabel(" "));
		menubar.add(orange);
		menubar.add(new JLabel(" "));
		menubar.add(pink);
		menubar.add(new JLabel(" "));
		menubar.add(yellow);
		menubar.add(new JLabel(" "));
		

			
		yuan = new JButton(new ImageIcon(icon_yuan));
		yuan.setText("  圆形");
		yuan.setBackground(Color.white);
		yuan.setActionCommand("yuan");
		yuan.addActionListener(listener);
		
		zheng = new JButton(new ImageIcon(icon_zheng));
		zheng.setText("  矩形");
		zheng.setBackground(Color.white);
		zheng.setActionCommand("zheng");
		zheng.addActionListener(listener);
		
		line = new JButton(new ImageIcon(icon_line));
		line.setText("  直线");
		line.setBackground(Color.white);
		line.setActionCommand("line");
		line.addActionListener(listener);
		
		xiangpi = new JButton(new ImageIcon(new ImageIcon(getClass().getResource("/img/xiangpi.png")).getImage()));
		xiangpi.setText("  橡皮");
		xiangpi.setBackground(Color.white);
		xiangpi.setActionCommand("xiangpi");
		xiangpi.addActionListener(listener);
		
		clean = new JButton();
		clean.setText("    清  空    ");
		clean.setBackground(Color.white);
		clean.setActionCommand("clean");
		clean.addActionListener(listener);
		
		label = new JLabel("        工具栏");
		
		
		this.setJMenuBar(menubar);
		
		this.setLayout(null);
		
		leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		leftPanel.setBounds(0, 0, 100, window_heigth);
		leftPanel.setBackground(Color.LIGHT_GRAY);
		leftPanel.add(label);
		leftPanel.add(yuan);
		leftPanel.add(zheng);
		leftPanel.add(line);
		leftPanel.add(xiangpi);
		leftPanel.add(clean);
		this.add(leftPanel);
		
		myPanel = new SpriteBase(window_width,window_heigth);
		myPanel.setBounds(100, 0, window_width, window_heigth);
		myPanel.addMouseListener(listener);
		myPanel.addMouseMotionListener(listener);
		Thread t = new Thread(myPanel);		
		t.start();
		this.add(myPanel);

		this.setIconImage(icon);
		this.setTitle("画板(casegame制作)");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(screen_width / 2 - window_width / 2, screen_height / 2 - window_heigth / 2);

		this.setSize(window_width, window_heigth);
		this.setVisible(true);
	}
}
