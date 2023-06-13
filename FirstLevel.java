import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * Purpose: FirstLevel class to manage functions of first level
 */
public class FirstLevel extends JPanel{
    /**
     * Images to display
     */
    private Image map;
    private Image mapIcon;
    private Image bgInst;
    private Image goalReachImage;
    private Image[] playerIcons;

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

    private boolean first;

    private int mouseX;
    private int mouseY;

    /**
     * Purpose: Constructs the FirstLevel object
     */
    public FirstLevel() {
        super();
        mouseX=0;
        mouseY=0;
        first=true;
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
        if (index<4 && e.getKeyCode() == KeyEvent.VK_ENTER){
            index++;
        }
    }
    
    /**
     * Purpose: Handles the key release event.
     * @param e the KeyEvent object
     */
    public void keyReleased(KeyEvent e) {}

    /**
     * Purpose: Handles the mouse click event.
     * @param e the MouseEvent object
     */
    public void mouseClicked(MouseEvent e) {
        if(mouseDetect(150,400,200,250)){
            System.out.println("HELLO");
        }
        if(mouseDetect(400,650,200,250)){
            System.out.println("HILLO");
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
            g.drawString("Press ENTER to  continue...",450,390);
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
            g.drawImage(bgInst,0,0,800,500,null);
            g.setColor(deepBlue);
            g.fillRect(100,30,600,390);
            g.setColor(backgroundC);
            g.fillRect(120,50,560,350);
            g.setColor(grey);
            g.setFont(smallSerifFont);
            g.drawString("What is the first thing you do when",150,100);
            g.drawString("navigating a new environment?",150,130);
            g.fillRect(120,50,560,350);

            g.fillRect(150,150,250,100);
            g.fillRect(150,250,250,100);
            g.fillRect(400,150,250,100);
            g.fillRect(400,250,250,100);
            g.drawString("Open map",160,200);
            g.drawString("Wander aimlessly",410,200);
            g.drawString("Leave the building",160,300);
            g.drawString("Panic and scream",410,300);
            g.drawString(mouseX+","+mouseY,mouseX,mouseY);
        }
    }

    /**
     * Purpose: Updates the variables and conditions within the first level, called every frame
     */
    public void update() {}


    /**
     * Purpose: Resets the level by resetting all variables 
     */
    public void restart(){
        index=0;
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