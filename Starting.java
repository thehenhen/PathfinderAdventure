import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;

public class Starting {

   private Image image;

    public Starting(){
        JFrame frame = new JFrame("Graphical Greeting");
        frame.setSize(800,500);
        try{
            image = ImageIO.read(new File("C:\\Users\\probi\\Downloads\\PathFinderAdventure\\PathfinderAdventure\\background.jpg"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
        frame.add(new Drawing());
        frame.setVisible(true);
    }

    public static void main (String[] args){
        new Starting();
    }

    class Drawing extends JComponent{
        public void paint (Graphics g){
            Font largeSerifFont = new Font("Serif", Font.PLAIN, 80);
            Font smallSerifFont = new Font("Serif", Font.PLAIN, 60);
            Font smallestSerifFont = new Font("Serif", Font.PLAIN, 40);
            g.drawImage(image,0,0,800,500,null);
            g.setFont(largeSerifFont);
            g.setColor(Color.orange);
            g.drawString("PATHFINDER", 150, 150);
            g.setFont(smallSerifFont);
            g.drawString("ADVENTURE", 210, 200);
            g.setFont(smallestSerifFont);
            g.setColor(Color.yellow);
            g.drawString("PLAY",350,285);
        }
    }
}