package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Bryson Paul
 */
public class EditListItemViewController {
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextField description;
    @FXML
    private Button backButton;
    @FXML
    private Button okayButton;

    /*
     loader = new FXMLLoader(in to do list view)
     Parent root = loader.load();
     ToDoListViewController c = loader.getController
     controller.displayToDoList
     showStage()
     closeCurStage();
     */
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
    /*
     App.tm.toDoList.get(App.currentItem).description=description.getText()
     App.tm.toDoList.get(App.currentItem).dueDate=datePicker.getValue().toString()
     loadToDoListView(event)
     */
    @FXML
    private void onOkayButtonClick(ActionEvent event) throws IOException{
        if(description.getText().length()==0 && datePicker.getValue()!=null){
            App.tm.toDoList.get(App.currentItem).dueDate=datePicker.getValue().toString();
        }
        else if(description.getText().length()!=0 && datePicker.getValue()==null){
            App.tm.toDoList.get(App.currentItem).description=description.getText();
        }
        else if(description.getText().length()==0 && datePicker.getValue()==null){
            loadToDoListView(event);
        }
        else{
            App.tm.toDoList.get(App.currentItem).description=description.getText();
            App.tm.toDoList.get(App.currentItem).dueDate=datePicker.getValue().toString();
        }
        loadToDoListView(event);
    }
}