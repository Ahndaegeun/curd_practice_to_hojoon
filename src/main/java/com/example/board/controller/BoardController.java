package com.example.board.controller;

import com.example.board.dto.BoardDto;
import com.example.board.service.inter.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board")
    public String writeView() {
        return "write";
    }

    @PostMapping("/board")
    public String write(BoardDto boardDto) {
        boardService.save(boardDto);
        return "redirect:/";
    }

    @GetMapping("/detail")
    public String detailView(Model model, Long id) {
        model.addAttribute("article", boardService.findById(id));
        return "detail";
    }

    @GetMapping("/delete")
    public String del(Long id) {
        boardService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/modify")
    public String modView(Long id, Model model) {
        model.addAttribute("board", boardService.findById(id));
        return "modifyView";
    }

    @PostMapping("/modify")
    public String modify(BoardDto board) {
        System.out.println(board.getId());
        boardService.modify(board);
        return "redirect:/detail?id=" + board.getId();
    }
}
