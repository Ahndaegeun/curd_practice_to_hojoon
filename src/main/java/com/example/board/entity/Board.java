package com.example.board.entity;

import com.example.board.dto.BoardDto;
import com.example.board.dto.MemberDto;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {

    @Id @GeneratedValue
    private Long id;
    private String title;
    private String content;
    private LocalDateTime date;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @ManyToOne
    @JoinColumn(name = "member")
    private Member member;

    public BoardDto entityToDto() {
        MemberDto memberDto = MemberDto.builder()
                .id(member.getId())
                .username(member.getUsername())
                .password(member.getPassword())
                .build();

        return BoardDto.builder()
                .title(title)
                .content(content)
                .date(date)
                .id(id)
                .member(memberDto)
                .build();
    }
}
