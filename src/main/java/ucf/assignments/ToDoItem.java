package ucf.assignments;

import java.util.Date;

/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Bryson Paul
 */
public class ToDoItem {
    public String description;
    public Date dueDate;
    public boolean isComplete;
    public ToDoItem(String title,Date dueDate){
        /*
        this.description = description
        this.dueDate = dueDate
        this.isComplete = false
         */
    }
    public void setDescription(String s){
        /*
         this.description = s
         */
    }
    public void setDueDate(Date d){
        /*
        this.dueDate = d
         */
    }
    public void markAsComplete(){
        /*
        this.isComplete = true
         */
    }
    public void display(){
        /*
            Gui.display(this.dueDate,this.date,this.isComplete)
         */
    }
}