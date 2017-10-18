/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment6;

import java.awt.BorderLayout;
import javax.swing.JPanel;


/**
 *
 * @author nelson
 */
public class ControlPanel extends JPanel {
    
    private Players footballPlayers;
    private TimerSetup Timers;
    private Score Scores;
    private Buttons gameButtons;
    
    ControlPanel(){
        super();
    
     
     Scores = new Score();
     footballPlayers = new Players(Scores); 
     Timers = new TimerSetup(footballPlayers,Scores);
     gameButtons = new Buttons(footballPlayers,Timers,Scores);
     

     /* Sends the timer class to the footballplayer method which has the class variable Timer.
        This lets the player class communicate with the timer class. 
     */
     footballPlayers.setTimerclass(Timers);
     
     Timers.setButtons(gameButtons);
     // Sets the layout
     setLayout(new BorderLayout());
     add(Scores,"South");
     add(footballPlayers,"Center");
     
     
     
     
     
    }      
}

    

