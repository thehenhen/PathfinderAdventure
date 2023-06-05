import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class SecondLevel extends Level{
    int x;
    int y;
    int mouseX;
    int mouseY;
    int playerSize;


    boolean right;
    boolean left;
    boolean down;
    boolean up;
    
    boolean cright;
    boolean cleft;
    boolean cdown;
    boolean cup;

    boolean second;
    boolean mapOpen;
    Image map;
    Image mapIcon;

    ArrayList<Wall> walls;
    int wallSize;

    public SecondLevel() {
        super();
        x = 0;
        y = 0;
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

        second=true;
        mapOpen = false;

        wallSize=0;
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
        
        addWall(1,300,300,400,300);//top
        addWall(1,300,400,400,400);//bottom
        
        addWall(2,300,300,300,400);//left
        addWall(2,400,300,400,400);//right
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
        for(int i=0;i<800;i+=50){
            //g.fillRect(i-x,-y,20,500);
        }
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
            //g.drawImage(map,200,30,400,400,null);
            g.fillRect(200,30,400,400);
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
                    cup = walls.get(i).updateUp(this);
                    cdown = walls.get(i).updateDown(this);
                }else{
                    cleft = walls.get(i).updateLeft(this);
                    cright = walls.get(i).updateRight(this);
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

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }


    public void addWall(int type, int x1, int y1, int x2, int y2){
        walls.add(new Wall(type,x1,y1,x2,y2));
    }
}