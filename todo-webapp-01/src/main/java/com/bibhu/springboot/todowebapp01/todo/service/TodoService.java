package com.bibhu.springboot.todowebapp01.todo.service;

import com.bibhu.springboot.todowebapp01.todo.model.Todo;
import com.bibhu.springboot.todowebapp01.todo.repo.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> findByUsername(String username) {
        List<Todo> todos = todoRepository.findByUsername(username);
        return todos.stream()
                .filter(todo -> todo.getUsername().equalsIgnoreCase(username))
                .collect(Collectors.toList());
    }

    public void addNewTodo(ModelMap model, Todo todo) {
        String username = (String) model.get("name");
        todoRepository.save(new Todo(username, todo.getDescription(), todo.getTargetDate(), todo.getCompleted()));
    }

    public void deleteTodoById(long id) {
        todoRepository.deleteById(id);
    }

    public Todo findById(long id) {
        return todoRepository.findById(id).get();
    }

    public void updateTodo(Todo todo) {
        todoRepository.save(todo);
        //deleteTodoById(todo.getId());
       // todos.add(todo);
    }
}

