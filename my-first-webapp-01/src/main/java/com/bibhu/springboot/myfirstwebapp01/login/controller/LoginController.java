package com.bibhu.springboot.myfirstwebapp01.login.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/login")
    public String loginPage(@RequestParam String name, ModelMap modelMap){
        modelMap.put("name", name);
        LOGGER.debug("test logging functionality");
        return "login";
    }
}
