import java.awt.Color;
import java.awt.Graphics;

public class Grass extends Square {

	public Grass(int topLeftX, int topLeftY) {
		x = topLeftX;
		y = topLeftY;
		snow = false;
	}
	
	@Override
	public void draw(Graphics g) {
		// Draw the interior of the square
		if (snow) {
			g.setColor(Color.white);
		} else {
			g.setColor(Color.green);
		}
		g.fillRect(x, y, SIZE, SIZE);

		// Draw the border of the square
		if (snow) {
			g.setColor(Color.LIGHT_GRAY);
		} else {
			g.setColor(Color.GRAY);
		}
		g.drawRect(x, y, SIZE, SIZE);
	}
}