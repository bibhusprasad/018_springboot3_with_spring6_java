package com.bibhu.springboot.todowebapp01.todo.repo;

import com.bibhu.springboot.todowebapp01.todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    public List<Todo> findByUsername(String username);
}
