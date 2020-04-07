package pong;
import java.awt.*;
import java.util.*;

public class Bricks
{
    protected ArrayList<Brick> bricks;
    
    public Bricks()
    { 
        bricks  = new ArrayList<Brick>();
        Constants.BRICK_INITIAL_Y = 0;
        for(int i=0 ; i < Constants.BRICK_ROWS ; i++)
        {   
            Constants.BRICK_INITIAL_X =0;
            for(int j=0 ; j < 10 ; j++)
            {
                Brick r = new Brick();
                bricks.add(r);
                Constants.BRICK_INITIAL_X = Constants.BRICK_INITIAL_X + Constants.BRICK_WIDTH + 2;
            }
            Constants.BRICK_INITIAL_Y = Constants.BRICK_INITIAL_Y + Constants.BRICK_LENGTH + 2;
        }               
    }  
    
    public void draw(Graphics g , GamePanel p)
    {
        for(int i=0 ; i < bricks.size() ; i++)
            bricks.get(i).draw(g,p);
    }
}