package com.jpa.jpaexample.repository;

import com.jpa.jpaexample.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, String> {
    @Query(value = "select User_name, User_id from User where User_name = : User_name", nativeQuery=true)
    List<UserEntity> searchParamRepo(@Param("User_name") String User_name);
}
