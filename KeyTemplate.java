import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;

public class KeyTemplate extends JFrame implements KeyListener{
    public KeyTemplate() {
        addKeyListener(this);
        Timer timer = new Timer(40, new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                KeyTemplate.this.repaint();
            }
        });
        timer.start();
    }

    public void keyPressed(KeyEvent e) {}
    
    public void keyReleased(KeyEvent e) {}

    public void keyTyped(KeyEvent e) {}

    public void paint(Graphics g) {
        update();

        // BACKGROUND
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        // DRAW STUFF HERE

    }

    public void update() {
        
    }
    public static void main(String[] args) {
        KeyTemplate frame = new KeyTemplate();
        frame.setSize(800, 500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}