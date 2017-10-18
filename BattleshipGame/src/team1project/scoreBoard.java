/*
 *
 *
 *Sprint ID: 2 created score board
 */
package team1project;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Keval
 */
public class scoreBoard {

    //created popup window with score board
    public static void popup() {
        TableView table = new TableView();
        Stage window = new Stage();
        // stop the player from clicking out side the window if it's open
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Score Board");
        window.setWidth(430);

        table.setEditable(false);
        // add colums to tables
        TableColumn rankCol = new TableColumn("Rank");
        rankCol.setMinWidth(100);
        TableColumn nameCol = new TableColumn("Name");
        nameCol.setMinWidth(200);
        nameCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("pname"));
        TableColumn scoreCol = new TableColumn("Score");
        scoreCol.setMinWidth(100);
        scoreCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("pscore"));

        table.getColumns().addAll(rankCol, nameCol, scoreCol);

        final VBox vbox = new VBox(20);
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        // close button to close the window      
        Button hide = new Button("Close");

        hide.setAlignment(Pos.CENTER);
        hide.setOnAction(e -> window.close());
        // add table and button to window
        vbox.getChildren().addAll(table, hide);
        //set window to scean
        Scene scean = new Scene(vbox);
        window.setScene(scean);
        window.show();
    }

}
