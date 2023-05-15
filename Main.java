import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//from   www. ja  v a 2  s  .c o m
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.event.KeyAdapter;

class mainDraw extends JComponent {

  public int x = 0;
  public int y = 0;
  public KeyChecker keyC;

  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    if(keyC.keyPressed()){

    }


    g.setColor(Color.BLACK);
    for(int i=0;i<800;i+=50){
        g.fillRect(i-x,-y,20,500);
    }
    g.setColor(Color.PINK);
    g.fillRect(400, 250, 50, 50);
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
}

public class Main extends JFrame implements KeyListener {
  private mainDraw draw;
  

  public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_RIGHT)
      draw.moveRight();
    else if (e.getKeyCode() == KeyEvent.VK_LEFT)
      draw.moveLeft();
    else if (e.getKeyCode() == KeyEvent.VK_DOWN)
      draw.moveDown();
    else if (e.getKeyCode() == KeyEvent.VK_UP)
      draw.moveUp();
  }

  public void keyReleased(KeyEvent e) {}

  public void keyTyped(KeyEvent e) {}

  public Main() {
    this.draw = new mainDraw();
    KeyChecker keyC = new KeyChecker();
    addKeyListener(this);
    setFocusable(true);
    setFocusTraversalKeysEnabled(false);
  }

  public static void main(String[] args) {
    Main frame = new Main();
    frame.setResizable(false);
    frame.setSize(800, 500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(frame.draw);
    frame.setVisible(true);
  }
}
