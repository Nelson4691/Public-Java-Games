/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team1project;


import java.util.logging.Level;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javax.swing.JOptionPane;
import team1project.Board.Cell;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.Writer;
import java.util.logging.Logger;

/**
 *
 * @author phil
 */
public class Team1Project extends Application {
    
    private static final Logger LOGGER = Logger.getLogger(Team1Project.class.getName());

    
    
    public static final boolean useGui = true; //We are using a GUI
    private boolean running = false; //Set variable of running to false, looks to see if game is running or not
    private Board enemyBoard, playerBoard; //Creates two different boards, enemy and players.
    private boolean enemyTurn = false; //Looks to see if it is the enemy turn or not.
    private Random random = new Random();
    private int shipsToPlace = 5;
    Button Scoreboard;
    MessageLayout messageLayout = new MessageLayout();
    LabelBoard boardLabel = new LabelBoard();
    BorderPane root;
    boolean debugStatus = false;
    Button debugMode = new Button("Debug mode: Off  ");
    Button hint = new Button("hint");
    int addMoves = 0;

    //Debugger position sotorage variables
    List<Integer> positionx = new ArrayList();
    List<Integer> positiony = new ArrayList();

    public void updateDebuggerButton() {

        if (debugStatus == false) {
            debugMode.setText("Debug mode: On");
            debugStatus = true;

        } else if (debugStatus == true) {
            debugMode.setText("Debug mode: Off");
            debugStatus = false;
        }
    }

    public boolean getCurrentDebugStatus() {
        return debugStatus;
    }

    public Button getDebuggerButton() {
        return debugMode;
    }

    public void storeDebuggerPosition(int positionx, int positiony) {

        this.positionx.add(positionx);
        this.positiony.add(positiony);
        
        
    }

    public void setRightPanel() {
        root.setRight(messageLayout.getMessageLayout());
    }
    
    public void setLeftPanel(){
        
        VBox LeftPanelVbox = new VBox();
        //SPI ID: 23
        Text c = new Text ();
        c.setText("                                       Computer Board:");
        c.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
        c.setFill(Color.RED);
        Text p = new Text ();
        p.setText("\n\n\n\n\n\n\n\n\n                                             Player Board:");
        p.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
        p.setFill(Color.RED);
        
        LeftPanelVbox.getChildren().addAll(debugMode,hint, c, p);
        
        root.setLeft(LeftPanelVbox);
    }
    
    
    
    //Test comment
    //Creates Game Board
    public Parent createGameBoard() {
        root = new BorderPane();
        MenuBars menubar = new MenuBars();// creates MenuBars object for use of the methods in MenuBars
        root.setPrefSize(1920, 1080); //Sets default size of window, game works better in full screen.
        root.setTop(menubar.getMenu());//Sets the menu bar to the top of the borderpane ID:7
        setRightPanel();

        setLeftPanel();
        
//        setCenterPanel();
   
     //   setCenterPanel();

        //Action Listeners for updating debugger button
        debugMode.setOnAction(e -> {
            //still needs code
            updateDebuggerButton();
        });
        hint.setOnAction(e -> hint());

        //creates the enemy board if the game is running
        enemyBoard = new Board(true, event -> {
            setRightPanel(); //everyTime user clicks it takes the most updated grid
            if (!running) {
                return;
            }
            
            
            Cell cell = (Cell) event.getSource();
            //This checks to see if a cell on the board was shot.
            cell.runDebbugerMode(debugStatus);
                
            if (cell.wasShot) {

                return;
            }

            //Sprint ID: 19
            //Only switchs to the enemies turn if a ship was not hit.
            enemyTurn = !cell.shoot();

            if (enemyTurn) {
                enemyMove();

            }

        });
        //creates the player board if the game is running
        playerBoard = new Board(false, event -> {
            setRightPanel();                        //updates each time enemy clicks on board
            if (running) {
                return;
            }
            Cell cell = (Cell) event.getSource();
            cell.runDebbugerMode(debugStatus);
            if (playerBoard.placeShip(new Ship(shipsToPlace, event.getButton() == MouseButton.PRIMARY), cell.x, cell.y)) {

                if (--shipsToPlace == 0) {
                    startGame();
                }
            }
        });

        //Sets both boards up and aligns them to the center
        VBox vbox = new VBox(55, enemyBoard, playerBoard);
        //vbox.setAlignment(Pos.CENTER);//Originally
        vbox.setMaxSize(800, 925);//SBI 27, Made the correct changes for the board to be properly set.

        root.setCenter(vbox);
        

        return root;
    }

