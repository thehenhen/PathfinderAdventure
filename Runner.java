import java.awt.event.*;
import javax.swing.JFrame;

/**
 * The Runner class represents a game runner that extends JFrame and implements the event listeners.
 * It manages the game menu and the different levels of the game.
 */
public class Runner extends JFrame implements KeyListener, MouseListener, MouseMotionListener {

    private Menu menu = new Menu();
    private FirstLevel first = new FirstLevel();
    private SecondLevel second = new SecondLevel();
    private ThirdLevel third = new ThirdLevel();

    /**
     * Constructs a Runner object.
     * Initializes event listeners for the menu.
     */
    public Runner() {
        menu.addKeyListener(this);
        menu.addMouseListener(this);
        menu.addMouseMotionListener(this);
    }

    /**
     * Handles the key press event.
     * Passes the event to the corresponding level based on the current active level.
     *
     * @param e the KeyEvent object representing the key press event
     */
    public void keyPressed(KeyEvent e) {
        if (first.getFirst()) {
            first.keyPressed(e);
        } else if (second.second) {
            second.keyPressed(e);
        } else if (third.third) {
            third.keyPressed(e);
        }
    }

    /**
     * Handles the key release event.
     * Passes the event to the corresponding level based on the current active level.
     *
     * @param e the KeyEvent object representing the key release event
     */
    public void keyReleased(KeyEvent e) {
        if (first.getFirst()) {
            first.keyReleased(e);
        } else if (second.second) {
            second.keyReleased(e);
        } else if (third.third) {
            third.keyReleased(e);
        }
    }

    /**
     * Handles the key typed event.
     *
     * @param e the KeyEvent object representing the key typed event
     */
    public void keyTyped(KeyEvent e) {    }

    /**
     * Handles the mouse click event.
     * Passes the event to the corresponding level based on the current active level.
     *
     * @param e the MouseEvent object representing the mouse click event
     */
    public void mouseClicked(MouseEvent e) {
        if (first.getFirst()) {
            first.mouseClicked(e);
        } else if (second.second) {
            second.mouseClicked(e);
        } else if (third.third) {
            third.mouseClicked(e);
        }
    }

    /**
     * Handles the mouse enter event.
     *
     * @param e the MouseEvent object representing the mouse enter event
     */
    public void mouseEntered(MouseEvent e) {    }

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
     * Passes the event to the corresponding level based on the current active level.
     *
     * @param e the MouseEvent object representing the mouse move event
     */
    public void mouseMoved(MouseEvent e) {
        if (first.getFirst()) {
            first.mouseMoved(e);
        } else if (second.second) {
            second.mouseMoved(e);
        } else if (third.third) {
            third.mouseMoved(e);
        }
    }

    /**
     * Handles the mouse drag event.
     *
     * @param e the MouseEvent object representing the mouse drag event
     */
    public void mouseDragged(MouseEvent e) {    }

    /**
     * Runs the game.
     * Sets up the menu frame, initializes levels, and manages the game loop.
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
            } else if (second.second) {
                second.repaint();
                menu.add(second);
                menu.setVisible(true);
            } else if (third.third) {
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
     * Creates a Runner object and starts the game.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Runner r = new Runner();
        r.run();
    }
}
