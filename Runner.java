import java.awt.event.*;
import javax.swing.JFrame;

/**
 * Purpose: Runner class that creats a JFrame and runs the game
 */
public class Runner extends JFrame implements KeyListener, MouseListener, MouseMotionListener {

    /**
     * The various scene objects to display to the JFrame
     */
    private Menu menu = new Menu();
    private FirstLevel first = new FirstLevel();
    private SecondLevel second = new SecondLevel();
    private ThirdLevel third = new ThirdLevel();

    /**
     * Purpose: Constructs a Runner object.
     */
    public Runner() {
        menu.addKeyListener(this);
        menu.addMouseListener(this);
        menu.addMouseMotionListener(this);
    }

    /**
     * Purpose: Handles the key press event.
     * @param e the KeyEvent object
     */
    public void keyPressed(KeyEvent e) {
        if (first.getFirst()) {
            first.keyPressed(e);
        } else if (second.getSecond()) {
            second.keyPressed(e);
        } else if (third.getThird()) {
            third.keyPressed(e);
        }
    }

    /**
     * Purpose: Handles the key release event.
     * @param e the KeyEvent object
     */
    public void keyReleased(KeyEvent e) {
        if (first.getFirst()) {
            first.keyReleased(e);
        } else if (second.getSecond()) {
            second.keyReleased(e);
        } else if (third.getThird()) {
            third.keyReleased(e);
        }
    }

    public void keyTyped(KeyEvent e) {    }

    /**
     * Purpose: Handles the mouse click event.
     * @param e the MouseEvent object
     */
    public void mouseClicked(MouseEvent e) {
        if (first.getFirst()) {
            first.mouseClicked(e);
        } else if (second.getSecond()) {
            second.mouseClicked(e);
        } else if (third.getThird()) {
            third.mouseClicked(e);
        }
    }

    //Unused interface methods
    public void mouseEntered(MouseEvent e) {    }
    public void mouseExited(MouseEvent e) {    }
    public void mousePressed(MouseEvent e) {    }
    public void mouseReleased(MouseEvent e) {    }
    public void mouseDragged(MouseEvent e) {    }

    /**
     * Purpose: Handles the mouse move event.
     * @param e the MouseEvent object
     */
    public void mouseMoved(MouseEvent e) {
        if (first.getFirst()) {
            first.mouseMoved(e);
        } else if (second.getSecond()) {
            second.mouseMoved(e);
        } else if (third.getThird()) {
            third.mouseMoved(e);
        }
    }

    /**
     * Purpose: Creates the JFrame and runs the game
     */
    public void run() {
        menu.setSize(800, 500);
        menu.setResizable(false);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setVisible(true);
        while (true) {
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (menu.getMenu()) {
                // Do nothing, only need to repaint once
            } else if (first.getFirst()) {
                first.repaint();
                menu.add(first);
                menu.setVisible(true);
            } else if (second.getSecond()) {
                second.repaint();
                menu.add(second);
                menu.setVisible(true);
            } else if (third.getThird()) {
                third.repaint();
                menu.add(third);
                menu.setVisible(true);
            } else {
                menu.setMenu(true);
                menu.setBeat(true);
                menu.repaint();
                first.restart();
                second.restart();
                third.restart();
            }
        }
    }

    /**
     * The main method.
     * Creates a Runner object and starts the game.\
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Runner r = new Runner();
        r.run();
    }
}
