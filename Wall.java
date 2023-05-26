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

    public boolean updateUp(FirstLevel f) {
        boolean up = true;
        if ((f.x + 400 - f.playerSize/2 >= x1 && f.x + 400 - f.playerSize/2 <= x2) || (f.x + 400 + f.playerSize/2 >= x1 && f.x + 400 + f.playerSize/2 <= x2)) {
            if (f.y + 250 >= y1 - f.y && f.y + 250 <= y2 - f.y) {
                f.cup = false;
            }
        }
        return up;
    }

    public boolean updateDown(FirstLevel f) {
        boolean down = true;
        if ((f.x + 400 - f.playerSize/2 >= x1 && f.x + 400 - f.playerSize/2 <= x2) || (f.x + 400 + f.playerSize/2 >= x1 && f.x + 400 + f.playerSize/2 <= x2)) {
            if (f.y + 300 + f.playerSize >= y1 - f.y && f.y + 300 + f.playerSize <= y2 - f.y) {
                f.cdown = false;
            }
        }
        return down;
    }

    public boolean updateLeft(FirstLevel f) {
    boolean left = true;
    if ((f.y + 250 - f.playerSize/2 >= y1 && f.y + 250 - f.playerSize/2 <= y2) || (f.y + 250 + f.playerSize/2 >= y1 && f.y + 250 + f.playerSize/2 <= y2)) {
        if (f.x + 400 >= x1 - f.x && f.x + 400 <= x2 - f.x) {
            f.cleft = false;
        }
    }
    return left;
}

    
    
    
    
    
    

    public void display(Graphics g, FirstLevel f) {
        g.setColor(Color.BLACK);
        g.drawLine(x1 - f.x, y1 - f.y, x2 - f.x, y2 - f.y);
    }
}
