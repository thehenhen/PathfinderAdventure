import java.awt.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;

/**
 * The Menu class represents the game menu that extends JFrame and implements MouseListener and MouseMotionListener interfaces.
 * It handles mouse events and displays the menu graphics.
 */
public class Menu extends JFrame implements MouseListener, MouseMotionListener {
    private Image image;
    private int mouseX = 0;
    private int mouseY = 0;
    private boolean menu = true;
    private Font largeSerifFont;
    private Font smallSerifFont;
    private Font smallestSerifFont;
    private Font superSmallF;
    private boolean beatGame;

    /**
     * Constructs a Menu object.
     * Loads the necessary images and initializes fonts.
     * Adds mouse listeners to the frame.
     */
    public Menu() {
        try {
            image = ImageIO.read(new File("assets/background.jpg"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        largeSerifFont = new Font("Serif", Font.PLAIN, 80);
        smallSerifFont = new Font("Serif", Font.PLAIN, 60);
        smallestSerifFont = new Font("Serif", Font.PLAIN, 40);
        superSmallF = new Font("Serif", Font.PLAIN, 20);
        beatGame = false;
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    /**
     * Handles the mouse click event.
     * Updates the mouse coordinates and checks if the play button was clicked to start the game.
     *
     * @param e the MouseEvent object representing the mouse click event
     */
    public void mouseClicked(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        if (mouseX > 345 && mouseX < 455 && mouseY > 250 && mouseY < 290) {
            menu = false;
        }
    }

    /**
     * Handles the mouse enter event.
     *
     * @param e the MouseEvent object representing the mouse enter event
     */
    public void mouseEntered(MouseEvent e) {
        // Not used in this implementation
    }

    /**
     * Handles the mouse exit event.
     *
     * @param e the MouseEvent object representing the mouse exit event
     */
    public void mouseExited(MouseEvent e) {    }

    /**
     * Handles the mouse press event.
     *
     * @param e the MouseEvent object representing the mouse press event
     */
    public void mousePressed(MouseEvent e) {    }

    /**
     * Handles the mouse release event.
     *
     * @param e the MouseEvent object representing the mouse release event
     */
    public void mouseReleased(MouseEvent e) {    }

    /**
     * Handles the mouse move event.
     * Updates the mouse coordinates.
     *
     * @param e the MouseEvent object representing the mouse move event
     */
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    /**
     * Handles the mouse drag event.
     *
     * @param e the MouseEvent object representing the mouse drag event
     */
    public void mouseDragged(MouseEvent e) {
        // Not used in this implementation
    }

    /**
     * Overrides the paint method to draw the menu graphics.
     *
     * @param g the Graphics object
     */
    @Override
    public void paint(Graphics g) {
        if (menu) {
            update();

            // BACKGROUND
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, 800, 500);

            // DRAW STUFF HERE
            g.drawImage(image, 0, 0, 800, 500, null);

            g.setFont(largeSerifFont);
            g.setColor(Color.orange);
            g.drawString("PATHFINDER", 150, 150);
            g.setFont(smallSerifFont);
            g.drawString("ADVENTURE", 210, 200);
            g.setFont(smallestSerifFont);
            g.setColor(Color.yellow);
            g.drawString("PLAY", 350, 285);
            if (beatGame) {
                g.setFont(superSmallF);
                g.drawString("Thanks for playing!", 320, 230);
            }
        }
    }

    /**
     * Updates the menu.
     * This method can be used to implement any menu-related updates.
     */
    public void update() {    }

    public boolean getMenu(){
        return menu;
    }

    public void setMenu(boolean set){
        menu=set;
    }

    public boolean getBeat(){
        return beatGame;
    }

    public void setBeat(boolean set){
        beatGame=set;
    }
}
