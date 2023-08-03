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
    private static int size = 0;

    static {
        todos = new ArrayList<>();
        todos.add(new Todo(1L, "AAA", "LearnAws", LocalDate.now().plusYears(1), "No"));
        todos.add(new Todo(2L, "AAA", "LearnAzure", LocalDate.now().plusYears(2), "No"));
        todos.add(new Todo(3L, "AAA", "LearnGCP", LocalDate.now().plusYears(3), "No"));
        todos.add(new Todo(4L, "BBB", "LearnAws", LocalDate.now().plusYears(1), "No"));
        todos.add(new Todo(5L, "BBB", "LearnAzure", LocalDate.now().plusYears(2), "No"));
        todos.add(new Todo(6L, "BBB", "LearnGCP", LocalDate.now().plusYears(3), "No"));
        size = todos.size();

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
        String username = (String) model.get("name");
        todos.add(new Todo(++size, username, todo.getDescription(), todo.getTargetDate(), todo.getCompleted()));
    }

    public void deleteTodoById(long id) {
        todos.removeIf(todo -> todo.getId() == id);
    }

    public Todo findById(long id) {
        return todos.stream().filter(todo -> todo.getId() == id).findFirst().get();
    }

    public void updateTodo(Todo todo) {
        deleteTodoById(todo.getId());
        todos.add(todo);
    }
}

