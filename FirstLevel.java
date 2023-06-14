import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;
import javax.swing.JPanel;

/**
 * Purpose: FirstLevel class to manage functions of first level
 */
public class FirstLevel extends JPanel{
    /**
     * Images to display
     */
    private Image mapIcon;
    private Image bgInst;
    private Image goalReachImage;
    private Image[] playerIcons;

    /**
     * Fonts and colours
     */
    private Font smallSerifFont = new Font("Serif", Font.PLAIN, 25);
    private Color backgroundC = new Color(227, 215, 182);
    private Color button1 = new Color(168, 153, 111);
    private Color button2 = new Color(120, 104, 61);
    private Color grey = new Color(68, 69, 69);
    private Color deepBlue = new Color(11, 58, 84);

    /**
     * Index to determine which scene of level 1 we are on
     */
    private int index;

    /**
     * Start the level
     */
    private boolean first;

    /**
     * Detect mouse coordinates
     */
    private int mouseX;
    private int mouseY;

    /**
     * Detect wrong answer
     */
    private boolean wrong;

    /**
     * count number of guesses
     */
    private int guesses;

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
        wrong=true;
        guesses=0;
        try {
            bgInst = ImageIO.read(new File("assets/background.jpg"));
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
        if (index<12 && e.getKeyCode() == KeyEvent.VK_ENTER){
            if(index<5 || index==6 || index==8 || index==10){
                index++;
            }
            else if((index==5 || index==7 || index==9 || index==11) && !wrong){
                index++;
                wrong=true;
            }
        }else if(index==12 && e.getKeyCode() == KeyEvent.VK_ENTER){
            restart();
            first=false;
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
        if(index==5){
            if(mouseDetect(158,408,181,281)){
                index++;
                wrong=false;
                guesses=0;
            }
            if(mouseDetect(158,408,281,381)){
                wrong=true;
                guesses++;
            }
            if(mouseDetect(408,658,181,281)){
                wrong=true;
                guesses++;
            }
            if(mouseDetect(408,658,281,381)){
                wrong=true;
                guesses++;
            }
        }
        if(index==7){
            if(mouseDetect(158,408,181,281)){
                wrong=true;
                guesses++;
            }
            if(mouseDetect(158,408,281,381)){
                index++;
                wrong=false;
                guesses=0;
            }
            if(mouseDetect(408,658,181,281)){
                wrong=true;
                guesses++;
            }
            if(mouseDetect(408,658,281,381)){
                wrong=true;
                guesses++;
            }
        }
        if(index==9){
            if(mouseDetect(158,408,181,281)){
                wrong=true;
                guesses++;
            }
            if(mouseDetect(158,408,281,381)){
                wrong=true;
                guesses++;
            }
            if(mouseDetect(408,658,181,281)){
                wrong=true;
                guesses++;
            }
            if(mouseDetect(408,658,281,381)){
                index++;
                wrong=false;
                guesses=0;
            }
        }
        if(index==11){
            if(mouseDetect(158,408,181,281)){
                index++;
                wrong=false;
                guesses=0;
            }
            if(mouseDetect(408,658,181,281)){
                wrong=true;
                guesses++;
            }
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
            g.drawImage(bgInst,0,0,800,500,null);
            g.setColor(deepBlue);
            g.fillRect(100,30,600,390);
            g.setColor(backgroundC);
            g.fillRect(120,50,560,350);
            g.setColor(grey);
            g.setFont(new Font("Serif", Font.PLAIN, 20));
            g.drawString("TIPS:",130,80);
            g.drawString("1) First, open up the map",130,120);
            g.drawString("2) Then, try to find where you are on the map",130,145);
            g.drawString("3) Don't rush to run around, be patient and observe your",130,170);
            g.drawString("    surroundings",130,195);
            g.drawString("4) Use clues such as the wall structures nearby to determine your",130,220);
            g.drawString("    location and guide you",130,245);
            g.drawString("5) If the map is too large and overwhelming, try to break it down in",130,270);
            g.drawString("    to smaller sections mentally to better observe familiar areas",130,295);
            g.drawString("6) Be confident in your decisions, and take a mental note of your",130,320);
            g.drawString("    location along the map",130,345);
            g.setFont(smallSerifFont);
            g.setFont(new Font("Serif", Font.PLAIN, 20));
            g.drawString("Press ENTER to  continue...",450,390);
        }
        if(index==4){
            g.setColor(Color.BLACK);
            g.fillRect(0,0,800,500);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Serif", Font.PLAIN, 50));
            g.drawString("LEVEL ONE",250,225);
            g.setFont(new Font("Serif", Font.PLAIN, 20));
            g.drawString("Press ENTER to continue...",550,450);
        }
        if(index==5){
            g.drawImage(bgInst,0,0,800,500,null);
            g.setColor(deepBlue);
            g.fillRect(100,30,600,390);
            g.setColor(backgroundC);
            g.fillRect(120,50,560,350);
            g.setColor(grey);
            g.setFont(smallSerifFont);
            g.drawString("Q: What is the first thing you do when",150,100);
            g.drawString("navigating a new environment?",150,130);
            g.setColor(deepBlue);
            g.drawRect(120,50,560,350);
            
            g.setColor(button1);
            g.fillRect(150,150,250,100);
            g.fillRect(150,250,250,100);
            g.fillRect(400,150,250,100);
            g.fillRect(400,250,250,100);
            g.setColor(button2);
            if(mouseDetect(158,408,181,281)){
                g.fillRect(150,150,250,100);
            }
            if(mouseDetect(158,408,281,381)){
                g.fillRect(150,250,250,100);
            }
            if(mouseDetect(408,658,181,281)){
                g.fillRect(400,150,250,100);
            }
            if(mouseDetect(408,658,281,381)){
                g.fillRect(400,250,250,100);
            }

            g.setColor(grey);
            g.drawRect(150,150,250,100);
            g.drawRect(150,250,250,100);
            g.drawRect(400,150,250,100);
            g.drawRect(400,250,250,100);
            g.setColor(grey);
            g.drawString("Open map",160,200);
            g.drawString("Wander aimlessly",410,200);
            g.drawString("Leave the building",160,300);
            g.drawString("Panic and scream",410,300);
            g.setColor(backgroundC);
            g.fillRect(125,370,250,25);
            if(wrong && guesses > 0){
                g.setColor(grey);
                g.setFont(smallSerifFont);
                g.drawString("Incorrect. Try Again!",125,390);
            }
            if(!wrong){
                g.setFont(new Font("Serif", Font.PLAIN, 20));
                g.drawString("Press ENTER to continue...",450,390);
            }
            g.setColor(grey);
        }
        if(index==6){
            wrong=true;
            g.drawImage(bgInst,0,0,800,500,null);
            g.setColor(deepBlue);
            g.fillRect(220,155,320,110);
            g.setColor(backgroundC);
            g.fillRect(230,165,300,90);
            g.setColor(Color.GREEN);
            g.setFont(new Font("Serif", Font.PLAIN, 50));
            g.drawString("CORRECT!",250,225);
            g.setFont(new Font("Serif", Font.PLAIN, 30));
            g.setColor(deepBlue);
            g.drawString("Press ENTER to continue...",450,390);
        }
        if(index==7){
            g.drawImage(bgInst,0,0,800,500,null);
            g.setColor(deepBlue);
            g.fillRect(100,30,600,390);
            g.setColor(backgroundC);
            g.fillRect(120,50,560,350);
            g.setColor(grey);
            g.setFont(smallSerifFont);
            g.drawString("Q: What is the best attitude to have",150,100);
            g.drawString("when navigating a new environment?",150,130);

            g.setColor(button1);
            g.fillRect(150,150,250,100);
            g.fillRect(150,250,250,100);
            g.fillRect(400,150,250,100);
            g.fillRect(400,250,250,100);
            g.setColor(button2);
            if(mouseDetect(158,408,181,281)){
                g.fillRect(150,150,250,100);
            }
            if(mouseDetect(158,408,281,381)){
                g.fillRect(150,250,250,100);
            }
            if(mouseDetect(408,658,181,281)){
                g.fillRect(400,150,250,100);
            }
            if(mouseDetect(408,658,281,381)){
                g.fillRect(400,250,250,100);
            }
            g.setColor(grey);
            g.drawRect(120,50,560,350);
            g.drawRect(150,150,250,100);
            g.drawRect(150,250,250,100);
            g.drawRect(400,150,250,100);
            g.drawRect(400,250,250,100);
            g.drawString("Impatient",160,200);
            g.drawString("Undetermined",405,200);
            g.drawString("Confident",160,300);
            g.drawString("Scared",410,300);
            g.setColor(backgroundC);
            g.fillRect(125,370,250,25);
            if(wrong && guesses > 0){
                g.setColor(grey);
                g.setFont(smallSerifFont);
                g.drawString("Incorrect. Try Again!",125,390);
            }
            if(!wrong){
                g.setFont(new Font("Serif", Font.PLAIN, 20));
                g.drawString("Press ENTER to continue...",450,390);
            }
            g.setColor(grey);
        }
        if(index==8){
            wrong=true;
            g.drawImage(bgInst,0,0,800,500,null);
            g.setColor(deepBlue);
            g.fillRect(220,155,320,110);
            g.setColor(backgroundC);
            g.fillRect(230,165,300,90);
            g.setColor(Color.GREEN);
            g.setFont(new Font("Serif", Font.PLAIN, 50));
            g.drawString("CORRECT!",250,225);
            g.setFont(new Font("Serif", Font.PLAIN, 30));
            g.setColor(deepBlue);
            g.drawString("Press ENTER to continue...",450,390);
        }
        if(index==9){
            g.drawImage(bgInst,0,0,800,500,null);
            g.setColor(deepBlue);
            g.fillRect(100,30,600,390);
            g.setColor(backgroundC);
            g.fillRect(120,50,560,350);
            g.setColor(grey);
            g.setFont(smallSerifFont);
            g.drawString("What clue can you use to determine your location?",150,100);
            g.setColor(button1);
            g.fillRect(150,150,250,100);
            g.fillRect(150,250,250,100);
            g.fillRect(400,150,250,100);
            g.fillRect(400,250,250,100);
            g.setColor(button2);
            if(mouseDetect(158,408,181,281)){
                g.fillRect(150,150,250,100);
            }
            if(mouseDetect(158,408,281,381)){
                g.fillRect(150,250,250,100);
            }
            if(mouseDetect(408,658,181,281)){
                g.fillRect(400,150,250,100);
            }
            if(mouseDetect(408,658,281,381)){
                g.fillRect(400,250,250,100);
            }
            g.setColor(grey);
            g.drawRect(120,50,560,350);
            g.drawRect(150,150,250,100);
            g.drawRect(150,250,250,100);
            g.drawRect(400,150,250,100);
            g.drawRect(400,250,250,100);
            g.drawString("A megaphone",160,200);
            g.drawString("Your shoes",410,200);
            g.drawString("The sky",160,300);
            g.drawString("Wall structures",410,300);
            g.setColor(backgroundC);
            g.fillRect(125,370,250,25);
            if(wrong && guesses > 0){
                g.setColor(grey);
                g.setFont(smallSerifFont);
                g.drawString("Incorrect. Try Again!",125,390);
            }
            if(!wrong){
                g.setFont(new Font("Serif", Font.PLAIN, 20));
                g.drawString("Press ENTER to continue...",450,390);
            }
            g.setColor(grey);
        }
        if(index==10){
            wrong=true;
            g.drawImage(bgInst,0,0,800,500,null);
            g.setColor(deepBlue);
            g.fillRect(220,155,320,110);
            g.setColor(backgroundC);
            g.fillRect(230,165,300,90);
            g.setColor(Color.GREEN);
            g.setFont(new Font("Serif", Font.PLAIN, 50));
            g.drawString("CORRECT!",250,225);
            g.setFont(new Font("Serif", Font.PLAIN, 30));
            g.setColor(deepBlue);
            g.drawString("Press ENTER to continue...",450,390);
        }
        if(index==11){
            g.drawImage(bgInst,0,0,800,500,null);
            g.setColor(deepBlue);
            g.fillRect(100,30,600,390);
            g.setColor(backgroundC);
            g.fillRect(120,50,560,350);
            g.setColor(grey);
            g.setFont(smallSerifFont);
            g.drawString("It is recommended to be patient when navigating.",150,100);
            g.setColor(button1);
            g.fillRect(150,150,250,100);
            g.fillRect(400,150,250,100);
            g.setColor(button2);
            if(mouseDetect(158,408,181,281)){
                g.fillRect(150,150,250,100);
            }
            if(mouseDetect(408,658,181,281)){
                g.fillRect(400,150,250,100);
            }
            g.setColor(grey);
            g.drawRect(120,50,560,350);
            g.drawRect(150,150,250,100);
            g.drawRect(400,150,250,100);
            g.drawString("True",160,200);
            g.drawString("False",410,200);
            g.setColor(backgroundC);
            g.fillRect(125,370,250,25);
            if(wrong && guesses > 0){
                g.setColor(grey);
                g.setFont(smallSerifFont);
                g.drawString("Incorrect. Try Again!",125,390);
            }
            if(!wrong){
                g.setFont(new Font("Serif", Font.PLAIN, 20));
                g.drawString("Press ENTER to continue...",450,390);
            }
            g.setColor(grey);
        }
        if(index==12){
            wrong=true;
            g.drawImage(bgInst,0,0,800,500,null);
            g.setColor(deepBlue);
            g.fillRect(220,155,320,110);
            g.setColor(backgroundC);
            g.fillRect(230,165,300,90);
            g.setColor(Color.GREEN);
            g.setFont(new Font("Serif", Font.PLAIN, 50));
            g.drawString("CORRECT!",250,225);
            g.setFont(new Font("Serif", Font.PLAIN, 30));
            g.setColor(deepBlue);
            g.drawString("Press ENTER to continue...",450,390);
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