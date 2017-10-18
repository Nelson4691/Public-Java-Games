/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment6;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author nelson
 */
public class Players extends JPanel  {
    //Button and image variables
     private ImageIcon playerImage;
     private ImageIcon playerPowerImage;
     private JButton footBallPlayer;
     private JButton goalButton;
     
     
     //Arraylist for walls and players //
     private ArrayList<JButton> walls = new ArrayList();
     private ArrayList<JButton> machinePlayers = new ArrayList();
     //The set of rectangles
     private Rectangle [] machineplayerRectangles  = new Rectangle [4];
     private Rectangle [] wallsRectangles = new Rectangle [4];
     private Rectangle playerRectangle;
     private Rectangle goalRectangle;
     
     private int checkSeconds =0; //Variable used to check to see if special move is available for use
     //Class variables
     private Score ScoreBoard;
     private TimerSetup Timers;
     
     
     //Penn State Football Player start postition
     private int x =50; 
     private int y = 300;
    
        Players(Score Scr){
            ScoreBoard = Scr; 
            
              
              setLayout(null); 
              setBackground(Color.BLACK);
              addmovablePlayer();
              addGoalButton(); 
              addWalls();
              //addKeyyListener();
              
              
              
              
        }
    // This method sends the TimerSetup class from the controlpanel to the   
    // class variable Timer 
    public void setTimerclass(TimerSetup tim){
        Timers = tim;
    }
        
    public void changePlayercolor(){
        if (checkSeconds == 0){
        
            footBallPlayer.setIcon(playerPowerImage);
        } 
        else
        {
            footBallPlayer.setIcon(playerImage);
        }
    }
    
    
    public void updateSeconds(){
        checkSeconds = Timers.getSeconds() % 5;
    }
    public void resetPlayerPosition(){
        x =50;
        y = 300; 
    }
    
    //Key Listener is activated once the start button is clicked in the Buttons class
    public void addKeyyListener(){
        
        setFocusable(true);
        //add listeners 
        addKeyListener(new KeyAdapter(){
       
            public void keyPressed(KeyEvent evt){ 
                
                /* This gets the seconds from timers and uses modulus 5, so
                   So that it can be used for the special moves (every 5 seconds the        
                   move is available for use).*/
                
                int kk = evt.getKeyCode(); 
                if(kk ==  evt.VK_LEFT) {x=x-5;} 
                if(kk ==  evt.VK_RIGHT) {x=x+5;} 
                if(kk ==  evt.VK_UP) {y=y-5;} 
                if(kk ==  evt.VK_DOWN) {y=y+5;} 
   
                //Special Moves is active as long as checkSeconds is 0 (every 5 seconds)
                if(kk ==  evt.VK_D) {
                    if (checkSeconds == 0){
                        changePlayercolor();
                        x=x+15;}
                  }
                if(kk ==  evt.VK_S) {
                    if (checkSeconds == 0){
                        changePlayercolor();
                        y=y+15;} 
                  }
                
                if(kk ==  evt.VK_W) {
                    if (checkSeconds == 0){
                        changePlayercolor();
                         y=y-15;
                  }
                }
   
   
   
               footBallPlayer.setBounds(new Rectangle(x,y,50,50)); 

               //Each time the keyboard is pressed
               // adds position of player to the player rectangle
               // adds the position of machine 1 to machine rectangle
               playerRectangle = footBallPlayer.getBounds();
               machineplayerRectangles[0] = (machinePlayers.get(0).getBounds());
               machineplayerRectangles[1] = (machinePlayers.get(1).getBounds());
               machineplayerRectangles[2] = (machinePlayers.get(2).getBounds());
               machineplayerRectangles[3] = (machinePlayers.get(3).getBounds());


                   //if player intersects machine player
               if (playerRectangle.intersects(machineplayerRectangles[0]) || playerRectangle.intersects(machineplayerRectangles[1]) || playerRectangle.intersects(machineplayerRectangles[2])){       //resets the position of player
                        //Resets Players position
                        resetPlayerPosition();
                        footBallPlayer.setBounds(x, y, 50, 50);

                        //It adds a missed attemp if playes intersect from the method in Score
                        ScoreBoard.AddMissedAttempt();      
                  }



               if (playerRectangle.intersects(goalRectangle)){
                        //Resets the position of player
                        resetPlayerPosition();
                        footBallPlayer.setBounds(x, y, 50, 50);

                        //It adds a point to Touchdown from the method in Score
                        ScoreBoard.addTouchDown();
               }
               
                    //If player intersects the wall.
               if (playerRectangle.intersects(wallsRectangles[0]) || playerRectangle.intersects(wallsRectangles[1])|| 
                   playerRectangle.intersects(wallsRectangles[2]) || playerRectangle.intersects(wallsRectangles[3])){
                      
                    if(kk ==  evt.VK_LEFT) {x=x+5;} 
                    if(kk ==  evt.VK_RIGHT) {x=x-5;} 
                    if(kk ==  evt.VK_UP) {y=y+5;} 
                    if(kk ==  evt.VK_DOWN) {y=y-5;} 
               
               
               }
            }
              
                      
        });
    }
      
