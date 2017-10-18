
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
public class myJPanel1 extends JPanel
{
    
    public myJPanel1()
    {
        super();
       
        
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Image myImage = Toolkit.getDefaultToolkit().getImage("images/PSU_MazeRunner_IMAGE.jpg");
        g.drawImage(myImage,0,0,this);
      
        
        
        
    }
    
}
