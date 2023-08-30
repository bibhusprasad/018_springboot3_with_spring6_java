package com.bibhu.springboot.todorestapi01.todo.service;

import com.bibhu.springboot.todorestapi01.todo.model.Todo;
import com.bibhu.springboot.todorestapi01.todo.repo.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> findByUsername(String username){
        return todoRepository.findByUsername(username);
    }

    public Todo addTodo(Todo todo) {
        Todo newTodo =
                new Todo(todo.getUsername(),
                        todo.getDescription(),
                        todo.getTargetDate(),
                        todo.isCompleted());
        return todoRepository.save(newTodo);
    }

    public void deleteById(long id) {
        todoRepository.deleteById(id);
    }

    public Todo findById(long id) {
        return todoRepository.findById(id).get();
    }

    public void updateTodo(Todo todo) {
        deleteById(todo.getId());
        todoRepository.save(todo);
    }

}
