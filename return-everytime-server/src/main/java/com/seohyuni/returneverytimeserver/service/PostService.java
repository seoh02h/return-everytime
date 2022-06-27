package com.seohyuni.returneverytimeserver.service;

import com.seohyuni.returneverytimeserver.dto.post.PostRequest;
import com.seohyuni.returneverytimeserver.dto.post.PostResponse;
import com.seohyuni.returneverytimeserver.model.post.Post;
import com.seohyuni.returneverytimeserver.model.user.User;
import com.seohyuni.returneverytimeserver.repository.PostRepository;
import com.seohyuni.returneverytimeserver.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;


@Service
@Transactional
@RequiredArgsConstructor
public class PostService {

  private final PostRepository repository;

  private final UserRepository userRepository;

  @Transactional(readOnly = true)
  public List<PostResponse.GetList> getList(String title) {
    if (StringUtils.hasText(title)) {
      return repository.findByTitleContains(title).stream().map(PostResponse.GetList::of)
          .collect(Collectors.toList());

    }
    return repository.findAll().stream().map(PostResponse.GetList::of)
        .collect(Collectors.toList());
  }

  @Transactional(readOnly = true)
  public PostResponse.Get get(Long postId) {
    return PostResponse.Get.of(repository.getById(postId));
  }

  public PostResponse.Get save(PostRequest.Save request) {
    User user = userRepository.getById(request.getUserId());
    Post post = request.toEntity(user);

    return PostResponse.Get.of(repository.save(post));
  }

  public PostResponse.Get update(Long postId, PostRequest.Update request) {
    Post post = repository.getById(postId);

    // update
    post.setTitle(request.getTitle());
    post.setContent(request.getContent());

    return PostResponse.Get.of(post);
  }

  public void delete(Long postId) {
    repository.deleteById(postId);
  }

}
