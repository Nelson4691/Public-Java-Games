
import javax.swing.JLabel;
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
public class MyJpanelInstruction extends JPanel  
{
    JLabel J2;
    JLabel J1;
    JLabel J3;
    JLabel J4;
    JLabel J5;
    public MyJpanelInstruction ()
 {
     super();
    
     J1 = new JLabel("Instructions: ");
     J2 = new JLabel("Complete the maze before time runs out!  If you have chosen level Easy, you will have 30 seconds to complete the maze.");
    J3 = new JLabel("If you have chose level Medium you will have 30 seconds to complete the maze."); 
    J4 = new JLabel("Finally, if you have chosen level Hard you will have 40 seconds to complete the maze.");
    J5 = new JLabel("The lower the score the better you did! Good luck and have fun!");
    add(J1);
    add(J2);
    add(J3);
    add(J4);
    add(J5);
    
    
     
     
    
}
    
}