    //This method creates the football player
    public void addmovablePlayer(){
         //Assigns image to variable Player Image
        playerImage = new ImageIcon("Images/footballPlayer.jpg");
        playerPowerImage = new ImageIcon("Images/footballPlayerblue.png");
        //FootballPlayer button is added
        footBallPlayer = new JButton();  
        add(footBallPlayer); 
        footBallPlayer.setIcon(playerImage);
        footBallPlayer.setOpaque(true);
        footBallPlayer.setBounds(new Rectangle(x, y, 50, 50));
        
         
        
    }
   public void addMachinePlayers(){
        
        // Bot 1
        machinePlayers.add(new JButton("B1"));
        //machinePlayers.get(0).setIcon(playerImage);
        machinePlayers.get(0).setBounds(600,300,50,50);
        add(machinePlayers.get(0));
        // Bot 2
        
        machinePlayers.add(new JButton("B2"));
        //machinePlayers.get(1).setIcon(playerImage);
        machinePlayers.get(1).setBounds(600,400,50,50);
        add(machinePlayers.get(1));
        
        //Bot 3 
        
        machinePlayers.add(new JButton("B3"));
        //machinePlayers.get(0).setIcon(playerImage);
        machinePlayers.get(2).setBounds(800,300,50,50);
        add(machinePlayers.get(2));
        
        //Bot 4
        
        machinePlayers.add(new JButton("B4"));
        //machinePlayers.get(0).setIcon(playerImage);
        machinePlayers.get(3).setBounds(400,300,50,50);
        add(machinePlayers.get(3));
        
        
    }
   //This method is meant to include the boundy walls 
   public void addWalls()
   {
       //This will include the top of the wall
       walls.add(new JButton());
       walls.get(0).setBounds(30,5,1150,30);
       add(walls.get(0));
       //This will include the left part of the wall
       walls.add(new JButton());
       walls.get(1).setBounds(5,5,30,800);
       add(walls.get(1));
       //This will Be the right wall
       walls.add(new JButton());
       walls.get(2).setBounds(1180,5,30,800);
       add(walls.get(2));
       //This is the bottom wall
       walls.add(new JButton());
       walls.get(3).setBounds(30,555,1150,30);
       add(walls.get(3));
       
       //Makes all the walls invisible
      for( int i = 0 ; i < 4; i++){
      walls.get(i).setVisible(false);
      }
      
      // all the walls get converted to rectangles
      wallsRectangles[0] = (walls.get(0).getBounds()); 
      wallsRectangles[1] = (walls.get(1).getBounds());
      wallsRectangles[2] = (walls.get(2).getBounds());
      wallsRectangles[3] = (walls.get(3).getBounds());
       
      
       
   }
   
   // This method is being tested in consideration of the walls that will bounce any player or machine back inside the game if they intersect
//   public void checkIntersection(){
//       if(wallsRectangles[0].intersects(machineplayerRectangles[0])|| wallsRectangles[1].intersects(machineplayerRectangles[1])|| wallsRectangles[2].intersects(machineplayerRectangles[2])|| wallsRectangles[3].intersects(machineplayerRectangles[3])){
//          wallsRectangles[0].setBounds(wallsRectangles[0].getX(),wallsRectangles[0].getY(),50,50);
//        }
//   
// }
    
   /*This method is meant to generate a random postion for the
     machine players it is typically activate in the Timersetup class under the add timer method
   */
   public void GenerateRandomPosition(){
       
       double r = Math.random();
       double r1= Math.random();
       double r2= Math.random();
       double r3= Math.random();
       double r4= Math.random();
       double r5= Math.random();
       double r6= Math.random();
       double r7= Math.random();
       
       
      
       int randomNumber1 = (int) (r*1000);
       int randomNumber2 = (int) (r1*600);
       int randomNumber3 = (int) (r2*1000);
       int randomNumber4 = (int) (r3*600);
       int randomNumber5 = (int) (r4*1000);
       int randomNumber6 = (int) (r5*600);
       int randomNumber7 = (int) (r6*1000);
       int randomNumber8 = (int) (r7*600);
       
       
       
    //Sets the machine player position to a random location
       machinePlayers.get(0).setBounds(randomNumber1,randomNumber2,50,50);
       machinePlayers.get(1).setBounds(randomNumber3,randomNumber4,50,50);
       machinePlayers.get(2).setBounds(randomNumber5,randomNumber6,50,50);
       machinePlayers.get(3).setBounds(randomNumber7,randomNumber8,50,50);
       
       
        
//        machinePlayers.get(0).setBounds(machinePlayers.get(0).getX() -20,machinePlayers.get(0).getY(),50,50);
//        machinePlayers.get(1).setBounds(machinePlayers.get(1).getX() -20,machinePlayers.get(1).getY(),50,50);
   } 
   
   /*This creats the goal button for when the player 
     makes it across the field 
   */
   public void addGoalButton(){
       
      goalButton = new JButton();
      goalButton.setBounds(1080,40, 100, 510);
      add(goalButton);
      goalButton.setVisible(false);
      
      goalRectangle = goalButton.getBounds();   
   }
    
   public void paintComponent(Graphics g){ 
        super.paintComponent(g); 
        Image footBallField = Toolkit.getDefaultToolkit().getImage("images/Football Field.jpg"); 
        requestFocusInWindow(); 
        g.drawImage(footBallField, 0, 0, this);
        requestFocusInWindow();
      }   
}
    
      
      
 
    

