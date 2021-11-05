package ucf.assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.*;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Bryson Paul
 */
public class ToDoList {
    public String title;
    public ArrayList<ToDoItem> toDoList;//can do 100 or more, so is a good thing to use
    public ToDoList(){

        this.title = " ";
        this.toDoList = new ArrayList<>();
    }
    public ToDoList(String title){

        this.title =title;
        this.toDoList = new ArrayList<>();

    }
    public ToDoList(String title, ArrayList<ToDoItem> t){
        this.title = title;
        this.toDoList = t;
    }

    public void addItem(ToDoItem t){
            toDoList.add(t);
    }
    public ToDoItem removeItem(int index){

           return toDoList.remove(index);
    }
    public void setTitle(String s){
        this.title=s;
    }
    public void editToDoItemDesc(int index,String s){
        toDoList.get(index).setDescription(s);

    }
    public void editToDoItemDueDate(int index, LocalDate d){
        toDoList.get(index).setDueDate(d);
    }
    public void markItemAsComplete(int index){
        toDoList.get(index).markAsComplete();
    }
    public void markItemAsIncomplete(int index){toDoList.get(index).markAsIncomplete();}
    public String saveToDoList(String path) throws IOException { //saves a to do list to the path given
        File f = new File(path);
        f.getParentFile().mkdirs();
        if(!f.exists()){
            f.createNewFile();
        }
        Gson gson = new Gson();
        FileWriter fw= new FileWriter(path);
        String s= gson.toJson(this);
        fw.write(s);
        fw.close();
        return s;
    }
    public ToDoList loadToDoList(String path) throws FileNotFoundException {//loads the to do list using the path given
        String jsonString =getJsonString(path);
        if(jsonString.equals("-1")){
            return new ToDoList();
        }
        Gson gson = new Gson();
        ToDoList t =gson.fromJson(jsonString, this.getClass());
        addToDoListItemsToCurrentList(t);
        return t;
    }
    private String getJsonString(String path) throws FileNotFoundException {
        String s = "";
        try {
            File f = new File(path);
            Scanner sc = new Scanner(f);
            s = " ";
            while (sc.hasNextLine()){
                s += sc.next();
            }
        }
        catch (FileNotFoundException ex){
            return "-1";
        }
        return s;

    }
    public void addToDoListItemsToCurrentList(ToDoList t){
        for(int x=0;x<t.toDoList.size();x++){
            this.addItem(t.toDoList.get(x));
        }
    }
}