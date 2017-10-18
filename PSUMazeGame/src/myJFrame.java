
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
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
public class myJFrame extends JFrame implements ActionListener
{
    myJPanel p1;
    
    public myJFrame()
    {
        super("PSU Maze Game"); 
        
         p1 = new myJPanel();
        
        
        getContentPane().add(p1,"Center");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1280,900);
        setVisible(true);
        p1.RTBT.addActionListener(this);
        
        
        
    }

   public void actionPerformed(ActionEvent e)
    {
        Object obj = e.getSource();
        
        if(obj == p1.RTBT)
        {
            remove(p1);
            
            p1 = new myJPanel();
         
            validate();
            repaint();
        
            getContentPane().add(p1,"Center");
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setSize(1280,900);
            setVisible(true);
        
        
       
        }
    }
}
