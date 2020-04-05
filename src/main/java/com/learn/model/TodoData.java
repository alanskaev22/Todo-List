package com.learn.model;

// Used to simulate database (in memory database)

import lombok.NonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class TodoData {

    // == fields ==
    private static int idValue = 1;
    private final List<TodoItem> items = new ArrayList<>();

    // == constructor ==
    public TodoData() {
        addItem(new TodoItem("First", "first details", LocalDate.now()));
        addItem(new TodoItem("Second", "second details", LocalDate.now()));
        addItem(new TodoItem("Third", "third details", LocalDate.now()));
    }

    // == public methods ==
    public List<TodoItem> getItems(){
        return Collections.unmodifiableList(items);
    }

    public void addItem(@NonNull TodoItem todoItem){   // Lombok @NonNull
        todoItem.setId(idValue);
        items.add(todoItem);
        idValue++;
    }

    public void removeItem(int id){
        ListIterator<TodoItem> itemIterator = items.listIterator();

        while (itemIterator.hasNext()){
            TodoItem item = itemIterator.next();
            if(item.getId() == id){
                itemIterator.remove();
                break;
            }
        }
    }

    public TodoItem getItem(int id){
        for(TodoItem item:items){
            if(item.getId() == id){
                return item;
            }
        }
        return null;
    }

    public void updateItem(@NonNull TodoItem todoItem){
        ListIterator<TodoItem> itemIterator = items.listIterator();

        while (itemIterator.hasNext()){
            TodoItem item = itemIterator.next();

            if (item.equals(todoItem)){
                itemIterator.set(todoItem);
            }
        }
    }
}
