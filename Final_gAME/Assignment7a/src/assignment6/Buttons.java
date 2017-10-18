/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment6;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author nelson
 */
public class Buttons extends JPanel {
    
   private JButton startButton;
   private JButton newGameButton;
   private JTextArea Instructions;
   private Players gamePanel;
   private TimerSetup Timer;
   private ImageIcon startButtonImage;
   private JButton gameOver;
   private JTextArea gameOverMessege;
   private Score ScoreInformation;
  
    
    Buttons(Players Play, TimerSetup Time, Score Scoreboard){
       gamePanel = Play;
       Timer = Time;
       ScoreInformation = Scoreboard;
        
        addStartButton();
        addActionListeners();
        addInstructions();
        
    }
    public void addGameOverButton(){
       gameOver = new JButton("Game Over!");
       gameOver.setBackground(Color.PINK);
       gameOver.setBounds(500,200,200,50);
       gamePanel.add(gameOver);
    }
    public void addInstructions(){
        Instructions = new JTextArea("You are a footballplayer and your goal to get as many touchdowns as you can! Just make sure\n you avoid tackles. "
              + "You have have a limited amount of time to actually get as many points as \n you can."+ " When player has a special in which it is activated when you press the W"
                + "  (Move up)\n,S (Move Down),D (Move Foward)."
                + "\n\n\n Now if you feel ready press the start button up there and make me proud! \n Hut HUT!");
        Instructions.setBounds(350,300,520,200);
        Instructions.setBackground(Color.PINK);
        gamePanel.add(Instructions);
        
        
    }
    public void removeGameOverMesseges(){
        gamePanel.remove(gameOverMessege);
        gamePanel.remove(gameOver);
        gamePanel.remove(newGameButton);
    
    }
    
    
    // This button is made to display after the game is over
    public void addNewGameButton(){
        newGameButton = new JButton("new Game");
        newGameButton.setBounds(500,440,200,50);
        gamePanel.add(newGameButton);
    }
    
    //Adds the game over messege after game is over
    public void addGameOverMessege(){
    
        
        
        gameOverMessege = new JTextArea ("Your made : " +  ScoreInformation.getTouchdownScore() + " Touchdowns\n" + " You made : " + ScoreInformation.getmissedAttemotScore() + " Missed attempts\n"
        + "\n\n If you want to retry press the new game Button");
        gameOverMessege.setBackground(Color.PINK);
        gameOverMessege.setBounds(350,300,520,200);
        
        gamePanel.add(gameOverMessege);
        
    
    }
    
    
    
    
    public void addStartButton(){
        
        
        startButton = new JButton("Start Game");
        startButton.setBounds(500,440,200,50);
        
        
        startButtonImage =new ImageIcon ("Images/start_button.png");
        startButton.setIcon(startButtonImage);
        gamePanel.add(startButton);
        
        
    }
    public void removeStartButton(){
    
        gamePanel.remove(startButton);
    }
    public void removeInstructions(){
        gamePanel.remove(Instructions);
    }
    
    public void addActionListeners(){
        //StartButton Action Listenr
         startButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Object obj = ae.getSource();
                Object obj2 = ae.getSource();
                if(obj == startButton){ 
                    Timer.startTimer();
                    removeStartButton();
                    gamePanel.addKeyyListener();
                    gamePanel.addMachinePlayers();
                    removeInstructions();
                    
                }
                if(obj2 == newGameButton){
                    removeGameOverMesseges();
                    addStartButton();
                    addInstructions();
                    addActionListeners();
                    gamePanel.resetPlayerPosition();
                    ScoreInformation.resetScore();
                    
                }
            
            }
        
        });
    
    }
    
        
        
   
    
    
    
    
     
    
    
    
    
    
    
    
}
