package com.example.board.service.impl;

import com.example.board.dto.MemberDto;
import com.example.board.entity.Member;
import com.example.board.respository.MemberRepository;
import com.example.board.service.inter.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public MemberDto sign(MemberDto member) {
        Member entity = new Member(null, member.getUsername(), member.getPassword());
        memberRepository.save(entity);
        member.setId(entity.getId());
        return member;
    }

    @Override
    public MemberDto login(MemberDto member) {
        Member findMember = memberRepository.findByUsernameAndPassword(member.getUsername(), member.getPassword());

        if(findMember != null) {
            member.setId(findMember.getId());
            return member;
        }
        return null;
    }
}
