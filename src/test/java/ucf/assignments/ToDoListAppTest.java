package ucf.assignments;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Bryson Paul
 */
class ToDoListAppTest {

    //toDoListItem
     /*
            ToDoItem i = new ToDoItem(wrong,new Date())
            String hold = "right!"
            i.setDescription(hold)
            assertEqual(i.description,"right!")
    */
    @Test
    void setDescription() {
            ToDoItem i = new ToDoItem("wrong");
            String hold = "right!";
            i.setDescription(hold);
            assertEquals(i.description,"right!");
    }

    //toDoListItem
      /*
            ToDoItem i = new ToDoItem(wrong,new Date())
            Date d= new Date("11/19/2001")
            i.setDueDate(d)
            assertEqual(d,i.date)
      */
    @Test
    void setDueDate() {
            ToDoItem i = new ToDoItem("wrong","");
            LocalDate d = LocalDate.now();//my birthday!
            i.setDueDate(d);
            assertEquals(i.dueDate,LocalDate.now().toString());
    }

    //toDoListItem
    /*
            ToDoItem i = new ToDoItem(wrong,new Date())//defaults to false
            String hold = "right!"
            i.markAsComplete()
            assertTrue(i.isComplete)
     */
    @Test
    void markAsComplete() {
            ToDoItem i = new ToDoItem("wrong");//defaults to false in the constructor
            i.markAsComplete();
            assertTrue(i.isComplete);
    }

    //toDoListItem
    /*
            ToDoItem i = new ToDoItem(wrong,new Date())//defaults to false
            String hold = "right!"
            i.markAsComplete()
            assertTrue(i.isComplete)
            i.markAsIncomplete()
            assertFalse(i.isComplete)
     */
    @Test
    void markAsIncomplete() {
        ToDoItem i = new ToDoItem("wrong");//defaults to false in the constructor
        i.markAsComplete();
        assertTrue(i.isComplete);
        i.markAsIncomplete();
        assertFalse(i.isComplete);
    }

    //toDoList
    /*
            toDoList list = new toDoList()
            list.addItem(new toDoItem("do the dishes"))
            assertEqual(list.toDoList.size,1)
     */
    @Test
    void addItem() {
            ToDoList list = new ToDoList();
            list.addItem(new ToDoItem("do the dishes"));
            assertEquals(list.toDoList.size(),1);//shows that an item was added
            assertEquals(list.toDoList.get(0).description,"do the dishes");
    }

    //toDoList
     /*
            toDoList list = new toDoList()
            list.addItem(new toDoItem("do the dishes",//date stuff))
            list.addItem(new toDoItem("walk dog",//date stuff))
            toDoItem i = list.removeItem(0);
            assertEqual(list.toDoList.size,1)
            assertEqual(i.description,"do the dishes")
      */
    @Test
    void removeItem() {
            ToDoList list = new ToDoList();
            list.addItem(new ToDoItem("do the dishes"));
            list.addItem(new ToDoItem("walk dog"));
            ToDoItem item = list.removeItem(0);
            assertEquals(list.toDoList.size(),1);
            assertEquals(item.description,"do the dishes");
    }

    //toDoList
    /*
            ToDoItem i = new ToDoList("wrong")
            String hold = "right!"
            i.setTitle(hold)
            assertEqual(i.title,"right!")
        */
    @Test
    void setTitle() {
            ToDoList i = new ToDoList("wrong");
            String hold = "right!";
            i.setTitle(hold);
            assertEquals(i.title,"right!");
    }

    //toDoList
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
    @Test
    void editToDoItemDesc() {
            ToDoList list = new ToDoList();
            list.addItem(new ToDoItem("do the dishes"));
            list.addItem(new ToDoItem("walk dog"));
            list.editToDoItemDesc(0,"walk the dishes");
            list.editToDoItemDesc(1,"clean the alligator");
            assertEquals(list.toDoList.size(),2);
            assertEquals(list.toDoList.get(0).description,"walk the dishes");
            assertEquals(list.toDoList.get(1).description,"clean the alligator");
    }

    //toDoList
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
    @Test
    void editToDoItemDueDate() {
            ToDoList list = new ToDoList();
            list.addItem(new ToDoItem("do the dishes"));
            list.editToDoItemDueDate(0,LocalDate.now());
            assertEquals(list.toDoList.size(),1);
            assertEquals(list.toDoList.get(0).dueDate,LocalDate.now().toString());
    }

    //toDoList
     /*
            toDoList list = new toDoList()
            list.addItem(new toDoItem("do the dishes",//date stuff))
            list.addItem(new toDoItem("walk dog",//date stuff))
            list.markItemAsComplete(0)
            assertEqual(list.toDoList.size,2)
            assertFalse(list.toDoList.get(0).isComplete)
            assertTrue(list.toDoList.get(1).isComplete)
     */
    @Test
    void markItemAsComplete() {
            ToDoList list = new ToDoList();
            list.addItem(new ToDoItem("do the dishes"));
            list.addItem(new ToDoItem("walk dog"));
            list.markItemAsComplete(0);
            assertEquals(list.toDoList.size(),2);
            assertTrue(list.toDoList.get(0).isComplete);
            assertFalse(list.toDoList.get(1).isComplete);
    }

