/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team1project;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

/**
 *
 * @author kidlid215
 */
public class MenuBars {

    public static MenuBar getMenu() {
        instructions howTo = new instructions();
        MenuBar menuBar = new MenuBar();
        //Creates Menu items
        // --- Menu File and items
        Menu menuFile = new Menu("File");
        MenuItem saveGame = new MenuItem("Save");
        MenuItem loadGame = new MenuItem("Load");
        menuFile.getItems().addAll(saveGame, loadGame);

        // --- Menu Edit
        Menu menuInstruct = new Menu("Help");
        MenuItem howtoPlay = new MenuItem("How to play");
        howtoPlay.setOnAction(e -> howTo.help());
        menuInstruct.getItems().addAll(howtoPlay);

        // --- Menu Exit
        Menu menuExit = new Menu("Exit");
        MenuItem exitGame = new MenuItem("Quit");
        menuExit.getItems().addAll(exitGame);
        exitGame.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                System.exit(0);
            }
        }
        );

        //Adds all the menu items to the menu bar
        menuBar.getMenus().addAll(menuFile, menuInstruct, menuExit);
        return menuBar;
    }

}
