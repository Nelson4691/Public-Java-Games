/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team1project;

/**
 *
 * @author Andrew
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author arr5365
 */
// Sprint ID: 3
public class Board extends Parent {

    int addMoves;
    private VBox rows = new VBox(); //Creates a new Vbox
    private boolean enemy = false; //Creates boolean to check if board is enemies or not
    public int ships = 5; //Sets ship default health to 5 (for size of ship)

    List<Ship> storedShips = new ArrayList();

    ;          //Will store the ships
    //Allows user to click on enemy board
    public Board(boolean enemy, EventHandler<? super MouseEvent> handler) {
        this.enemy = enemy;
        for (int y = 0; y < 10; y++) {
            HBox row = new HBox();
            for (int x = 0; x < 10; x++) {
                Cell c = new Cell(x, y, this);
                c.setOnMouseClicked(handler);
                row.getChildren().add(c);
            }

            rows.getChildren().add(row);
        }

        getChildren().add(rows);
    }

    //Sprint ID: 12
    public boolean placeShip(Ship ship, int x, int y) {

        if (canPlaceShip(ship, x, y)) {
            int length = ship.type;

            if (ship.vertical) {
                for (int i = y; i < y + length; i++) {
                    Cell cell = getCell(x, i);
                    cell.ship = ship;
                    if (!enemy) {
                        cell.setFill(Color.DARKGRAY);
                        cell.setStroke(Color.GREEN);
                    }
                }
            } else {
                for (int i = x; i < x + length; i++) {
                    Cell cell = getCell(i, y);
                    cell.ship = ship;
                    if (!enemy) {
                        cell.setFill(Color.DARKGRAY);
                        cell.setStroke(Color.GREEN);
                    }
                }
            }
            ship.setShipName();
            storedShips.add(ship);
            return true;
        }

        return false;
    }

    public List getShipsOnBoard() {
        return storedShips;
    }

    //Gets the x and y value of the spot on the board
    public Cell getCell(int x, int y) {
        return (Cell) ((HBox) rows.getChildren().get(y)).getChildren().get(x);
    }

    //Gets different cell x,y value that are around the user click to be later used for hint
    private Cell[] getNeighbors(int x, int y) {
        Point2D[] points = new Point2D[]{
            new Point2D(x - 1, y),
            new Point2D(x + 1, y),
            new Point2D(x, y - 1),
            new Point2D(x, y + 1)
        };

        List<Cell> neighbors = new ArrayList<Cell>();

        for (Point2D p : points) {
            if (isValidPoint(p)) {
                neighbors.add(getCell((int) p.getX(), (int) p.getY()));
            }
        }

        return neighbors.toArray(new Cell[0]);
    }