    //toDoList
     /*
            toDoList list = new toDoList()
            list.addItem(new toDoItem("do the dishes",//date stuff))
            list.addItem(new toDoItem("walk dog",//date stuff))
            list.markItemAsComplete(0)
            assertEqual(list.toDoList.size,2)
            assertFalse(list.toDoList.get(0).isComplete)
            assertTrue(list.toDoList.get(1).isComplete)
            list.markItemAsIncomplete(0)
            assertFalse(list.toDoList.get(0).isComplete)
     */
    @Test
    void markItemAsIncomplete(){
        ToDoList list = new ToDoList();
        list.addItem(new ToDoItem("do the dishes"));
        list.addItem(new ToDoItem("walk dog"));
        list.markItemAsComplete(0);
        assertEquals(list.toDoList.size(),2);
        assertTrue(list.toDoList.get(0).isComplete);
        assertFalse(list.toDoList.get(1).isComplete);
        list.markItemAsIncomplete(0);
        assertFalse(list.toDoList.get(0).isComplete);
    }

    /*
        t = new ToDoList()
        t.tile = "test"
        t.toDoList.add(new ToDoItem("hello","12-3-2022",true))//complete
        t.toDoList.add(new ToDoItem("a","11-3-2023"))
        t.toDoList.add(new ToDoItem("b","1-6-2021",true))//complete
        t.toDoList.add(new ToDoItem("cdefg","2-20-2122",true))//complete
        t.toDoList.add(new ToDoItem("other words","7-5-2025"))
        t.toDoList.add(new ToDoItem("walk penguin","9-2-2012",true))//complete

     */
    ToDoList createTestToDoList(){
        ToDoList t = new ToDoList();
        t.title="test";
        t.toDoList.add(new ToDoItem("hello","12-3-2022"));//complete
        t.toDoList.add(new ToDoItem("a","11-3-2023"));
        t.toDoList.add(new ToDoItem("b","1-6-2021"));//complete
        t.toDoList.add(new ToDoItem("cdefg","2-20-2122"));//complete
        t.toDoList.add(new ToDoItem("other words","7-5-2025"));
        t.toDoList.add(new ToDoItem("walk penguin","9-2-2012"));//complete

        t.toDoList.get(0).markAsComplete();
        t.toDoList.get(2).markAsComplete();
        t.toDoList.get(3).markAsComplete();
        t.toDoList.get(5).markAsComplete();
        return t;
    }

    //from ToDoListViewController (sorting is integrated with displaying)
    /*
        ToDoList t = createTestToDoList()//index 0,2,3, and 5 should be in the sorted for complete
        ToDoListViewController c= new ToDoListViewController()
        ArrayList<ToDoItem> completedItems = c.displayToDoList(t,1)
        //here there would be checks with the arraylist and what should be in here if it is sorted by complete items
        ArrayList<ToDoItem> incompleteItems = c.displayToDoList(t,2)
        //here there would be checks with the arraylist and what should be in here if it is sorted by incomplete items
     */
    //TESTS THE SORTING OF SORTING BY ALL ITEMS, INCOMPLETE ITEMS, AND COMPLETE ITEMS
    @Test
    void testSorting(){
        ToDoList t = createTestToDoList();//index 0,2,3, and 5 should be in the sorted for complete
        ToDoListViewController c= new ToDoListViewController();

        ArrayList<ToDoItem> allItems = c.displayToDoList(t,0);//looking at all items
        assertEquals(allItems.size(),6);
        assertEquals(allItems.get(0).description,"hello");
        assertEquals(allItems.get(1).description,"a");
        assertEquals(allItems.get(2).description,"b");
        assertEquals(allItems.get(3).description,"cdefg");
        assertEquals(allItems.get(4).description,"other words");
        assertEquals(allItems.get(5).description,"walk penguin");
        assertEquals(allItems.get(0).dueDate,"12-3-2022");
        assertEquals(allItems.get(1).dueDate,"11-3-2023");
        assertEquals(allItems.get(2).dueDate,"1-6-2021");
        assertEquals(allItems.get(3).dueDate,"2-20-2122");
        assertEquals(allItems.get(4).dueDate,"7-5-2025");
        assertEquals(allItems.get(5).dueDate,"9-2-2012");
        assertEquals(allItems.get(0).isComplete,true);
        assertEquals(allItems.get(1).isComplete,false);
        assertEquals(allItems.get(2).isComplete,true);
        assertEquals(allItems.get(3).isComplete,true);
        assertEquals(allItems.get(4).isComplete,false);
        assertEquals(allItems.get(5).isComplete,true);


        ArrayList<ToDoItem> completedItems = c.displayToDoList(t,1);//Looking at complete items
        assertEquals(completedItems.size(),4);
        assertEquals(completedItems.get(0).description,"hello");
        assertEquals(completedItems.get(1).description,"b");
        assertEquals(completedItems.get(2).description,"cdefg");
        assertEquals(completedItems.get(3).description,"walk penguin");
        assertEquals(completedItems.get(0).dueDate,"12-3-2022");
        assertEquals(completedItems.get(1).dueDate,"1-6-2021");
        assertEquals(completedItems.get(2).dueDate,"2-20-2122");
        assertEquals(completedItems.get(3).dueDate,"9-2-2012");
        assertEquals(completedItems.get(0).isComplete,true);
        assertEquals(completedItems.get(1).isComplete,true);
        assertEquals(completedItems.get(2).isComplete,true);
        assertEquals(completedItems.get(3).isComplete,true);

        ArrayList<ToDoItem> incompleteItems = c.displayToDoList(t,2);//Looking at incomplete items
        assertEquals(incompleteItems.size(),2);
        assertEquals(incompleteItems.get(0).description,"a");
        assertEquals(incompleteItems.get(1).description,"other words");
        assertEquals(incompleteItems.get(0).dueDate,"11-3-2023");
        assertEquals(incompleteItems.get(1).dueDate,"7-5-2025");
        assertEquals(incompleteItems.get(0).isComplete,false);
        assertEquals(incompleteItems.get(1).isComplete,false);
    }

