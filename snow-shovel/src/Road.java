
public class Road {
	// A road is the region bounded by two lines, both with slope m.
	// One has intercept b - halfWidth, the other b + halfWidth.
	private int b; // Intercept
	private int m; // Slope
	private int halfWidth; // Line thickness in number of tiles
	
	public Road(int i, int s, int w, int tileSize) {
		b = i;
		m = s;
		halfWidth = Math.max(w / tileSize, 1);
	}
	
	// Find the vertical center of a line, and round down to the nearest square boundary location.
	public static int centerY(int m, int b, int x, int squareSize) {
		int y = m*x + b;
		return Math.floorDiv(y, squareSize) * squareSize;
	}
	
	public static int tileDifference(int squareCenterX, int squareCenterY, int m, int b, int squareSize) {
		int lineCenterY = centerY(m, b, squareCenterX, squareSize);
		return Math.floorDiv(squareCenterY - lineCenterY, squareSize);
	}
	
	// Check if a square is above the top line of this road, given its center point 
	public static boolean isTooHigh(int squareCenterX, int squareCenterY, int m, int b, int squareSize, int halfWidth) {
		int tileDifference = -tileDifference(squareCenterX, squareCenterY, m, b, squareSize);
		return tileDifference > halfWidth;
	}
	
	public static boolean isTooLow(int squareCenterX, int squareCenterY, int m, int b, int squareSize, int halfWidth) {
		int tileDifference = tileDifference(squareCenterX, squareCenterY, m, b, squareSize);
		return tileDifference >= halfWidth;
	}
	
	// Check if the square defined by the args intersects this road.
	public boolean isInRoad(int topLeftX, int topLeftY, int squareSize) {
		int centerX = topLeftX + squareSize/2;
		int centerY = topLeftY + squareSize/2;
		return !isTooLow(centerX, centerY, m, b, squareSize, halfWidth) 
			&& !isTooHigh(centerX, centerY, m, b, squareSize, halfWidth);
	}
}
