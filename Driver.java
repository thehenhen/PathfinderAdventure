import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Driver extends JFrame{
    public Starting startFrame;

    public Driver() {
        startFrame = new Starting();
        Timer timer = new Timer(40, new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Driver.this.repaint();
            }
        });
        timer.start();
    }

    public void paint(Graphics g) {  
        System.out.println("paint");
        if(startFrame.starting){
            startFrame.setSize(800,500);
            startFrame.setResizable(false);
            startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            add(startFrame);
        }
        
    }

    public void update() {}

    public static void main(String[] args) { 
        Driver d = new Driver();     
        d.setSize(800, 500);
        d.setResizable(false);
        d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        d.setVisible(true);
        System.out.println("main");
    }
}