import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;

public class MainFrame extends JFrame implements KeyListener{
    int x = 0;
    int y = 0;
    int inc;
    boolean right=false;
    boolean left=false;
    boolean down=false;
    boolean up=false;

    public MainFrame() {
        addKeyListener(this);
        Timer timer = new Timer(40, new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                MainFrame.this.repaint();
            }
        });
        timer.start();
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D){
            right=true;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A){
            left=true;
        }  
        if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S){
            down=true;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W){
            up=true;
        }
    }
    
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D){
            right=false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A){
            left=false;
        }  
        if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S){
            down=false;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W){
            up=false;
        }
    }
    public void keyTyped(KeyEvent e) {}

    public void paint(Graphics g) {
        update();

        // BACKGROUND
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.BLACK);
        for(int i=0;i<800;i+=50){
            g.fillRect(i-x,-y,20,500);
        }
        g.setColor(Color.PINK);
        g.fillRect(375,225,50,50);
    }

    public void update() {
        if (right){
            moveRight();
        }
        if (left){
            moveLeft();
        }
        if (down){
            moveDown();
        }
        if (up){
            moveUp();
        }
    }

    public void moveRight() {
        x = x + 5;
    }
    
    public void moveLeft() {
        x = x - 5;
    }
    
    public void moveDown() {
        y = y + 5;
    }
    
    public void moveUp() {
        y = y - 5;
    }

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setSize(800, 500);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }
}