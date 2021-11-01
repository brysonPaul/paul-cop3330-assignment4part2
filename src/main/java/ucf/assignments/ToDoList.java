package ucf.assignments;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

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
            toDoList.add(new ToDoItem(t));
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
    public ToDoList sortByCompleteItems(){
        ArrayList<ToDoItem> aList= new ArrayList<>();
        for(ToDoItem t :this.toDoList){
            if(t.isComplete){
                aList.add(t);
            }
        }
        return new ToDoList(this.title,aList);
    }
    public ToDoList sortByIncompleteItems(){
        ArrayList<ToDoItem> aList= new ArrayList<>();
        for(ToDoItem t :this.toDoList){
            if(!t.isComplete){
                aList.add(t);
            }
        }
        return new ToDoList(this.title,aList);
    }
    public void saveToDoList(String path){
        /*
         Gson gson = new Gson()
         gson.toJson(this, new FileWriter(path))
         */
    }
    //this one will be called when saving every single to do list
    public String saveToDoList(){
        return "";
     /*
      Gson gson = new Gson()
      return gson.toJson(this)
      */
    }
    //for single to do list
    public ToDoList loadToDoList(String path){
        /*
        File f= new File(path);
        sc= new Scanner(f)
        s = " "
        while sc.hasNextLine
            s+=sc.next
        end loop
        Gson gson = new Gson()
        return gson.fromJson(s)
         */
        return new ToDoList();
    }
}