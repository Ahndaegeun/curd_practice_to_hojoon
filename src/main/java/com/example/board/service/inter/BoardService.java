package com.example.board.service.inter;

import com.example.board.dto.BoardDto;

import java.util.List;

public interface BoardService {

    List<BoardDto> getAllArticle();
    void save(BoardDto board);
    BoardDto findById(Long id);
    void delete(Long id);
    void modify(BoardDto board);
}
