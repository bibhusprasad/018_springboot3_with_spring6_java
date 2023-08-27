package com.bibhu.springboot.todorestapi01.todo.controller;

import com.bibhu.springboot.todorestapi01.todo.model.Todo;
import com.bibhu.springboot.todorestapi01.todo.service.TodoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/users/{username}/todos")
    public List<Todo> fetchAllTodosByUsername(@PathVariable String username) {
        return todoService.findByUsername(username);
    }
}
