package pong;
import com.sun.corba.se.impl.orbutil.ObjectWriter;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class SaveScoreFrame extends JFrame 
{ 
    private JButton btnsave ; 
    private JTextField txtscore ; 
    private JLabel lblscore ; 
    private int highscore = 0 ; 
    private String fileloc ; 
    private String filename = "scores" ; 
    private String HS = " " ; 
    private GamePanel f;
    
//    protected  String name = txtscore.getText();
    
    public SaveScoreFrame(GamePanel f) 
    {
        init();
        this.f = f;
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
        this.setLocation(520, 325);
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
                JFrame f1 =(JFrame) SwingUtilities.getWindowAncestor(f);
                f1.setVisible(false);
                FileWriter FW = null;
                
                BufferedWriter BW = null;
                
        
              
                 try {
          File FF1 = new File("yo.txt");
         
           if (!FF1.exists()) 
          {
	     FF1.createNewFile();
	  }
            FW = new FileWriter("yoo.txt",true);
            BW = new BufferedWriter(FW);
//            BW.append();
           
           HS =txtscore.getText()+":"+GameFrame.Score+"\n"  ; 
            BW.write(HS);
            BW.flush();
            
            BW.close();
          // fos.close();
           
           
        } 
        
        catch (IOException ex) {
           // Logger.getLogger(Sheet8_no1.class.getName()).log(Level.SEVERE, null, ex);
        }
                 finally {
            try {
                    FW.close();
                    BW.close();
                
                    
            } catch (IOException ex) {

            }
                 }
            new StartFrame() ; 
            setVisible(false); 

            }
        
             
        } ) ;
        
                }
}
   /*  public void createFile ()
    {
        try
        {
            File file = new File(fileloc,filename);
            FileWriter output = new FileWriter(file) ; 
            BufferedWriter writer = new BufferedWriter(output);
            writer.write("" +0);
        writer.close();
        }
        catch(Exception e)
        {e.printStackTrace();}
        
    }
    public void loadscore()
    {
         try
        {
            File f = new File(fileloc,filename);
         //  if(!f.isFile())
           //{createFile();}
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f))) ; 
        highscore = Integer.parseInt(reader.readLine()) ; 
        reader.close();
        }
        catch(Exception e)
        {e.printStackTrace();}
        
    }
    public void setscore()
    {
        FileWriter output = null ; 
        try
        {
            String name = txtscore.getText() ;
            highscore = GameFrame.Score ; 
            File f = new File(fileloc,filename);
           output = new FileWriter(f);
           BufferedWriter writer = new BufferedWriter(output);
               writer.write( GameFrame.Score );
        
        }
        catch(Exception e)
        {e.printStackTrace();}
        
        
    }*/
            
            
        

