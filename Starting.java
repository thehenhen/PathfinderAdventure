import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Starting {

    public Starting(){
        JFrame frame = new JFrame("Graphical Greeting");
        frame.setSize(800,500);
        frame.add(new Drawing());
        frame.setVisible(true);
    }

    public static void main (String[] args){
        new Starting();
    }

    class Drawing extends JComponent{
        public void paint (Graphics g){
            Font largeSerifFont = new Font("Serif", Font.PLAIN, 50);
            Font smallSerifFont = new Font("Serif", Font.PLAIN, 40);
            g.setFont(largeSerifFont);
            g.drawString("PATHFINDER", 250, 150);
            g.setFont(smallSerifFont);
            g.drawString("ADVENTURE", 275, 200);
        }
    }
}