    //This methods give basic logic to the enemy you are facing. Here the computer chooses a spot at random where they want to shot.
    //Sprint ID: 18  
    private void enemyMove() {
        while (enemyTurn) {
            int x = random.nextInt(10);
            int y = random.nextInt(10);
            //Nelson ID:20
            Cell cell = playerBoard.getCell(x, y);
            if (cell.wasShot) {
                LOGGER.info("Location of enemy shot location is (" +x+","+y+")" + "\nShot was successful ");
                continue;
                
            }
            //SBI 20
            //debugger mode for enemy shot
            else if (!cell.wasShot) {
                LOGGER.info("Location of enemy shot location is (" +x+","+y+")" +"\n Shot was a miss");
            }
            if(cell.wasShot){
                LOGGER.info("Location of enemy shot location is (" +x+","+y+")" + "\nShot was successful ");
            }
            
            
    
            enemyTurn = cell.shoot();
            

        }
    }

    // SID: 10 when clicked on hint button on the game it show suggested move (need to make some changes sometimes it shows same move)

    private void hint() {
        int x = random.nextInt(10);              // get ramdom x value with in the board created
        int y = random.nextInt(10);               // get ramdom y value with in the board created
        
        Cell cell = enemyBoard.getCell(x, y);   //place the X and y values on the enemyboard
        storeDebuggerPosition(x, y);                 //Stores debuggerPosition        
        
        
        //SBI ID 20
        //everytime a hint is used it loggs the hint information
        LOGGER.info("Location of Hint is (" +x+","+y+")" );
        
        
        if (debugStatus == true) {                //used for debuging, display x and y values generated from about
            System.out.println("Hint position coordinates\n " + "x: " + x + " y : " + y); //print
        }
        if (!cell.wasShot) {                //cleck for cell that re not shot
            cell.setFill(Color.AQUA);           //change the color of the cell to aqua if the cell is not shot
        }

    }

    private void startGame() {
        // place enemy ships
        int type = 5;

        while (type > 0) {
            int x = random.nextInt(10);
            int y = random.nextInt(10);

            if (enemyBoard.placeShip(new Ship(type, Math.random() < 0.5), x, y)) {
                type--;
            }
        }

        running = true;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

        //Loads the creatGameBoard method to create the scene
        Scene scene = new Scene(createGameBoard());
        //SPI ID: 25
       scene.getStylesheets().
                add(Team1Project.class.getResource("Scene.css").toExternalForm());
        Scene mainMenu;

        //Buttons for main Menu
        Button startButton = new Button("Start Game");
        Button scoresButton = new Button("High Scores");
        Button instruct = new Button("How to Play");

        //listener for main menu Button
        startButton.setOnAction(e -> primaryStage.setScene(scene));
        //SID: 1/9 score bard popup connected with button high scores
        scoresButton.setOnAction(e -> scoreBoard.popup());
        //SID:13 window popup with instructions on how to play game 
        instruct.setOnAction(e -> instructions.help());

        VBox mainMenuOptions = new VBox(20);
        mainMenuOptions.getChildren().addAll(startButton, scoresButton, instruct);
        mainMenuOptions.setAlignment(Pos.CENTER);

        //Creates a StackPane which includes the main menu options
        StackPane mainMenuLayout = new StackPane();
        mainMenuLayout.getChildren().add(mainMenuOptions);
        mainMenu = new Scene(mainMenuLayout, 600, 800);
        mainMenu.getStylesheets().
                add(Team1Project.class.getResource("MenuCss.css").toExternalForm());

        primaryStage.setMaximized(true);
        primaryStage.setTitle("Battleship");
        primaryStage.setScene(mainMenu);
        //primaryStage.setResizable(false);
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public int getShipsRemaining(int Ships) {
        return Ships;
    }

    public static void main(String[] args) throws IOException {
        
        //SID: 1 prompt user to enter name
        //SID: 25 make sure user enter something in text box else if not game don't start
        String name;
        do {
            name = JOptionPane.showInputDialog(
                    "Enter your name", null);
        } while (name.matches("END"));
        System.out.println(name);
        try {
            Writer writer = new BufferedWriter(new FileWriter("names.txt", true));
            writer.write(name + "==");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            File f = new File("name.txt");
            Scanner sc = new Scanner(f);

            List<Person> people = new ArrayList<Person>();

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] details = line.split("(==)|(\\+\\+)");
                String pname = details[0];
                int pscore = Integer.parseInt(details[1]);

                Person p = new Person(pname, pscore);
                people.add(p);
            }

            for (Person p : people) {
                System.out.println(p.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (useGui) {
            launch(args);
        } else {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Hello, you are in the character interface.");
            System.out.println("Hit a key to quit");
            keyboard.nextLine();
            Platform.exit();
            System.exit(0);

        }
    }
}
