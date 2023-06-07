import java.awt.*;

public class AntiWall {
    public int type;
    public int x1;
    public int y1;
    public int x2;
    public int y2;

    public AntiWall(int type, int x1, int y1, int x2, int y2) {
        this.type = type;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

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

    public void display(Graphics g, Level l) {
        g.setColor(Color.WHITE);
        g.drawLine(x1 - l.playerX, y1 - l.playerY, x2 - l.playerX, y2 - l.playerY);
    }
}
