package com.seohyuni.returneverytimeserver.service;

import com.seohyuni.returneverytimeserver.dto.board.PostRequest;
import com.seohyuni.returneverytimeserver.dto.board.PostResponse;
import com.seohyuni.returneverytimeserver.model.board.Post;
import com.seohyuni.returneverytimeserver.model.user.User;
import com.seohyuni.returneverytimeserver.repository.PostRepository;
import com.seohyuni.returneverytimeserver.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class PostService {

  private final PostRepository repository;

  private final UserRepository userRepository;

  @Transactional(readOnly = true)
  public List<PostResponse.GetList> getAll(Long boardId, String title) {
    if(title == null){
      return repository.findByBoardId(boardId).stream().map(PostResponse.GetList::toResponse).collect(
          Collectors.toList());
    }else{
      return repository.findByBoardIdAndTitleContaining(boardId, title).stream().map(PostResponse.GetList::toResponse).collect(
          Collectors.toList());
    }

  }

  @Transactional
  public PostResponse.Save save(PostRequest.Save request) {
    User user = userRepository.getById(request.getUserId());
    Post post = request.toEntity(user);

    return PostResponse.Save.toResponse(repository.save(post));
  }
}
