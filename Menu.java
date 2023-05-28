import java.awt.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements MouseListener,MouseMotionListener{
    Image image;
    int x=0;
    int y=0;
    boolean menu=true;
    Font largeSerifFont;
    Font smallSerifFont;
    Font smallestSerifFont;

    public Menu(){
        try {
            image = ImageIO.read(new File("background.jpg"));
        }catch (Exception e){
            e.printStackTrace();
        }
        largeSerifFont = new Font("Serif", Font.PLAIN, 80);
        smallSerifFont = new Font("Serif", Font.PLAIN, 60);
        smallestSerifFont = new Font("Serif", Font.PLAIN, 40);
        addMouseListener(this);
        addMouseMotionListener(this);
        Timer timer = new Timer(50, new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Menu.this.repaint();
            }
        });
        timer.start();
    }

    public void mouseClicked(MouseEvent e) {
        x=e.getX();
        y=e.getY();
        if(x>345 && x<455 && y>250 && y<290){
            System.out.println("start");
            menu=false;
        }
    }
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseMoved(MouseEvent e) {
        x=e.getX();
        y=e.getY();
    }
    public void mouseDragged(MouseEvent e) {}

    public static void main (String[] args){
        Menu frame = new Menu();
        frame.setSize(800,500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void paint(Graphics g) {
        if(menu){
            update();

            // BACKGROUND
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, getWidth(), getHeight());

            // DRAW STUFF HERE
            g.drawImage(image,0,0,800,500,null);
            g.setFont(largeSerifFont);
            g.setColor(Color.orange);
            g.drawString("PATHFINDER", 150, 150);
            g.setFont(smallSerifFont);
            g.drawString("ADVENTURE", 210, 200);
            g.setFont(smallestSerifFont);
            g.setColor(Color.yellow);
            g.drawString("PLAY",350,285);
        }
    }

    public void update(){

    }
}