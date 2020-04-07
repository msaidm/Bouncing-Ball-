package pong;
import java.awt.*;
import javax.swing.*;

abstract class Shape 
{
    protected int x; 
    protected int y;
    protected int Length;
    protected int Width;
    protected ImageIcon img;

    
    public Shape(int x, int y , int Length , int Width , ImageIcon img)
    {
        this.x = x;
        this.y = y;
        this.Length = Length;
        this.Width = Width;
        this.img = img;
    }
    
    public int getX(){return x;}
    
    public int getY(){return y;}
    
    public void setX(int x){this.x = x;}
    
    public void setY(int y){this.y = y;}
    
    public int getLength(){return Length;}
    
    public int getWidth(){return Width;}
    
    public void setLength(int length){this.Length = length;}
    
    public void setWidth(int width){this.Width = width;}
    
    public void setImage(ImageIcon i){this.img = i;}

    public abstract void draw(Graphics g , GamePanel p);   
}