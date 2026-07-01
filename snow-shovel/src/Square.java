
import java.awt.Graphics;

public abstract class Square {
	public static int SIZE = 24;
	
	protected int x, y;
	protected boolean snow;
	
	public abstract void draw(Graphics g);
}
