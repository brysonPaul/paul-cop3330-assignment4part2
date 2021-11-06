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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.DataInput;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Bryson Paul
 */
public class ToDoListViewController {
    @FXML
    private Button addItemButton;
    @FXML
    private Button saveButton;
    @FXML
    private  Button sortByButton;
    @FXML
    private AnchorPane toDoListItemAnchorPane;




    public ArrayList<ToDoItem> displayToDoList(ToDoList t,int val){//testing version, no fxml needed
      return display(t.toDoList,val);
    }
    @FXML public void displayToDoList(){
        display(App.tm.toDoList);
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
        toDoListItemAnchorPane.setPrefSize(600,50*listsWithElements.size());
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
    @FXML private ArrayList<ToDoItem> display(ArrayList<ToDoItem> items,int sortByValue){//test version of display
        int size =items.size();
        ArrayList<ToDoItem> itemsBeingDisplayed = new ArrayList<>();

        for (int x = 0; x < size; x++) {
            if(sortByValue==0)
            {
                // listsWithElements.add(createItemHbox(x,items.get(x)));
                itemsBeingDisplayed.add(items.get(x));
            }
            else if(sortByValue==1 && items.get(x).isComplete){
                //listsWithElements.add(createItemHbox(x,items.get(x)));
                itemsBeingDisplayed.add(items.get(x));
            }
            else if(sortByValue==2 && !items.get(x).isComplete){
                //listsWithElements.add(createItemHbox(x,items.get(x)));
                itemsBeingDisplayed.add(items.get(x));
            }
        }
        //toDoListItemAnchorPane.setPrefSize(600,50*listsWithElements.size());
//        VBox listsVert;
//        try {
//            HBox[] h= toHboxArray(listsWithElements);
//            listsVert = new VBox(10.0, h );
//        }
//        catch (ClassCastException ex){
//            System.out.println("checking123");
//            listsVert = new VBox();
//        }
//        listsVert.setAlignment(Pos.BASELINE_CENTER);
//        toDoListItemAnchorPane.getChildren().clear();
//        toDoListItemAnchorPane.getChildren().add(listsVert);
        return itemsBeingDisplayed;//returning this so it can be tested in the future
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
        Button description = new Button();
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
                    App.tm.markItemAsComplete(x);
                    System.out.println( App.tm.toDoList.get(x).isComplete);
                }
                else if(!radioButton.isSelected()){
                    App.tm.markItemAsIncomplete(x);
                    System.out.println( App.tm.toDoList.get(x).isComplete);
                }

            }
        });


        description.setText(item.description);
        description.setPrefSize(166, 18);
        description.setFont(new Font(18));
        description.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                try {
                    loadBiggerDescriptionView(e,x);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
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
                ToDoItem t= App.tm.removeItem(x);//needed another x variable to work, not gonna question it
                displayToDoList();
            }
        });

        //places each group to an HBOX (melee reference??). This one has two hboxes into one hbox because spacing looks better this way
        HBox one = new HBox(100,radioButton,description);
        one.setAlignment(Pos.CENTER_RIGHT);
        HBox two = new HBox(12,dateDue,editItemButton,deleteItemButton);
        return new HBox(30,one,two);
    }

    @FXML
    private void loadSortView(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sort-by-view.fxml"));
        Stage secondStage = new Stage();
        secondStage.setScene(new Scene(loader.load()));
        //shows stage
        secondStage.show();

        Stage curStage = (Stage) sortByButton.getScene().getWindow();
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
    @FXML private void onSaveButtonClick(ActionEvent e) throws IOException {
        String dirPath = System.getProperty("user.home")+System.getProperty("file.separator")
                +"Desktop"+System.getProperty("file.separator")
                +"Saves"+System.getProperty("file.separator")+"save.txt";
        String s = App.tm.saveToDoList(dirPath);
        saveButton.setText("Saved");
    }
    @FXML private void onLoadButtonClick(ActionEvent e) throws FileNotFoundException {
        String dirPath = System.getProperty("user.home")+System.getProperty("file.separator")
                +"Desktop"+System.getProperty("file.separator")
                +"Saves"+System.getProperty("file.separator")+"save.txt";
        App.tm.loadToDoList(dirPath);
        displayToDoList();
    }
    @FXML private void onClearAllButtonClick(ActionEvent e){
        App.tm.clearAllItems();
        displayToDoList();
    }
    @FXML private void  loadBiggerDescriptionView(ActionEvent e, int i) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/in-description-field-view.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load()));
        DescriptionFieldController controller =loader.getController();
        controller.setDescLabel(i);
        stage.show();
    }
}