import java.awt.Color;
import java.awt.Graphics;

public class Apple {

	public int xACoor, yACoor, Awidth, Aheight;
	
	public Apple(int tileSize) {
		this.xACoor = (int)( Math.random() * 100);
		this.yACoor = (int)( Math.random() * 100);
		Awidth = tileSize;
		Aheight = tileSize;
	}
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.drawOval(xACoor * 8, yACoor * 8, 16, 16);
	}
	
}
