package pong;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
enum BarDirection {RIGHT, LEFT};
public class Bar extends Shape
{
    private BarDirection dir = BarDirection.RIGHT;
    
    public Bar()
    {
        super(Constants.BAR_INITIAL_X,Constants.BAR_Y,Constants.BAR_INITIAL_LENGTH,Constants.BAR_INITIAL_WIDTH,new ImageIcon("bar 3.png"));
    }
        
    public void setDirection(BarDirection d){dir = d;}
    
    public BarDirection getDirection(){return dir;}
    
    public void draw(Graphics g , GamePanel p)
    {
        g.drawImage(img.getImage(),x,y,Width, Length, p);
    }
            
    public void MoveLeft()
    {
        if(x > 0)
            x -= 20;
    }
 
    public void MoveRight()
    {
        if(x + Width < Constants.FRAME_W)
           x += 20;
    }
    
    public void DecreaseSize(int x)
    {
        Width = Width - x;
    }
    
    public void reset()
    {
        this.x=Constants.BAR_INITIAL_X;
        this.y=Constants.BAR_Y;
        this.Length =Constants.BAR_INITIAL_LENGTH;
        this.Width=Constants.BAR_INITIAL_WIDTH;
    }
}