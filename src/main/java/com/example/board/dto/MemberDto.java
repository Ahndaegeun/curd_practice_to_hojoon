package com.example.board.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDto {

    private Long id;
    private String username;
    private String password;
}
