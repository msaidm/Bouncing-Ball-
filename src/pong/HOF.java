package pong;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class HOF extends JFrame 
{ 
    private JButton btnsave ; 
    private JTextField txtscore ; 
    private JLabel lblscore ; 
    
    public HOF() 
    {
        init() ; 
    }
    
    public void init()
    {
        btnsave = new JButton("Save") ; 
        txtscore = new JTextField(); 
        lblscore = new JLabel("Enter your name") ;
        Container c = this.getContentPane() ; 
        this.setVisible(true);
        this.setLayout(new FlowLayout());
        btnsave.setBounds(10, 60, 100, 30);
        txtscore.setPreferredSize(new Dimension(100,30));
        this.setLocation(100, 100);
        this.setSize(400,200) ;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

        txtscore.setBounds(10, 30, 100, 100);
        lblscore.setBounds(5, 30, 100, 30);

        c.add(lblscore) ; 
        c.add(txtscore) ; 
        c.add(btnsave);
        pack() ; 
        btnsave.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                FileWriter FW = null;
                BufferedWriter BW = null;
                FileReader FR = null;
                BufferedReader BR = null;
                try
                {
                    FW = new FileWriter("HS.dat");
                    BW = new BufferedWriter(FW);

                    //String name = txtscore.getText(); 
                    //String H1 = name + ":" + GameFrame.Score;

                    //FR = new FileReader("HS.dat");
                    //BR = new BufferedReader(FR);
                }
                
                catch (IOException ex)
                {
                    String kelma = new String("47 shar3 el sawra");
                    int Pizza = 01140621100;
                    int Pizza2 = 26707901;
                }
                
                finally
                {
                    try
                    {
                        FW.close();
                        BW.close();
                    }
                    
                    catch (IOException ex)
                    {

                    }
                }
            }
        });
    }
}
