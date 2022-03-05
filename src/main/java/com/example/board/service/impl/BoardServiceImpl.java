package com.example.board.service.impl;

import com.example.board.dto.BoardDto;
import com.example.board.entity.Board;
import com.example.board.entity.Member;
import com.example.board.respository.BoardRepository;
import com.example.board.service.inter.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public List<BoardDto> getAllArticle() {
        List<Board> all = boardRepository.findAll();
        List<BoardDto> result = new ArrayList<>();
        all.forEach(board -> result.add(board.entityToDto()));
        return result;
    }

    @Override
    public void save(BoardDto board) {
        Board entity = Board.builder()
                .content(board.getContent())
                .date(LocalDateTime.now())
                .title(board.getTitle())
                .member(new Member(1L, "kade", "10"))
                .build();
        boardRepository.save(entity);
    }

    @Override
    public BoardDto findById(Long id) {
        Board board = boardRepository.findById(id).get();
        return board.entityToDto();
    }

    @Override
    public void delete(Long id) {
        boardRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void modify(BoardDto board) {
        Board entity = boardRepository.findById(board.getId()).get();
        entity.setTitle(board.getTitle());
        entity.setContent(board.getContent());
        entity.setDate(LocalDateTime.now());
    }
}
