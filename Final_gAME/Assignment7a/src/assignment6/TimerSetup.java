/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author nelson
 */
public class TimerSetup extends JPanel{
    
    private Timer tim;
    private int delay = 1000;
    private int Count;
    private JSlider js1;
    
    //Timer for the game
    private int counterTimer = 60;
    private JLabel timeLeft;
    private int countSeconds =0;
    
    //Class Variable 
    private Players FootballPlayers;
    private Score Scores;
    private Buttons Buttons;
    
        TimerSetup(Players FootBallP, Score myScore ){
            Scores = myScore;            
            FootballPlayers = FootBallP;
            
            
            
            addTimer(); //Method includes the Action Performed
            addJSlider();
            addTimeTracker();
            myScore.add(js1);
        
        }
    public void resetTimer(){
        counterTimer =60;
    }
        //
    public void startTimer(){
    
        tim.start();
        
    }
    public void stopTimer(){ 
        tim.stop();
    }
    public void setButtons(Buttons Button){
        Buttons = Button;
    }
    public void stopGame(){
    
        if (counterTimer == 0){
            tim.stop();
            resetTimer();
            Buttons.addGameOverButton();
            FootballPlayers.setFocusable(false);
            Buttons.addNewGameButton();
            Buttons.addGameOverMessege();
            Buttons.addActionListeners();
            
            
            
        } 
    }
    
    public void addTimeTracker(){
        timeLeft = new JLabel("Time Left:" + counterTimer);
        Scores.add(timeLeft);
    }
    
    public void addTimer(){
        
        tim = new Timer (delay, new ActionListener(){
                public void actionPerformed(ActionEvent ae) {
                    Object obj = ae.getSource();
                    
                    if (obj == tim){   
                        FootballPlayers.GenerateRandomPosition(); //Each second generates random position
                        FootballPlayers.changePlayercolor();      //Checks if player color needs to change (powerup)
                        FootballPlayers.updateSeconds();
                        countSeconds++;
                        counterTimer = counterTimer - 1;
                        timeLeft.setText("Time Left:" + counterTimer);
                        stopGame();
                        
                        
                        
                        
                       
                    }   
                }
            });
            
    
    }   
    //changes the delay variable by communicating the information to the scores class
    public void setSpeed(int speed){
        tim.setDelay(speed);
    }
    
    //Method returns the number of seconds the game has running
    public int getSeconds(){
         return countSeconds;
    }
    
    public void addJSlider(){
       js1 = new JSlider(JSlider.HORIZONTAL,0,10,0);
	    js1.setBorder(BorderFactory.createTitledBorder("Speed"));
            js1.setMajorTickSpacing(1);
            js1.setPaintTicks(true);
            js1.setPaintLabels(true);
            js1.addChangeListener( new ChangeListener(){
                public void stateChanged(ChangeEvent ce) {
                        Object obj = ce.getSource();
                        if(obj == js1)
                            {
                                //get value of js1 and converts it into count
                                Count = js1.getValue();
                                changeSpeed();   
                            }
                }
            
            }); 
            setFocusable(true);
    }
    
    /* This method is recieves the value from the jslider using the change listener
    Located in the addJSlider method which has the mathod changeSpeed*/
    public void changeSpeed(){
    
        if (Count ==1){
            setSpeed(900);
        
        }
        else if (Count ==2){
            setSpeed(800);
        
        }
        else if (Count ==3){
            setSpeed(700);
        
        }
        else if (Count ==4){
            setSpeed(600);
        
        }
        else if (Count ==5){
            setSpeed(500);
        
        }
        else if (Count ==6){
            setSpeed(400);
        
        }
        else if (Count ==7){
           setSpeed(300);
        
        }
        else if (Count ==8){
           setSpeed(300);
        
        }
        else if (Count ==9){
           setSpeed(300);
        
        }
        else if (Count ==10){
           setSpeed(300);
        
        }
    }          
}
    

   
    
    
    