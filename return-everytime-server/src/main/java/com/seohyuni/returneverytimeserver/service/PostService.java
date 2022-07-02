package com.seohyuni.returneverytimeserver.service;

import com.seohyuni.returneverytimeserver.dto.post.PostRequest;
import com.seohyuni.returneverytimeserver.dto.post.PostResponse;
import com.seohyuni.returneverytimeserver.model.common.Image;
import com.seohyuni.returneverytimeserver.model.notice.Notice;
import com.seohyuni.returneverytimeserver.model.notice.NoticeImage;
import com.seohyuni.returneverytimeserver.model.post.Post;
import com.seohyuni.returneverytimeserver.model.post.PostImage;
import com.seohyuni.returneverytimeserver.model.user.User;
import com.seohyuni.returneverytimeserver.repository.ImageRepository;
import com.seohyuni.returneverytimeserver.repository.PostImageRepository;
import com.seohyuni.returneverytimeserver.repository.PostRepository;
import com.seohyuni.returneverytimeserver.repository.UserRepository;
import com.seohyuni.returneverytimeserver.utils.ImageUtils;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


@Service
@Transactional
@RequiredArgsConstructor
public class PostService {

  private final PostRepository repository;
  private final PostImageRepository postImageRepository;
  private final ImageRepository imageRepository;

  private final UserRepository userRepository;

  @Transactional(readOnly = true)
  public List<Post> getList(String title) {
    if (StringUtils.hasText(title)) {
      return repository.findByTitleContainsOrderByCreatedDateDesc(title);
    }
    return repository.findAll(Sort.by(Direction.DESC, "createdDate"));
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

  public Post saveImage(Long postId, List<MultipartFile> imageList) throws Exception {
    Post post = repository.getById(postId);

    postImageRepository.deleteByPostId(postId);
    for (MultipartFile multipartFile : imageList) {

      Image image = imageRepository.save(ImageUtils.getImage(multipartFile));

      PostImage postImage = PostImage.builder()
          .post(post)
          .image(image)
          .build();

      postImageRepository.save(postImage);
    }

    return post;
  }
}
