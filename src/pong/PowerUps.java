package pong;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class PowerUps
{    
    protected static ImageIcon IncreaseLifeImg = new ImageIcon ("LifeIncrease.png");
    protected static ImageIcon DecreaseLifeImg = new ImageIcon("LifeDecrease.png");
    protected static ImageIcon BarIncreaseImg = new ImageIcon("BarIncrease.png");
    protected static ImageIcon BarDecreaseImg = new ImageIcon ("BarDecrease.png");
    protected static ImageIcon BallSizeIncreaseImg = new ImageIcon("BallSizeIncrease.png");
    protected static ImageIcon BallSizeDecreaseImg = new ImageIcon("BallSizeDecrease.png");
    protected static ImageIcon GiveBallImg = new ImageIcon ("GiveBall.png");
    
    
    protected static PowerUp IncreaseLife;
    protected static PowerUp DecreaseLife;
    protected static PowerUp BarIncrease;
    protected static PowerUp BarDecrease;
    protected static PowerUp BallSizeIncrease;
    protected static PowerUp BallSizeDecrease;
    protected static PowerUp GiveBall;
    
    protected static ArrayList<PowerUp> List = new ArrayList<PowerUp>();
    
    public PowerUps()
    {
        IncreaseLife = new PowerUp(0,IncreaseLifeImg);
        DecreaseLife = new PowerUp(1,DecreaseLifeImg);
        BarIncrease = new PowerUp(2,BarIncreaseImg);
        BarDecrease = new PowerUp(3,BarDecreaseImg);
        BallSizeIncrease = new PowerUp(4,BallSizeIncreaseImg);
        BallSizeDecrease = new PowerUp(5,BallSizeDecreaseImg);
        GiveBall = new PowerUp(6,GiveBallImg);
        List.clear();
        FillPowerUps();
    }
    
    public static void FillPowerUps()
    {
        List.add(IncreaseLife);
        List.add(DecreaseLife);
        List.add(BarIncrease);
        List.add(BarDecrease);
        List.add(BallSizeIncrease);
        List.add(BallSizeDecrease);
        List.add(GiveBall);
    }
    
    public static void IncreaseLife()
    {
        GameFrame.AddLife();
    }
    
    public static void DecreaseLife()
    {
        GameFrame.RemoveLife(true);
    }
    
    public static void BarIncrease()
    {
        if(GameFrame.GameBar.Width < 300)
            GameFrame.GameBar.setWidth(GameFrame.GameBar.getWidth()/2 + GameFrame.GameBar.getWidth());
    }
    
    public static void BarDecrease ()
    {
        if(GameFrame.GameBar.Width > 50)
            GameFrame.GameBar.setWidth(GameFrame.GameBar.getWidth()/2);
    }
    
    public static void GiveBall()
    {
        Ball b = new Ball();
        GamePanel.GameBalls.add(b);
    }
    
    public static void IncreaseBallSize()
    {
        if(GameFrame.GameBalls.get(0).Length < 32 && GameFrame.GameBalls.get(0).Width < 32)
        {
            GameFrame.GameBalls.get(0).setWidth(GameFrame.GameBalls.get(0).getWidth()/2 + GameFrame.GameBalls.get(0).getWidth());
            GameFrame.GameBalls.get(0).setLength(GameFrame.GameBalls.get(0).getLength()/2 + GameFrame.GameBalls.get(0).getLength());
        }
    }
    
    public static void DecreaseBallSize()
    {
        if(GameFrame.GameBalls.get(0).Width > 4)
        {
            GameFrame.GameBalls.get(0).setWidth(GameFrame.GameBalls.get(0).getWidth()/2);
            GameFrame.GameBalls.get(0).setLength(GameFrame.GameBalls.get(0).getLength()/2);
        }
    }
    
    public static void ActivatePowerUp(int n)
    {
        switch(n)
        {
            case 0:
                IncreaseLife();
                break;
            
            case 1:
                DecreaseLife();
                break;
              
            case 2:
                BarIncrease();
                break;
               
            case 3:
                BarDecrease();
                break;
                
            case 4:
                IncreaseBallSize();
                break;
                
            case 5:
                DecreaseBallSize();
                break;  
                
            case 6:
                GiveBall();
                break;
        }
    }   
}