    //Sprint ID: 12
    private boolean canPlaceShip(Ship ship, int x, int y) {
        int length = ship.type;

        if (ship.vertical) {
            for (int i = y; i < y + length; i++) {
                if (!isValidPoint(x, i)) {
                    return false;
                }

                Cell cell = getCell(x, i);
                if (cell.ship != null) {
                    return false;
                }

                for (Cell neighbor : getNeighbors(x, i)) {
                    if (!isValidPoint(x, i)) {
                        return false;
                    }

                    if (neighbor.ship != null) {
                        return false;
                    }
                }
            }
        } else {
            for (int i = x; i < x + length; i++) {
                if (!isValidPoint(i, y)) {
                    return false;
                }

                Cell cell = getCell(i, y);
                if (cell.ship != null) {
                    return false;
                }

                for (Cell neighbor : getNeighbors(i, y)) {
                    if (!isValidPoint(i, y)) {
                        return false;
                    }

                    if (neighbor.ship != null) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    //makes sure the users click is valid on the board. This prevents the user from placing their ships on the enemy board or off the game board, also prevents the ability of stacking ships.
    private boolean isValidPoint(Point2D point) {
        return isValidPoint(point.getX(), point.getY());
    }

    private boolean isValidPoint(double x, double y) {
        return x >= 0 && x < 10 && y >= 0 && y < 10;
    }

    //creates the cell class and give the cell certain properties
    public class Cell extends Rectangle {

        public int x, y;
        public Ship ship = null;
        public boolean wasShot = false;

        private Board board;
        private MessageLayout messageLayout = new MessageLayout();
        private LabelBoard boardLabel = new LabelBoard();
        Messages messages = new Messages();
        Team1Project appClass = new Team1Project();

        public Cell(int x, int y, Board board) {
            super(30, 30);
            this.x = x;
            this.y = y;
            this.board = board;
            setFill(Color.BLUE);
            setStroke(Color.BLACK);
        }

        //Sprint ID: 11
        public boolean shoot() {
            wasShot = true;
            addMoves++;
            setFill(Color.BLACK);

            if (ship != null) {
                ship.hit();
                //#Demo ID 14
                //if board that is hit is enemies then it will set the message layout to display opponent ship hit message from message class
                
                if (board.enemy) {
                    System.out.println(messages.getOpponentHitMessage());
                    messageLayout.setAlertBox(messages.getOpponentHitMessage());
                    //ship.displayShipStatus();

                    //System.out.println("Ship has been hit");
                } //Sprint ID: 15
                //if board that is hit is enemies then it will set the message layout to display opponent ship hit message from message class
                else if (!board.enemy) {
                    System.out.println(messages.getHitMessage());
                    messageLayout.setAlertBox(messages.getHitMessage());
                    //ship.displayShipStatus();
                }
                setFill(Color.YELLOW);
                if (!ship.alive()) {
                    board.ships--;
                }
                //Sprint ID: 16
                //ID 16 and 17. Both sprints are in this code.
                if (board.ships == 0)//If all ships been shot
                {
                    //create a window
                    Stage winnerWindow = new Stage();
                    winnerWindow.initModality(Modality.APPLICATION_MODAL);
                    winnerWindow.setTitle("You've won!");
                    winnerWindow.setWidth(430);
                    //create vbox
                    final VBox vbox = new VBox(20);
                    vbox.setSpacing(5);
                    vbox.setPadding(new Insets(10, 0, 0, 10));

                    //Menu Options when player has won.
                    Button newGame = new Button("New Game");
                    Button exit = new Button("Exit");
                    Button highScore = new Button("High Scores");

                    //Sets alignments of the buttons.
                    newGame.setAlignment(Pos.CENTER);
                    highScore.setAlignment(Pos.CENTER);
                    exit.setAlignment(Pos.CENTER);
                    //SBI: 22 It is not fully complete but it does show another game instance to run
                    Team1Project main = new Team1Project();
                    //action listeners when button is clicked.
                    newGame.setOnAction(e -> {
                        try {
                            winnerWindow.close();
                            Stage stage = new Stage();
                            
                            Scene scene = new Scene(main.createGameBoard());
                            
                            stage.setScene(scene);
                            
                            stage.sizeToScene();
                            stage.setResizable(true);
                            
                            stage.show();
                            main.start(stage);
                        } catch (Exception ex) {
                            Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
                        }
});
                    highScore.setOnAction(e -> scoreBoard.popup());
                    exit.setOnAction(e -> System.exit(0));

                    // add buttons to window
                    vbox.getChildren().addAll(newGame, highScore, exit);
                    Scene scean = new Scene(vbox);
                    winnerWindow.setScene(scean);
                    winnerWindow.show();
                    
                    //SID: 26 it save the total moves plyer made when the game ended
                    /*
                    Insted of scoring points when ship hits, we count how many turns player makes till the one side loses all the ships
                    part below creates new txt file and stores total moves in the file.
                    
                    */
                    String moves = String.valueOf(addMoves);
                    System.out.println(moves);
                    try {
                        FileWriter writer = new FileWriter("names.txt", true);
                        writer.write(moves + "++");
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return true;
            }
            return false;
        }
        //Nelson ID: 21
        public void runDebbugerMode(boolean debuggerStatus) {
            //Takes paramerter of bool to see if status is active
            if (debuggerStatus) {
                //if there there is a ship in the cell then it activates the ship hit method lso
                if (ship != null) {
                    //ship.hit();
                    //if statment checks which board has been hit in order to display the status
                    if (!board.enemy) {
                        System.out.print("Your");
                        ship.displayShipStatus();
                    }
                    else if (board.enemy) {
                        System.out.print("The Enemies ");
                        ship.displayShipStatus();
                    }
                    
                }

            }
        }
    }
}
