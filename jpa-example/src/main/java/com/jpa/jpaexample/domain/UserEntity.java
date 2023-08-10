package com.jpa.jpaexample.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "User")
@Table(name = "User")
public class UserEntity {
    @Id
    @Column(nullable = false, unique = true)
    private String user_id;

    @Column(nullable = false)
    private String user_name;

    @Column(nullable = false)
    private String user_pw;

    @Column(nullable = true)
    private int user_authority;
}
