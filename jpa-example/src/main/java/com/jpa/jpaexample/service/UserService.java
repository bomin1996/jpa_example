package com.jpa.jpaexample.service;
import com.jpa.jpaexample.domain.CrudEntity;
import com.jpa.jpaexample.domain.UserEntity;
import com.jpa.jpaexample.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserEntityRepository userEntityRepository;

    @PersistenceContext
    private  EntityManager entityManager;

    private UserEntity userEntity;

    public  List<UserEntity> searchUser(){
        return userEntityRepository.findAll();
    }

}
