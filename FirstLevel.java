import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Purpose: FirstLevel class to manage functions of first level
 */
public class FirstLevel extends Level{
    /**
     * Variables to determine if player is pressing respective buttons
     */
    private boolean right;
    private boolean left;
    private boolean down;
    private boolean up;
    /**
     * Boolean variable to determine if first level should display
     */
    private boolean first;
    /**
     * Boolean variable to determine if map is open
     */
    private boolean mapOpen;
    /**
     * Images to display
     */
    private Image map;
    private Image mapIcon;
    private Image bgInst;
    private Image goalReachImage;
    private Image[] playerIcons;
    /**
     * ArrayLists to store walls and antiwalls
     */
    private ArrayList<Wall> walls;
    private ArrayList<AntiWall> antiwalls;
    /**
     * Coords of goal
     */
    private int goalX=690;
    private int goalY=-1630;

    /**
     * Boolean variable to determine if instructions are done displaying
     */
    private boolean instructionsDone;

    /**
     * Variable to determine which way character is facing
     */
    private int facing=1;
    //down right 0
    //down left 1
    //up right 2
    //up left 3

    /**
     * Fonts and colours
     */
    private Font smallSerifFont = new Font("Serif", Font.PLAIN, 25);
    private Color backgroundC = new Color(227, 215, 182);
    private Color grey = new Color(68, 69, 69);
    private Color deepBlue = new Color(11, 58, 84);

    /**
     * Index to determine which scene of level 1 we are on
     */
    private int index;

