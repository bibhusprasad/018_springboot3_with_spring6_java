package com.bibhu.springboot.todowebapp01.todo.controller;

import com.bibhu.springboot.todowebapp01.todo.model.Todo;
import com.bibhu.springboot.todowebapp01.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("list-todos")
    public String listAllTodos(ModelMap modelMap) {
        List<Todo> todos = todoService.findAllTodos();
        modelMap.put("todos", todos);
        return "listTodos";
    }

}
