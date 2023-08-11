package com.bibhu.springboot.restfulwebservice01.user.service;

import com.bibhu.springboot.restfulwebservice01.user.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final static List<User> userList = new ArrayList<>();
    private static int size = 0;

    static {
        userList.add(new User(1L, "Adam", LocalDate.now().minusYears(30)));
        userList.add(new User(2L, "Ben", LocalDate.now().minusYears(25)));
        userList.add(new User(3L, "Cardy", LocalDate.now().minusYears(20)));
        size = userList.size();
    }

    public List<User> findAll(){
        return userList;
    }

    public User findByUserId(Long id) {
        return userList.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }

    public User createUser(User user) {
        user.setId((long) ++size);
        userList.add(user);
        return user;
    }
}