    /**
     * Purpose: Constructs the FirstLevel object
     */
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
        instructionsDone=false;
        walls = new ArrayList<Wall>();
        antiwalls = new ArrayList<AntiWall>();
        playerIcons = new Image[4];
        index = 0;
        try {
            bgInst = ImageIO.read(new File("assets/background.jpg"));
            map = ImageIO.read(new File("assets/map1.png"));
            goalReachImage = ImageIO.read(new File("assets/goalReach.png"));
            mapIcon = ImageIO.read(new File("assets/mapIcon.png"));
            playerIcons[0] = ImageIO.read(new File("assets/playerDownRight.png"));
            playerIcons[1] = ImageIO.read(new File("assets/playerDownLeft.png"));
            playerIcons[2] = ImageIO.read(new File("assets/playerUpRight.png"));
            playerIcons[3] = ImageIO.read(new File("assets/playerUpLeft.png"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Purpose: Handles the key press event.
     * @param e the KeyEvent object
     */
    public void keyPressed(KeyEvent e) {
        if ((e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) && instructionsDone && !checkGoal()){
            right=true;
        }
        if ((e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) && instructionsDone && !checkGoal()){
            left=true;
        }  
        if ((e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) && instructionsDone && !checkGoal()){
            down=true;
        }
        if ((e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) && instructionsDone && !checkGoal()){
            up=true;
        }
        if (index<4 && e.getKeyCode() == KeyEvent.VK_ENTER){
            index++;
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            if(checkGoal()){
                index=0;
                first=false;
            }else if(!instructionsDone){
                instructionsDone=true;
            }
        }
    }
    
    /**
     * Purpose: Handles the key release event.
     * @param e the KeyEvent object
     */
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

    /**
     * Purpose: Handles the mouse click event.
     * @param e the MouseEvent object
     */
    public void mouseClicked(MouseEvent e) {
        if(mouseDetect(708,758,57,105)){
            mapOpen=!mapOpen;
        }
    }

    /**
     * Purpose: Handles the mouse move event.
     * @param e the MouseEvent object
     */
    public void mouseMoved(MouseEvent e) {
        mouseX=e.getX();
        mouseY=e.getY();
    }

    public void keyTyped(KeyEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseDragged(MouseEvent e) {}
    
    /**
     * Purpose: makes moues detection easier by defining coordinates and borders
     * @param x1 lower limit of mouseX
     * @param x2 upper limit of mouseX
     * @param y1 lower limit of mouseY
     * @param y2 upper limit of mouseY
     * @return if the mouse is within the defined borders
     */
    public boolean mouseDetect(int x1,int x2,int y1,int y2){
        return(mouseX>=x1 && mouseX<=x2 && mouseY>=y1 && mouseY<=y2);
    }
    
    /**
     * Purpose: method to draw to the JPanel
     * @param g the Graphics object
     */
    public void paint(Graphics g) {
        update();
        if(index==0){
            g.drawImage(bgInst,0,0,800,500,null);
            g.setColor(deepBlue);
            g.fillRect(100,30,600,390);
            g.setColor(backgroundC);
            g.fillRect(120,50,560,350);
            g.setColor(grey);
            g.setFont(smallSerifFont);
            g.drawString("Welcome to Pathfinder Adventure!",130,80);
            g.drawString("In this game, you will learn how to navigate new",130,130);
            g.drawString("environments, such as school.", 130, 155);
            g.setFont(new Font("Serif", Font.PLAIN, 20));
            g.drawString("Press ENTER to continue...",450,390);
        }
        if(index==1){
            g.setColor(deepBlue);
            g.fillRect(100,30,600,390);
            g.setColor(backgroundC);
            g.fillRect(120,50,560,350);
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(700,25,50,50);
            g.setColor(grey);
            g.setFont(smallSerifFont);
            g.drawString("Use the map to help you navigate.",240,180);
            g.drawLine(590,170,650,120);
            g.drawLine(635,125,650,120);
            g.drawLine(645,135,650,120);
            g.drawImage(mapIcon,700,25,50,50,null);
            g.drawString("Use WASD or arrow keys to move.",230,220);
            g.setFont(new Font("Serif", Font.PLAIN, 20));
            g.drawString("Press ENTER to continue...",450,390);
        }
        if(index==2){
            g.drawImage(bgInst,0,0,800,500,null);
            g.setColor(deepBlue);
            g.fillRect(100,30,600,390);
            g.setColor(backgroundC);
            g.fillRect(120,50,560,350);
            g.setColor(grey);
            g.setFont(smallSerifFont);
            g.drawString("When you approach your goal, you will notice that it",130,80);
            g.drawString("is outlined in a green circle.",130,105);
            g.drawImage(goalReachImage,130,130,273,123,null);
            g.drawString("Simply move your character inside of the green circle",130,270);
            g.drawString("and follow the prompt.",130,295);
            g.setFont(new Font("Serif", Font.PLAIN, 20));
            g.drawString("Press ENTER to continue...",450,390);
        }
        if(index==3){
            g.setColor(Color.BLACK);
            g.fillRect(0,0,800,500);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Serif", Font.PLAIN, 50));
            g.drawString("LEVEL ONE",250,225);
            g.setFont(new Font("Serif", Font.PLAIN, 20));
            g.drawString("Press ENTER to continue...",550,450);
        }
        if(index==4){
        g.setColor(backgroundC);
        g.fillRect(0, 0, 800, 500);
        for(int i=0;i<walls.size();i++){
            if(walls.get(i)!=null){
                walls.get(i).display(g,this);
            }
        }
        g.setColor(backgroundC);
        for(int i=0;i<antiwalls.size();i++){
            if(antiwalls.get(i)!=null){
                antiwalls.get(i).display(g,this);
            }
        }
        g.setColor(Color.GREEN);
        g.fillOval(goalX-50-playerX,goalY-50-playerY,100,100);
        g.drawImage(playerIcons[facing],375,225,50,50,null);
        g.setColor(Color.LIGHT_GRAY);
        if(mouseDetect(708,758,57,105)){
            g.setColor(Color.GRAY);
        }
        g.fillRect(700,25,50,50);
        g.drawImage(mapIcon,700,25,50,50,null);
        g.setFont(smallSerifFont);
        g.setColor(grey);
        g.drawString("Goal: Make your way to room 106",20,50);
        if(mapOpen){
            g.drawImage(map,200,30,400,400,null);
        }
        if(!instructionsDone){
            g.setColor(deepBlue);
            g.fillRect(100,30,600,390);
            g.setColor(backgroundC);
            g.fillRect(120,50,560,350);
            g.setColor(grey);
            g.drawString("Welcome to school!",300,100);
            g.drawString("Your first class is in room 106.",255,140);
            g.drawString("Press SPACE to start.",300,300);
        }
        if(checkGoal()){
            g.setColor(deepBlue);
            g.fillRect(100,30,600,390);
            g.setColor(backgroundC);
            g.fillRect(120,50,560,350);
            g.setColor(grey);
            g.drawString("Congrats, you made it to class!",240,200);
            g.drawString("Press SPACE to continue.",270,300);
        }
            //library
            addRect(-250,-100,600,330);
            addDoor(2,350,60,350,120);
    
            //office
            addRect(170,-400,180,300);
            addDoor(2,350,-280,350,-220);
    
            //caf
            addRect(450,-200,300,370);
            addDoor(1,470,-200,530,-200);
            addDoor(1,660,-200,730,-200);
    
            //big left wall
            addWall(2,170,-1400,170,-400);
    
            //business rooms
            addRect(60,-1000,110,300);
            addRect(60,-1050,110,50);
            addRect(60,-1250,110,200);
    
            //center block (gym)
            addRect(320,-1400,430,850);
            addWall(1,320,-1300,750,-1300);
            addDoor(1,505,-1300,565,-1300);
            addDoor(2,320,-800,320,-740);
    
            addRect(320,-650,220,100);
            addDoor(1,400,-550,460,-550);
    
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
    
            //room 103
            addRect(900,-1250,250,350);
    
            //room 104
            addRect(900,-1500,250,250);
    
            //top left walls
            addWall(1,0,-1400,170,-1400);
            addWall(2,0,-1550,0,-1400);
    
            //room 107
            addRect(-30,-1700,500,150);
    
            //room 106
            addRect(470,-1700,300,150);
            addDoor(1,540,-1550,600,-1550);
    
            //room 105
            addRect(770,-1700,380,200);
        }
    }

    /**
     * Purpose: Updates the variables and conditions within the first level, called every frame
     */
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

    /**
     * Purpose: Moves the player to the right
     */
    public void right() {
        playerX += 5;
        if(facing%2==1) facing--;
    }
    
    /**
     * Purpose: Moves the player to the left
     */
    public void left() {
        playerX -= 5;
        if(facing%2==0) facing++;
    }
    
    /**
     * Purpose: Moves the player down
     */
    public void down() {
        playerY += 5;
        if(facing>1) facing-=2;
    }
    
    /**
     * Purpose: Moves the player up
     */
    public void up() {
        playerY -= 5;
        if(facing<2) facing+=2;
    }

    /**
     * Purpose: Accessor method for playerX
     * @return playerX
     */
    public int getPlayerX(){
        return playerX;
    }

    /**
     * Purpose: Accessor method for playerY
     * @return playerY
     */
    public int getPlayerY(){
        return playerY;
    }

    /**
     * Purpose: Checks if the player has reached the goal coordinates
     * @return if reached goal
     */
    public boolean checkGoal(){
        boolean reached=false;
        if(Math.abs(playerX+400-goalX)<30 && Math.abs(playerY+250-goalY)<30){
            reached=true;
        }
        return reached;
    }

    /**
     * Purpose: Adds a wall to the walls ArrayList
     * @param type 1: horizontal, 2: vertical
     * @param x1 x-coord of first point
     * @param y1 y-coord of first point
     * @param x2 x-coord of second point
     * @param y2 y-coord of second point
     */
    public void addWall(int type, int x1, int y1, int x2, int y2){
        walls.add(new Wall(type,x1,y1,x2,y2));
    }

    /**
     * Purpose: Adds walls in the shape of a rectangle to the walls ArrayList
     * @param x x-coord of top left corner
     * @param y y-coord of top left corner
     * @param width width of rectangle
     * @param height height of rectangle
     */
    public void addRect(int x,int y,int width,int height){
        addWall(1,x,y,x+width,y);
        addWall(2,x,y,x,y+height);
        addWall(1,x,y+height,x+width,y+height);
        addWall(2,x+width,y,x+width,y+height);
    }

    /**
     * Purpose: Adds an AntiWall
     * @param type 1: horizontal, 2: vertical
     * @param x1 x-coord of first point
     * @param y1 y-coord of first point
     * @param x2 x-coord of second point
     * @param y2 y-coord of second point
     */
    public void addAntiWall(int type, int x1, int y1, int x2, int y2){
        antiwalls.add(new AntiWall(type,x1,y1,x2,y2));
    }

    /**
     * Purpose: Creates a door by adding and AntiWall and 2 small walls
     * @param type 1: horizontal, 2: vertical
     * @param x1 x-coord of first point
     * @param y1 y-coord of first point
     * @param x2 x-coord of second point
     * @param y2 y-coord of second point
     */
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

    /**
     * Purpose: Resets the level by resetting all variables 
     */
    public void restart(){
        goalX=690;
        goalY=-1630;
        facing=0;
        instructionsDone=false;
        playerX=0;
        playerY=0;
        mapOpen=false;
        first=true;
    }

    /**
     * Purpose: Accessor method for if the first level should be displayed
     * @return
     */
    public boolean getFirst(){
        return first;
    }
}