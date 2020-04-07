package pong;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
enum BallDirection {UP, DOWN , LEFT , RIGHT};

public class Ball extends Shape 
{
    private BallDirection Vertical_D = BallDirection.UP;
    private BallDirection Horizontal_D = BallDirection.RIGHT;
    
    public Ball()
    {
        super(Constants.BALL_INITIAL_X,Constants.BALL_INITIAL_Y,Constants.BALL_INITIAL_LENGTH,Constants.BALL_INITIAL_WIDTH,new ImageIcon("ball 2.png"));
    }
    
    public void draw(Graphics g,GamePanel p)
    {
        g.drawImage(img.getImage(), x, y, Length, Width, p);
    }
    
    public boolean hasBarCollision(Bar bar)
    {
        for(int m=0;m<Constants.BALL_dx;m++)
        {
            for(int i=bar.getX() ; i <= bar.getX() + bar.getWidth() ; i++)
            {
              if(x+m == i && y+m == bar.getY()-10)
                  return true;
            }
        }
        return false;        
    }
    
    public boolean hasBrickCollision(Bricks b)
    {  
        for(int m=0;m<Constants.BALL_dx;m++)
        {      
            for(int i=0 ; i< b.bricks.size() ; i++) 
            {
              for(int j=b.bricks.get(i).getX() ; j <= b.bricks.get(i).getX()+b.bricks.get(i).getWidth() ; j++ )
                   if(((x+m) == j && (y+m) == b.bricks.get(i).getY()+b.bricks.get(i).getLength()) || ((x+m) == j && (y+m) == b.bricks.get(i).getY()))
                    {   
                     b.bricks.remove(b.bricks.get(i));
                     GameFrame.IncreaseScore();
                        return true;
                    }                  
            }
        }
        return false;
    }
    
    public boolean hasBrickSidesCollision(Bricks b)
    {    
        for(int m=0;m<Constants.BALL_dx;m++)
        {
            for(int i=0 ; i< b.bricks.size() ; i++)
            {
                if(y+m >= b.bricks.get(i).getY() && y+m <= b.bricks.get(i).getY()+b.bricks.get(i).getLength())  
                {
                    if(x+m == b.bricks.get(i).getX() || x+m == b.bricks.get(i).getX() + b.bricks.get(i).getWidth())
                    {
                        b.bricks.remove(b.bricks.get(i));
                        GameFrame.IncreaseScore();
                        return true;
                    }
                }      
            }
        }
        return false;
    }
    
    public boolean hasLeftWallCollision()
    {
        for(int m=0;m<Constants.BALL_dx;m++)
             if(x+m == 0)
                return true;
        return false;
    }
    
    public boolean hasRightWallCollision()
    {
        for(int m=0;m<Constants.BALL_dx;m++)
           if(x+m == Constants.FRAME_W)
              return true;
        return false;
    }
    
    public boolean hasUpperWallCollision()
    {
        for(int m=0;m<Constants.BALL_dx;m++)
             if(y+m ==0)
               return true;
        return false;
    }
    
    public boolean hasLowerWallCollision()
    {
        for(int m=0;m<Constants.BALL_dx;m++)
            if(y+m == Constants.FRAME_H)
               return true;
         return false;
    }
    
    public void Deflect(BallDirection h , BallDirection v)
    {
        Horizontal_D = h;
        Vertical_D = v;
    }
    
    public void move(Bar bar , Bricks bricks)
    {
        if(Horizontal_D == BallDirection.RIGHT && Vertical_D == BallDirection.DOWN)
        {
            x+=Constants.BALL_dx;
            y+=Constants.BALL_dy;
        }
        
        if(Horizontal_D == BallDirection.RIGHT && Vertical_D == BallDirection.UP)
        {
            x+=Constants.BALL_dx;
            y-=Constants.BALL_dy;
        }
        
        if(Horizontal_D == BallDirection.LEFT && Vertical_D == BallDirection.DOWN)
        {
            x-=Constants.BALL_dx;
            y+=Constants.BALL_dy;
        }
        
        if(Horizontal_D == BallDirection.LEFT && Vertical_D == BallDirection.UP)
        {
            x-=Constants.BALL_dx;
            y-=Constants.BALL_dy;
        }
              
        if(hasBarCollision(bar))
        {
            if(Horizontal_D == BallDirection.RIGHT && Vertical_D == BallDirection.DOWN)
                Deflect(BallDirection.RIGHT , BallDirection.UP);
            
            else if(Horizontal_D == BallDirection.LEFT && Vertical_D == BallDirection.DOWN)
                Deflect(BallDirection.LEFT , BallDirection.UP);
        }
        
        if(hasUpperWallCollision())
        {
            if(Horizontal_D == BallDirection.LEFT && Vertical_D == BallDirection.UP)
                Deflect(BallDirection.LEFT , BallDirection.DOWN);
            
            else if(Horizontal_D == BallDirection.RIGHT && Vertical_D == BallDirection.UP)
                Deflect(BallDirection.RIGHT , BallDirection.DOWN);
        }
        
        if(hasRightWallCollision())
        {
            if(Vertical_D == BallDirection.DOWN)
                Deflect(BallDirection.LEFT , BallDirection.DOWN);
            
            else if(Vertical_D == BallDirection.UP)
                Deflect(BallDirection.LEFT , BallDirection.UP);
        }
        
        if(hasLeftWallCollision())
        {
            if(Vertical_D == BallDirection.DOWN)
                Deflect(BallDirection.RIGHT , BallDirection.DOWN);
            
            else if(Vertical_D == BallDirection.UP)
                Deflect(BallDirection.RIGHT , BallDirection.UP);
        }
        
        if(hasBrickSidesCollision(bricks))
        {
            if(Horizontal_D == BallDirection.LEFT && Vertical_D == BallDirection.UP)
                Deflect(BallDirection.RIGHT,BallDirection.UP);
            
            else if(Horizontal_D == BallDirection.LEFT && Vertical_D == BallDirection.DOWN)
                Deflect(BallDirection.RIGHT,BallDirection.DOWN);
            
            else if(Horizontal_D == BallDirection.RIGHT && Vertical_D == BallDirection.UP)
                Deflect(BallDirection.LEFT,BallDirection.UP);
            
            else if(Horizontal_D == BallDirection.RIGHT && Vertical_D == BallDirection.DOWN)
                Deflect(BallDirection.LEFT,BallDirection.DOWN);
        }
        
        if(hasBrickCollision(bricks))
        {
            if(Horizontal_D == BallDirection.LEFT && Vertical_D == BallDirection.UP)
                Deflect(BallDirection.LEFT,BallDirection.DOWN);
            
            else if(Horizontal_D == BallDirection.LEFT && Vertical_D == BallDirection.DOWN)
                Deflect(BallDirection.LEFT,BallDirection.UP);
            
            else if(Horizontal_D == BallDirection.RIGHT && Vertical_D == BallDirection.UP)
                Deflect(BallDirection.RIGHT,BallDirection.DOWN);
            
            else if(Horizontal_D == BallDirection.RIGHT && Vertical_D == BallDirection.DOWN)
                Deflect(BallDirection.RIGHT,BallDirection.UP);           
        }
    }     
    
    public void reset()
    {
        Vertical_D = BallDirection.UP;
        Horizontal_D = BallDirection.RIGHT;
        x= Constants.BALL_INITIAL_X;
        y= Constants.BALL_INITIAL_Y;
        Length =Constants.BALL_INITIAL_LENGTH;
        Width=Constants.BALL_INITIAL_WIDTH;

    }
}