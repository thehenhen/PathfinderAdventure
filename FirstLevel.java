import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.lang.Math.*;

public class FirstLevel extends Level{
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

    boolean first;
    boolean mapOpen;
    Image map;
    Image mapIcon;
    Image idk;

    Color c = new Color(255,255,255);

    ArrayList<Wall> walls;
    int wallSize;

    public FirstLevel() {
        super();
        X = 0;
        Y = 0;
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

        wallSize=0;
        walls = new ArrayList<Wall>();
        try {
            map = ImageIO.read(new File("map1.png"));
            mapIcon = ImageIO.read(new File("mapIcon.png"));
            idk = ImageIO.read(new File("idk.jpg"));
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


        // // BACKGROUND
        // //g.setColor(Color.YELLOW);
        // System.out.println("before back");
        // c = new Color(c.getRed()-1,c.getGreen()-1,c.getBlue()-1);
        // g.setColor(c);
        // g.fillRect(0, 0, 800, 500);
        // //g.drawImage(idk,0,0,800,500,null);
        // System.out.println("after back");
        // //c = new Color(c.getRed()+1,c.getGreen()+1,c.getBlue()+1);
        // g.setColor(c);
        // g.fillOval(c.getRed()*2,100,100,100);


        // //DRAW STUFF HERE
        
        
        
        // g.setColor(Color.BLACK);
        
        // for(int i=0;i<800;i+=50){
        //     g.fillRect(i-X,-Y,20,500);
        // }
        // g.setColor(Color.PINK);
        // g.fillRect(375,225,playerSize,playerSize);

        // for(int i=0;i<walls.size();i++){
        //     if(walls.get(i)!=null){
        //         walls.get(i).display(g,this);
        //     }
        // }
        // g.setColor(Color.LIGHT_GRAY);
        // if(mouseDetect(700,750,25,75)){
        //     g.setColor(Color.GRAY);
        // }
        // g.fillRect(700,25,50,50);
        // g.drawImage(mapIcon,700,25,50,50,null);
        // if(mapOpen){
        //     g.drawImage(map,200,30,400,400,null);
        //     //g.setColor(Color.GRAY);
        //     //g.fillRect(200,30,100,100);
        // }
        // g.drawString("(" + mouseX + "," + mouseY + ")", mouseX, mouseY);
        // //System.out.println(X+","+Y);
        c = new Color(c.getRed()-1,c.getGreen()-1,c.getBlue()-1);
        g.setColor(c);
        g.fillRect(0, 0, 800, 500);
    }

    public void update() {
        cright=true;
        cleft=true;
        cdown=true;
        cup=true;
        // for(int i=0;i<walls.size();i++){
        //     if(walls.get(i)!=null){
        //         if(walls.get(i).type==1){
        //             cup = walls.get(i).updateUp(this);
        //             cdown = walls.get(i).updateDown(this);
        //         }else{
        //             cleft = walls.get(i).updateLeft(this);
        //             cright = walls.get(i).updateRight(this);
        //         }
        //     }
        // }
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
        X = X + 5;
    }
    
    public void moveLeft() {
        X = X - 5;
    }
    
    public void moveDown() {
        Y = Y + 5;
    }
    
    public void moveUp() {
        Y = Y - 5;
    }

    public int getX(){
        return X;
    }

    public int getY(){
        return Y;
    }


    public void addWall(int type, int x1, int y1, int x2, int y2){
        walls.add(new Wall(type,x1,y1,x2,y2));
    }
}