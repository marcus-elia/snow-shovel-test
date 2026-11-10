
import java.awt.Color;
import java.awt.Graphics;

public abstract class Square {
	public static int SIZE = 24;
	protected static int MAX_INCHES = 12;
	
	protected int x, y;
	protected int snowInches;
	protected Color snowColor;
	
	public abstract void draw(Graphics g);
	
	public void setSnowInches(int inches) {
		snowInches = Math.min(inches, MAX_INCHES);
		int snowColorValue = 255 - Square.MAX_INCHES + snowInches;
		snowColor = new Color(snowColorValue, snowColorValue, snowColorValue);
	}
	
	public void addSnow(int inches) {
		setSnowInches(snowInches + inches);
	}
}
