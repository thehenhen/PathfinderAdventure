import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Level extends JPanel implements KeyListener,MouseListener,MouseMotionListener{
    int playerX;
    int playerY;
    int mouseX;
    int mouseY;
    
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
    public void mouseMoved(MouseEvent e) {
        mouseX=e.getX();
        mouseY=e.getY();
    }
    public void mouseDragged(MouseEvent e) {}
    public boolean mouseDetect(int x1,int x2,int y1,int y2){
        return(mouseX>=x1 && mouseX<=x2 && mouseY>=y1 && mouseY<=y2);
    }
    
    public void paint(Graphics g) {
        // BACKGROUND
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 800, 500);

        //DRAW STUFF HERE
    }
}