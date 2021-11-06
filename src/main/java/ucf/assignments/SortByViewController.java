package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Bryson Paul
 */
public class SortByViewController {
    private Button backButton;

    @FXML
    private void loadToDoListView(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/in-to-do-list-view.fxml"));
        Parent root= loader.load();
        ToDoListViewController controller = loader.getController();
        controller.displayToDoList();
        Stage s= new Stage();
        s.setScene(new Scene(root));
        s.show();
        Stage secondStage = (Stage) backButton.getScene().getWindow();
        secondStage.close();
    }
    @FXML
    private void sortByExistingItems(ActionEvent event) throws IOException {
            App.sortByValue=0;
            loadToDoListView(event);
    }
    @FXML
    private void sortByCompleteItems(ActionEvent event) throws IOException {
            App.sortByValue=1;
            loadToDoListView(event);
    }
    @FXML
    private void sortByIncompleteItems(ActionEvent event) throws IOException {
            App.sortByValue=2;
            loadToDoListView(event);
    }

}