package pong;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
  
public class GameFrame extends JFrame 
{
    private Container c;
    protected static Bar GameBar;
    protected static ArrayList <Ball> GameBalls;
    protected static Bricks GameBricks;
    protected static PowerUps GamePowerUps;
    protected static GamePanel GamePanel;
    protected static ImageIcon LifeImage;
    protected static JPanel LabelPanel;
    protected static JLabel ScoreLabel;
    protected static JLabel LevelLabel;
    protected static JLabel LifeLabel;
    protected static ArrayList<JLabel> LifeIcons;
    protected static int Score;
    protected static int Level;
    protected static int Life;
    
    public GameFrame(){init();}
    
    public void init()
    {
        GameBar = new Bar();
        GameBalls = new ArrayList<Ball>();
        GameBalls.add(new Ball ());
        GameBricks = new Bricks();
        GamePanel = new GamePanel(GameBar,GameBalls,GameBricks);
        LifeImage = new ImageIcon("life.png");
        LabelPanel = new JPanel();
        ScoreLabel = new JLabel("Score: ");
        LevelLabel = new JLabel("Level: ");
        LifeLabel = new JLabel("Lives: ");
        LifeIcons = new ArrayList<JLabel>();
        Score = 0;
        Level = 1;
        Life = 3;
        c = getContentPane();
        c.add(LabelPanel , BorderLayout.SOUTH);
        c.add(GamePanel);
           
        LabelPanel.setLayout(new FlowLayout());
        LabelPanel.add(ScoreLabel);
        LabelPanel.add(LevelLabel);
        LabelPanel.add(LifeLabel);
        LabelPanel.setBackground(Color.BLACK);
        
        ScoreLabel.setFont(new Font("Mistral" ,Font.BOLD , 22));
        ScoreLabel.setForeground(Color.WHITE);
        ScoreLabel.setText("Score: "+Score);
        ScoreLabel.setPreferredSize(new Dimension(150,30));
        
        LevelLabel.setFont(new Font("Mistral" ,Font.BOLD , 22));
        LevelLabel.setForeground(Color.WHITE);
        LevelLabel.setText("Level: "+Level);
        LevelLabel.setPreferredSize(new Dimension(150,30));
        
        LifeLabel.setFont(new Font("Mistral" ,Font.BOLD , 22));
        LifeLabel.setForeground(Color.WHITE);
        LifeLabel.setText("Life:");
        LifeLabel.setPreferredSize(new Dimension(50,30));
        
        for(int i=0 ; i < Life ; i++)
        {
           JLabel l = new JLabel();
           l.setIcon(LifeImage);
           LifeIcons.add(l);
           LabelPanel.add(l);
        }

        setTitle("Pong Ping");
        setLocation(358,0);
        pack();
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);  
    }
    
    public static void RemoveLife(boolean isPowerUp)
    {
        Life--;
        JLabel l = LifeIcons.get(LifeIcons.size()-1);
        LabelPanel.remove(l);
        LifeIcons.remove(LifeIcons.size()-1);
        LabelPanel.repaint();

        if(LifeIcons.isEmpty())
        {
            GamePanel.BallTimer.stop();
            GamePanel.PowerUpTimerShow.stop();
            GamePanel.PowerUpTimerMove.stop();
            new GameOverFrame(GamePanel);
        }
        
        else if(!isPowerUp)
        {
            GameBar.reset();
            GameBalls.get(0).reset();
            GamePanel.BallTimer.stop();
            GamePanel.PowerUpTimerShow.stop();
            GamePanel.PowerUpTimerMove.stop();
            //GamePanel.repaint();
        }

    }
    
    public static void IncreaseScore()
    {
        Score = Score + 100;
        ScoreLabel.setText("Score: "+Score);
    }
    
    public static void IncreaseLevel()
    {
        if(Level == 10)
        {
            JOptionPane.showMessageDialog(GamePanel, "WOW YOU ARE TOO GOOD MAN!!! ");    
        }
        
        Level = Level + 1;
        LevelLabel.setText("Level: "+Level);
        GameBar.DecreaseSize(20);
        int NewX = GameBar.getWidth()/2 + GameBar.getX();
        if(GameBalls.size()>1)
            for(int i=1; i<GameBalls.size();i++)
                GameBalls.remove(i);
        GameBalls.get(0).setX(NewX);
        GameBalls.get(0).setY(Constants.BALL_INITIAL_Y);
        Constants.BALL_dx+=1;
        Constants.BALL_dy+=1;
    }
    
     public static void AddLife()
    {
        Life++;
        JLabel l = new JLabel();
        l.setIcon(LifeImage);
        LifeIcons.add(l);
        LabelPanel.add(l);
        LabelPanel.repaint();
        LabelPanel.validate();
    }   
}