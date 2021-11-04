package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
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
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

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


    @FXML public void displayToDoList(){
        title.setText(App.tm.toDoLists.get(App.currentList).title);
        display(App.tm.toDoLists.get(App.currentList).toDoList);

    }
    @FXML private void display(ArrayList<ToDoItem> items){
        int size =items.size();

        ArrayList<HBox> listsWithElements = new ArrayList<HBox>();

        for (int x = 0; x < size; x++) {
            if(App.sortByValue==0)
            {
                listsWithElements.add(createItemHbox(x,items.get(x)));
            }
            else if(App.sortByValue==1 && items.get(x).isComplete){
                listsWithElements.add(createItemHbox(x,items.get(x)));
            }
            else if(App.sortByValue==2 && !items.get(x).isComplete){
                listsWithElements.add(createItemHbox(x,items.get(x)));
            }
        }
        //places each hbox into one vbox
        //TODO: PLEASE AND I MEAN PLEASE ADD THE THING THAT ALLOWS THE ANCHOR PANE TO RESIZE IF TOO MANY ELEMENTS ARE HERE
        VBox listsVert;
        try {
            HBox[] h= toHboxArray(listsWithElements);
             listsVert = new VBox(10.0, h );
        }
        catch (ClassCastException ex){
            System.out.println("checking123");
            listsVert = new VBox();
        }
        listsVert.setAlignment(Pos.BASELINE_CENTER);
        toDoListItemAnchorPane.getChildren().clear();
        toDoListItemAnchorPane.getChildren().add(listsVert);
    }
    private HBox[] toHboxArray(ArrayList<HBox> src){
        HBox[] h= new HBox[src.size()];
        for(int x=0;x<h.length;x++){
            h[x]=src.get(x);
        }
        return h;
    }

    private HBox createItemHbox(int x, ToDoItem item){

        RadioButton radioButton = new RadioButton();
        Label description = new Label();
        Label dateDue = new Label();
        Button editItemButton = new Button();
        Button deleteItemButton = new Button();

        radioButton.setText("");
        radioButton.setPrefSize(28,27);
        radioButton.setFont(new Font(18));
        if(item.isComplete){
            radioButton.setSelected(true);
        }
        else radioButton.setSelected(false);
        radioButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                if(radioButton.isSelected()){
                    App.tm.toDoLists.get(App.currentList).markItemAsComplete(x);
                    System.out.println( App.tm.toDoLists.get(App.currentList).toDoList.get(x).isComplete);
                }
                else if(!radioButton.isSelected()){
                    App.tm.toDoLists.get(App.currentList).markItemAsIncomplete(x);
                    System.out.println( App.tm.toDoLists.get(App.currentList).toDoList.get(x).isComplete);
                }

            }
        });


        description.setText(item.description);
        description.setPrefSize(166, 18);
        description.setFont(new Font(18));

        dateDue.setText(item.dueDate.toString());
        dateDue.setPrefSize(105,27);
        dateDue.setFont(new Font(18));

        editItemButton.setText("Edit");
        editItemButton.setPrefSize(74,30);
        editItemButton.setFont(new Font(14));
        editItemButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                try {
                    loadEditItemView(e,x);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        deleteItemButton.setText("-");
        deleteItemButton.setPrefSize(29,30);
        deleteItemButton.setFont(new Font(14));
        deleteItemButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                ToDoItem t= App.tm.toDoLists.get(App.currentList).removeItem(x);//needed another x variable to work, not gonna question it
                displayToDoList();
            }
        });

        //places each group to an HBOX (melee reference??). This one has two hboxes into one hbox because spacing looks better this way
        HBox one = new HBox(125,radioButton,description);
        one.setAlignment(Pos.CENTER_RIGHT);
        HBox two = new HBox(12,dateDue,editItemButton,deleteItemButton);
        return new HBox(one,two);
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
        App.sortByValue=0;
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
    @FXML private void loadEditItemView(ActionEvent event,int i) throws IOException {
        App.currentItem=i;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/edit-to-do-list-item.fxml"));
        Stage secondStage = new Stage();
        secondStage.setScene(new Scene(loader.load()));
        //shows stage
        secondStage.show();
        Stage curStage = (Stage) addItemButton.getScene().getWindow();
        curStage.close();
    }
}