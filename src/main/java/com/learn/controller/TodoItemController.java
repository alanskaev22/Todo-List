        package com.learn.controller;

        import com.learn.model.TodoData;
        import com.learn.model.TodoItem;
        import com.learn.service.TodoItemService;
        import com.learn.util.AttributeNames;
        import com.learn.util.Mappings;
        import com.learn.util.ViewNames;
        import lombok.extern.slf4j.Slf4j;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.ModelAttribute;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.bind.annotation.RequestParam;

        import java.time.LocalDate;

        @Slf4j
        @Controller
        public class TodoItemController {

          private final TodoItemService todoItemService;

          @Autowired
          public TodoItemController(TodoItemService todoItemService) {
            this.todoItemService = todoItemService;
          }

          // == model attributes ==
          @ModelAttribute
          public TodoData todoData() {
            return todoItemService.getTodoData();
          }

          // http://localhost:8080/Todo-List/items
          @GetMapping(Mappings.ITEMS)
          public String items() {
            return ViewNames.ITEMS_LIST;
          }

          @GetMapping(Mappings.ADD_ITEM)
          public String addEditItem(
              @RequestParam(required = false, defaultValue = "-1") int id, Model model) {
            log.info("Editing item with id {}", id);
            TodoItem todoItem = todoItemService.getItem(id);
            if (todoItem == null) {
              todoItem = new TodoItem("", "", LocalDate.now());
            }
            model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
            return ViewNames.ADD_ITEM;
          }

          @PostMapping(Mappings.ADD_ITEM)
          public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) TodoItem todoItem) {
            log.info("to do item from form = {}", todoItem);
            if(todoItem.getId() == 0){
            todoItemService.addItem(todoItem);
            }else {
                todoItemService.updateItem(todoItem);
            }
            return "redirect:/" + Mappings.ITEMS;
          }

          @GetMapping(Mappings.DELETE_ITEM)
          public String deleteItem(@RequestParam int id) {
            log.info("Deleting id {}", id);
            todoItemService.removeItem(id);
            return "redirect:/" + Mappings.ITEMS;
          }

          @GetMapping(Mappings.VIEW_ITEM)
            public String viewItem(@RequestParam int id, Model model){
              TodoItem todoItem = todoItemService.getItem(id);
              model.addAttribute(AttributeNames.TODO_ITEM, todoItem);

              return ViewNames.VIEW_ITEM;
          }
        }
