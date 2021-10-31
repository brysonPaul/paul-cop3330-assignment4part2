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
public class EditListItemViewController {
    @FXML
    private Pane editListItemPane;
    @FXML
    private Button backButton;
    @FXML
    private Button okayButton;

    @FXML
    private void loadToDoListView(ActionEvent event) throws IOException {
        Pane p = FXMLLoader.load(getClass().getResource("/in-to-do-list-view.fxml"));
        editListItemPane.getChildren().setAll(p);
    }
}