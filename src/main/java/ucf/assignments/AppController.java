package ucf.assignments;

import javafx.beans.value.ObservableNumberValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
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
public class AppController {

    @FXML
    public Stage window;
    @FXML
    public Scene addToDoListScene;
    @FXML
    private Button[] toDoLists;
    @FXML
    private Button[] editListButtons;
    @FXML
    private Button[] deleteListButtons;
    @FXML
    public AnchorPane anchorPaneOnOpenView= new AnchorPane();
    @FXML
    public TextField descFieldNewTDList;
    @FXML
    public Pane onOpenPane;
    @FXML
    public Button addButton;
    public void displayLists(){
        displayToDoListsAndButtons(App.tm);
    }
    public void setText(String s ){
        addButton.setText(s);
    }
    private void displayToDoListsAndButtons(ToDoListManager tm) {
        System.out.println(tm.toDoLists.size());
        toDoLists = new Button[tm.toDoLists.size()];
        editListButtons = new Button[tm.toDoLists.size()];
        deleteListButtons = new Button[tm.toDoLists.size()];
        HBox[] listsWithButtons = new HBox[tm.toDoLists.size()];
        for (int x = 0; x < tm.toDoLists.size(); x++) {
            int finalX = x;

            toDoLists[x] = new Button();
            editListButtons[x] = new Button();
            deleteListButtons[x] = new Button();

            toDoLists[x].setText(tm.toDoLists.get(x).title);
            toDoLists[x].setMaxSize(390, 66);
            toDoLists[x].setMinSize(390,66);
            toDoLists[x].setFont(new Font(27));
            toDoLists[x].setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                    try {
                        loadToDoListView(e,finalX);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            });

            editListButtons[x].setText("Edit");
            editListButtons[x].setMaxSize(42, 26);
            editListButtons[x].setFont(new Font(13));
            editListButtons[x].setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                    try {
                        loadEditToDoList(e,finalX);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            });

            deleteListButtons[x].setText("-");
            deleteListButtons[x].setMaxSize(22, 11);
            deleteListButtons[x].setFont(new Font(13));
            deleteListButtons[x].setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                    App.tm.removeToDoList(finalX);//needed another x variable to work, not gonna question it
                    displayLists();
                }
            });
            //places each group to an HBOX (melee reference??)
            listsWithButtons[x] = new HBox(12.0,editListButtons[x],toDoLists[x], deleteListButtons[x]);
            listsWithButtons[x].setAlignment(Pos.CENTER);
        }
        //places each hbox into one vbox
        //TODO: PLEASE AND I MEAN PLEASE ADD THE THING THAT ALLOWS THE ANCHOR PANE TO RESIZE IF TOO MANY BUTTONS ARE HERE
        VBox listsVert = new VBox(10.0,listsWithButtons);
        listsVert.setAlignment(Pos.BASELINE_CENTER);
        anchorPaneOnOpenView.getChildren().clear();
        anchorPaneOnOpenView.getChildren().add(listsVert);

    }
    @FXML
    private void loadToDoListView(ActionEvent event, int i) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/in-to-do-list-view.fxml"));
        Parent root= loader.load();
        App.currentList=i;
        ToDoListViewController controller = loader.getController();
        controller.displayToDoList();
        Stage s= new Stage();
        s.setScene(new Scene(root));
        s.show();
        Stage secondStage = (Stage) addButton.getScene().getWindow();//dont like that I chose a random button for this step, but it is better than adding the whole button
        secondStage.close();
    }
    @FXML private void loadEditToDoList(ActionEvent event,int i) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/edit-to-do-list-view.fxml"));
        Parent root= loader.load();
        EditListViewController controller = loader.getController();
        controller.setIndex(i);
        Stage s= new Stage();
        s.setScene(new Scene(root));
        s.show();
        Stage secondStage = (Stage) addButton.getScene().getWindow();
        secondStage.close();
    }
    @FXML private void loadAddToDoList(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/new-to-do-list-view.fxml"));
        Parent root= loader.load();
        CreateListViewController controller = loader.getController();
        Stage s= new Stage();
        s.setScene(new Scene(root));
        s.show();
        Stage secondStage = (Stage) addButton.getScene().getWindow();
        secondStage.close();

    }


}