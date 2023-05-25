import java.awt.*;
import java.awt.geom.Line2D;
import javax.swing.*;

public class Wall {
    //type: 
    //1 horizontal
    //2 vertical
    //x1
    //y1
    //x1
    //y2
    public int type;
    public int x1;
    public int y1;
    public int x2;
    public int y2;
    
    public Wall(int type,int x1,int y1,int x2,int y2){
        this.type=type;
        this.x1=x1;
        this.y1=y2;
        this.x2=x2;
        this.y2=y2;
    }

    public boolean updateUp(FirstLevel f){
        boolean up=true;
        //System.out.println("update");
        if((f.x+400>x1-f.x && f.x+400<x2-f.x) || (f.x+400<x1-f.x && f.x+400>x2-f.x)){
            System.out.println("within");
            if(f.y-y1+250 >-25 && f.y-y1+250<0){
                f.cup=false;
                System.out.println("touch");
            }
        }
        return up;
    }

    public void display(Graphics g,FirstLevel f){
        g.setColor(Color.BLACK);
        g.drawLine(x1-f.x,y1-f.y,x2-f.x,y2-f.y);
    }
}
