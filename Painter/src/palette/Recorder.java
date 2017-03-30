package palette;

import java.awt.Color;

public class Recorder {
	/*
	 * -1表示未选中
	 * 0表示圆
	 * 1表示长方形
	 * 2表示线
	 * 3表示橡皮擦
	 */
	public static int state = -1;
	public static boolean isFirst = true;
	public static int tmp_x;
	public static int tmp_y;
	public static Color tmp_color = Color.BLACK;
	public static Color color_default = Color.BLACK;
	public static Color color_bg = Color.orange;
	
	
}
