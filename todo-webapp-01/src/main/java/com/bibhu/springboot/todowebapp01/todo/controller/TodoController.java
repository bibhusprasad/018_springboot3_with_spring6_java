package com.bibhu.springboot.todowebapp01.todo.controller;

import com.bibhu.springboot.todowebapp01.todo.model.Todo;
import com.bibhu.springboot.todowebapp01.todo.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
        String username = (String) modelMap.get("name");
        List<Todo> todos = todoService.findByUsername(username);
        modelMap.put("todos", todos);
        return "todosList";
    }

    @GetMapping("add-todo")
    public String showNewTodoPage(ModelMap model){
        String username = (String) model.get("name");
        Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), "No");
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
    public String updateToPage(ModelMap model, @Valid Todo todo, BindingResult result) {
        if(result.hasErrors()){
            return "addTodos";
        }
        String username = (String)model.get("name");
        todo.setUsername(username);
        todoService.updateTodo(todo);
        return "redirect:todos-list";
    }

}
