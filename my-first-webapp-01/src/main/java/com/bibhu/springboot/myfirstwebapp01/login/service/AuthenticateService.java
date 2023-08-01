package com.bibhu.springboot.myfirstwebapp01.login.service;

import org.springframework.stereotype.Service;

@Service
public class AuthenticateService {

    public boolean validateUserCredential(String name, String password) {
        return name.equalsIgnoreCase(password);
    }
}
