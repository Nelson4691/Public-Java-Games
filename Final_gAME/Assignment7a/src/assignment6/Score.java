package assignment6;


import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
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
public class Score extends JPanel {
    
   
    private JLabel touchDown;
    private JLabel missedAttemptScore;
    
    private int touchDownScore =0;
    private int missedAttempts =0;
    private Players footballPlayers;
    
    
    
    Score(){
        
    
    setBackground(Color.PINK);
    Scores();
    addLayout();
    //addSpecial();
    
    }
    
    public void addLayout(){
    
        GridLayout grid = new GridLayout (2,2);
        setLayout(grid);
    }
    
    //Displays all of the Score information
    public void Scores (){
       //Will keep track of players score
       touchDown = new JLabel();
       touchDown.setText("Touchdown :" + touchDownScore);
       //creating second JLabel
       missedAttemptScore = new JLabel();
       missedAttemptScore.setText("Missed Attempts :" + missedAttempts);
      
       
       add(missedAttemptScore);
       add(touchDown);
       
    }
    
    public void resetScore(){
        
         touchDownScore =0;
         missedAttempts =0;
        
    }
    
    public int getTouchdownScore(){
    
       return touchDownScore;
       
    }
    public int getmissedAttemotScore(){
        return missedAttempts;
    }
    
    public void AddMissedAttempt(){
        
        missedAttempts++;
        missedAttemptScore.setText("Missed Attempts :" + missedAttempts);
       
    
    }  
    public void addTouchDown(){
    
        touchDownScore++;
        touchDown.setText("Touchdown :" + touchDownScore);   
    }
    
    
}
