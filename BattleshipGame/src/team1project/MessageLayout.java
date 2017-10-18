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
 * @author nelson
 */
public class MessageLayout {
    //#Demo ID 14
    Label messageLabel;
    Label messageUpdates = new Label("  ");         //This is the label that will hold the information for 
    Messages message = new Messages();
    GridPane grid;
    
    String currentMessage = " ";
 
    public GridPane getMessageLayout() {
        
        grid = new GridPane();
        grid.setAlignment(Pos.TOP_RIGHT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text sceneTitle = new Text("HUD: ");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        messageLabel = new Label("Alet Messages: ");
        grid.add(sceneTitle, 0, 0, 2, 1);
        grid.add(messageLabel, 0, 1);
        grid.add(messageUpdates, 2, 1);
        
       // System.out.println(messageUpdates);
        return grid;

    }
 
        
    
    //sets the alert Box to the appropriate message
    public void setAlertBox(String getString) {
        currentMessage = getString;
        messageUpdates.setText(currentMessage);
        
    }
    public String getMessageUpdate(){
        return currentMessage;
    }
   
    public void resetAletMessage(){
        messageUpdates.setText(" ");
    }

}
