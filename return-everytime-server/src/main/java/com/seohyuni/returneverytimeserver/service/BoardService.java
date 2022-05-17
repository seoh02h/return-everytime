package com.seohyuni.returneverytimeserver.service;

import com.seohyuni.returneverytimeserver.model.board.Board;
import com.seohyuni.returneverytimeserver.repository.BoardRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {

  private final BoardRepository repository;

  @Transactional(readOnly = true)
  public List<Board> getAll() {
    return repository.findAll();
  }

  @Transactional
  public Board save(Board board) {
    return repository.save(board);
  }

}
