package pong;
import java.awt.*;
import javax.swing.*;

public class StartPanel extends JPanel
{
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        ImageIcon Background = new ImageIcon("start menu background.png");
        g.drawImage(Background.getImage(), 0, 0, getWidth(), getHeight(), this);       
    }    
}