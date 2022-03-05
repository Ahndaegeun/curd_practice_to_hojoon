package com.example.board.controller;

import com.example.board.dto.BoardDto;
import com.example.board.service.inter.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final BoardService boardService;

    @GetMapping("/")
    public String home(Model model) {
        List<BoardDto> allArticle = boardService.getAllArticle();
        model.addAttribute("articleList", allArticle);
        return "index";
    }
}
