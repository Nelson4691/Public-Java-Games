/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment6;
import javax.swing.*;

/**
 *
 * @author nir5113
 */
public class MyJFrame extends JFrame  {
   
        MyJFrame(){
            super("Football Game");
            
            setVisible(true);
            setSize (1254,740);
            
            ControlPanel Game = new ControlPanel();
            add(Game);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setVisible(true);
            setResizable(false);
                
        }    
        
       
}
        
        

