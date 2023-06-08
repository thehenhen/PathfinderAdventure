import javax.swing.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Level extends JPanel{
    int playerX;
    int playerY;
    int mouseX;
    int mouseY;
    int playerSize;
    
    boolean cright;
    boolean cleft;
    boolean cdown;
    boolean cup;

    public Level() {}

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
    public int getPlayerX(){
        return playerX;
    }

    public int getPlayerY(){
        return playerY;
    }
    
    public void paint(Graphics g) {}
}