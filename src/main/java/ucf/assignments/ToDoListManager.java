package ucf.assignments;

import java.lang.reflect.Array;
import java.util.ArrayList;
/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Bryson Paul
 */
public class ToDoListManager
{
    public ArrayList<ToDoList> toDoLists;//arrayList used to support at least 100 to do lists

    public ToDoListManager(){
        /*
            this.toDoLists = new ArrayList<>()
         */
    }
    public void addToDoList(ToDoList t){
        /*
            toDoLists.add(t)
         */
    }
    public ToDoList removeToDoList(int index){
        /*
            return toDoLists.remove(index);
         */
        return new ToDoList();
    }
    public void editToDoListTitle(int index, String title) {
        /*
            toDoLists.get(index).setTitle(title)
         */
    }
    public void AddItemToToDoList(int index, ToDoItem item){
        /*
            toDoLists.get(index).addItem(item)
         */
    }
    public void RemoveItemFromToDoList(int toDoIndex, int itemIndex){
        /*
            toDoLists.get(toDoIndex).remove(itemIndex)
         */
    }
    public void saveSingleToDoList(int index, String path){
    /*
        toDoLists.get(index).saveToDoList(path)
     */
    }
    public void loadSingleToDoList( String path){//made it void because it is going right into the arrayList
        /*
        toDoLists.add(loadToDoList(path))
         */
    }
    public void saveAllToDoLists(String path){
        /*
        File f = new File(path)
        Gson gson = new Gson()
        String s = gson.toGson(this)
        FileWriter fw = new FileWriter(f)
        fw.write(s)
         */
    }
    public void loadAllToDoLists(String path){
       /*
       File f = new File(path)
       Scanner sc= new Scanner(f)
       Gson gson = new Gson()
       s = ""
       while sc.hasNext()
            s+=sc.next
       end loop
       this = gson.fromGson(s)
        */
    }
}