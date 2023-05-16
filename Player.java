import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;

class mainDraw extends JComponent {

  public int x = 0;
  public int y = 0;
  
  public KeyChecker keyC;

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.BLACK);
    for(int i=0;i<800;i+=50){
        g.fillRect(i-x,-y,20,500);
    }
    g.setColor(Color.PINK);
    g.fillRect(375,225,50,50);
  }

  public void moveRight() {
    x = x + 5;
    repaint();
  }

  public void moveLeft() {
    x = x - 5;
    repaint();
  }

  public void moveDown() {
    y = y + 5;
    repaint();
  }

  public void moveUp() {
    y = y - 5;
    repaint();
  }

  public void update(Player frame){
    if (frame.right){
      this.moveRight();
    }
    if (frame.left){
        this.moveLeft();
    }
    if (frame.down){
        this.moveDown();
    }
    if (frame.up){
        this.moveUp();
    }
    System.out.println(frame.right+" "+frame.left+" "+frame.down+" "+frame.up);
  }
}

public class Player extends JFrame implements KeyListener {
  private mainDraw draw;
  public boolean right = false;
  public boolean left = false;
  public boolean down = false;
  public boolean up = false;

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
    draw.update(this);
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
    draw.update(this);
  }

  public void keyTyped(KeyEvent e) {}

  public Player() {
    this.draw = new mainDraw();
    addKeyListener(this);
    setFocusable(true);
    setFocusTraversalKeysEnabled(false);
  }

  public static void main(String[] args) {
    Player frame = new Player();
    frame.setResizable(false);
    frame.setSize(800, 500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(frame.draw);
    frame.setVisible(true);
    Timer timer = new Timer(40, new ActionListener(){      // Timer 4 seconds
        public void actionPerformed(ActionEvent e) {
            frame.repaint();
        }
    });
    timer.start();
  }
}
