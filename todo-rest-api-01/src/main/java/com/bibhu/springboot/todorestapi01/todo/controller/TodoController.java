package com.bibhu.springboot.todorestapi01.todo.controller;

import com.bibhu.springboot.todorestapi01.todo.model.Todo;
import com.bibhu.springboot.todorestapi01.todo.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    public List<Todo> findAllTodosByUsername(@PathVariable String username) {
        return todoService.findByUsername(username);
    }

    @GetMapping("/users/{username}/todos/{id}")
    public Todo findTodoByUserId(@PathVariable String username, @PathVariable long id) {
        return todoService.findById(id);
    }

    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodoByUserId(@PathVariable String username, @PathVariable long id) {
        todoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
