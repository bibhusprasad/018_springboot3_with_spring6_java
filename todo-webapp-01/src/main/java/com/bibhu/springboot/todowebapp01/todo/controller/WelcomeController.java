package com.bibhu.springboot.todowebapp01.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {

    @GetMapping("/")
    public String gotoWelcomePage(ModelMap model){
        model.put("name", "bibhu-hc");
        return "welcome";
    }
}
