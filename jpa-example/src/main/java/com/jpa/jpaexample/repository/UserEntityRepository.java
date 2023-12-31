package com.jpa.jpaexample.repository;

import com.jpa.jpaexample.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, String> {
    @Query(value = "SELECT * FROM User WHERE user_id = :user_id", nativeQuery = true)
    List<UserEntity> searchParamRepo(@Param("user_id") String user_id);
}

