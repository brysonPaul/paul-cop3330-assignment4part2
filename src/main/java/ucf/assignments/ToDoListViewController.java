package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.io.IOException;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Bryson Paul
 */
public class ToDoListViewController {
    @FXML
    private Pane inToDoListPane;
    @FXML
    private Button sortByButton;
    @FXML
    private Button backButton;
    @FXML
    private Button addItemButton;
    @FXML
    private Button editItemButton;

    @FXML
    private void loadSortView(ActionEvent event) throws IOException {
        Pane p = FXMLLoader.load(getClass().getResource("/sort-by-view.fxml"));
        inToDoListPane.getChildren().setAll(p);
    }
    @FXML private void loadOnOpenView(ActionEvent event) throws IOException {
        Pane p = FXMLLoader.load(getClass().getResource("/on-open-view.fxml"));
        inToDoListPane.getChildren().setAll(p);
    }
    @FXML private void loadAddItemView(ActionEvent event) throws IOException {
        Pane p = FXMLLoader.load(getClass().getResource("/new-to-do-list-item-view.fxml"));
        inToDoListPane.getChildren().setAll(p);
    }
    @FXML private void loadEditItemView(ActionEvent event) throws IOException {
        Pane p = FXMLLoader.load(getClass().getResource("/edit-to-do-list-item.fxml"));
        inToDoListPane.getChildren().setAll(p);
    }
}