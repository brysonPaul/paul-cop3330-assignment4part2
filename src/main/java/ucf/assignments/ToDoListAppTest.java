package ucf.assignments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Bryson Paul
 */
class ToDoListAppTest {

    //toDoListItem
    @Test
    void setDescription() {
        /*
            ToDoItem i = new ToDoItem(wrong,new Date())
            String hold = "right!"
            i.setDescription(hold)
            assertEqual(i.description,"right!")
        */
    }
    //toDoListItem
    @Test
    void setDueDate() {
        /*
            ToDoItem i = new ToDoItem(wrong,new Date())
            Date d= new Date("11/19/2001")
            i.setDueDate(d)
            assertEqual(d,i.date)
        */
    }
    //toDoListItem
    @Test
    void markAsComplete() {
        /*
            ToDoItem i = new ToDoItem(wrong,new Date())//defaults to false
            String hold = "right!"
            i.markAsComplete()
            assertEqual(i.isComplete)
        */
    }



    //toDoList
    @Test
    void addItem() {
        /*
            toDoList list = new toDoList()
            list.addItem(new toDoItem("do the dishes"))
            assertEqual(list.toDoList.size,1)
         */
    }
    //toDoList
    @Test
    void removeItem() {
        /*
            toDoList list = new toDoList()
            list.addItem(new toDoItem("do the dishes",//date stuff))
            list.addItem(new toDoItem("walk dog",//date stuff))
            toDoItem i = list.removeItem(0);
            assertEqual(list.toDoList.size,1)
            assertEqual(i.description,"do the dishes")
         */
    }
    //toDoList
    @Test
    void setTitle() {
         /*
            ToDoItem i = new ToDoList("wrong")
            String hold = "right!"
            i.setTitle(hold)
            assertEqual(i.title,"right!")
        */
    }
    //toDoList
    @Test
    void editToDoItemDesc() {
        /*
            toDoList list = new toDoList()
            list.addItem(new toDoItem("do the dishes",//date stuff))
            list.addItem(new toDoItem("walk dog",//date stuff))
            list.editToDoItemDesc(0,"walk the dishes")
            list.editToDoItemDesc(1,"clean the alligator")
            assertEqual(list.toDoList.size,2)
            assertEqual(list.toDoList.get(0).description,"walk the dishes")
            assertEqual(list.toDoList.get(1).description,"clean the alligator")
         */
    }
    //toDoList
    @Test
    void editToDoItemDueDate() {
        /*
            toDoList list = new toDoList()
            list.addItem(new toDoItem("do the dishes",//date stuff))
            list.addItem(new toDoItem("walk dog",//date stuff))
            list.editToDoItemDueDate(0,new Date("12/2/2007"))
            list.editToDoItemDueDate(1,new Date("11/19/2001"))
            assertEqual(list.toDoList.size,2)
            assertEqual(list.toDoList.get(0).dueDate,new Date("12/2/2007"))
            assertEqual(list.toDoList.get(1).dueDate,new Date("11/19/2001"))
         */
    }
    //toDoList
    @Test
    void markItemAsComplete() {
        /*
            toDoList list = new toDoList()
            list.addItem(new toDoItem("do the dishes",//date stuff))
            list.addItem(new toDoItem("walk dog",//date stuff))
            list.markItemAsComplete(0)
            assertEqual(list.toDoList.size,2)
            assertFalse(list.toDoList.get(0).isComplete)
            assertTrue(list.toDoList.get(1).isComplete)
         */
    }
    //toDoList
    @Test
    void sortByCompleteItems() {
        /*
         toDoList list = new toDoList()
         list.addItem(new toDoItem("do the dishes",//date stuff))
         list.addItem(new toDoItem("walk dog",//date stuff))
         list.addItem(new toDoItem("get groceries",//date stuff))
         list.markItemAsComplete(1)
         ArrayList hold = list.sortByCompleteItems()
         assertEqual(hold.size(),1)
         assertEqual(hold.get(0).description,"walk dog")
         */
    }
    //toDoList
    @Test
    void sortByIncompleteItems() {
        /*
         toDoList list = new toDoList()
         list.addItem(new toDoItem("do the dishes",//date stuff))
         list.addItem(new toDoItem("walk dog",//date stuff))
         list.addItem(new toDoItem("get groceries",//date stuff))
         list.markItemAsComplete(1)
         ArrayList hold = list.sortByIncompleteItems()
         assertEqual(hold.size(),2)
         assertEqual(hold.get(0).description,"do the dishes")
         assertEqual(hold.get(1).description,"get groceries")
         */
    }
    //toDoList
    @Test
    void saveToDoList() {//TESTS BOTH SAVING AND LOADING TECHNICALLY, ONLY ONE TEST
        /*
         toDoList list = new toDoList()
         list.addItem(new toDoItem("do the dishes",//date stuff))
         list.addItem(new toDoItem("walk dog",//date stuff))
         list.addItem(new toDoItem("get groceries",//date stuff))
         list.save("test.json")
         ToDoList a = list.load("test.json")

         assertEquals(a.size(),list.toDoList.size())
         for x=0;x<a.length;x++
            assertEquals(a.toDoList.get(x).description,list.toDoList.get(x).description)
            assertEquals(a.toDoList.get(x).dueDate,list.toDoList.get(x).dueDate)
            end loop
         */
    }
    //toDoListManager
    @Test
    void addToDoList() {
        /*
        ToDoListManager t = new ToDoListManager()
        t.addToDoList(new ToDoList("testing"))
        t.addToDoList(new ToDoList("testing"))
        t.addToDoList(new ToDoList("testing"))
        assertEquals(t.toDoLists.size(),3)
         */
    }
    //toDoListManager
    @Test
    void removeToDoList() {
        /*
        ToDoListManager t = new ToDoListManager()
        t.addToDoList(new ToDoList("testing 1 "))
        t.addToDoList(new ToDoList("testing 2 "))
        t.addToDoList(new ToDoList("testing 3"))
        ToDoList hold = t.removeToDoList(1)
        assertEquals(hold.title,"testing 2")

        assertEquals(t.toDoLists.size(),2)
        assertEquals(t.toDoLists.get(0).title,"testing 1")
        assertEquals(t.toDoLists.get(1).title,"testing 3")
         */
    }
    //toDoListManager
    @Test
    void editToDoListTitle() {
        /*
        ToDoListManager t = new ToDoListManager()
        t.addToDoList(new ToDoList("testing 1 "))
        t.addToDoList(new ToDoList("testing 2 "))
        t.addToDoList(new ToDoList("testing 3"))
        t.editToDoListTitle(0,"sleeping")
        t.editToDoListTitle(1,"is")
        t.editToDoListTitle(2,"great")

        assertEquals(t.toDoLists.get(0).title,"sleeping")
        assertEquals(t.toDoLists.get(1).title,"is")
        assertEquals(t.toDoLists.get(2).title,"great")
         */
    }
    //toDoListManager
    @Test
    void addItemToToDoList() {
        /*
        ToDoListManager t = new ToDoListManager()
        t.addToDoList(new ToDoList("testing 1 "))
        t.addToDoList(new ToDoList("testing 2 "))
        t.addToDoList(new ToDoList("testing 3"))

        t.addItemToToDoList(1,new ToDoItem("e",new Date()))
        t.addItemToToDoList(2,new ToDoItem("f",new Date()))
        t.addItemToToDoList(2,new ToDoItem("g",new Date()))

        assertEqual(t.toDoLists.get(0).toDoList,0)
        assertEqual(t.toDoLists.get(1).toDoList,1)
        assertEqual(t.toDoLists.get(2).toDoList,2)

        assertEqual(t.toDoLists.get(1).toDoList(0),"e")
        assertEqual(t.toDoLists.get(2).toDoList(0),"f")
        assertEqual(t.toDoLists.get(2).toDoList(1),"g")

        */
    }
    //toDoListManager
    @Test
    void removeItemFromToDoList() {
        /*
        ToDoListManager t = new ToDoListManager()
        t.addToDoList(new ToDoList("testing 1 "))
        t.addToDoList(new ToDoList("testing 2 "))
        t.addToDoList(new ToDoList("testing 3"))

        t.addItemToToDoList(1,new ToDoItem("e",new Date()))
        t.addItemToToDoList(2,new ToDoItem("f",new Date()))
        t.addItemToToDoList(2,new ToDoItem("g",new Date()))

        t.removeItemFromToDoList(2,1)
        t.removeItemFromToDoList(1,0);

        assertEqual(t.toDoLists.get(0).toDoList,0)
        assertEqual(t.toDoLists.get(1).toDoList,0)
        assertEqual(t.toDoLists.get(2).toDoList,1)

        assertEqual(t.toDoLists.get(2).toDoList(0),"g")
         */
    }
    //toDoListManager
    @Test
    void saveAndLoadSingleToDoList() {//contains saving and loading tests
        /*
         ToDoListManager tm= new ToDoListManager()

         toDoList list = new toDoList()
         list.addItem(new toDoItem("do the dishes",//date stuff))
         list.addItem(new toDoItem("walk dog",//date stuff))
         list.addItem(new toDoItem("get groceries",//date stuff))
         tm.addToDoList(list)

         tm.saveSingleToDoList(0,"test.txt")
         toDoList testList = loadSingleToDoList("test.txt")

         assertEquals(testList.toDoList.size(),tm.toDoLists.get(0).toDoList.size())
         for x=0;x<a.length;x++
            assertEquals(testList.toDoList.get(x).description, tm.get(0).toDoList.get(x).description)
            assertEquals(testList.toDoList.get(x).dueDate, tm.get(0).toDoList.get(x).dueDate)
            end loop
         */
    }
    //toDoListManager
    @Test
    void saveAndLoadAllToDoLists() {//contains saving and loading tests
        /*
             ToDoListManager tm = new ToDoListManager()
             toDoList list = new toDoList()
             list.addItem(new toDoItem("do the dishes",//date stuff))
             list.addItem(new toDoItem("walk dog",//date stuff))
             list.addItem(new toDoItem("get groceries",//date stuff))
             tm.addToDoList(list)

             tm.saveALlToDoLists("testAll.txt")
             ToDoListManager test = tm.loadAllToDoLists("testAll.txt")
             assertEquals(s.toDoLists.size(),tm.toDoLists.size())
             assertEquals(s.toDoLists(0).size(),tm.toDoLists(0).size())

             for x=0;x<a.length;x++
                assertEquals(test.toDoLists.get(0).toDoList.get(x).description, tm.toDoLists.get(0).toDoList.get(x).description)
                assertEquals(test.toDoLists.get(0).toDoList.get(x).dueDate, tm.toDoLists.get(0).toDoList.get(x).dueDate)
            end loop

         */
    }
}