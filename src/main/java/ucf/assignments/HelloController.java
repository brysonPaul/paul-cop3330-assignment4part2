package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.io.IOException;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Bryson Paul
 */
public class HelloController {
    @FXML
    private Pane onOpenPane;
    @FXML
    private Button testButton;
    @FXML
    private Button editButton;
    @FXML
    private Button addButton;


    @FXML
    private void loadToDoListView(ActionEvent event) throws IOException {
        Pane p = FXMLLoader.load(getClass().getResource("/in-to-do-list-view.fxml"));
        onOpenPane.getChildren().setAll(p);
    }
    @FXML private void loadEditToDoList(ActionEvent event) throws IOException{
        Pane p = FXMLLoader.load(getClass().getResource("/edit-to-do-list-view.fxml"));
        onOpenPane.getChildren().setAll(p);
    }
    @FXML private void loadAddToDoList(ActionEvent event) throws IOException{
        Pane p = FXMLLoader.load(getClass().getResource("/new-to-do-list-view.fxml"));
        onOpenPane.getChildren().setAll(p);
    }
}