import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstLevel extends JPanel implements KeyListener,MouseListener,MouseMotionListener{
    int x = 0;
    int y = 0;
    int mouseX=0;
    int mouseY=0;
    int inc;
    int playerSize=50;


    boolean right=false;
    boolean left=false;
    boolean down=false;
    boolean up=false;
    
    boolean cright=true;
    boolean cleft=true;
    boolean cdown=true;
    boolean cup=true;

    boolean first=true;
    boolean mapOpen = false;
    Image map;
    Image mapIcon;

    Wall[] walls;

    public FirstLevel() {
        try {
            map = ImageIO.read(new File("map1.png"));
            mapIcon = ImageIO.read(new File("mapIcon.png"));
        }catch (Exception e){
            e.printStackTrace();
        }
        addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);
        walls=new Wall[10];
        walls[0]= new Wall(1,100,200,450,200);
        walls[1]= new Wall(2,200,200,200,300);
        Timer timer = new Timer(40, new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                FirstLevel.this.repaint();
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

    public void mouseClicked(MouseEvent e) {
        if(mouseDetect(700,750,25,75)){
            mapOpen=!mapOpen;
        }
    }
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseMoved(MouseEvent e) {
        mouseX=e.getX();
        mouseY=e.getY();
    }
    public void mouseDragged(MouseEvent e) {}
    public boolean mouseDetect(int x1,int x2,int y1,int y2){
        return(mouseX>=x1 && mouseX<=x2 && mouseY>=y1 && mouseY<=y2);
    }
    

    public void paint(Graphics g) {
        update();

        // BACKGROUND
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        //DRAW STUFF HERE
        g.setColor(Color.BLACK);
        for(int i=0;i<800;i+=50){
            //g.fillRect(i-x,-y,20,500);
        }
        g.setColor(Color.PINK);
        g.fillRect(375,225,playerSize,playerSize);

        for(int i=0;i<walls.length;i++){
            if(walls[i]!=null){
                walls[i].display(g,this);
            }
        }

        g.setColor(Color.LIGHT_GRAY);
        if(mouseDetect(700,750,25,75)){
            g.setColor(Color.GRAY);
        }
        g.fillRect(700,25,50,50);
        g.drawImage(mapIcon,700,25,50,50,null);
        if(mapOpen){
            g.drawImage(map,200,30,400,400,null);
        }
        g.drawString("(" + mouseX + "," + mouseY + ")", mouseX, mouseY);
    }

    public void update() {
        cright=true;
        cleft=true;
        cdown=true;
        cup=true;
        for(int i=0;i<walls.length;i++){
            if(walls[i]!=null){
                if(walls[i].type==1){
                    walls[i].updateUp(this);
                    walls[i].updateDown(this);
                }else{
                    walls[i].updateLeft(this);
                }
            }
        }
        if (right && cright){
            moveRight();
        }
        if (left && cleft){
            moveLeft();
        }
        if (down && cdown){
            moveDown();
        }
        if (up && cup){
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
        FirstLevel frame = new FirstLevel();
        frame.setSize(800, 500);
        frame.setVisible(true);
    }
}