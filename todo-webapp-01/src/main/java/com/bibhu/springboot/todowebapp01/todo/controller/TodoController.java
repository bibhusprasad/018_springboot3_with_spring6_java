package com.bibhu.springboot.todowebapp01.todo.controller;

import com.bibhu.springboot.todowebapp01.todo.model.Todo;
import com.bibhu.springboot.todowebapp01.todo.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("todos-list")
    public String listAllTodosByUsername(ModelMap modelMap) {
        List<Todo> todos = todoService.findByUsername(getLoggedInUsername());
        modelMap.put("todos", todos);
        return "todosList";
    }

    @GetMapping("add-todo")
    public String showNewTodoPage(ModelMap model){
        Todo todo = new Todo(0, getLoggedInUsername(), "", LocalDate.now().plusYears(1), "No");
        model.put("todo", todo);
        return "addTodos";
    }

    @PostMapping("add-todo")
    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result){
        if(result.hasErrors()){
            return "addTodos";
        }
        todoService.addNewTodo(model, todo);
        return "addTodos";
    }

    @GetMapping("delete-todo")
    public String deleteTodo(@RequestParam long id) {
        todoService.deleteTodoById(id);
        return "redirect:todos-list";
    }

    @GetMapping("update-todo")
    public String showUpdateToPage(@RequestParam long id, ModelMap model) {
        Todo todoById = todoService.findById(id);
        model.put("todo", todoById);
        return "addTodos";
    }

    @PostMapping("update-todo")
    public String updateToPage(@Valid Todo todo, BindingResult result) {
        if(result.hasErrors()){
            return "addTodos";
        }
        todo.setUsername(getLoggedInUsername());
        todoService.updateTodo(todo);
        return "redirect:todos-list";
    }

    private String getLoggedInUsername() {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

}
