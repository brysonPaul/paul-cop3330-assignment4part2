package ucf.assignments;

import javafx.fxml.FXML;

import javafx.scene.control.Label;


/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Bryson Paul
 */
public class DescriptionFieldController {
    @FXML private Label descLabel;
    @FXML public void setDescLabel(int index){
        descLabel.setText(App.tm.toDoList.get(index).description);
    }

}
