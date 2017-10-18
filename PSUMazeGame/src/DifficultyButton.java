
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nir5113
 */
public class DifficultyButton extends JPanel 
{
    JButton Dif1;
    JButton Dif2;
    JButton Dif3;
    
     public DifficultyButton()
     {
         super();
         setLayout(new GridLayout(3,1));
          Dif1 = new JButton("Easy");
          Dif2 = new JButton("Medium");
          Dif3 = new JButton("Hard");
         
         add(Dif1);
         add(Dif2);
         add(Dif3);
         
         
     
     }
             
     
   
}
