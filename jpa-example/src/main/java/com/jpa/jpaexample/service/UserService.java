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
    public List<UserEntity> searchParam(String user_name){
        return  entityManager.createQuery("select  m from  User  m where user_name = :user_name", UserEntity.class)
                .setParameter("user_name",user_name)
                .getResultList();
    }
    public List<UserEntity> searchParamRepo(String user_id){
        return userEntityRepository.searchParamRepo(user_id);
    }
    public String insertMember(String user_id,String user_name,String user_pw,int user_authority){
        if (userEntityRepository.findById(user_id).isPresent()){
            return "중복된 아이디 입니다.";
        }else {
            userEntityRepository.save(UserEntity.builder().user_id(user_id).user_name(user_name).user_pw(user_pw).user_authority(user_authority).build());
            return "아이디 : " +user_id+" 이름 : "+user_name+" 비밀번호 : "+user_pw+" 권한 레벨 : "+user_authority+" 으로 생성되었습니다.";
        }
    }

    public String updateMember(String user_id,String user_name,String user_pw,int user_authority){
        if (userEntityRepository.findById(user_id).isEmpty()){
            return "입력한 "+user_id+"가 존재하지 않습니다.";
        }else {
            userEntityRepository.save(UserEntity.builder().user_id(user_id).user_name(user_name).user_pw(user_pw).user_authority(user_authority).build());
            return user_id+"의 정보를\n이름 : "+user_name+" 비밀번호 : "+user_pw+" 권한 레벨 : "+user_authority+" 으로 변경되었습니다.";
        }
    }

    public String deleteMember(String user_id){
        if (userEntityRepository.findById(user_id).isEmpty()){
            return "입력한 "+user_id+"가 존재하지 않습니다.";
        }else {
            userEntityRepository.delete(UserEntity.builder().user_id(user_id).build());
            return user_id+" 의 모든 정보를 삭제하였습니다.";
        }
    }

}
