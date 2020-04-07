package pong;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameOverFrame extends JFrame
{
    private JButton Save = new JButton("Save score and exit");
    private JLabel lbl = new JLabel("                You lost :(");
    private JPanel South = new JPanel(new FlowLayout());
    private JButton Exit = new JButton("Exit");
    private JButton PlayAgain = new JButton("Play again");
    private GamePanel f;
    
    public GameOverFrame(GamePanel f)
    {
       init() ;
       this.f = f;
    }
    
    public void init()
    {
        
        Container c = this.getContentPane() ; 
        this.setVisible(true);
        
        this.setLocation(520, 325);
        this.setResizable(false);
        this.setPreferredSize(new Dimension(400,100)) ;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 


        c.add(lbl, BorderLayout.CENTER) ; 
        South.add(PlayAgain);
        South.add(Save);
        South.add(Exit);
        c.add(South,BorderLayout.SOUTH);
        pack() ; 
        Exit.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                new StartFrame();
                setVisible(false);
                JFrame f1 =(JFrame) SwingUtilities.getWindowAncestor(f);
                f1.setVisible(false);
            }
        });

        PlayAgain.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                new GameFrame();
                JFrame f1 =(JFrame) SwingUtilities.getWindowAncestor(f);
                f1.setVisible(false);
                setVisible(false);
            }
        });
        
        Save.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                new SaveScoreFrame(f);
                JFrame f1 =(JFrame) SwingUtilities.getWindowAncestor(f);
                setVisible(false);
            }
        });
    }
}
