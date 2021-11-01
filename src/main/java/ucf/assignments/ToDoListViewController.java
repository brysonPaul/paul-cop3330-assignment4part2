package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Bryson Paul
 */
public class ToDoListViewController {
    @FXML
    private Button sortByButton;
    @FXML
    private Button backButton;
    @FXML
    private Button addItemButton;
    @FXML
    private AnchorPane toDoListItemAnchorPane;
    @FXML private Label title;

    @FXML private RadioButton[] radioButtons;
    @FXML private Label[] descriptions;
    @FXML private Label[] dateDue;
    @FXML private Button[] editItemButtons;
    @FXML private Button[] deleteItemButtons;

    @FXML public void displayToDoList(){
        title.setText(App.tm.toDoLists.get(App.currentList).title);
        display(App.tm.toDoLists.get(App.currentList));
    }
    @FXML private void display(ToDoList toDoList){
        int size =toDoList.toDoList.size();
        radioButtons = new RadioButton[size];
        descriptions = new Label[size];
        dateDue = new Label[size];
        editItemButtons = new Button[size];
        deleteItemButtons = new Button[size];

        HBox[] listsWithElements = new HBox[size];

        for (int x = 0; x < size; x++) {
            int finalX = x;

            radioButtons[x] = new RadioButton();
            descriptions[x] = new Label();
            dateDue[x] = new Label();
            editItemButtons[x] = new Button();
            deleteItemButtons[x] = new Button();

            radioButtons[x].setText("");
            radioButtons[x].setPrefSize(28,27);
            radioButtons[x].setFont(new Font(18));
            if(toDoList.toDoList.get(x).isComplete){
                radioButtons[x].setSelected(true);
            }
            else radioButtons[x].setSelected(false);
            radioButtons[x].setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                    if(radioButtons[finalX].isSelected()){
                        App.tm.toDoLists.get(App.currentList).markItemAsComplete(finalX);
                    }
                    else{
                        App.tm.toDoLists.get(App.currentList).markItemAsIncomplete(finalX);
                    }

                }
            });


            descriptions[x].setText(toDoList.toDoList.get(x).description);
            descriptions[x].setPrefSize(166, 18);
            descriptions[x].setFont(new Font(18));

            dateDue[x].setText(toDoList.toDoList.get(x).dueDate.toString());
            dateDue[x].setPrefSize(105,27);
            dateDue[x].setFont(new Font(18));

            editItemButtons[x].setText("Edit");
            editItemButtons[x].setPrefSize(74,30);
            editItemButtons[x].setFont(new Font(14));

            deleteItemButtons[x].setText("-");
            deleteItemButtons[x].setPrefSize(29,30);
            deleteItemButtons[x].setFont(new Font(14));
            deleteItemButtons[x].setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                    App.tm.toDoLists.get(App.currentList).removeItem(finalX);//needed another x variable to work, not gonna question it
                    displayToDoList();
                }
            });

            //places each group to an HBOX (melee reference??). This one has two hboxes into one hbox because spacing looks better this way
            HBox one = new HBox(125,radioButtons[x],descriptions[x]);
            one.setAlignment(Pos.CENTER_RIGHT);
            HBox two = new HBox(12,dateDue[x],editItemButtons[x],deleteItemButtons[x]);
            listsWithElements[x]= new HBox(one,two);
            listsWithElements[x].setAlignment(Pos.CENTER);
        }
        //places each hbox into one vbox
        //TODO: PLEASE AND I MEAN PLEASE ADD THE THING THAT ALLOWS THE ANCHOR PANE TO RESIZE IF TOO MANY ELEMENTS ARE HERE
        VBox listsVert = new VBox(10.0,listsWithElements);
        listsVert.setAlignment(Pos.BASELINE_CENTER);
        toDoListItemAnchorPane.getChildren().clear();
        toDoListItemAnchorPane.getChildren().add(listsVert);
    }

    @FXML
    private void loadSortView(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sort-by-view.fxml"));
        Stage secondStage = new Stage();
        secondStage.setScene(new Scene(loader.load()));
        //shows stage
        secondStage.show();

        Stage curStage = (Stage) addItemButton.getScene().getWindow();
        curStage.close();
    }
    @FXML private void loadOnOpenView(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/on-open-view.fxml"));
        Stage secondStage = new Stage();
        secondStage.setScene(new Scene(loader.load()));
        //this makes the thing display the list. but it in anything that goes back to the main method
        AppController mainController = loader.getController();
        mainController.displayLists();
        //shows stage
        secondStage.show();

        Stage curStage = (Stage) backButton.getScene().getWindow();
        curStage.close();
    }
    @FXML private void loadAddItemView(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/new-to-do-list-item-view.fxml"));
        Stage secondStage = new Stage();
        secondStage.setScene(new Scene(loader.load()));
        //shows stage
        secondStage.show();

        Stage curStage = (Stage) addItemButton.getScene().getWindow();
        curStage.close();
    }
    @FXML private void loadEditItemView(ActionEvent event) throws IOException {

    }
}