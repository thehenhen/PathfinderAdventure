import java.awt.*;

/**
 * Holes in the wall to let player through walls
 */
public class AntiWall {
    public int type;
    public int x1;
    public int y1;
    public int x2;
    public int y2;
    
    /**
     * Constructor to make an AntiWall
     * @param type horizontal/vertical
     * @param x1 x-coord of first point
     * @param y1 y-coord of first point
     * @param x2 x-coord of second point
     * @param y2 y-coord of second point
     */
    public AntiWall(int type, int x1, int y1, int x2, int y2) {
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
        boolean up = false;
        if ((l.getPlayerX() + 400 - 25 > x1 && l.getPlayerX() + 400 - 25 < x2) && (l.getPlayerX() + 400 + 25 > x1 && l.getPlayerX() + 400 + 25 < x2)) {
            if (l.getPlayerY() + 250 - 25 == y1) {
                //l.cup = false;
                up=true;
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
        boolean down = false;
        if ((l.getPlayerX() + 400 - 25 > x1 && l.getPlayerX() + 400 - 25 < x2) && (l.getPlayerX() + 400 + 25 > x1 && l.getPlayerX() + 400 + 25 < x2)) {
            if (l.getPlayerY() + 250 + 25 == y1) {
                //l.cdown = false;
                down=true;
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
        boolean left = false;
        if ((l.getPlayerY() + 250 - 25 > y1 && l.getPlayerY() + 250 - 25 < y2) && (l.getPlayerY() + 250 + 25 > y1 && l.getPlayerY() + 250 + 25 < y2)) {
            if (l.getPlayerX() + 400 - 25 == x1) {
                //l.cleft=false;
                left = true;
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
        boolean right = false;
        if ((l.getPlayerY() + 250 - 25 > y1 && l.getPlayerY() + 250 - 25 < y2) && (l.getPlayerY() + 250 + 25 > y1 && l.getPlayerY() + 250 + 25 < y2)) {
            if (l.getPlayerX() + 400 + 25 == x1) {
                //l.cright=false;
                right = true;
            }
        }
        return right;
    }

    /**
     * Displays the AntiWall
     * @param g
     * @param l
     */
    public void display(Graphics g, Level l) {
        g.drawLine(x1 - l.playerX, y1 - l.playerY, x2 - l.playerX, y2 - l.playerY);
    }
}
