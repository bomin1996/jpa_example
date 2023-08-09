package com.jpa.jpaexample.controller;

import com.jpa.jpaexample.domain.UserEntity;
import com.jpa.jpaexample.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PersistenceContext
    private  EntityManager entityManager;

    @GetMapping("searchUser")
    public List<UserEntity> searchUser(){
        return userService.searchUser();
    }

}
