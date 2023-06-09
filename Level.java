import javax.swing.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

/**
 * Parent Level class
 */
public class Level extends JPanel{
    /**
     * Coords of player
     */
    int playerX;
    int playerY;
    /**
     * Coords of mouse
     */
    int mouseX;
    int mouseY;
    /**
     * Size of player
     */
    int playerSize;
    /**
     * Boolean variables to determine if player can move in respective directions
     */
    boolean cright;
    boolean cleft;
    boolean cdown;
    boolean cup;
    /**
     * Constructor to construct Level class
     */
    public Level() {}

    /**
     * Inherited listener methods
     * @param e
     */
    public void keyPressed(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseMoved(MouseEvent e) {}
    public void mouseDragged(MouseEvent e) {}
    /**
     * Gets playerX
     * @return
     */
    public int getPlayerX(){
        return playerX;
    }

    /**
     * Gets playerY
     * @return
     */
    public int getPlayerY(){
        return playerY;
    }
    
    /**
     * Paint method
     */
    public void paint(Graphics g) {}
}