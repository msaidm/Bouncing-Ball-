package pong;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class PowerUp extends Shape
{
    protected int ID;
    
    public PowerUp (int ID , ImageIcon img)
    {
       super(0,0,30,30, img);
       this.ID = ID;       
    }
    
    public boolean hasBarCollision(Bar bar)
    {
        for(int m=0 ; m < Constants.PU_dy; m++)
        {
            for(int i=bar.getX() ; i <= bar.getX() + bar.getWidth() ; i++)
            {
                if(x+m == i && y+m == bar.getY())
                    return true;
            }
        }
        return false;
    }
    
    public boolean hasLowerWallCollision()
    {
        for(int m=0; m< Constants.PU_dy ;m++)
            if(y+m == Constants.FRAME_H)
               return true;
         return false;
    }

    public void move(Bar b)
    {
        y+= Constants.PU_dy;
        
        if(hasBarCollision(b))
        {
            PowerUps.ActivatePowerUp(this.ID);
            this.img = new ImageIcon(); 
        }
    }

    @Override
    public void draw(Graphics g, GamePanel p) 
    {
        new PowerUps();
        g.drawImage(img.getImage(), x, y, Length, Width, p);
    }
}