package com.bibhu.springboot.todorestapi01.todo.service;

import com.bibhu.springboot.todorestapi01.todo.model.Todo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
    private static final List<Todo> todos = new ArrayList<>();

    private static int todosCount = 0;

    static {
        todos.add(new Todo(++todosCount, "bibhu","Get AWS Certified",
                LocalDate.now().plusYears(10), false ));
        todos.add(new Todo(++todosCount, "bibhu","Learn DevOps",
                LocalDate.now().plusYears(11), false ));
        todos.add(new Todo(++todosCount, "bibhu","Learn Full Stack Development",
                LocalDate.now().plusYears(12), false ));
        todos.add(new Todo(++todosCount, "bibhu","Learn Spring boot",
                LocalDate.now().plusYears(12), false ));
    }

    public List<Todo> findByUsername(String username){
        Predicate<? super Todo> predicate =
                todo -> todo.getUsername().equalsIgnoreCase(username);
        return todos.stream().filter(predicate).toList();
    }

    public Todo addTodo(Todo todo) {
        Todo newTodo =
                new Todo(++todosCount,
                        todo.getUsername(),
                        todo.getDescription(),
                        todo.getTargetDate(),
                        todo.isCompleted());
        todos.add(newTodo);
        return newTodo;
    }

    public void deleteById(long id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }

    public Todo findById(long id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        return todos.stream().filter(predicate).findFirst().get();
    }

    public void updateTodo(Todo todo) {
        deleteById(todo.getId());
        todos.add(todo);
    }

}
