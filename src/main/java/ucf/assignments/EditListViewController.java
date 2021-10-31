package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Bryson Paul
 */
public class EditListViewController {
    @FXML
    private TextField titleOfList;
    @FXML
    private Button backButton;
    @FXML
    private Button okayButton;

    private int index;
    @FXML
    public void setIndex(int i){
        this.index=i;
    }
    @FXML
    private void onOkayButtonClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/on-open-view.fxml"));
        Stage secondStage = new Stage();
        secondStage.setScene(new Scene(loader.load()));
        App.tm.editToDoListTitle(index,titleOfList.getText());
        //displays all the lists
        AppController mainController = loader.getController();
        mainController.displayLists();
        //shows stage
        secondStage.show();
        //closes current stage
        Stage curStage = (Stage) okayButton.getScene().getWindow();
        curStage.close();
    }
    @FXML
    private void onCancelButtonClick(ActionEvent event) throws IOException{
    }
}