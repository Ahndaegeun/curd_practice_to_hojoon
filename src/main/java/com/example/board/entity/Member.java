package com.example.board.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {

    @Id @GeneratedValue
    private Long id;
    private String username;
    private String password;
}
