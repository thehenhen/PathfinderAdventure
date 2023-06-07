import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class SecondLevel extends Level{
    int playerSize;
    boolean right;
    boolean left;
    boolean down;
    boolean up;
    boolean second;
    boolean mapOpen;
    Image map;
    Image mapIcon;
    Image[] playerIcons;
    ArrayList<Wall> walls;
    ArrayList<AntiWall> antiwalls;
    int facing=1;
    //dr 0
    //dl 1
    //ur 2
    //ul 3

    public SecondLevel() {
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

        second=true;
        mapOpen = false;

        walls = new ArrayList<Wall>();
        antiwalls = new ArrayList<AntiWall>();
        playerIcons = new Image[4];
        try {
            map = ImageIO.read(new File("map1.png"));
            mapIcon = ImageIO.read(new File("mapIcon.png"));
            playerIcons[0] = ImageIO.read(new File("playerDownRight.png"));
            playerIcons[1] = ImageIO.read(new File("playerDownLeft.png"));
            playerIcons[2] = ImageIO.read(new File("playerUpRight.png"));
            playerIcons[3] = ImageIO.read(new File("playerUpLeft.png"));
        }catch (Exception e){
            e.printStackTrace();
        }
        addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);

        //library
        addRect(-250,-100,600,330);
        addDoor(2,350,160,350,220);

        //office
        addRect(170,-400,180,300);

        //caf
        addRect(450,-200,300,370);
        addDoor(1,470,-200,530,-200);
        addDoor(1,660,-200,730,-200);

        //big left wall
        addWall(2,170,-1500,170,-400);

        //business rooms
        addRect(60,-1000,110,300);
        addRect(60,-1050,110,50);
        addRect(60,-1250,110,200);

        //center block (gym)
        addRect(320,-1250,430,700);
        addRect(320,-650,220,100);
        addRect(540,-650,105,100);
        addRect(645,-650,105,100);

        //kitchen
        addRect(750,-400,600,200);

        //end of kitchen hallway
        addWall(2,1350,-550,1350,-400);

        //room 101
        addRect(1050,-650,400,100);

        //room 102
        addRect(900,-900,200,350);
        addDoor(2,1100,-650,1100,-550);


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
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            second=false;
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
        for(int i=0;i<walls.size();i++){
            if(walls.get(i)!=null){
                walls.get(i).display(g,this);
            }
        }
        for(int i=0;i<antiwalls.size();i++){
            if(antiwalls.get(i)!=null){
                antiwalls.get(i).display(g,this);
            }
        }
        g.drawImage(playerIcons[facing],375,225,50,50,null);


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
        for(int i=0;i<antiwalls.size();i++){
            if(antiwalls.get(i)!=null){
                if(antiwalls.get(i).type==1){
                    if(antiwalls.get(i).updateUp(this)){
                        cup=true;
                    }
                    if(antiwalls.get(i).updateDown(this)){
                        cdown=true;
                    }
                    
                }else{
                    if(antiwalls.get(i).updateLeft(this)){
                        cleft=true;
                    }
                    if(antiwalls.get(i).updateRight(this)){
                        cright=true;
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
        if(facing%2==1) facing--;
    }
    
    public void left() {
        playerX -= 5;
        if(facing%2==0) facing++;
    }
    
    public void down() {
        playerY += 5;
        if(facing>1) facing-=2;
    }
    
    public void up() {
        playerY -= 5;
        if(facing<2) facing+=2;
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

    public void addRect(int x,int y,int width,int height){
        addWall(1,x,y,x+width,y);
        addWall(2,x,y,x,y+height);
        addWall(1,x,y+height,x+width,y+height);
        addWall(2,x+width,y,x+width,y+height);
    }

    public void addAntiWall(int type, int x1, int y1, int x2, int y2){
        antiwalls.add(new AntiWall(type,x1,y1,x2,y2));
    }

    public void addDoor(int type,int x1,int y1,int x2,int y2){
        addAntiWall(type, x1, y1, x2, y2);
        if(type==1){
            addWall(2,x1,y1-1,x1,y1+1);
            addWall(2,x2,y1-1,x2,y1+1);
        }else if(type==2){
            addWall(1,x1-1,y1,x1+1,y1);
            addWall(1,x1-1,y2,x1+1,y2);
        }
    }
}