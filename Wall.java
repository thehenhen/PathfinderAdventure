import java.awt.*;

/**
 * Wall class to define boundaries of where player can move
 */
public class Wall {
    public int type;
    public int x1;
    public int y1;
    public int x2;
    public int y2;

    /**
     * Constructor to make a Wall
     * @param type horizontal/vertical
     * @param x1 x-coord of first point
     * @param y1 y-coord of first point
     * @param x2 x-coord of second point
     * @param y2 y-coord of second point
     */
    public Wall(int type, int x1, int y1, int x2, int y2) {
        this.type = type;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    /**
     * Checks if player can move up
     * @param l Level object
     * @return up
     */
    public boolean updateUp(Level l) {
        boolean up = true;
        if(x2-x1>50){
            if ((l.getPlayerX() + 400 - 25 > x1 && l.getPlayerX() + 400 - 25 < x2) || (l.getPlayerX() + 400 + 25 > x1 && l.getPlayerX() + 400 + 25 < x2)) {
                if (l.getPlayerY() + 250 - 25 == y1) {
                    //l.cup = false;
                    up=false;
                }
            }
        }else{
            if((x2+x1)/2>l.getPlayerX()+400-25 && (x2+x1)/2<l.getPlayerX()+400+25){
                if (l.getPlayerY() + 250 - 25 == y1) {
                    up = false;
                }
            }
        }
        return up;
    }
    
    /**
     * Checks if player can move down
     * @param l Level object
     * @return up
     */
    public boolean updateDown(Level l) {
        boolean down = true;
        if(x2-x1>50){
            if ((l.getPlayerX() + 400 - 25 > x1 && l.getPlayerX() + 400 - 25 < x2) || (l.getPlayerX() + 400 + 25 > x1 && l.getPlayerX() + 400 + 25 < x2)) {
                if (l.getPlayerY() + 250 + 25 == y1) {
                    //l.cdown = false;
                    down=false;
                }
            }
        }else{
            if((x2+x1)/2>l.getPlayerX()+400-25 && (x2+x1)/2<l.getPlayerX()+400+25){
                if (l.getPlayerY() + 250 + 25 == y1) {
                    down = false;
                }
            }
        }
        return down;
    }
    
    
    /**
     * Checks if player can move left
     * @param l Level object
     * @return up
     */
    public boolean updateLeft(Level l) {
        boolean left = true;
        if(y2-y1>50){
            if ((l.getPlayerY() + 250 - 25 > y1 && l.getPlayerY() + 250 - 25 < y2) || (l.getPlayerY() + 250 + 25 > y1 && l.getPlayerY() + 250 + 25 < y2)) {
                if (l.getPlayerX() + 400 - 25 == x1) {
                    //l.cleft=false;
                    left = false;
                }
            }
        }else{
            if((y2+y1)/2>l.getPlayerY()+250-25 && (y2+y1)/2<l.getPlayerY()+250+25){
                if (l.getPlayerX() + 400 - 25 == x1) {
                    left = false;
                }
            }
        }
        return left;
    }
    
    
    /**
     * Checks if player can move right
     * @param l Level object
     * @return up
     */
    public boolean updateRight(Level l) {
        boolean right = true;
        if(y2-y1>50){
            if ((l.getPlayerY() + 250 - 25 > y1 && l.getPlayerY() + 250 - 25 < y2) || (l.getPlayerY() + 250 + 25 > y1 && l.getPlayerY() + 250 + 25 < y2)) {
                if (l.getPlayerX() + 400 + 25 == x1) {
                    //l.cright=false;
                    right = false;
                }
            }
        }else{
            if((y2+y1)/2>l.getPlayerY()+250-25 && (y2+y1)/2<l.getPlayerY()+250+25){
                if (l.getPlayerX() + 400 + 25 == x1) {
                    right = false;
                }
            }
        }
        return right;
    }
    
    /**
     * Displays the Wall
     * @param g
     * @param l
     */
    public void display(Graphics g, Level l) {
        g.setColor(Color.BLACK);
        g.drawLine(x1 - l.playerX, y1 - l.playerY, x2 - l.playerX, y2 - l.playerY);
    }
}
