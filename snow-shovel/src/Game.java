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
        
        squares = new ArrayList<Square>();
        squares.add(new Grass(0, 0));
        squares.add(new Grass(24, 0));
        squares.add(new Pavement(0, 24));
        squares.add(new Pavement(0, 48));
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