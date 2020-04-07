package pong;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CreditsFrame extends JFrame
{
    JLabel Moussa = new JLabel("Moussa Mohsen - 15P4011");
    JLabel Marina = new JLabel("Marina Gamal - 15P6047");
    JLabel Mohammed = new JLabel("Mohammed Said - 15P6048");
    JLabel Aly = new JLabel("Aly Mohamed - 15P5072");
    JLabel Lbl1 = new JLabel("Created by: ");
    JLabel Lbl2 = new JLabel ("Submitted to: ");
    JLabel Lbl3 = new JLabel ("Dr.Cherif Salama.");
    private CreditsPanel BackgroundPanel = new CreditsPanel();
    private JLabel back = new JLabel();
    private ImageIcon backImage = new ImageIcon("button_back.png");
    private ImageIcon backImageHighLighted = new ImageIcon("button_back-highlighted.png");



    public CreditsFrame()
    {
        init();    
    }

    public void init()
    {
        back.setIcon(backImage);
        Container c = getContentPane();
        c.add(BackgroundPanel);
        BackgroundPanel.setLayout(null);
        BackgroundPanel.add(Lbl1);
        BackgroundPanel.add(Aly);
        BackgroundPanel.add(Marina);
        BackgroundPanel.add(Mohammed);
        BackgroundPanel.add(Moussa);
        BackgroundPanel.add(Lbl2);
        BackgroundPanel.add(Lbl3);
        BackgroundPanel.add(back);
        back.addMouseListener(new BackButton());

        
        Lbl1.setBounds(10,10,400,50);
        Aly.setBounds(10,80,600,50);
        Marina.setBounds(10,150,600,50);
        Mohammed.setBounds(10,220,600,50);
        Moussa.setBounds(10,290,600,50);
        Lbl2.setBounds(10,360,600,50);
        Lbl3.setBounds(10,430,600,50);
        back.setBounds(500,510,100,100);
        
        Moussa.setFont(new Font("Copperplate Gothic Bold" ,Font.BOLD , 38));
        Marina.setFont(new Font("Copperplate Gothic Bold" ,Font.BOLD , 38));
        Mohammed.setFont(new Font("Copperplate Gothic Bold" ,Font.BOLD , 38));
        Aly.setFont(new Font("Copperplate Gothic Bold" ,Font.BOLD , 38));
        Lbl1.setFont(new Font("Copperplate Gothic Bold" ,Font.BOLD , 38));
        Lbl2.setFont(new Font("Copperplate Gothic Bold" ,Font.BOLD , 38));
        Lbl3.setFont(new Font("Copperplate Gothic Bold" ,Font.BOLD , 38));
        
        Moussa.setForeground(Color.blue);
        Marina.setForeground(Color.pink);
        Mohammed.setForeground(Color.orange);
        Aly.setForeground(Color.green);
        Lbl1.setForeground(Color.white);
        Lbl2.setForeground(Color.white);
        Lbl3.setForeground(Color.cyan);
        
        setTitle("Pong Ping");
        setLocation(358,0);
        setSize(Constants.FRAME_W , Constants.FRAME_H);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true); 
    }
    
    class BackButton extends MouseAdapter
    {
        public void mouseClicked(MouseEvent e)
        {
            new StartFrame() ;
            setVisible(false);
        }
        
        public void mouseEntered(MouseEvent e)
        {
           back.setIcon(backImageHighLighted);
        }
        
        public void mouseExited(MouseEvent e)
        {
            back.setIcon(backImage);
        }
    }
}