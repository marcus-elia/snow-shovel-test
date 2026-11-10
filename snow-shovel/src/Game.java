import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Game extends JPanel implements ActionListener {
    private static final int screenWidth = 800;
    private static final int screenHeight = 400;
    
    private ArrayList<Square> squares;

    private final Timer timer;

    public Game() {
        // Create a Timer that triggers an ActionEvent every 10 milliseconds
        timer = new Timer(10, this);
        timer.start(); // Start the animation timer
        
        Road road = new Road(screenHeight/2, 1, 48, Square.SIZE);
        VerticalRoad verticalRoad = new VerticalRoad(screenWidth / 2, 40);
        
        squares = new ArrayList<Square>();
        for(int i = 0; i < screenWidth; i += Square.SIZE) {
        	for(int j = 0; j < screenHeight; j += Square.SIZE) {
        		if (road.isInRoad(i, j, Square.SIZE) || verticalRoad.isInRoad(i, j, Square.SIZE)) {
        			squares.add(new Pavement(i, j));
        		} else {
        			squares.add(new Grass(i, j));
        		}
        	}
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Clear the previous drawing
        for(Square s : squares) {
        	s.draw(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint(); // Request the JPanel to be redrawn
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snow Shovel World");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Game g = new Game();
        frame.add(g);
        frame.setSize(screenWidth, screenHeight);
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
    }
}