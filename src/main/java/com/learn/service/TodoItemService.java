package com.learn.service;

import com.learn.model.TodoData;
import com.learn.model.TodoItem;

public interface TodoItemService {

  void addItem(TodoItem todoItem);

  void removeItem(int id);

  TodoItem getItem(int id);

  void updateItem(TodoItem todoItem);

  TodoData getTodoData();
}
