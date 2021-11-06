package ucf.assignments;
import java.time.LocalDate;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Bryson Paul
 */
public class ToDoItem {
    public String description;
    public String dueDate;
    public boolean isComplete;
    public ToDoItem(String description ,String dueDate){
        this.description = description;
        this.dueDate = dueDate;
        this.isComplete = false;
    }
    public ToDoItem(String description){

        this.description = description;
        this.isComplete = false;
    }
    public ToDoItem(ToDoItem t){
        this.description=t.description;
        this.dueDate=t.dueDate;
        this.isComplete=t.isComplete;
    }

    //   this.description = s
    public void setDescription(String s){
         this.description = s;
    }

    // this.dueDate = d
    public void setDueDate(LocalDate d){
        this.dueDate = d.toString();
    }

    //this.isComplete = true
    public void markAsComplete(){

        this.isComplete = true;
    }

    //this.isComplete = false
    public void markAsIncomplete(){
        this.isComplete = false;
    }
}