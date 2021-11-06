package ucf.assignments;

import java.io.*;
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
        this.toDoList = new ArrayList<ToDoItem>();
    }
    public ToDoList(String title){
        this.title =title;
        this.toDoList = new ArrayList<ToDoItem>();
    }
    public ToDoList(String title, ArrayList<ToDoItem> t){
        this.title = title;
        this.toDoList = t;
    }
    public ToDoList(ToDoList t){
        this.title=t.title;
        this.toDoList = new ArrayList<>();
        for(int x=0;x<t.toDoList.size();x++){
            this.toDoList.add(new ToDoItem(t.toDoList.get(x)));//have to make sure all references are NOT stepping on each other
        }
    }

    //toDoList.add(t)
    public void addItem(ToDoItem t){
            toDoList.add(t);
    }

    //return toDoList.remove(index)
    public ToDoItem removeItem(int index){

           return toDoList.remove(index);
    }

    //this.title=s
    public void setTitle(String s){
        this.title=s;
    }

    //toDoList.get(index).setDescription(s)
    public void editToDoItemDesc(int index,String s){
        toDoList.get(index).setDescription(s);

    }

    //toDoList.get(index).setDate(d)
    public void editToDoItemDueDate(int index, LocalDate d){
        toDoList.get(index).setDueDate(d);
    }

    //toDoList.get(index).markAsComplete()
    public void markItemAsComplete(int index){
        toDoList.get(index).markAsComplete();
    }

    //toDoList.get(index).markAsIncomplete()
    public void markItemAsIncomplete(int index){
        toDoList.get(index).markAsIncomplete();
    }

    //Gson gson = new Gson()
    //gson.toJson(this, new FileWriter(path))
    //return gson.toJson(this)
    public String saveToDoList(String path) throws IOException { //saves a to do list to the path given
        File f = new File(path);
        f.getParentFile().mkdirs();
        if(!f.exists()){
            f.createNewFile();
        }
        ToDoList t = replaceInDesc(new ToDoList(this)," ","\n");//this sadly must be done because after an hour and a half of
        //stack overflow there is no way I can save the spaces in a string desc without making my own deserializer, which was not
        //worth
        Gson gson = new Gson();
        FileWriter fw= new FileWriter(path);
        String s= gson.toJson(t);
        fw.write(s);
        fw.close();
        return s;
    }

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
    public ToDoList loadToDoList(String path) throws FileNotFoundException {//loads the to do list using the path given
        String jsonString =getJsonString(path);
        if(jsonString.equals("-1")){
            return new ToDoList();
        }
        Gson gson = new Gson();
        ToDoList t = gson.fromJson(jsonString, ToDoList.class);
        ToDoList spacesInDesc=replaceInDesc(t,"\n"," ");//all enters (which cant be entered in a desc field) are converted to spaces from the save
        addToDoListItemsToCurrentList(spacesInDesc);
        return spacesInDesc;
    }

    /*
    String s = " "
    FIle f = new File(path)
    Scanner sc = new Scanner(f)
    while sc.hasNext()
        s += sc.next()
    end loop
    return s
    */
    public String getJsonString(String path) throws FileNotFoundException {
        String s = "";
        try {
            File f = new File(path);
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()){
                s += sc.next();
            }
        }
        catch (FileNotFoundException ex){
            return "-1";
        }
        return s;

    }
    /*
        ToDoList t1 = new ToDoList(t)
        for x = 0, x<t1.toDoList.size(), x++
            t1.toDoList.get(x).description = t1.toDoList.get(x).description.replaceAll(lf, replaced)
        end loop
        return t1
    */
    public ToDoList replaceInDesc(ToDoList t,String lookingFor, String replaced){
        ToDoList sendToJSON= new ToDoList(t);
        for(int x=0;x<sendToJSON.toDoList.size();x++){
            sendToJSON.toDoList.get(x).description=sendToJSON.toDoList.get(x).description.replaceAll(lookingFor,replaced);
        }
        return  sendToJSON;
    }
    // for ToDoItem x in t
    //     this.addItem(x)
    //  end loop
    public void addToDoListItemsToCurrentList(ToDoList t){
        for(int x=0;x<t.toDoList.size();x++){
            this.addItem(t.toDoList.get(x));
        }
    }
    //this.toDoList.clear
    public void clearAllItems(){
            this.toDoList.clear();
    }
}