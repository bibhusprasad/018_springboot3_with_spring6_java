package com.bibhu.springboot.todowebapp01.todo.controller;

import com.bibhu.springboot.todowebapp01.todo.model.Todo;
import com.bibhu.springboot.todowebapp01.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("all-todos-list")
    public String listAllTodos(ModelMap modelMap) {
        List<Todo> todos = todoService.findAllTodos();
        modelMap.put("todos", todos);
        return "todosList";
    }

    @GetMapping("todos-list")
    public String listAllTodosByUsername(ModelMap modelMap) {
        String username = (String) modelMap.get("name");
        List<Todo> todos = todoService.findByUsername(username);
        modelMap.put("todos", todos);
        return "todosList";
    }

    @GetMapping("add-todo")
    public String showNewTodoPage(){
        return "addTodos";
    }

    @PostMapping("add-todo")
    public String addNewTodo(@RequestParam String description,
                             @RequestParam String targetDate,
                             @RequestParam String done,
                             ModelMap model){
        todoService.addNewTodo(description, targetDate, done, model);
        return "addTodos";
    }

}
