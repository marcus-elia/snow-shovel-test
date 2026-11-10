import java.awt.Color;
import java.awt.Graphics;

public class Pavement extends Square {

	public Pavement(int topLeftX, int topLeftY) {
		x = topLeftX;
		y = topLeftY;
		setSnowInches(0);
	}
	
	@Override
	public void draw(Graphics g) {
		// Draw the interior of the square
		if (snowInches > 0) {
			g.setColor(snowColor);
		} else {
			g.setColor(Color.black);
		}
		g.fillRect(x, y, SIZE, SIZE);

		// Draw the border of the square
		if (snowInches > 0) {
			g.setColor(Color.LIGHT_GRAY);
		} else {
			g.setColor(Color.GRAY);
		}
		g.drawRect(x, y, SIZE, SIZE);
	}
}
