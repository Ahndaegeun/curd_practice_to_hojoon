package com.example.board.dto;

import com.example.board.entity.Member;
import lombok.*;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDto {

    private Long id;
    private String title;
    private String content;
    private LocalDateTime date;
    private MemberDto member;
}
