
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nelson
 */
public class MyScores extends JPanel  {
    
     JLabel J1;
     JLabel J2;
     gamePanel gp;
     myJPanel mp;
     XMLDecoder de;
     String name;
     int time;

    public MyScores( gamePanel game,myJPanel a  )
    {
     super();
     
     gp=game;
     mp=a;
     
     
     J1 = new JLabel("Scores For Maze game");
     J2 = new JLabel("???");
     add(J1);
     add(J2);
      
     }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Image myImage = Toolkit.getDefaultToolkit().getImage("images/PSU_MazeRunner_fadd.jpg");
        g.drawImage(myImage,0,0,this);
        //read xml
//read
                      try {
              de = new XMLDecoder(new BufferedInputStream(new FileInputStream("info.xml")));
             }
          catch(Exception xx) {xx.printStackTrace();}
          try {
			 name = (String)de.readObject();
			 time = (Integer)de.readObject();
			 
            }
          catch(Exception xx) {xx.printStackTrace();}
          try {
             de.close();
            }
          catch(Exception xx) {xx.printStackTrace();}

//==========         
      
        //update J1
        J2.setText("The low score is from " + name + " with score " + time);
        
        
      
        
        
        
    }
        
     
    
}
