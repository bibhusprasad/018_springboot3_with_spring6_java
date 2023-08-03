package com.bibhu.springboot.todowebapp01.todo.service;

import com.bibhu.springboot.todowebapp01.todo.model.Todo;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {

    private static List<Todo> todos;

    static {
        todos = new ArrayList<>();
        todos.add(new Todo(1L, "AAA", "LearnAws", LocalDate.now().plusYears(1), "No"));
        todos.add(new Todo(2L, "AAA", "LearnAzure", LocalDate.now().plusYears(2), "No"));
        todos.add(new Todo(3L, "AAA", "LearnGCP", LocalDate.now().plusYears(3), "No"));
        todos.add(new Todo(1L, "BBB", "LearnAws", LocalDate.now().plusYears(1), "No"));
        todos.add(new Todo(2L, "BBB", "LearnAzure", LocalDate.now().plusYears(2), "No"));
        todos.add(new Todo(3L, "BBB", "LearnGCP", LocalDate.now().plusYears(3), "No"));
    }

    public List<Todo> findAllTodos() {
        return todos;
    }

    public List<Todo> findByUsername(String username) {
        return todos.stream()
                .filter(todo -> todo.getUsername().equalsIgnoreCase(username))
                .collect(Collectors.toList());
    }

    public void addNewTodo(ModelMap model, Todo todo) {
       // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
       // LocalDate localDate = LocalDate.parse(targetDate, formatter);
        String username = (String) model.get("name");
        //boolean isDone = done.equalsIgnoreCase("yes");
        List<Todo> todosByUsername = findByUsername(username);
        todos.add(new Todo(todosByUsername.size()+1, username, todo.getDescription(), LocalDate.now().plusYears(1), todo.getCompleted()));
    }
}

