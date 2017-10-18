
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rmk5333
 */
public class gamePanel extends JPanel implements ActionListener
{
    DifficultyButton a;
    myJPanel c;
    int diff =0;
    optionPanel b;
    String st;
    String st1;
    JButton jb1 = new JButton("Start Game");
    JLabel jl;
    int delay = 0;
    Timer tim;
    int i = 0;
    JButton timStart = new JButton("Time: ");
    JButton finish = new JButton("Finish");
    Rectangle r1 = new Rectangle(1075,575,100,60);
    
    
   
    
    

    public gamePanel(DifficultyButton x, optionPanel y, myJPanel z)
    {
        super();
        a = x;
        b = y;
        c = z;
        setLayout(new GridLayout(2,1));

       
        delay = 1000;
        tim = new Timer(delay, this);
        

    }
  
     @Override
    public void actionPerformed(ActionEvent e)
    {
        Object obj = e.getSource();
       
       
        if (obj == tim)
        {
            i = i+1;
            timStart.setText("Time:  "+i);
        }
       if(diff==0)
        {
            
            if (i >= 30)
            {
            
                tim.stop();
                
                int text_response = (int)JOptionPane.showConfirmDialog(null,
                        "You have lost! Please exit out of the game to play again.",
                        "You have run out of time!",JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE);
                XmlWrite xlw = new XmlWrite(c,this);
                
            }
        }
        if(diff==1)
        {
            if(i>=30)
            {
                tim.stop();
                
                int text_response = (int)JOptionPane.showConfirmDialog(null,
                        "You have lost! Please exit out of the game to play again.",
                        "You have run out of time!",JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE);
                XmlWrite xlw = new XmlWrite(c,this);
            }
        }
        if(diff==2)
        {
            if(i>=40)
            {
                tim.stop();
                
                int text_response = (int)JOptionPane.showConfirmDialog(null,
                        "You have lost! Please exit out of the game to play again.",
                        "You have run out of time!",JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE);
                XmlWrite xlw = new XmlWrite(c,this);
            }
        }
    }
    String GameLoc()
    { 
       
        return st;
    }
    String GameDif()
    {
        return st1;
    }
  
    
   
}
