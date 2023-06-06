import java.awt.event.*;
import javax.swing.JFrame;

public class Runner extends JFrame implements KeyListener,MouseListener
{
    private boolean shouldStop = false;

    private boolean pause = false;

    Menu menu = new Menu();
    FirstLevel first = new FirstLevel();

    public Runner(){
        menu.addKeyListener(this); 
    }

    public void keyPressed(KeyEvent e) {
        if(first.first){
            first.keyPressed(e);
        }
    }
    
    public void keyReleased(KeyEvent e) {
        if(first.first){
            first.keyReleased(e); 
        }
    }

    public void keyTyped(KeyEvent e) {}
    
    public void mouseClicked(MouseEvent e) {
        if(first.first){
            first.mouseClicked(e);
        }
    }
    public void mouseEntered(MouseEvent e) {}


    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}

    public void shouldStop() {
        this.shouldStop = true;
    }

    public void pauseGame() { pause = true; }

    public void resumeGame() { pause = false; }

    public void run()
    {
        menu.setSize(800,500);
        menu.setResizable(false);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setVisible(true);
        while( !shouldStop )
        {
            try {
                Thread.sleep( 40 );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if( !pause )
            {
                if(menu.menu){
                    menu.repaint();
                }
                else 
                if(first.first){
                    first.repaint();
                    menu.add(first);
                    menu.setVisible(true);
                }
            }
        }
    }

    public boolean isPaused() {
        return pause;
    }

    public static void main(String[] args){
        Runner r = new Runner();
        r.run();
    }
}