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
 * Purpose: Menu class that displays the menu
 */
public class Menu extends JFrame implements MouseListener, MouseMotionListener {
    /**
     * Background image
     */
    private Image image;
    /**
     * x-coordinate of mouse
     */
    private int mouseX = 0;
    /**
     * y-coordinate of mouse
     */
    private int mouseY = 0;
    /**
     * Boolean variable that represents if menu should display
     */
    private boolean menu = true;
    /**
     * Large font
     */
    private Font largeSerifFont;
    /**
     * Small font
     */
    private Font smallSerifFont;
    /**
     * Smaller font
     */
    private Font smallestSerifFont;
    /**
     * Smallest font
     */
    private Font superSmallF;
    /**
     * Boolean variable that represents if player has beat game
     */
    private boolean beatGame;

    /**
     * Purpose: Constructs a Menu object
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
     * Purpose: Handles the mouse click event.
     * @param e the MouseEvent object
     */
    public void mouseClicked(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        if (mouseX > 345 && mouseX < 455 && mouseY > 250 && mouseY < 290) {
            menu = false;
        }
    }


    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}

    /**
     * Purpose: Handles the mouse move event.
     * Updates the mouse coordinates.
     * @param e the MouseEvent object
     */
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }


    public void mouseDragged(MouseEvent e) {}

    /**
     * Purpose: method to draw to the JPanel
     * @param g the Graphics object
     */
    public void paint(Graphics g) {
        if (menu) {
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, 800, 500);
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
     * Purpose: Accessor method that returns if menu should display
     * @return menu
     */
    public boolean getMenu(){
        return menu;
    }

    /**
     * Purpose: Mutator method that sets the menu variable
     * @param set var to set menu to
     */
    public void setMenu(boolean set){
        menu=set;
    }

    /**
     * Purpose: Accessor method that returns if player has beat game
     * @return beatGame
     */
    public boolean getBeat(){
        return beatGame;
    }

    /**
     * Purpose: Mutator method that sets the beatGame variable
     * @param set var tp set neatGame to
     */
    public void setBeat(boolean set){
        beatGame=set;
    }
}
