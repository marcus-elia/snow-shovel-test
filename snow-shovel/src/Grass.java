import java.awt.Color;
import java.awt.Graphics;

public class Grass extends Square {
	
	private static int NUM_GRASS_PATCHES = 12;
	private double[] grassPatchLocationsX;
	private double[] grassPatchLocationsY;

	public Grass(int topLeftX, int topLeftY) {
		x = topLeftX;
		y = topLeftY;
		setSnowInches(0);
		
		grassPatchLocationsX = new double[NUM_GRASS_PATCHES];
		grassPatchLocationsY = new double[NUM_GRASS_PATCHES];
		for(int i = 0; i < NUM_GRASS_PATCHES; i++) {
			grassPatchLocationsX[i] = Math.random();
			grassPatchLocationsY[i] = Math.random();
		}
	}
	
	@Override
	public void draw(Graphics g) {
		// Draw the interior of the square
		if (snowInches > 0) {
			g.setColor(snowColor);
			g.fillRect(x, y, SIZE, SIZE);
		} else {
			g.setColor(Color.white);
			g.fillRect(x, y, SIZE, SIZE);
			g.setColor(Color.green);
			for(int i = 0; i < NUM_GRASS_PATCHES; i++) {
				g.fillRect(x + (int)(SIZE * grassPatchLocationsX[i]), y + (int)(SIZE * grassPatchLocationsY[i]), 2, 2);
			}
		}

		// Draw the border of the square
		if (snowInches > 0) {
			g.setColor(Color.LIGHT_GRAY);
		} else {
			g.setColor(Color.GRAY);
		}
		g.drawRect(x, y, SIZE, SIZE);
	}
}