import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.util.ArrayList;
import javax.swing.Timer;



public class ThirdLevel extends Level{
    int playerSize;
    boolean right;
    boolean left;
    boolean down;
    boolean up;
    boolean third;
    boolean mapOpen;
    Image map;
    Image mapIcon;
    Image[] playerIcons;
    Image printer;
    Image computer;
    ArrayList<Wall> walls;
    ArrayList<AntiWall> antiwalls;
    int facing=1;
    //dr 0
    //dl 1
    //ur 2
    //ul 3

    boolean instructionsDone;
    int goalX=1080;
    int goalY=-1000;
    boolean failed=false;
    boolean beatGame=false;

    int secondsPassed=0;
    String temp="";

    Color backgroundC = new Color(227, 215, 182);
    Color grey = new Color(68, 69, 69);
    Color deepBlue = new Color(11, 58, 84);
    Font smallSerifFont = new Font("Serif", Font.PLAIN, 25);
    
    /*
     * 0: Main Entrance --> room 103 (print from computer)--> 
     * 1: room 114 (printer) --> 
     * 2: STORAGE (get paper) --> 
     * 3: room 114 (place paper in printer) --> 
     * 4: Social Offices (get ink) --> 
     * 5: room 114 (place ink in printer and get printed paper) --> 
     * 6: room 111 (hand in paper to teacher)
     */
    int stage=0;
    String[] goals;

