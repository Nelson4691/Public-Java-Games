
import java.awt.*;
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
public class optionPanel extends JPanel
{
    JButton b1;
    JButton b2;
    JButton b3;
    public optionPanel()
    {
        super();
        
        setLayout(new GridLayout(3,1));
        b1 = new JButton("To Class");
        b2 = new JButton("To Football Game");
        b3 = new JButton("To Dorm");
        add(b1);
        add(b2);
        add(b3);
    }  

 
    }
    

