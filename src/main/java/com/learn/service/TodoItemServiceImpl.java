package com.learn.service;

import com.learn.model.TodoData;
import com.learn.model.TodoItem;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
public class TodoItemServiceImpl implements TodoItemService {

    // == fields ==
    @Getter
    public final TodoData todoData = new TodoData();


    // == public methods ==
    @Override
    public void addItem(TodoItem todoItem) {
        todoData.addItem(todoItem);
    }

    @Override
    public void removeItem(int id) {
        todoData.removeItem(id);
    }

    @Override
    public TodoItem getItem(int id) {
        return todoData.getItem(id);
    }

    @Override
    public void updateItem(TodoItem todoItem) {
        todoData.updateItem(todoItem);
    }

}
