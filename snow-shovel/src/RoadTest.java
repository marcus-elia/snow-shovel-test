import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RoadTest {

	@Test
	void testCenterY() {
		// Horizontal Line at x = 0
		assertEquals(0, Road.centerY(0, 0, 0, 10));
		assertEquals(0, Road.centerY(0, 1, 0, 10));
		assertEquals(0, Road.centerY(0, 9, 0, 10));
		assertEquals(10, Road.centerY(0, 10, 0, 10));
		assertEquals(10, Road.centerY(0, 11, 0, 10));
		assertEquals(10, Road.centerY(0, 19, 0, 10));
		assertEquals(-10, Road.centerY(0, -1, 0, 10));
		assertEquals(-10, Road.centerY(0, -9, 0, 10));
		assertEquals(-10, Road.centerY(0, -10, 0, 10));
		// Horizontal Line at x != 0
		assertEquals(0, Road.centerY(0, 0, 25, 10));
		assertEquals(0, Road.centerY(0, 1, 25, 10));
		assertEquals(0, Road.centerY(0, 9, 25, 10));
		assertEquals(10, Road.centerY(0, 10, 25, 10));
		assertEquals(10, Road.centerY(0, 11, 25, 10));
		assertEquals(10, Road.centerY(0, 19, 25, 10));
		assertEquals(-10, Road.centerY(0, -1, 25, 10));
		assertEquals(-10, Road.centerY(0, -9, 25, 10));
		assertEquals(-10, Road.centerY(0, -10, 25, 10));
		// Diagonal Line at x = 0
		assertEquals(0, Road.centerY(1, 0, 0, 10));
		assertEquals(0, Road.centerY(1, 1, 0, 10));
		assertEquals(0, Road.centerY(1, 9, 0, 10));
		assertEquals(10, Road.centerY(1, 10, 0, 10));
		assertEquals(10, Road.centerY(1, 11, 0, 10));
		assertEquals(10, Road.centerY(1, 19, 0, 10));
		assertEquals(-10, Road.centerY(1, -1, 0, 10));
		assertEquals(-10, Road.centerY(1, -9, 0, 10));
		assertEquals(-10, Road.centerY(1, -10, 0, 10));
		// Diagonal Line at x != 0
		assertEquals(20, Road.centerY(1, 0, 25, 10));
		assertEquals(20, Road.centerY(1, 1, 25, 10));
		assertEquals(30, Road.centerY(1, 9, 25, 10));
		assertEquals(30, Road.centerY(1, 10, 25, 10));
		assertEquals(30, Road.centerY(1, 11, 25, 10));
		assertEquals(40, Road.centerY(1, 19, 25, 10));
		assertEquals(20, Road.centerY(1, -1, 25, 10));
		assertEquals(10, Road.centerY(1, -9, 25, 10));
		assertEquals(10, Road.centerY(1, -10, 25, 10));
		// Negative slope line
		assertEquals(-220, Road.centerY(-10, 30, 25, 10));
	}

	@Test
	void testTileDifference() {
		// Horizontal zero line at the y-axis
		assertEquals(0, Road.tileDifference(5, 5, 0, 0, 10));
		assertEquals(1, Road.tileDifference(5, 15, 0, 0, 10));
		assertEquals(2, Road.tileDifference(5, 25, 0, 0, 10));
		assertEquals(-1, Road.tileDifference(5, -5, 0, 0, 10));
		assertEquals(-2, Road.tileDifference(5, -15, 0, 0, 10));
		// Horizontal zero line at non-zero x-value
		assertEquals(0, Road.tileDifference(25, 5, 0, 0, 10));
		assertEquals(7, Road.tileDifference(25, 75, 0, 0, 10));
		// Horizontal non-zero line
		assertEquals(-1, Road.tileDifference(5, 5, 0, 18, 10));
		assertEquals(3, Road.tileDifference(5, 15, 0, -20, 10));
		// Diagonal line, not on the y-axis
		assertEquals(2, Road.tileDifference(-1, 15, 1, 0, 10));
		assertEquals(1, Road.tileDifference(0, 15, 1, 0, 10));
		assertEquals(1, Road.tileDifference(3, 15, 1, 0, 10));
		assertEquals(1, Road.tileDifference(9, 15, 1, 0, 10));
		assertEquals(0, Road.tileDifference(10, 15, 1, 0, 10));
		assertEquals(0, Road.tileDifference(14, 15, 1, 0, 10));
		assertEquals(-1, Road.tileDifference(24, 15, 1, 0, 10));
		assertEquals(-1, Road.tileDifference(25, 15, 1, 0, 10));
		assertEquals(-2, Road.tileDifference(34, 15, 1, 0, 10));
		assertEquals(-2, Road.tileDifference(35, 15, 1, 0, 10));		
	}
	
	@Test
	void testIsTooLow() {
		// Basic lowness checks for horizontal line
		assertFalse(Road.isTooLow(5, 5, 0, 0, 10, 2));
		assertFalse(Road.isTooLow(5, 5, 0, 0, 10, 1));
		assertTrue(Road.isTooLow(5, 5, 0, 0, 10, 0));
		assertFalse(Road.isTooLow(5, 15, 0, 0, 10, 2));
		assertTrue(Road.isTooLow(5, 15, 0, 0, 10, 1));
		assertTrue(Road.isTooLow(5, 15, 0, 0, 10, 0));
		assertTrue(Road.isTooLow(5, 25, 0, 0, 10, 2));
		assertTrue(Road.isTooLow(5, 25, 0, 0, 10, 1));
		assertTrue(Road.isTooLow(5, 25, 0, 0, 10, 0));
		assertFalse(Road.isTooLow(5, -45, 0, 0, 10, 2));
		assertFalse(Road.isTooLow(5, -45, 0, 0, 10, 1));
		assertFalse(Road.isTooLow(5, -45, 0, 0, 10, 0));
		// Basic highness checks for horizontal line
		assertFalse(Road.isTooHigh(5, -5, 0, 0, 10, 2));
		assertFalse(Road.isTooHigh(5, -5, 0, 0, 10, 1));
		assertTrue(Road.isTooHigh(5, -5, 0, 0, 10, 0));
		assertFalse(Road.isTooHigh(5, -15, 0, 0, 10, 2));
		assertTrue(Road.isTooHigh(5, -15, 0, 0, 10, 1));
		assertTrue(Road.isTooHigh(5, -15, 0, 0, 10, 0));
		// Diagonal Line
		assertTrue(Road.isTooLow(30, 15, 1, -20, 10, 0));
		assertFalse(Road.isTooHigh(30, 15, 1, -20, 10, 0));
		assertFalse(Road.isTooLow(30, 5, 1, -20, 10, 0));
		assertTrue(Road.isTooHigh(30, 5, 1, -20, 10, 0));
		assertFalse(Road.isTooLow(30, 15, 1, -20, 10, 1));
		assertFalse(Road.isTooHigh(30, 15, 1, -20, 10, 1));
		assertFalse(Road.isTooLow(30, 5, 1, -20, 10, 1));
		assertFalse(Road.isTooHigh(30, 5, 1, -20, 10, 1));
	}
}
