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
public class SortByViewController {
    @FXML
    private Pane sortByPane;
    @FXML
    private Button backButton;

    @FXML
    private void loadToDoListView(ActionEvent event) throws IOException {
        Pane p = FXMLLoader.load(getClass().getResource("/in-to-do-list-view.fxml"));
        sortByPane.getChildren().setAll(p);
    }
}