import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
//import javax.swing.JFrame;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Runner 
{
    private boolean shouldStop = false;

    private boolean pause = false;

    Starting start = new Starting();
    MovingMechanics move = new MovingMechanics();

    public void shouldStop() {
        this.shouldStop = true;
    }

    public void pauseGame() { pause = true; }

    public void resumeGame() { pause = false; }

    public void run()
    {
        while( !shouldStop )
        {
            try {
                Thread.sleep( 500 );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if( !pause )
            {
                if(start.starting){
                    start.repaint();
                    start.setSize(800,500);
                    start.setResizable(false);
                    start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    start.setVisible(true);
                }
                else if(move.moving){
                    move.repaint();

                    start.add(move);
                    start.setVisible(true);
                }

            }
        }
    }

    public boolean isPaused() {
        return pause;
    }

    public static void main(String[] args){
        Runner r = new Runner();
        r.run();
    }
}