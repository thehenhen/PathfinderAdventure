import java.awt.*;

public class Wall {
    public int type;
    public int x1;
    public int y1;
    public int x2;
    public int y2;

    public Wall(int type, int x1, int y1, int x2, int y2) {
        this.type = type;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public boolean updateUp(Level l) {
        boolean up = true;
        if ((l.getX() + 400 - 25 > x1 && l.getX() + 400 - 25 < x2) || (l.getX() + 400 + 25 > x1 && l.getX() + 400 + 25 < x2)) {
            if (l.getY() + 250 - 25 == y1) {
                l.cup = false;
                up=false;
            }
        }
        return up;
    }
    

    public boolean updateDown(Level l) {
        boolean down = true;
        if ((l.getX() + 400 - 25 > x1 && l.getX() + 400 - 25 < x2) || (l.getX() + 400 + 25 > x1 && l.getX() + 400 + 25 < x2)) {
            if (l.getY() + 250 + 25 == y1) {
                l.cdown = false;
                down=false;
            }
        }
        return down;
    }
    
    

    public boolean updateLeft(Level l) {
        boolean left = true;
        if ((l.getY() + 250 - 25 > y1 && l.getY() + 250 - 25 < y2) || (l.getY() + 250 + 25 > y1 && l.getY() + 250 + 25 < y2)) {
            if (l.getX() + 400 - 25 == x1) {
                l.cleft=false;
                left = false;
            }
        }
        return left;
    }
    
    

    public boolean updateRight(Level l) {
        boolean right = true;
        if ((l.getY() + 250 - 25 > y1 && l.getY() + 250 - 25 < y2) || (l.getY() + 250 + 25 > y1 && l.getY() + 250 + 25 < y2)) {
            if (l.getX() + 400 + 25 == x1) {
                l.cright=false;
                right = false;
            }
        }
        return right;
    }
    

    public void display(Graphics g, Level l) {
        g.setColor(Color.BLACK);
        g.drawLine(x1 - l.playerX, y1 - l.playerY, x2 - l.playerX, y2 - l.playerY);
    }
}
