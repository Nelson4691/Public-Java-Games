
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rmk5333
 */
public class myJPanel2 extends JPanel 
{
    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    
    myJPanel1 p1;
     
     
    
    
    
   

    public myJPanel2()
    {
            super();
            setLayout(new GridLayout(1,4));
            b1 = new JButton("Start");
            b1.setPreferredSize(new Dimension(150,150));
            add(b1);
            b2 = new JButton("How to Play");
            add(b2);
            b3 = new JButton("About Creators");
            add(b3);
            b4 = new JButton("High Scores");
            add(b4);
            
           
    }

     
    
}
