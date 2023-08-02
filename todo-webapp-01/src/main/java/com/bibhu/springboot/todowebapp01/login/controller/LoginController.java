package com.bibhu.springboot.todowebapp01.login.controller;

import com.bibhu.springboot.todowebapp01.login.service.AuthenticateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {

    @Autowired
    private AuthenticateService authenticateService;

    @GetMapping("login")
    public String loginPage(){
        return "login";
    }

    @PostMapping("login")
    public String login(@RequestParam String name, @RequestParam String password, ModelMap model){
        if(authenticateService.validateUserCredential(name, password)){
            model.put("name", name);
            return "welcome";
        }
        return "login";
    }
}
