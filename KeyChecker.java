import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//from   www. ja  v a 2  s  .c o m
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.event.KeyAdapter;

public class KeyChecker extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent event) {

        char ch = event.getKeyChar();

        System.out.println(event.getKeyChar());

    }

}