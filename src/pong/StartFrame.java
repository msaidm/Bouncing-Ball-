package pong;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StartFrame extends JFrame
{
    private GameFrame f1;
    private CreditsFrame f2;
    private HOFframe f3;
    private JLabel StartLabel = new JLabel();
    private JLabel QuitLabel = new JLabel();
    private JLabel CreditsLabel = new JLabel();
    private JLabel HOFLabel = new JLabel();
    private ImageIcon StartImage = new ImageIcon("button_start-game.png");
    private ImageIcon CreditsImage = new ImageIcon("button_credits.png");
    private ImageIcon QuitImage = new ImageIcon("button_quit.png");
    private ImageIcon HOFImage = new ImageIcon("button_hall-of-fame.png");
    private ImageIcon StartImageHL = new ImageIcon("button_start-game-highlighted.png");
    private ImageIcon CreditsImageHL = new ImageIcon("button_credits-highlighted.png");
    private ImageIcon QuitImageHL = new ImageIcon("button_quit-highlighted.png");
    private ImageIcon HOFImageHL = new ImageIcon("button_hall-of-fame-highlighted.png");
    private StartPanel BackgroundPanel = new StartPanel();
    
    
    public StartFrame()
    {
        init();
    }
    
    public void init()
    {
        Container c = getContentPane();
        BackgroundPanel.setLayout(null);
        StartLabel.setBounds(193,160,265,82);
        HOFLabel.setBounds(197,247,257,82);
        CreditsLabel.setBounds(233,334,185,82);
        QuitLabel.setBounds(261,421,128,82);
        
        StartLabel.setIcon(StartImage);
        HOFLabel.setIcon(HOFImage);
        QuitLabel.setIcon(QuitImage);
        CreditsLabel.setIcon(CreditsImage);
        
        BackgroundPanel.add(StartLabel);
        BackgroundPanel.add(HOFLabel);
        BackgroundPanel.add(CreditsLabel);
        BackgroundPanel.add(QuitLabel);
        c.add(BackgroundPanel);
        StartLabel.addMouseListener(new StartButton());
        QuitLabel.addMouseListener(new QuitButton());
        HOFLabel.addMouseListener(new HOFButton());
        CreditsLabel.addMouseListener(new CreditsButton());
        
     
        setTitle("Pong Ping");
        setLocation(358,0);
        setSize(Constants.FRAME_W , Constants.FRAME_H);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);  
    }
    
    class QuitButton extends MouseAdapter
    {
        public void mouseClicked(MouseEvent e)
        {
            System.exit(0);
        }
        
        public void mouseEntered(MouseEvent e)
        {
            QuitLabel.setIcon(QuitImageHL);
        }
        
        public void mouseExited(MouseEvent e)
        {
            QuitLabel.setIcon(QuitImage);
        }
    }
    
    class StartButton extends MouseAdapter
    {
        public void mouseClicked(MouseEvent e)
        {
            f1 = new GameFrame();
            setVisible(false);
        }
        
        public void mouseEntered(MouseEvent e)
        {
           StartLabel.setIcon(StartImageHL);
        }
        
        public void mouseExited(MouseEvent e)
        {
            StartLabel.setIcon(StartImage);
        }
    }
        
    class HOFButton extends MouseAdapter
    {
        public void mouseClicked(MouseEvent e)
        {
            f3 = new HOFframe();
            setVisible(false);
        }
        
        public void mouseEntered(MouseEvent e)
        {
           HOFLabel.setIcon(HOFImageHL);
        }
        
        public void mouseExited(MouseEvent e)
        {
            HOFLabel.setIcon(HOFImage);
        }
    }
    
    class CreditsButton extends MouseAdapter
    {
        public void mouseClicked(MouseEvent e)
        {
            f2 = new CreditsFrame();
            setVisible(false);
        }
        
        public void mouseEntered(MouseEvent e)
        {
           CreditsLabel.setIcon(CreditsImageHL);
        }
        
        public void mouseExited(MouseEvent e)
        {
            CreditsLabel.setIcon(CreditsImage);
        }
    }     
}