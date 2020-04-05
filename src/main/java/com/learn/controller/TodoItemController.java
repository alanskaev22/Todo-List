package com.learn.controller;

import com.learn.model.TodoData;
import com.learn.util.Mappings;
import com.learn.util.ViewNames;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class TodoItemController {

    // == model attributes ==
    @ModelAttribute
    public TodoData todoData(){
        return new TodoData();
    }

    // http://localhost:8080/Todo-List/items
    @GetMapping(Mappings.ITEMS)
    public String items(){
        return ViewNames.ITEMS_LIST;
    }
}