    Timer timer = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {
            secondsPassed++;
        }
    });

    public ThirdLevel() {
        super();
        playerX = -440;
        playerY = -1100;
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

        third=true;
        mapOpen = false;

        instructionsDone=false;

        walls = new ArrayList<Wall>();
        antiwalls = new ArrayList<AntiWall>();
        playerIcons = new Image[4];
        goals = new String[7];
        goals[0]="Go to the computer in room 103 to print.";
        goals[1]="Go to the printer in room 114 to get your work.";
        goals[2]="Go to the STORAGE room to get paper.";
        goals[3]="Go to room 114 to put the paper in the printer.";
        goals[4]="Out of ink! Go to the Social Office to get ink.";
        goals[5]="Go to room 114 to put the ink in the printer.";
        goals[6]="Go to room 111 to hand in your paper to the teacher.";
        
        try {
            map = ImageIO.read(new File("assets/map3.png"));
            mapIcon = ImageIO.read(new File("assets/mapIcon.png"));
            playerIcons[0] = ImageIO.read(new File("assets/playerDownRight.png"));
            playerIcons[1] = ImageIO.read(new File("assets/playerDownLeft.png"));
            playerIcons[2] = ImageIO.read(new File("assets/playerUpRight.png"));
            playerIcons[3] = ImageIO.read(new File("assets/playerUpLeft.png"));
            printer = ImageIO.read(new File("assets/printer.png"));
            computer = ImageIO.read(new File("assets/computer.png"));
        }catch (Exception e){
            e.printStackTrace();
        }
        //walls
        if(true){
        //library
        addRect(-250,-100,600,330);
        addDoor(2,350,60,350,120);

        //room 114
        addRect(-350,-25,100,180);
        addDoor(2,-250,5,-250,65);

        //hallway over library
        addRect(-430,-700,600,300);
        addDoor(2,170,-700,170,-400);

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
        addRect(60,-1000,110,300); //room 109
        addRect(60,-1050,110,50);
        addRect(60,-1250,110,200);

        //left block (therapeutic area)
        addRect(-450,-1400,510,700);
        addDoor(1,-225,-1400,-165,-1400); //entrance #1
        
        addWall(1,-450,-1100,60,-1100); //middle split
        addWall(1,-300,-1325,-55,-1325); //middle of middle split
        addDoor(1,-225,-1325,-165,-1325); //door for middle of middle split
        
        addWall(2,-300,-1400,-300,-1250); //left wall
        addWall(1,-450,-1250,-300,-1250); //door's wall of left wall
        addDoor(1,-450,-1250,-390,-1250); //door of left wall
        
        addWall(2,-55,-1400,-55,-1100); //right wall
        addDoor(2,-55,-1170,-55,-1100);
        
        addRect(-340,-1180,120,80); //room near middle split
        addDoor(1,-295,-1180,-235,-1180);
        addDoor(1,-320,-1100,-260,-1100);
        addWall(2,-340,-1100,-340,-820);
        
        addRect(-165,-1025,225,325); //big room in #2 space for left block
        addDoor(1,0,-1025,60,-1025);

        addWall(1,-650,-520,-430,-520); //bottom room bottom wall
        addWall(1,-650,-840,-450,-840); //bottom room top wall
        addWall(2,-650,-840,-650,-520); //bottom room left wall
        addDoor(2,-450,-790,-450,-730); //bottom room door

        addWall(1,-650,-870,-450,-870);//middle room bottom wall
        addWall(1,-650,-1050,-450,-1050); //middle room top wall
        addWall(2,-650,-1050,-650,-870); //middle room left wall
        addDoor(2,-450,-990,-450,-930); //middle room door

        addWall(1,-650,-1080,-450,-1080); //top room bottom wall
        addWall(1,-650,-1360,-450,-1360); //top room top wall
        addWall(2,-650,-1360,-650,-1080); //top room left wall
        addDoor(2,-450,-1200,-450,-1140); //top room door
        
        //hallway extension to therapeuatic area
        addRect(-375,-1550,375,150);
        addDoor(2,0,-1550,0,-1400);

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
        addRect(1350,-550,150,350); //extension
        addDoor(2,1350,-550,1350,-400);

        //STORAGE
        addRect(1500,-725,250,710);
        addDoor(2,1500,-330,1500,-270);

        //room 101
        addRect(1050,-650,400,100);

        //room 102
        addRect(900,-900,200,350);
        addDoor(2,1100,-650,1100,-550);

        //room 103
        addRect(900,-1250,250,350);
        addDoor(2,900,-1105,900,-1045);

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

    public void keyPressed(KeyEvent e) {
        if ((e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) && instructionsDone && !checkGoal() && !failed){
            right=true;
        }
        if ((e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) && instructionsDone && !checkGoal() && !failed){
            left=true;
        }  
        if ((e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) && instructionsDone && !checkGoal() && !failed){
            down=true;
        }
        if ((e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) && instructionsDone && !checkGoal() && !failed){
            up=true;
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            if(!instructionsDone){
                instructionsDone=true;
                timer.start();
            }
            if(failed){
                restart();
                instructionsDone=true;
                timer.start();
            }
            else if(checkGoal()){
                if(stage==0){
                    goalX=-700+400;
                    goalY=-140+250;
                    stage++;
                }else if(stage==1){
                    goalX=1220+400;
                    goalY=-880+250;
                    stage++;
                }else if(stage==2){
                    goalX=-700+400;
                    goalY=-140+250;
                    stage++;
                }else if(stage==3){
                    goalX=-20+400;
                    goalY=-1600+250;
                    stage++;
                }else if(stage==4){
                    goalX=-700+400;
                    goalY=-140+250;
                    stage++;
                }else if(stage==5){
                    goalX=-960+400;
                    goalY=-1540+400;
                    stage++;
                }else if(stage==6){
                    third=false;                }
            }
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
        if(mouseDetect(708,758,57,105)){
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
        g.setColor(backgroundC);
        g.fillRect(0, 0, 800, 500);

        //DRAW STUFF HERE
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

        g.drawImage(printer,-300-playerX-40,110-playerY-40,75,75,null); //printer
        g.drawImage(computer,1080-playerX-100,-1000-playerY-50,null);


        g.setColor(Color.LIGHT_GRAY);
        if(mouseDetect(708,758,57,105)){
            g.setColor(Color.GRAY);
        }
        g.fillRect(700,25,50,50);
        g.drawImage(mapIcon,700,25,50,50,null);
        if(mapOpen){
            g.drawImage(map,200,30,400,400,null);
        }
        g.setFont(smallSerifFont);
        g.setColor(grey);
        g.drawString("Goal: "+goals[stage],20,50);
        temp="";
        if(secondsPassed%60<10){
            temp="0";
        }
        g.drawString("Time Elapsed: "+String.valueOf(secondsPassed/60)+":"+temp+String.valueOf(secondsPassed%60),10,450);

        if(!instructionsDone){
            g.setColor(deepBlue);
            g.fillRect(100,30,600,390);
            g.setColor(backgroundC);
            g.fillRect(120,50,560,350);
            g.setColor(grey);
            g.drawString("Level 3",370,100);
            g.drawString("Uh oh, you forgot to print your homework at home.",140,140);
            g.drawString("Now you need to use the school printer!",200,180);
            g.drawString("You have 5 minutes to accomplish this task.",180,220);
            g.drawString("Use the map to help you navigate.",220,260);
            g.drawString("Use WASD or arrow keys to move.",215,300);
            g.drawString("Press SPACE to start.",300,340);
        }
        if(checkGoal()){
            g.setColor(deepBlue);
            g.fillRect(100,30,600,390);
            g.setColor(backgroundC);
            g.fillRect(120,50,560,350);
            g.setColor(grey);
            if(stage==0){
                g.drawString("Great, now go to the printer to get your work!",180,200);
                g.drawString("Press SPACE to continue.",270,300);
            }else if(stage==1){
                g.drawString("Uh oh, the printer is out of paper!",220,200);
                g.drawString("Go to the STORAGE room to get paper.",190,240);
                g.drawString("Press SPACE to continue.",270,300);
            }else if(stage==2){
                g.drawString("Great, now put the paper back in the printer!",200,200);
                g.drawString("Press SPACE to continue.",270,300);
            }else if(stage==3){
                g.drawString("Uh oh, the printer is out of ink!",235,200);
                g.drawString("Go to the Social Office to get ink.",225,240);
                g.drawString("Press SPACE to continue.",270,300);
            }else if(stage==4){
                g.drawString("Great, now put the ink back in the printer!",205,200);
                g.drawString("Press SPACE to continue.",270,300);
            }else if(stage==5){
                g.drawString("You successfully printer your work!",220,200);
                g.drawString("Go to room 111 to hand in your work!",220,240);
                g.drawString("Press SPACE to continue.",270,300);
            }else if(stage==6){
                g.drawString("Congrats! You handed in your work on time!",180,200);
                g.drawString("Press SPACE to continue.",270,300);
                timer.stop();
            }
        }

        if(failed){
            g.setColor(deepBlue);
            g.fillRect(100,30,600,390);
            g.setColor(backgroundC);
            g.fillRect(120,50,560,350);
            g.setColor(grey);
            g.drawString("Uh oh, you were too slow!",270,200);
            g.drawString("Press SPACE to try again.",270,300);
            timer.stop();
        }
    }

    public void update() {
        if(secondsPassed>=300){
            failed=true;
        }
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

    public boolean checkGoal(){
        boolean reached=false;
        if(Math.abs(playerX+400-goalX)<30 && Math.abs(playerY+250-goalY)<30){
            reached=true;
        }
        return reached;
    }

    public void restart(){
        goalX=1080;
        goalY=-1000;
        stage=0;
        facing=0;
        instructionsDone=false;
        playerX=-440;
        playerY=-1100;
        mapOpen=false;
        failed=false;
        secondsPassed=0;
        System.out.println("failed");
    }
}