/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team1project;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author arr5365
 */
public class LabelBoard {
    Label boardLabel;
    Messages message = new Messages();
    GridPane grid;
    
    String currentMessage = " ";

    public  GridPane labelBoard() {
        
        grid = new GridPane();
        grid.setAlignment(Pos.TOP_RIGHT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text sceneTitle = new Text("HUD: ");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        boardLabel = new Label("Alet Messages: ");
        grid.add(sceneTitle, 0, 0, 2, 1);
        grid.add(boardLabel, 0, 1);


        return grid;

    }
}
