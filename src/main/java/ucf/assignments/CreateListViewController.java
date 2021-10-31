package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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
public class CreateListViewController {
   @FXML
    private TextField descFieldNewTDList;
    @FXML
    private Button okayButtonTDList;
    @FXML
    private Button cancelButtonTDList;
    @FXML
    public ToDoListManager toDoListHold;

    @FXML
    private void loadOnOpenView(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/on-open-view.fxml"));
        Stage secondStage = new Stage();
        secondStage.setScene(new Scene(loader.load()));
        //this makes the thing display the list. but it in anything that goes back to the main method
        AppController mainController = loader.getController();
        mainController.displayLists();
        //shows stage
        secondStage.show();

        Stage curStage = (Stage) cancelButtonTDList.getScene().getWindow();
        curStage.close();
    }
    @FXML
    private void addToDoListAndDisplay(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/on-open-view.fxml"));
        Stage secondStage = new Stage();
        secondStage.setScene(new Scene(loader.load()));
        App.tm.addToDoList(new ToDoList(descFieldNewTDList.getText()));
        //displays all the lists
        AppController mainController = loader.getController();
        mainController.displayLists();
        //shows stage
        secondStage.show();
        //closes current stage
        Stage curStage = (Stage) okayButtonTDList.getScene().getWindow();
        curStage.close();

    }




}