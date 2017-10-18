/*
 *
 * SID: 13 created window popup with instructions to play the game
 */
package team1project;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.control.Label;

/**
 *
 * @author Keval
 */
public class instructions {

    public static void help() {
        //created stage window
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Score Board");
        window.setWidth(430);
        // tital lable
        final Label label1 = new Label("Instructions");
        label1.setFont(new Font("Arial", 20));
        // instructions lable
        final Label label2 = new Label("  -> Click on Start Game to lauch the game.");
        final Label label3 = new Label("  -> Click on buttom board to place your ships");
        final Label label4 = new Label("  --> Left click place your ship vertical");
        final Label label5 = new Label("  --> Right clicck to place your ship horizontal");
        final Label label6 = new Label("  -> Click on High score to see your rank / score");

        final VBox vbox = new VBox(20);
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));

        //close button
        Button hide = new Button("Close");

        hide.setAlignment(Pos.CENTER);
        hide.setOnAction(e -> window.close());
        // add lables and button on window
        vbox.getChildren().addAll(label1, label2, label3, label4, label5, label6, hide);

        Scene scean = new Scene(vbox);
        window.setScene(scean);
        window.show();
    }

}
