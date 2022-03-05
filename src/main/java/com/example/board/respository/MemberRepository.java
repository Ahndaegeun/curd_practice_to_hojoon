package com.example.board.respository;

import com.example.board.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByUsernameAndPassword(String username, String password);

}
