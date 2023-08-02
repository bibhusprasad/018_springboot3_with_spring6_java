package com.bibhu.springboot.todowebapp01.todo.service;

import com.bibhu.springboot.todowebapp01.todo.model.Todo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    private static List<Todo> todos;

    static {
        todos = new ArrayList<>();
        todos.add(new Todo(1L, "AAA", "LearnAws", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(2L, "AAA", "LearnAzure", LocalDate.now().plusYears(2), false));
        todos.add(new Todo(3L, "AAA", "LearnGCP", LocalDate.now().plusYears(3), false));
        todos.add(new Todo(1L, "BBB", "LearnAws", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(2L, "BBB", "LearnAzure", LocalDate.now().plusYears(2), false));
        todos.add(new Todo(3L, "BBB", "LearnGCP", LocalDate.now().plusYears(3), false));
    }

    public List<Todo> findAllTodos() {
        return todos;
    }

    public List<Todo> findByUsername(String username) {
        return todos;
    }
}

