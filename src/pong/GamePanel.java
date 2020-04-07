package pong;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

public class GamePanel extends JPanel
{
    private Bar GameBar;
    protected static ArrayList<Ball> GameBalls;
    private Bricks GameBricks;
    private PowerUp GamePowerUp;
    private boolean isPaused;
    private boolean isActivated;
    private ImageIcon PanelBackground = new ImageIcon("game background.png");
    protected static javax.swing.Timer BallTimer;
    protected static javax.swing.Timer PowerUpTimerMove;
    protected static javax.swing.Timer PowerUpTimerShow; 

    public GamePanel(Bar bar , ArrayList<Ball> ball , Bricks brick)
    {
      GameBar = bar;
      GameBalls = ball;
      GameBricks = brick;
      PowerUps.FillPowerUps();
      isPaused = false;
      isActivated = false;
      GamePowerUp = new PowerUp(0 ,new ImageIcon());
      setFocusable(true);
      setPreferredSize(new Dimension(Constants.FRAME_W, Constants.FRAME_H));
      this.addKeyListener(new Keys());
      this.addMouseMotionListener(new BarMotionMouse());
      BallTimer = new javax.swing.Timer(Constants.DELAY, new BallMotion());
      PowerUpTimerMove = new javax.swing.Timer(Constants.PU_MOVE_DELAY, new MovePowerup());
      PowerUpTimerShow = new javax.swing.Timer(Constants.PU_SHOW_DELAY, new ShowPowerup());
      //PowerUpTimerShow.start();
    }
    
    @Override
    public void paint(Graphics g)
    {
        super.paint(g); 
        GameBar.draw(g,this);
        for(int i=0;i<GameBalls.size();i++)
          GameBalls.get(i).draw(g,this);
        GameBricks.draw(g,this);
        GamePowerUp.draw(g,this);
    }
    
    @Override
     public void paintComponent(Graphics g)
     {
        super.paintComponent(g);
        g.drawImage(PanelBackground.getImage(), 0, 0, getWidth(), getHeight(), this);
     }
     
     public void ClearedBricks(int n)
     {
        if(n == 0)
        {
            GameFrame.IncreaseLevel();
            Constants.BRICK_ROWS++;
            GameBricks = new Bricks();
            GameBalls.get(0).reset();
            GameBar.reset();
            repaint();
        }
        
        else if(n == 1)
        {
            new SaveScoreFrame(this);
        }
        
        else
        {
            new StartFrame();
            JFrame GameFrame =(JFrame) SwingUtilities.getWindowAncestor(this);
            GameFrame.setVisible(false);
        }
     }
     
    class Keys extends KeyAdapter
    {
        public void keyPressed(KeyEvent e)
            {
                if(e.getKeyCode()==KeyEvent.VK_RIGHT && !isPaused)
                {
                    BallTimer.start();
                    PowerUpTimerShow.start();
                    GameBar.setDirection(BarDirection.RIGHT);
                    GameBar.MoveRight();
                    repaint();
                }
                
                else if(e.getKeyCode()==KeyEvent.VK_LEFT && !isPaused)
                {
                    BallTimer.start();
                    PowerUpTimerShow.start();
                    GameBar.setDirection(BarDirection.LEFT);
                    GameBar.MoveLeft();
                    repaint();                  
                }
                
                else if(e.getKeyCode() == KeyEvent.VK_SPACE)
                {
                    if(isPaused)
                    {
                        BallTimer.start();
                        PowerUpTimerShow.start();
                        if(isActivated)
                            PowerUpTimerMove.start();
                        isPaused = false;
                    }
                    
                    else if(!isPaused)
                    {
                        BallTimer.stop();
                        PowerUpTimerShow.stop();
                        if(isActivated)
                            PowerUpTimerMove.stop();
                        JOptionPane.showMessageDialog(GamePanel.this, "Game is paused , press space again to continue");
                        isPaused = true;
                    }
                }
            }            
    }
    
    class BarMotionMouse extends MouseMotionAdapter
    {
        private int OldX = 0;
        public void mouseMoved(MouseEvent e)
        {
            if(e.getX() > OldX && BallTimer.isRunning())
            {
                GameBar.setDirection(BarDirection.RIGHT);
                GameBar.MoveRight();
                repaint();   
            }
            
            else if(e.getX() < OldX && BallTimer.isRunning())
            {
                GameBar.setDirection(BarDirection.LEFT);
                GameBar.MoveLeft();
                repaint();
            }
            OldX = e.getX();
        }
    }
    
    class BallMotion implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(GameBalls.size()==1 && GameBalls.get(0).hasLowerWallCollision())
                    GameFrame.RemoveLife(false);
            
            else if(GameBalls.size()>1)
            {
                for( int i=0; i<GameBalls.size();i++ )
                    if(GameBalls.get(i).hasLowerWallCollision())
                        GameBalls.remove(i);
            }
                
            
            if(GameBricks.bricks.isEmpty())
            {
                BallTimer.stop();
                PowerUpTimerShow.stop();
                PowerUpTimerMove.stop();
                Object[] options = {"Continue" , "Save Score and exit" , "Exit"} ;
                int n = JOptionPane.showOptionDialog(GamePanel.this, "You cleared all bricks!", "Victory", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[2]);
                ClearedBricks(n);
            }
            
            

            for(int i=0; i<GameBalls.size();i++)
            {
                GameBalls.get(i).move(GameBar,GameBricks);
                repaint();
            }
        }
    }
    
    class ShowPowerup implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Random r = new Random();
            int Rand = r.nextInt(7);
            GamePowerUp = PowerUps.List.get(Rand);
            GamePowerUp.setX(r.nextInt(Constants.FRAME_W-15));
            GamePowerUp.draw(GamePanel.this.getGraphics(),GamePanel.this);
            repaint();
            PowerUpTimerMove.start();
            isActivated = true;            
        }
    }
    
    class MovePowerup implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            GamePowerUp.move(GameBar);
            if(GamePowerUp.hasBarCollision(GameBar))
            {
                PowerUpTimerMove.stop();
                repaint();
                isActivated = false;
            }
            
            if(GamePowerUp.hasLowerWallCollision())
                isActivated = false;
            repaint();
        }
    }
}