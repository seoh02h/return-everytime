package com.seohyuni.returneverytimeserver.repository;

import com.seohyuni.returneverytimeserver.model.post.PostImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostImageRepository extends JpaRepository<PostImage, Long> {

  void deleteByPostId(Long postId);
}
