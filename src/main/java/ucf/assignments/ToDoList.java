package ucf.assignments;

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
        /*
        this.title = " "
        this.toDoList = new ArrayList<>()
         */
    }
    public ToDoList(String title){
        /*
        this.title =title
        this.toDoList = new ArrayList<>()
         */
    }

    public void addItem(ToDoItem t){
        /*
            toDoList.add(t)
         */
    }
    public ToDoItem removeItem(int index){
        /*
           return toDoList.remove(index)
         */
        return new ToDoItem("",new Date());
    }
    public void setTitle(String s){
        /*
        this.title=s
         */
    }
    public void editToDoItemDesc(int index,String s){
        /*
        toDoList.get(index).setDescription(s)
         */

    }
    public void editToDoItemDueDate(int index, Date d){
        /*
        toDoList.get(index).setDate(d)
         */
    }
    public void markItemAsComplete(int index){
        /*
        toDoList.get(index).markAsComplete();
         */
    }
    public void displayExistingItems(){
        /*
        displayItems(this.toDoList);
      */
    }
    public void displayCompletedItems(){
     /*
        ArrayList<ToDoItem> a = sortByCompleteItems(this.toDoList)
        displayItems(a)
      */
    }
    public void displayIncompleteItems(){
     /*
        ArrayList<ToDoItem> a = sortByIncompleteItems(this.toDoList)
        displayItems(a)
      */
    }
    public ArrayList<ToDoItem> sortByCompleteItems(){
        /*
        ArrayList<ToDoItem> aList= new ArrayList<>()
        for ToDoItem i in this.toDoList
            if i.isComplete()
                aList.add(i);
            end if
        end loop
        return aList
      */
        return new ArrayList<>();
    }
    public ArrayList<ToDoItem> sortByIncompleteItems(){
        /*
        ArrayList<ToDoItem> aList= new ArrayList<>()
        for ToDoItem i in this.toDoList
            if !i.isComplete()
                aList.add(i);
            end if
        end loop
        return aList
      */
        return new ArrayList<>();
    }
    public void displayItems(ArrayList<ToDoItem> i){
        /*
        for ToDoItem item in i
            item.display()
        end loop
      */
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