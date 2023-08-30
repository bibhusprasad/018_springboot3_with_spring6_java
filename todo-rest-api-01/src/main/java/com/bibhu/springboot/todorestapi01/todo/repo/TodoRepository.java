package com.bibhu.springboot.todorestapi01.todo.repo;

import com.bibhu.springboot.todorestapi01.todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByUsername(String username);
}
