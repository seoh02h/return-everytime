package com.seohyuni.returneverytimeserver.service;

import com.seohyuni.returneverytimeserver.dto.post.CommentRequest;
import com.seohyuni.returneverytimeserver.dto.post.CommentResponse;
import com.seohyuni.returneverytimeserver.dto.post.CommentResponse.GetList;
import com.seohyuni.returneverytimeserver.model.post.Comment;
import com.seohyuni.returneverytimeserver.model.post.Post;
import com.seohyuni.returneverytimeserver.model.user.User;
import com.seohyuni.returneverytimeserver.repository.CommentRepository;
import com.seohyuni.returneverytimeserver.repository.PostRepository;
import com.seohyuni.returneverytimeserver.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

  private final CommentRepository repository;

  private final PostRepository postRepository;

  private final UserRepository userRepository;

  @Transactional(readOnly = true)
  public List<GetList> getList(Long postId) {
    return null;
  }

  @Transactional
  public CommentResponse.Get save(CommentRequest.Save request) {

    User user = userRepository.findById(request.getUserId()).get();
    Post post = postRepository.findById(request.getPostId()).get();

    Comment comment = repository.save(request.toEntity(post, user));

    return CommentResponse.Get.toResponse(comment);
  }
}
