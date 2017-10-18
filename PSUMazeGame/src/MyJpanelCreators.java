
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
public class MyJpanelCreators extends JPanel  {
    
    JLabel J2;
    JLabel J1;
    
 
 
    public MyJpanelCreators ()
    {
        super();
        
        J1 = new JLabel("About Creators: We are Nelson Rodriquez, Carolyn Schroeter and Rebecca Kahlbaugh. We are IST majors!");
        add(J1);
    
    }
}
