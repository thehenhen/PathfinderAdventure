import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class FirstLevel extends Level{
    int playerSize;
    boolean right;
    boolean left;
    boolean down;
    boolean up;
    boolean first;
    boolean mapOpen;
    Image map;
    Image mapIcon;
    ArrayList<Wall> walls;

    public FirstLevel() {
        super();
        playerX = 0;
        playerY = 0;
        mouseX=0;
        mouseY=0;
        playerSize=50;

        right=false;
        left=false;
        down=false;
        up=false;
    
        cright=true;
        cleft=true;
        cdown=true;
        cup=true;

        first=true;
        mapOpen = false;

        walls = new ArrayList<Wall>();
        try {
            map = ImageIO.read(new File("map1.png"));
            mapIcon = ImageIO.read(new File("mapIcon.png"));
        }catch (Exception e){
            e.printStackTrace();
        }
        addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);

        //library
        addWall(2,350,-500,350,230);
        addWall(1,170,-500,350,-500);
        addWall(1,-250,230,350,230);
        addWall(2,-250,-100,-250,230);

        //caf
        addWall(2,450,-200,450,170);

        addWall(2,750,-200,750,170);

        addWall(1,450,170,750,170);
        
        addWall(1,450,-200,750,-200);
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
        g.fillRect(0, 0, 800, 500);

        //DRAW STUFF HERE
        g.setColor(Color.BLACK);
        g.setColor(Color.PINK);
        g.fillRect(375,225,playerSize,playerSize);

        for(int i=0;i<walls.size();i++){
            if(walls.get(i)!=null){
                walls.get(i).display(g,this);
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
        for(int i=0;i<walls.size();i++){
            if(walls.get(i)!=null){
                if(walls.get(i).type==1){
                    if(!walls.get(i).updateUp(this)){
                        cup=false;
                    }
                    if(!walls.get(i).updateDown(this)){
                        cdown=false;
                    }
                    
                }else{
                    if(!walls.get(i).updateLeft(this)){
                        cleft=false;
                    }
                    if(!walls.get(i).updateRight(this)){
                        cright=false;
                    }
                    
                }
            }
        }
        if (right && cright){
            right();
        }
        if (left && cleft){
            left();
        }
        if (down && cdown){
            down();
        }
        if (up && cup){
            up();
        }
    }

    public void right() {
        playerX += 5;
    }
    
    public void left() {
        playerX -= 5;
    }
    
    public void down() {
        playerY += 5;
    }
    
    public void up() {
        playerY -= 5;
    }

    public int getPlayerX(){
        return playerX;
    }

    public int getPlayerY(){
        return playerY;
    }

    public void addWall(int type, int x1, int y1, int x2, int y2){
        walls.add(new Wall(type,x1,y1,x2,y2));
    }
}