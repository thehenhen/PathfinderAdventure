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
        while( !shouldStop )
        {
            try {
                Thread.sleep( 500 );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if( !pause )
            {
                if(menu.menu){
                    menu.repaint();
                    menu.setSize(800,500);
                    menu.setResizable(false);
                    menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    menu.setVisible(true);
                }
                else if(first.first){
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
        for(int x=-800;x<800;x++){
            int y=100;
            /* 
            //if ((y + 250 >= 50 && y + 250 <= 150) || (y + 250 >= 50 && y + 250 <= 150)) {
                //System.out.println("within");
                if (x + 400 >= 100 - x && x + 400 <= 100 - x) {
                    System.out.println(x);
                }
            //}*/
            

            int x1=200;
            int x2=200;

            

            //if ((y + 250 >= 50 && y + 250 <= 150) || (y + 250 >= 50 && y + 250 <= 150)) {
                //System.out.println("within");
                if (x + 550== 200 - x) {
                    System.out.println(x);
                }
            //}

        }
        Runner r = new Runner();
        r.run();
    }
}