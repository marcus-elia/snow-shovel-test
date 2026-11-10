
public class VerticalRoad {
	private int xCenter;
	private int halfWidth;
	
	public VerticalRoad(int x, int w) {
		xCenter = x;
		halfWidth = w;
	}
	
	public boolean isInRoad(int topLeftX, int topLeftY, int size) {
		if (topLeftX >= xCenter + halfWidth) {
			return false;
		}
		if (topLeftX + size <= xCenter - halfWidth) {
			return false;
		}
		return true;
	}
}
