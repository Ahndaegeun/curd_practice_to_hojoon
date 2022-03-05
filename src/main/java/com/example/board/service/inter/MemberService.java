package com.example.board.service.inter;

import com.example.board.dto.MemberDto;

public interface MemberService {

    MemberDto sign(MemberDto member);
    MemberDto login(MemberDto member);
}
