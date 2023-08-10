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

    //user테이블 전체 조회
    @GetMapping("searchUser")
    public List<UserEntity> searchUser(){
        return userService.searchUser();
    }

    //name을 이용한 검색기능
    @GetMapping("searchParam")
    public List<UserEntity> searchParam(@RequestParam(value = "user_name")String user_name) {
        return userService.searchParam(user_name);
    }

    //Repositoty에 작성한 쿼리를 이용한 조회
    @GetMapping("searchParamRepo")
    public List<UserEntity> searchParamRepo(@RequestParam(value =  "user_id")String user_id){
        return userService.searchParamRepo(user_id);
    }

    @GetMapping("insert")
    public String insertMember(@RequestParam(value = "user_id") String user_id,
                               @RequestParam(value = "user_name") String user_name,
                               @RequestParam(value = "user_pw") String user_pw,
                               @RequestParam(value = "user_authority") int user_authority){
        return userService.insertMember(user_id,user_name,user_pw,user_authority);
    }

    @GetMapping("update")
    public String updateMember(@RequestParam(value = "user_id") String user_id,
                               @RequestParam(value = "user_name") String user_name,
                               @RequestParam(value = "user_pw") String user_pw,
                               @RequestParam(value = "user_authority") int user_authority){
        return userService.updateMember(user_id,user_name,user_pw,user_authority);
    }

    @GetMapping("delete")
    public String deleteMember(@RequestParam(value = "user_id")String user_id){
        return userService.deleteMember(user_id);
    }
}
