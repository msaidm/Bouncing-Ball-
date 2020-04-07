package pong;

import java.awt.*;
import javax.swing.*;

public class Brick extends Shape
{   
    public Brick()
    {
        super(Constants.BRICK_INITIAL_X,Constants.BRICK_INITIAL_Y,Constants.BRICK_LENGTH,Constants.BRICK_WIDTH , new ImageIcon("brick 2.png"));
    }
    
    public void draw(Graphics g , GamePanel p)
    {
        g.drawImage(img.getImage(), x, y, Width, Length, p);
    }
}