    //toDoList
    /*
        path = "path to test env"
        t = createTestList()
        s = t.saveToDoList(path)

        f = new File(path)
        assertTrue(f.exists)
        assertEquals(s.trim(),t.getJsonString(path).trim());
     */
    @Test
    void saveToDoList() throws IOException {
        String path = System.getProperty("user.dir")+System.getProperty("file.separator")+"test.txt";
        ToDoList t = createTestToDoList();
        String s = t.saveToDoList(path);

        File f= new File(path);
        assertTrue(f.exists());
        assertEquals(s.trim(),t.getJsonString(path).trim());
        loadToDoList();
        f.deleteOnExit();
    }

    //toDoList
    /*
        test = createTestToDoList()
        testPath = "pathToDirectory"
        f = new File(testPath)
        t1 = new ToDoList()
        t1.loadToDoList(path)
        for x=0;x<test.size();x++
            assertEqual(test.description,t1.description)
            assertEqual(test.dueDate,t1.dueDate)
            assertEqual(test.dueDate,t1.dueDate)
        end loop

     */
    void loadToDoList() throws IOException{
        ToDoList t = createTestToDoList();
        String path = System.getProperty("user.dir")+System.getProperty("file.separator")+"test.txt";
        File f = new File(path);
        ToDoList t1= new ToDoList();
        ToDoList madeFromJSON=t1.loadToDoList(path);
        //if all of these are the exact same, saving and loading are working perfectly
        // because the other one is made from the JSON created by save !
        for(int x=0;x<t.toDoList.size();x++){
            assertEquals(t.toDoList.get(x).description,madeFromJSON.toDoList.get(x).description);
            assertEquals(t.toDoList.get(x).dueDate,madeFromJSON.toDoList.get(x).dueDate);
            assertEquals(t.toDoList.get(x).isComplete,madeFromJSON.toDoList.get(x).isComplete);
        }
    }

    //ToDoList
    /*
        String path = "testPath"
        ToDoList t = createTestToDoList()
        String s1 = t.saveToDoList(path)
        String s2 = t.getJsonString(path)
        assertEquals(s1.trim(),s2.trim())
     */
    @Test
    void getJsonString() throws IOException {
        String path = System.getProperty("user.dir")+System.getProperty("file.separator")+"test.txt";
        ToDoList t = createTestToDoList();
        String s1 = t.saveToDoList(path);
        String s2 = t.getJsonString(path);
        assertEquals(s1.trim(),s2.trim());
        File f = new File(path);
        f.deleteOnExit();
    }

    //ToDoList
    /*
        ToDoList t1= createTestToDoList()
        ToDoList t2 = t1.replaceInDesc(t1," ","\n")
        assertEquals(t2.toDoList.get(0).description,"hello")
        assertEquals(t2.toDoList.get(4).description,"other\nwords")
        assertEquals(t2.toDoList.get(5).description,"walk\npenguin")
     */
    @Test
    void replaceInDesc() throws IOException{
        ToDoList t1= createTestToDoList();

        ToDoList t2 = t1.replaceInDesc(t1," ","\n");
        assertEquals(t2.toDoList.get(0).description,"hello");
        assertEquals(t2.toDoList.get(4).description,"other\nwords");//only descriptions with spaces
        assertEquals(t2.toDoList.get(5).description,"walk\npenguin");

    }

}