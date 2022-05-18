package com.seohyuni.returneverytimeserver.service;

import com.seohyuni.returneverytimeserver.dto.board.BoardRequest;
import com.seohyuni.returneverytimeserver.dto.board.BoardResponse;
import com.seohyuni.returneverytimeserver.model.board.Board;
import com.seohyuni.returneverytimeserver.model.user.User;
import com.seohyuni.returneverytimeserver.repository.BoardRepository;
import com.seohyuni.returneverytimeserver.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {

  private final BoardRepository repository;

  private final UserRepository userRepository;

  @Transactional(readOnly = true)
  public BoardResponse.Get get(Long boardId) {
    return BoardResponse.Get.toResponse(repository.getById(boardId));
  }

  @Transactional(readOnly = true)
  public List<BoardResponse.GetList> getAll() {
    return repository.findAll().stream().map(BoardResponse.GetList::toResponse)
        .collect(Collectors.toList());
  }

  @Transactional
  public BoardResponse.Save save(BoardRequest.Save request) {
    User user = userRepository.getById(request.getUserId());
    Board board = request.toEntity(user);
    return BoardResponse.Save.toResponse(repository.save(board));
  }


}
