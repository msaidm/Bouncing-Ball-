/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pong;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

import javax.swing.JFrame;
public class HOFframe extends JFrame
{
    ArrayList<JLabel> lbl1 =new ArrayList<JLabel>(12) ;
     private JLabel back = new JLabel();
    private ImageIcon backImage = new ImageIcon("button_back.png");
    private ImageIcon backImageHighLighted = new ImageIcon("button_back-highlighted.png");

   
    private CreditsPanel BackgroundPanel = new CreditsPanel();
   


    public HOFframe()
    {
        init();    
    }

    public void init()
    {
         back.setIcon(backImage);
         back.addMouseListener(new HOFframe.BackButton());
         
        Container c = getContentPane();
        FileReader FR = null;
        BufferedReader BR = null;
        String HighScoreName = "NAN";
        int HighScoreNumber = -1;
        //String check = "" ;
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        try {
          //int i = 1 ; 
           
          FR = new FileReader("yoo.txt");
            BR = new BufferedReader(FR);
           int flag = 0 ; 
           do{
                if (flag == 1)
                    BR.reset();
                
                String  check = BR.readLine();
                
           if(Integer.parseInt(check.split(":")[1]) > HighScoreNumber)
               {
                 HighScoreNumber = Integer.parseInt(check.split(":")[1]);
                  HighScoreName = check.split(":")[0];
               }
                
                
               
                        lbl1.add(new JLabel(check));
                    
                //if(i < lbl1.length)
                    //i++;

                BR.mark(1);
                flag = 1;

            }

                    while(BR.readLine()!=null);
                Collections.sort(lbl1, new Comparator<JLabel>(){
               public int compare(JLabel l1 , JLabel l2)
               {
                   if(Integer.parseInt(l1.getText().split(":")[1]) < Integer.parseInt(l2.getText().split(":")[1]))
                       return 1;
                   
                   else if(Integer.parseInt(l1.getText().split(":")[1]) > Integer.parseInt(l2.getText().split(":")[1]))
                        return -1;
                   
                   else 
                       return 0;
               }
           });
//                for(int i=0 ; i < lbl1.size()-1;i++)
//                {
//                    for(int j=lbl1.size()-1; j >= 0;j--)
//                        if(Integer.parseInt(lbl1.get(i).getText().split(":")[1]) < Integer.parseInt(lbl1.get(j).getText().split(":")[1]))
//                        {
//                            System.out.println(lbl1.get(i).getText().split(":")[1]);
//                            System.out.println(lbl1.get(j).getText().split(":")[1]);
//                            JLabel temp = lbl1.get(i);
//                            lbl1.add(i,lbl1.get(j));
//                            lbl1.add(j,temp);
//                        }
//                }
           
                    
           
        }
        catch(IOException ex){
            System.out.println(ex);            
        }
        finally {
            try {
                   
                    FR.close();
                    BR.close();
            } catch (IOException ex) {

            }
        }
        
        c.add(BackgroundPanel);
        BackgroundPanel.setLayout(new GridLayout(11,2));
       
       back.setBounds(500,510,100,100);
       
        
              
for(int i = 0 ; i < lbl1.size() ;i++)
{
    
     BackgroundPanel.add(lbl1.get(i));
       lbl1.get(i).setBounds(10,20,500,100);
     lbl1.get(i).setFont(new Font("Copperplate Gothic Bold" ,Font.BOLD , 38));
        
        lbl1.get(i).setForeground(Color.WHITE);
}

//BackgroundPanel.add(lbl1[6]);
//       lbl1[6].setBounds(10,20,500,100);
//     lbl1[6].setFont(new Font("Copperplate Gothic Bold" ,Font.BOLD , 38));
//        
//        lbl1[6].setForeground(Color.blue);
                BackgroundPanel.add(back);

        setTitle("Hall Of Fame");
        setLocation(358,0);
        setSize(Constants.FRAME_W , Constants.FRAME_H);
        setResizable(true);
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