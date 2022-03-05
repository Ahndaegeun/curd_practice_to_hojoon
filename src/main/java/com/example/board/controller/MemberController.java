package com.example.board.controller;

import com.example.board.dto.MemberDto;
import com.example.board.service.inter.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member")
    public String signView() {
        return "sign";
    }

    @PostMapping("/member")
    public String sign(MemberDto memberDto, Model model) {
        MemberDto signedMember = memberService.sign(memberDto);
        model.addAttribute("member", signedMember);
        return "welcomMember";
    }

    @GetMapping("/login")
    public String loginView() {
        return "login";
    }

    @PostMapping("/login")
    public String login(MemberDto member, HttpServletRequest request) {
        MemberDto loginMember = memberService.login(member);
        if(loginMember != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", loginMember);
        }
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return "redirect:/";
    }
}
