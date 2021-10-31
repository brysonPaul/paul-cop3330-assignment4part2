package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Bryson Paul
 */
public class CreateListItemViewController {
    @FXML
    private DatePicker dateChosen;
    @FXML
    private TextField description;
    @FXML
    private Button cancelButton;
    @FXML
    private Button createButton;

    @FXML
    private void onCancelButtonClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/in-to-do-list-view.fxml"));
        Parent root= loader.load();
        ToDoListViewController controller = loader.getController();
        controller.displayToDoList();
        Stage s= new Stage();
        s.setScene(new Scene(root));
        s.show();
        Stage secondStage = (Stage) cancelButton.getScene().getWindow();
        secondStage.close();
    }

    @FXML
    private void onCreateButtonClick(ActionEvent event) throws IOException {//not working completely yet
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/in-to-do-list-view.fxml"));
        Parent root= loader.load();
        App.tm.toDoLists.get(App.currentList).addItem(new ToDoItem(description.getText()));//this line is not working, look at it later
        ToDoListViewController controller = loader.getController();
        controller.displayToDoList();
        Stage s= new Stage();
        s.setScene(new Scene(root));
        s.show();
        Stage secondStage = (Stage) createButton.getScene().getWindow();
        secondStage.close();
    }
}