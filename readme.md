hey reader! To start, just wanted to say thanks for taking
time out to look at this! Your work does not go unappreciated,
and I appreciate your time. 

For this application, we have a basic
to do list which allows you to add, remove, save, and edit to
do list items. Lets go through each behavior

1. This  app is able to hold much more than 100 items and manage them with ease
   
   - I utilized a dynamically scaling anchorpane to always allow the user to scroll to see each of the items created!

2. When an item is created, you can see that the description field is a bit small to hold all 256 possible characters

    - To see all characters in a description, simply hit the button and another screen will appear allowing you to read it all if needed


3. The due date is already in the correct format of YYYY-MM-DD through the DatePicker's local data toString() method
   
    - This is good, because the only way to change the date is through JFX's DatePicker!


4. To add an item to the list from the first screen, hit the + button in the top right

   - Then, add in a due date and description in the respective fields and hit create

   - If both a description and due date are not entered, it does not make the item

   - If you decide to not make the item, hit cancel and it will lead you back to the main menu


5. To remove an item in the list, simply hit the "-" button on the far right of every single ilist item created!


6. To clear every single item in the list, click the "clear all" button in the top right


 7-8. To edit a description or due date of the item, click the "Edit " button on any to do item.
    This will take you to the Edit Item screen, where you can enter either the description or due date you want to change.
    If you only choose one, that is fine, as the program will only fill the fields that were edited\
 
9. To mark an item as complete or incomplete, click the radio button on the left side of any button
    
    - All items are by default set as incomplete


10. To display all existing items, click the "Sort By" button in the top right

    - In the Sort By Screen, click "Sort by all existing items"
    - When you go back to the main screen, all items will be shown 


11. To display all complete items, click the "Sort By" button in the top right

    - In the Sort By Screen, click "Sort by all completed items"
    - When you go back to the main screen, the only items shown will be completed items 


12. To display all incomplete items, click the "Sort By" button in the top right

    - In the Sort By Screen, click "Sort by all incomplete items"
    - When you go back to the main screen, the only items shown will be incomplete items


13. To save the list made to storage, click the "Save" button in the top left
    
    - if it worked, you should see the "Save" button change to "Saved"
    - The file is saved on the user's Desktop, in a folder known as "Saves"


14. To load a list made to storage, click the "Load" button in the top left

    - if it worked, you should see all lists in the application when the Save button was clicked
    - If it is clicked when nothing is in the save or there is no Save folder, nothing happens


I hope you liked the application, and have an amazing rest of your day! Take care